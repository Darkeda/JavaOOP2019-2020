import com.chessmaster.config.PieceColor;
import com.chessmaster.pieces.King;
import com.chessmaster.pieces.Pawn;
import com.chessmaster.test.*;

public class Application {

	public static void main(String[] args) {
		
		PawnTest.run();
		System.out.println();
		RookTest.run();
		System.out.println();
		BishopTest.run();
		System.out.println();
		KnightTest.run();
		System.out.println();
		KingTest.run();
		System.out.println();
		System.out.println();
		QueenTest.run();
	}
}