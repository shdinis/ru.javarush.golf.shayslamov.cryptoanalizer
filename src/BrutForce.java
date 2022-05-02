import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BrutForce {

    public BrutForce(String alphabet) {
        System.out.println("Здесь код взлома шифра");
        System.out.println("Введите полный путь к *.txt файлу где находится текст: \n " +
                "или введите \"2\" чтобы вернутся в главное меню:");

        String outTxt = "";
        ArrayList<Character> chars = new ArrayList<>();
        boolean loop = true;
        while (loop) {
            Scanner console = new Scanner(System.in);
            String inTxt;
            if (console.hasNextInt() && (console.nextInt() == 2)) {
                return;
            }
            inTxt = console.nextLine();

            try (
                    BufferedReader reader = new BufferedReader(new FileReader(inTxt));
            ) {
                outTxt = inTxt;
                while (reader.ready()) {
                    chars.add(Character.toLowerCase((char) reader.read()));
                }
                loop = false;
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("Файла по указанному пути нет.\n Ведите полный путь к *.txt файлу:\n " +
                        "или введите \"2\" чтобы вернутся в главное меню:");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        char[] alphabetCharRevers = Methods.Revers(alphabet.toCharArray());
        int key = 1;
        int countCommaSpace;
        int countDotSpace;
        int countSpace;
        char ch1 = 0;
        int tmp = 0;

        for (int keyB = 1; keyB < alphabetCharRevers.length - 1; keyB++) {
            var map = Methods.aDictionaryFromAnArrayOfChar(alphabetCharRevers, keyB);
            countCommaSpace = 0;
            countDotSpace = 0;
            countSpace = 0;
            for (Character aChar : chars) {
                char ch = aChar;
                char ch2 = map.getOrDefault(ch, ch);
                if (ch1 == ',' && ch2 == ' ') {
                    countCommaSpace++;
                } else if (ch1 == '.' && ch2 == ' ') {
                    countDotSpace++;
                } else if (ch1 == ' ') {
                    countSpace++;
                }
                ch1 = ch2;
            }
            if (countCommaSpace + countDotSpace + countSpace > tmp) {
                tmp = countCommaSpace + countDotSpace + countSpace;
                key = keyB;
            }
        }
        Methods.Encrypting(alphabetCharRevers, key, outTxt, "Файл дешифрован.\n" +
                "результат сохранен в ту же папку под названием out.txt" +
                "\nЖелаешь сделать что-то еще?\n","(расшифрован подбором на основе анализа)");
    }
}