public class Cryptographer {
    private static final String MESSAGE = "Файл успешно зашифрован.\n" +
            "результат сохранен в ту же папку под названием *(зашифрован).txt\n" +
            "Желаешь сделать что-то еще?\n";
    private static final String ENDING_TO_NAME = "(зашифрован)";
    private final char[] alphabetInCharArray = Runner.ALPHABET.toCharArray();

    public Cryptographer() {
        System.out.println("Здесь код шифрования текста");
        System.out.println("Выберите каким ключем зашифровать");

        int key = Methods.enteringNumberFromConsole(1, Integer.MAX_VALUE);

        Methods.encrypting(alphabetInCharArray, key, "", MESSAGE, ENDING_TO_NAME);
    }
}