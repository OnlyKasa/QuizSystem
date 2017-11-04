package com.ben.quiz.service.impl;

import com.ben.quiz.domain.common.constant.CodeConst;
import com.ben.quiz.domain.common.constant.CommonConst;
import com.ben.quiz.domain.common.constant.QuizTrasitionConst;
import com.ben.quiz.domain.common.exception.QuizException;
import com.ben.quiz.domain.common.util.JspUtil;
import com.ben.quiz.domain.model.SUser;
import com.ben.quiz.domain.model.SeiUser;
import com.ben.quiz.service.interfaces.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private SUser sUser;

//    @Override
//    @Transactional
//    public void resetPassword(ForgotPasswordReq forgotPasswordReq) throws QuizException {
//        Seiuser seiuser = userRepository.findEmployeeSeiuserByUserId(forgotPasswordReq.getUserId());
//        empRepository.validateEmployeeEmail(seiuser.getiEmployeePk(), forgotPasswordReq.getEmail());
//
//        String newPassword = PasswordUtil.genRandomPassword();
//        String newSHAPassword = PasswordUtil.genHSHAForPassword(newPassword);
//        seiuser.setPassword(newSHAPassword);
//        userRepository.save(seiuser);
//        emailService.sendResetPasswordNotification(forgotPasswordReq.getEmail(), newPassword);
//    }
//
//    @Override
//    @Transactional
//    public void changePassword(ChangePasswordReq changePasswordReq) throws QuizException {
//        Seiuser seiuser = userRepository.findEmployeeSeiuserByUserId(changePasswordReq.getUserid());
//        String newSHAPassword = PasswordUtil.genHSHAForPassword(changePasswordReq.getNewPassword());
//        seiuser.setPassword(newSHAPassword);
//        userRepository.save(seiuser);
//        MEmployee mEmployeeByVcEmpLogin = empRepository.findMEmployeeByVcEmpLogin(changePasswordReq.getUserid());
//        mEmployeeByVcEmpLogin.setDtTosConfirm(DateUtil.getCurrentDate());
//        empRepository.save(mEmployeeByVcEmpLogin);
//    }
//
//    @Override
//    public Map<String, Object> actLogin(UserFormReq request, BindingResult result) {
//
//        try {
//            // validate user password error
//            if (result.hasErrors()) {
//                return Constant.responseError(CodeConst.ErrorCode.ERR_999, FormError.bindingResult(result));
//            }
//            String strUsername = request.getUserid();
//            String passWord = request.getPassword();
//            int i_company_pk;
//            int i_branch_pk;
//            int i_store_comp_pk;
//            int i_store_branch_pk;
//            Seiuser user = findUserByUserName(strUsername);
//            if (user == null) {
//                return Constant.responseError(CodeConst.ErrorCode.ERR_002, null);
//            }
//            i_company_pk = user.getiCompanyPk();
//            i_branch_pk = user.getiBranchPk();
//            i_store_comp_pk = user.getiStoreCompPk();
//            i_store_branch_pk = user.getiStoreBranchPk();
//            boolean bCheckOver;
//            if (i_company_pk == 0 && i_branch_pk == 0 && i_store_branch_pk == 0 && i_store_comp_pk == 0) {
//                bCheckOver = false;
//            } else if (i_company_pk > 0 && i_branch_pk == 0) {
//                long companyCount = compCusRepository.findCountCompanyByCompanyPkAndLessThanCurrentDate(i_company_pk);
//                bCheckOver = (companyCount > 0);
//            } else if (i_company_pk > 0 && i_branch_pk > 0) {
//                long branchCount = branchRepository.findCountBranchByBranchPkAndLessThanCurrentDate(i_branch_pk);
//                bCheckOver = (branchCount > 0);
//            } else if (i_store_comp_pk > 0 && i_store_branch_pk == 0) {
//                long storeCompCount = storeCompCusRepository.findCountStoreCompByStoreCompPkAndLessThanCurrentDate(i_store_comp_pk);
//                bCheckOver = (storeCompCount > 0);
//            } else if (i_store_comp_pk > 0 && i_store_branch_pk > 0) {
//                long storeBranchCount = storeBranchRepository.findCountStoreBranchByStoreBranchPkAndLessThanCurrentDate(i_store_branch_pk);
//                bCheckOver = (storeBranchCount > 0);
//            } else {
//                bCheckOver = true;
//            }
//            if (bCheckOver)
//                return Constant.responseError(CodeConst.ErrorCode.ERR_003, null);
//            // Convert password string to SHA-256
//            String passWordSHA = PasswordUtil.genHSHAForPassword(passWord);
//            if (passWordSHA.equals(user.getPassword())) {
//                sUser.clear();
//                sUser.setStrUsername(strUsername);
//                sUser.setsPasswordHash(passWordSHA);
//                getUserInfo(sUser);
//                if ((user.getiCompanyPk() > 0 || user.getiBranchPk() > 0) && user.getiEmployeePk() != null) {
//                    MEmployee employee = empRepository.findMEmployeeByIEmployeePk(user.getiEmployeePk());
//                    if (employee != null) {
//                        sUser.setStrFullname((employee.getVcEmpFirstName() + " " + employee.getVcEmpFamilyName()).trim());
//                        HashMap<String, Object> map = new HashMap<>();
//                        if (employee.getDtTosConfirm() != null) {
//                            map.put("DtTosConfirm", employee.getDtTosConfirm().getTime());
//                            sUser.setDtTosConfirm(employee.getDtTosConfirm().getTime());
//                        } else {
//                            map.put("DtTosConfirm", null);
//                            sUser.setDtTosConfirm(null);
//                        }
//                        Logger.getLogger(UserController.class).info(strUsername + " is logged in!");
//                        return Constant.responseMessage(CodeConst.SUCCESS, map);
//                    }
//                }
//                // create code id token
//                return Constant.responseMessage(CodeConst.SUCCESS, true);
//            }
//            // Userid or password is incorrect.
//            return Constant.responseError(CodeConst.ErrorCode.ERR_001, FormError.bindingResult(result));
//        } catch (Exception ex) {
//            Logger.getLogger(UserServiceImpl.class).error(ex);
//            return Constant.responseError(CodeConst.ErrorCode.ERR_999, null);
//        }
//    }

//    @Override
//    public Map<String, Object> getUserInfo(String userID)throws QuizException {
//        try {
//            if (userID.isEmpty()) {
//                throw  new QuizException(CodeConst.ErrorCode.ERR_010, null);
//            }
//            SeiUser seiuser = findUserByUserName(userID);
//            String topMenu = "defaulf";
//            if (seiuser != null) {
//                topMenu = seiuser.getTopMenu();
//                String strUserName = "";
//                // get Name of []
//                if (topMenu.toUpperCase().equals(AuthorityEnum.EMP.getKey())) {
//                    MEmployee emp = empRepository.findMEmployeeByVcEmpLogin(userID);
//                    // get Name of EMP if EMP null return strUserName= userID
//                    strUserName = (emp != null) ? (emp.getVcEmpFamilyName() + " " + emp.getVcEmpFirstName()) : userID;
//                } else if (topMenu.toUpperCase().equals(AuthorityEnum.COMP.getKey())) {
//                    MCompManager compManager = compManagerRepository.findMCompManagerByVcCompManagerLogin(userID);
//                    strUserName = (compManager != null)
//                            ? (compManager.getVcCompManagerFamilyName() + " " + compManager.getVcCompManagerFirstName())
//                            : userID;
//                } else if (topMenu.toUpperCase().equals(AuthorityEnum.BRAN.getKey())) {
//                    MBranchManager branchManager = branManagerRepository.findMBranchManagerByVcBranchManagerLogin(userID);
//                    strUserName = (branchManager != null) ? (branchManager.getVcBranchManagerFamilyName() + " "
//                            + branchManager.getVcBranchManagerFirstName()) : userID;
//                } else if (topMenu.toUpperCase().equals(AuthorityEnum.STOCOMP.getKey())) {
//                    MStoreCompManager storeCompManager = storeCompManagerRepository.findByVcStoreCompManagerLogin(userID);
//                    strUserName = (storeCompManager != null) ? (storeCompManager.getVcStoreCompManagerFamilyName() + " "
//                            + storeCompManager.getVcStoreCompManagerFirstName()) : userID;
//                } else if (topMenu.toUpperCase().equals(AuthorityEnum.STOBRAN.getKey())) {
//                    MStoreBranchManager storeBranchManager = storeBranManageRepository.findByVcStoreBranchManagerLogin(userID);
//                    strUserName = (storeBranchManager != null) ? (storeBranchManager.getVcStoreBranchManagerFamilyName()
//                            + " " + storeBranchManager.getVcStoreBranchManagerFirstName()) : userID;
//                } else if (topMenu.toUpperCase().equals(AuthorityEnum.ADM.getKey())) {
//                    strUserName = "システム管理者(" + userID + ")";
//                } else {
//                    // if user different [EMP,COMP,BRAN,STOCOMP,STOBRAN,ADM] return
//                    // strUserName= userID;
//                    strUserName = userID;
//                }
//                UserInfoDto userInfoForm = new UserInfoDto();
//                userInfoForm.setUsername(strUserName);
//                userInfoForm.setTopmenu(topMenu);
//                return Constant.responseMessage(CodeConst.SUCCESS, userInfoForm);
//            }
//            return Constant.responseError(CodeConst.ErrorCode.ERR_005, null);
//        } catch (Exception ex) {
//            Logger.getLogger(UserServiceImpl.class).error(ex);
//            return Constant.responseError(CodeConst.ErrorCode.ERR_999, null);
//        }
//    }


    @Override
    public String handleHome(Map<String, Object> inModel) throws QuizException{
        try {
            // Get user on session
            if (sUser == null || sUser.getStrUsername() == null || sUser.getStrUsername().equals("")
                    || sUser.getStrUsername().equals("null")) {
                // If not logged in, redirect to login page
                return QuizTrasitionConst.AUTH.LOG_IN;
            }
            // Check login
            //		System.out.println(">>>>>>>>>> Account OK:" + getSUser().getStrUsername() + " >>>>>>>>>>>");
            inModel.put("fullname", sUser.getStrFullName());
            return QuizTrasitionConst.TEMPLATE.HOME;
        } catch (Exception ex) {
            Logger.getLogger(UserServiceImpl.class).error(ex);
            throw new QuizException(1, CommonConst.ERROR_MESSAGER) ;
        }
    }

    @Override
    public ModelAndView handleLoggedIn() {
        try {
            ModelAndView modelAndView = new ModelAndView("archive");
            if (!(sUser == null || sUser.getStrUsername() == null || sUser.getStrUsername().equals(""))) {
                modelAndView.addObject("currentUser", sUser);
            }
            return modelAndView;
        } catch (Exception ex) {
            Logger.getLogger(UserServiceImpl.class).error(ex);
            return null;
        }
    }

    @Override
    public String handleLogout(HttpServletRequest request) {
        try {
            sUser = new SUser();
            return JspUtil.redirect(QuizTrasitionConst.AUTH.LOG_IN, request);
        } catch (Exception ex) {
            Logger.getLogger(UserServiceImpl.class).error(ex);
            return null;
        }
    }

//    @Override
//    public Seiuser findUserByUserNameAndPassword(String userName, String password) throws QuizException {
//        return userRepository.findSeiuserByUseridAndPassword(userName, password);
//    }

//    @Override
//    public SeiUser findUserByUserName(String userName) throws QuizException {
//        return userRepository.findSeiuserByUserid(userName);
//    }
//
//    public void getUserInfo(SUser user) throws QuizException {
//        String userID = user.getStrUsername();
//        Seiuser seiuser = userRepository.findSeiuserByUserid(userID);
//        String topMenu = "defaulf";
//        if (seiuser != null) {
//            topMenu = seiuser.getTopmenu();
//            String strUserName = "";
//            // get Name of [EMP,COMP,BRAN,STOCOMP,STOBRAN,ADM]
//            if (topMenu.toUpperCase().equals(AuthorityEnum.EMP.getKey())) {
//                MEmployee emp = empRepository.findMEmployeeByVcEmpLogin(userID);
//                // get Name of EMP if EMP null return strUserName= userID
//                strUserName = (emp != null) ? (emp.getVcEmpFamilyName() + " " + emp.getVcEmpFirstName()) : userID;
//            } else if (topMenu.toUpperCase().equals(AuthorityEnum.COMP.getKey())) {
//                MCompManager compManager = compManagerRepository.findMCompManagerByVcCompManagerLogin(userID);
//                strUserName = (compManager != null)
//                        ? (compManager.getVcCompManagerFamilyName() + " " + compManager.getVcCompManagerFirstName())
//                        : userID;
//            } else if (topMenu.toUpperCase().equals(AuthorityEnum.BRAN.getKey())) {
//                MBranchManager branchManager = branManagerRepository.findMBranchManagerByVcBranchManagerLogin(userID);
//                strUserName = (branchManager != null) ? (branchManager.getVcBranchManagerFamilyName() + " "
//                        + branchManager.getVcBranchManagerFirstName()) : userID;
//            } else if (topMenu.toUpperCase().equals(AuthorityEnum.STOCOMP.getKey())) {
//                MStoreCompManager storeCompManager = storeCompManagerRepository.findByVcStoreCompManagerLogin(userID);
//                strUserName = (storeCompManager != null) ? (storeCompManager.getVcStoreCompManagerFamilyName() + " "
//                        + storeCompManager.getVcStoreCompManagerFirstName()) : userID;
//            } else if (topMenu.toUpperCase().equals(AuthorityEnum.STOBRAN.getKey())) {
//                MStoreBranchManager storeBranchManager = storeBranManageRepository.findByVcStoreBranchManagerLogin(userID);
//                strUserName = (storeBranchManager != null) ? (storeBranchManager.getVcStoreBranchManagerFamilyName()
//                        + " " + storeBranchManager.getVcStoreBranchManagerFirstName()) : userID;
//            } else if (topMenu.toUpperCase().equals(AuthorityEnum.ADM.getKey())) {
//                strUserName = "システム管理者(" + userID + ")";
//            } else {
//                // if user different [EMP,COMP,BRAN,STOCOMP,STOBRAN,ADM] return
//                // strUserName= userID;
//                strUserName = userID;
//            }
//            user.setStrFullname(strUserName);
//            user.setStrTopMenu(seiuser.getTopmenu());
//        }
//    }
}
