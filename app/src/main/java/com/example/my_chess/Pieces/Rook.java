package com.example.my_chess.Pieces;

import com.example.my_chess.Game.Board;
import com.example.my_chess.Game.Player;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{
    private boolean moved;  //for castling

    public Rook(Point place, int colour, Player player, int ID){
        super(place, colour, player, ID);
        this.moved = false;
    }

    @Override
    public List<Point> getMoves(Board current_board, boolean trigger, Player opponent) {
        int x = this.place.getX();
        int y = this.place.getY();
        String[][] board = current_board.getBoard();
        List<Point> moves = new ArrayList<>();

//___________________________UP_______________________________________________
        int tryY = y++;

        //run till you hit something (edge or piece)
        while(tryY < 8 && isEmpty(board, tryY, x) &&
                !isCheck(opponent, this.ID, new Point(tryY, x), current_board)){
            moves.add(new Point(tryY, x));
            tryY++;
        }
        // if it's not an edge that was hit, check if it is an opponent piece that can be taken
        if(tryY < 8 && !isComrade(board, tryY, x) &&
                !isCheck(opponent, this.ID, new Point(tryY, x, true), current_board))
            moves.add(new Point(tryY, x, true));

//__________________________Left____________________________________________

        int tryX = x--;

        while(tryX >= 0 && isEmpty(board, y, tryX) &&
                !isCheck(opponent, this.ID, new Point(y, tryX), current_board)){
            moves.add(new Point(y, tryX));
            tryX--;
        }
        if(tryX >= 0 &&!isComrade(board, y, tryX) &&
                !isCheck(opponent, this.ID, new Point(y, tryX, true), current_board))
            moves.add(new Point(y, tryX, true));

//__________________________Down___________________________________________

        tryY = y--;
        while(tryY >= 0 && isEmpty(board, tryY, x) &&
                !isCheck(opponent, this.ID, new Point(tryY, x), current_board)){
            moves.add(new Point(tryY, x));
            tryY--;
        }
        if(tryY >= 0 && !isComrade(board, tryY, x) &&
                !isCheck(opponent, this.ID, new Point(tryY, x, true), current_board))
            moves.add(new Point(tryY, x, true));

//____________________________Right______________________________________

        tryX = x++;
        while(tryX < 8 && isEmpty(board, y, tryX) &&
                !isCheck(opponent, this.ID, new Point(y, tryX), current_board)){
            moves.add(new Point(y, tryX));
            tryX++;
        }
        if(tryX < 8 &&  !isComrade(board, y, tryX) &&
                !isCheck(opponent, this.ID, new Point(y, tryX, true), current_board))
            moves.add(new Point(y, tryX, true));
//_______________________________________________________________________________


        return moves;
    }

    @Override
    public void move(Point newPlace) {
        this.place = newPlace;
        this.moved = true;
    }
    public void castling(Board board){  //!!!!!!!!!!!!!!!!!!! - after the King do this
        /*if(!this.moved){

        }*/

    }

}
