package com.jarvis.focus.controller;

import com.jarvis.focus.utils.Config;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by Jarvis on 2016/5/21.
 */
public class BaseController {

    @ModelAttribute("t")
    public String getCurrentVersion() {
        return Config.getProperty("CURRENT_VERSION");
    }
}
