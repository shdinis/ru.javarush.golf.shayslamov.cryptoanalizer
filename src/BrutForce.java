import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class BrutForce {
    public BrutForce(String alphabet) {
        System.out.println("Здесь код взлома текста");
        char[] alphabetCharRevers = Methods.Revers(alphabet.toCharArray());
//        System.out.println("Выберите каким ключем расшифровать");
        int key = 1; //Methods.Point(1, alphabetCharRevers.length - 1);
        System.out.println("Введите полный путь к *.txt файлу где находится текст:");
        boolean loop = true;
        String outTxt = "";
        while (loop) {
            Scanner console = new Scanner(System.in);
            String inTxt = console.nextLine();
//            String outTxt = OutTxt(inTxt);
            try (
                    BufferedReader reader = new BufferedReader(new FileReader(inTxt));
//                    BufferedWriter writer = new BufferedWriter(new FileWriter(outTxt)))
            ) {
                outTxt = inTxt;
                int countCommaSpace = 0;
                int countDotSpace = 0;
                int countSpace = 0;
                char ch1 = 0;

                for (int keyB = 1; keyB < alphabetCharRevers.length - 1; keyB++) {
                    int tmp = countCommaSpace;
                    countCommaSpace = 0;
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
                    if (countCommaSpace > tmp) {
                        key = keyB;
                    }
                }
                loop = false;
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("Файла по указанному пути нет.\n Ведите полный путь к *.txt файлу:");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Methods.Encrypting(alphabetCharRevers, key, outTxt, "Файл дешифрован.\n" +
                "результат сохранен в ту же папку под названием out.txt"+
                "\nЖелаешь сделать что-то еще?\n");

    }


}
//    HashMap<Character, Integer> letterСount = new HashMap<>();

//if(letterСount.containsKey(ch)){
//        int count=letterСount.get(ch);
//        letterСount.put(ch,++count);
//        }else{
//        letterСount.put(ch,1);
//        }
//        System.out.println(letterСount);
//        letterСount.clear();
//        System.out.println("---------------------");