/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sleepapp;
import java.util.ArrayList;
import java.io.*;
/**
 *
 * @author Mridhula Vijayakumar
 */
public class SleepManager {
    private ArrayList<SleepApp> entries = new ArrayList<>(); // This list holds all SleepApp objects (one object per day)
    private final String FILE_NAME = "sleepdata.txt"; // Name of the file where sleep records are stored
    
    //constructor
    public SleepManager() {
        loadFromFile();
    }
    
    // Adds a new sleep record to the list,then saves updated data to file.
    public void addEntry(SleepApp entry) {
        entries.add(entry);
        saveToFile(); // Save immediately to keep data forever
    }
    
    //Provides access to the stored entries list.
    public ArrayList<SleepApp> getEntries() {
        return entries;
    }
    
    // Calculates average sleep duration from all entries.
    public double getAverageHours() {
    if (entries.isEmpty()) {
        return 0.0; // No data - average = 0
    }

    double total = 0.0;
    
    // Loop through each entry and add up durations
    for (SleepApp e : entries) {
        total += e.getDuration();
    }
    // Divide total sleep hours by number of days
    return total / entries.size();
}
    //Saves all sleep records into a text file, Each record is saved in one line.
    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            // Write each entry using its toString() format
            for (SleepApp e : entries) {
                writer.println(e.toString());
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }
    
    //Loads saved sleep data when app starts.Each line from file - converted back to objects.
    public void loadFromFile() {
        File file = new File(FILE_NAME);
        // If no file exists yet (first time running), skip loading
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the saved text into 4 parts: date, sleep, wake, duration
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String date = parts[0];
                    String sleepTime = parts[1];
                    String wakeTime = parts[2];
                    
                    // Convert duration from "HH:mm" - double hours
                    String[] hm = parts[3].split(":");
                    double duration = Integer.parseInt(hm[0]) + Integer.parseInt(hm[1]) / 60.0;
                    // Add reconstructed object into list
                    entries.add(new SleepApp(date, sleepTime, wakeTime, duration));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading file.");
        }
    }

}
