package Hangman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class HangmanEntry {



    public static void main(String[] args) throws FileNotFoundException {
        WordQuiz wordQuiz=new WordQuiz();
        ConsoleReader consoleReader=new ConsoleReader(new BufferedReader(new InputStreamReader(System.in)));
        wordQuiz.setConsoleReader(consoleReader);
        WordList[] wordlists = new WordList[]{
                                                new WordList(Subject.Animals),
                                                new WordList(Subject.Cars),
                                                new WordList(Subject.Videogames),
                                                new WordList(Subject.Softdrinks),
                                                new WordList(Subject.Wuppi)
        };
        for(int i=0;i<wordlists.length;i++){
            wordlists[i].readListFromFile("../Java/src/Hangman/Data/words"+i+".txt");
            wordQuiz.addWordList(wordlists[i]);
        }
        wordQuiz.playgame();
    }


}
