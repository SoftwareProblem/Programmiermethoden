package Hangman;

public abstract class Writer {
    protected Subject subject;
    protected Difficulty difficulty;
    protected String word;
    public void setSubject(Subject subject){
        this.subject = subject;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setWord(String word){
        this.word = word;
    }

    public boolean write(char[] charArray, char cha, int failedAttempts){
        return false;
    }
}
