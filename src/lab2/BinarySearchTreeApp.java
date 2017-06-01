package lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearchTreeApp {
    private static final int SIZE = 20;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < SIZE; i++) {
            int j = (int)(Math.random() * 50);
            System.out.print(j + " ");
            tree.insert(j);
        }
        System.out.println();

        System.out.println("Tree: ");
        tree.display();

        System.out.println("Enter element to delete: ");
        int i = Integer.parseInt(reader.readLine());
        if (tree.delete(i)) System.out.println("Node found - was deleted");
        else System.out.println("Node not found - was not deleted");
        System.out.println("Tree: ");
        tree.display();

        System.out.println("Enter element to find: ");
        i = Integer.parseInt(reader.readLine());
        if (tree.find(i))
            System.out.println("Element found");
        else System.out.println("Element not found");
    }
}
