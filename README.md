# Anagram Checker

Anagram Checker is a Java program that allows users to check if two texts are anagrams of each other and find anagrams for a given text. The program stores the input used for anagram comparison, and use it as data set for the anagram finder feature.

## Features

- **Check If Anagrams**: Verify if two texts are anagrams of each other, and store the input for later use in the anagram finder feature.
- **Find Anagrams**: Retrieve a set of anagrams, out of the already stored data, for a given text.

## Installation

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/NikolaMladenovski/BackendTask.git
    ```
   
2. Build the project using Maven:

    ```bash
    mvn clean install
    ```

## Usage
1. Run the program from IDE
- Clone or download the repository to your machine, and open the project in the preferred IDE.
- Navigate to the main class(`Main.java`), and run the program.

2. Run the jar file
- First build the JAR file, and navigate to the directory containing the file.
- Run the program using the following command: 
- ```bash 
  java -jar BackendTask-1.0.0.jar 
  ```
-The following anagrams from Wikipedia can be used as an example:
```
New York Times = monkeys write
Church of Scientology = rich-chosen goofy cult
McDonald's restaurants = Uncle Sam's standard rot
coronavirus = carnivorous
She Sells Sanctuary = Santa; shy, less cruel or Satan; cruel, less shy
```

## Testing
Anagram Checker includes unit tests to ensure the correctness of its functionality. To run the tests, either execute the following command:
```bash
mvn test
```

Or navigate to the test class(`AnagramTest.java`), using an IDE and run the tests.