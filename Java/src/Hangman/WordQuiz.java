package Hangman;

import java.util.ArrayList;
import java.util.Arrays;

public class WordQuiz {
    private ArrayList<WordList> wordLists;
    private ConsoleReader consoleReader;
    private Writer writer;
    private Writer excelWriter;

    /**
     * adds a Wordlist to an ArrayList
     * @param wordList the wordList who should properly add to the ArrayList
     * @return true if it added to the ArrayList, if not it return false
     */
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
        if(writer.getClass() == ConsoleWriter.class){
            this.writer = writer;
        } else if(writer.getClass() == ExcelWriter.class){
            this.excelWriter = writer;
        }
    }

    public void playGame() {
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
        excelWriter.setDifficulty(difficulty);
        excelWriter.setWord(searchedWord);
        excelWriter.setSubject(subject);
        System.out.println(
                        "Let the game begin. \n" +
                        "The word is from the subject: "+subject+"\n" +
                        "You have "+difficulty.getValue()+" failed attempts.\n" +
                        "Your first choose: "

        );
        while (!gameFinished){
            foundSome = false;
            newestChar = consoleReader.readNextChar();
            for(int i=0;i<length;i++){
                if(Character.toUpperCase(searchedWord.charAt(i))==Character.toUpperCase(newestChar)){
                    encryptedWord[i]=searchedWord.charAt(i);
                    foundSome = true;
                }
            }
            if(!foundSome){
                failedAttempts++;
            }
            if(Arrays.equals(searchedWord.toCharArray(), encryptedWord)){
                failedAttempts=-1;
            }
            excelWriter.write(encryptedWord,newestChar,failedAttempts);
            gameFinished = writer.write(encryptedWord,newestChar,failedAttempts);
        }



    }
}
