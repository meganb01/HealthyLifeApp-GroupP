/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exerciseapp;

import java.io.Serializable;

/**
 *
 * @author dhruva 
 */
public class Exercise implements Serializable {
    //creating variables
    protected String name;
    protected double duration;
    
   
    //default constructor
    public Exercise() {
        name=null;
        duration=0.0;
    }
    //overloaded constructor

    public Exercise(String name, double duration) {
        this.name = name;
        this.duration = duration;
    }
    
    //Setters and Getters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
    
    public String printDetails(){
        return "Name: "+name+", "+" Duration: "+ duration;
    }
}
