package com.jarvis.focus.service;

import com.jarvis.focus.dto.MemberDTO;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by Jarvis on 2016/5/21.
 */
public interface MemberService {

    public void applyFocus(String code, Model model);

    public void applyFocusData(MemberDTO memberDTO, MultipartFile imageFile) throws Exception;

    public Map<Integer, Object> getAreaCityFull();

    public Map<String, Object> compressImg();
}
