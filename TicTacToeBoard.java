import java.util.Random;


public class TicTacToeBoard {

	public char[][] board;
	private final char O = 'O';

	public TicTacToeBoard() {
		board = new char[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}

	public boolean isSquareFull(int i, int j) {
		if(board[i][j] != ' ') {
			return true;
		}
		return false;
	}

	public boolean move(char piece, int i, int j) {
		if(!isSquareFull(i, j)) {
			board[i][j] = piece;
			return true;
		}
		return false;		
	}

	public boolean isBoardFull() {
		boolean full = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == ' ') {
					full = false;
				}
			}
		}
		return full;
	}

	public char winner() {
		if(board[1][0] == board[1][1] && board[1][0] == board[1][2]			//4=5=6
				|| board[0][1] == board[1][1] && board[0][1] == board[2][1]			//2=5=8
						|| board[0][0] == board[1][1] && board[0][0] == board[2][2]			//1=5=9
								|| board[0][2] == board[1][1] && board[0][2] == board[2][0]) {		//3=5=7
			return board[1][1];
		}
		else if(board[0][0] == board[0][1] && board[0][0] == board[0][2]			//1=2=3
				|| board[0][0] == board[1][0] && board[0][0] == board[2][0]) {			//1=4=7
			return board[0][0];
		}
		else if (board[2][0] == board[2][1] && board[2][0] == board[2][2]		//7=8=9
				|| board[0][2] == board[1][2] && board[0][2] == board[2][2]) {		//3=6=9	
			return board[2][2];
		}
		return ' ';
	}

	public String toString() {

		String s = 
				"     1   2   3    \n" +    
				"   ┌───┬───┬───┐ \n" +
				" 1 │ "+board[0][0]+" │ "+board[0][1]+" │ "+board[0][2]+" │ \n" +
				"   ├───┼───┼───┤ \n" +
				" 2 │ "+board[1][0]+" │ "+board[1][1]+" │ "+board[1][2]+" │ \n" +
				"   ├───┼───┼───┤ \n" +
				" 3 │ "+board[2][0]+" │ "+board[2][1]+" │ "+board[2][2]+" │ \n" +
				"   └───┴───┴───┘ ";
		
		return s;
	}

	public void compMove() {
    	//first row
    	if(board[0][0] == board[0][1] && board[0][0] != ' ' && board[0][2] == ' ') {
    	   move(O, 0, 2);
    	}
    	else if(board[0][0] == board[0][2] && board[0][0] != ' ' && board[0][1] == ' ') {
    	   move(O, 0, 1);
    	}
    	else if(board[0][1] == board[0][2] && board[0][1] != ' ' && board[0][0] == ' ') {
    	   move(O, 0, 0);
    	}
    	//second row
    	else if(board[1][0] == board[1][1] && board[1][0] != ' ' && board[1][2] == ' ') {
    		move(O, 1, 2);
    	}
    	else if(board[1][0] == board[1][2] && board[1][0] != ' ' && board[1][1] == ' ') {
    		move(O, 1, 1);
    	}
    	else if(board[1][1] == board[1][2] && board[1][1] != ' ' && board[1][0] == ' ') {
    		move(O, 1, 0);
    	}
    	//third row
    	else if(board[2][0] == board[2][1] && board[2][0] != ' ' && board[2][2] == ' ') {
    		move(O, 2, 2);
    	}
    	else if(board[2][0] == board[2][2] && board[2][0] != ' ' && board[2][1] == ' ') {
    		move(O, 2, 1);
    	}
    	else if(board[2][1] == board[2][2] && board[2][1] != ' ' && board[2][0] == ' ') {
    		move(O, 2, 0);
    	}
    	//first column
    	else if(board[0][0] == board[1][0] && board[0][0] != ' ' && board[2][0] == ' ') {
    		move(O, 2, 0);
    	}
    	else if(board[0][0] == board[2][0] && board[0][0] != ' ' && board[1][0] == ' ') {
    		move(O, 1, 0);
    	}
    	else if(board[1][0] == board[2][0] && board[1][0] != ' ' && board[0][0] == ' ') {
    		move(O, 0, 0);
    	}
    	//second column
    	else if(board[0][1] == board[1][1] && board[0][1] != ' ' && board[2][1] == ' ') {
    		move(O, 2, 1);
    	}
    	else if(board[0][1] == board[2][1] && board[0][1] != ' ' && board[1][1] == ' ') {
    		move(O, 1, 1);
    	}
    	else if(board[1][1] == board[2][1] && board[1][1] != ' ' && board[0][1] == ' ') {
    		move(O, 0, 1);
    	}
    	//third column
    	else if(board[0][2] == board[1][2] && board[0][2] != ' ' && board[2][2] == ' ') {
    		move(O, 2, 2);
    	}
    	else if(board[0][2] == board[2][2] && board[0][2] != ' ' && board[1][2] == ' ') {
    		move(O, 1, 2);
    	}
    	else if(board[1][2] == board[2][2] && board[1][2] != ' ' && board[0][2] == ' ') {
    		move(O, 0, 2);
    	}
    	//first diagonal
    	else if(board[0][0] == board[1][1] && board[0][0] != ' ' && board[2][2] == ' ') {
    		move(O, 2, 2);
    	}
    	else if(board[0][0] == board[2][2] && board[0][0] != ' ' && board[1][1] == ' ') {
    		move(O, 1, 1);
    	}
    	else if(board[1][1] == board[2][2] && board[1][1] != ' ' && board[0][0] == ' ') {
    		move(O, 0, 0);
    	}
    	//second diagonal
    	else if(board[0][2] == board[1][1] && board[0][2] != ' ' && board[2][0] == ' ') {
    		move(O, 2, 0);
    	}
    	else if(board[0][2] == board[2][0] && board[0][2] != ' ' && board[1][1] == ' ') {
    		move(O, 1, 1);
    	}
    	else if(board[1][1] == board[2][0] && board[1][1] != ' ' && board[0][2] == ' ') {
    		move(O, 0, 2);
    	}
    	//or random
    	else {
    		Random rand = new Random();
    		int i = rand.nextInt(3);
    		int j = rand.nextInt(3);
    		if(board[i][j] == ' ') {
    			move(O, i, j);
    		}
    		else {
    			i = rand.nextInt(3);
        		j = rand.nextInt(3);
        		move(O, i, j);
    		}
    		
    	}
    }
}