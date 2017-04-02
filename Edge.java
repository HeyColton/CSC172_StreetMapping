/*Name:Xiaoyu Zheng
 * Email:xzheng10@u.rochester.edu
 * Project Number: 4
 * Lab Section: Tue 2:00 pm and Thu 2:00 pm
 */
public class Edge {
	public final String Intersection1ID, Intersection2ID; // an edge from v to w
	Boolean visited = false;
	public double weight;
	String StringID;

	public Edge(String StringID, String Intersection1ID, String Intersection2ID) { // your
																					// code
																					// here
		this.StringID = StringID;
		this.Intersection1ID = Intersection1ID;
		this.Intersection2ID = Intersection2ID;

	}

	// cite from stackoverflow:
	// http://stackoverflow.com/questions/365826/calculate-distance-between-2-gps-coordinates
	static double mile(double lat1, double long1, double lat2, double long2) {
		double d2r = 0.0174532925199433;
		double dlong = (long2 - long1) * d2r;
		double dlat = (lat2 - lat1) * d2r;
		double a = Math.pow(Math.sin(dlat / 2.0), 2)
				+ Math.cos(lat1 * d2r) * Math.cos(lat2 * d2r) * Math.pow(Math.sin(dlong / 2.0), 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double d = 3956 * c;

		return d;
	}

	public int compareTo(Edge n2) {
		// TODO Auto-generated method stub
		if (this.weight > n2.weight) {
			return 1;
		} else {
			return -1;
		}
	}
}