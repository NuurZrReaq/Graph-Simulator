package graphs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class DeleteFrame extends JFrame implements ActionListener 
{
	private ArrayList<Node> nodes ;
	Icon delete;
	public static String [] a;
	public static int selected = -1;
	private JList<String> list;
	private JButton deleteNode;
	public DeleteFrame( ArrayList<Node> n ) {
		// TODO Auto-generated constructor stub
		nodes = n;
		a = new String[nodes.size()];
		for(int i =0; i<nodes.size();i++) {
			a[i] = nodes.get(nodes.indexOf(i)).getKey() ;
		}
		list = new JList<String>(a);
		list.setVisibleRowCount(5);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JPanel panel = new JPanel();
		panel.add(new JScrollPane(list));
		add(panel,BorderLayout.CENTER);
		deleteNode = new JButton("Delete Nodes"); 
		delete = new ImageIcon("delete.png");
		deleteNode.setIcon(delete);
		deleteNode.addActionListener(this);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.add(deleteNode, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		selected = list.getSelectedIndex();
		if(selected >=0)
		nodes.remove(new Node(a[selected]));
		this.dispose();
	}

	
	

}
