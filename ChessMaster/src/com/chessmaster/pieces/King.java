package com.chessmaster.pieces;
public class King {
	
	public String color;
	public int power;
	public int id;

	public int row;
	public int col;
	
	public King(String color, int row, int col)  {
		
		this.color  = color;
		this.power  = 6;
		this.id 	= 5;

		this.row 	= row;
		this.col 	= col;
	}

	public boolean isMoveActionValid(int moveRow, int moveCol) {

		if( moveCol > 9 || moveCol < 0){return false;}
		if( moveRow > 9 || moveRow < 0){return false;}


		int moveRowCoeficient = Math.abs(this.row - moveRow);
		int moveColCoeficient = Math.abs(this.col - moveCol);

		boolean isMoveActionValidRegardingTheDiagonal = (moveColCoeficient==1 && moveRowCoeficient == 1);
		boolean isMoveActionValidRegardingSideways = (moveColCoeficient==0 && moveRowCoeficient == 1);
		boolean isMoveActionValidRegardingUpwardsAndDownwards = (moveColCoeficient==1 && moveRowCoeficient == 0);

		return  isMoveActionValidRegardingTheDiagonal ||
				isMoveActionValidRegardingUpwardsAndDownwards||
				isMoveActionValidRegardingSideways;




	}

	public void move(int row, int col) {

		if(isMoveActionValid(row, col)) {

			this.row = row;
			this.col = col;
		}
}}