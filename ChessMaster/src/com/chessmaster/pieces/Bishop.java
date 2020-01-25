package com.chessmaster.pieces;
public class Bishop extends Pieces {
	

	
	public Bishop(String color, int row, int col) {

		super(color, row, col);

		this.power  = 5;
		this.id 	= 2;

	}


	public boolean isMoveActionValid(int moveRow, int moveCol) {

		if( moveCol > 9 || moveCol < 0){return false;}
		if( moveRow > 9 || moveRow < 0){return false;}


		int moveRowCoeficient = Math.abs(this.row - moveRow);
		int moveColCoeficient = Math.abs(this.col - moveCol);

		boolean isMoveActionValidRegardingTheDiagonal = (moveColCoeficient==moveRowCoeficient);

		if(	isThereSomeoneBlockingTheWay(moveRow,moveCol) == false) {
			System.out.println("Something is blocking the way.");
			return false;
		}


		return isMoveActionValidRegardingTheDiagonal;

	}

	@Override
	public void move(int row, int col) {

		if(isMoveActionValid(row, col)) {
			System.out.println("gucci");
			this.row = row;
			this.col = col;
		} else {
			System.out.println("nein");
		}
}

	@Override
	public void attack(int row, int col) {

	}
}
