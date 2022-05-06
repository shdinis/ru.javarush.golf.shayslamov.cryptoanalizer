import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

class Methods {

    private Methods() {
        throw new IllegalStateException("Utility class");
    }

    public static int enteringNumberFromConsole(int start, int end) {
        int result;

        System.out.printf("Введите число от %d до %d:\n", start, end);
        while (true) {
            Scanner console = new Scanner(System.in);
            if (console.hasNextInt()) {
                result = console.nextInt();
                if (start <= result && result <= end) {
                    break;
                } else {
                    System.err.printf("Нужно ввести число от %d до %d:\n", start, end);
                }
            } else if (console.hasNextLine()) {
                System.err.printf("Нужно ввести число от %d до %d:\n", start, end);
            }
        }
        return result;
    }

    public static HashMap<Character, Character> aDictionaryFromAnArrayOfChar(char[] alphabetFromChar, int keyCryption) {
        var result = new HashMap<Character, Character>();
        int key = keyCryption % alphabetFromChar.length;
        char originalChar;
        char replacementChar;

        if (key == 0) {
            key = key + Runner.MAGIC_KEY;
        }
        for (int i = 0; i < alphabetFromChar.length; i++) {
            originalChar = alphabetFromChar[i];
            replacementChar = alphabetFromChar[(i + key) % alphabetFromChar.length];
            result.put(originalChar, replacementChar);
        }
        return result;
    }

    public static String createOutputFilePathAndName(String in, String fileName) {
        int lastIndex = in.lastIndexOf(".");
        return (((lastIndex == -1) ? "" : (in.substring(0, lastIndex)))
                + fileName + ".txt");
    }

    public static char[] reverse(char[] chars) {
        char[] result = new char[chars.length];
        for (int i = 0; i < result.length; i++) {
            result[result.length - 1 - i] = chars[i];
        }
        return result;
    }

    public static void encrypting(char[] alphabetInCharArray, int keyCription, String inputFileName, String message, String outputFileName) {
        var mapAlphabet = aDictionaryFromAnArrayOfChar(alphabetInCharArray, keyCription);
        boolean loop = true;
        String inFileTxt;
        char currentChar;

        if (inputFileName.equals("")) {
            System.out.println("Введите полный путь к *.txt файлу где находится текст: \n " +
                    "или введите \"2\" чтобы вернутся в главное меню:");
        }

        while (loop) {
            Scanner console = new Scanner(System.in);
            if (inputFileName.equals("")) {
                if (console.hasNextInt() && (console.nextInt() == 2)) {
                    return;
                }
                inFileTxt = console.nextLine();
            } else {
                inFileTxt = inputFileName;
            }
            String outFileTxt = createOutputFilePathAndName(inFileTxt, outputFileName);

            try (
                    BufferedReader reader = new BufferedReader(new FileReader(inFileTxt));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(outFileTxt))
            ) {
                while (reader.ready()) {
                    currentChar = (char) reader.read();
                    writer.append(mapAlphabet.getOrDefault(Character.toLowerCase(currentChar), currentChar));
                }
                loop = false;
            } catch (FileNotFoundException fileNotFoundException) {
                System.err.println("Файла по указанному пути нет.\n Ведите полный путь к *.txt файлу\n" +
                        "или \"2\" для возврата в главное меню:");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(message);
    }
}
