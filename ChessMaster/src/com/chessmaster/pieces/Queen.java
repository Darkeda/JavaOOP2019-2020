package com.chessmaster.pieces;
public class Queen {
	
	public String color;
	public int power;
	public int id;

	public int row;
	public int col;
	
	public Queen(String color, int row, int col) {
		
		this.color  = color;
		this.power  = 10;
		this.id 	= 6;

		this.row 	= row;
		this.col 	= col;
	}
	public boolean isMoveActionValid(int moveRow, int moveCol) {

		if( moveCol > 9 || moveCol < 0){return false;}
		if( moveRow > 9 || moveRow < 0){return false;}


		int moveRowCoeficient = Math.abs(this.row - moveRow);
		int moveColCoeficient = Math.abs(this.col - moveCol);

		boolean isMoveActionValidRegardingTheDiagonal = (moveColCoeficient==moveRowCoeficient);
		boolean isMoveActionValidRegardingTheRow = (moveColCoeficient == 0);
		boolean isMoveActionValidRegardingTheCol =(moveRowCoeficient == 0);

		return  isMoveActionValidRegardingTheDiagonal || isMoveActionValidRegardingTheCol
				|| isMoveActionValidRegardingTheRow;






	}

	public void move(int row, int col) {

		if(isMoveActionValid(row, col)) {

			this.row = row;
			this.col = col;
		}
	}
}