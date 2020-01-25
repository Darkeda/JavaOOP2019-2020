package com.chessmaster.pieces;

import com.chessmaster.config.PieceColor;
import com.chessmaster.manager.CordinateXY;
import com.chessmaster.manager.GameBoard;

import java.util.Scanner;

import static com.sun.javafx.util.Utils.clamp;

public abstract class Pieces {

    public String color;
    public int power;
    public int id;

    public int row;
    public int col;

    public Pieces(String color, int row, int col) {

        this.color = color;
        this.row = row;
        this.col = col;
    }

    public Pieces(String color) {

        this.color = color;
        this.row = 0;
        this.col = 0;
    }

    public abstract void move(int row, int col);

    public abstract void attack(int row, int col);


    int clamp(int value, int min, int max) {
        if (value <= min) return min;
        if (value >= max) return max;
        return value;
    }

    // Check if something is along the path
    boolean isThereSomeoneBlockingTheWay(int moveRow, int moveCol) {
        int rowCoef = clamp(moveRow - this.row, -1, 1);
        int colCoef = clamp(moveCol - this.col, -1, 1);

        while (true) {

            moveRow = moveRow - rowCoef;
            moveCol = moveCol - colCoef;
            if (moveRow == this.row && moveCol == this.col) {
                break;
            }
            if (GameBoard.board[moveRow][moveCol] != null) {
                return false;
            }


        }

        return true;
    }


}
