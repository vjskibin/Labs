package lab1;

public class HuffmanTreeApp {

    public static void main(String[] args) {
        String text = "it is itis";

        int[] charFrequencies = new int[256];
        for (char c : text.toCharArray()) {
            charFrequencies[c]++;
        }

        HuffmanTree tree = HuffmanTree.buildHuffmanTree(charFrequencies);
        System.out.printf("size before compression = %d%n", text.length() * 8);
        String incoded = tree.incode(text);
        System.out.println("incoded result = " + incoded);
        System.out.printf("size after compression = %d%n", incoded.length());

        tree.printCodes();
    }

}
