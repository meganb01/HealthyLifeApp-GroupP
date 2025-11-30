/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exerciseapp;

/**
 *
 * @author dhruva
 */
public class Cardio extends Exercise implements CaloriesBurned{
    //declaring variables
    private String intensity;
    
    //default constructor
    public Cardio() {
    intensity=null;
    }
    //overloaded constructor
    public Cardio(String intensity, String name, double duration) {
        super(name, duration); // super class constructor
        this.intensity = intensity;
    }
    
    @Override //interface method
    public double calculateCalories(){
        double level, result;
        switch(intensity){ // decide the burn rate based on intensity value
            case "Low":
               level=5;
               break;
            case "Medium":
                level= 7;
                break;
            case "High":
                level= 10;
                break;
            default:
                level =5;
        }
        result= getDuration()* level;
        return result;
    
    }
    @Override
    public String printDetails(){
        return super.printDetails()+", Intensity: "+intensity;
    }
    
}
