import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Encryption {
    public static int key;

    public Encryption(String alphabet) {

        System.out.println("Здесь код шифрования текста");

        char[] alphabetChar = alphabet.toCharArray();
        System.out.println("Выберите каким ключем зашифровать");
        key = Methods.Point(1, alphabetChar.length - 1);

        var mapAlphabet = Methods.aDictionaryFromAnArrayOfChar(alphabetChar, key);

        String inTxt = "C:\\Users\\shdin\\Desktop\\Курс javaRush\\JavaRushTasks\\1.JavaSyntax\\src\\lessons28\\in.txt";
        String outTxt = "C:\\Users\\shdin\\Desktop\\Курс javaRush\\JavaRushTasks\\1.JavaSyntax\\src\\lessons28\\out.txt";
        String decryptedTxt = "C:\\Users\\shdin\\Desktop\\Курс javaRush\\JavaRushTasks\\1.JavaSyntax\\src\\lessons28\\decrypted.txt";

        try (
                Scanner console = new Scanner(System.in);
                FileReader in = new FileReader(inTxt);
                FileWriter out = new FileWriter(outTxt);
                BufferedReader reader = new BufferedReader(in);
                BufferedWriter writer = new BufferedWriter(out)) {
            while (reader.ready()) {
                char ch = (char) reader.read();
                writer.append(mapAlphabet.getOrDefault(ch, ch));

            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }
}

