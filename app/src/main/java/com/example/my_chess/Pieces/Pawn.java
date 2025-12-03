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
    public List<Point> getMoves(Board current_board) {
        int x = this.place.getX();
        int y = this.place.getY();
        String[][] board = current_board.getBoard();
        List<Point> moves = new ArrayList<>();
//_______________________________White_______________________________________________

        if(moved == 0 && this.player == 0 && isEmpty(board, 2, x)){  // if this is the pawn's first move and the player is white, check if it can move forward once and twice.
            moves.add(new Point(y++, x));
            if(isEmpty(board, 3, x))
                moves.add(new Point(y+2, x));
        }
        if(this.player == 0 && isEmpty(board, y++, x))  // check if it can move forward once as white.
            moves.add(new Point(y++, x));

        if(this.player == 0){       // check if white can take a piece
            if(!isEmpty(board, y++, x++)){
                moves.add(new Point(y++, x++, true));
            }
            if(!isEmpty(board, y++, x--)){
                moves.add(new Point(y++, x--, true));
            }
        }

//_________________________________Black________________________________________

        if(moved == 0 && this.player == 1 && board[5][x].equals("-")){  // if this is the pawn's first move and the player is black, check if it can move forward once and twice.
            moves.add(new Point(y--, x));
            if(board[4][x].equals("-"))
                moves.add(new Point(y-2, x));
        }
        if(this.player == 1 && board[y--][x].equals("-"))  // check if it can move forward once as black.
            moves.add(new Point(y--, x));


        if(this.player == 0){       // check if black can take a piece
            if(!isEmpty(board, y--, x++)){
                moves.add(new Point(y--, x++, true));
            }
            if(!isEmpty(board, y--, x--)){
                moves.add(new Point(y--, x--, true));
            }
        }


        return moves;
    }
}
