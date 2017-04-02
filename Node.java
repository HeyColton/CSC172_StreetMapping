import java.util.ArrayList;

/*Name:Xiaoyu Zheng
 * Email:xzheng10@u.rochester.edu
 * Project Number: 4
 * Lab Section: Tue 2:00 pm and Thu 2:00 pm
 */

public class Node {
	double dist;
	Boolean known;
	Node path;
	Boolean visited = false;
	double lattitude, longitude;
	String StringID;
	public int heapindex = 0;
	public ArrayList<Edge> adjEdge = new ArrayList<Edge>();
	public Node prev;

	public Node(String StringID, double lattitude, double longitude) {
		this.StringID = StringID;
		this.lattitude = lattitude;
		this.longitude = longitude;
	}

	public int compareTo(Node a) {

		if (dist > a.dist) {
			return 1;
		}
		if (dist <= a.dist) {

			return -1;
		}

		return 0;

	}

	public void printpath() {
		if (prev != null) {
			prev.printpath();
		}
		System.out.println(this.StringID);

	}
}
