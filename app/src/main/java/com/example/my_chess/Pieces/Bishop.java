package com.example.my_chess.Pieces;

import com.example.my_chess.Game.Board;
import com.example.my_chess.Game.Player;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece{

    public Bishop(Point place, int colour, Player player, int ID){
        super(place, colour, player, ID);
    }

    @Override
    public List<Point> getMoves(Board current_board, boolean trigger, Player opponent) {
        int x = this.place.getX();
        int y = this.place.getY();
        String[][] board = current_board.getBoard();
        List<Point> moves = new ArrayList<>();

//_________________________top right_______________________________________________
        int tryX = x++;
        int tryY = y++;
        //run till you hit something (edge or piece)
        while(tryX < 8 && tryY < 8 && isEmpty(board, tryY, tryX) &&
                !isCheck(opponent, this.ID, new Point(tryY, tryX), current_board)){
            moves.add(new Point(tryY, tryX));
            tryX++;
            tryY++;
        }
        // if it's not an edge that was hit, check if it is an opponent piece that can be taken
        if(tryX < 8 && tryY < 8 && !isComrade(board, tryY, tryX) &&
                !isCheck(opponent, this.ID, new Point(tryY, tryX, true), current_board))
            moves.add(new Point(tryY, tryX, true));

//__________________________top left____________________________________________

        tryX = x--;
        tryY = y++;
        while(tryX >= 0 && tryY < 8 && isEmpty(board, tryY, tryX) &&
                !isCheck(opponent, this.ID, new Point(tryY, tryX), current_board)){
            moves.add(new Point(tryY, tryX));
            tryX--;
            tryY++;
        }
        if(tryX >= 0 && tryY < 8 && !isComrade(board, tryY, tryX) &&
                !isCheck(opponent, this.ID, new Point(tryY, tryX, true), current_board))
            moves.add(new Point(tryY, tryX, true));

//__________________________bottom left___________________________________________

        tryX = x--;
        tryY = y--;
        while(tryX >= 0 && tryY >= 0 && isEmpty(board, tryY, tryX) &&
                !isCheck(opponent, this.ID, new Point(tryY, tryX), current_board)){
            moves.add(new Point(tryY, tryX));
            tryX--;
            tryY--;
        }
        if(tryX >= 0 && tryY >= 0 && !isComrade(board, tryY, tryX) &&
                !isCheck(opponent, this.ID, new Point(tryY, tryX, true), current_board))
            moves.add(new Point(tryY, tryX, true));

//____________________________bottom right_____________________________

        tryX = x++;
        tryY = y--;
        while(tryX < 8 && tryY >= 0 && isEmpty(board, tryY, tryX) &&
                !isCheck(opponent, this.ID, new Point(tryY, tryX), current_board)){
            moves.add(new Point(tryY, tryX));
            tryX++;
            tryY--;
        }
        if(tryX < 8 && tryY >= 0 && !isComrade(board, tryY, tryX) &&
                !isCheck(opponent, this.ID, new Point(tryY, tryX, true), current_board))
            moves.add(new Point(tryY, tryX, true));

//___________________________________________________________________________

        return moves;
    }


    @Override
    public void move(Point newPlace) {
        this.place = newPlace;
    }
}
