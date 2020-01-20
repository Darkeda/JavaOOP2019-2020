package com.chessmaster.test;

import com.chessmaster.config.PieceColor;
import com.chessmaster.pieces.Bishop;
import com.chessmaster.pieces.Knight;

public class KnightTest {

	public static void testIfKnightanMoveGShape() {
		
		System.out.print("testIf Knight CanMoveGShape - ");
		
		// AAA
		// 1. Arange
		Knight testElement = new Knight(PieceColor.BLACK, 1, 1);
		
		// 2. Act 
		boolean isValid = testElement.isMoveActionValid(0, 3);
		
		// 3. Assert
		String testMessage = (isValid) ? "Valid" : "Fail";
		System.out.println(testMessage);
	}
	
	
	public static void testIfKnightCanMoveNotGShape() {

		System.out.print("testIf Knight CanMoveNotGShape - ");
		
		// AAA
		// 1. Arange
		Knight testElement = new Knight(PieceColor.BLACK, 1, 1);
		
		// 2. Act 
		boolean isValid = (testElement.isMoveActionValid(1, 3));
		
		// 3. Assert
		String testMessage = (isValid) ? "Valid" : "Fail";
		System.out.println(testMessage);
	}



	
	public static void run() {

		testIfKnightanMoveGShape();
		testIfKnightCanMoveNotGShape();

	}
	
}
