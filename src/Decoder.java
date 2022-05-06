public class Decoder {

    public Decoder(String alphabet) {
        System.out.println("Здесь код расшифрования текста");
        char[] reversedAlphabetInCharArray = Methods.reverse(alphabet.toCharArray());
        System.out.println("Выберите каким ключем расшифровать");

        int key = Methods.enteringNumberFromConsole(1, Integer.MAX_VALUE);

        Methods.encrypting(reversedAlphabetInCharArray,key,"","Файл успешно расшифрован.\n" +
                "результат сохранен в ту же папку под названием *(расшифрован ключем).txt"+
                "\nЖелаешь сделать что-то еще?\n","(расшифрован ключем)");
    }
}