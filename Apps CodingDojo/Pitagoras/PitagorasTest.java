public class PitagorasTest{
    public static void main(String[] args) {
        Pitagoras pitagoras = new Pitagoras();
        int a = 6;
        int b = 8;
        double respuesta = pitagoras.calcularHipotenusa( a , b );
        System.out.println("La suma de los catetos dan el siguiente valor de la hipotenusa " + respuesta );
    }
}