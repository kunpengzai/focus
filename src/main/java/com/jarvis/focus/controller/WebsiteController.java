package com.jarvis.focus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jia Qianpeng
 * 2016-04-24
 */

@Controller
@RequestMapping("/ws/")
public class WebsiteController extends BaseController {

    @RequestMapping ("index")
    public String index(HttpServletRequest request, Model model) {
        return "/website/index";
    }

    @RequestMapping ("focus")
    public String focus(HttpServletRequest request, Model model) {
        return "/website/focus";
    }
}
