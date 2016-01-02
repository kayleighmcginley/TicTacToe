import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeGame {

	private TicTacToeBoard myBoard;
	private Scanner scanner;

	public TicTacToeGame(TicTacToeBoard board) {
		board = new TicTacToeBoard();
	}

	public int[] chooseSquare(char piece) {
		
		int i;
		int j;
		
		try {
			scanner = new Scanner(System.in);
			System.out.println("Select a row(1-3).");
			i = scanner.nextInt();
			while(i > 3 || i < 1 ) {
				System.out.println("Invalid.\nSelect a row between 1 and 3 (1, 2 or 3).");
				i = scanner.nextInt();
			}
			System.out.println("Select a column(1-3).");
			j = scanner.nextInt();
			while(j > 3 || j < 1 ) {
				System.out.println("Invalid.\nSelect a column between 1 and 3 (1, 2 or 3).");
				j = scanner.nextInt();
			}
			
			int[] tmp = new int[2];
			tmp[0] = i;
			tmp[1] = j;
	
			return tmp;
		}
		catch(InputMismatchException e) {
			System.exit(0);
		}
		return null;
	}

	public void play(boolean twoPlayer) {
		myBoard = new TicTacToeBoard();
		boolean p1Turn = true;
		boolean notFull = true;
		int i = 0;
		int j = 0;
		int[] coOrds;
		
		do {
			scanner = new Scanner(System.in);

			System.out.println(myBoard.toString());
			
			if(p1Turn) {
				System.out.println("Player 1's Turn:");
				coOrds = chooseSquare('X');
				i = coOrds[0]; 
				j = coOrds[1];
				if(!myBoard.move('X', i-1, j-1)) {
					System.out.println("This box is taken! Try Again:");
					coOrds = chooseSquare('X');
					i = coOrds[0]; 
					j = coOrds[1];
				}
				myBoard.move('X', i-1, j-1);
				p1Turn = false;
			}
			else {
				if(twoPlayer) {
					System.out.println("Player 2's Turn:");
					coOrds = chooseSquare('O');
					i = coOrds[0]; 
					j = coOrds[1];
					if(!myBoard.move('O', i-1, j-1)) {
						System.out.println("This box is taken! Try Again:");
						coOrds = chooseSquare('O');
						i = coOrds[0]; 
						j = coOrds[1];
					}
					myBoard.move('O', i-1, j-1);
					p1Turn = true;
				}
				else {
					System.out.println("Computer's Turn:");
					myBoard.compMove();
					p1Turn = true;
				}
			}

			if(myBoard.winner() != ' ') {
				String winner = ""; 
				if(twoPlayer) {
					if(myBoard.winner() == 'O') {
						winner = "Player 2";
					}
					else {
						winner = "Player 1";
					}
				}
				else {
					if(myBoard.winner() == 'O') {
						winner = "Sorry, The Computer";
					}
					else {
						winner = "Congratulations, You";
					}
				}
				System.out.println(myBoard.toString());
				System.out.println(winner + " Won!");
				break;
			}
			if(myBoard.isBoardFull()) {
				System.out.println(myBoard.toString());
				System.out.println("Game Over! Draw!");
				break;
			}
		} while(notFull);
	}
}
