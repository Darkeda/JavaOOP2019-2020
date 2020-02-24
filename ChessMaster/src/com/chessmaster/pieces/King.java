package com.chessmaster.pieces;

import com.chessmaster.config.PieceColor;
import com.chessmaster.manager.GameBoard;

public class King extends Pieces {
	

	
	public King(String color, int row, int col)  {

		super(color, row, col);

		this.power  = 6;
		this.id 	= 5;


	}

	public boolean isMoveActionValid(int moveRow, int moveCol) {

		if( moveCol > 9 || moveCol < 0){return false;}
		if( moveRow > 9 || moveRow < 0){return false;}


		int moveRowCoeficient = Math.abs(this.row - moveRow);
		int moveColCoeficient = Math.abs(this.col - moveCol);

		boolean isMoveActionValidRegardingTheDiagonal = (moveColCoeficient==1 && moveRowCoeficient == 1);
		boolean isMoveActionValidRegardingSideways = (moveColCoeficient==0 && moveRowCoeficient == 1);
		boolean isMoveActionValidRegardingUpwardsAndDownwards = (moveColCoeficient==1 && moveRowCoeficient == 0);

		if(	isThereSomeoneBlockingTheWay(moveRow,moveCol) == false) {
			//System.out.println("Something is blocking the way.");
			return false;
		}

		return  isMoveActionValidRegardingTheDiagonal ||
				isMoveActionValidRegardingUpwardsAndDownwards||
				isMoveActionValidRegardingSideways;


	}

	@Override
	public void move(int row, int col) {

		if(isMoveActionValid(row, col)) {
			System.out.println("Move made");
			GameBoard.board[row][col] = GameBoard.board[this.row][this.col];
			GameBoard.board[this.row][this.col] = null;
			this.row = row;
			this.col = col;
			GameBoard.initPiece(this);
		}
}

	@Override
	public void attack(int row, int col) {

	}

	@Override
	public String getImage() {
		String filepath="";
		if(this.color== PieceColor.WHITE){
			filepath = "resource/KingWhite.png";
		} else { filepath = "resource/KingDark.png";}
		return filepath;
	}
}