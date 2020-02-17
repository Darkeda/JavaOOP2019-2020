package com.chessmaster.pieces;

import com.chessmaster.config.PieceColor;

public class Knight extends Pieces {
	

	
	public Knight(String color, int row, int col) {

		super(color, row, col);

		this.power  = 5;
		this.id 	= 3;


	}

	public boolean isMoveActionValid(int moveRow, int moveCol) {

		if( moveCol > 9 || moveCol < 0){return false;}
		if( moveRow > 9 || moveRow < 0){return false;}


		int moveRowCoeficient = Math.abs(this.row - moveRow);
		int moveColCoeficient = Math.abs(this.col - moveCol);

		boolean isMoveActionValidRegardingGShapeUpwardsOrDownwards = (moveColCoeficient== 2 && moveRowCoeficient==1);
		boolean isMoveActionValidRegardingGSideways = (moveColCoeficient== 1 && moveRowCoeficient==2);

		if(	isThereSomeoneBlockingTheWay(moveRow,moveCol) == false) {
			System.out.println("Something is blocking the way.");
			return false;
		}


		return isMoveActionValidRegardingGShapeUpwardsOrDownwards||isMoveActionValidRegardingGSideways;

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
			filepath = "resource/KnighWhite.png";
		} else { filepath = "resource/KnighDark.png";}
		return filepath;
	}
}
