public class Decryption {

    public Decryption(String alphabet) {
        System.out.println("Здесь код расшифрования текста");
        char[] alphabetCharRevers = Methods.Revers(alphabet.toCharArray());
        System.out.println("Выберите каким ключем расшифровать");
        int key = Methods.Point(1, Integer.MAX_VALUE);
        Methods.Encrypting(alphabetCharRevers,key,"","Файл успешно расшифрован.\n" +
                "результат сохранен в ту же папку под названием out.txt"+
                "\nЖелаешь сделать что-то еще?\n");
    }
}


