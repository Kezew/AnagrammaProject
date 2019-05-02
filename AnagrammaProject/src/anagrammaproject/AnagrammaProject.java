
package anagrammaproject;

import java.io.*;
import java.util.*;

/**
 *
 * @author User
 */
public class AnagrammaProject {

    static ArrayList<String> words = new ArrayList<>(); // az erdeti szotar.txt-t tartalmazó lista 
   
    public static void main(String[] args) throws FileNotFoundException {
        
    int maxLength = readFile();    
    // System.out.println(maxLength);
    // getCharAndNumOfCharFromText();
    // orderedWordList();
    // anagramm();
    // isAnagrInVocabulary();
    // getLongestWords(maxLength);
    getWordsIncrOrderAnagrams(maxLength);
    
    }
    
    // Kerj be a felhasznalotol egy szoveget, majd hatarozd meg, 
    // hogy hany kulonbozo karakter talalhato a szovegben! 
    // A darabszamot es a karaktereket írd ki a konzolra!
    public static void getCharAndNumOfCharFromText() {
        HashMap<Character, Integer> chars = new HashMap<>();
        int numOfDifferentChars = 0;
        Scanner input = new Scanner(System.in, "UTF-8");
        System.out.println("Írj be egy szöveget: ");
        String text = input.nextLine();
        input.close();
        char[] charsOfText = text.toCharArray();
        for (char c : charsOfText) {        // karaktereken végig
            if (chars.containsKey(c)) {     // ha már van ilyen karakter Key
                int actValue = chars.get(c);
                chars.put(c, actValue + 1);
            } else {                        // még nincs ilyen karakter Key
                numOfDifferentChars++;
                chars.put(c, 1);
            }   
        }
        // kiíratom a karaktereket és a hozzá tartozó Value-t
        System.out.println(numOfDifferentChars + " különböző karakter található a beírt szövegben");
        for (Character ch :  chars.keySet()) {
            System.out.println(ch + " -- " + chars.get(ch) + " db");
        }
        
    }
    
    // A fájlból beolvasott szavakat alakítsd át úgy, 
    // hogy minden szó karaktereit egyenként tedd abc rendbe! 
    // Az igy létrehozott szavakból hozz létre egy tömböt / listát, az eredetivel egyező sorrendben!
    // Peldául: tervez => eertvz, nyugalom => aglmnouy    
    public static ArrayList<String> orderedWordList() {
        ArrayList<String> ordereByCharsList = new ArrayList<>();
        for (String word : words) {
            char[] chars = word.toCharArray();          // String to charsArr
            Arrays.sort(chars);                         // sort alphabetically
            String sortedWord = String.valueOf(chars);  // chars Array to String 
            ordereByCharsList.add(sortedWord);          // add sortedWord to ArrayList
        }

//        for (int i = 0; i < words.size(); i++) {
//            System.out.println(words.get(i) + " -- " + ordereByCharsList.get(i));
//        }

        return ordereByCharsList;
    }
    
    // Kerj be a felhasznalotol ket szot, es dontsd el, hogy a ket szo anagramma-e! 
    // Ha azok voltak, ird ki a konzolra az „Anagramma” szot, ha nem, 
    // akkor pedig a „Nem anagramma” szoveget!
    public static void anagramm() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kérem az első szót");
        String firstString = sc.nextLine();
        System.out.println("Kérem a második szót");
        String secondString = sc.nextLine();
        boolean result = true;
        if (firstString.length() != secondString.length()) {
            result = false;
        } else {
            char[] charsOfFirstString = firstString.toLowerCase().toCharArray();
            char[] charsOfSecondString = secondString.toLowerCase().toCharArray();
            Arrays.sort(charsOfFirstString);
            Arrays.sort(charsOfSecondString);
            for (int i = 0; i < charsOfFirstString.length; i++) {
                if (charsOfFirstString[i] != charsOfSecondString[i]) {
                    result = false;
                    break;
                }
            }
        }
        System.out.println(result ? "Anagramma" : "Nem Anagramma");
    }
    
    // Kérj be a felhasználótól egy szót! A fájlból beolvasott szavakból keresd meg 
    // a szó anagrammáit (a szót önmagát is annak tekintve)! Ha van találat, 
    // azokat egymas ala írd ki a konzolra, ha nem volt találat, akkor írja ki 
    // a „Nincs a szótárban anagramma” szöveget!
    public static boolean isAnagramm (String firstString, String secondString) {
        boolean result = true;
        if (firstString.length() != secondString.length()) {
            result = false;
        } else {
            char[] charsOfFirstString = firstString.toLowerCase().toCharArray();
            char[] charsOfSecondString = secondString.toLowerCase().toCharArray();
            Arrays.sort(charsOfFirstString);
            Arrays.sort(charsOfSecondString);
            for (int i = 0; i < charsOfFirstString.length; i++) {
                if (charsOfFirstString[i] != charsOfSecondString[i]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
    
    public static void isAnagrInVocabulary () {
        boolean angr = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Kérem a szót");
        String inputWord = sc.nextLine();
        System.out.println("= = = = = = = = = = ");
        for (String actWord : words) {
            if(isAnagramm(actWord, inputWord)) {
                System.out.println(actWord);
                angr = true;
            }
        }
        if(!angr) {
            System.out.println("Nincs a szótárban anagramma");
        }
        
    }
    
    // Határozd meg, hogy a beolvasott szavak közül melyik a leghosszabb szó! 
    // Ha több, ugyanannyi karakterből álló leghosszabb szó volt, 
    // akkor az összeset írd ki! A feltételnek megfelelő összes szó pontosan 
    // egyszer szerepeljen a kiírásban!
    public static void getLongestWords(int lenght) {
        HashSet<String> longWords = new HashSet<>();
        for (String actWord : words) {
            if(actWord.length() == lenght) {
                longWords.add(actWord);
            }
        }
        System.out.println(longWords);
    }
    
    // Rendezd a fájlból beolvasott szavakat a karakterek száma szerint növekvő sorrendbe!
    // Az egyforma hosszúságú és ugyanazokat a karaktereket tartalmazó szavak 
    // (amelyek egymás anagrammái) szóközzel elválasztva ugyanabba 
    // a sorba kerüljenek! Az egyforma hosszúságú, de nem ugyanazokat a
    // karaktereket tartalmazó szavak külön sorba kerüljenek! Az így rendezett
    // szavakat írd ki a konzolra!
    public static void getWordsIncrOrderAnagrams(int maxLength) {
        ArrayList<String> wordsKeyBase = orderedWordList();      // az eredeti ArrayList betűrendbe alakított Stringjei
        HashSet<String> keys = new HashSet<>();                  // ebből HashSet >>>> mindegyik csak egyszer szerepel !!! anagramma miatt fontos
        keys.addAll(wordsKeyBase);                               // ezek lesznek a kulcsok a HashMap-ben
        HashMap<String, HashSet<String>> wordsOrderedAnagramms = new HashMap<>();

        for (String key : keys) {                               // kulcsok megvannak
            wordsOrderedAnagramms.put(key, new HashSet<>());    // HashSet-en végigmenve kulcsként beteszem egy üres HashSet-el mint Value-val
            for (String actWord : words) {                      // az eredeti listán végigmegyek és ha a Kulcs ( key ) anagrammája akkor belerakom az annak megfelelő HashSet-be
                if (isAnagramm(actWord, key)) {
                    wordsOrderedAnagramms.get(key).add(actWord);
                }
            }
        }

        for (int i = 2; i <= maxLength; i++) {
            System.out.println( i + " karakter hosszúságúak");
            System.out.println("= = = = = = = = = = = = = = = = = = ");
            for (String key : wordsOrderedAnagramms.keySet()) {
                if (key.length() == i) {
                    System.out.println(wordsOrderedAnagramms.get(key));
                }

            }
            System.out.println("");
        }
    }
    
    
    
    // file beolvasása, Olvasd be a fájlból a szavakat egy tömbbe vagy listába!
    public static int readFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("szotar.txt"));
        int maxL = 0; 
        while(sc.hasNext()) {
            String actWord = sc.nextLine();
            words.add(actWord);
            maxL = Math.max(maxL, actWord.length());  // a leghosszabb szó hossza
            
        }
        sc.close();
    return maxL;    
    }
    
}
