package inClass;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class BinarySearchTree implements Set<String> {
    private static class Node {
        String value;
        Node left;
        Node right;

        public Node(String value) {
            this(value, null, null);
        }
        public Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }


    @Override
    public int size() {
        return size(root);
    }
    private int size(Node subRoot) {
        return subRoot == null ? 0 : 1 + size(subRoot.left) + size(subRoot.right);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(Object target) {
        return target instanceof String && contains(root, (String)target);
    }

    private boolean contains(Node subroot, String target) {
        boolean found;
        if (subroot == null) {
            found = false;
        } else if (subroot.value.equals(target)) {
            found = true;
        } else if (subroot.value.compareTo(target) > 0) {
            found = contains(subroot.left, target);
        } else {
            found = contains(subroot.right, target);
        }
        return found;
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(String s) throws IllegalArgumentException {
        boolean added = false;
        if (s == null) {
            throw new IllegalArgumentException();
        }
        if (root == null) {
            root = new Node(s);
            added = true;
        } else {
            added = add(s, root);
        }
        return added;
    }
    private boolean add(String s, Node subRoot) {
        boolean added = false;
        int compareResult = s.compareTo(subRoot.value);
        if (compareResult < 0) {
            if (subRoot.left == null) {
                subRoot.left = new Node(s);
                added = true;
            } else {
                added = add(s, subRoot.left);
            }
        } else if (compareResult > 0) {
            if (subRoot.right == null) {
                subRoot.right = new Node(s);
                added = true;
            } else {
                added = add(s, subRoot.right);
            }
        }
        return added;
    }

    @Override
    public String toString() {
        return toString(root);
    }
    private String toString(Node subRoot) {
        if (subRoot == null) {
            return "";
        }
        String leftStr = toString(subRoot.left);
        String rightStr = toString(subRoot.right);
        return (leftStr.isEmpty() ? "" : leftStr + " ") +
                subRoot.value + (rightStr.isEmpty() ? "" :
                rightStr);
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    public int height() {
        return height(root);
    }

    private int height(Node subRoot) {
        return subRoot == null ? 0 : 1 +
                Math.max(height(subRoot.left), height(subRoot.right));
    }
}
