package com.midgardabc.day9.adapter.math.v2;

import com.midgardabc.day9.adapter.math.Arifmetika;
import com.midgardabc.day9.adapter.math.v2.calc.Calculator;

public class AfifmetikaAdapter implements Calculator{

	@Override
	public int summa(int a, int b) {
		int[] numbers = {a,b};
		return Arifmetika.summa(numbers);
	}

	@Override
	public int multiply(int a, int b) {
		return Arifmetika.multiply(a, b);
	}

}
