
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Runner {
    public static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";


    public static void main(String[] args) {

        int point = 0;
        while (point != 4) {
            System.out.println("1.Зашифровать текст");
            System.out.println("2.Расшифровать текст");
            System.out.println("3.Взломать шифр");
            System.out.println("4.Выход");

            point = Methods.Point(1, 4);
            switch (point) {
                case 1:
                    new Encryption(ALPHABET);
                    break;
                case 2:
                    new Decryption();
                    break;
                case 3:
                    new BrutForce();
                    break;
            }
        }

    }


}


//        for (int y = 1; y < alphabetCharLength; y++) {
//        HashMap<Character, Character> mapAlphabetRevers = new HashMap<>();
//
//        for (int i = 0; i < alphabetStringRevers.length; i++) {
//            char a = alphabetStringRevers[i];
//            char b = alphabetStringRevers[(i + y) % alphabetCharLength];
//            mapAlphabetRevers.put(a, b);
//        }
//        try (Scanner console = new Scanner(System.in);
//             FileReader in = new FileReader(outTxt);
//             FileWriter out = new FileWriter(decryptedTxt);
//             BufferedReader reader = new BufferedReader(in);
//             BufferedWriter writer = new BufferedWriter(out)) {
//            while (reader.ready()) {
//                char ch = (char) reader.read();
//                char a = mapAlphabetRevers.getOrDefault(ch, ch);
//                //writer.append(mapAlphabetRevers.getOrDefault(ch, ch));
//                System.out.print(a);
//                if (letterСount.containsKey(a)) {
//                    letterСount.put(a, letterСount.get(a) + 1);
//                } else {
//                    letterСount.put(a, 1);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.print("     " + y + "  ");
//        System.out.println(letterСount);
//        letterСount.clear();
//    }
//

