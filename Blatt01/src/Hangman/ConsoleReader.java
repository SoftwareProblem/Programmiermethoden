package Hangman;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleReader {
    private BufferedReader reader;

    public ConsoleReader(BufferedReader bufferedReader){
        this.reader = bufferedReader;
    }

    /**
     * read the first char from the console. If there is no char, it will ask till there is one.
     * @return the first char
     */
    public char readNextChar(){
        String line = "";
        try {
            line = reader.readLine();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        if(line.length()>0){
            return line.charAt(0);
        } else {
            System.out.println("No input. \n " +
                    "Please try again:");
            return readNextChar();
        }
    }
}
