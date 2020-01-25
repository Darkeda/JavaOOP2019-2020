package com.chessmaster.pieces;
public class Queen extends Pieces {
	
;
	
	public Queen(String color, int row, int col) {

		super(color, row, col);

		this.power  = 10;
		this.id 	= 6;


	}
	public boolean isMoveActionValid(int moveRow, int moveCol) {

		if( moveCol > 9 || moveCol < 0){return false;}
		if( moveRow > 9 || moveRow < 0){return false;}


		int moveRowCoeficient = Math.abs(this.row - moveRow);
		int moveColCoeficient = Math.abs(this.col - moveCol);

		boolean isMoveActionValidRegardingTheDiagonal = (moveColCoeficient==moveRowCoeficient);
		boolean isMoveActionValidRegardingTheRow = (moveColCoeficient == 0);
		boolean isMoveActionValidRegardingTheCol =(moveRowCoeficient == 0);

		if(	isThereSomeoneBlockingTheWay(moveRow,moveCol) == false) {
			System.out.println("Something is blocking the way.");
			return false;
		}

		return  isMoveActionValidRegardingTheDiagonal || isMoveActionValidRegardingTheCol
				|| isMoveActionValidRegardingTheRow;

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
}