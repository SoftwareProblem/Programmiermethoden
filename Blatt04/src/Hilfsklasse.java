import lexer.*;
import java.util.*;

public class Hilfsklasse {
    public static void main(String[] args) {
        String testString = """
                // test test void
                "test213"/* test2 */
                
                
                /* test123 public


                test231 */
                \"test2132\"
                public void private protected this
                """;
        Lexer test = new Lexer();

        List<Token> testList = new LinkedList<>();
        testList.add(new Comment());
        testList.add(new MultilineComment());
        testList.add(new StringContent());
        testList.add(new KeyWord());
        testList.add(new NewLine());
        test.registerToken(testList);
        test.registerCatchAll(new lexer.CatchAll());

        /*
        try {
            File folder = new File("/home/smierx/Programmiermethoden/Blatt04/src/lexer");
            ArrayList<Class> c2 = new ArrayList<>();
            ArrayList<Class> cSorted = new ArrayList<>();
            String[] test1 = folder.list();
            for(String val : test1){
                if(val.contains(".java")){
                    val = val.split("\\.")[0];
                    c2.add(Class.forName("lexer."+val));
                }
            }
            for(int i=0;i<c2.size();i++){
                if(c2.get(i).isAnnotationPresent(lexer.Annotationen.Prio.class)){
                    cSorted.add(c2.get(i));
                }
            }
            cSorted = sort(cSorted);
        } catch(Exception e){
            e.printStackTrace();
        }
        List<Token> list = new LinkedList<>();
        list = test.tokenize(testString);
    }
    public static ArrayList<Class> sort(ArrayList<Class> cSorted){
        Class<?> k;
        for(int i=0;i<cSorted.size()-1;i++){
            lexer.Annotationen.Prio p = (Prio) cSorted.get(i).getAnnotation(Prio.class);
            lexer.Annotationen.Prio p2 = (Prio) cSorted.get(i+1).getAnnotation(Prio.class);
            if(p.value()<p2.value()){
                continue;
            }
            k = cSorted.get(i);
            cSorted.set(i,cSorted.get(i+1));
            cSorted.set(i+1,k);
            sort(cSorted);
        }
        return cSorted;*/
    }
}
