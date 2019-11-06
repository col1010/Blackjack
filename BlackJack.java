import static java.lang.System.out;

import java.util.Scanner;

public class BlackJack {
	private Dealer dealer;
	private Player player;
	private int playerWins;
	private int dealerWins;
	private boolean keepPlaying;
	private boolean hit;
	private Scanner input = new Scanner(System.in);
	private Card hitCard;

	public BlackJack() {
		// instantiate all of your instance variables
		dealer = new Dealer();
		player = new Player();
		playerWins = 0;
		dealerWins = 0;
		keepPlaying = true;
		hit = true;
		hitCard = new Card();
	}

	public void playGame() {
		// all game code goes in here
		while (keepPlaying == true) {
			dealer.shuffle();
			player.addCardToHand(dealer.deal());
			dealer.addCardToHand(dealer.deal());
			player.addCardToHand(dealer.deal());
			dealer.addCardToHand(dealer.deal());

			while (dealer.getHandValue() < 17) {
				dealer.hit(dealer.deal());
			}

			while (hit == true && player.getHandValue() < 21) {
				out.println("\n" + player.toString());
				out.println("\nWould you like to hit? [y/n]");
				if (input.next().equalsIgnoreCase("y")) {

					hitCard = dealer.deal();

					if (hitCard.getSuit().equals("ACE") && player.getHandValue() > 10) { // if the card dealt is an Ace and the player's hand's sum is greater than 10
						player.hit(new Card(1, hitCard.getSuit())); // manually enter the card's value as 1

					} else {
						player.hit(hitCard);
					}
				} else {
					hit = false;
				}
			}
			System.out.println(dealer.dealerDeck);
			out.println("\nPLAYER ");
			out.println("Hand Value: " + player.getHandValue());
			out.println("Hand Size: " + player.getHandSize());
			out.println(player.toString());
			out.println("\nDEALER ");
			out.println("Hand Value: " + dealer.getHandValue());
			out.println("Hand Size: " + dealer.getHandSize());
			out.println(dealer.toString());
			out.println();
			
			if (player.getHandValue() > 21 && dealer.getHandValue() > 21) {
				System.out.println("Double bust! No one wins!");
			}
			else if (player.getHandValue() > 21) {
				System.out.println("Player busted! Dealer wins!");
				dealerWins+=1;
			}
			else if (dealer.getHandValue() > 21) {
				System.out.println("Dealer busted! Player wins!");
				playerWins+=1;
			}
			else if (player.getHandValue() == dealer.getHandValue()) {
				System.out.println("It's a tie! No one wins!");
			}
			else if (player.getHandValue() == 21) {
				System.out.println("Blackjack! Player wins!");
				playerWins+=1;
			} 
			else if (dealer.getHandValue() == 21) {
				System.out.println("Blackjack! Dealer wins!");
				dealerWins+=1;
			}
			else if (player.getHandValue() > dealer.getHandValue()) {
				System.out.println("Player has the bigger hand value!");
				playerWins+=1;
			} 
			else if (dealer.getHandValue() > player.getHandValue()) {
				System.out.println("Dealer has the bigger hand value!");
				dealerWins+=1;
			}

			
			System.out.println();
			System.out.println("Dealer has won " + dealerWins + " times");
			System.out.println("Player has won " + playerWins + " times");
			
			System.out.println("\nWould you like to play again? [y/n]");
			if (input.next().equalsIgnoreCase("y")) {
				System.out.println("Let's play again!");
				player.resetHand();
				dealer.resetHand();
				hit = true;
				dealer = new Dealer();
			} else {
				System.out.println("Thanks for playing");
				keepPlaying = false;
			}
		

		} // end of while loop

	} // end of playGame

	public static void main(String args[]) {
		BlackJack game = new BlackJack();
		game.playGame();
	}
}
