package org.example;

import org.example.anagram.Anagram;
import org.example.anagram.AnagramRepository;

import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        AnagramRepository anagramRepository = new AnagramRepository();
        Anagram anagram = new Anagram(anagramRepository);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to Anagram checker app!");

        while (running) {
            System.out.println("========================");
            System.out.println("Choose an option:");
            System.out.println("1 -> Compare two texts");
            System.out.println("2 -> Find an anagram for a given text");
            System.out.println("3 -> Exit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.println("Comparing two anagrams!:");
                    System.out.println("Enter the first text:");
                    String firstText = scanner.nextLine();

                    System.out.println("Enter the second text:");
                    String secondText = scanner.nextLine();

                    if (anagram.areAnagramsAndStoreInput(firstText, secondText)) {
                        System.out.println("Given texts are anagrams, saving both");
                    } else {
                        System.out.println("The given texts are not anagrams, saving both");
                    }
                }
                case "2" -> {
                    System.out.println("Enter the text :");
                    String text = scanner.nextLine();

                    Set<String> foundAnagrams = anagram.findAnagrams(text);

                    if (foundAnagrams.isEmpty()) {
                        System.out.println("No anagrams were found for the provided text: " + text);
                    } else {
                        System.out.println("The following anagrams were found for the provided text: " + text);
                        foundAnagrams.forEach(System.out::println);
                    }
                }
                case "3" -> {
                    System.out.println("Exiting program");
                    running = false;
                }
                default -> System.out.println("Invalid choice! Please select a valid option.");
            }
        }
        scanner.close();
    }
}