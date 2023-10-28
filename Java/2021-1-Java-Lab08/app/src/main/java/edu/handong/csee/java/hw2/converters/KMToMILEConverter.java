package edu.handong.csee.java.hw2.converters;
/**
 * This is a class 'KMToMILEConverter' - implements Convertible(interface).
 */
public class KMToMILEConverter implements Convertible{
    /**
     * This is a method 'convert' of the class 'KMToMILEConverter' - implements Convertible(interface).
     */
    public double convert(double value){
        return value/1.6;
    }
}
