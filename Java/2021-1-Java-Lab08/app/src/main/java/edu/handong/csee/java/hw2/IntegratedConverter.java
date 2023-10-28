package edu.handong.csee.java.hw2;
import edu.handong.csee.java.hw2.converters.*;
/**
 * This is a class 'IntegratedConverter'- where the main method is implemented.
 */
public class IntegratedConverter {
   
    public static double number=0;
    
    /**
     * This is a main method of this program.
     * @param args
     */
    public static void main(String[] args) {

        IntegratedConverter myConverter = new IntegratedConverter();

        myConverter.run(args);

    }

    /**
     * This is a method 'run'.
     * @param args
     */
    private void run(String[] args) {
        
        number=Util.compare(args[1], args[2]);
        if(number==1.1){
            KMToMILEConverter kmToMile = new  KMToMILEConverter();
            Util.setKM(args[0]);
            System.out.println(args[0] +" KM is "+ kmToMile.convert(Util.km)+" MILE!\n");

        }
        else if(number==1.2){
            KMToMConverter kmToM = new  KMToMConverter();
            Util.setKM(args[0]);
            System.out.println(args[0] +" KM is "+ kmToM.convert(Util.km)+" M!\n");
        }
        else if(number==1.3){
            AllConverter all =new AllConverter();
            Util.setKM(args[0]);
            all.convertKM(Util.km);
        }
        else if(number==2.1){
            TONToKGConverter TonToKg = new  TONToKGConverter();
            Util.setTON(args[0]);
            System.out.println(args[0] +" TON is "+ TonToKg.convert(Util.ton)+" KG!\n");
        }
        else if(number==2.2){
            TONToGConverter TonToG = new  TONToGConverter();
            Util.setTON(args[0]);
            System.out.println(args[0] +" TON is "+ TonToG.convert(Util.ton)+" G!\n");
        }
        else if(number==2.3){
            AllConverter all =new AllConverter();
            Util.setTON(args[0]);
            all.convertTON(Util.ton);
        }
        else if(number==3.1){
            MILEToKMConverter MileToKm = new  MILEToKMConverter();
            Util.setMILE(args[0]);
            System.out.println(args[0] +" MILE is "+ MileToKm.convert(Util.mile)+" KM!\n");
        }
        else if(number==0){
            System.out.println("The converter (edu.handong.csee.java.hw2.converters."+ args[1].toUpperCase()+"To"+ args[2].toUpperCase()+"Converter) for "+args[1].toUpperCase()+" to " +args[2].toUpperCase() + " does not exist!!\n");
        }
        else if(number==0.1){
            System.out.println("AllConverter cannot support the measure!\n");
        }

        //
        //KMToMConverter mConvert = new  KMToMConverter();



    }
    
}
