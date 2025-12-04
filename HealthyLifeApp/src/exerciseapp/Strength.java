/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exerciseapp;

/**
 *
 * @author dhruva
 */
public class Strength extends Exercise implements CaloriesBurned{
    //declaring variables
    private int sets, reps;
    
    //default constructor

    public Strength() {
        sets=0;
        reps=0;
    }
    //overloaded constructor
    public Strength(int sets, int reps, String name, double duration) {
        super(name, duration); //super class constructor
        this.sets = sets;
        this.reps = reps;
    }
    
    @Override //interface method
    public double calculateCalories(){
       double result;
       result= (sets*reps)*getDuration();
       return result;
    }
    @Override
    public String printDetails(){
        return super.printDetails()+", Sets: "+ sets+", Reps: "+reps;
    }
    
}
