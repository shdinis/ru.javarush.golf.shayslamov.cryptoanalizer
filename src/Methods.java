import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Methods {
    public static int Point(int start, int end) {
        int point;
        System.out.printf("Введите число от %d до %d:\n", start, end);
        while (true) {
            Scanner console = new Scanner(System.in);
            if (console.hasNextInt()) {
                point = console.nextInt();
                if (start <= point && point <= end) {
                    break;
                } else {
                    System.out.printf("Нужно ввести число от %d до %d:\n", start, end);
                }
            } else if (console.hasNextLine()) {
                System.out.printf("Нужно ввести число от %d до %d:\n", start, end);
            }
        }
        return point;
    }

    public static HashMap<Character, Character> aDictionaryFromAnArrayOfChar(char[] aChar, int key) {
        HashMap<Character, Character> map = new HashMap<>();
        int keyCription = key % aChar.length;
        if (keyCription == 0) {
            keyCription = keyCription + Runner.MAGIC;
        }
        for (int i = 0; i < aChar.length; i++) {
            char a = aChar[i];
            char b = aChar[(i + keyCription) % aChar.length];
            map.put(a, b);
        }
        return map;
    }

    public static String OutTxt(String in, String fileName) {
        int lastIndex = in.lastIndexOf(".");
        String out = "";
        if (lastIndex == -1) {
            return out = fileName + ".txt";
        } else {
            out = in.substring(0, lastIndex ) + fileName + ".txt";
        }
        return out;
    }

    public static char[] Revers(char[] chars) {
        char[] revers = new char[chars.length];
        for (int i = 0; i < revers.length; i++) {
            revers[revers.length - 1 - i] = chars[i];
        }
        return revers;
    }

    public static void Encrypting(char[] alphabet, int key, String file, String message, String fileName) {
        var mapAlphabet = aDictionaryFromAnArrayOfChar(alphabet, key);
        if (file == "") {
            System.out.println("Введите полный путь к *.txt файлу где находится текст: \n " +
                    "или введите \"2\" чтобы вернутся в главное меню:");
        }
        boolean loop = true;
        while (loop) {
            Scanner console = new Scanner(System.in);
            String inTxt;
            if (console.hasNextInt()) {
                if (console.nextInt() == 2) {
                    console.nextLine();
                    return;
                }
            }
            if (file == "") {
                inTxt = console.nextLine();
            } else {
                inTxt = file;
            }
            String outTxt = OutTxt(inTxt, fileName);
            try (
                    BufferedReader reader = new BufferedReader(new FileReader(inTxt));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(outTxt))
            ) {
                while (reader.ready()) {
                    char ch = (char) reader.read();
                    writer.append(mapAlphabet.getOrDefault(Character.toLowerCase(ch), ch));
                }
                loop = false;
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("Файла по указанному пути нет.\n Ведите полный путь к *.txt файлу\n" +
                        "или \"2\" для возврата в главное меню:");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(message);
    }

}
