package Hangman;

public class ConsoleWriter extends Writer {
    public ConsoleWriter(Subject subject, Difficulty difficulty, String string) {
        super(subject, difficulty, string);
    }
    @Override
    public boolean write(char[] charArray, char cha, int failedAttempts) {
        System.out.println("test");
        return false;
    }
}
