package com.algo.graph.dfs;

public class BattleshipsInABoard {

	public static void main(String[] args) {
		char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
		System.out.println(new BattleshipsInABoard().countBattleships(board));
	}

    public int countBattleships(char[][] board) {
    	int count = 0;
		for(int i = 0; i < board.length; i++ ) {
			for(int j = 0; j < board[0].length; j++ ) {
				if(board[i][j] == 'X') {
					count = count + 1;
					markBattleshipsByDFS(board, i, j);
				}
			}
		}
		return count;
        
    }

	private void markBattleshipsByDFS(char[][] board, int i, int j) {
        if( i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'X' ) return;
        board[i][j] = '-';
        markBattleshipsByDFS(board, i - 1, j);
        markBattleshipsByDFS(board, i + 1, j);
        markBattleshipsByDFS(board, i, j - 1);
        markBattleshipsByDFS(board, i, j + 1);
	}
}
