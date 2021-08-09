import java.util.ArrayList;

public class Excepciones{
    public void exception() {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("Hola Mundo");
        myList.add(48);
        myList.add("Adios Mundo");
        for(int i = 0; i < myList.size(); i++) {
            try{
                int castedValue = (int) myList.get(i);
                System.out.println(castedValue);
            }
            catch (Exception e) {
                System.out.println(" Ha ocurrido un error " + e);
            }
        }
        System.out.println(" Termino el  programa y era ");
    }
}