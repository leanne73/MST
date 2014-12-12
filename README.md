MST
===

Two Implementations of Minimal Spanning Trees: Kruskal & Prim

Included are two basic implementations of MST algorithms.


KruskalMST takes graphs in the form of a string of ints where the first int is the number of vertices followed by a sequence of edges represented in the form vertex1,vertex2,edgeWeight. Graphs are assumed to be undirected.

Example:
4 1,2,3 2,3,5 3,0,4

This would denote a graph with 4 vertices [0..3] and 3 edges where w(1,2)=3 ; w(2,3)=5 ; w(3,0)=4 if w is the weight function.


PrimMST takes graphs formatted in the the same way except that an additional single integer follows the number of vertices. This number specifies which vertex is to be the root of the growing tree.

Example:
4 1 1,2,3 2,3,5 3,0,4

This indicates the same graph as above with the specified root vertex being 1.
