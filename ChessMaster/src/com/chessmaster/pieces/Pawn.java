package com.chessmaster.pieces;

import com.chessmaster.config.PieceColor;

public class Pawn extends Pieces {
	

	
	public Pawn(String color, int row, int col) {

		super(color, row, col);

		this.power  = 1;
		this.id 	= 1;
		

	}
	
	public boolean isMoveActionValid(int moveRow, int moveCol) {

		
		int moveRowCoeficient = this.row - moveRow;
		int moveColCoeficient = this.col - moveCol;
		
		boolean isMoveActionValidRegardingTheRow = (moveRowCoeficient == 1);
		boolean isMoveActionValidRegardingTheCol = (moveColCoeficient == 0);
		
		return isMoveActionValidRegardingTheRow &&
			   isMoveActionValidRegardingTheCol;
	}

	@Override
	public void move(int row, int col) {
		
		if(isMoveActionValid(row, col)) {
			
			this.row = row;
			this.col = col;
		}
	}

	@Override
	public void attack(int row, int col) {

	}


	@Override
	public String getImage() {
		String filepath="";
		if(this.color== PieceColor.WHITE){
			filepath = "resource/PawnWhite.png";
		} else { filepath = "resource/PawnDark.png";}
		return filepath;
	}


}
