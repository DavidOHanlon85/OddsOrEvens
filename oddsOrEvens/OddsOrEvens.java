/**
 * 
 */
package oddsOrEvens;

import java.util.Random;
import java.util.Scanner;

/**
 * Odds and Even v.01 27/05/2024
 */
public class OddsOrEvens {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Introduction

		System.out.println("Welcome to Odds or Evens");

		System.out.println();

		// Game selection

		int stake = 0;

		System.out.println("Select your stake and we will find you an opponent");
		System.out.println("1. $1");
		System.out.println("2. $5");
		System.out.println("3. $10");
		System.out.println("4. $50");
		System.out.println("5. $100");
		System.out.println("6. $500");

		Scanner sc = new Scanner(System.in);

		stake = sc.nextInt();
		sc.nextLine();

		switch (stake) {
		case 1:
			System.out.println("$1 games - Good luck!");
			break;
		case 2:
			System.out.println("$5 games - Good luck!");
			break;
		case 3:
			System.out.println("$10 games - Good luck!");
			break;
		case 4:
			System.out.println("$50 games - Good luck!");
			break;
		case 5:
			System.out.println("$100 games - Good luck!");
			break;
		case 6:
			System.out.println("$500 games - Good luck!");
			break;
		default:
			System.out.println("Please choose a valid game");
			break;
		}
		while (stake < 1 && stake > 6)
			;

		// The Game

		char playAgain = '0';
		int round = 1;

		do {
			Random rand = new Random();

			System.out.println();
			System.out.println("The rules are simple: Choose Odds or Evens");
			System.out.println("Two coins of the same face = Evens");
			System.out.println("Two coins of different faces = Odds");
			System.out.println("Players make prediction on alternate rounds");

			System.out.println();

			int player;

			if (round % 2 != 0) {
				player = 1;
			} else {
				player = 2;
			}

			System.out.printf("Player %s - What is your prediction? - ODDS or EVENS", player);

			String playerPrediction = sc.nextLine();

			do {
				if (playerPrediction.equalsIgnoreCase("Odds")) {
					playerPrediction = "Odds";
					System.out.println("You've chosen ODDS!");
				} else if (playerPrediction.equalsIgnoreCase("Evens")) {
					playerPrediction = "Evens";
					System.out.println("You've chosen EVENS!");
				} else {
					System.out.println("Invalid input - try again");
					playerPrediction = sc.nextLine();
				}
			} while (!playerPrediction.equalsIgnoreCase("Odds") && !playerPrediction.equalsIgnoreCase("Evens"));

			System.out.println("Here we go!");

			int player1CoinResult = rand.nextInt(1, 3);
			String player1Coin;

			if (player1CoinResult == 1) {
				player1Coin = "Heads";
			} else {
				player1Coin = "Tails";
			}

			int player2CoinResult = rand.nextInt(1, 3);
			String player2Coin;

			if (player2CoinResult == 1) {
				player2Coin = "Heads";
			} else {
				player2Coin = "Tails";
			}

			String gameResult;

			System.out.println();
			System.out.printf("****** GAME %s ******", round);
			System.out.println();
			round++;

			if (player1CoinResult == player2CoinResult) {
				gameResult = "Evens";
			} else {
				gameResult = "Odds";
			}

			System.out.printf("Player 1's coin: %s \n", player1Coin);
			System.out.printf("Player 2's coin: %s \n", player2Coin);

			if (playerPrediction.toUpperCase().equalsIgnoreCase(gameResult.toUpperCase())) {
				System.out.printf("It's %s - Player %d wins", playerPrediction, player);
			} else {
				System.out.printf("It's %s - Player %d losses", playerPrediction, player);
			}

			System.out.println("\nShall we play again? - Y/ N");
			playAgain = sc.nextLine().charAt(0);

			if (playAgain == 'y' || playAgain == 'Y') {
				playAgain = 'Y';
			} else {
				playAgain = 'N';
			}

		} while (playAgain == 'Y');

	}

}
