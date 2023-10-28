package edu.handong.csee.java.inheritance;
/**
 * 
 * @author leeshinwon
 *
 */
public class Dog extends Animal{
	/**
	 * @override 
	 * (or hiding: 상속관계에 있는 클래스 간에, 부모 클래스에 static으로 선언된 메소드를 
	 * 자식 클래스에 오버라이딩하는것과 같이 선언해주는데, 자식 클래스를 인스턴스화 하여 
	 * 호출시에 최초 선언한 부모 클래스의 static메소드가 실행하게 된다. )
	 */
	public static void testClassMethod() {
        System.out.println("The static method in Dog");
    }
	/**
	 * @override: 상속 관계에 있는 부모 클래스에서 
	 * 이미 정의된 메소드를 자식 클래스에서 같은 시그니쳐를 갖는 메소드로 
	 * 다시 정의하는 것
	 */
    public void testInstanceMethod() {
        System.out.println("The instance method in Dog");
    }
}