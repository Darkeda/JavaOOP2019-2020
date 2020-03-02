package com.chessmaster.pieces;

import com.chessmaster.config.PieceColor;
import com.chessmaster.manager.GameBoard;

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
			//System.out.println("Something is blocking the way.");
			//return false;
		}


		return isMoveActionValidRegardingGShapeUpwardsOrDownwards||isMoveActionValidRegardingGSideways;

	}

	@Override
	public boolean isThereSomethingToTake(int moveRow, int moveCol) {
		if (GameBoard.board[moveRow][moveCol] != null
				&& GameBoard.board[moveRow][moveCol].color != this.color){return  true;}
		return false;
	}

	@Override

	public boolean isAttackActionValid(int moveRow, int moveCol) {

		if( moveCol > 9 || moveCol < 0){return false;}
		if( moveRow > 9 || moveRow < 0){return false;}


		int moveRowCoeficient = Math.abs(this.row - moveRow);
		int moveColCoeficient = Math.abs(this.col - moveCol);

		boolean isMoveActionValidRegardingGShapeUpwardsOrDownwards = (moveColCoeficient== 2 && moveRowCoeficient==1);
		boolean isMoveActionValidRegardingGSideways = (moveColCoeficient== 1 && moveRowCoeficient==2);




		return isMoveActionValidRegardingGShapeUpwardsOrDownwards||isMoveActionValidRegardingGSideways;


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

		if(isAttackActionValid(row, col)) {
			System.out.println("Attack made");
			GameBoard.board[row][col] = GameBoard.board[this.row][this.col];
			GameBoard.board[this.row][this.col] = null;
			this.row = row;
			this.col = col;
			GameBoard.initPiece(this);
		}

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
