package lab1;

import java.util.PriorityQueue;

public class HuffmanTree implements Comparable<HuffmanTree> {

    private Node root;

    private HuffmanTree(Node root) {
        this.root = root;
    }

    private static class Node {
        private Integer frequency;
        private Character character;
        private Node leftChild;
        private Node rightChild;

        Node(Integer frequency, Character character) {
            this.frequency = frequency;
            this.character = character;
        }

        Node(HuffmanTree left, HuffmanTree right) {
            frequency = left.root.frequency + right.root.frequency;
            leftChild = left.root;
            rightChild = right.root;
        }

        @Override
        public String toString() {
            return "[id=" + frequency + ", data =" + character + "]";
        }
    }

    public static HuffmanTree buildHuffmanTree(int[] charFrequencies) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<>();
        for (int i = 0; i < charFrequencies.length; i++) {
            if (charFrequencies[i] > 0) {
                trees.offer(new HuffmanTree(new Node(charFrequencies[i], (char)i)));
            }
        }
        while (trees.size() > 1) {
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();
            trees.offer(new HuffmanTree(new Node(a, b)));
        }
        return trees.poll();
    }

    public String incode(String text) {
        String[] codes = codeTable();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            result.append(codes[text.charAt(i)]);
        }
        return result.toString();
    }

    private String[] codeTable() {
        String[] codeTable = new String[256];
        codeTable(root, new StringBuilder(), codeTable);
        return codeTable;
    }

    private void codeTable(Node node, StringBuilder code, String[] codeTable) {
        if (node.character != null) {
            codeTable[node.character] = code.toString();
            return;
        }
        codeTable(node.leftChild, code.append('0'), codeTable);
        code.deleteCharAt(code.length() - 1);
        codeTable(node.rightChild, code.append('1'), codeTable);
        code.deleteCharAt(code.length() - 1);
    }

    public void printCodes() {
        System.out.println("char\t frequency\t binary code");
        printCodes(root, new StringBuilder());
    }

    private void printCodes(Node current, StringBuilder code) {
        if (current.character != null) {
            System.out.println(current.character + "\t " + current.frequency + "\t\t " + code);
        } else {
            printCodes(current.leftChild, code.append('0'));
            code.deleteCharAt(code.length() - 1);
            printCodes(current.rightChild, code.append('1'));
            code.deleteCharAt(code.length() - 1);
        }
    }

    @Override
    public int compareTo(HuffmanTree tree) {
        return root.frequency - tree.root.frequency;
    }

}