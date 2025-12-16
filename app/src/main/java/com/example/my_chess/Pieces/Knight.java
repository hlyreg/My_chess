package com.example.my_chess.Pieces;

import com.example.my_chess.Game.Board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Knight extends Piece{

    public Knight(Point place, int player){
        super(place, player);
    }

    @Override
    public List<Point> getMoves(Board current_board, boolean trigger) {
        int x = this.place.getX();
        int y = this.place.getY();
        String[][] board = current_board.getBoard();
        List<Point> moves = new ArrayList<>();
//__________________________________________________________________________________________
        for(int num = -2; num < 3; num+=4){     // will run twice, once num = 2, once num = -2
            if(y+num < 8 && y+num >= 0){         // when the knight moves vertically, when num = 2, go up, and when it's -2 go down
                if(x-- >= 0){
                    if(isEmpty(board, y+num, x--))
                        moves.add(new Point(y+num, x--));
                    else
                        moves.add(new Point(y+num, x--, true));     // does the move kill a piece
                }
                else if(x++ < 8){
                    if(isEmpty(board, y+num, x++))
                        moves.add(new Point(y+num, x++));
                    else
                        moves.add(new Point(y+num, x++, true));
                }
            }
            if(x+num < 8 && x+num >= 0){        //when the knight moves horizontally, when num = 2, go right, and when it's -2 go left
                if(y-- >= 0){
                    if(isEmpty(board, y--, x+num))
                        moves.add(new Point(y--, x+num));
                    else
                        moves.add(new Point(y--, x+num, true));
                }
                else if(y++ < 8){
                    if(isEmpty(board, y++, x+num))
                        moves.add(new Point(y++, x+num));
                    else
                        moves.add(new Point(y++, x+num, true));
                }
            }

        }



        return Collections.emptyList();
    }

    @Override
    public void move(Point newPlace) {

    }
}
