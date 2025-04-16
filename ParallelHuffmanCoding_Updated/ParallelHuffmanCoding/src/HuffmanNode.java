
public class HuffmanNode {
    int frequency;
    char character;
    HuffmanNode left, right;

    public HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = this.right = null;
    }
}
