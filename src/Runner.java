import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Runner {
    public static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";
    public static int key;

    public static void main(String[] args) {

        char[] alphabetChar = ALPHABET.toCharArray();
        int alphabetCharLength = alphabetChar.length;

        char[] alphabetStringRevers = new char[alphabetCharLength];
        for (int i = alphabetStringRevers.length - 1; i >= 0; i--) {
            alphabetStringRevers[i] = alphabetChar[alphabetCharLength - 1 - i];
        }

        System.out.println(alphabetChar);
        System.out.println(alphabetStringRevers);
        System.out.println(alphabetCharLength);


        HashMap<Character, Character> mapAlphabet = new HashMap<>();

        for (int i = 0; i < alphabetChar.length; i++) {
            char a = alphabetChar[i];
            char b = alphabetChar[(i + key) % alphabetCharLength];
            mapAlphabet.put(a, b);
        }

//        HashMap<Character, Character> mapAlphabetRevers = new HashMap<>();
//
//        for (int i = 0; i < alphabetStringRevers.length; i++) {
//            char a = alphabetStringRevers[i];
//            char b = alphabetStringRevers[(i + key) % alphabetCharLength];
//            mapAlphabetRevers.put(a, b);
//        }

        String inTxt = "C:\\Users\\shdin\\Desktop\\Курс javaRush\\JavaRushTasks\\1.JavaSyntax\\src\\lessons28\\in.txt";
        String outTxt = "C:\\Users\\shdin\\Desktop\\Курс javaRush\\JavaRushTasks\\1.JavaSyntax\\src\\lessons28\\out.txt";
        String decryptedTxt = "C:\\Users\\shdin\\Desktop\\Курс javaRush\\JavaRushTasks\\1.JavaSyntax\\src\\lessons28\\decrypted.txt";

        HashMap<Character, Integer> letterСount = new HashMap<>();


        try (Scanner console = new Scanner(System.in);
             FileReader in = new FileReader(inTxt);
             FileWriter out = new FileWriter(outTxt);
             BufferedReader reader = new BufferedReader(in);
             BufferedWriter writer = new BufferedWriter(out)) {
            while (reader.ready()) {
                char ch = (char) reader.read();
                writer.append(mapAlphabet.getOrDefault(ch, ch));
                if (letterСount.containsKey(ch)) {
                    int count = letterСount.get(ch);
                    letterСount.put(ch, ++count);
                } else {
                    letterСount.put(ch, 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(letterСount);
        letterСount.clear();
        System.out.println("---------------------");

        for (int y = 1; y < alphabetCharLength; y++) {
            HashMap<Character, Character> mapAlphabetRevers = new HashMap<>();

            for (int i = 0; i < alphabetStringRevers.length; i++) {
                char a = alphabetStringRevers[i];
                char b = alphabetStringRevers[(i + y) % alphabetCharLength];
                mapAlphabetRevers.put(a, b);
            }
            try (Scanner console = new Scanner(System.in);
                 FileReader in = new FileReader(outTxt);
                 FileWriter out = new FileWriter(decryptedTxt);
                 BufferedReader reader = new BufferedReader(in);
                 BufferedWriter writer = new BufferedWriter(out)) {
                while (reader.ready()) {
                    char ch = (char) reader.read();
                    char a = mapAlphabetRevers.getOrDefault(ch, ch);
                    //writer.append(mapAlphabetRevers.getOrDefault(ch, ch));
                    System.out.print(a);
                    if (letterСount.containsKey(a)) {
                        letterСount.put(a, letterСount.get(a) + 1);
                    } else {
                        letterСount.put(a, 1);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.print("     " + y + "  ");
            System.out.println(letterСount);
            letterСount.clear();
        }

    }
}



