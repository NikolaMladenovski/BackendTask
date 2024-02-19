package org.example.anagram;

import java.util.*;

public class Anagram {

    private final AnagramRepository repository;

    public Anagram(AnagramRepository repository) {
        this.repository = repository;
    }

    /**
     * Checks if the given strings are anagrams and stores the user input.
     *
     * @param firstText  The first string to check.
     * @param secondText The second string to check.
     * @return True if the strings are anagrams, false otherwise.
     */
    public boolean areAnagramsAndStoreInput(String firstText, String secondText) {

        String firstTextSortedLetters = sortLetters(firstText);
        String secondTextSortedLetters = sortLetters(secondText);

        repository.saveUserInput(firstTextSortedLetters, firstText);
        repository.saveUserInput(secondTextSortedLetters, secondText);

        if (firstTextSortedLetters.length() != secondTextSortedLetters.length())
            return false;

        return firstTextSortedLetters.equals(secondTextSortedLetters);
    }

    /**
     * Finds anagrams for the provided text, in the anagramMap where previous user inputs are stored.
     * Excludes the provided text if already present in the set of anagrams.
     *
     * @param text The string to find anagrams for.
     * @return A set of anagrams for the given text, or an empty set if there are no anagrams found.
     */
    public Set<String> findAnagrams(String text) {
        String textSortedLetters = sortLetters(text);

        Set<String> anagrams = repository.getUserInputs().get(textSortedLetters);

        if (anagrams == null) {
            return Set.of();
        }

        anagrams.remove(text);

        return anagrams;
    }

    /**
     * Sorts the letters of the input string.
     *
     * @param text The input text to sort.
     * @return A String that contains only alphabet letters in sorted ascending order.
     */
    private String sortLetters(String text) {
        String optimizedText = extractAlphabetLettersInLowerCase(text);
        char[] charArray = optimizedText.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }

    /**
     * Extracts the alphabet letters from the input string, and converts them in lower case.
     *
     * @param text The text input to extract letters from.
     * @return A string that contains alphabet letters in lower case.
     * @throws IllegalArgumentException If the input text is null.
     */
    private String extractAlphabetLettersInLowerCase(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Input text cannot be null!");
        }

        return text.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }


}
