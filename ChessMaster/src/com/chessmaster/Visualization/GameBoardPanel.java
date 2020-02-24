package com.chessmaster.Visualization;

import com.chessmaster.config.PieceColor;
import com.chessmaster.manager.CordinateXY;
import com.chessmaster.manager.GameBoard;
import com.chessmaster.pieces.Pieces;
import com.chessmaster.pieces.Queen;
import javafx.scene.chart.PieChart;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import static com.chessmaster.manager.GameBoard.board;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class GameBoardPanel extends JPanel {
    private final int TILE_SIDE = 50;
    private boolean isAPieeceSelected = false;
    private int currentRow = -1;
    private int curretCol = -1;

    private String currentPlayerColor = PieceColor.WHITE;

    private int selectedRow = -1;
    private int selectedCol = -1;

    public GameBoardPanel() {

        addMouseListener(new ChessBoardEventProxy() {

            @Override
            public void mouseClicked(MouseEvent e) {

                int x = e.getX();
                int y = e.getY();

                selectedRow = y / TILE_SIDE;
                selectedCol = x / TILE_SIDE;
                System.out.println(selectedRow + " " + selectedCol);
                updateUI();
                move();


                // paint(getGraphics());
                updateUI();
            }
        });
    }

    public void paint(Graphics g) {

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                render(g, row, col);
            }
        }

        //g.setColor(Color.GREEN);
        //g.fillRect(10, 10, 100, 100);
    }

    private void render(Graphics g, int row, int col) {

        boolean isRowEven = (row % 2 == 0);
        boolean isColEvent = (col % 2 == 0);

        boolean isWhite = (isRowEven && isColEvent) ||
                (!isRowEven && !isColEvent);

        Color tileColor = isWhite ? Color.WHITE
                : Color.BLACK;

        boolean isSelected = (row == selectedRow) &&
                (col == selectedCol);

        int tileX = col * TILE_SIDE;
        int tileY = row * TILE_SIDE;


        if (isSelected) {

            tileColor =  new Color(174, 215, 00, 100);
            g.setColor(tileColor);

            g.fillRect(tileX, tileY, TILE_SIDE, TILE_SIDE);
            return;
        }

        g.setColor(tileColor);
        g.fillRect(tileX, tileY, TILE_SIDE, TILE_SIDE);

        drawFiure(g, tileX, tileY);


        if (selectedRow >= 0 && selectedCol >= 0 && board[selectedRow][selectedCol] != null
                && board[selectedRow][selectedCol].getColor() == currentPlayerColor) {

            if ((board[selectedRow][selectedCol].isMoveActionValid(tileY / 50, tileX / 50))) {
                isAPieeceSelected = true;
                currentRow = (selectedRow);
                curretCol = selectedCol;


                g.setColor(new Color(215, 00, 00, 150));
                g.fillRect(tileX, tileY, TILE_SIDE, TILE_SIDE);
            }

        }


    }

    public void move() {
        if (isAPieeceSelected) {


            if (board[currentRow][curretCol].isMoveActionValid(selectedRow, selectedCol)) {
                isAPieeceSelected = false;
                board[currentRow][curretCol].move(selectedRow, selectedCol);

                if (currentPlayerColor == PieceColor.WHITE) {
                    currentPlayerColor = PieceColor.BLACK;
                } else {
                    currentPlayerColor = PieceColor.WHITE;
                }

            }

        }
    }


    public void drawFiure(Graphics g, int tileX, int tileY) {

        if (board[tileY / 50][tileX / 50] != null) {
            BufferedImage myPicture = null;

            try {
                myPicture = ImageIO.read(new File(board[tileY / 50][tileX / 50].getImage()));

            } catch (IOException | NullPointerException ex) {
                ex.printStackTrace();
            }
            g.drawImage(myPicture, tileX, tileY, null);
        }
    }

}


