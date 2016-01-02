import java.util.Scanner;

public class TicTacToeMain {
	
	public static void main(String[] args) {
		TicTacToeBoard board = new TicTacToeBoard();
		TicTacToeGame game = new TicTacToeGame(board);
		boolean twoPlayer = true;
		
		Scanner player = new Scanner(System.in);
		System.out.println("Do you want to play a two player game(1) or againt the computer(2)? ");
		int choice = player.nextInt();
		if(choice == 1) {
			twoPlayer = true;
		}
		else if(choice == 2) {
			twoPlayer = false;
		}
		else {
			while(choice != 1 || choice != 2) {
				System.out.println("Invalid input!\nEnter 1 if you want to play a two player game or enter 2 if you want to play againt the computer. ");
				choice = player.nextInt();
				if(choice == 1) {
					twoPlayer = true;
				}
				else if(choice == 2) {
					twoPlayer = false;
				}
			}
		}
		if(twoPlayer) {
			System.out.println("Welcome to Tic Tac Toe!\n"
					+ "Player 1 is playing as X.\n"
					+ "Player 2 is playing as O.");
		}
		else {
			System.out.println("Welcome to Tic Tac Toe!\n"
					+ "You are playing as X.\n"
					+ "The Computer is playing as O.");
		}
		game.play(twoPlayer);
		player.close();
	}
}