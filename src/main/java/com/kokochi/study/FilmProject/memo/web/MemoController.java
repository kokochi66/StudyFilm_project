package com.kokochi.study.FilmProject.memo.web;

import com.kokochi.study.FilmProject.memo.domain.MemoBoardMasterVO;
import com.kokochi.study.FilmProject.memo.service.MemoBoardMasterService;
import com.kokochi.study.FilmProject.memo.service.MemoBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/memo")
@Log4j2
@RequiredArgsConstructor
public class MemoController {

    private final MemoBoardService memoBoardService;
    private final MemoBoardMasterService memoBoardMasterService;

    // :: / :: 메모 메인 페이지
    @RequestMapping(value="", method = RequestMethod.GET)
    public String memoHome(Model model) {
        log.info("TEST :: 메모 홈페이지 접근");
        return "memo/memo_home";
    }

    // :: /add :: 메모 추가 페이지
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String memoAddPage(Model model) {
        log.info("TEST :: 메모 홈페이지 접근");
        return "memo/memo_add";
    }

    // :: /edit :: 메모 수정 페이지
    @RequestMapping(value="/edit", method = RequestMethod.GET)
    public String memoEditPage(Model model) {
        log.info("TEST :: 메모 홈페이지 접근");
        return "memo/memo_edit";
    }

    // :: /list :: 메모 리스트 페이지
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public String memoListPage(Model model,
                               @RequestParam(name = "id") String id) {
        log.info("/memo/list :: 메모 리스트 가져오기 :: " + id);

        model.addAttribute("masterId", id);
        return "memo/memo_list";
    }

    // :: /list :: 메모 상세보기 페이지
    @RequestMapping(value="/view", method = RequestMethod.GET)
    public String memoViewPage(Model model) {
        log.info("/memo/view 메모 홈페이지 접근");
        return "memo/memo_view";
    }

    // :: /master/add :: 게시판 추가 페이지
    @RequestMapping(value="/master/add", method = RequestMethod.GET)
    public String memoMasterAddPage(Model model) {
        log.info("/memo/master/add :: 게시판 추가 페이지");
        return "memo/master/memo_master_add";
    }

    // :: /master/add POST :: 게시판 추가 처리
    @RequestMapping(value = "/master/add/process", method = RequestMethod.POST)
    public String memoMasterAddProcess(@ModelAttribute MemoBoardMasterVO memoBoardMasterVO,
                                       Model model) {
        log.info("/memo/master/add/process :: 게시판 추가 처리");
        memoBoardMasterService.addMemoBoardMaster(memoBoardMasterVO);

        return "redirect:/memo/list?id="+memoBoardMasterVO.getId();
    }

}
