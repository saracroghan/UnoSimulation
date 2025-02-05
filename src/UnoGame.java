import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class UnoGame {
	private CardStack stack;
	private LinkedList<Card> hand;
	private int hand_size;
	private char[] values;
	private String[] colors;
	
	public UnoGame() {
		this.stack = new CardStack();
		this.hand =  new LinkedList<Card>();
		this.values = new char[]{'1','2','3','4','5','6','B','R','W'};
		this.colors = new String[] {"Red","Yellow","Blue"};
		
	}
	public Card getNewCard() {
		Random rand = new Random();
		int v_index = rand.nextInt(9);
		int c_index = rand.nextInt(3);
		Card newCard = new Card(values[v_index], colors[c_index]);
		return newCard;
	}
	public LinkedList<Card> drawHand(){
		for (int i=0; i< 5; i++) {
			Card drawn_card = getNewCard();
			hand.add(drawn_card);
			hand_size++;
		}
		return hand;
	}
	public void printHand() {
		String hand_string = "What card do you want to play?" +"\n";
		hand_string += "Press 0 to draw a new card"+ "\n"+"[ ";
		for (int i = 0; i < hand_size; i++) {
			hand_string += hand.get(i).printCard()+", ";
		}
		hand_string += " ]";
		System.out.println(hand_string);
	}
	public void startGame() {
		Card newCard = getNewCard();
		stack.push(newCard);
	}
	public void play() {
		if(hand_size == 0) {
			System.out.println("Game Over");
			return;
		}
		stack.printTop();
		printHand();
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		if(i == 0) {
			hand_size++;
			Card newCard = getNewCard();
			hand.push(newCard);
			play();
		}
		else {
		Card played_card = hand.get(i-1);
		Card top_stack = stack.peek();
		if(played_card.getValue()== top_stack.getValue() || played_card.getColor().equals(top_stack.getColor())|| played_card.getValue()== 'W'){
			hand.remove(played_card);
			hand_size --;
			if (played_card.getValue()== 'R') {
				if(stack.getSize()==1) {
					play();
				}
				else {
				stack.pop();
				play();
				}
			}
			else if(played_card.getValue() == 'B') {
				if (stack.getSize()==1) {
					play();
				}
				else {
				for(int q = 0; q < stack.getSize()-1; q++) {
					stack.pop();
					}
				play();
				}
				}
			else {
				stack.push(played_card);
				play();
			}
		}
		else {
			System.out.println("Illegal move...try again");
			play();
			return;
			}
		}
		}
}