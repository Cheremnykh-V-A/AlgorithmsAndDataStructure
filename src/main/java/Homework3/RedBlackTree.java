package Homework3;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root; // Корень дерева

    // Внутренний класс, представляющий узел дерева
    private class Node {
        Key key;
        Value value;
        Node left, right;
        boolean color;

        public Node(Key key, Value value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    // Проверка, является ли узел красным
    private boolean isRed(Node node) {
        if (node == null) return false;
        return node.color == RED;
    }

    // Вращение влево
    private Node rotateLeft(Node node) {
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        temp.color = node.color;
        node.color = RED;
        return temp;
    }

    // Вращение вправо
    private Node rotateRight(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        temp.color = node.color;
        node.color = RED;
        return temp;
    }

    // Перекрашивание узлов
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    // Вставка ключа и значения в дерево
    public void insert(Key key, Value value) {
        root = insert(root, key, value);
        root.color = BLACK; // Корень всегда черный
    }

    private Node insert(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value, RED);

        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = insert(node.left, key, value);
        else if (cmp > 0) node.right = insert(node.right, key, value);
        else node.value = value;

        // Проверка и исправление нарушений структуры дерева
        if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColors(node);

        return node;
    }

    // Поиск значения по ключу
    public Value get(Key key) {
        Node node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) node = node.left;
            else if (cmp > 0) node = node.right;
            else return node.value;
        }
        return null;
    }
}