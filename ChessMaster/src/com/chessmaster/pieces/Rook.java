package com.chessmaster.pieces;

public class Rook {
	
	public String color;
	public int power;
	public int id;

	public int row;
	public int col;


	public Rook(String color, int row, int col) {
		
		this.color  = color;
		this.power  = 5;
		this.id 	= 4;


		this.row 	= row;
		this.col 	= col;
	}


	public boolean isMoveActionValid(int moveRow, int moveCol) {
		if( moveCol > 9 || moveCol < 0){return false;}
		if( moveRow > 9 || moveRow < 0){return false;}

		int moveRowCoeficient = Math.abs(this.row - moveRow);
		int moveColCoeficient = Math.abs(this.col - moveCol);

		boolean isMoveActionValidRegardingTheRow = (moveColCoeficient == 0);
		boolean isMoveActionValidRegardingTheCol =(moveRowCoeficient == 0);

		return isMoveActionValidRegardingTheRow ||
				isMoveActionValidRegardingTheCol;
	}

	public void move(int row, int col) {

		if(isMoveActionValid(row, col)) {

			this.row = row;
			this.col = col;
		}
	}
}
