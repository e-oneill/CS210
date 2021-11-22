package Labs;
import java.util.Queue;
import java.util.LinkedList;
public class BinaryTree {
    Node root;
    
    public static void main(String[] args) {
        BinaryTree test = createBinaryTree();

        // System.out.println(test.findNode(1));
        // System.out.println(test.findNode(9));
        // System.out.println(test.findNode(11));

        // test.delete(9);
        // System.out.println(test.findNode(9));

        test.depthFirstInOrder(test.root);
        System.out.println();
        test.depthFirstPreOrder(test.root);
        System.out.println();
        test.breadthFirstTraverse();
    }

    private static BinaryTree createBinaryTree() {
        BinaryTree bt = new BinaryTree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        return bt;
    }

    private static BinaryTree createBinaryTree(int clamp) {
        BinaryTree bt = new BinaryTree();

        for (int i = 1; i <= clamp; i++)
        {
            bt.add(i);
        }

        return bt;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (current.value > value) {
            current.left = addRecursive(current.left, value);
        } else if ( current.value < value ) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }

        return current;
    }

    public boolean findNode(int value)
    {
        return findNodeRecursive(root, value);
    }

    private boolean findNodeRecursive(Node current, int value)
    {
        
        if (current == null) {
            return false;
        }
        if (current.value == value) {
            return true;
        }

        if (current.value > value)
        {
           return findNodeRecursive(current.left, value);
        } else {
           return findNodeRecursive(current.right, value);
        }
    }

    public void delete (int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (current.value == value)
        {
            if (current.left == null && current.right == null)
            {
                return null;
            } 
            else if (current.left == null || current.right == null)
            {
                if (current.left == null) { return current.right;}
                return current.left;
            } 
            else
            {
                int smallest = findSmallestValue(current.right);
                current.value = smallest;
                current.right = deleteRecursive(current.right, smallest);
                return current;
            }
        }

        if (current.value > value)
        {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root) {
        if (root.left == null)
        {
            return root.value;
        } else {
            return findSmallestValue(root.left);
        }
    }

    public void depthFirstInOrder(Node n) {
        if (n != null) {
            depthFirstInOrder(n.left);
            System.out.print(" " + n.value);
            depthFirstInOrder(n.right);
        }
    }

    public void depthFirstPreOrder(Node n) {
        if (n != null)
        {
            System.out.print(" " + n.value);
            depthFirstPreOrder(n.left);
            depthFirstPreOrder(n.right);
        }
    }

    public void breadthFirstTraverse() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<Node>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            System.out.print(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }

}


class Node {
    Node parent;
    int value;
    Node left;
    Node right;
    String posDefiner;
    int tier;

    Node (int value) {
        this.value = value;
        right = null;
        left = null;
    }

    Node (int value, int tier, Node parent) {
        this.value = value;
        right = null;
        left = null;
        // this.posDefiner = posDefiner;
        this.tier = tier;
        this.parent = parent;
    }
}