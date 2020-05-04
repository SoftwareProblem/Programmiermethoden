
package Hangman;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleReader {
    private BufferedReader reader;

    public ConsoleReader(BufferedReader bufferedReader){
        this.reader = bufferedReader;
    }
    public char readNextChar(){
        String line = "";
        try {
            line = reader.readLine();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        return line.charAt(0);
    }
}
