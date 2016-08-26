package matrix;

public class SurroundedRegions {
	//Given a 2D board containing 'X' and 'O', capture all regions surrounded 
	//by 'X'. A region is captured by flipping all 'O's into 'X's in that 
	//surrounded region.
	public static void main(String[] args) {
		char[][] board = {{'X','X','X','X'},
				{'X','O','O','X'},
				{'X','X','O','X'},
				{'X','O','X','O'}};
		
		surroundedRegions(board);
		
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}

	}

	private static void surroundedRegions(char[][] board) {
		int m = board.length;
		int n = board[0].length;
		// if all entries on the boarders are 'X', then every entry in the board
		// can be transformed into 'X'
		// so we start merging from the boarders
		
		// merge O's on left & right boarders
		for(int i=0;i<m;i++){
			if(board[i][0] == 'O')
				merge(board,i,0,m,n);
			if(board[i][n-1] == 'O')
				merge(board,i,n-1,m,n);
		}
		
		// merge O's on top & bottom boarders
		for(int j=0;j<n;j++){
			if(board[0][j] == 'O')
				merge(board,0,j,m,n);
			if(board[m-1][j] == 'O')
				merge(board,m-1,j,m,n);
		}
		
		// process the board
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(board[i][j] == '#'){
					board[i][j] = 'O';
				}else if(board[i][j] == 'O'){
					board[i][j] = 'X'; // change all un-traversed 'O' into 'X'
				}
			}
		}
	}

	private static void merge(char[][] board, int i, int j, int m, int n) {
		if(i<0 || i>m-1 || j<0 || j>n-1 || board[i][j] != 'O')
			return;
		
		board[i][j] = '#';
		
		merge(board,i-1,j,m,n);
		merge(board,i+1,j,m,n);
		merge(board,i,j-1,m,n);
		merge(board,i,j+1,m,n);
		
	}

}
