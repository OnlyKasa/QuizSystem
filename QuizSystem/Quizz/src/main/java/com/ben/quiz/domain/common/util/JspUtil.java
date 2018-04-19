package com.ben.quiz.domain.common.util;

import com.ben.quiz.domain.common.constant.CommonConst;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Utility class used in jsp file
 *
 */
public class JspUtil {
 
   /**
    * Constructor
    */
   public JspUtil() {
   }
 
   private static String printerDevice = null;
   static {
   }

   public static String redirect(String requestMapping, HttpServletRequest request) {
       // Store request parameter csrf in session
       HttpSession session = request.getSession();
       session.setAttribute(CommonConst.QUIZ_CSRF_PARAMETER_FNAME,
               request.getParameter(CommonConst.QUIZ_CSRF_PARAMETER_FNAME));
 
       return "redirect:" + requestMapping;
   }
 

   /**
    * Convert Java object to Json style string
    *
    * @param obj
    * @return
    */
   public static String toJson(Object obj) throws IOException {
       ObjectMapper mapper = new ObjectMapper();
       String json;
       json = mapper.writeValueAsString(obj);
       return json;
   }

}