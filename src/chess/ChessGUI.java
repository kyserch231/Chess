package chess;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

public class ChessGUI extends JFrame implements ActionListener{
	private String rules = "The ultimate aim in the chess game is delivering a checkmate – trapping your opponent´s king.\n"
						 + "White is always first to move and players take turns alternately moving one piece at a time.\n"
						 + "Movement is required. If a player´s turn is to move, he is not in check but has no legal moves,\n"
						 + "this situation is called “Stalemate” and it ends the game in a draw. Each type of piece has\n"
						 + "its own method of movement. A piece may be moved to another position or may capture an opponent´s\n"
						 + "piece, replacing on its square (en passant being the only exception). With the exception of the\n"
						 + "knight, a piece may not move over or through any of the other pieces. When a king is threatened\n"
						 + "with capture (but can protect himself or escape), it´s called check. If a king is in check, then\n"
						 + "the player must make a move that eliminates the threat of capture and cannot leave the king in check.\n"
						 + "Checkmate happens when a king is placed in check and there is no legal move to escape. Checkmate ends\n"
						 + "the game and the side whose king was checkmated looses.\n"
						 + "King can move exactly one square horizontally, vertically, or diagonally.\n"
						 + "Queen can move any number of vacant squares diagonally, horizontally, or vertically.\n"
						 + "Rook can move any number of vacant squares vertically or horizontally. It also is moved while castling.\n"
						 + "Bishop can move any number of vacant squares in any diagonal direction.\n"
						 + "Knight can move one square along any rank or file and then at an angle.\n"
						 + "The knight´s movement can also be viewed as an “L” or “7″ laid out at any horizontal or vertical angle.\n"
						 + "Pawns can move forward one square, if that square is unoccupied. If it has not yet moved, the pawn has the\n"
						 + "option of moving two squares forward provided both squares in front of the pawn are unoccupied. A pawn\n"
						 + "cannot move backward. Pawns are the only pieces that capture differently from how they move. They can capture\n"
						 + "an enemy piece on either of the two spaces adjacent to the space in front of them (i.e., the two squares\n"
						 + "diagonally in front of them) but cannot move to these spaces if they are vacant. ";
	
	JMenuBar menus;
    JMenu fileMenu;
    JMenuItem quitItem;
    JMenuItem rulesItem;
    
	JPanel pane = new JPanel(new GridBagLayout());
	JPanel board= new JPanel(new GridLayout(8,8));
    
    public static void main(String args[]){
    	ChessGUI gui = new ChessGUI();
    	gui.pane.add(gui.board);
		gui.add(gui.pane);
		gui.setSize(1000, 1000);
		gui.setTitle("The Game of Chess");
		gui.getContentPane().setPreferredSize(new Dimension(600,600));
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
	}
    
	public ChessGUI() {
		int n=0;int a=1;int b=0;
		
		for (int i=0;i<64;i++){
			JPanel label= new JPanel(new GridLayout(1,1));
			label.add(new JLabel(new ImageIcon()));
			
			if(i%2==a)
				label.setBackground(Color.darkGray);
			if(i%2==b)
				label.setBackground(Color.white);
			
			if(i%8==7){
				int temp=a;
				a=b;
				b=temp;				
			}			
			board.add(label, n);
			n++;
		}
		
		((JPanel) board.getComponent(0)).remove(0);
		((JPanel) board.getComponent(0)).add(new JLabel(new ImageIcon("rookB.png")));
		((JPanel) board.getComponent(1)).remove(0);
		((JPanel) board.getComponent(1)).add(new JLabel(new ImageIcon("horseB.png")));
		((JPanel) board.getComponent(2)).remove(0);
		((JPanel) board.getComponent(2)).add(new JLabel(new ImageIcon("bishopB.png")));
		((JPanel) board.getComponent(4)).remove(0);
		((JPanel) board.getComponent(4)).add(new JLabel(new ImageIcon("queenB.png")));
		((JPanel) board.getComponent(3)).remove(0);
		((JPanel) board.getComponent(3)).add(new JLabel(new ImageIcon("kingB.png")));
		((JPanel) board.getComponent(5)).remove(0);
		((JPanel) board.getComponent(5)).add(new JLabel(new ImageIcon("bishopB.png")));
		((JPanel) board.getComponent(6)).remove(0);
		((JPanel) board.getComponent(6)).add(new JLabel(new ImageIcon("horseB.png")));
		((JPanel) board.getComponent(7)).remove(0);
		((JPanel) board.getComponent(7)).add(new JLabel(new ImageIcon("rookB.png")));
		((JPanel) board.getComponent(8)).remove(0);
		((JPanel) board.getComponent(8)).add(new JLabel(new ImageIcon("pawnB.png")));
		((JPanel) board.getComponent(9)).remove(0);
		((JPanel) board.getComponent(9)).add(new JLabel(new ImageIcon("pawnB.png")));
		((JPanel) board.getComponent(10)).remove(0);
		((JPanel) board.getComponent(10)).add(new JLabel(new ImageIcon("pawnB.png")));
		((JPanel) board.getComponent(11)).remove(0);
		((JPanel) board.getComponent(11)).add(new JLabel(new ImageIcon("pawnB.png")));
		((JPanel) board.getComponent(12)).remove(0);
		((JPanel) board.getComponent(12)).add(new JLabel(new ImageIcon("pawnB.png")));
		((JPanel) board.getComponent(13)).remove(0);
		((JPanel) board.getComponent(13)).add(new JLabel(new ImageIcon("pawnB.png")));
		((JPanel) board.getComponent(14)).remove(0);
		((JPanel) board.getComponent(14)).add(new JLabel(new ImageIcon("pawnB.png")));
		((JPanel) board.getComponent(15)).remove(0);
		((JPanel) board.getComponent(15)).add(new JLabel(new ImageIcon("pawnB.png")));
		
		((JPanel) board.getComponent(63)).remove(0);
		((JPanel) board.getComponent(63)).add(new JLabel(new ImageIcon("rookW.png")));
		((JPanel) board.getComponent(62)).remove(0);
		((JPanel) board.getComponent(62)).add(new JLabel(new ImageIcon("horseW.png")));
		((JPanel) board.getComponent(61)).remove(0);
		((JPanel) board.getComponent(61)).add(new JLabel(new ImageIcon("bishopW.png")));
		((JPanel) board.getComponent(59)).remove(0);
		((JPanel) board.getComponent(59)).add(new JLabel(new ImageIcon("kingW.png")));
		((JPanel) board.getComponent(60)).remove(0);
		((JPanel) board.getComponent(60)).add(new JLabel(new ImageIcon("queenW.png")));
		((JPanel) board.getComponent(58)).remove(0);
		((JPanel) board.getComponent(58)).add(new JLabel(new ImageIcon("bishopW.png")));
		((JPanel) board.getComponent(57)).remove(0);
		((JPanel) board.getComponent(57)).add(new JLabel(new ImageIcon("horseW.png")));
		((JPanel) board.getComponent(56)).remove(0);
		((JPanel) board.getComponent(56)).add(new JLabel(new ImageIcon("rookW.png")));
		((JPanel) board.getComponent(55)).remove(0);
		((JPanel) board.getComponent(55)).add(new JLabel(new ImageIcon("pawnW.png")));
		((JPanel) board.getComponent(54)).remove(0);
		((JPanel) board.getComponent(54)).add(new JLabel(new ImageIcon("pawnW.png")));
		((JPanel) board.getComponent(53)).remove(0);
		((JPanel) board.getComponent(53)).add(new JLabel(new ImageIcon("pawnW.png")));
		((JPanel) board.getComponent(52)).remove(0);
		((JPanel) board.getComponent(52)).add(new JLabel(new ImageIcon("pawnW.png")));
		((JPanel) board.getComponent(51)).remove(0);
		((JPanel) board.getComponent(51)).add(new JLabel(new ImageIcon("pawnW.png")));
		((JPanel) board.getComponent(50)).remove(0);
		((JPanel) board.getComponent(50)).add(new JLabel(new ImageIcon("pawnW.png")));
		((JPanel) board.getComponent(49)).remove(0);
		((JPanel) board.getComponent(49)).add(new JLabel(new ImageIcon("pawnW.png")));
		((JPanel) board.getComponent(48)).remove(0);
		((JPanel) board.getComponent(48)).add(new JLabel(new ImageIcon("pawnW.png")));
		
		setupMenus();
	}
	private void setupMenus(){

        // create quit menu item
        quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(this);

        // create open... item menu
        rulesItem = new JMenuItem("Rules");
        rulesItem.addActionListener(this);
        
        // add items to menu
        fileMenu = new JMenu("File");
        fileMenu.add(rulesItem);
        fileMenu.add(quitItem);

        // display menu bar and File menu
        menus = new JMenuBar();
        menus.add(fileMenu);  
        setJMenuBar(menus);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        // user selects open...
        if (e.getSource() == rulesItem){
        	JOptionPane.showMessageDialog(this, rules);
        } 
        // user selects quit
        if (e.getSource() == quitItem){
            System.exit(1);
        }
	}
}
