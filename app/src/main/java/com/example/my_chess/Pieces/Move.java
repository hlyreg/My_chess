package com.example.my_chess.Pieces;

public class Move {
    private Point prev_place;
    private Point next_place;
    private boolean kills;

    public Move(Point prev, Point next, boolean kills){
        this.prev_place = prev;
        this.next_place = next;
        this.kills = kills;
    }

    public Point getPrev_place() {
        return prev_place;
    }

    public Point getNext_place() {
        return next_place;
    }

    public boolean getKills() {
        return kills;
    }

}
