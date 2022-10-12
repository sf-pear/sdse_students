package edu.sdse.csvprocessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class CityCSVProcessor {

    public void readAndProcess(File file) {
        // Try with resource statement (as of Java 8)
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            // Discard header row
            br.readLine();

            String line;

            // create empty list to hold all records
            ArrayList<CityRecord> allRecords = new ArrayList<>();
            Map<String, List<CityRecord>> cityMap = new HashMap<>();

            while ((line = br.readLine()) != null) {
                // Parse each line
                String[] rawValues = line.split(",");

                int id = convertToInt(rawValues[0]);
                int year = convertToInt(rawValues[1]);
                String city = convertToString(rawValues[2]);
                int population = convertToInt(rawValues[3]);

                // System.out.println("id: " + id + ", year: " + year + ", city: " + city + ",
                // population: " + population);

                // instantiate CityRecord object
                CityRecord obj = new CityRecord(id, year, city, population);
                // add new object to allRecord list
                allRecords.add(obj);

                if (!cityMap.containsKey(city)) {
                    cityMap.put(city, new ArrayList<CityRecord>());
                }
                cityMap.get(city).add(obj);

                // printing object for first part of the exercise
                // System.out.println(obj);
            }
            
            // Check map
            // System.out.println(cityMap.get("Oslo"));
            getStats(cityMap);

        } catch (Exception e) {
            System.err.println("An error occurred:");
            e.printStackTrace();
        }
    }

    private String cleanRawValue(String rawValue) {
        return rawValue.trim();
    }

    private int convertToInt(String rawValue) {
        rawValue = cleanRawValue(rawValue);
        return Integer.parseInt(rawValue);
    }

    private String convertToString(String rawValue) {
        rawValue = cleanRawValue(rawValue);

        if (rawValue.startsWith("\"") && rawValue.endsWith("\"")) {
            return rawValue.substring(1, rawValue.length() - 1);
        }

        return rawValue;
    }
    
    // TO DO
    public void getStats(Map<String, List<CityRecord>> cityMap) {
        for (String key : cityMap.keySet()) {
            List<CityRecord> recordList = cityMap.get(key);
            int entryCount = recordList.size();

            // this gets the record with the minimum year
            // CityRecord minYearRecord = recordList.stream().min(Comparator.comparingInt(CityRecord::getYear)).get();
            // System.out.println(minYearRecord);

            int minYear = 3000;
            int maxYear = 0;
            int popSum = 0;
            
            // loop through the records in the list to find value for each city/key
            for (CityRecord record : recordList) {

                int year = record.getYear();
                int pop = record.getPop();
                
                if (year < minYear) {
                    minYear = year;
                }
                if (year > maxYear) {
                    maxYear = year;
                }
                popSum += pop;
            }

            // calculate avg population
            int avgPop = popSum/entryCount;

            System.out.println("Avarage population of " + key + " (" + minYear + "-" + maxYear + "; " + entryCount + "): " + avgPop);
        }
    }

    public static final void main(String[] args) {
        CityCSVProcessor reader = new CityCSVProcessor();

        File dataDirectory = new File(
                "data/");
        File csvFile = new File(dataDirectory, "Cities.csv");

        reader.readAndProcess(csvFile);
    }
}
