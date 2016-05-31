package com.jarvis.focus.controller;

import com.jarvis.focus.dto.MemberDTO;
import com.jarvis.focus.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Jarvis on 2016/5/21.
 */
@Controller
@RequestMapping("/m/")
public class MemberController {

    @Resource
    private MemberService memberService;

    @RequestMapping ("apply")
    public String applyFocus(HttpServletRequest request, String code, Model model) {
        memberService.applyFocus(code, model);
        return "/member/apply-focus";
    }

    @RequestMapping ("apply-data")
    public String applyFocusData(HttpServletRequest request, MemberDTO memberDTO,
                     @RequestParam MultipartFile imageFile) throws Exception {
        memberService.applyFocusData(memberDTO, imageFile);
        return "redirect:/m/apply-success.htm";
    }

    @RequestMapping ("apply-success")
    public String applySuccess(HttpServletRequest request) throws Exception {
        return "/member/apply-success";
    }

    @ResponseBody
    @RequestMapping(value="compress-img", produces="application/json;charset=UTF-8")
    public Map<String, Object> compressImg() {
        Map<String, Object> m = memberService.compressImg();
        return m;
    }
}
