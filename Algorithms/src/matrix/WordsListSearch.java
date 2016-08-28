package matrix;

import java.util.ArrayList;
import java.util.List;

public class WordsListSearch {
	//Given a 2D board and a list of words from the dictionary, 
	//find all words in the board.

	//Each word must be constructed from letters of sequentially 
	//adjacent cell, where "adjacent" cells are those horizontally or 
	//vertically neighboring. The same letter cell may not be used more
	//than once in a word.
	public static void main(String[] args) {
		char[][] board = {{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}};
		String[] words = {"oath","pea","hk","rain"};
		System.out.println(findWords(board,words));
		
	}

	private static List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<String>();
		
		int m = board.length;
		int n = board[0].length;
		
		for(String word: words){
			boolean exist = false;
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					//========================Note========================
					// if doesn't change letters back in dfs(...), before 
					// each search, need copy a new board as below!!!!!!
					// then call "copyBoard" in dfs(...)
					//====================================================
					
					/*char[][] copyBoard = new char[m][n];
					for(int x=0;x<m;x++){
						for(int y=0;y<n;y++){
							copyBoard[x][y] = board[x][y];
						}
					}*/
					
					if(dfs(board,word,i,j,0))
						exist = true;
				}
			}
			if(exist)
				result.add(word);
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
			board[i][j] = '#';
			
			if(k == word.length()-1){
				board[i][j] = temp; // change it back to the original letter
				return true;
			}
			if(dfs(board,word,i-1,j,k+1) ||
					dfs(board,word,i+1,j,k+1) ||
					dfs(board,word,i,j-1,k+1) ||
					dfs(board,word,i,j+1,k+1)){
				board[i][j] = temp; // change it back to the original letter
				return true;
			}
			board[i][j] = temp; // change it back to the original letter
		}
		return false;
	}

}
