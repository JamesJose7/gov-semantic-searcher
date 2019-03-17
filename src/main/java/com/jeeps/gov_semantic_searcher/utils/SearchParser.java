package com.jeeps.gov_semantic_searcher.utils;

public class SearchParser {

    public static int parseSearch(String q) {
        if (q.contains("cuantos") || q.contains("cuenta"))
            return 1;
        if (q.contains("pertenece a") || q.contains("pertenezcan a"))
            return 2;
        return 0;
    }

    public static String extractGroup(String q) {
        if (q.contains("pertenece a"))
            return q.split("pertenece a ")[1].trim();
        else
            return q.split("pertenezcan a ")[1].trim();
    }
}
