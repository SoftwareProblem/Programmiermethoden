package Hangman;

public class QuizWord {
    String word;
    int length;

    public QuizWord(String word){
        this.word=word;
        length=word.length();}
    public String getWord(){return word;}
    public int getLength(){return length;}
}
