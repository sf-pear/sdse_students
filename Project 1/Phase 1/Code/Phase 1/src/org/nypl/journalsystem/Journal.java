package org.nypl.journalsystem;
import java.util.*;

class Journal {
    String journalName;
    String journalIssn;
    ArrayList<String> journalArticles;
    int journalCount = 0;

    public Journal(String journalName, String journalIssn, ArrayList<String> journalArticles) {
        this.journalName = journalName;
        this.journalIssn = journalIssn;
        this.journalArticles = journalArticles;
    }

    // override toString so it doesn't print the hash of the object, but it's
    // contents
    @Override
    public String toString() {
        return "id: " + id + ", year: " + year + ", city: " + city + ", population: " + population;
    }
    
}