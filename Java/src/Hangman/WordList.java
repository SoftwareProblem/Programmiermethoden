package Hangman;

public class WordList {
    private Subject subject;

    public WordList(Subject subject){}
    protected boolean readListFromFile(String file){return false;}
    public String getRandomWord(){return null;}
    public String getWordOfLength(int length){return null;}
    public Subject getSubject(){return null;}
}
