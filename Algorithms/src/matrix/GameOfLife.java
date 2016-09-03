package matrix;

public class GameOfLife {
	//Given a board with m by n cells, each cell has an initial state live (1) or 
	//dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules:

	//Any live cell with fewer than two live neighbors dies, as if caused by under-population.
	//Any live cell with two or three live neighbors lives on to the next generation.
	//Any live cell with more than three live neighbors dies, as if by over-population..
	//Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

	//Write a function to compute the next state (after one update) of the board given its current state.
	public static void main(String[] args) {
		int[][] board = {{0,1,0,0},
				{1,1,1,1},
				{0,1,0,1},
				{1,0,0,0}};
		
		if(board == null || board.length == 0)
			System.out.println("empty board");
		
		int m = board.length;
		int n = board[0].length;
		
		int[] x = {-1,-1,-1,0,0,1,1,1};
		int[] y = {-1,0,1,-1,1,-1,0,1};
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				int count = 0;
				for(int k=0;k<8;k++){
					int nx=i+x[k];
					int ny=j+y[k];
					
					if(nx >= 0 && nx <= m-1 && ny >=0 && ny <= n-1 && ((board[nx][ny] & 1) == 1)){
						// there are FOUR different scenarios:
						// origin cell is 1, 1&1=1; then it becomes 01, 01&1=01 (seen as 1)
						// origin cell is 1, 1&1=1; then it becomes 11, 11&1=01 (seen as 1)
						// origin cell is 1, 1&1=1; then it becomes 01, 01&1=01 (seen as 1)
						// origin cell is 0, 1&1=1; then it becomes 10, 10&1=00 (seen as 0)
						// so, in each scenario, the answer of (board[nx][ny] & 1) does NOT change
						count++;
					}
				}
				
				// Any live cell with fewer than two live neighbors dies
				if(count < 2)
//scenario 1     	// if board[i][j]=1, 1&1=1 (or seen as 01) (right shift 1 bit to be 0)
					// if board[i][j]=0, 0&1=0 (or seen as 00) (right shift 1 bit to be 0)
					board[i][j] &= 1;
				
				// Any live cell with two or three live neighbors lives
				if(count == 2 || count == 3)
//scenario 2		// if board[i][j]=1, 1|10=11 (right shift 1 bit to be 1)
					// if board[i][j]=0, 0|00=00 (right shift 1 bit to be 0)
					board[i][j] |= board[i][j] << 1;
				
				// Any live cell with more than three live neighbors dies
				if(count > 3)
//scenario 3		// if board[i][j]=1, 1&1=1 (or seen as 01) (right shift 1 bit to be 0)
					// if board[i][j]=0, 0&1=0 (or seen as 00) (right shift 1 bit to be 0)
					board[i][j] &= 1;
				
				// Any dead cell with exactly three live neighbors becomes a live cell
				if(count == 3)
//scenario 4		// if board[i][j]=0, 0&10=10 (right shift 1 bit to be 1)
					// if board[i][j]=1, 1|10=11 (right shift 1 bit to be 1)
					board[i][j] |= 2;
			}
		}
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				// right shift
				// 01 --> 0
				// 11 --> 1
				// 01 --> 0
				// 10 --> 1
				// all answers match those four scenarios respectively
				board[i][j] = board[i][j] >> 1;
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}

}
