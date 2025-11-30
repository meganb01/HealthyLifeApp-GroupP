/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sleepapp;

/**
 *
 * @author Mridhula Vijayakumar
 */
public class SleepApp {
    //variables
    private String date; // e.g. "2025-11-25"
    private String sleepTime;   
    private String wakeTime;
    private double duration;   
    
    //constructor
    public SleepApp(String date, String sleepTime, String wakeTime, double duration) {
        this.date = date;
        this.sleepTime = sleepTime;
        this.wakeTime = wakeTime;
        this.duration = duration;

    }
    
    //getters
    public String getDate() {
        return date;
    }

    public String getSleepTime() {
        return sleepTime;
    }

    public String getWakeTime() {
        return wakeTime;
    }

    public double getDuration() {
        return duration;
    }
    // Converts decimals to HH:mm format for displaying in the table
    public String getDurationInHHMM() {
        int totalMinutes = (int) Math.round(duration * 60);// Convert hours to minutes
        int hours = totalMinutes / 60; // Full hours part
        int minutes = totalMinutes % 60; // Remaining minutes
        return String.format("%02d:%02d", hours, minutes); //formatting
    }
    @Override
public String toString() {
    return date + "," + sleepTime + "," + wakeTime + "," + getDurationInHHMM();
    }
}

