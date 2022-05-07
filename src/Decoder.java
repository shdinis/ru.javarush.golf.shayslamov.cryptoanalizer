public class Decoder {
    private static final String MESSAGE = "Файл успешно расшифрован.\n" +
            "результат сохранен в ту же папку под названием *(расшифрован ключем).txt\n" +
            "Желаешь сделать что-то еще?\n";
    private static final String ENDING_TO_NAME = "(расшифрован ключем)";
    private int key;

    public Decoder() {
        System.out.println("Здесь код расшифрования текста");
        System.out.println("Выберите каким ключем расшифровать");

        key = Methods.enteringNumberFromConsole(1, Integer.MAX_VALUE);

        Methods.encrypting(Runner.reversedAlphabetInCharArray, key, "", MESSAGE, ENDING_TO_NAME);
    }
}