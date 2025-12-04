/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dietapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author megan
 */
public class DietManager {
    private ArrayList<MealEntry> meals; //stores all logged meals 
    private final String fileName = "meals.txt"; //file used for saving data
    
    //constructor initialises the ArrayList and loads any existing data
    public DietManager(){
        meals = new ArrayList<>();
        loadMeals(); //load saved meals from file
    }
    
    //add a new meal to the list and save updated data to file
    public boolean addMeal(MealEntry meal){
        meals.add(meal);
        saveMeals();
        return true; //return true after successful addition
        }
    
    //update an existing meal by matching its name. 
    public boolean updateMeal(String name, MealEntry updatedMeal){
        for(int i = 0; i < meals.size(); i++){
            if(meals.get(i).getName().equalsIgnoreCase(name)){
                meals.set(i, updatedMeal); // then replace the old meal with the updated version
                saveMeals();
                return true; // return true if found and updated
            }
        }
        return false; //otherwise, returns false
    } 
    
    //delete meal from list by matching its name
    public boolean deleteMeal(String name){
        for(int i = 0; i < meals.size(); i++){
            if(meals.get(i).getName().equalsIgnoreCase(name)){
                meals.remove(i);
                saveMeals(); //saves changes
                return true; //return tru if meal is deleted 
            }
        }
        return false; //returns false if meal is not found
        }                 
    
    //method to save the ArrayList of MealEntry objects to a file using serialization to file
    private void saveMeals(){
        try{
            FileOutputStream fStream = new FileOutputStream(fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(fStream);
            oStream.writeObject(meals);
            oStream.close();
        }catch(IOException e){
            //if an error occurs, show an error message
            JOptionPane.showMessageDialog(null, "Error saving meal: " + e);
        }
    }
    
    //method to load previously saved meal data from file
    private void loadMeals(){
        try{
 
            FileInputStream fStream = new FileInputStream(fileName);
            ObjectInputStream oStream = new ObjectInputStream(fStream);
            meals = (ArrayList<MealEntry>)oStream.readObject();
            oStream.close();
        }catch(FileNotFoundException e){
            //if file doesnt exist yet, start with empty ArrayList with no meals
            meals = new ArrayList<>();
        }catch (IOException | ClassNotFoundException e){
            //IOException will handle reading errors
            //ClassNotFoundException handles cases where MealEntry class isnt found 
        JOptionPane.showMessageDialog(null, "Error loading meals: " + e);
        }
    }
    
    //getter method used by GUI to access the list of meals
    public ArrayList<MealEntry> getMeals(){
        return meals;
    }
   
}
