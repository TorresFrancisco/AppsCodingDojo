public class Pitagoras {

public double calcularHipotenusa(int catetoA, int catetoB) {
    double c = 0;
    c = Math.sqrt(Math.pow(catetoA, 2) + Math.pow(catetoB, 2));
    return c;
    }
}