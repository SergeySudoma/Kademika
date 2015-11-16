package lesson_3_Electronic_Menu;

public enum Drinks {

	BLACK_COFFEE(BasicIngridients.WATER, 0.2, BasicIngridients.SUGAR, 0.02, BasicIngridients.MILK, 0, BasicIngridients.COFFEE, 0.03), 
	COFFEE_WITH_MILK(BasicIngridients.WATER, 0.15, BasicIngridients.SUGAR, 0.02, BasicIngridients.MILK, 0.05, BasicIngridients.COFFEE, 0.03),
	AMERICANO(BasicIngridients.WATER, 0.12, BasicIngridients.SUGAR, 0.02, BasicIngridients.MILK, 0.08, BasicIngridients.COFFEE, 0.03),
	KAPUCHINO(BasicIngridients.WATER, 0.1, BasicIngridients.SUGAR, 0.02, BasicIngridients.MILK, 0.1, BasicIngridients.COFFEE, 0.03),
	MOCACHINO(BasicIngridients.WATER, 0.08, BasicIngridients.SUGAR, 0.02, BasicIngridients.MILK, 0.12, BasicIngridients.COFFEE, 0.03),
	BLACK_TEA(BasicIngridients.WATER, 0.22, BasicIngridients.SUGAR, 0.02, BasicIngridients.MILK, 0, BasicIngridients.BLACK_TEA, 0.03),
	GREEN_TEA(BasicIngridients.WATER, 0.22, BasicIngridients.SUGAR, 0.02, BasicIngridients.MILK, 0, BasicIngridients.GREEN_TEA, 0.03),
	TEA_WITH_BERGHAMOT(BasicIngridients.WATER, 0.22, BasicIngridients.SUGAR, 0.02, BasicIngridients.MILK, 0, BasicIngridients.BLACK_TEA, 0.03, BasicIngridients.BERGHAMOT, 0.03);

	private BasicIngridients water;
	private BasicIngridients sugar;
	private BasicIngridients milk;
	private BasicIngridients base;
	private BasicIngridients berghmot;
	private double volume_water;
	private double volume_sugar;
	private double volume_milk;
	private double volume_base;
	private double volume_berghamot;
	private double sugarAdditionalPortion = 0.01;
	private double milkAdditionalPortion = 0.01;
		
	
	Drinks(BasicIngridients water, double volume_water, BasicIngridients sugar, double volume_sugar, BasicIngridients milk, double volume_milk,
			BasicIngridients base, double volume_base){
				
				this.water = water;
				this.sugar = sugar;
				this.milk = milk;
				this.base = base;
				this.volume_water = volume_water;
				this.volume_sugar = volume_sugar;
				this.volume_milk = volume_milk;
				this.volume_base = volume_base;
	}	


	Drinks(BasicIngridients water, double volume_water, BasicIngridients sugar, double volume_sugar, BasicIngridients milk, double volume_milk,
			BasicIngridients base, double volume_base, BasicIngridients berghamot, double volume_berghamot){				
				this.water = water;
				this.sugar = sugar;
				this.milk = milk;
				this.base = base;
				this.berghmot = berghamot;
				this.volume_water = volume_water;
				this.volume_sugar = volume_sugar;
				this.volume_milk = volume_milk;
				this.volume_base = volume_base;
				this.volume_berghamot = volume_berghamot;
	}
	
	public BasicIngridients getWater() {
		return water;
	}

	public void setWater(BasicIngridients water) {
		this.water = water;
	}

	public BasicIngridients getSugar() {
		return sugar;
	}

	public void setSugar(BasicIngridients sugar) {
		this.sugar = sugar;
	}

	public BasicIngridients getMilk() {
		return milk;
	}

	public void setMilk(BasicIngridients milk) {
		this.milk = milk;
	}

	public BasicIngridients getBase() {
		return base;
	}

	public void setBase(BasicIngridients base) {
		this.base = base;
	}

	public BasicIngridients getBerghmot() {
		return berghmot;
	}

	public void setBerghmot(BasicIngridients berghmot) {
		this.berghmot = berghmot;
	}

	public double getVolume_water() {
		return volume_water;
	}

	public void setVolume_water(double volume_water) {
		this.volume_water = volume_water;
	}

	public double getVolume_sugar() {
		return volume_sugar;
	}

	public void setVolume_sugar(double volume_sugar) {
		this.volume_sugar = volume_sugar;
	}

	public double getVolume_milk() {
		return volume_milk;
	}

	public void setVolume_milk(double volume_milk) {
		this.volume_milk = volume_milk;
	}

	public double getVolume_base() {
		return volume_base;
	}

	public void setVolume_base(double volume_base) {
		this.volume_base = volume_base;
	}

	public double getVolume_berghamot() {
		return volume_berghamot;
	}

	public void setVolume_berghamot(double volume_berghamot) {
		this.volume_berghamot = volume_berghamot;
	}

	public double getSugarAdditionalPortion() {
		return sugarAdditionalPortion;
	}

	public void setSugarAdditionalPortion(double sugarAdditionalPortion) {
		this.sugarAdditionalPortion = sugarAdditionalPortion;
	}

	public double getMilkAdditionalPortion() {
		return milkAdditionalPortion;
	}

	public void setMilkAdditionalPortion(double milkAdditionalPortion) {
		this.milkAdditionalPortion = milkAdditionalPortion;
	}
	
	@Override
	public String toString() {
		String string = this.name();
		
		if(this.name().length() < 20){
			int spaces = 20 - this.name().length();
			for(int i = 0; i < spaces; i++){
				string += " ";
			}
		}
		
		if(this.getVolume_water() > 0){
			string += this.getWater() + " " + this.getVolume_water() * 1000 + " g - ";
		}
		if(this.getVolume_sugar() > 0){
			string += this.getSugar() + " " + this.getVolume_sugar() * 100 + " g - "; 
		}
		if(this.getVolume_milk() > 0){
			string += this.getMilk() + " " + this.getVolume_milk() * 100 + " g - "; 
		}
		if(this.getVolume_base() > 0){
			string += this.getBase() + " " + this.getVolume_base() * 100 + " g - "; 
		}
		if(this.getVolume_berghamot() > 0){
			string += this.getBerghmot() + " " + this.getVolume_berghamot() * 100 + " g -"; 
		}		
		return string;
	}
}
