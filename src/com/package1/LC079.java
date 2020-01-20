package com.package1;

public class LC079 {

    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0))
                {
                    visited = new boolean[board.length][board[0].length];
                   if (exist(board,word,i,j,0)) return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int i, int j,int pos){
        if (pos == word.length()-1){
            return true;
        }

        boolean flag = false;
        visited[i][j] = true;
        char next = word.charAt(pos+1);
        if (i+1 < board.length && next == board[i+1][j] && !visited[i+1][j]){
            flag = exist(board,word,i+1,j,pos+1);
            if (flag) return true;
            visited[i+1][j] = false;
        }

        if (i>0 && next == board[i-1][j] && !visited[i-1][j]){
            flag = exist(board,word,i-1,j,pos+1);
            if (flag) return true;
            visited[i-1][j] = false;
        }

        if (j+1 < board[0].length && next == board[i][j+1] && !visited[i][j+1]){
            flag = exist(board,word,i,j+1,pos+1);
            if (flag) return true;
            visited[i][j+1] = false;
        }

        if (j>0 && next == board[i][j-1] && !visited[i][j-1]){
            flag = exist(board,word,i,j-1,pos+1);
            if (flag) return true;
            visited[i][j-1] = false;
        }
        return false;
    }
}
