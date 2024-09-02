package 예시용;


import java.util.ArrayList;
import java.util.List;

class E1 {
    public static void main(String[] args) {
        Tree tree = new Tree();

        // 노드 생성
        Tree.Node node0 = tree.addNode(0);
        Tree.Node node1 = tree.addNode(1);
        Tree.Node node2 = tree.addNode(2);
        Tree.Node node3 = tree.addNode(3);
        Tree.Node node4 = tree.addNode(4);
        Tree.Node node5 = tree.addNode(5);
        Tree.Node node6 = tree.addNode(6);
        /*       0
        *     1     2
        *   3  4  5   6
        */
        node0.setLeft(node1);
        node0.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);

        for (Tree.Node node : tree.getTreeNode()){

            System.out.print(node.data + "의 자식 노드는 ");
            if (node.getLeft() !=null)
                System.out.print(" 왼쪽 "+node.getLeft().data);
            if (node.getRight() !=null)
                System.out.print(" 오른쪽 "+node.getRight().data);
            System.out.println();
        }

        //0-> 6
        System.out.println(node0.getRight().getRight().data);
    }
}

class Tree{
    int count;
    List<Node> treeNode= new ArrayList<>();
    public Tree() {
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
        Node left= null;
        Node right=null;

        public Node(Object data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }


}

