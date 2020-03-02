package com.chessmaster.manager;

import com.chessmaster.config.PieceColor;
import com.chessmaster.pieces.*;
import com.chessmaster.pieces.Pieces;

import java.util.Scanner;

public class GameBoard {

    public static Pieces board[][] = new Pieces[10][10];
    boolean currentPlayer = true; // true = white , false = black
    public static boolean isClicked =false;
    public static CordinateXY selecedPiece;
    public static int whitePlayerPoints = 0;
    public static int blackPlayerPoints = 0;


    public static void init() {

        initPiece(new Rook(PieceColor.BLACK, 0, 0));
        initPiece(new Knight(PieceColor.BLACK, 0, 1));
        initPiece(new Bishop(PieceColor.BLACK, 0, 2));
        initPiece(new King(PieceColor.BLACK, 0, 3));
        initPiece(new Queen(PieceColor.BLACK, 0, 4));
//
//        initPiece(new Pawn(PieceColor.BLACK, 1, 0));
//        initPiece(new Pawn(PieceColor.BLACK, 1, 1));
//        initPiece(new Pawn(PieceColor.BLACK, 1, 2));
//        initPiece(new Pawn(PieceColor.BLACK, 1, 3));
//        initPiece(new Pawn(PieceColor.BLACK, 1, 4));

        initPiece(new Rook(PieceColor.WHITE, 9, 0));
        initPiece(new Knight(PieceColor.WHITE, 9, 1));
        initPiece(new Bishop(PieceColor.WHITE, 9, 2));
        initPiece(new King(PieceColor.WHITE, 9, 3));
        initPiece(new Queen(PieceColor.WHITE, 9, 4));

       // initPiece(new Pawn(PieceColor.WHITE, 8, 0));
       // initPiece(new Pawn(PieceColor.WHITE, 8, 1));
       // initPiece(new Pawn(PieceColor.WHITE, 8, 2));
        //initPiece(new Pawn(PieceColor.WHITE, 8, 3));
       // initPiece(new Pawn(PieceColor.WHITE, 8, 4));
    }

    public static void initPiece(Pieces piece) {

        // int row = piece.row;
        int row = piece.getRow();

        // int col = piece.col;
        int col = piece.getCol();

        board[row][col] = piece;
    }


    public static void render() {

    }

    public void setPiece(Pieces piece) {
        board[piece.getRow()][piece.getCol()] = piece;

    }

    public CordinateXY whereToGo() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the coordinates of where you want to go: (ex. X Y)");
        CordinateXY endCoordinate = new CordinateXY(scanner.nextInt(), scanner.nextInt());
        System.out.println(endCoordinate.getCoordinateX() + " " + endCoordinate.getCoordinateY());

        return endCoordinate;
    }

    public CordinateXY whereToStart() {


        System.out.println("Please enter the coordinates of a " + whoseTurnIsItNow() + " piece: (ex. X Y)");
        CordinateXY coordinate;
        boolean rightColor = true;

        do {

            coordinate = enterXY();

            if (board[coordinate.getCoordinateX()][coordinate.getCoordinateY()] == null) {

                System.out.println("There is nothing there");
            } else if ((board[coordinate.getCoordinateX()][coordinate.getCoordinateY()].getColor() != currentColorOfPlayer().toString())) {
                rightColor = false;
                System.out.println("Wrong Piece");
                continue;

            }
            rightColor = true;
        }
        while ((board[coordinate.getCoordinateX()][coordinate.getCoordinateY()] == null) || (rightColor == false));

        // Chose Right Cor
       // System.out.println(coordinate.getCoordinateX() + " " + coordinate.getCoordinateY());

        return coordinate;

    }

    public String whoseTurnIsItNow() {
        if (currentPlayer == true) {
            return "White";
        } else {
            return "Black";
        }
    }

    public String currentColorOfPlayer() {
        if (currentPlayer == true) {
            return PieceColor.WHITE;
        } else {
            return PieceColor.BLACK;
        }
    }


    private CordinateXY enterXY() {
        CordinateXY coordinate;

        Scanner scanner = new Scanner(System.in);
        coordinate = new CordinateXY(scanner.nextInt(), scanner.nextInt());

        return coordinate;
    }

    // Check for Move or Attack
    public void actionThisTurn(CordinateXY start, CordinateXY end) {


        if (board[start.getCoordinateX()][start.getCoordinateY()] == null) {
            board[start.getCoordinateX()][start.getCoordinateY()].move(end.getCoordinateX(), end.getCoordinateY());
            System.out.println("You have moved successfully");
        } else board[start.getCoordinateX()][start.getCoordinateY()].attack(end.getCoordinateX(), end.getCoordinateY());

        if (currentPlayer) {
            currentPlayer = false;
        } else {
            currentPlayer = true;
        }


    }

}