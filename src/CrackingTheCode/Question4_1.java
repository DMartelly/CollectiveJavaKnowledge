package CrackingTheCode;

import java.util.*;

/**
 * Created by Dominick Martelly on 2/7/2017 at 8:46 PM.
 *
 * @author Dominick Martelly
 */
public class Question4_1 {
    public static void main(String[] args) {
        Graph myGraph = new Graph(10);
        myGraph.addEdge('a', 'b');
        myGraph.addEdge('b', 'j');
        myGraph.addEdge('b', 'c');
        myGraph.addEdge('e', 'd');
        myGraph.addEdge('g', 'f');
        myGraph.addEdge('g', 'h');
        myGraph.addEdge('h', 'f');
        myGraph.addEdge('j', 'c');
        System.out.println(myGraph.toString());

        System.out.println(routeBetweenNodes(myGraph, 'a', 'e'));

    }

    private static boolean routeBetweenNodes(Graph graph, char start, char end) {
        LinkedList<ArrayList> q = new LinkedList<>();
        boolean[] markedList = new boolean[graph.numOfNodes()];
        Arrays.fill(markedList, false);
        markedList[start - 'a'] = false;
        q.add(graph.nodes[start - 'a']);

        return false;
    }

    private static class Graph {
        ArrayList<Character>[] nodes;
        Graph(int size){
            nodes = (ArrayList<Character>[]) new ArrayList[size];
            for (int i = 0; i < nodes.length; i ++){
                nodes[i] = new ArrayList<Character>();
            }
        }

        void addEdge(char index, Character c) {
            nodes[index - 'a'].add(c);
        }

        Character remove(int index, char c) {
            return nodes[index].remove(c);
        }

        int numOfNodes(){
            return nodes.length;
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < nodes.length; i++) {
                s.append((char)('a' + i)).append(": ").append(nodes[i].toString()).append("\n");
            }
            return s.toString();
        }
    }

}
