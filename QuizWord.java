package Hangman;

public class QuizWord {
    String word;
    int length;

    public QuizWord(String word){length=word.length();}
    public String getWord(){return word;}
    public int getLength(){return length;}
}
