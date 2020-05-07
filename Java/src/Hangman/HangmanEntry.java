package Hangman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class HangmanEntry {
    public static void main(String[] args) throws IOException {
        WordQuiz wordQuiz=new WordQuiz();
        wordQuiz.setConsoleReader(new ConsoleReader(new BufferedReader(new InputStreamReader(System.in))));
        wordQuiz.addWriter(new ConsoleWriter());
        wordQuiz.addWriter(new ExcelWriter());
        WordList[] wordLists = new WordList[]{
                                                new WordList(Subject.Animals),
                                                new WordList(Subject.Cars),
                                                new WordList(Subject.Videogames),
                                                new WordList(Subject.Softdrinks),
                                                new WordList(Subject.Wuppi)
        };
        for(WordList list : wordLists){
            list.readListFromFile("../Java/src/Hangman/Data/"+list.getSubject()+".txt");
            wordQuiz.addWordList(list);
        }
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        boolean wantsToPlay=false;
        boolean inputCorrect=false;
        Subject chosenSubject=null;
        Difficulty chosenDifficulty=null;
        int chosenNumber=-1;
        int chosenLength=0;
        String testTMP;
        do {
            System.out.println("Chose your subject");
            for (int i=0;i<Subject.values().length;i++) {

                System.out.println(i+": " + Subject.values()[i]);
            }
            while (!inputCorrect){
                testTMP=bufferedReader.readLine();
                if(testTMP.equals("")){
                    inputCorrect=true;
                }
                try {
                    chosenNumber=Integer.parseInt(String.valueOf(testTMP.toCharArray()));
                }
                catch (NumberFormatException ignored){

                }

                if (chosenNumber>=0&&chosenNumber<Subject.values().length){
                    chosenSubject=Subject.values()[chosenNumber];
                    chosenNumber=-1;
                    inputCorrect=true;
                }

            }
            inputCorrect=false;
            System.out.println("Chose your difficulty");
           for (int i=0;i<Difficulty.values().length;i++) {

               System.out.println(i+": " + Difficulty.values()[i]);
           }
           while (!inputCorrect){
               testTMP=bufferedReader.readLine();
               if(testTMP.equals("")){
                   inputCorrect=true;
               }
               try {
                  chosenNumber=Integer.parseInt(String.valueOf(testTMP.toCharArray()));
               }
               catch (NumberFormatException ignored){
               }


               if (chosenNumber>=0&&chosenNumber<Difficulty.values().length){
                   chosenDifficulty=Difficulty.values()[chosenNumber];
                   chosenNumber=-1;
                   inputCorrect=true;
               }

           }
           inputCorrect=false;
           System.out.println("Chose the length of your Word");
           while (!inputCorrect){
               testTMP=bufferedReader.readLine();
               if(testTMP.equals("")){
                   inputCorrect=true;
                   chosenLength=0;
               }
               try {
                  chosenNumber =Integer.parseInt(String.valueOf(testTMP.toCharArray()));
               }
               catch (NumberFormatException ignored){
               }

             if (chosenNumber>0){
                 chosenLength=chosenNumber;
                 chosenNumber=-1;

                   inputCorrect=true;
               }
           }
           inputCorrect=false;
           if (chosenLength==0&&chosenDifficulty==null&&chosenSubject==null){
               wordQuiz.playGame();
           }
           else if(chosenLength!=0&&chosenDifficulty==null&&chosenSubject==null){
               wordQuiz.playGame(chosenLength);
           }
           else if(chosenLength==0&&chosenDifficulty==null&&chosenSubject!=null){
              wordQuiz.playGame(chosenSubject);
           }
           else if(chosenLength==0&&chosenSubject==null&&chosenDifficulty!=null){
               wordQuiz.playGame(chosenDifficulty);
           }
           else if(chosenLength!=0&&chosenDifficulty==null&&chosenSubject!=null){
               wordQuiz.playGame(chosenLength, chosenSubject);
           }
            else if(chosenLength!=0&&chosenDifficulty!=null&&chosenSubject==null){
                wordQuiz.playGame(chosenLength, chosenDifficulty);
           }
            else if (chosenLength==0&&chosenDifficulty!=null&&chosenSubject!=null){
                wordQuiz.playGame( chosenSubject, chosenDifficulty);
           }
            else if(chosenLength!=0&&chosenDifficulty!=null&&chosenSubject!=null){
                wordQuiz.playGame(chosenLength, chosenSubject, chosenDifficulty);
           }
            System.out.println("Möchten sie erneut Spielen\n"+"geben sie Yes/No ein");
            boolean isYesNo=true;
            while (isYesNo){
                String yesNo= bufferedReader.readLine();
                if(yesNo.equals("Yes")||yesNo.equals("yes")){
                    wantsToPlay=true;
                    isYesNo=false;
                }
                else if (yesNo.equals("No")||yesNo.equals("no")){
                    wantsToPlay=false;
                    isYesNo=false;
                }
            }
        }while (wantsToPlay);
    }
}