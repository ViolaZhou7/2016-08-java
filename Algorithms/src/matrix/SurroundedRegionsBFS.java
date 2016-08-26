package matrix;

import java.util.LinkedList;

public class SurroundedRegionsBFS {
	// use BFS
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
		
		// left & right boarders
		for(int i=0;i<m;i++){
			if(board[i][0] == 'O')
				bfs(board,i,0,m,n);
		}
		for(int i=0;i<m;i++){
			if(board[i][n-1] == 'O')
				bfs(board,i,n-1,m,n);
		}
		
		// merge O's on top & bottom boarders
		for(int j=0;j<n;j++){
			if(board[0][j] == 'O')
				bfs(board,0,j,m,n);
		}
		for(int j=0;j<n;j++){
			if(board[m-1][j] == 'O')
				bfs(board,m-1,j,m,n);
		}
		
		// traverse the board
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(board[i][j] == 'O'){
					board[i][j] = 'X';
				}else if(board[i][j] == '#'){
					board[i][j] = 'O';
				}
			}
		}
		
	}

	private static void bfs(char[][] board, int o, int p, int m, int n) {
		int index = o*n+p;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.offer(index); // add the element at tail
		board[o][p] = '#';
		
		while(!queue.isEmpty()){
			int top = queue.poll(); // remove the element at head
			int i = top/n;
			int j = top%n;
			
			if(i-1 >= 0 && board[i-1][j] == 'O'){
				queue.offer((i-1)*n+j);
				board[i-1][j] = '#';
			}
			
			if(i+1 <= m-1 && board[i+1][j] == 'O'){
				queue.offer((i+1)*n+j);
				board[i+1][j] = '#';
			}
			
			if(j-1 >= 0 && board[i][j-1] == 'O'){
				queue.offer(i*n+j-1);
				board[i][j-1] = '#';
			}
			
			if(j+1 <= n-1 && board[i][j+1] == 'O'){
				queue.offer(i*n+j+1);
				board[i][j+1] = '#';
			}
		}
	}

}
