package org.nypl.journalsystem;
import java.util.*;

class Journal {
    String name;
    String issn;
    ArrayList<String> articles;
    // int journalCount = 0;

    public Journal(String name, String issn, ArrayList<String> articles) {
        this.name = name;
        this.issn = issn;
        this.articles = articles;
    }

    // override toString so it doesn't print the hash of the object, but it's
    // contents
    // @Override
    // public String toString() {
    //     return "id: " + id + ", year: " + year + ", city: " + city + ", population: " + population;
    // }
    
}

class Article {
    int id;
    String title;
    ArrayList<Integer> authors; // int not allowed - why cant have authors object stored here?
    String journalIssn; // how do i link these without storing the information twice?

    public Article(int id, String title, ArrayList<Integer> authors, String journalIssn) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.journalIssn = journalIssn;
    }
    
}

class Author {
    int id;
    String name;
    
    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }

    
}