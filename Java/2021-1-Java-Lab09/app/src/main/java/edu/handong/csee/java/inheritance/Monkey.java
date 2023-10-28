package edu.handong.csee.java.inheritance;
/**
 * 
 * @author leeshinwon
 *
 */
public class Monkey extends Animal{
	/**
	 * @override (or hiding)
	 */
	public static void testClassMethod() {
        System.out.println("The static method in Monkey");
    }
	/**
	 * @override
	 */
    public void testInstanceMethod() {
        System.out.println("The instance method in Monkey");
    }
}

