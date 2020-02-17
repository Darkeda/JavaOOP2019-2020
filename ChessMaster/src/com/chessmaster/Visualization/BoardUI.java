package com.chessmaster.Visualization;

import com.chessmaster.manager.GameBoard;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import static com.chessmaster.manager.GameBoard.board;
import static com.chessmaster.manager.GameBoard.isClicked;

public class BoardUI {


    public static void main(String[] args) {
        GameBoard.init();
        new BoardUI();
    }

    public BoardUI() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.setSize(600, 600);

                frame.add(new ChessPanel());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ChessPanel extends JPanel {

        public ChessPanel() {

            setLayout(new GridBagLayout());


            GridBagConstraints gbc = new GridBagConstraints();
            for (int row = 0; row < 10; row++) {
                for (int col = 0; col < 10; col++) {
                    gbc.gridx = col;
                    gbc.gridy = row;

                    CellPane cellPane = new CellPane();
                    Border border ;

                    boolean isRowEven = (row % 2 == 0);
                    boolean isColEven = (col % 2 == 0);

                    boolean isTileWhite = (isRowEven && isColEven) ||
                            (!isRowEven && !isColEven);

                    Color tileColor = (isTileWhite) ? Color.WHITE
                            : Color.BLACK;

                    cellPane.defaultBackground = tileColor;
                    cellPane.setBackground(tileColor);

                    BufferedImage myPicture = null;
                    if (board[row][col] != null) {
                        try {
                            myPicture = ImageIO.read(new File(board[row][col].getImage()));
                        } catch (IOException | NullPointerException ex) {
                            ex.printStackTrace();
                        }

                        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
                        cellPane.add(picLabel);
                    }
                    add(cellPane, gbc);


                }
            }
        }
    }

    public class CellPane extends JPanel {


         Color defaultBackground;


        public CellPane() {
            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {


                }

                @Override
                public void mousePressed(MouseEvent e) {
                    if (isClicked == true) {
                        setBackground(Color.RED);
                    } else {
                        setBackground(Color.BLUE);
                        
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    //setBackground(defaultBackground);
                    if (isClicked) {
                        isClicked = false;
                    } else {
                        isClicked = true;
                    }

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    //setBackground(defaultBackground);
                }

                @Override
                public void mouseExited(MouseEvent e) {


                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(50, 50);
        }
    }
}