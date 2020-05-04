package Hangman;

public abstract class Writer {
    protected Subject subject;
    protected Difficulty difficulty;
    protected String word;

    public Writer(Subject subject, Difficulty difficulty, String string){
        this.subject = subject;
        this.difficulty = difficulty;
        this.word = string;
    }
    public boolean write(char[] charArray, char cha, int failedAttempts){
        return false;
    }
}
