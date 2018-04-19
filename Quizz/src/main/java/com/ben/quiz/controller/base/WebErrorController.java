package com.ben.quiz.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by QuangNV
 * on 10/2/2017.
 */
@Controller
@RequestMapping("/quiz_error")
public class WebErrorController extends BaseControllerWeb {

    @RequestMapping
    public String defaultErrorPage() {
        return "default_error";
    }
}