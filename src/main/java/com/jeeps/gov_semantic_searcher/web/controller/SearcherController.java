package com.jeeps.gov_semantic_searcher.web.controller;

import com.jeeps.gov_semantic_searcher.model.SparqlQueries;
import com.jeeps.gov_semantic_searcher.service.SparqlService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:8890")
public class SearcherController {

    @RequestMapping("/")
    public String semanticSearcher(Model model) {
        return "index";
    }

    @RequestMapping("/search")
    public String searchResult(@PathParam("q") String q, Model model) {
        SparqlService sparqlService = new SparqlService();
        List<List<String>> resultSet =  sparqlService.query(SparqlQueries.CATALOG_WITH_TAG,
                "catalog", "title");
        List<List<String>> headers = resultSet.subList(0, 1);
        List<List<String>> result = resultSet.subList(1, resultSet.size());

        model.addAttribute("headers", headers);
        model.addAttribute("result", result);
        return "result";
    }
}
