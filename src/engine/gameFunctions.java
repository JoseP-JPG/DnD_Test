package engine;

import java.util.List;
import java.util.Random;

public class gameFunctions {

    static List randomize(List listie) {
        
        Random r = new Random();
        int n = listie.size();
        
        for (int i = n-1; i > 0; i--) {

            int j = r.nextInt(i+1);

            
            Object temp = listie.get(i);
            listie.set(i,listie.get(j));
            listie.set(j,temp);
        }
        return listie;
    }

}
