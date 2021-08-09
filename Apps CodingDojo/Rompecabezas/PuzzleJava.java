import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class PuzzleJava {
    public void EjercicioUno() {
        int[] array = { 3, 5, 1, 2, 7, 9, 8, 13, 25, 32 };
        int suma = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
            if (array[i] > 10) {
                arr.add(array[i]);
            }
        }
        System.out.println(suma);
        System.out.println(arr);
    }

    public void nombresMezclados() {
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<String> nombres2 = new ArrayList<>();
        String[] array = { "Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa" };
        for (int i = 0; i < array.length; i++) {
            nombres.add(array[i]);
        }
        Collections.shuffle(nombres);

        for (int i = 0; i < nombres.size(); i++) {
            if (nombres.get(i).length() > 5) {
                nombres2.add(nombres.get(i));
            }
        }
        System.out.println(nombres2);
    }

    public void imprimirLetras() {
        ArrayList<Character> l = new ArrayList<>();
        char[] letras = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        for (int i = 0; i < letras.length; i++) {
            l.add(letras[i]);
        }
        Collections.shuffle(l);
        System.out.println(l);
        System.out.println(l.get(0));
        System.out.println(l.get(letras.length - 1));
        if (l.get(0) == 'a') {
            System.out.println("La primera letra es una vocal");
        }
        if (l.get(0) == 'e') {
            System.out.println("La primera letra es una vocal");
        }
        if (l.get(0) == 'i') {
            System.out.println("La primera letra es una vocal");
        }
        if (l.get(0) == 'o') {
            System.out.println("La primera letra es una vocal");
        }
        if (l.get(0) == 'u') {
            System.out.println("La primera letra es una vocal");
        }
    }

    public void numerosAleatorios(ArrayList<Integer> x) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int nAleatorios = random.nextInt(101 - 54) + 54;
            x.add(nAleatorios);
        }
        System.out.println(x);
    }

    public void numerosAleatoriosOrdenados() {
        ArrayList<Integer> r = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int nAleatorios = random.nextInt(101 - 54) + 54;
            r.add(nAleatorios);
        }
        Collections.sort(r);
        System.out.println(r);
        System.out.println(r.get(0));
        System.out.println(r.get(9));
    }

    public void cadenaAleatoria() {
        ArrayList<String> texto = new ArrayList<>();
        String[] letras = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
                "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        for (int i = 0; i < letras.length; i++) {
            texto.add(letras[i]);
        }
        Collections.shuffle(texto);
        String word = (texto.get(0) + texto.get(1) + texto.get(2) + texto.get(3) + texto.get(4));
        System.out.println(word);
    }

    public void cadena10() {
        ArrayList<String> texto = new ArrayList<>();
        String[] letrita = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
                "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        for (int i = 0; i < letrita.length; i++) {
            texto.add(letrita[i]);
        }
        ArrayList<String> c10 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Collections.shuffle(texto);
            String word = (texto.get(0) + texto.get(1) + texto.get(2) + texto.get(3) + texto.get(4));
            c10.add(word);
        }
        System.out.println(c10);
    }
}
