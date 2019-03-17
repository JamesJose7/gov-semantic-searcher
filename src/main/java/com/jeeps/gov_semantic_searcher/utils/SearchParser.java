package com.jeeps.gov_semantic_searcher.utils;

public class SearchParser {

    public static int parseSearch(String q) {
        if (q.contains("cuantos") || q.contains("cuenta"))
            return 1;
        if (q.contains("pertenece a"))
            return 2;
        return 0;
    }

    public static String extractGroup(String q) {
        return q.split("pertenece a ")[1].trim();
    }
}
