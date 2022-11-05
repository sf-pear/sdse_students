package org.nypl.journalsystem;
import java.util.*;

class Journal {
    String name;
    String issn;
    Publisher publisher;
    int journalCount; 
    // should this be here? 
    Map<Integer, Article> articles = new HashMap<>();

    public Journal(String name, String issn, Publisher publisher) {
        this.name = name;
        this.issn = issn;
        this.publisher = publisher;
        this.journalCount = 0;
        // this.articles = new HashMap<>();
        // this.articles = articles;
    }

    // override toString so it doesn't print the hash of the object, but it's
    // contents
    // @Override
    public String toString() {
        return "Journal name: " + name + ", ISSN: " + issn + ", Publisher: " + publisher;
    }
}

class Author {
    String id;
    String name;

    public Author(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author ID:" + id + ", Author name:" + name;
    }
    
}

class Article {
    int id;
    String title;
    Map<Integer, Author> authors; // int not allowed - why cant have authors object stored here?
    String journalIssn; // how do i link these without storing the information twice?

    public Article(int id, String title, Map<Integer, Author> authors, String journalIssn) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.journalIssn = journalIssn;
    }

    public void addArticleToJournal() {
        
    }
    
}

class Publisher {
    String publisherName;
    String publisherLocation;

    public Publisher(String publisherName, String publisherLocation) {
        this.publisherName = publisherName;
        this.publisherLocation = publisherLocation;
    }

    @Override
    public String toString() {
        return publisherName + ", " + publisherLocation;
    }
}