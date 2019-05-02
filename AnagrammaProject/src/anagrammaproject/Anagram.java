
package anagrammaproject;
import java.util.*;
/**
 *
 * @author User
 */
public class Anagram {
    
    public static void main(String[] args) {
       
        Scanner sc = new Scanner (System.in);
        
        String firstString = sc.nextLine();
        String secondString = sc.nextLine();
        
        
        boolean result = true;
        
        if (firstString.length() != secondString.length()) {
            result = false;
        } else {
            char [] charsOfFirstString = firstString.toLowerCase().toCharArray();              
            char [] charsOfSecondString = secondString.toLowerCase().toCharArray();
            
            Arrays.sort(charsOfFirstString);
            Arrays.sort(charsOfSecondString);
            
            for (int i = 0; i < charsOfFirstString.length; i++) {
                if (charsOfFirstString [i] != charsOfSecondString [i]) {
                    result = false;
                    break;
                }
            }
            
        }
        
        System.out.println( result ? "Anagramma" : "Nem Anagramma");
        
    }
    
}
