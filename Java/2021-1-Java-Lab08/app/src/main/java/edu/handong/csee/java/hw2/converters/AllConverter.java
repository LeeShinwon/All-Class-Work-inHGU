package edu.handong.csee.java.hw2.converters;
/**
 * This is a class 'AllConverter'.
 */
public class AllConverter {
    /**
     * This is a method - 'convertKM' - convert Km to m, mile.
     * @param value
     */
    public void convertKM(double value){
        System.out.println(value+ " KM to "+value*1000+" M");
        System.out.println(value+ " KM to "+value/1.6+" MILE\n");
    }
    /**
     * This is a method - 'convertTON' - convert Ton to kg,g.
     * @param value
     */
    public void convertTON(double value){
        System.out.println(value+ " TON to "+value*1000+" KG");
        System.out.println(value+ " TON to "+value*1000000+" G\n");
    }
}
