package com.chessmaster.test;

import com.chessmaster.config.PieceColor;
import com.chessmaster.pieces.Bishop;

public class BishopTest {

	public static void testIfBishopCanMoveDiagonal() {
		
		System.out.print("testIf Bishop CanMoveDiagonal - ");
		
		// AAA
		// 1. Arange
		Bishop testElement = new Bishop(PieceColor.BLACK, 0, 2);
		
		// 2. Act 
		boolean isValid = testElement.isMoveActionValid(1, 3);
		
		// 3. Assert
		String testMessage = (isValid) ? "Valid" : "Fail";
		System.out.println(testMessage);
	}
	
	
	public static void testIfBishopCanMoveNotDiagonal() {

		System.out.print("testIf Bishop CanMoveNotDiagonal - ");
		
		// AAA
		// 1. Arange
		Bishop testElement = new Bishop(PieceColor.BLACK, 0, 0);
		
		// 2. Act 
		boolean isValid = (testElement.isMoveActionValid(5, 8));
		
		// 3. Assert
		String testMessage = (isValid) ? "Valid" : "Fail";
		System.out.println(testMessage);
	}



	
	public static void run() {
		
		testIfBishopCanMoveDiagonal();
		testIfBishopCanMoveNotDiagonal();

	}
	
}
