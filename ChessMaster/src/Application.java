import com.chessmaster.Visualization.GameBoardPanel;
import com.chessmaster.config.PieceColor;
import com.chessmaster.manager.CordinateXY;
import com.chessmaster.manager.GameBoard;
import com.chessmaster.manager.TurnManager;
import com.chessmaster.pieces.King;
import com.chessmaster.pieces.Pawn;
import com.chessmaster.pieces.Pieces;
import com.chessmaster.pieces.Rook;
import com.chessmaster.test.*;

import javax.swing.*;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
//		PawnTest.run();
//		System.out.println();
//		RookTest.run();
//		System.out.println();
//		BishopTest.run();
//		System.out.println();
//		KnightTest.run();
//		System.out.println();
//		KingTest.run();
//		System.out.println();
//		System.out.println();
//		QueenTest.run();

	//TestMovement.testMove();

		GameBoard.init();
		JFrame windowFrame = new JFrame();
		windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowFrame.setSize(605, 547);
		windowFrame.add(new GameBoardPanel());
		windowFrame.setVisible(true);

		TurnManager turn = new TurnManager();
		turn.getCurrentBoard();

	}
}