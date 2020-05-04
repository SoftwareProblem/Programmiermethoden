package Hangman;

import java.io.*;
import java.util.*;

public class WordList {
    private Subject subject;
    private ArrayList<QuizWord> wordList;


    public WordList(Subject subject) {
        this.subject = subject;

    }

    /**
     * Reads a List of QuizWords from a file. Returns true if successful else false.
     * @author Sören Kröger
     */
    protected boolean readListFromFile(String file) {

        try {

            File list = new File(file);
            BufferedReader fileReader = new BufferedReader(new FileReader(list));
            String rawList = fileReader.readLine();
            String[] splitList = rawList.split(";");
            wordList = new ArrayList<QuizWord>();
            for (int i = 0; i < splitList.length; i++) {

                QuizWord word = new QuizWord(splitList[i]);
                wordList.add(word);

            }
        }
        catch (FileNotFoundException e) {
            return false;
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public String getRandomWord() {
        if (wordList.isEmpty()) {
            return null;
        }
        Random rand = new Random();
        int i = rand.nextInt(wordList.size());
        return wordList.get(i).getWord();
    }

    /**
     * Returns a Random QuizWord with a given length from the WordList.
     * Returns null if there is no QuizWord with the the given length.
     * @author Sören Kröger
     */
    public String getWordOfLength(int length) {
        if (wordList.isEmpty()) {
            return null;
        }
        ArrayList<QuizWord> wordsOfLength = new ArrayList<QuizWord>();
        QuizWord currentQuizWord = null;
        Iterator<QuizWord> litr = wordList.iterator();
        while (litr.hasNext()) {
            currentQuizWord = litr.next();
            if (currentQuizWord.getLength() == length) {
                wordsOfLength.add(currentQuizWord);


            }

        }

        if (!wordsOfLength.isEmpty()) {
            Random rand = new Random();
            int i = rand.nextInt(wordsOfLength.size());
            String wordOfLength = wordsOfLength.get(i).getWord();
            return wordOfLength;
        }

        return null;
    }

    public Subject getSubject() {
        return subject;
    }
}
