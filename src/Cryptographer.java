public class Cryptographer {

    public Cryptographer(String alphabet) {
        System.out.println("Здесь код шифрования текста");
        char[] alphabetInCharArray = alphabet.toCharArray();
        System.out.println("Выберите каким ключем зашифровать");

        int key = Methods.enteringNumberFromConsole(1, Integer.MAX_VALUE);

        Methods.encrypting(alphabetInCharArray, key,"","Файл успешно зашифрован.\n" +
                "результат сохранен в ту же папку под названием *(зашифрован).txt"+
                "\nЖелаешь сделать что-то еще?\n","(зашифрован)");
    }
}