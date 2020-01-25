package com.chessmaster.pieces;

import com.chessmaster.manager.GameBoard;

public class Rook extends Pieces {
	





	public Rook(String color, int row, int col) {

		super(color, row, col);

		this.power  = 5;
		this.id 	= 4;



	}


	public boolean isMoveActionValid(int moveRow, int moveCol) {
		if( moveCol > 9 || moveCol < 0){return false;}
		if( moveRow > 9 || moveRow < 0){return false;}

		int moveRowCoeficient = Math.abs(this.row - moveRow);
		int moveColCoeficient = Math.abs(this.col - moveCol);

		boolean isMoveActionValidRegardingTheRow = (moveColCoeficient == 0);
		boolean isMoveActionValidRegardingTheCol = (moveRowCoeficient == 0);

		if(	isThereSomeoneBlockingTheWay(moveRow,moveCol) == false) {
			System.out.println("Something is blocking the way.");
			return false;
		}

		return isMoveActionValidRegardingTheRow ||
				isMoveActionValidRegardingTheCol ;
	}

	@Override
	public void move(int row, int col) {

		if(isMoveActionValid(row, col)) {

			System.out.println("Move made");
			GameBoard.board[row][col] = GameBoard.board[this.row][this.col];
			GameBoard.board[this.row][this.col] = null;
			this.row = row;
			this.col = col;

		} else {
			System.out.println("That move cannot be made.");
		}
	}

	@Override
	public void attack(int row, int col) {

	}
}
