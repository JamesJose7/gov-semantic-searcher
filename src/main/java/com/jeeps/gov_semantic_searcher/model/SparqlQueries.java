package com.jeeps.gov_semantic_searcher.model;

import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.SKOS;

public class SparqlQueries {

    public static String getCatalogWithTag(String tag) {
        return String.format("PREFIX gvld:<http://www.government-linked-data.org/>\n" +
                "PREFIX dct:<http://purl.org/dc/terms/>\n" +
                "PREFIX data:<http://example.org/data/>\n" +
                "PREFIX skos:<http://www.w3.org/2004/02/skos/core#>\n" +
                "\n" +
                "SELECT ?catalog ?title ?tagLabel\n" +
                "WHERE{\n" +
                "  ?catalog a gvld:Catalog; gvld:tag ?tag; dct:title ?title .\n" +
                "  optional {?tag skos:prefLabel ?tagLabel}\n" +
                "  FILTER regex(str(?tag), \"%s\") .\n" +
                "}", tag);
    }

    public static String getGroups() {
        return "PREFIX gvld:<http://www.government-linked-data.org/>\n" +
                "PREFIX dct:<http://purl.org/dc/terms/>\n" +
                "PREFIX data:<http://example.org/data/>" +
                "SELECT ?group ?title\n" +
                "WHERE{\n" +
                "  ?group a gvld:Group; gvld:title ?title .\n" +
                "}";
    }

    public static String getHowManyCatalogsPerGroup() {
        return "PREFIX gvld:<http://www.government-linked-data.org/>\n" +
                "PREFIX dct:<http://purl.org/dc/terms/>\n" +
                "PREFIX data:<http://example.org/data/>\n" +
                "\n" +
                "\n" +
                "SELECT ?group ?title (COUNT(?catalog) as ?count)\n" +
                "WHERE{\n" +
                "  ?catalog a gvld:Catalog; gvld:group ?group .\n" +
                "  ?group a gvld:Group; gvld:title ?title .\n" +
                "}\n" +
                "GROUP BY ?group ?title";
    }

    public static String getCatalogsWithGroup(String group) {
        return String.format("PREFIX gvld:<http://www.government-linked-data.org/>\n" +
                "PREFIX dct:<http://purl.org/dc/terms/>\n" +
                "PREFIX data:<http://example.org/data/>\n" +
                "\n" +
                "SELECT ?catalog ?title ?groupTitle\n" +
                "WHERE{\n" +
                "  ?catalog a gvld:Catalog; gvld:group ?group; dct:title ?title .\n" +
                "  ?group gvld:title ?groupTitle .\n" +
                "  FILTER regex(str(?group), \"%s\") .\n" +
                "}", group);
    }

    public static String getPublishers() {
        return "PREFIX gvld:<http://www.government-linked-data.org/>\n" +
                "PREFIX dct:<http://purl.org/dc/terms/>\n" +
                "PREFIX data:<http://example.org/data/>\n" +
                "PREFIX foaf:<http://xmlns.com/foaf/0.1/>\n" +
                "\n" +
                "SELECT ?publisher ?name (COUNT(?catalog) as ?count)\n" +
                "WHERE{\n" +
                "  ?catalog a gvld:Catalog; dct:publisher ?publisher .\n" +
                "  ?publisher a foaf:Agent; foaf:name ?name.\n" +
                "}\n" +
                "GROUP BY ?publisher ?name";
    }
}
