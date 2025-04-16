
# Parallel Huffman Coding (Mini Project)

This Java mini-project demonstrates the implementation of Huffman Coding using parallel computing principles.
It uses the ForkJoin Framework to parallelize the frequency analysis and builds a Huffman Tree to generate the Huffman codes.

## Features
- Frequency calculation using Java's ForkJoinPool (parallelism)
- Huffman Tree construction using priority queue
- Huffman code generation for each character

## How to Run
1. Compile all `.java` files in the `src` directory:
   ```sh
   javac src/*.java
   ```

2. Run the main method from `ParallelHuffmanTree`:
   ```sh
   java -cp src ParallelHuffmanTree
   ```

## Example Input
"This is an example for parallel huffman encoding"

## Example Output
```
Huffman Tree Root:  with frequency 48
Huffman Codes:
' ': 01
'a': 1110
'c': 00000
'd': 11110
'e': 101
...
```

## Requirements
- Java 8 or later
