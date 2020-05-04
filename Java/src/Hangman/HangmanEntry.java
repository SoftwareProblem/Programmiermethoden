package Hangman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class HangmanEntry {



    public static void main(String[] args) throws FileNotFoundException {
        WordQuiz wordQuiz=new WordQuiz();
        ConsoleReader consoleReader=new ConsoleReader(new BufferedReader(new InputStreamReader(System.in)));
        wordQuiz.setConsoleReader(consoleReader);
        WordList animalList=new WordList(Subject.Animals);
        WordList carsList=new WordList(Subject.Cars);
        WordList videoGamesList=new WordList(Subject.Videogames);
        WordList softDrinksList=new WordList(Subject.Softdrinks);
        WordList wuppiList=new WordList(Subject.Wuppi);
        animalList.readListFromFile("../Java/src/words.txt");
        System.out.println(animalList.getWordOfLength(9));
        System.out.println(wordQuiz.addWordList(animalList));
        //wordQuiz.playgame();
    }


}
