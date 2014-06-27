/* 8.1
 * Design the data structure for a generic deck of cards. Explain how you would
 * subclass the data structure to implement blackjack.
 */ 

public abstract class Card {
	 Suit suit;
	 int faceValue;
	 
	 public Card(Suit suit, int faceValue) {
		 this.suit = suit;
		 this.faceValue = faceValue;
	 }
	 
	 public abstract void value() {}
	 
}

public enum Suit {
	SPADE, HEART, DIAMOND, CLUB;
}

public class BlackjackCard extends Card {	
	public BlackjackCard(Suit suit, int faceValue) {
		super(suit, faceValue);
	}
	
	public void value() {
		if (faceValue >= 2 && faceValue <= 10) {
			return faceValue;
		} else if (faceValue > 10) {
			return 10;
		} else if (isAce()) {
			return 11;
		}
	}
	
	public boolean isAce() {
		return faceValue == 1 ? true : false;
	}
	
}

public class Deck <T extends Card>{
	private Stack deck;
	
	public Deck(T card) {
		for (Suit s : Suit.values()) {
			for (int i = 1; i <= 13; i++) {
				T card = new T(s, i);
				card.setValue();
				deck.push(card);
			}
		}
	}
	
	public T getCard() {
		return deck.pop();
	}
	
	public void shuffle() {
		
	}
	
}


public class Player {
	private String name;
	private ArrayList<BlackjackCard> cards;
	private int score;
	private boolean isStop;
	
	public Player(String name) {
		this.name = name;
		cards = new ArrayList<BlackjackCard>();
	}
	
	public void hit(Deck<BlackjackCard> deck) {
		cards.add(deck.getCard());
		score =+ c.value();
		if (c.isAce() && score > 21) {
			score =- 10;
		}
	}
	
	public boolean stand() {
		return true;
	}
	
	public int score() {
		return score;
	}
	
	public String getName() {
		return name;
	}
	
	public void play() {
		if (score < 17) {
			hit();
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
		dealer = new Player("Dealer");
		player = new Player("Player");
	}
	
	public static void start() {
		while(!dealer.isStop() && !player.isStop()) {
			dealer.play();
			player.play();
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