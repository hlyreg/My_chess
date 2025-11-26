package com.example.my_chess.Pieces;

import com.example.my_chess.Game.Board;

import java.util.List;

public abstract class Piece {
    protected Point place;
    protected Point prev_place;
    protected int player;  // player = 0 : white, player = 1 : black.
    protected boolean isAlive;

    protected Piece(Point place, Point prev_place, int player){
        this.place = place;
        this.prev_place = prev_place;
        this.player = player;
        this.isAlive = true;
    }
    public abstract List<Point> getMoves( Board board);

    public void kill(){
        this.isAlive = false;
    }
}
