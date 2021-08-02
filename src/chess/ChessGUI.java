package chess;

import static chess.Constants.BLACK;
import static chess.Constants.WHITE;
import static chess.Constants.SQUARE_SIZE;
import static chess.Constants.GUI_SIZE;
import static chess.Constants.PANE_SIZE;
import static chess.Constants.BOARD_SIZE;
import static chess.Constants.ROWS;
import static chess.Constants.COLS;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChessGUI extends JFrame implements
ActionListener, MouseListener {

    /**
     * String of the rules of the game.
     */
    private String rules = "The ultimate aim in the "
            + "chess game is delivering a checkmate – "
            + "trapping your opponent´s king.\n"
            + "White is always first to move and players take "
            + "turns alternately moving one piece at a time.\n"
            + "Movement is required. If a player´s turn is to "
            + "move, he is not in check but has no legal moves,\n"
            + "this situation is called “Stalemate” and it ends "
            + "the game in a draw. Each type of piece has\n"
            + "its own method of movement. A piece may be moved "
            + "to another position or may capture an opponent´s\n"
            + "piece, replacing on its square (en passant being "
            + "the only exception). With the exception of the\n"
            + "knight, a piece may not move over or through any "
            + "of the other pieces. When a king is threatened\n"
            + "with capture (but can protect himself or escape), "
            + "it´s called check. If a king is in check, then\n"
            + "the player must make a move that eliminates "
            + "the threat of capture and cannot "
            + "leave the king in check.\n"
            + "Checkmate happens when a king is placed "
            + "in check and there is no legal move to escape. "
            + "Checkmate ends\n"
            + "the game and the side whose king was "
            + "checkmated looses.\n"
            + "King can move exactly one square horizontally, "
            + "vertically, or diagonally.\n"
            + "Queen can move any number of vacant squares "
            + "diagonally, horizontally, or vertically.\n"
            + "Rook can move any number of vacant "
            + "squares vertically or horizontally. "
            + "It also is moved while castling.\n"
            + "Bishop can move any number of vacant squares in any "
            + "diagonal direction.\n"
            + "Knight can move one square along any rank or file "
            + "and then at an angle.\n"
            + "The knight´s movement can also be viewed as an “L” "
            + "or “7″ laid out at any horizontal "
            + "or vertical angle.\n"
            + "Pawns can move forward one square, "
            + "if that square is unoccupied. "
            + "If it has not yet moved, the pawn has the\n"
            + "option of moving two squares forward provided "
            + "both squares in front of the pawn are unoccupied. "
            + "A pawn\n"
            + "cannot move backward. Pawns are the only pieces "
            + "that capture differently from how they move. "
            + "They can capture\n"
            + "an enemy piece on either of the two spaces "
            + "adjacent to the space in front of them "
            + "(i.e., the two squares\n"
            + "diagonally in front of them) but cannot move to "
            + "these spaces if they are vacant. ";

    /** Menu bar to hold fileMenu. */
    private JMenuBar menus;

    /** Menu to hold menu options. */
    private JMenu fileMenu;

    /** Menu item to quit the game. */
    private JMenuItem quitItem;

    /** Menu item to restart the game. */
    private JMenuItem restartItem;

    /** Menu item to view the rules of the game. */
    private JMenuItem rulesItem;

    /** Panel to hold the white captured pieces. */
    private JPanel wJail = new JPanel(new GridLayout(ROWS, 2));

    /** Panel to hold the black captured pieces. */
    private JPanel bJail = new JPanel(new GridLayout(ROWS, 2));
    
    /** Count of white captured pieces. */
    private int wJailCount = 0;
    
    /** Count of black captured pieces. */
    private int bJailCount = 0;

    /** Panel to hold the items displayed on the screen. */
    private JPanel pane = new JPanel(new GridBagLayout());

    /** Panel to hold the chess board. */
    private JPanel board = new JPanel(new GridLayout(ROWS, COLS));

    /** Panel to hold the currently selected space. */
    private JPanel selectedSpace;

    /**
     * Boolean to determine if a space on the board
     * is currently selected.
     */
    private boolean selected = false;

    /** Component of black king. */
    private Component Bking;
    
    /** Component number of white king. */
    private Component Wking;
    /**
     * @param args
     */
    public static void main(final String[] args) {
        ChessGUI gui = new ChessGUI();
        gui.pane.add(gui.wJail);
        gui.pane.add(gui.board);
        gui.pane.add(gui.bJail);
        gui.add(gui.pane);
        gui.setSize(GUI_SIZE, GUI_SIZE);
        gui.setTitle("The Game of Chess");
        gui.getContentPane().setPreferredSize(new Dimension(PANE_SIZE, PANE_SIZE));
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
    }

    /**
     * Sets up GUI and added images of each piece.
     */
    public ChessGUI() {
        int n = 0;
        int a = 1;
        int b = 0;

        for (int i = 0; i < BOARD_SIZE; i++) {
            JPanel label = new JPanel(new GridLayout(1, 1));
            label.add(new JLabel(new ImageIcon()));

            if (i % 2 == a) {
                label.setBackground(Color.darkGray);
            }
            if (i % 2 == b) {
                label.setBackground(Color.white);
            }
            if (i % COLS == COLS - 1) {
                int temp = a;
                a = b;
                b = temp;
            }
            label.addMouseListener(this);
            board.add(label, n);
            n++;
        }
        int next = 0;
        ((JPanel) board.getComponent(next)).remove(0);
        ((JPanel) board.getComponent(next)).add(new JLabel(new ImageIcon("rookB.png")));
        ((JPanel) board.getComponent(++next)).remove(0);
        ((JPanel) board.getComponent(next)).add(new JLabel(new ImageIcon("horseB.png")));
        ((JPanel) board.getComponent(++next)).remove(0);
        ((JPanel) board.getComponent(next)).add(new JLabel(new ImageIcon("bishopB.png")));
        ((JPanel) board.getComponent(++next)).remove(0);
        ((JPanel) board.getComponent(next)).add(new JLabel(new ImageIcon("kingB.png")));
        Bking = board.getComponent(next);
        ((JPanel) board.getComponent(++next)).remove(0);
        ((JPanel) board.getComponent(next)).add(new JLabel(new ImageIcon("queenB.png")));
        ((JPanel) board.getComponent(++next)).remove(0);
        ((JPanel) board.getComponent(next)).add(new JLabel(new ImageIcon("bishopB.png")));
        ((JPanel) board.getComponent(++next)).remove(0);
        ((JPanel) board.getComponent(next)).add(new JLabel(new ImageIcon("horseB.png")));
        ((JPanel) board.getComponent(++next)).remove(0);
        ((JPanel) board.getComponent(next++)).add(new JLabel(new ImageIcon("rookB.png")));
        for (int i = 0; i < COLS; ++i, ++next) {
            ((JPanel) board.getComponent(next)).remove(0);
            ((JPanel) board.getComponent(next)).add(new JLabel(new ImageIcon("pawnB.png")));
        }

        next = BOARD_SIZE - 1;
        ((JPanel) board.getComponent(next)).remove(0);
        ((JPanel) board.getComponent(next)).add(new JLabel(new ImageIcon("rookW.png")));
        ((JPanel) board.getComponent(--next)).remove(0);
        ((JPanel) board.getComponent(next)).add(new JLabel(new ImageIcon("horseW.png")));
        ((JPanel) board.getComponent(--next)).remove(0);
        ((JPanel) board.getComponent(next)).add(new JLabel(new ImageIcon("bishopW.png")));
        ((JPanel) board.getComponent(--next)).remove(0);
        ((JPanel) board.getComponent(next)).add(new JLabel(new ImageIcon("queenW.png")));
        ((JPanel) board.getComponent(--next)).remove(0);
        ((JPanel) board.getComponent(next)).add(new JLabel(new ImageIcon("kingW.png")));
        Wking = board.getComponent(next);
        ((JPanel) board.getComponent(--next)).remove(0);
        ((JPanel) board.getComponent(next)).add(new JLabel(new ImageIcon("bishopW.png")));
        ((JPanel) board.getComponent(--next)).remove(0);
        ((JPanel) board.getComponent(next)).add(new JLabel(new ImageIcon("horseW.png")));
        ((JPanel) board.getComponent(--next)).remove(0);
        ((JPanel) board.getComponent(next--)).add(new JLabel(new ImageIcon("rookW.png")));
        for (int i = 0; i < COLS; ++i, --next) {
            ((JPanel) board.getComponent(next)).remove(0);
            ((JPanel) board.getComponent(next)).add(new JLabel(new ImageIcon("pawnW.png")));
        }
        setupJails();
        setupMenus();
    }

    private void setupMenus() {

        // create quit menu item
        quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(this);

        // create open... item menu
        rulesItem = new JMenuItem("Rules");
        rulesItem.addActionListener(this);

        // create restart menu item
        restartItem = new JMenuItem("Restart");
        restartItem.addActionListener(this);

        // add items to menu
        fileMenu = new JMenu("File");
        fileMenu.add(rulesItem);
        fileMenu.add(restartItem);
        fileMenu.add(quitItem);

        // display menu bar and File menu
        menus = new JMenuBar();
        menus.add(fileMenu);
        setJMenuBar(menus);
    }
    
    private void setupJails() {

        for (int i = 0; i < ROWS * 2; i++) {
            JPanel label = new JPanel(new GridLayout(1, 1));
            label.add(new JLabel(new ImageIcon()));
            //label.addMouseListener(this);
            wJail.add(label, i);
        }
        for (int i = 0; i < ROWS * 2; i++) {
            JPanel label = new JPanel(new GridLayout(1, 1));
            label.add(new JLabel(new ImageIcon()));
            //label.addMouseListener(this);
            bJail.add(label, i);
        }
    }

    /**
     * When the menu is selected it opens, and a menus item can be selected.
     * @param e
     */
    public void actionPerformed(final ActionEvent e) {
        // user selects open...
        if (e.getSource() == rulesItem) {
            JOptionPane.showMessageDialog(this, rules);
        }
        // user selects quit
        if (e.getSource() == quitItem) {
            System.exit(1);
        }
        // user selects restart
        if (e.getSource() == restartItem) {
            resetBoard();
        }
    }

    @Override
    public void mouseClicked(final MouseEvent e) {
        // TODO Auto-generated method stub
    }

    /**
     * When a space is selected from the board, the piece will move or the
     * space will be highlighted.
     * @param e
     */
    public void mousePressed(final MouseEvent e) {

        // calculate the x and y location of clicked square
        int x = e.getComponent().getX() / SQUARE_SIZE + 1;
        if (e.getComponent().getX() == 0) {
            x = 0;
        }
        int y = e.getComponent().getY() / SQUARE_SIZE + 1;
        if (e.getComponent().getY() == 0) {
            y = 0;
        }

        System.out.println("(" + x + ", " + y + ")");

        if (Board.getBoard().isEmpty(x, y)) {
            System.out.println(" is Empty");
        }

        // if a square is not currently selected
        if (!selected) {
            if (!Board.getBoard().isEmpty(x, y)) {
                if (Board.getBoard().getTurn() == WHITE && Board.getBoard().getPiece(x, y).getColor() == WHITE) {

                    // set border to blue
                    ((JPanel) e.getComponent()).setBorder(new LineBorder(Color.BLUE, 2));
                    selected = true;

                    // set currently selected square
                    selectedSpace = (JPanel) e.getComponent();
                } else if (Board.getBoard().getTurn() == BLACK && Board.getBoard().getPiece(x, y).getColor() == BLACK) {
                    // set border to blue
                    ((JPanel) e.getComponent()).setBorder(new LineBorder(Color.BLUE, 2));
                    selected = true;

                    // set currently selected square
                    selectedSpace = (JPanel) e.getComponent();
                }
            }
        } else if (selected) {
            // calculate (x,y) location of previous selected square
            int xSel = selectedSpace.getX() / SQUARE_SIZE + 1;
            if (selectedSpace.getX() == 0) {
                xSel = 0;
            }

            int ySel = selectedSpace.getY() / SQUARE_SIZE + 1;
            if (selectedSpace.getY() == 0) {
                ySel = 0;
            }

            // if the same square is selected, then un-select it
            if (xSel == x && ySel == y && selected) {

                selected = false;
                ((JPanel) e.getComponent()).setBorder(new LineBorder(null));
                selectedSpace.setBorder(new LineBorder(null));

            } else if (Board.getBoard().getPiece(xSel, ySel).isValidMove(x, y) && Board.getBoard().getPiece(xSel, ySel).getColor() == Board.getBoard().getTurn()) {

                /* if the move is valid, highlight space, move piece and move GUI label */
                moveLabel(selectedSpace, (JPanel) e.getComponent());
                ((JPanel) e.getComponent()).setBorder(new LineBorder(Color.RED, 2));
                Piece captured = Board.getBoard().getPiece(xSel, ySel).move(x, y);
                Board.getBoard().togleTurn();

                if (captured != null) {
                    moveToJail(captured);
                }

                selected = false;
                ((JPanel) e.getComponent()).setBorder(new LineBorder(null));
                selectedSpace.setBorder(new LineBorder(null));
                kingCheck();
            }
        }
    }

    /**
     * Moves picture of piece.
     * @param moveFrom
     * @param moveTo
     */
    public void moveLabel(final JPanel moveFrom, final JPanel moveTo) {

        Board getBoard = Board.getBoard();

        moveTo.removeAll();
        moveFrom.removeAll();

        int x = moveFrom.getX() / SQUARE_SIZE + 1;
        if (moveFrom.getX() == 0) {
            x = 0;
        }
        int y = moveFrom.getY() / SQUARE_SIZE + 1;
        if (moveFrom.getY() == 0) {
            y = 0;
        }

        if (getBoard.getPiece(x, y).getColor() == BLACK) {
            if (getBoard.getPiece(x, y) instanceof Pawn) {
                moveTo.add(new JLabel(new ImageIcon("pawnB.png")));
            } else if (getBoard.getPiece(x, y) instanceof Rook) {
                moveTo.add(new JLabel(new ImageIcon("rookB.png")));
            } else if (getBoard.getPiece(x, y) instanceof Queen) {
                moveTo.add(new JLabel(new ImageIcon("queenB.png")));
            } else if (getBoard.getPiece(x, y) instanceof King) {
                moveTo.add(new JLabel(new ImageIcon("kingB.png")));
                Bking = moveTo;
            } else if (getBoard.getPiece(x, y) instanceof Knight) {
                moveTo.add(new JLabel(new ImageIcon("horseB.png")));
            } else if (getBoard.getPiece(x, y) instanceof Bishop) {
                moveTo.add(new JLabel(new ImageIcon("bishopB.png")));
            }
        }
        if (getBoard.getPiece(x, y).getColor() == WHITE) {
            if (getBoard.getPiece(x, y) instanceof Pawn) {
                moveTo.add(new JLabel(new ImageIcon("pawnW.png")));
            } else if (getBoard.getPiece(x, y) instanceof Rook) {
                moveTo.add(new JLabel(new ImageIcon("rookW.png")));
            } else if (getBoard.getPiece(x, y) instanceof Queen) {
                moveTo.add(new JLabel(new ImageIcon("queenW.png")));
            } else if (getBoard.getPiece(x, y) instanceof King) {
                moveTo.add(new JLabel(new ImageIcon("kingW.png")));
                Wking = moveTo;
            } else if (getBoard.getPiece(x, y) instanceof Knight) {
                moveTo.add(new JLabel(new ImageIcon("horseW.png")));
            } else if (getBoard.getPiece(x, y) instanceof Bishop) {
                moveTo.add(new JLabel(new ImageIcon("bishopW.png")));
            }
        }
        kingCheck();
        board.revalidate();
        board.repaint();
        pane.revalidate();
        pane.repaint();
    }
    
    /**
     * Adds piece to jail.
     * @param p
     */
    public void moveToJail(final Piece p) {
        if (p.getColor() == BLACK) {
            if (p instanceof Pawn) {
                ((JPanel) bJail.getComponent(bJailCount)).remove(0);
                ((JPanel) bJail.getComponent(bJailCount)).add(new JLabel(new ImageIcon("pawnB.png")));
            } else if (p instanceof Rook) {
                ((JPanel) bJail.getComponent(bJailCount)).remove(0);
                ((JPanel) bJail.getComponent(bJailCount)).add(new JLabel(new ImageIcon("rookB.png")));
            } else if (p instanceof Queen) {
                ((JPanel) bJail.getComponent(bJailCount)).remove(0);
                ((JPanel) bJail.getComponent(bJailCount)).add(new JLabel(new ImageIcon("Queen.png")));
            } else if (p instanceof King) {
                ((JPanel) bJail.getComponent(bJailCount)).remove(0);
                ((JPanel) bJail.getComponent(bJailCount)).add(new JLabel(new ImageIcon("kingB.png")));
            } else if (p instanceof Knight) {
                ((JPanel) bJail.getComponent(bJailCount)).remove(0);
                ((JPanel) bJail.getComponent(bJailCount)).add(new JLabel(new ImageIcon("horseB.png")));
            } else if (p instanceof Bishop) {
                ((JPanel) bJail.getComponent(bJailCount)).remove(0);
                ((JPanel) bJail.getComponent(bJailCount)).add(new JLabel(new ImageIcon("bishopB.png")));
            }
            bJailCount++;
            bJail.revalidate();
            bJail.repaint();
        } else if (p.getColor() == WHITE) {
            if (p instanceof Pawn) {
                ((JPanel) wJail.getComponent(wJailCount)).remove(0);
                ((JPanel) wJail.getComponent(wJailCount)).add(new JLabel(new ImageIcon("pawnW.png")));
            } else if (p instanceof Rook) {
                ((JPanel) wJail.getComponent(wJailCount)).remove(0);
                ((JPanel) wJail.getComponent(wJailCount)).add(new JLabel(new ImageIcon("rookW.png")));
            } else if (p instanceof Queen) {
                ((JPanel) wJail.getComponent(wJailCount)).remove(0);
                ((JPanel) wJail.getComponent(wJailCount)).add(new JLabel(new ImageIcon("queenW.png")));
            } else if (p instanceof King) {
                ((JPanel) wJail.getComponent(wJailCount)).remove(0);
                ((JPanel) wJail.getComponent(wJailCount)).add(new JLabel(new ImageIcon("kingW.png")));
            } else if (p instanceof Knight) {
                ((JPanel) wJail.getComponent(wJailCount)).remove(0);
                ((JPanel) wJail.getComponent(wJailCount)).add(new JLabel(new ImageIcon("horseW.png")));
            } else if (p instanceof Bishop) {
                ((JPanel) wJail.getComponent(wJailCount)).remove(0);
                ((JPanel) wJail.getComponent(wJailCount)).add(new JLabel(new ImageIcon("bishopW.png")));
            }
            wJailCount++;
            wJail.revalidate();
            wJail.repaint();
        }
        pane.revalidate();
        pane.repaint();
    }

    public void kingCheck() {

        int a = 1;
        int b = 0;

        for (int i = 0; i < BOARD_SIZE; i++) {

            if (i % 2 == a) {
                board.getComponent(i).setBackground(Color.darkGray);
            }
            if (i % 2 == b) {
                board.getComponent(i).setBackground(Color.white);
            }
            if (i % COLS == COLS - 1) {
                int temp = a;
                a = b;
                b = temp;
            }
        }
    
        if (Board.isCheck(BLACK)) {
            Bking.setBackground(Color.red);
        }
        if (Board.isCheck(WHITE)) {
            Wking.setBackground(Color.red);
        }
        board.revalidate();
        board.repaint();
        pane.revalidate();
        pane.repaint();
    }
    
    @Override
    public void mouseReleased(final MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(final MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(final MouseEvent e) {
        // TODO Auto-generated method stub
    }
    
    private void resetBoard() {
        ChessGUI gui = new ChessGUI();
        gui.pane.add(gui.board);
        gui.add(gui.pane);
        gui.setSize(GUI_SIZE, GUI_SIZE);
        gui.setTitle("The Game of Chess");
        gui.getContentPane().setPreferredSize(new Dimension(PANE_SIZE, PANE_SIZE));
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        Board.getBoard().resetBoard();
    }

}
