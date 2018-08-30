import java.util.Arrays;
import java.util.HashMap;

public class BuildingSentence {
    public static void main(String[] args) {
        HashMap<String, Integer> dictionary = new HashMap<>();
        dictionary.put("a", 1);
        dictionary.put("b", 2);
        dictionary.put("ab", 2);
        dictionary.put("aba", 1);
        int maxWordLength = -1;
        for (String word : dictionary.keySet()) {
            maxWordLength = Math.max(maxWordLength, word.length());
        }
        String sentence = "aabbaba";
        int answer = findMinWeight(sentence, dictionary, maxWordLength);
        int optimizedAnswer = findMinWeightOptimized(sentence, dictionary, maxWordLength);
        System.out.println(answer + " " + optimizedAnswer);
    }

    public static int findMinWeightOptimized(String sentence, HashMap<String, Integer> dictionary, int maxWordLength) {
        // O(m) space complexity
        int[] cache = new int[maxWordLength];
        // Placeholder value
        Arrays.fill(cache, -1);

        // O(n) where n is the # of characters within the sentence
        for (int i = 0; i < sentence.length(); i++) {
            int minSum = Integer.MAX_VALUE;

            // If the current window length is less than the maximum length of the word within the dictionary,
            // then proceed to look it up within the dictionary
            if (i + 1 <= maxWordLength) {
                String windowString = sentence.substring(i, i + 1);
                // Found the window word within the dictionary
                if (dictionary.containsKey(windowString)) {
                    minSum = dictionary.get(windowString);
                }
            }

            // O(m) where m is the maximum length of a word within the dictionary
            for (int j = 0; j < cache.length; j++) {
                int previousSum = cache[j];
                int newIndex = i - (j + 1);
                // If the window is not out of bounds or the cache has been filled,
                // then proceed to try to look them up within the dictionary
                if (previousSum != -1 && newIndex >= 0) {
                    String windowString = sentence.substring(newIndex + 1, i + 1);
                    // Found the window word within the dictionary
                    if (dictionary.containsKey(windowString)) {
                        int totalSum = dictionary.get(windowString) + previousSum;
                        minSum = Math.min(minSum, totalSum);
                    }
                }
            }

            // Update the cache by removing the last value of the cache
            for (int j = cache.length - 1; j >= 1; j--) {
                cache[j] = cache[j - 1];
            }
            cache[0] = minSum;
        }
        return cache[0];
    }

    public static int findMinWeight(String sentence, HashMap<String, Integer> dictionary, int maxWordLength) {
        // O(n) space complexity
        int[] cache = new int[sentence.length()];

        // O(n) where n = # of characters of the string
        for (int i = 0; i < cache.length; i++) {
            // Placeholder value for minimum sum
            int minSum = Integer.MAX_VALUE;

            // If the current window length is less than the maximum length of the word within the dictionary,
            // then proceed to look it up within the dictionary
            if (i + 1 <= maxWordLength) {
                String windowString = sentence.substring(i, i + 1);
                // Found the valid window word
                if (dictionary.containsKey(windowString)) {
                    minSum = dictionary.get(windowString);
                }
            }

            // You only need to look back by the maximum length of the word within the dictionary
            // O(m) where m = max length of the word in the dictionary
            for (int j = 1; j <= maxWordLength; j++) {
                int newIndex = i - j;
                if (newIndex >= 0) {
                    int lookbackSum = cache[newIndex];
                    String windowString = sentence.substring(newIndex + 1, i + 1);

                    // Found the valid window word
                    if (dictionary.containsKey(windowString)) {
                        int windowWeight = dictionary.get(windowString);
                        int totalSum = lookbackSum + windowWeight;
                        minSum = Math.min(minSum, totalSum);
                    }
                }
            }
            cache[i] = minSum;
        }
        return cache[cache.length - 1];
    }
}
