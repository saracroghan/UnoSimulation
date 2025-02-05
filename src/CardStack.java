import java.util.LinkedList;

public class CardStack {
	private LinkedList<Card> stack;
	private Card top_of_stack;
	private int size;
	
	public CardStack() {
		this.stack = new LinkedList<Card>();
		this.top_of_stack = null;
		this.size = 0;
	}
	public void push(Card newCard) {
		stack.addFirst(newCard);
		size++;
		top_of_stack = stack.getFirst();
	}
	public Card pop() {
		if(size == 0) {
			System.out.println("Error.... stack is empty");
			return null;
		}
		Card drawn_card = stack.remove();
		top_of_stack = stack.getFirst();
		size--;
		return drawn_card;
	}
	public Card peek() {
		return top_of_stack;
	}
	
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public int getSize() {
		return this.size;
	}
	public void printTop() {
		System.out.println("The top of the stack is: "+stack.peek().printCard());
	}
}
