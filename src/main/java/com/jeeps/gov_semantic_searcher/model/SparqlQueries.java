package com.jeeps.gov_semantic_searcher.model;

public class SparqlQueries {

    public static final String CATALOG_WITH_TAG = "PREFIX gvld:<http://www.government-linked-data.org/>\n" +
            "PREFIX dct:<http://purl.org/dc/terms/>\n" +
            "PREFIX data:<http://example.org/data/>\n" +
            "\n" +
            "SELECT ?catalog ?title\n" +
            "WHERE{\n" +
            "  ?catalog a gvld:Catalog; gvld:tag ?tag; dct:title ?title .\n" +
            "  FILTER regex(str(?tag), \"economy\") .\n" +
            "}";
}
