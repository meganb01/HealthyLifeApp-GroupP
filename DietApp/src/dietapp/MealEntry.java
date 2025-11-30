/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dietapp;

import java.io.Serializable;

/**
 *
 * @author megan
 */
public class MealEntry implements Serializable { //implements serializable so that meals can be saved to file
    private String name;
    private int calories;
    private String type;
    private String date;
    
    //constructor to create a MealEntry object with all required fields
    public MealEntry(String name, int calories, String type, String date){
        this.name = name;
        this.calories = calories;
        this.type = type;
        this.date = date;
    }
    
    //setters and getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
