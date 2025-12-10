package com.example.my_chess.Pieces;

public class Point {
    private int x;
    private int y;
    private boolean takes;
    private boolean pawn_twice;
    public Point(int y, int x){
        this.x = x;
        this.y = y;
        takes = false;      // does the move kill a piece
        pawn_twice = false;     // does a pawn move twice, so that un poissant is possible
    }
    public Point(int y, int x, boolean takes){
        this.x = x;
        this.y = y;
        this.takes = takes;
    }

    public Point(int y, int x, boolean takes, boolean twice){
        this.x = x;
        this.y = y;
        this.takes = takes;
        this.pawn_twice = twice;
    }



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isTakes() {
        return takes;
    }

    public boolean isPawn_twice() {
        return pawn_twice;
    }
}
