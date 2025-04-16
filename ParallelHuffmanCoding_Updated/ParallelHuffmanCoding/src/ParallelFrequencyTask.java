
import java.util.concurrent.RecursiveTask;
import java.util.Map;
import java.util.HashMap;

class ParallelFrequencyTask extends RecursiveTask<Map<Character, Integer>> {
    private String input;
    private int start, end;

    public ParallelFrequencyTask(String input, int start, int end) {
        this.input = input;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Map<Character, Integer> compute() {
        Map<Character, Integer> localFrequencyMap = new HashMap<>();
        for (int i = start; i < end; i++) {
            char c = input.charAt(i);
            localFrequencyMap.put(c, localFrequencyMap.getOrDefault(c, 0) + 1);
        }
        return localFrequencyMap;
    }
}
