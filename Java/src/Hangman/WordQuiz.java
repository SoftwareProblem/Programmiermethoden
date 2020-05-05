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
        if(wordLists==null){
            wordLists = new ArrayList<>();
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
        for(WordList list : wordLists){
            if(list.getSubject().equals(subject)){
                gameList=list;
            } else {
                System.out.println("Ungültiges Subject");
            }
        }
        boolean gameFinished = false;
        String searchedWord;
        searchedWord=gameList.getWordOfLength(length);
        char[] guessedCharacters=new char[length];
        while (gameFinished!=true){
            consoleReader.readNextChar();
        }



    }
}
