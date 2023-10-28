package edu.handong.csee.java.hw2;
//import edu.handong.csee.java.hw2.converters.*;
/**
 * This is a public class 'Util' - a static class having a frequently used method in this program.
 */
public class Util {

        public static double ton=0;
        public static double kg=0;
        public static double km=0;
        public static double mile=0;
        public static double g=0;

        /**
         * This is a public static method 'setON'of a class 'Util' - put the value on the ton (change the type of the value : string -> double).
         * @param arg
         */
        public static void setTON(String arg){
            ton=Double.parseDouble(arg);
        }
        /**
         * This is a public static method 'setKG'of a class 'Util' - put the value on the kg (change the type of the value : string -> double).
         * @param arg
         */
        public static void setKG(String arg){
            kg=Double.parseDouble(arg);
        }
        /**
         * This is a public static method 'setKM'of a class 'Util' - put the value on the km (change the type of the value : string -> double).
         * @param arg
         */
        public static void setKM(String arg){
            km=Double.parseDouble(arg);
        }
        /**
         * This is a public static method 'setMILE'of a class 'Util' - put the value on the mile (change the type of the value : string -> double).
         * @param arg
         */
        public static void setMILE(String arg){
            mile=Double.parseDouble(arg);
        }
        /**
         * This is a public static method 'setG'of a class 'Util' - put the value on the g. (change the type of the value : string -> double)
         * @param arg
         */
        public static void setG(String arg){
            g=Double.parseDouble(arg);
        }
    
    

        private static double result=0;

        /**
         * This is a public method 'compare' of the class 'Util' - classsify numits of input values.
         * @param arg1
         * @param arg2
         * @return
         */
        public static double compare(String arg1, String arg2){
            if(arg2.equals("all")){
                if(arg1.equals("KM")||arg1.equals("Km")||arg1.equals("km")){
                    result=1.3;
                }
                else if(arg1.equals("TON")||arg1.equals("Ton")||arg1.equals("ton")){
                    result=2.3;
                }

                else{
                    result=0.1;
                }
            }
            else{
                if(arg1.equals("KM")||arg1.equals("Km")||arg1.equals("km")){
                    if(arg2.equals("MILE")||arg2.equals("Mile")||arg2.equals("mile")){
                        result=1.1;
                    }
                    else if(arg2.equals("M")||arg2.equals("m")){
                            result= 1.2;
                        }
                    else{
                        result=0;
                    }
                }
                else if(arg1.equals("TON")||arg1.equals("Ton")||arg1.equals("ton")){
                    if(arg2.equals("KG")||arg2.equals("Kg")||arg2.equals("kg")){
                        result=2.1;
                    }
                    else if(arg2.equals("G")||arg2.equals("g")){
                        result=2.2;
                    }                       
                    else{
                        result=0;
                    }
                }
                else if(arg1.equals("MILE")||arg1.equals("Mile")||arg1.equals("mile")){
                    if(arg2.equals("KM")||arg2.equals("Km")||arg2.equals("km")){
                        result=3.1;
                    }
                    else{
                        result=0;
                    }
                }    
                else{
                    result=0;
                }
            }
            return result;
        }
    
}
