package com.example.my_chess.Pieces;

import com.example.my_chess.Game.Board;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(Point place, Point prev_place, int player){
        super(place, prev_place, player);
    }

    @Override
    public List<Point> getMoves(Board current_board) {
        int x = this.place.getX();
        int y = this.place.getY();
        String[][] board = current_board.getBoard();
        List<Point> moves = new ArrayList<>();
//_______________________________White_______________________________________________

        if(y == 1 && this.player == 0 && board[2][x].equals("-")){  // if this is the pawn's first move and the player is white, check if it can move forward once and twice.
            moves.add(new Point(x, y++));
            if(board[3][x].equals("-"))
                moves.add(new Point(x, y+2));
        }
        if(this.player == 0 && board[y++][x].equals("-"))  // check if it can move forward once as white.
            moves.add(new Point(x, y++));

        if(this.player == 0)


//_________________________________Black________________________________________

        if(y == 6 && this.player == 1 && board[5][x].equals("-")){  // if this is the pawn's first move and the player is white, check if it can move forward once and twice.
            moves.add(new Point(x, y--));
            if(board[4][x].equals("-"))
                moves.add(new Point(x, y-2));
        }
        if(this.player == 1 && board[y--][x].equals("-"))  // check if it can move forward once as white.
            moves.add(new Point(x, y--));

        return moves;
    }
}
