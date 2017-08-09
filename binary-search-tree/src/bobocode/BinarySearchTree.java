package bobocode;

import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable> implements BST<T> {
     Node<T> root;

    @Override
    public boolean insert(T element) {
        if (root == null) {
            root = new Node<>(element);
            return true;
        } else {
            return insert(root, element);
        }
    }

    @Override
    public int height() {
        return height(root) - 1;
    }

    private int height(Node<T> node) {
        if (node != null) {
            return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        } else {
            return 0;
        }
    }

    private boolean insert(Node<T> node, T element) {
        if (node.getElement().compareTo(element) > 0) {
            if (node.getLeft() != null) {
                return insert(node.getLeft(), element);
            } else {
                node.setLeft(new Node<>(element));
                return true;
            }
        } else if (node.getElement().compareTo(element) < 0) {
            if (node.getRight() != null) {
                return insert(node.getRight(), element);
            } else {
                node.setRight(new Node<>(element));
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public void inOrderTraversal(Consumer<T> consumer) {
        inOrderTraversal(consumer, root);
    }

    private void inOrderTraversal(Consumer<T> consumer, Node<T> node) {
        if (node != null) {
            inOrderTraversal(consumer, node.getLeft());
            consumer.accept(node.getElement());
            inOrderTraversal(consumer, node.getRight());
        }
    }

    @Override
    public void preOrderTraversal(Consumer<T> consumer) {
        preOrderTraversal(consumer, root);
    }

    private void preOrderTraversal(Consumer<T> consumer, Node<T> node) {
        if (node != null) {
            consumer.accept(node.getElement());
            preOrderTraversal(consumer, node.getLeft());
            preOrderTraversal(consumer, node.getRight());
        }
    }

    @Override
    public void postOrderTraversal(Consumer<T> consumer) {
        postOrderTraversal(consumer, root);
    }

    private void postOrderTraversal(Consumer<T> consumer, Node<T> node) {
        if (node != null) {
            postOrderTraversal(consumer, node.getLeft());
            postOrderTraversal(consumer, node.getRight());
            consumer.accept(node.getElement());
        }
    }

}
