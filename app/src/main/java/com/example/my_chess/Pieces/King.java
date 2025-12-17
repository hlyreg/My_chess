package com.example.my_chess.Pieces;

import com.example.my_chess.Game.Board;
import com.example.my_chess.Game.Player;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece{
    private boolean moved; // for casting

    public King(Point place, int colour, Player player, int ID){
        super(place, colour, player, ID);
        this.moved = false;
    }

    @Override
    public List<Point> getMoves(Board current_board, boolean trigger, Player opponent) {
        int x = this.place.getX();
        int y = this.place.getY();
        String[][] board = current_board.getBoard();
        List<Point> moves = new ArrayList<>();


        return moves;
    }

    @Override
    public void move(Point newPlace) {
        this.place = newPlace;
    }

}
