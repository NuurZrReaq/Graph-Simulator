package graphs;

import java.util.ArrayList;
import java.util.Set;



class Node {
	private String key  ; 
	private int xP , yP ;
	private ArrayList<Node> adjacents ; 
	public Node(String key) {
		this.key = key ; 
		adjacents = new ArrayList<Node>();
	}
	public Node(String key , Node ...nodes) {
		this.key=key;
		adjacents = new ArrayList<Node>() ; 
		for(Node node : nodes) {
			adjacents.add(node);
		}
		
	}
	public void addAdjacents (Node ...nodes) {
		for(Node node : nodes) {
			adjacents.add(node);
		}
	}
	public void setKey (String k) { 
		this.key = k ;
	}
	public String getKey () {
		return this.key;
	}
	public ArrayList<Node> getAdjacents (){
		return adjacents ; 
	}
	public void setXP (int x) {
		xP =x;
	}
	public void setYP(int y) {
		yP = y;
	}
	public int getXP() {
		return xP;
	}
	public int getYP() {
		return yP;
	}
	@Override
	public boolean equals(Object o) { 
        if (o == this) {
            return true;
        }
        if (!(o instanceof Node)) {
            return false;
        } 
        Node c = (Node) o;
        return this.key.equals(c.key);
    }

}
