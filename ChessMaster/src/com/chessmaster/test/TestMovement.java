package com.chessmaster.test;

import com.chessmaster.config.PieceColor;
import com.chessmaster.manager.CordinateXY;
import com.chessmaster.manager.GameBoard;
import com.chessmaster.pieces.Bishop;
import com.chessmaster.pieces.Rook;

public class TestMovement {


    public static void testMove() {
        GameBoard gameBoard = new GameBoard();

        Bishop bishop1 = new Bishop(PieceColor.BLACK, 3, 2);
        Rook rook = new Rook(PieceColor.WHITE, 1, 4);


        gameBoard.setPiece(rook);
        gameBoard.setPiece(bishop1);

         /*

         Example of input
          1 8 will return empty
          3 2 will return that it's a wrong color and will ask again
          1 4 will be valid piece so you can move it
          .actionThisTurn() check if its a move or attack

        */

        while (true) {
            CordinateXY startingPoint = gameBoard.whereToStart();
            CordinateXY end = gameBoard.whereToGo();
            gameBoard.actionThisTurn(startingPoint, end);

        }


    }
}
