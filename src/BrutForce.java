import java.io.*;
import java.util.Scanner;

public class BrutForce {

    public BrutForce(String alphabet) {
        System.out.println("Здесь код взлома шифра");
        char[] alphabetCharRevers = Methods.Revers(alphabet.toCharArray());
        int key = 1;
        System.out.println("Введите полный путь к *.txt файлу где находится текст:");
        boolean loop = true;
        String outTxt = "";
        while (loop) {
            Scanner console = new Scanner(System.in);
            String inTxt = console.nextLine();

            int countCommaSpace = 0;
            int countDotSpace = 0;
            int countSpace = 0;
            char ch1 = 0;
            int tmp = 0;
            for (int keyB = 1; keyB < alphabetCharRevers.length - 1; keyB++) {

                countCommaSpace = 0;
                countDotSpace = 0;
                countSpace = 0;
                try (
                        BufferedReader reader = new BufferedReader(new FileReader(inTxt));
                ) {
                    outTxt = inTxt;
                    var map = Methods.aDictionaryFromAnArrayOfChar(alphabetCharRevers, keyB);
                    while (reader.ready()) {
                        char ch = (char) reader.read();
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
                    if (countCommaSpace+countDotSpace+countSpace > tmp) {
                        tmp = countCommaSpace+countDotSpace+countSpace;
                        key = keyB;
                    }
                    loop = false;
                } catch (FileNotFoundException fileNotFoundException) {
                    System.out.println("Файла по указанному пути нет.\n Ведите полный путь к *.txt файлу:");
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(key);
        Methods.Encrypting(alphabetCharRevers, key, outTxt, "Файл дешифрован.\n" +
                "результат сохранен в ту же папку под названием out.txt" +
                "\nЖелаешь сделать что-то еще?\n");
    }
}