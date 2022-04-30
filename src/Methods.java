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
                    System.out.printf("Введите число от %d до %d:\n", start, end);
                }
            } else if (console.hasNextLine()) {
                System.out.printf("Введите число от %d до %d:\n", start, end);
            }
        }
        return point;
    }

    public static HashMap<Character,Character> aDictionaryFromAnArrayOfChar(char[] aChar, int key){
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < aChar.length; i++) {
            char a = aChar[i];
            char b = aChar[(i + key) % aChar.length];
            map.put(a, b);
        }
        return map;
    }
}
