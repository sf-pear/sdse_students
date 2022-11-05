package org.nypl.journalsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class LibrarySystem {

    // create publishers
    Publisher springer = new Publisher("Springer", "Germany");
    Publisher elsevier = new Publisher("Elsevier", "Netherlands");
    Publisher natureResearch = new Publisher("Nature Research", "Great Britain");

    // hashmap holding all journals
    static Map<String, Journal> journalsMap = new HashMap<>();
    static Map<String, Author> authorMap = new HashMap<>();

    // function to add journals
    static void addJournal(String name, String issn, Publisher publisher) {
        Journal journal = new Journal(name, issn, publisher);
        journalsMap.put(journal.issn, journal);

        // just checking
        // System.out.println(journal.issn);
    }

    public LibrarySystem() {
        // DONE: Initialize system with default journals.
        LibrarySystem.addJournal("Higher Education", "0018-1560", springer);
        LibrarySystem.addJournal("System", "0346-2511", elsevier);
        LibrarySystem.addJournal("Chem", "2451-9294", elsevier);
        LibrarySystem.addJournal("Nature", "1476-4687", natureResearch);
        LibrarySystem.addJournal("Society", "0147-2011", springer);

        // just checking
        // journalsMap.forEach((key, value) -> System.out.println(key + ":" + value));
    }
    
    public void load() throws FileNotFoundException, IOException {
        loadAuthors();
        loadArticles();
    }
    
    protected void loadAuthors() throws FileNotFoundException, IOException {
        // File file = new File("data/Authors.csv");
        System.out.println(new File(".").getAbsolutePath());
        
        // TODO: Load authors from file
        Reader file = new FileReader("data/Authors.csv");
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(file);
        for (CSVRecord record : records) {
            String id = record.get(0);
            String lastName = record.get(1);
            String firstName = record.get(2);
            String name = (lastName + "," + firstName).replace("\"", "");
            
            Author author = new Author(id, name);
            authorMap.put(author.id, author);
            
        }
        authorMap.forEach((key, value) -> System.out.println(key + ":" + value));
        
    }

    protected void loadArticles() throws FileNotFoundException, IOException {
        File file = new File("data/Articles.csv");

        // TODO: Load articles from file and assign them to appropriate journal
    }

    public void listContents() {
        // TODO: Print all journals with their respective articles and authors to the
        // console.
    }

    public static final void main(String[] args) throws Exception {
        LibrarySystem librarySystem = new LibrarySystem();

        librarySystem.load();
        librarySystem.listContents();
    }
}
