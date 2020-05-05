package Hangman;

public enum Difficulty {
    EASY(15),NORMAL(10),HARD(5),EXTREM(1);

    private final int value;

    Difficulty(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
