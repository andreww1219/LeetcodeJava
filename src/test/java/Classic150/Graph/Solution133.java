package Classic150.Graph;


import java.util.*;

// 克隆图
public class Solution133 {
    private Map<Node, Node> vis = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        if (vis.containsKey(node))
            return vis.get(node);
        Node newNode = new Node();
        newNode.val = node.val;
        newNode.neighbors = new ArrayList<>();
        vis.put(node, newNode);
        for (Node neighbor: node.neighbors)
            newNode.neighbors.add(cloneGraph(neighbor));
        return newNode;
    }
}
