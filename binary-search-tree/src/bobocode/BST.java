package bobocode;

import java.util.function.Consumer;

public interface BST<T extends Comparable> {
    boolean insert(T element);

    int height();

    void inOrderTraversal(Consumer<T> consumer);

    void preOrderTraversal(Consumer<T> consumer);

    void postOrderTraversal(Consumer<T> consumer);
}
