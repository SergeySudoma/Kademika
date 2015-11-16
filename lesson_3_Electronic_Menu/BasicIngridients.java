package lesson_3_Electronic_Menu;

public enum BasicIngridients {
	WATER(10), SUGAR(15), MILK(30), BLACK_TEA(90), GREEN_TEA(95), BERGHAMOT(90), COFFEE(
			170);

	int pricePer1000g;

	BasicIngridients(int pricePer1000g) {
		this.pricePer1000g = pricePer1000g;
	}

	public int getPrice() {
		return this.pricePer1000g;
	}
}