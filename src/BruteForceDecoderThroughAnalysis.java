import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BruteForceDecoderThroughAnalysis {

    public BruteForceDecoderThroughAnalysis() {
        String outTxt = "";
        ArrayList<Character> temporaryArrayOfParsedText = new ArrayList<>();

        System.out.println("Здесь код взлома шифра");

        System.out.println("Введите полный путь к *.txt файлу где находится текст: \n " +
                "или введите \"2\" чтобы вернутся в главное меню:");

        boolean loop = true;
        while (loop) {
            Scanner console = new Scanner(System.in);
            if (console.hasNextInt() && (console.nextInt() == 2)) {
                return;
            }
            String inTxt = console.nextLine();
            outTxt = inTxt;
            try (
                    BufferedReader reader = new BufferedReader(new FileReader(inTxt))
            ) {
                while (reader.ready()) {
                    temporaryArrayOfParsedText.add(Character.toLowerCase((char) reader.read()));
                }
                loop = false;
            } catch (FileNotFoundException fileNotFoundException) {
                System.err.println("Файла по указанному пути нет.\n Ведите полный путь к *.txt файлу:\n " +
                        "или введите \"2\" чтобы вернутся в главное меню:");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        int keyCryption = key(Runner.reversedAlphabetInCharArray, temporaryArrayOfParsedText);

        Methods.encrypting(Runner.reversedAlphabetInCharArray, keyCryption, outTxt, "Файл дешифрован.\n" +
                "результат сохранен в ту же папку под названием *(расшифрован подбором на основе анализа).txt" +
                "\nЖелаешь сделать что-то еще?\n", "(расшифрован подбором на основе анализа)");
    }

    private int key(char[] alphabetCharRev, ArrayList<Character> temArrayOfParsedText) {
        int result = 1;
        int countCommaSpace;
        int countDotSpace;
        int countSpace;
        char previousCharAfterDecryption = 0;
        char currentChar;
        char charAfterDecryption;
        int tmpCount = 0;

        for (int key = 1; key < alphabetCharRev.length - 1; key++) {
            var map = Methods.aDictionaryFromAnArrayOfChar(alphabetCharRev, key);
            countCommaSpace = 0;
            countDotSpace = 0;
            countSpace = 0;

            for (Character aChar : temArrayOfParsedText) {
                currentChar = aChar;
                charAfterDecryption = map.getOrDefault(currentChar, currentChar);
                if (previousCharAfterDecryption == ',' && charAfterDecryption == ' ') {
                    countCommaSpace++;
                } else if (previousCharAfterDecryption == '.' && charAfterDecryption == ' ') {
                    countDotSpace++;
                } else if (previousCharAfterDecryption == ' ') {
                    countSpace++;
                }
                previousCharAfterDecryption = charAfterDecryption;
            }

            if (countCommaSpace + countDotSpace + countSpace > tmpCount) {
                tmpCount = countCommaSpace + countDotSpace + countSpace;
                result = key;
            }
        }
        return result;
    }
}