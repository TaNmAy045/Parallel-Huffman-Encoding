
import java.util.concurrent.ForkJoinPool;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class ParallelHuffmanCoding {

    public static Map<Character, Integer> calculateFrequency(String input) {
        ForkJoinPool pool = new ForkJoinPool();
        int chunkSize = input.length() / 4;
        List<ParallelFrequencyTask> tasks = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int start = i * chunkSize;
            int end = (i == 3) ? input.length() : (i + 1) * chunkSize;
            tasks.add(new ParallelFrequencyTask(input, start, end));
        }

        List<Map<Character, Integer>> results = new ArrayList<>();
        for (ParallelFrequencyTask task : tasks) {
            pool.execute(task);
        }

        for (ParallelFrequencyTask task : tasks) {
            results.add(task.join());
        }

        Map<Character, Integer> combinedFrequencyMap = new HashMap<>();
        for (Map<Character, Integer> result : results) {
            result.forEach((k, v) -> combinedFrequencyMap.put(k, combinedFrequencyMap.getOrDefault(k, 0) + v));
        }

        return combinedFrequencyMap;
    }
}
