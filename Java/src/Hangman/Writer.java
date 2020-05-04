package Hangman;

public abstract class Writer {
    private Subject subject;
    private Difficulty difficulty;
    private String word;

    public Writer(Subject subject, Difficulty difficulty, String string){}
    public boolean write(char[] charArray, char cha, int failedAttempts){
        return false;
    }
}
