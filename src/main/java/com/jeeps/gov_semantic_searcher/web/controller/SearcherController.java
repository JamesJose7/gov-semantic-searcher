package com.jeeps.gov_semantic_searcher.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearcherController {

    @RequestMapping("/")
    public String semanticSearcher(Model model) {
        return "index";
    }
}
