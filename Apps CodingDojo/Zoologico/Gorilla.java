public class Gorilla extends Mammal{
    public void throwSomething() {
        energyLevel -= 5;
        System.out.println("Gorilla ha lanzado algo " + energyLevel + " puntos de energia" );
    }
    public void eatBananas() {
        energyLevel += 10;
        System.out.println("Gorilla ha saciado su hambre con un platano " + energyLevel
        + " se han sumado 10 puntos de energia");
    }
    public void climb() {
        energyLevel -= 10;
        System.out.println("Gorilla ha trepadoa a la cima de un arbol " + energyLevel
        +  " ha disminuido su energia en 10 puntos");
    }
}
