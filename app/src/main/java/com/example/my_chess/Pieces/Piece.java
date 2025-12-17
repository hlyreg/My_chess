package com.example.my_chess.Pieces;

import com.example.my_chess.Game.Board;
import com.example.my_chess.Game.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    protected Point place;
    protected int colour;  // player = 0 : white, player = 1 : black.
    protected int ID;
    protected Player player;
    protected boolean isAlive;

    protected Piece(Point place, int colour, Player player, int ID){
        this.place = place;
        this.player = player;
        this.colour = colour;
        this.ID = ID;
        this.isAlive = true;

    }
    public abstract List<Point> getMoves( Board board, boolean trigger, Player opponent);

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

    public boolean isCheck(Player opponent, int id, Point move, Board board){
        Point KingPlace = this.player.getPieces()[15].getPlace();

        Piece moving = player.getPieces()[id];      // what piece is moving
        Board newBoardCheck = new Board(board, moving.getPlace(), move);        // a new board which represents what would happen if the move was made
        List<Point> opponentMoves = new ArrayList<>();

        // goes one by one getting all the possible moves of the opponent in the case of this move
        for (int i = 0; i < 16; i++){
            opponentMoves.addAll(opponent.getPieces()[i].getMoves(newBoardCheck, false, opponent));
        }
        //then checks if the opponent has the option to kill the king
        if(opponentMoves.contains(KingPlace))
            return true;

        return false;

    }

    public Point getPlace(){
        return this.place;
    }
}
