package graphs;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.xml.xpath.XPath;


class PaintPanel extends JPanel {
	private ArrayList<Node> nodes ;
    boolean dragging=false,firstNode=false,moving = false; 
    Node first , second ,dragged=null;
	public PaintPanel(ArrayList<Node> n) {
		// TODO Auto-generated constructor stub
		nodes = n; 
		MouseHandle handler = new MouseHandle();
		addMouseListener(handler);
		addMouseMotionListener(handler);
	}
	private class MouseHandle implements MouseMotionListener,MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			String kString ;
			int x,y,xp,yp;
			if(moving) {
				if(e.isMetaDown()) {
					moving = false; 
					nodes.remove(nodes.size()-1);
					repaint();
				}
				else if(!e.isAltDown()) {
					x=e.getX();
					y=e.getY();
					nodes.get(nodes.size()-1).setXP(x);
					nodes.get(nodes.size()-1).setYP(y);
					repaint();
					validate();
					moving = false;
				}
			}
			else {
				if(e.isMetaDown()) {
			
				x=e.getX();
				y=e.getY();
				
				for(Node node: nodes) {
					xp = Math.abs(x- node.getXP());
					yp = Math.abs(y- node.getYP());
					if(xp<90 && yp <90) {
					kString=JOptionPane.showInputDialog(this,"Enter the New Key"); 
					node.setKey(kString);
					repaint();
					validate();
					break;
					
					}
				}
			}
			else if (!e.isAltDown()) {
				if(firstNode) {
					
					x=e.getX();
					y=e.getY();
					
					for(Node node: nodes) {
						xp = Math.abs(x- node.getXP());
						yp = Math.abs(y- node.getYP());
						if(xp<90 && yp <90) {
						node.getAdjacents().add(first);
						first.getAdjacents().add(node);
						first =null;
						firstNode = false;
						repaint();
						validate();
						break;
						}
					}
				}
				else if(!firstNode){
					x=e.getX();
					y=e.getY();
					
					for(Node node: nodes) {
						xp = Math.abs(x- node.getXP());
						yp = Math.abs(y- node.getYP());
						if(xp<90 && yp <90) {
						first = node;
						firstNode = true;
						break;
						}
					}
				}
			}
		}
	}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			int x,y;
			 if(moving) {
				x=e.getX();
				y=e.getY();
				nodes.get(nodes.size()-1).setXP(x);
				nodes.get(nodes.size()-1).setYP(y);
				repaint();
				validate();
				
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			int x,y,xp,yp;
			x=e.getX();
			y=e.getY();
			  
				dragging = true ; 
				for(Node node: nodes) {
					xp = Math.abs(x- node.getXP());
					yp = Math.abs(y- node.getYP());
					if(xp<90 && yp <90) {
					dragged =node;
					break;
					}
					if(dragged == null) 
						dragging = false;
				}
			}
			
		

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			int x,y;
			x = e.getX();
			y = e.getY();
			if(dragging) {
				dragging =false;
				dragged.setXP(x);
				dragged.setYP(y);
				repaint();
				validate();
				dragged = null;
			}
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			int x,y;
			x=e.getX();
			y=e.getY();
			if(dragging) {
				dragged.setXP(x);
				dragged.setYP(y);
				repaint();
				validate();
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			int x , y ;
		
			// TODO Auto-generated method stub
			if(moving) {
				x=e.getX();
				y=e.getY();
				nodes.get(nodes.size()-1).setXP(x);
				nodes.get(nodes.size()-1).setYP(y);
				repaint();
				validate();
			}
		
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		for(Node nd :nodes) {
			g.setColor(new Color(250, 189, 189));
			g.fillOval(nd.getXP()-10, nd.getYP()-10, 100, 100);
			g.setColor(new Color(0, 0, 0));
			g.drawString(nd.getKey(), nd.getXP()+50, nd.getYP()+50);
		}
		g.setColor(Color.BLACK);
		
		for(Node nd : nodes) {
			for (Node adj : nd.getAdjacents()) {
				g.drawLine(nd.getXP()+20,nd.getYP()+20,adj.getXP()+20,adj.getYP()+20);
			}
		}
	}

}
