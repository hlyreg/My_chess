package Pieces;

import java.util.List;

public abstract class Piece {
    protected Point place;
    protected Point prev_place;
    protected int player;
    protected boolean isAlive;

    protected Piece(Point place, Point prev_place, int player){
        this.place = place;
        this.prev_place = prev_place;
        this.player = player;
        this.isAlive = true;
    }
    public abstract List<Point> getMoves();

    public void kill(){
        this.isAlive = false;
    }
}
