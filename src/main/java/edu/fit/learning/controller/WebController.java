package edu.fit.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by virus on 03/14/16.
 */

@Controller
public class WebController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }
}
