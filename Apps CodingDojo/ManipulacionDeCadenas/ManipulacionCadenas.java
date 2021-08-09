public class ManipulacionCadenas {
    public void trimAndConcat(String cadena1, String cadena2) {
        String str = cadena1.trim() + cadena2.trim();
        System.out.println(str); // HolaMundo 
    }
    public int getIndexOrNull(String palabra, char letra){
        int entregar = palabra.indexOf(letra);
        return entregar;
    }
    public int getIndexOrNull(String ca1, String ca2){
        int entrega = ca1.indexOf(ca2);
        return entrega;
    }
    public String concatSubstring(String c1, int n1, int n2, String c2) {
        String index = c1.substring(n1, n2); 
        return index + c2;
    }
}
