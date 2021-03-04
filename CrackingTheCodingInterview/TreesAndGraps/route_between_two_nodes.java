import java.util.*;
/**
 * PSA: I apologize if there are typos here; I did not run this to check,
 * but it looks intuitively fine, in the actual interview, you don't run code on the
 * whiteboard just make sure it makes sense. love :)
 */
// Find out whether there is a route between two nodes
// Shortest way to do that is with bfs

public class MyClass {
    public static void main(String args[]) {
      Graph graph = new Graph();
      
      for (int i = 0; i < 9; i++) {
          Node node = new Node(String.valueOf(i));
          for (int j = 10; j < 20; j++) {
              Node child = new Node(String.valueOf(j));
              node.addChild(child);
          }
          graph.addNode(node);
      }
    }
    public boolean bfs findNode(Graph graph, Node start, Node end) {
        // Add all the start children to a queue
        Queue<Node> queue = new ArrayDeque<>();
        
        for (Node node : graph.getNodes()) {
            node.state = "unvisited";
        }
        start.state = "visiting";
        queue.add(start);
        while (!q.isEmpty()) {
            // Get the current node
            Node node = q.poll();
            // visit this node, and add it's children to the q
            if (node != null) {
                for (Node child : node.children()) {
                    if (child.state.equals("unvisited")) {
                        // Visit child
                        if (child == end) {
                            return true;
                        } else {
                            // visit this child's children
                            child.state = "visiting";
                            // Add it's nodes to the queue
                            queue.offer(child);
                        }
                    }
                }
            }
            node.state = "visited";
        }
        return false;
    }
}

public class Graph {
    public ArrayList<Node> nodes;
    public Graph() {
        this.nodes = new ArrayList<Node>();
    }
    public void addNode(Node node) {
        this.nodes.add(node);
    }
}
public class Node {
    public String name;
    public ArrayList<Node> children;
    
    public Node(String name) {
        this.name = name;
        this.children = new ArrayList<String>();
    }
    public void addChild(Node node) {
        this.children.add(node);
    }
}