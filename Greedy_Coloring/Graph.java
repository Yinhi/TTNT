package Greedy_Coloring;

import java.util.*;
import java.util.LinkedList;
 
public class Graph
{
    private int Vertex;   
    private LinkedList<Integer> adj[]; 
 
    public Graph(int v)
    {
        Vertex = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    public void addEdge(int v,int w)
    {
        adj[v].add(w);
        adj[w].add(v); 
    }
 
    public void greedyColoring()
    {
        int result[] = new int[Vertex];
        result[0]  = 0;
 
        for (int u = 1; u < Vertex; u++)
            result[u] = -1;  
 
        boolean available[] = new boolean[Vertex];
        for (int cr = 0; cr < Vertex; cr++)
            available[cr] = false;
 
        for (int u = 1; u < Vertex; u++)
        {
            Iterator<Integer> it = adj[u].iterator() ;
            while (it.hasNext())
            {
                int i = it.next();
                if (result[i] != -1)
                    available[result[i]] = true;
            }
 
            int cr;
            for (cr = 0; cr < Vertex; cr++)
                if (available[cr] == false)
                    break;
 
            result[u] = cr; 
 
            it = adj[u].iterator() ;
            while (it.hasNext())
            {
                int i = it.next();
                if (result[i] != -1)
                    available[result[i]] = false;
            }
        }
 
        for (int u = 0; u < Vertex; u++)
            System.out.println("Color of vertex " + u + " ---> "+ result[u]);
    }
 
    public static void main(String args[])
    {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(0, 5);
        g.addEdge(4, 5);
        g.addEdge(1, 4);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.greedyColoring();
    }
}
