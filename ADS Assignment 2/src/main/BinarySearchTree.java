package main;

public class BinarySearchTree {
    public Node root;


    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }


    public static BinarySearchTree createBinarySearchTree(int[] numbers) {
        BinarySearchTree bst = new BinarySearchTree();
        for (int num: numbers) {
            bst.add(num);
        }
        return bst;
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean isElement(int value) {
        return containsNodeRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }

        if (value > current.value) {
            current.right = deleteRecursive(current.right, value);
            return current;
        }

        // node found

        // case 1: no children
        if (current.left == null && current.right == null) {
            return null;
        }

        // case 2: only right child
        if (current.left == null) {
            return current.right;
        }

        // case 3: only left child
        if (current.right == null) {
            return current.left;
        }

        // case 4: two children
        int smallestValue = findMin(current.right);
        current.value = smallestValue;
        current.right = deleteRecursive(current.right, smallestValue);
        return current;
    }

    private int findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    public void remove(int value) {
        root = deleteRecursive(root, value);
    }

    public boolean setEmpty() {
        return root == null;
    }

    private int setSizeRecursive(Node x) {
        if (x == null) {
            return 0;
        }
        return setSizeRecursive(x.left) + setSizeRecursive(x.right) + 1;
    }

    public int setSize() {
        return setSizeRecursive(root);
    }


    public int[] toArray() {
        int[] arr = new int[setSize()];
        fillArray(root, arr, new int[]{0});
        return arr;
    }

    private void fillArray(Node node, int[] arr, int[] index) {
        if (node == null) {
            return;
        }

        arr[index[0]++] = node.value;
        fillArray(node.left, arr, index);
        fillArray(node.right, arr, index);
    }

    public BinarySearchTree union(BinarySearchTree T) {
        BinarySearchTree bst = createBinarySearchTree(new int[] {});
        for (int node:this.toArray()) {
            bst.add(node);
        }

        for (int node:T.toArray()) {
            bst.add(node);
        }
        return bst;
    }

    public BinarySearchTree intersection(BinarySearchTree T) {
        BinarySearchTree bst = createBinarySearchTree(new int[] {});
        int[] tree1 = toArray();

        for (int i = 0; i < setSize(); i++) {
            if (T.isElement(tree1[i])) {
                bst.add(tree1[i]);
            }
        }
        return bst;
    }

    public BinarySearchTree difference(BinarySearchTree T) {
        BinarySearchTree bst = createBinarySearchTree(new int[] {});
        int[] tree1 = toArray();

        for (int i = 0; i < setSize(); i++) {
            if (!T.isElement(tree1[i])) {
                bst.add(tree1[i]);
            }
        }
        return bst;
    }

    public boolean subset(BinarySearchTree T) {
        BinarySearchTree bst = createBinarySearchTree(new int[] {});
        int[] tree1 = toArray();
        boolean subset = true;
        for (int i = 0; i < setSize(); i++) {
            if (!T.isElement(tree1[i])) {
                subset = false;
            }
        }
        return subset;
    }
}
