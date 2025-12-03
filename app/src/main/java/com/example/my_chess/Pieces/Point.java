package com.example.my_chess.Pieces;

public class Point {
    private int x;
    private int y;
    private boolean takes;
    public Point(int y, int x){
        this.x = x;
        this.y = y;
        takes = false;
    }
    public Point(int y, int x, boolean takes){
        this.x = x;
        this.y = y;
        this.takes = takes;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean Takes() {
        return takes;
    }
}
