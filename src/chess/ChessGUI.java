package chess;

import javax.swing.*;
import java.util.*;
import java.awt.*; 

public class ChessGUI {
	public static void main(String arg[]){

		JFrame frame = new JFrame("The Game of Chess");
		JPanel pane = new JPanel(new GridBagLayout());
		JPanel board= new JPanel(new GridLayout(8,8));
		
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
		
		
		
		pane.add(board);
		frame.add(pane);
		frame.setSize(1000, 1000);
		frame.getContentPane().setPreferredSize(new Dimension(600,600));
		frame.setVisible(true);

	}
}
