package com.example.my_chess.Pieces;

import com.example.my_chess.Game.Board;

import java.util.List;

public abstract class Piece {
    protected Point place;
    protected int player;  // player = 0 : white, player = 1 : black.
    protected boolean isAlive;

    protected Piece(Point place, int player){
        this.place = place;
        this.player = player;
        this.isAlive = true;
    }
    public abstract List<Point> getMoves( Board board, boolean trigger);

    public abstract void move(Point newPlace);

    public void kill(){
        this.isAlive = false;
    }

    public boolean isEmpty(String[][] board, int y, int x){
        return board[y][x].equals("-");
    }

    public boolean isComrade(String[][] board, int y, int x){
        String my_player = ""+this.player;
        String piece = board[y][x];
        return my_player.equals(""+piece.charAt(piece.length()-1));
    }
}
