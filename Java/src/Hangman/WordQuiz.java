package Hangman;

import java.io.BufferedReader;

public class WordQuiz {

    public boolean addWordList(WordList wordList){return false;}
    public void deleteWordList(WordList wordList){}
    public void setConsoleReader(ConsoleReader consoleReader){}
    public void setWriter(Writer writer){}
    public void playgame(){
        playGame(5,Subject.Animals,Difficulty.EASY);
    }
    public void playGame(int length){
        playGame(length,Subject.Animals,Difficulty.EASY);
    }
    public void playGame(Subject subject){
        playGame(5,subject,Difficulty.EASY);
    }
    public void playGame(Difficulty difficulty){
        playGame(5,Subject.Animals,difficulty);
    }
    public void playGame(int length,Difficulty difficulty){
        playGame(length,Subject.Animals,difficulty);
    }
    public void playGame(Subject subject, Difficulty difficulty){
        playGame(5,subject,difficulty);
    }
    public void playGame(int length,Subject subject){
        playGame(length,subject,Difficulty.EASY);
    }
    public void playGame(int length, Subject subject, Difficulty difficulty){
        Writer writer = new ConsoleWriter(subject,difficulty,new WordList(subject).getWordOfLength(length));
        //
        // ConsoleReader reader = new ConsoleReader(new BufferedReader());

    }
}
