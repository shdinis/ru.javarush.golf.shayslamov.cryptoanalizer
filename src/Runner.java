public class Runner {
    public static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";
    public static final int MAGIC_KEY = 7;

    public static void main(String[] args) {
        int point = 0;
        while (point != 4) {
            System.out.println( "1.Зашифровать текст\n"+
                    "2.Расшифровать текст\n"+
                    "3.Взломать шифр\n"+
                    "4.Выход");

            point = Methods.enteringNumberFromConsole(1, 4);
            switch (point) {
                case 1:
                    new Cryptographer(ALPHABET);
                    break;
                case 2:
                    new Decoder(ALPHABET);
                    break;
                case 3:
                    new BruteForceDecoderThroughAnalysis(ALPHABET);
                    break;
                default:
                    break;
            }
        }
    }
}
