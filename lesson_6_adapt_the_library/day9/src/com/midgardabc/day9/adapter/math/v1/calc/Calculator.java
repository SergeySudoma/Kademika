package com.midgardabc.day9.adapter.math.v1.calc;

import com.midgardabc.day9.adapter.math.Arifmetika;

public class Calculator {
	
	public int summa(int a, int b) {
		int[] numbers = {a,b}; 
		return Arifmetika.summa(numbers);

	}

	public int multiply(int a, int b) {
		return Arifmetika.multiply(a, b);
	}
}
