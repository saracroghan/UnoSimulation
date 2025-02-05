
public class Card {
	private char value;
	private String color;

	public Card (char v, String c) {
		this.value = v;
		this.color = c;
	}
	public char getValue() {
		return this.value;
	}
	public String getColor() {
		return this.color;
	}
	public String printCard() {
		return ("( "+this.value+", "+this.color+" )");
		
	}
}

