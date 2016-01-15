package lesson_7_personal_box;

import java.awt.Color;

public class SwimmingTank extends AbstractTank {
		
		public SwimmingTank(int ID, Color color, int health){
			super(ID, color, ID);
		}
		
		public void swim(){
			System.out.println("SWIM");
		}
}
