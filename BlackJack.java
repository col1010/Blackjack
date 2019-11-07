import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
	private Dealer dealer;
	private ArrayList<Player> playerList;
	private int[] playerWins;
	private int dealerWins;
	private boolean keepPlaying;
	private boolean hit;
	private Scanner input;
	private Card hitCard;

	public BlackJack() {
		// instantiate all of your instance variables
		dealer = new Dealer();
		playerList = new ArrayList<>();
		System.out.println("How many players are there?");
		int numPlayers = input.nextInt();
		for (int i = 0; i < numPlayers; i++) {
			playerList.add(new Player());
		}
		playerWins = new int[numPlayers];
		dealerWins = 0;
		keepPlaying = true;
		hit = true;
		hitCard = new Card();
		input = new Scanner(System.in);
	}

	public void playGame() {
		// all game code goes in here
		while (keepPlaying == true) {
			dealer.shuffle(); // shuffle the deck
			dealToPlayers();
			dealer.addCardToHand(dealer.deal());
			dealToPlayers();
			dealer.addCardToHand(dealer.deal());

			while (dealer.getHandValue() < 17) {
				dealer.hit(dealer.deal());
			}
			for (int i = 0; i < playerList.size(); i++) { // for each player playing
				hit = true; // resets the value after each player is finished hitting
				while (hit == true && playerList.get(i).getHandValue() < 21) { // while the player still wants to hit and hasn't busted
					out.println("\n" + "Player " + (i+1) + "'s " + playerList.get(i).toString());
					out.println("\nWould you like to hit? [y/n]");
					if (input.next().equalsIgnoreCase("y")) {
	
						hitCard = dealer.deal();
	
						if (hitCard.getSuit().equals("ACE") && playerList.get(i).getHandValue() > 10) { // if the card dealt is an Ace and the player's hand's sum is greater than 10
							playerList.get(i).hit(new Card(1, hitCard.getSuit())); // manually enter the card's value as 1
	
						} else {
							playerList.get(i).hit(hitCard);
						}
					} else {
						hit = false; // set hit to false to exit while loop
					}
				} // end of while loop
				System.out.println(showHandStatus(playerList.get(i))); // print if the player busted or got a blackjack, nothing otherwise
			} // end of for loop
			

			for (int i = 0; i < playerList.size(); i++) { // for each player playing
				out.println("\nPLAYER " + (i+1));
				out.println("Hand Value: " + playerList.get(i).getHandValue());
				out.println("Hand Size: " + playerList.get(i).getHandSize());
				out.println(playerList.get(i).toString());
				out.println("\nDEALER ");
				out.println("Hand Value: " + dealer.getHandValue());
				out.println("Hand Size: " + dealer.getHandSize());
				out.println(dealer.toString());
				out.println();
				
				if (playerList.get(i).getHandValue() > 21 && dealer.getHandValue() > 21) {
					System.out.println("Double bust! No one wins!");
				}
				else if (playerList.get(i).getHandValue() > 21) {
					System.out.println("Player busted! Dealer wins!");
					dealerWins+=1;
				}
				else if (dealer.getHandValue() > 21) {
					System.out.println("Dealer busted! Player wins!");
					playerWins[i]+=1;
				}
				else if (playerList.get(i).getHandValue() == dealer.getHandValue()) {
					System.out.println("It's a tie! No one wins!");
				}
				else if (playerList.get(i).getHandValue() == 21) {
					System.out.println("Blackjack! Player wins!");
					playerWins[i]+=1;
				} 
				else if (dealer.getHandValue() == 21) {
					System.out.println("Blackjack! Dealer wins!");
					dealerWins+=1;
				}
				else if (playerList.get(i).getHandValue() > dealer.getHandValue()) {
					System.out.println("Player has the bigger hand value!");
					playerWins[i]+=1;
				} 
				else if (dealer.getHandValue() > playerList.get(i).getHandValue()) {
					System.out.println("Dealer has the bigger hand value!");
					dealerWins+=1;
				}
			
				System.out.println();
				System.out.println("Dealer has won " + dealerWins + " times");
				System.out.println("Player " + (i+1) + " has won " + playerWins[i] + " times");
			} // end of for loop
			
			System.out.println("\nWould you like to play again? [y/n]");
			if (input.next().equalsIgnoreCase("y")) {
				System.out.println("Let's play again!");
				for (int i = 0; i < playerList.size(); i++) {
					playerList.get(i).resetHand(); // reset every player's hand
				}
				dealer.resetHand(); // clear the dealer's hand
				hit = true; // reset hit to true for the game to be played again
				dealer = new Dealer(); // essentially reset the deck
			} else {
				System.out.println("Thanks for playing");
				keepPlaying = false; // end of the while loop controlling the game
			}
		

		} // end of while loop

	} // end of playGame
	
	// deals cards to each player
	public void dealToPlayers() {
		for (int i = 0; i < playerList.size(); i++) {
			playerList.get(i).addCardToHand(dealer.deal());
		}
	}
	
	// tell the player if they busted or got a blackjack before moving onto the next player
	public String showHandStatus(Player player) {
		if (player.getHandValue() > 21) {
			return "Player busted!";
		}
		else if (player.getHandValue() == 21) {
			return "Blackjack!";
		}
		
		return "";
		
	}

	public static void main(String args[]) {
		BlackJack game = new BlackJack();
		game.playGame();
	}
}