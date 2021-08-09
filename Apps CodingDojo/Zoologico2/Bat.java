
public class Bat extends Mammal{
    public int energyLevel = 300;
    public void fly() {
        energyLevel -= 50;
        System.out.println("Bat chilla al despegar " 
        + energyLevel + " su energia bajo 50 puntos.");
    }
    public void eatHumans() {
        energyLevel += 25;
        System.out.println("Bueno, no importa " +
         energyLevel + " su energia aumenta en 25 puntos");
    }
    public void attackTown() {
        energyLevel -= 100;
        System.out.println("Ciudad en llamas " +
         energyLevel + " su energia disminuye en 100 puntos");
    }
}
