/* 8.1
 * Design the data structure for a generic deck of cards. Explain how you would
 * subclass the data structure to implement blackjack.
 */

import java.util.*;

abstract class Card {
	 Suit suit;
	 int faceValue;
	 
	 public Card(Suit suit, int faceValue) {
		 this.suit = suit;
		 this.faceValue = faceValue;
	 }
	 
	 public abstract int value();
	 
}

enum Suit {
	SPADE, HEART, DIAMOND, CLUB;
}

class BlackjackCard extends Card {	
	public BlackjackCard(Suit suit, int faceValue) {
		super(suit, faceValue);
	}
	
	public int value() {
		if (faceValue >= 2 && faceValue <= 10) {
			return faceValue;
		} else if (isAce()) {
			return 11;
		} else {//faceValue > 10
			return 10;
		}
	}
	
	public boolean isAce() {
		return faceValue == 1 ? true : false;
	}
	
}

class Deck <T extends Card>{
	private Stack<BlackjackCard> deck;
	
	public void setDeck() {
		deck = new Stack<BlackjackCard>();
		for (Suit s : Suit.values()) {
			for (int i = 1; i <= 13; i++) {
				BlackjackCard card = new BlackjackCard(s, i);
				card.value();
				deck.push(card);
			}
		}
	}
	
	public BlackjackCard getCard() {
		return deck.pop();
	}
	
	public void shuffle() {
		
	}
	
}


class Player {
	private String name;
	private ArrayList<BlackjackCard> cards;
	private int score;
	private boolean stop;
	
	public Player(String name) {
		this.name = name;
		cards = new ArrayList<BlackjackCard>();
	}
	
	public void hit(Deck<BlackjackCard> deck) {
		BlackjackCard card = deck.getCard();
		cards.add(card);
		score =+ card.value();
		if (card.isAce() && score > 21) {
			score =- 10;
		}
	}
	
	public void stand() {
		stop = true;
	}
	
	public int score() {
		return score;
	}
	
	public boolean isStop() {
		return stop;
	}
	public String getName() {
		return name;
	}
	
	public void play(Deck<BlackjackCard> deck) {
		if (score < 17) {
			hit(deck);
		} else {
			stand();
		}
	}
}

public class BlackjackGame {
	private Deck<BlackjackCard> deck;
	private Player dealer;
	private Player player;
	
	public BlackjackGame() {
		deck = new Deck<BlackjackCard>();
		deck.setDeck();
		dealer = new Player("Dealer");
		player = new Player("Player");
	}
	
	public void start() {
		while(!dealer.isStop() && !player.isStop()) {
			dealer.play(deck);
			player.play(deck);
		}
		
		Player winner = (dealer.score() >= player.score()) ? dealer : player;		
		System.out.println(winner + "wins.");
		System.out.println(dealer.getName() + "'s score: " + dealer.score());
		System.out.println(player.getName() + "'s score: " + player.score());
		
	}
	
	public static void main(String[] args) {
		new BlackjackGame().start();
	}
}