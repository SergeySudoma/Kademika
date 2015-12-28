package com.midgardabc.day9.adapter.math.v2;

import java.util.Random;
import com.midgardabc.day9.adapter.math.v2.calc.Calculator;
import com.midgardabc.day9.adapter.math.v2.calc.DefaultCalculator;

public class Launcher {

	public static void main(String[] args) {
		Calculator calc = new AfifmetikaAdapter();
		
		Operations o = new Operations();
		o.setCalc(calc);

		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			System.out.println(o.createSummaryReport(r.nextInt(100)));
		}
	}
}
