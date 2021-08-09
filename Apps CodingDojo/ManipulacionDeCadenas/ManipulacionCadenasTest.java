public class ManipulacionCadenasTest {
    public static void main(String[] args) {
        ManipulacionCadenas manipulator = new ManipulacionCadenas();
        manipulator.trimAndConcat("    Hola     ","     Mundo    ");

        char letter = 'n';
        int a = manipulator.getIndexOrNull("Coding", letter);
        int b = manipulator.getIndexOrNull("Hola Mundo", letter);
        int c = manipulator.getIndexOrNull("Saludar", letter);
        System.out.println(a); // 4
        System.out.println(b); // 7
        System.out.println(c); // -1

        String word = "Hola";
        String subString = "la";
        String notSubString = "mundo";
        int x = manipulator.getIndexOrNull(word, subString);
        int y = manipulator.getIndexOrNull(word, notSubString);
        System.out.println(x); // 2
        System.out.println(y); // -1

        String words = manipulator.concatSubstring("Hola", 1, 3, "mundo");
        System.out.println(words); // olmundo

    }
}

