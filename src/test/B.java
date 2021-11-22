package test;

public class B extends A {
public  void display() {
	System.out.println("in b");
}
public static void main(String[] args) {
	B b=new B();
	A a=new B();
	b.display();
	a.display();
}
}
