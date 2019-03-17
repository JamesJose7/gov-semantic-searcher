package com.jeeps.gov_semantic_searcher.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

@Controller
@CrossOrigin(origins = "http://localhost:8890")
public class SearcherController {

    @RequestMapping("/")
    public String semanticSearcher(Model model) {
        return "index";
    }

    @RequestMapping("/search")
    public String searchResult(@PathParam("q") String q, Model model) {
        System.out.println(q);
        return "result";
    }
}
