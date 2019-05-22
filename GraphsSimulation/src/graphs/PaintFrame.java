package graphs;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

class PaintFrame extends JFrame implements ActionListener{
	private ArrayList<Node> nodes ;
	private Icon quitI,delete,add;
	private JPanel buttonPanel ; 
	private PaintPanel paintPanel ; 
	private JButton addButton , deleteNode ,quit; 
	

	public PaintFrame () { 
		super("Graphs Simulation") ; 
		nodes = new ArrayList<Node>() ; 
		//Button Creation
		addButton = new JButton("Add New Node");  
		deleteNode = new JButton("Delete Node") ; 
		quit = new JButton("Quit"); 
		quitI = new ImageIcon("quit.png");
		quit.setIcon(quitI);
		add = new ImageIcon("plus.png");
		delete = new ImageIcon("delete.png");
		addButton.setIcon(add);
		deleteNode.setIcon(delete);
		//Button Registration
		addButton.addActionListener(this);
		deleteNode.addActionListener(this);
		quit.addActionListener(this);
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(addButton);
		
		buttonPanel.add(deleteNode);
		buttonPanel.add(quit);
		setLayout(new BorderLayout());
		add(buttonPanel,BorderLayout.SOUTH);
		paintPanel = new PaintPanel(nodes);
		
		add(paintPanel, BorderLayout.CENTER);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//int x ,y;
		if(e.getSource() == quit) 
			System.exit(0);
		else if (e.getSource() == addButton) {
			String k = JOptionPane.showInputDialog(null, "Enter the key of the Node");
			Node n = new Node(k);
			nodes.add(n);
			/*x = 450*(int)Math.random()+ 50 ; 
			y = 450*(int)Math.random()+ 50 ;
			n.setXP(x);
			n.setYP(y);*/
			paintPanel.moving=true;
			paintPanel.repaint();
			paintPanel.validate();
			
			
			
			
		}
		else if ( e.getSource() == deleteNode) {
			String key = JOptionPane.showInputDialog("Enter the Node you want to delete");
			int i = nodes.indexOf(new Node(key)); 
			if(i<0) 
				JOptionPane.showMessageDialog(null, "the key doesn't exist");
			else 
				nodes.remove(i);
			for(Node node :nodes) {
				i = node.getAdjacents().indexOf(new Node(key)); 
				if(i>0) {
					node.getAdjacents().remove(i);
				}
			}	
			paintPanel.repaint();
		}

	}
			
}

