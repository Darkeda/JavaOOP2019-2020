package com.chessmaster.test;

import com.chessmaster.config.PieceColor;
import com.chessmaster.pieces.Rook;

public class RookTest {

	public static void testIfRookCanMoveRows() {
		
		System.out.print("testIf Rook CanMoveDiagonal - ");
		
		// AAA
		// 1. Arange
		Rook testElement = new Rook(PieceColor.BLACK, 0, 0);
		
		// 2. Act 
		boolean isValid = testElement.isMoveActionValid(9, 0);
		
		// 3. Assert
		String testMessage = (isValid) ? "Valid" : "Fail";
		System.out.println(testMessage);
	}
	
	
	public static void testIfRookCanMoveCols() {

		System.out.print("testIf Rook CanMoveCols - ");
		
		// AAA
		// 1. Arange
		Rook testElement = new Rook(PieceColor.BLACK, 0, 0);
		
		// 2. Act 
		boolean isValid = (testElement.isMoveActionValid(0, 8));
		
		// 3. Assert
		String testMessage = (isValid) ? "Valid" : "Fail";
		System.out.println(testMessage);
	}


	public static void testIfRookCanMoveBothRowAndCol() {

		System.out.print("testIf Rook CanMoveBothRowAndCol - ");

		// AAA
		// 1. Arange
		Rook testElement = new Rook(PieceColor.BLACK, 0, 0);

		// 2. Act
		boolean isValid = (testElement.isMoveActionValid(5, 5));

		// 3. Assert
		String testMessage = (isValid) ? "Valid" : "Fail";
		System.out.println(testMessage);
	}
	
	public static void run() {
		
		testIfRookCanMoveRows();
		testIfRookCanMoveCols();
		testIfRookCanMoveBothRowAndCol();
	}
	
}
