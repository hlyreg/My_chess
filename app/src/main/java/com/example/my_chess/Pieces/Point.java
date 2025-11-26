package com.example.my_chess.Pieces;

public class Point {
    private int x;
    private int y;
    private boolean takes;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
        takes = false;
    }
    public Point(int x, int y, boolean takes){
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
