package com.jeeps.gov_semantic_searcher.web.controller;

import com.jeeps.gov_semantic_searcher.model.SparqlQueries;
import com.jeeps.gov_semantic_searcher.service.SparqlService;
import com.jeeps.gov_semantic_searcher.utils.SearchParser;
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
    public String searchResult(@PathParam("q") String q, @PathParam("filter") String filter, Model model) {
        SparqlService sparqlService = new SparqlService();
        List<List<String>> resultSet = null;

        switch (filter) {
            case "tag_filter":
                resultSet = sparqlService.query(SparqlQueries.getCatalogWithTag(q),
                        "catalog", "title", "tagLabel");
                break;
            case "groups_filter":
                int parse = SearchParser.parseSearch(q);
                if (parse == 2)
                    resultSet = sparqlService.query(SparqlQueries.getCatalogsWithGroup(SearchParser.extractGroup(q)),
                            "catalog", "title", "groupTitle");
                else if (parse == 1)
                    resultSet = sparqlService.query(SparqlQueries.getHowManyCatalogsPerGroup(),
                            "group", "title", "count");
                else
                    resultSet = sparqlService.query(SparqlQueries.getGroups(),
                            "group", "title");
                break;
            case "publishers":
                resultSet = sparqlService.query(SparqlQueries.getPublishers(),
                        "publisher", "name", "count");
        }

        List<List<String>> headers = resultSet.subList(0, 1);
        List<List<String>> result = resultSet.subList(1, resultSet.size());

        model.addAttribute("headers", headers);
        model.addAttribute("result", result);
        return "result";
    }
}
