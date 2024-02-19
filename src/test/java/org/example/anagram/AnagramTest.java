package org.example.anagram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class AnagramTest {
    private AnagramRepository anagramRepository;
    private Anagram anagram;

    @BeforeEach
    public void setUp() {
        anagramRepository = new AnagramRepository();
        anagram = new Anagram(anagramRepository);
    }

    @Test
    void testAreAnagramsAndStoreInput_Anagrams() {

        String firstText = "William Shakespeare";
        String secondText = "I am a weakish speller";

        boolean result = anagram.areAnagramsAndStoreInput(firstText, secondText);

        Map<String, Set<String>> storedValuesMap = anagramRepository.getUserInputs();

        assertTrue(result);
        assertTrue(containsAll(storedValuesMap, List.of(firstText, secondText)));
    }

    @Test
    void testAreAnagramsAndStoreInput_AnagramsWithSpecialCharacters() {

        String firstText = "McDonald's restaurants";
        String secondText = "Uncle - Sam's standard rot !$%";

        boolean result = anagram.areAnagramsAndStoreInput(firstText, secondText);

        Map<String, Set<String>> storedValuesMap = anagramRepository.getUserInputs();

        assertTrue(result);
        assertTrue(containsAll(storedValuesMap, List.of(firstText, secondText)));
    }

    @Test
    void testAreAnagramsAndStoreInput_NonAnagrams() {

        String firstText = "Simple String";
        String secondText = "New String";

        boolean result = anagram.areAnagramsAndStoreInput(firstText, secondText);

        Map<String, Set<String>> storedValuesMap = anagramRepository.getUserInputs();

        assertFalse(result);
        assertTrue(containsAll(storedValuesMap, List.of(firstText, secondText)));
    }

    @Test
    void testAreAnagramsAndStoreInput_NullAsInputParam() {

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            anagram.areAnagramsAndStoreInput(null, "SimpleString");
        });

        assertEquals("Input text cannot be null!", exception.getMessage());
    }

    @Test
    void testFindAnagrams_TwoAnagramsFound() {
        anagramRepository.saveUserInput("aet", "ate");
        anagramRepository.saveUserInput("aet", "tea");

        Set<String> foundAnagrams = anagram.findAnagrams("eat");

        assertTrue(foundAnagrams.containsAll(List.of("tea", "ate")));
    }

    @Test
    void testFindAnagrams_OneAnagramFoundAndSameWordIgnored() {
        anagramRepository.saveUserInput("aet", "eat");
        anagramRepository.saveUserInput("aet", "tea");

        Set<String> foundAnagrams = anagram.findAnagrams("eat");

        assertTrue(foundAnagrams.contains("tea"));
    }

    @Test
    void testFindAnagrams_noAnagramsFound() {
        Set<String> foundAnagrams = anagram.findAnagrams("eat");

        assertTrue(foundAnagrams.isEmpty());
    }

    private boolean containsAll(Map<String, Set<String>> storedValues, List<String> listOfValues) {
        Set<String> allValues = new HashSet<>();
        for (Set<String> set : storedValues.values()) {
            allValues.addAll(set);
        }

        return allValues.containsAll(listOfValues);
    }
}