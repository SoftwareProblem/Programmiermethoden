package Hangman;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class WordList {
    private Subject subject;
    private List<QuizWord> wordList;

    public WordList(Subject subject) {
        this.subject = subject;
    }

    /**
     * Reads a List of QuizWords from a file. Returns true if successful else false.
     * @author Sören Kröger
     */
    protected boolean readListFromFile(String file) {
        try {
            Reader fileReader = new BufferedReader(new FileReader(file));
            String rawList = fileReader.toString();
            String[] splitList = rawList.split("\n");
            for (int i = 0; i < splitList.length; i++) {

                wordList.add(new QuizWord(splitList[i]));

            }
        } catch (FileNotFoundException e) {
            return false;
        }

        return true;
    }

    public String getRandomWord() {
        if (wordList.isEmpty()){return null;}
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
        if (wordList.isEmpty()){return null;}
        List<QuizWord> wordsOfLength = null;
        ListIterator<QuizWord> litr = wordList.listIterator();
        QuizWord currentQuizWord = null;
        while (litr.hasNext()) {
            currentQuizWord = litr.next();
            if (currentQuizWord.getLength() == length) {
                wordsOfLength.add(currentQuizWord);


            }

        }

        if (wordsOfLength != null) {
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
