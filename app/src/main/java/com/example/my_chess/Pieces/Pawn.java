package com.example.my_chess.Pieces;

import com.example.my_chess.Game.Board;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    private int moved;  // if moved = 0, it hasn't moved yet, if it's 2, it moved 2, if it's 1, that means it's moved once since it was 2 or 0.


    public Pawn(Point place, int player){
        super(place, player);
        this.moved = 0;
    }

    @Override
    public List<Point> getMoves(Board current_board, boolean is_twice) {
        int x = this.place.getX();
        int y = this.place.getY();
        String[][] board = current_board.getBoard();
        List<Point> moves = new ArrayList<>();
//_______________________________White_______________________________________________

        if(moved == 0 && this.player == 0 && isEmpty(board, 2, x)){  // if this is the pawn's first move and the player is white, check if it can move forward once and twice.
            moves.add(new Point(y++, x));
            if(isEmpty(board, 3, x))
                moves.add(new Point(y+2, x, false, true));
        }
        if(y++ < 8) {
            if (this.player == 0 && isEmpty(board, y++, x))  // check if it can move forward once as white.
                moves.add(new Point(y++, x));

            if (this.player == 0 && x++ < 8) {       // check if white can take a piece
                if (!isEmpty(board, y++, x++)) {
                    moves.add(new Point(y++, x++, true));
                }
                if (x-- >= 0 && !isEmpty(board, y++, x--)) {
                    moves.add(new Point(y++, x--, true));
                }
            }

            if(this.player == 0 && place.getY() == 4 && x++ < 8 && board[4][x++].equals("Pawn-1") && is_twice)      // check if un poissant is possible
                moves.add(new Point(5, x++, true));
            if(this.player == 0 && place.getY() == 4 && x-- >= 0 && board[4][x--].equals("Pawn-1") && is_twice)
                moves.add(new Point(5, x--, true));
        }

//_________________________________Black________________________________________

        if(moved == 0 && this.player == 1 && isEmpty(board, 5, x)){  // if this is the pawn's first move and the player is black, check if it can move forward once and twice.
            moves.add(new Point(y--, x));
            if(isEmpty(board, 4, x))
                moves.add(new Point(y-2, x, false, true));
        }

        if(y-- >= 0) {
            if (this.player == 1 && isEmpty(board, y--, x))  // check if it can move forward once as black.
                moves.add(new Point(y--, x));


            if (this.player == 1 && x++ < 8) {       // check if black can take a piece
                if (!isEmpty(board, y--, x++))
                    moves.add(new Point(y--, x++, true));

                if (x-- >= 0 && !isEmpty(board, y--, x--))
                    moves.add(new Point(y--, x--, true));


                if(this.player == 1 && place.getY() == 3 && x++ < 8 && board[3][x++].equals("Pawn-0") && is_twice)      // check if un poissant is possible
                    moves.add(new Point(2, x++, true));

                if(this.player == 1 && place.getY() == 3 && x-- >= 0 && board[3][x--].equals("Pawn-0") && is_twice)
                    moves.add(new Point(2, x--, true));
            }

        }


        return moves;
    }

    public void move(Point new_place){ // the function that changes the location of the pawn
        this.place = new_place;

        if(this.moved == 0)     //did it move for the first time
            this.moved = 1;
        if(new_place.isPawn_twice())    // did it move twice
            this.moved = 2;
    }

    public void cancel_twice(){     // turns off the lamp that signals if un poissant is possible
        this.moved = 1;
    }
}
