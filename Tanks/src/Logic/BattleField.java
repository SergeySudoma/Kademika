package Logic;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.security.auth.DestroyFailedException;

import Objects.AbstractObjectOfField;
import Objects.Blank;
import Objects.Brick;
import Objects.Eagle;
import Objects.Rock;
import Objects.Water;

public class BattleField {

	public static final int bfWidth = 576;
	public static final int bfHeight = 576;
	public static final int PIXELS_IN_CELL = 64;
	
	private int eagleX;
	private int eagleY;
	private Eagle eagle;
	private ArrayList<AbstractObjectOfField> list = new ArrayList<AbstractObjectOfField>();
	private AbstractObjectOfField toBeDeleted;

	private String[][] battleField = {
			{ "B", "B", "B", "B", "B", "B", "B", "B", "B" },
			{ "B", " ", " ", " ", "B", " ", "", "", "B" },
			{ "B", " ", "", " ", "R", " ", "W", " ", "B" },
			{ "B", "B", "", " ", " ", " ", " ", " ", "B" },
			{ "B", "B", "B", "B", " ", " ", " ", " ", "B" },
			{ "B", " ", "W", "B", " ", " ", "", "B", "B" },
			{ "B", " ", " ", " ", "B", " ", " ", " ", "B" },
			{ "B", "E", " ", " ", " ", " ", " ", " ", "B" },
			{ "B", "B", "B", "B", "B", "B", "B", "B", "B" } };

	public BattleField() {
		createObjects();
	}

	public BattleField(String[][] battlefield) {
		this.battleField = battlefield;
		createObjects();
	}

	public String[][] getBattleField() {
		return battleField;
	}

	public void addToList(AbstractObjectOfField obj) {
		list.add(obj);
	}

	public ArrayList<AbstractObjectOfField> getList() {
		return list;
	}

	public String scanQuadrant(int x, int y) {
		return battleField[x][y];
	}

	public void updateQuadrant(int x, int y, String value) {
		battleField[x][y] = value;
	}

	public int getDimensionX() {
		return battleField.length;
	}

	public int getDimensionY() {
		return battleField.length;
	}

	public int getBfWidth() {
		return bfWidth;
	}

	public int getBfHeight() {
		return bfHeight;
	}

	public AbstractObjectOfField checkQuadrant(int x, int y) {
		AbstractObjectOfField result = null;
		for (AbstractObjectOfField obj : list) {
			if (obj.getX() == x * PIXELS_IN_CELL
					&& obj.getY() == y * PIXELS_IN_CELL) {
				result = obj;
			}
		}
		return result;
	}

	public void updateObjects(int y, int x) throws DestroyFailedException {
		for (AbstractObjectOfField obj : list) {
			if (!(obj instanceof Blank)) {
				if (obj.getX() == x * PIXELS_IN_CELL
						&& obj.getY() == y * PIXELS_IN_CELL) {
					toBeDeleted = obj;
					obj.destroy();					
				}
			}
		}
		list.remove(toBeDeleted);
	}

	public boolean checkInterception(int y, int x) {
		boolean result = false;
		for (AbstractObjectOfField obj : list) {
			if (!(obj instanceof Blank)) {
				if (obj.getX() == x * PIXELS_IN_CELL
						&& obj.getY() == y * PIXELS_IN_CELL) {
					result = true;
				}
			}
		}
		return result;
	}
	
	public void createObjects() {
		for (int j = 0; j < this.getDimensionY(); j++) {
			for (int k = 0; k < this.getDimensionX(); k++) {
				if (this.scanQuadrant(j, k).equals("B")) {
					list.add(new Brick(j * PIXELS_IN_CELL, k * PIXELS_IN_CELL));
				} else if (this.scanQuadrant(j, k).equals("R")) {
					list.add(new Rock(j * PIXELS_IN_CELL, k * PIXELS_IN_CELL));
				} else if (this.scanQuadrant(j, k).equals("E")) {
					list.add(eagle = new Eagle(j * PIXELS_IN_CELL, k
							* PIXELS_IN_CELL));
					setEagleX(j);
					setEagleY(k);
				} else if (this.scanQuadrant(j, k).equals("W")) {
					list.add(new Water(j * PIXELS_IN_CELL, k * PIXELS_IN_CELL));

				}

				else {
					list.add(new Blank(j * PIXELS_IN_CELL, k * PIXELS_IN_CELL));
				}

			}
		}
	}

	public void draw(Graphics g) {
		for (AbstractObjectOfField item : list) {
			item.draw(g);
		}
	}

	public int getEagleX() {
		return eagle.getX();
	}

	private void setEagleX(int eagleX) {
		this.eagleX = eagleX;
	}

	public int getEagleY() {
		return eagle.getY();
	}

	private void setEagleY(int eagleY) {
		this.eagleY = eagleY;
	}

	public Eagle getEagle() {
		return eagle;
	}
}
