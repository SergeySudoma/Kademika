package test1;

import java.util.ArrayList;

public class InheritanceTest {

	private static ArrayList<A> list = new ArrayList<>();
	
	public static void main(String[] args) {
		
		A a = new A();
		System.out.println(a.name);
		
		A a1 = new B();
		System.out.println(a1.name);
		
		B b = new B();
		System.out.println(b.name);
		
		list.add(a);
		list.add(b);
		list.add(a1);
		
		
		
	}
}
	
	class A {
		
		String name = "A";
		
	}

	class B extends A{
		
		String name = "B";
		String ass = "ass";
		
	}
