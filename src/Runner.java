public class Runner {
    public static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";

    public static void main(String[] args) {
        int point = 0;
        while (point != 4) {
            System.out.println("1.Зашифровать текст");
            System.out.println("2.Расшифровать текст");
            System.out.println("3.Взломать шифр");
            System.out.println("4.Выход");

            point = Methods.Point(1, 4);
            switch (point) {
                case 1:
                    new Encryption(ALPHABET);
                    break;
                case 2:
                    new Decryption(ALPHABET);
                    break;
                case 3:
                    new BrutForce(ALPHABET);
                    break;
            }
        }
    }
}