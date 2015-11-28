Data structure - Graph
-----------------------
<h5>Graph terminology</h5>
<pre>
 - Vertex
 - Edge
 - Cycle graph
 - Degree
</pre>

<h5>Graph representation</h5>
 - Vertex representation
 - Set of edges representation
 - Adjacency matrix representation
 - Adjacency list representation

<h5>Graph Traversal</h5>
 - Breadth First Search - uses queue
 - Depth First Search - uses stack

<h5>Types of Graph</h5>
 - Undirected graph
 - Directed graph (or) Digraph
 - Weighted Undirected/Digraph
 - DAG (or) Directed Acyclic Graph

<h3>Undirected Graph:-</h3>
<pre>

<i><b>Problems</b></i>
 - <b>Bipartite: </b> Is a graph bipartite?
 - <b>Cycle: </b> Find a cycle.
 - <b>Euler tour: </b> Is there a (general) cycle that uses each edge exactly once?
 	<i>Answer: A connected graph is Eulerian if all vertices have even degree</i>
 - <b>Cycle detection: </b> Find a cycle that visits every vertex exactly once.
 	<i>Answer: Hamiltonian cycle (classic NP-complete problem). Intractable No efficient solution so far</i>
 - <b>Identical: </b>Are two graphs identical except for the vertex names?
 	<i>Answer: No one knows</i> 
 - <b>Crossing Edge: </b>Lay out a graph in the plane without crossing edges?
 - <b></b>
</pre>


<h3>Directed Graph:-</h3>
<pre>
<i><b>Applications</b></i>
 - transportation
 - web and its hyper links
 - food web
 - word net
 - scheduling
 - financial
 - cell phone
 - infectious disease
 - gaming
 - object graph
 - inheritance hierarchy
 - control flow - coding

<i><b>Problems</b></i>
 - <b>Path: </b> Is there a directed path from s to t?
 - <b>Shortest path: </b> What is the shortest path from s to t?
 - <b>Topological sort: </b> Can you draw a digraph so that all edges point upwards?
 - <b>Strong connectivity: </b> Is there a directed path between all pairs of vertices?
 - <b>Transitive closure: </b> For which vertices v and w is there a path from v and w?
 - <b>PageRank: </b> What is the importance of web page?
 - <b>Cycle: </b> Given a digraph, find a directed cycle?
 - <b>Reverse Graph: </b> Reverse the given Graph.
 
 
<i><b>Definition</b></i>
<p>
	<b>Topological order: </b> Linear ordering of its vertices such that for every directed
	edge UV from vertex U to vertex V, U comes before V in the ordering
</p>

<p>
	<b>Strong components: </b>Vertices v and w are strongly connected components when there is a
	 directed path from v to w and directed path from w to v
</p>
</pre> 





