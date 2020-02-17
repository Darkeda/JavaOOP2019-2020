package com.chessmaster.pieces;

import com.chessmaster.config.PieceColor;

public class Chudaka extends Pieces implements Blastable {



    public Chudaka(String color, int row, int col) {

        super(color, row, col);
        this.power 	= 15;
        this.id 	= 7;
    }

    @Override
    public void move(int row, int col) {
        // TODO Auto-generated method stub

    }

    @Override
    public void attack(int row, int col) {
        // TODO Auto-generated method stub

    }


    @Override
    public void blast() {

    }

    @Override
    public String getImage() {
        String filepath="";
        if(this.color== PieceColor.WHITE){
            filepath = "C:\\\\Users\\\\svetl\\\\Desktop\\\\Pawn.png";
        } else { filepath = "C:\\\\Users\\\\svetl\\\\Desktop\\\\Pawn.png";}
        return filepath;
    }
}


