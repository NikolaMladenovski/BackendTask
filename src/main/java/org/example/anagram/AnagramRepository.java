package org.example.anagram;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnagramRepository {
    private final Map<String, Set<String>> anagramMap = new HashMap<>();

    /**
     * Saves the user input in the anagramMap, it uses the sorted text letters as a key,
     * and the value is a set where every text that has the same sorted text letters key is stored.
     * @param key The sorted text letters, used as key in the map,
     *                          to easily identify anagrams for the anagram search.
     * @param value The user text input.
     */
    public void saveUserInput(String key, String value) {
        anagramMap.putIfAbsent(key, new HashSet<>());
        anagramMap.get(key).add(value);
    }

    /**
     * Returns the anagramMap that keeps the inputs of the user.
     * @return anagramMap
     */
    public Map<String, Set<String>> getUserInputs() {
        return anagramMap;
    }
}
