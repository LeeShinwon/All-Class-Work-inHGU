package edu.handong.csee.java.inheritance;

/**
 * @author leeshinwon
 *
 */
public class Cat extends Animal{
	/**
	 * @override (or hiding)
	 */
	public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }
	/**
	 * @override
	 */
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }
	
	/**
	 * @param args
	 */
    public static void main(String[] args) {
    	/**
    	 *  polymorphism : 하나의 객체가 여러개의 자료형 타입을 가질 수 있는 것
    	 *  static method의 경우에는 다형성 적용X
    	 *  'dog' and 'monkey', declared by the Animal type 
    	 */
    	Animal dog = new Dog();
    	Animal monkey = new Monkey();
    	
        Cat myCat = new Cat();
        Animal myAnimal = myCat;
        /**
         * class method(static method)
         * the resulting message: The static method in Animal
         */
        Animal.testClassMethod();
        /**
         * @override
         * the resulting message: The instance method in Cat
         */
        myAnimal.testInstanceMethod();
    }


}