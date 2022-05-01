public class Encryption {

    public Encryption(String alphabet) {
        System.out.println("Здесь код шифрования текста");
        char[] alphabetChar = alphabet.toCharArray();
        System.out.println("Выберите каким ключем зашифровать");
        int key = Methods.Point(1, alphabetChar.length - 1);
        Methods.Encrypting(alphabetChar, key,"","Файл успешно зашифрован.\n" +
                "результат сохранен в ту же папку под названием out.txt"+
                "\nЖелаешь сделать что-то еще?\n");
    }
}

