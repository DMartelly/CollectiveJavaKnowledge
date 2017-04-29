package crackingTheCode;

import java.util.ArrayList;
import java.util.List;

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
    }

    private static class Graph {
        List<List<Character>> nodes;

        Graph(int size){
            for (int i = 0; i < size; i++) {
                nodes.add(new ArrayList<>());
            }
        }

        void addEdge(char index, Character c) {
            nodes.get(index - 'a').add(c);
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < nodes.size(); i++) {
                s.append((char) ('a' + i)).append(": ").append(nodes.get(i).toString()).append("\n");
            }
            return s.toString();
        }
    }

}
