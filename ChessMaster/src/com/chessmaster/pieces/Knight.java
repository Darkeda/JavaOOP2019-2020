package com.chessmaster.pieces;
public class Knight {
	
	public String color;
	public int power;
	public int id;

	public int row;
	public int col;
	
	public Knight(String color, int row, int col) {
		
		this.color  = color;
		this.power  = 5;
		this.id 	= 3;

		this.row 	= row;
		this.col 	= col;
	}

	public boolean isMoveActionValid(int moveRow, int moveCol) {

		if( moveCol > 9 || moveCol < 0){return false;}
		if( moveRow > 9 || moveRow < 0){return false;}


		int moveRowCoeficient = Math.abs(this.row - moveRow);
		int moveColCoeficient = Math.abs(this.col - moveCol);

		boolean isMoveActionValidRegardingGShapeUpwardsOrDownwards = (moveColCoeficient== 2 && moveRowCoeficient==1);
		boolean isMoveActionValidRegardingGSideways = (moveColCoeficient== 1 && moveRowCoeficient==2);


		return isMoveActionValidRegardingGShapeUpwardsOrDownwards||isMoveActionValidRegardingGSideways;

	}

	public void move(int row, int col) {

		if(isMoveActionValid(row, col)) {

			this.row = row;
			this.col = col;
		}
}}
