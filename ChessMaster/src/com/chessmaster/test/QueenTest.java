package com.chessmaster.test;

import com.chessmaster.config.PieceColor;
import com.chessmaster.pieces.Bishop;
import com.chessmaster.pieces.Queen;

public class QueenTest {

	public static void testIfQueenCanMoveDiagonal() {
		
		System.out.print("testIf Queen CanMoveDiagonal - ");
		
		// AAA
		// 1. Arange
		Queen testElement = new Queen(PieceColor.BLACK, 0, 0);
		
		// 2. Act 
		boolean isValid = testElement.isMoveActionValid(3, 3);
		
		// 3. Assert
		String testMessage = (isValid) ? "Valid" : "Fail";
		System.out.println(testMessage);
	}
	
	
	public static void testIfQueenCanMoveRow() {

		System.out.print("testIf Queen CanMoveRow - ");
		
		// AAA
		// 1. Arange
		Queen testElement = new Queen(PieceColor.BLACK, 0, 0);
		
		// 2. Act 
		boolean isValid = (testElement.isMoveActionValid(5, 0));
		
		// 3. Assert
		String testMessage = (isValid) ? "Valid" : "Fail";
		System.out.println(testMessage);
	}

	public static void testIfQueenCanMoveCol() {

		System.out.print("testIf Queen CanMoveCol - ");

		// AAA
		// 1. Arange
		Queen testElement = new Queen(PieceColor.BLACK, 0, 0);

		// 2. Act
		boolean isValid = (testElement.isMoveActionValid(0, 5));

		// 3. Assert
		String testMessage = (isValid) ? "Valid" : "Fail";
		System.out.println(testMessage);
	}

	public static void testIfQueenCanMoveFail() {

		System.out.print("testIf Queen CanMoveFail - ");

		// AAA
		// 1. Arange
		Queen testElement = new Queen(PieceColor.BLACK, 0, 0);

		// 2. Act
		boolean isValid = (testElement.isMoveActionValid(1, 2));

		// 3. Assert
		String testMessage = (isValid) ? "Valid" : "Fail";
		System.out.println(testMessage);
	}



	
	public static void run() {
		
		testIfQueenCanMoveDiagonal();
		testIfQueenCanMoveRow();
		testIfQueenCanMoveCol();
		testIfQueenCanMoveFail();

	}
	
}
