package matrix;

public class WordSearch {
	//Given a 2D board and a word, find if the word exists in the grid.
	//The word can be constructed from letters of sequentially adjacent
	//cell, where "adjacent" cells are those horizontally or vertically 
	//neighboring. The same letter cell may not be used more than once.
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'},
				{'W','X','Y','Z'},};
		String word = "SEE";
		System.out.println(wordExists(board,word));
	}

	private static boolean wordExists(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;

		boolean result = false;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(dfs(board,word,i,j,0))
					result = true; // once find the word, result is true
			}
		}
		return result;
	}

	private static boolean dfs(char[][] board, String word, int i, int j, int k) {
		int m = board.length;
		int n = board[0].length;
		
		if(i<0 || i>m-1 || j<0 || j>n-1)
			return false;
		
		if(board[i][j] == word.charAt(k)){
			char temp = board[i][j];
			board[i][j] = '#'; // since the same letter can be used
								// only once, temporarily change it to '#'
			
			if(k == word.length()-1){ // the entire word has checked
				board[i][j] = temp; // change it back to the original letter
				return true;
			}
			if(dfs(board,word,i-1,j,k+1) ||
					dfs(board,word,i+1,j,k+1) ||
					dfs(board,word,i,j-1,k+1) ||
					dfs(board,word,i,j+1,k+1)){
				board[i][j] = temp;
				return true;
			}
			board[i][j] = temp;
		}
		return false;
	}

}
