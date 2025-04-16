
import java.util.*;
import java.util.stream.*;

public class ParallelHuffmanTree {

    public static HuffmanNode buildHuffmanTree(Map<Character, Integer> frequencyMap) {
        PriorityQueue<HuffmanNode> queue = frequencyMap.entrySet().parallelStream()
            .map(entry -> new HuffmanNode(entry.getKey(), entry.getValue()))
            .collect(Collectors.toCollection(() -> new PriorityQueue<>(Comparator.comparingInt(n -> n.frequency))));

        while (queue.size() > 1) {
            HuffmanNode left = queue.poll();
            HuffmanNode right = queue.poll();
            HuffmanNode mergedNode = new HuffmanNode('\0', left.frequency + right.frequency);
            mergedNode.left = left;
            mergedNode.right = right;
            queue.add(mergedNode);
        }

        return queue.poll();
    }

    public static void printHuffmanCodes(HuffmanNode root, String code) {
        if (root == null) return;
        if (root.left == null && root.right == null && root.character != '\0') {
            System.out.println("'" + root.character + "': " + code);
        }
        printHuffmanCodes(root.left, code + "0");
        printHuffmanCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        String input = "this is an example for parallel huffman encoding";
        Map<Character, Integer> frequencyMap = ParallelHuffmanCoding.calculateFrequency(input);
        HuffmanNode root = buildHuffmanTree(frequencyMap);
        System.out.println("Huffman Tree Root: " + root.character + " with frequency " + root.frequency);
        System.out.println("Huffman Codes:");
        printHuffmanCodes(root, "");
    }
}
