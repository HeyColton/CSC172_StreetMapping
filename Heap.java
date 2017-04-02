import java.util.ArrayList;
/*Name:Xiaoyu Zheng
 * Email:xzheng10@u.rochester.edu
 * Project Number: 4
 * Lab Section: Tue 2:00 pm and Thu 2:00 pm
 */

public class Heap {

	public Node[] myheap;
	int lastone = 0;

	public Heap() {

		myheap = new Node[10];
		myheap[0] = null;

	}

	public int fp(int index) {

		return (int) ((index) / 2);

	}

	public void swap(int a, int b) {

		Node tempt1 = myheap[a];
		Node tempt2 = myheap[b];
		int i1 = tempt1.heapindex;
		int i2 = tempt2.heapindex;
		tempt1.heapindex = i2;
		tempt2.heapindex = i1;
		myheap[a] = tempt2;

		myheap[b] = tempt1;

	}

	public void bubbleup(int index) {
		if (index != 1) {
			int pi = fp(index);

			Node parent = myheap[pi];
			Node Child = myheap[index];
			if (Child.compareTo(parent) < 0) {
				swap(pi, index);
				if (pi != 1) {
					bubbleup(pi);
				}
			}
		}

	}

	public void bubbledown(int index) {

		int child1 = 2 * index;
		int child2 = 2 * index + 1;
		if (child1 > lastone) {

		} else if (child2 > lastone) {

			if (myheap[child1].compareTo(myheap[index]) < 0) {

				swap(child1, index);

				bubbledown(child1);
			}

		}

		else {

			Node a = myheap[child1];
			Node b = myheap[child2];
			Node c = myheap[index];
			Double ad = a.dist;
			Double bd = b.dist;
			Double pd = c.dist;
			if (pd < ad && pd < bd) {

			} else if (ad < bd) {

				swap(child1, index);
				bubbledown(child1);
			}

			else {

				swap(child2, index);
				bubbledown(child2);
			}
		}
	}

	public void insert(Node item) {
		// TODO Auto-generated method stub
		try {
			lastone = lastone + 1;
			myheap[lastone] = item;
			item.heapindex = lastone;
			bubbleup(lastone);
		} catch (ArrayIndexOutOfBoundsException e) {

			Node[] newheap = new Node[myheap.length * 2];
			for (int i = 0; i < myheap.length; i++) {

				newheap[i] = myheap[i];

			}
			lastone -= 1;
			myheap = newheap;
			insert(item);

		}

	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (myheap[1] == null) {

			return true;
		}

		return false;
	}

	public int size() {
		// TODO Auto-generated method stub
		int size = 0;
		for (int i = 0; i < myheap.length; i++) {

			if (myheap[i] != null) {
				size += 1;
			}

		}

		return size;
	}

	public Node deleteMin() {
		// TODO Auto-generated method stub
		Node tempt = myheap[1];
		myheap[lastone].heapindex = 0;
		swap(1, lastone);
		myheap[lastone] = null;
		lastone -= 1;

		bubbledown(1);

		return tempt;
	}

	public void decreaseKey(Node a, double value) {
		if (value > a.dist) {
			System.out.println("error! ");
		} else {

			a.dist = value;
			bubbleup(a.heapindex);
		}

	}

	public boolean contain(Node x) {

		if (x.heapindex == 0) {
			return false;
		} else
			return true;

	}

}
			