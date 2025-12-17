package com.example.my_chess.Game;

import com.example.my_chess.Pieces.Bishop;
import com.example.my_chess.Pieces.King;
import com.example.my_chess.Pieces.Knight;
import com.example.my_chess.Pieces.Pawn;
import com.example.my_chess.Pieces.Piece;
import com.example.my_chess.Pieces.Point;
import com.example.my_chess.Pieces.Rook;

public class Player {

    private int colour; // what colour player, 0 = white, 1 = black
    private Piece[] pieces = new Piece[16];

    public Player(int colour){
        this.colour = colour;
        setPieces();


    }

    private void setPieces(){
        if(this.colour == 0){
            for(int x = 0; x < 8; x++){
                pieces[x] = new Pawn(new Point(1, x), colour, this, x);

                if(x % 7 == 0)
                    pieces[x+8] = new Rook(new Point(0, x), colour, this, x+8);

                else if(x == 1 || x == 6)
                    pieces[x+8] = new Knight(new Point(0, x), colour, this, x+8);

                else if(x == 2 || x == 5)
                    pieces[x+8] = new Bishop(new Point(0, x), colour, this, x+8);    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!add QUEEN
            }
            pieces[15] = new King(new Point(0, 4), colour, this, 15);
        }

        else{
            for(int x = 0; x < 8; x++){
                pieces[x] = new Pawn(new Point(6, x), colour, this, x);

                if(x % 7 == 0)
                    pieces[x+8] = new Rook(new Point(7, x), colour, this, x+8);

                else if(x == 1 || x == 6)
                    pieces[x+8] = new Knight(new Point(7, x), colour, this, x+8);

                else if(x == 2 || x == 5)
                    pieces[x+8] = new Bishop(new Point(7, x), colour, this, x+8);    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!add QUEEN
            }
            pieces[15] = new King(new Point(7, 4), colour, this, 15);
        }
    }

    public Piece[] getPieces(){
        return this.pieces;
    }

}
