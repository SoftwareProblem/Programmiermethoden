package Hangman;

import java.io.BufferedReader;

public class WordQuiz {

    private WordList wordListAnimals;
    private WordList wordListCars;
    private WordList wordListVideoGames;
    private WordList wordListSoftDrinks;
    private WordList wordListWuppi;
    private ConsoleReader consoleReader;

    public boolean addWordList(WordList wordList) {
        if (wordList==null){
            return false;
        }
        switch (wordList.getSubject()){
            case Animals:
                if (wordListAnimals==null){
                    wordListAnimals=wordList;
                    return true;
                }
                else{
                    return false;
                }
            case Cars:
                if (wordListCars==null){
                    wordListCars=wordList;
                    return true;
                }
                else{
                    return false;
                }

            case Videogames:
                if (wordListVideoGames==null){
                    wordListVideoGames=wordList;
                    return true;
                }
                else{
                    return false;
                }

            case Softdrinks:
                if (wordListSoftDrinks==null){
                    wordListSoftDrinks=wordList;
                    return true;
                }
                else{
                    return false;
                }

            case Wuppi:
                if (wordListWuppi==null){
                    wordListWuppi=wordList;
                    return true;
                }
                else{
                    return false;
                }

        }

        return false;
    }

    public void deleteWordList(WordList wordList) {
        if (wordList.getSubject()==null){
            return;
        }
        switch (wordList.getSubject()){
            case Animals:
                wordListAnimals=null;
            case Cars:
                wordListCars=null;
            case Videogames:
                wordListVideoGames=null;
            case Softdrinks:
                wordListSoftDrinks=null;
            case Wuppi:
                wordListWuppi=null;


        }


    }

    public void setConsoleReader(ConsoleReader consoleReader) {
        this.consoleReader=consoleReader;
    }

    public void setWriter(Writer writer) {
    }

    public void playgame() {
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
        //Writer writer = new ConsoleWriter(subject, difficulty, new WordList(subject).getWordOfLength(length));
        WordList gameList=null;
        switch (subject){
            case Animals:
                gameList=wordListAnimals;
                break;
            case Cars:
                gameList=wordListCars;
                break;
            case Videogames:
                gameList=wordListVideoGames;
                break;
            case Softdrinks:
                gameList=wordListSoftDrinks;
                break;
            case Wuppi:
                gameList=wordListWuppi;
                break;
        }
        System.out.println(gameList);
        int triesLeft=0;
        switch (difficulty){
            case EASY:
                triesLeft=15;
                break;
            case NORMAL:
                triesLeft=10;
                break;
            case HARD:
                triesLeft=5;
                break;
            case EXTREM:
                triesLeft=1;
                break;
        }

        String searchedWord;
        int newLength=length;
        while (gameList.getWordOfLength(newLength)==null){
            System.out.println("Kein Wort dieser Länge gefunden.\nBitte geben sie eine andere Länge ein.");
            //input auf int Parsen
            System.out.println(newLength);
        }
        searchedWord=gameList.getWordOfLength(length);
        char[] guessedCharacters=new char[length];
        while (triesLeft>0){
            consoleReader.readNextChar();


        }



    }
}
