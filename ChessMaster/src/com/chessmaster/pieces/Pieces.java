package com.chessmaster.pieces;

import com.chessmaster.config.PieceColor;
import com.chessmaster.manager.CordinateXY;
import com.chessmaster.manager.GameBoard;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;

import static com.sun.javafx.util.Utils.clamp;

public abstract class Pieces {

    protected String color;
    protected int power;
    protected int id;
    protected int row;
    protected int col;
    protected  int points = 10;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public abstract String getImage();


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

    public boolean isMoveActionValid(int moveRow, int moveCol) {
        return true;
    }


    // Check if something is along the path
    public boolean isAttackActionValid(int moveRow, int moveCol) {
        return true;
    }


    public boolean isThereSomeoneBlockingTheWay(int moveRow, int moveCol) {
        int rowCoef = clamp(moveRow - this.row, -1, 1);
        int colCoef = clamp(moveCol - this.col, -1, 1);

        while (true) {

            try {
                if (GameBoard.board[moveRow][moveCol] != null) {
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }

            moveRow = moveRow - rowCoef;

            moveCol = moveCol - colCoef;
            if (moveRow == this.row && moveCol == this.col) {

                break;
            }
            try {
                if (GameBoard.board[moveRow][moveCol] != null) {
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }


        }

        return true;
    }


    public boolean isThereSomethingToTake(int moveRow, int moveCol) {

        int rowCoef = clamp(moveRow - this.row, -1, 1);
        int colCoef = clamp(moveCol - this.col, -1, 1);

        int currentRow = this.row;
        int currentCol = this.col;


        while (true) {

            System.out.println(currentRow + " row " + moveRow);
            System.out.println(currentCol + " col " + moveCol);

            try {
                if (GameBoard.board[currentRow][currentCol] != null
                        && GameBoard.board[currentRow][currentCol].color != this.color
                        && currentCol == moveCol
                        && currentRow == moveRow
                ) {

                    System.out.println(currentRow + " Wow row " + moveRow);
                    System.out.println(currentCol + " Wow col " + moveCol);
                    return true;

                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }

            currentRow += rowCoef;


            currentCol += colCoef;


            if (currentRow > 10 || currentRow < 0 || currentCol > 10 || currentCol < 0) {

                break;
            }


//            try {
//                if (GameBoard.board[currentRow][currentCol] != null && GameBoard.board[currentRow][currentCol].color != this.color
//                        && currentRow==moveRow && currentCol==moveCol ) {
//                    return true;
//                }
//            } catch (ArrayIndexOutOfBoundsException e) {return  false;}


        }

        return false;
    }


}
