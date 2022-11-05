package org.nypl.journalsystem;
import java.util.*;

class Journal {
    String name;
    String issn;
    Publisher publisher;
    // should this be here? 
    int journalCount = 0; 
    ArrayList<Article> articles = new ArrayList<>();

    public Journal(String name, String issn, Publisher publisher) {
        this.name = name;
        this.issn = issn;
        this.publisher = publisher;
    }

    public void addArticleToJournal(Article article) {
        articles.add(article);
        journalCount +=1;
    }

    private String fullIssue() {
        if (journalCount > 2) {
            return "Yes"; 
        } else {
            return "No";
        }
    }

    // override toString so it doesn't print the hash of the object, but it's
    // contents
    // @Override
    public String toString() {
        return "Journal name: " + name + "\nISSN: " + issn + "\nPublisher: " + publisher + "\nFull issue: " + fullIssue() + "\nArticles: " + articles + "\n";
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
        return name;
    }
    
}

class Article {
    String id;
    String title;
    ArrayList<Author> authors;
    String journalIssn; // how do i link these without storing the information twice?

    public Article(String id, String title, ArrayList<Author> authors, String journalIssn) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.journalIssn = journalIssn;
    }

    @Override
    public String toString() {
        return "\nTitle:" + title + ", Authors:" + authors;
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