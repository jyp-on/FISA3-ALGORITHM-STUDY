package 예시용;

import java.util.ArrayList;
import java.util.List;

class E2 {
    public static void main(String[] args) {
        Tree2 tree = new Tree2();

        // 노드 생성
        Tree2.Node node0 = tree.addNode(0);
        Tree2.Node node1 = tree.addNode(1);
        Tree2.Node node2 = tree.addNode(2);
        Tree2.Node node3 = tree.addNode(3);
        Tree2.Node node4 = tree.addNode(4);
        Tree2.Node node5 = tree.addNode(5);
        Tree2.Node node6 = tree.addNode(6);
        /*         0
        *     1    2    3
        *   4     5  6
        */
        node0.addNode(node1);
        node0.addNode(node2);
        node0.addNode(node3);
        node1.addNode(node4);
        node2.addNode(node5);
        node2.addNode(node6);

        for (Tree2.Node node: tree.getTreeNode()){
            System.out.print(node.data + "의 노드들은: ");
            for (Tree2.Node n : node.nodeList){
                System.out.print(n.data+" ");
            }
            System.out.println();
        }

        System.out.println(node0.getNodeList().get(1).getNodeList().get(1).data);
    }
}

class Tree2{
    int count;
    List<Node> treeNode= new ArrayList<>();
    public Tree2() {
        count = 0;
    }

    public List<Node> getTreeNode() {
        return treeNode;
    }

    public Node addNode(Object data) {
        Node n = new Node(data);
        treeNode.add(n);
        return n;
    }

    class Node{
        Object data;
        List<Node> nodeList= new ArrayList<>();

        public Node(Object data) {
            this.data = data;
        }

        public void addNode(Node node) {
            nodeList.add(node);
        }

        public List<Node> getNodeList() {
            return nodeList;
        }
    }
}

