package com.chessmaster.test;

import com.chessmaster.config.PieceColor;
import com.chessmaster.pieces.King;
import com.chessmaster.pieces.Knight;

public class KingTest {

	public static void testIfKingCanMoveUpOrDOwn() {
		
		System.out.print("testIf King CanMoveUpOrDOwn - ");
		
		// AAA
		// 1. Arange
		King testElement = new King(PieceColor.BLACK, 1, 1);
		
		// 2. Act 
		boolean isValid = testElement.isMoveActionValid(0, 1);
		
		// 3. Assert
		String testMessage = (isValid) ? "Valid" : "Fail";
		System.out.println(testMessage);
	}

	public static void testIfKingCanMoveSideways() {

		System.out.print("testIf King CanMoveSideways - ");

		// AAA
		// 1. Arange
		King testElement = new King(PieceColor.BLACK, 1, 1);

		// 2. Act
		boolean isValid = testElement.isMoveActionValid(1, 2);

		// 3. Assert
		String testMessage = (isValid) ? "Valid" : "Fail";
		System.out.println(testMessage);
	}

	public static void testIfKingCanMoveDiagonal() {

		System.out.print("testIf King CanMoveDiagonal- ");

		// AAA
		// 1. Arange
		King testElement = new King(PieceColor.BLACK, 1, 1);

		// 2. Act
		boolean isValid = testElement.isMoveActionValid(0, 0);

		// 3. Assert
		String testMessage = (isValid) ? "Valid" : "Fail";
		System.out.println(testMessage);
	}
	
	
	public static void testIfKingCanMoveMoreThanOneSpace() {

		System.out.print("testIf King CanMoveThanOneSpace - ");
		
		// AAA
		// 1. Arange
		King testElement = new King(PieceColor.BLACK, 1, 1);
		
		// 2. Act 
		boolean isValid = (testElement.isMoveActionValid(1, 3));
		
		// 3. Assert
		String testMessage = (isValid) ? "Valid" : "Fail";
		System.out.println(testMessage);
	}



	
	public static void run() {

		testIfKingCanMoveDiagonal();
		testIfKingCanMoveSideways();
		testIfKingCanMoveUpOrDOwn();
		testIfKingCanMoveMoreThanOneSpace();


	}
	
}
