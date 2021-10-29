package com.kokochi.study.FilmProject.memo.web;

import com.kokochi.study.FilmProject.memo.domain.MemoBoard;
import com.kokochi.study.FilmProject.memo.repo.MemoBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value="/memo")
@Log4j2
@RequiredArgsConstructor
public class MemoController {

    private final MemoBoardRepository memoBoardRepository;

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
        log.info("TEST :: /memo/list :: 메모 리스트 가져오기");
        List<MemoBoard> boardList = memoBoardRepository.findAll();
        for (MemoBoard memoBoard : boardList) {
            log.info("TEST :: 리스트 가져옴 :: " + memoBoard.getId() +" " + memoBoard.getTitle()+" " + memoBoard.getWriter());
        }

        model.addAttribute("boardList", boardList);
        return "memo/list";
    }

    @RequestMapping(value="/view", method = RequestMethod.GET)
    public String memoViewPage(Model model) {
        log.info("TEST :: 메모 홈페이지 접근");
        return "memo/view";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String memoTest(Model model) {
        log.info("TEST ::  메모 테스트 페이지 접근");
        return "memo/test";
    }

}
