import java.util.Arrays;

public class Lambda {
    public static void main(String[] args){
        String[] words = new String[]{"test123","test23123","fgsadfsdf"};
        Arrays.sort( words, (String s1, String s2) -> { return s1.trim().compareTo(s2.trim()); } );
        System.out.println(words[0]);
        int i -> {return new int[] {52,54};}
    }
}
