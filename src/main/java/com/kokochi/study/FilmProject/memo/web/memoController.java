package com.kokochi.study.FilmProject.memo.web;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/memo")
@Log4j2
public class memoController {

    @RequestMapping(value="", method = RequestMethod.GET)
    public String memoHome(Model model) {
        log.info("TEST :: 메모 홈페이지 접근");
        return "memo/home";
    }

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String memoAddPage(Model model) {
        log.info("TEST :: 메모 홈페이지 접근");
        return "memo/add";
    }

    @RequestMapping(value="/edit", method = RequestMethod.GET)
    public String memoEditPage(Model model) {
        log.info("TEST :: 메모 홈페이지 접근");
        return "memo/edit";
    }

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public String memoListPage(Model model) {
        log.info("TEST :: 메모 홈페이지 접근");
        return "memo/list";
    }

    @RequestMapping(value="/view", method = RequestMethod.GET)
    public String memoViewPage(Model model) {
        log.info("TEST :: 메모 홈페이지 접근");
        return "memo/view";
    }

}
