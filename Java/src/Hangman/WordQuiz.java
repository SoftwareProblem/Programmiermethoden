package Hangman;

import java.io.BufferedReader;
import java.util.ArrayList;

public class WordQuiz {
    private ArrayList<WordList> wordLists;
    private ConsoleReader consoleReader;

    public boolean addWordList(WordList wordList) {
        if (wordList==null){
            return false;
        }
        for (WordList list : wordLists) {
            if (wordList.getSubject().equals(list.getSubject())) {
                return false;
            }
        }
        wordLists.add(wordList);
        return true;
    }

    public void deleteWordList(WordList wordList) {
        if (wordList.getSubject()==null){
            return;
        }
        wordLists.removeIf(list -> list.getSubject().equals(wordList.getSubject()));
    }

    public void setConsoleReader(ConsoleReader consoleReader) {
        this.consoleReader=consoleReader;
    }

    public void addWriter(Writer writer) {
    }

    public void playgame() {
        playGame(5, Subject.Animals, Difficulty.EASY);
    }

    public void playGame(int length) {
        playGame(length, Subject.Animals, Difficulty.EASY);
    }

    public void playGame(Subject subject) {
        playGame(5, subject, Difficulty.EASY);
    }

    public void playGame(Difficulty difficulty) {
        playGame(5, Subject.Animals, difficulty);
    }

    public void playGame(int length, Difficulty difficulty) {
        playGame(length, Subject.Animals, difficulty);
    }

    public void playGame(Subject subject, Difficulty difficulty) {
        playGame(5, subject, difficulty);
    }

    public void playGame(int length, Subject subject) {
        playGame(length, subject, Difficulty.EASY);
    }

    public void playGame(int length, Subject subject, Difficulty difficulty) {
        //Writer writer = new ConsoleWriter(subject, difficulty, new WordList(subject).getWordOfLength(length));
        WordList gameList=null;
        switch (subject){
            case Animals:
                gameList=wordListAnimals;
                break;
            case Cars:
                gameList=wordListCars;
                break;
            case Videogames:
                gameList=wordListVideoGames;
                break;
            case Softdrinks:
                gameList=wordListSoftDrinks;
                break;
            case Wuppi:
                gameList=wordListWuppi;
                break;
        }
        int triesLeft=0;
        switch (difficulty){
            case EASY:
                triesLeft=15;
                break;
            case NORMAL:
                triesLeft=10;
                break;
            case HARD:
                triesLeft=5;
                break;
            case EXTREM:
                triesLeft=1;
                break;
        }

        String searchedWord;
        int newLength=length;
        while (gameList.getWordOfLength(newLength)==null){
            System.out.println("Kein Wort dieser Länge gefunden.\nBitte geben sie eine andere Länge ein.");
            //input auf int Parsen
            System.out.println(newLength);
        }
        searchedWord=gameList.getWordOfLength(length);
        char[] guessedCharacters=new char[length];
        while (triesLeft>0){
            consoleReader.readNextChar();

        }



    }
}
