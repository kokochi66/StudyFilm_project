package com.kokochi.study.FilmProject.web;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Log4j2
public class homeController {


    @RequestMapping(value="/", method = RequestMethod.GET)
    public String home() {
        log.info("TEST :: 홈 컨트롤러 매핑");
        return "home";
    }

}
