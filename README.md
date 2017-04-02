# CSC172_StreetMapping
The main classes of my program include GUI, Graph and Teste. The rest are basically defined classes.

Teste is a class to input commands and to scan files. It’s also a program to distribute tasks for GUI and Graph.

GUI is a Jpanel class that only draws according to processed data from Graph.

Graph is to build a graph according to data from Teste. First, it will insert roads and intersections. Second, with such data, my program can set height and width for jframe by the max and min lattitudes and longitudes. At last, it will process Dijkstra's algorithm and MST to convey data for drawing in GUI.

Runtime 
Let the number of edges be E, the number of nodes be n.

For basic map:
The runtime for nodes is O(n), because I only build a hashmap in teste and copy it into graph.
O(E)+O(E)=O(E) for edges, because I build a hash map and do evaluation for every edge in the hashmap.
O(n) to find max and min longitude and lattitude, because I change the max and min after every edge input.
For GUI, I draw every edge. The runtime is O(E).
In total, the runtime is O(n)+O(E)

For Dijastra, each time, I extra min from heap and update distance. The worst case is to add all the edges to the heap and delete until no edge can be processed. O(E)

For MST, first we sort the edge list, so the runtime is Elog(E)(java built in sort). Find prev method costs O(E)at worst case.

In total, the runtime is O(E) +O(n)+Elog(E)

Extra Credit: My graph is in good shape that perfectly include my drawing in jframe and you can resize the window. Each time you restart my program or resize the window, you can get the result soon. Moreover, my drawing can clear show the map structure. Basic map is drawn by black lines. Dijastra is red. MST is Blue. Thus, I think my project is worth 20 extra credits.

