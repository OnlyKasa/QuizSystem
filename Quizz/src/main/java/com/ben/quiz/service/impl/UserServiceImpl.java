package com.ben.quiz.service.impl;

import com.ben.quiz.domain.common.constant.AuthorityConst;
import com.ben.quiz.domain.common.constant.CodeConst;
import com.ben.quiz.domain.common.constant.CommonConst;
import com.ben.quiz.domain.common.constant.QuizTrasitionConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.common.util.JspUtil;
import com.ben.quiz.domain.common.util.PasswordUtil;
import com.ben.quiz.domain.common.util.PropertiesUtil;
import com.ben.quiz.domain.dto.request.UserLoginReq;
import com.ben.quiz.domain.model.SUser;
import com.ben.quiz.domain.model.Seiuser;
import com.ben.quiz.domain.model.StudentInformation;
import com.ben.quiz.domain.model.TeacherInformation;
import com.ben.quiz.domain.repository.interfaces.StudentInformRepository;
import com.ben.quiz.domain.repository.interfaces.TeacherInformRepository;
import com.ben.quiz.domain.repository.interfaces.UserRepository;
import com.ben.quiz.service.interfaces.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private SUser sUser;
    private final UserRepository userRepository ;
    private final StudentInformRepository studentRepository ;
    private final TeacherInformRepository teacherRepository ;

    @Autowired
    public UserServiceImpl(SUser sUser,
                           UserRepository userRepository,
                           StudentInformRepository studentRepository,
                           TeacherInformRepository teacherRepository) {
        this.sUser = sUser;
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    @Transactional
    public Long actLogin(UserLoginReq request) throws QuizException {
        try {
            String strUsername = request.getUserid();
            String passWord = request.getPassword();
            Seiuser user = findUserByUserName(strUsername);
            if (user == null)
                throw new QuizException(CodeConst.ErrorCode.ERR_004, PropertiesUtil.getMessage("C101.UserPassWrong"));
            // Convert password string to SHA-256
            if (PasswordUtil.genSHAForPassword(passWord).equals(user.getPassword())) {
                sUser.clear();

                sUser.setStrUsername(strUsername);
                sUser.setsPasswordHash(user.getPassword());
                sUser.setStrTopMenu(user.getTopMenu());
                if(user.getiStudentInformationPk() != null ) {
                    sUser.setStrFullName(getStrFullNameByTopMenu(sUser.getStrTopMenu(), user.getiStudentInformationPk(), strUsername));
                }else
                    sUser.setStrFullName(getStrFullNameByTopMenu(sUser.getStrTopMenu(), user.getiTeacherInformationPk(), strUsername));

                sUser.setiStudentInformationPk(user.getiStudentInformationPk());
                sUser.setiTeacherInformationPk(user.getiTeacherInformationPk());
                sUser.setScreenCode((String) Class.forName("com.ben.quiz.domain.common.constant.AuthorityConst$"
                        + user.getTopMenu()).getDeclaredField("SCREEN_CODE").get(null));
                if (user.getiStudentInformationPk() == null && user.getiTeacherInformationPk() == null
                        && user.getTopMenu().equals(AuthorityConst.ADM.CODE)) {
                    sUser.setAsAdministrator(true);
                    return 1L;
                }
                if (user.getiStudentInformationPk() != null && user.getiTeacherInformationPk() == null
                        && user.getTopMenu().equals(AuthorityConst.STU.CODE)) {
                    sUser.setAsStudent(true);
                    return 1L;
                }
                if (user.getiStudentInformationPk() == null && user.getiTeacherInformationPk() != null
                        && user.getTopMenu().equals(AuthorityConst.TEA.CODE)) {
                    sUser.setAsTeacher(true);
                    return 1L;
                }
                return 1L;
            } else {
                throw new QuizException(CodeConst.ErrorCode.ERR_004, PropertiesUtil.getMessage("LOGIN.error.user.notExists"));
            }
        }catch (Exception ex){
            throw new QuizException(CodeConst.ErrorCode.ERR_999, ex.getMessage(), ex);
        }
    }

    @Override
    @Transactional
    public Seiuser findUserByUserName(String userName) throws QuizException {
        return userRepository.findSeiuserByUserid(userName);
    }

    @Override
    public String handleHome(Map<String, Object> inModel) throws QuizException{
        try {
            // Get user on session
            if (sUser == null || sUser.getStrUsername() == null || sUser.getStrUsername().equals("")
                    || sUser.getStrUsername().equals("null")) {
                // If not logged in, redirect to login page
                return QuizTrasitionConst.AUTH.LOG_IN;
            }
            inModel.put("fullname", sUser.getStrFullName());
            inModel.put("screenCode", sUser.getStrTopMenu());
            if(sUser.getStrTopMenu().equals("ADM") || sUser.getStrTopMenu().equals("TEA")){
                return QuizTrasitionConst.TEMPLATE.A101;
            }else if(sUser.getStrTopMenu().equals("STU")) {
                inModel.put("iStudentInformationPk", sUser.getiStudentInformationPk());
                return QuizTrasitionConst.TEMPLATE.S102;
            }

            return QuizTrasitionConst.TEMPLATE.HOME;
        } catch (Exception ex) {
            Logger.getLogger(UserServiceImpl.class).error(ex);
            throw new QuizException(1, CommonConst.ERROR_MESSAGER) ;
        }
    }

    @Override
    public ModelAndView handleLoggedIn() {
        try {
            ModelAndView modelAndView = new ModelAndView(QuizTrasitionConst.AUTH.LOG_IN);
            if (!(sUser == null || sUser.getStrUsername() == null || sUser.getStrUsername().equals(""))) {
                modelAndView.addObject("currentUser", sUser);
            }
            return modelAndView;
        } catch (Exception ex) {
            Logger.getLogger(UserServiceImpl.class).error(ex);
            return new ModelAndView (QuizTrasitionConst.ERROR);
        }
    }

    @Override
    public String handleLogout(HttpServletRequest request) {
        try {
            sUser = new SUser();
            return JspUtil.redirect(QuizTrasitionConst.AUTH.LOG_IN, request);
        } catch (Exception ex) {
            Logger.getLogger(UserServiceImpl.class).error(ex);
            return JspUtil.redirect(QuizTrasitionConst.ERROR,request);
        }
    }

    @Override
    public SUser getUserLogin() throws QuizException {
        return sUser;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        try {
            Seiuser Seiuser = userRepository.findSeiuserByUserid(userName);
            return new org.springframework.security.core.userdetails.User(
                    Seiuser.getUserId(),
                    Seiuser.getPassword(),
                    AuthorityUtils.createAuthorityList(Seiuser.getTopMenu())
            );
        } catch (QuizException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getStrFullNameByTopMenu(String topMenu, Integer id ,String userID) throws QuizException {
        switch (topMenu.toUpperCase()){
            case AuthorityConst.STU.CODE:
               StudentInformation student = studentRepository.findOne(StudentInformation.class,id);
                return (student != null) ? (student.getStrStudentInformationFirstName()
                        + " " + student.getStrStudentInformationLastName()) : userID;
            case AuthorityConst.TEA.CODE:
                TeacherInformation teacher = teacherRepository.findOne(TeacherInformation.class,id);
                return (teacher != null) ? (teacher.getStrTeacherInformationFirstName()
                        + " " + teacher.getStrTeacherInformationLastName()) : userID;
           case AuthorityConst.ADM.CODE:
                return "System management(" + userID + ")";
            default:
                return userID;
        }
    }
}
