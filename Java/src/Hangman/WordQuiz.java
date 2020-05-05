package Hangman;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;

public class WordQuiz {
    private ArrayList<WordList> wordLists;
    private ConsoleReader consoleReader;
    private Writer writer;

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
        this.writer = writer;
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
        boolean gameFinished = false;
        boolean foundSome;
        int failedAttempts = 0;
        char[] guessedCharacters=new char[length];
        char newestChar;
        WordList gameList=null;
        for(WordList list : wordLists){
            if(list.getSubject().equals(subject)){
                gameList=list;
            }
        }
        String searchedWord = gameList.getWordOfLength(length);
        char[] encryptedWord = searchedWord.toCharArray();
        Arrays.fill(encryptedWord, '-');
        writer.setDifficulty(difficulty);
        writer.setWord(searchedWord);
        writer.setSubject(subject);
        while (!gameFinished){
            foundSome = false;
            newestChar = consoleReader.readNextChar();
            for(int i=0;i<length;i++){
                if(searchedWord.charAt(i)==newestChar){
                    encryptedWord[i]=newestChar;
                    foundSome = true;
                }
            }
            if(!foundSome){
                failedAttempts++;
            }
            if(Arrays.equals(searchedWord.toCharArray(), encryptedWord)){
                failedAttempts=-1;
            }
            gameFinished = writer.write(encryptedWord,newestChar,failedAttempts);
        }



    }
}
