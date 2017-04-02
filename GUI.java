import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;
/*Name:Xiaoyu Zheng
 * Email:xzheng10@u.rochester.edu
 * Project Number: 4
 * Lab Section: Tue 2:00 pm and Thu 2:00 pm
 */

public class GUI extends JPanel {
	Graph e;
	HashMap<String, Node> intersections;
	HashMap<String, Edge> roads;
	double minLattitude, maxLattitude, minLongitude, maxLongitude;
	Boolean findPath = false;
	Node end;
	ArrayList<Edge> MST;
	Boolean MSTTF = false;

	public GUI(Graph e) {
		this.e = e;
		intersections = e.intersections;
		roads = e.roads;
		this.minLattitude = e.minLattitude;
		this.maxLattitude = e.maxLattitude;
		this.minLongitude = e.minLongitude;
		this.maxLongitude = e.maxLongitude;

	}

	@Override
	public void paintComponent(Graphics g) {
		
		for (String key : roads.keySet()) {

			Edge road = roads.get(key);
			g.drawLine(getX(intersections.get(road.Intersection1ID).longitude),
					getY(intersections.get(road.Intersection1ID).lattitude),
					getX(intersections.get(road.Intersection2ID).longitude),
					getY(intersections.get(road.Intersection2ID).lattitude));
		}
		
		if (findPath == true) {
			drawShortestPath(g, end);
		}

		if (MSTTF == true) {
			drawMST(g);
			
			for(Edge e:MST){
				g.setColor(Color.BLUE);
				Node i1 = intersections.get(e.Intersection1ID);
				Node i2 = intersections.get(e.Intersection2ID);
				g.drawLine(getX(i1.longitude), getY(i1.lattitude), getX(i2.longitude), getY(i2.lattitude));
			}
		}
	}

	public void drawMST(Graphics g) {

		while (!MST.isEmpty()) {

			Edge road = MST.remove(0);
			g.setColor(Color.BLUE);
			Node i1 = intersections.get(road.Intersection1ID);
			Node i2 = intersections.get(road.Intersection2ID);
			g.drawLine(getX(i1.longitude), getY(i1.lattitude), getX(i2.longitude), getY(i2.lattitude));
		}
	}

	public void drawShortestPath(Graphics g, Node end) {

		g.setColor(Color.red);

		if (end.prev != null) {

			g.drawLine(getX(end.longitude), getY(end.lattitude), getX(end.prev.longitude), getY(end.prev.lattitude));
			drawShortestPath(g, end.prev);
		}
	}

	public int getY(double lattitude) {

		return (int) (getHeight() * (maxLattitude - lattitude) / (maxLattitude - minLattitude));
	}

	public int getX(double longitude) {

		return (int) (getWidth() * (longitude - minLongitude) / (maxLongitude - minLongitude));
	}

}
