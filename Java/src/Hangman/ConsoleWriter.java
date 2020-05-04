package Hangman;

public class ConsoleWriter extends Writer {
    public ConsoleWriter(Subject subject, Difficulty difficulty, String string) {
        super(subject, difficulty, string);
    }
    @Override
    public boolean write(char[] charArray, char cha, int failedAttempts) {
        System.out.println("Aktueller Stand:");
        for (char c : charArray) {
            System.out.print(c + " ");
        }
        System.out.println("\n" +
                "Neuestes  Zeichen: "+cha);
        if(failedAttempts==difficulty.getValue()){
            System.out.println("Leider verloren");
            return true;
        } else if(failedAttempts==-1){
            System.out.println("Herzlichen Glückwunsch du hast gewonnen!!");
            return true;
        }
        System.out.println("Anzahl der Fehlversuche: "+failedAttempts);
        return false;
    }
}
