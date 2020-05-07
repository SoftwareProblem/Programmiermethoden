package Hangman;

public class ConsoleWriter extends Writer {
    /**
     * write the args to the console
     * @param charArray current status of the word
     * @param cha the last guessed letter
     * @param failedAttempts
     * @return return true if the game is over, no matter of the player win or lose
     * @author Michel Dudas
     */
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
        System.out.println("Deine nächste Auswahl: ");
        return false;
    }
}
