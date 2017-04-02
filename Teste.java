/*Name:Xiaoyu Zheng
 * Email:xzheng10@u.rochester.edu
 * Project Number: 4
 * Lab Section: Tue 2:00 pm and Thu 2:00 pm
 */

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JFrame;

public class Teste {
	//check if we use integers or characters
	Boolean integer=true;
	HashMap<String,Node> intersections=new HashMap<String,Node>(390000);
	HashMap<String,Edge> roads=new HashMap<String,Edge>(720000);
	int numOfnode=0;
	int numOfroad=0;
	String startN,endN;
	//read in file and get Graph
	public Graph createFromFile(String filename,String show, String category) {
		
        Scanner in;
		try {
		in = new Scanner(new File(filename));
        while(in.hasNextLine()){
        	String IR=in.next();
        	if(IR.equals("i")){
        		String key=in.next();
        		Node intersection=new Node(key,Double.parseDouble(in.next()),Double.parseDouble(in.next()));
        		intersections.put(key, intersection);
        		numOfnode++;
        	}else{
        		String keye=in.next();
        		Edge road=new Edge(keye,in.next(),in.next());
        	    roads.put(keye, road);
        	    numOfroad++;
        	}
        }
        in.close();
        JFrame jframe=new JFrame("Map");
		jframe.setSize(530,530);
        Graph g=new Graph(intersections);
        g.insertEdges(roads);
        GUI gui=new GUI(g);
        gui.setFocusable(true);
		gui.setPreferredSize(new Dimension(500,500));
        jframe.add(gui);
        jframe.setVisible(show.equals("-show"));
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(category.equals("-directions")){
		Node start=intersections.get(startN);
		Node end=intersections.get(endN);
		g.dijkstra(start, end);
		gui.end=end;
		gui.findPath=true;
		}else{
		gui.MST=g.MST();
		gui.MSTTF=true;
		}
		gui.repaint();
        return g;
        } catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			return null;
		}
}
public void directions(String startN,String endN){
	this.startN=startN;
	this.endN=endN;
}
	public static void main(String[] arg) {
		//you can choose any one to test my program
		
		String filename = arg[0];
		String show = arg[1];
		String category = arg[2];
		Teste t=new Teste();
		if(category.equals("-directions")){
			t.directions(arg[3], arg[4]);
		}
		t.createFromFile(filename,show,category);

	}
}
