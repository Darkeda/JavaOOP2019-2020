package com.chessmaster.manager;

import com.chessmaster.Visualization.GameBoardPanel;
import com.chessmaster.config.PieceColor;
import com.chessmaster.pieces.Pieces;

public class TurnManager {
    int currentTurn = 0;
    int blackPoints = 0;
    int whitePoints = 0;
    boolean isWhiteOnTurn = true;
    private int baseCollectionInitialLength = 5;

    public int getCurrentTurn() {
        return currentTurn;
    }

    public int getBlackPoints() {
        return blackPoints;
    }

    public int getWhitePoints() {
        return whitePoints;
    }

    public boolean isWhiteOnTurn() {
        return isWhiteOnTurn;
    }

    private int freePositionPointerIndex = 0;

    private int boardLength = 10;
    public Pieces[][] currentBoard = new Pieces[boardLength][boardLength];
    public TurnManager[] collection = new TurnManager[baseCollectionInitialLength];


    public Pieces[][] getCurrentBoard() {

        for (int i = 0; i < GameBoard.board.length; i++) {
            for (int j = 0; j < GameBoard.board.length; j++) {
                if (GameBoard.board[i][j] != null) {
                    currentBoard[i][j] = GameBoard.board[i][j];
                }
            }

        }
        return currentBoard;
    }

    public TurnManager saveTurn(int currentTurn) {
        this.blackPoints = GameBoard.blackPlayerPoints;
        this.whitePoints = GameBoard.whitePlayerPoints;
        if (currentTurn % 2 == 0) {
            isWhiteOnTurn = true;
        } else {
            isWhiteOnTurn = false;
        }
        this.currentTurn = currentTurn;
        this.currentBoard = getCurrentBoard();
        return this;
    }


    public void push(TurnManager element) {

        try {
            this.collection[this.freePositionPointerIndex] = element;
        } catch (ArrayIndexOutOfBoundsException exc) {
            // extend
            // 1. create a copy of the original collection

            TurnManager[] temporalyCollection = this.copyCollection(this.collection);
            this.baseCollectionInitialLength = baseCollectionInitialLength * 2;
            this.collection = new TurnManager[this.baseCollectionInitialLength];
            this.collection = extendCollection(this.collection, temporalyCollection);
            this.collection[this.freePositionPointerIndex] = element;
        } finally {
            this.freePositionPointerIndex++;
        }
    }


    private TurnManager[] copyCollection(TurnManager[] originalCollection) {

        TurnManager[] newCollection = new TurnManager[originalCollection.length];

        for (int i = 0; i < originalCollection.length; i++) {
            newCollection[i] = originalCollection[i];
        }

        return newCollection;
    }

    private TurnManager[] extendCollection(TurnManager[] baseCollection, TurnManager[] extendCollection) {

        TurnManager[] newCollection = copyCollection(baseCollection);

        for(int i = 0; i < extendCollection.length; i++) {
            newCollection[i] = extendCollection[i];
        }


        return newCollection;
    }
}
