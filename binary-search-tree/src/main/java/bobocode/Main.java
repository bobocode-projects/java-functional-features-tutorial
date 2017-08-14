package bobocode;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree<Integer> intTree = new BinarySearchTree<>();
        intTree.insert(9);
        intTree.insert(2);
        intTree.insert(12);
        intTree.insert(1);
        intTree.insert(7);
        intTree.insert(14);

        Consumer printer = element -> System.out.print(element + " ");

        System.out.println("Height: " + intTree.height());

        System.out.print("\nIn-order traversal: ");
        intTree.inOrderTraversal(printer);

        System.out.print("\nPre-order traversal: ");
        intTree.preOrderTraversal(printer);

        System.out.print("\nPost-order traversal: ");
        intTree.postOrderTraversal(printer);
        System.out.println();

    }


}
