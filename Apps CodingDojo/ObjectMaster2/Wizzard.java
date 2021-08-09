public class Wizzard extends Human{
    public Wizzard(String name) {
        setName(name);
        this.setHealth(50);
        this.setIntelligence(8);
    }
    public void heal(Human human) {
        human.setHealth(human.getHealth() + this.getIntelligence());
        System.out.println( this.getName() + " ha curado a " + human.getName() + " ha restado " + this.getIntelligence() + " puntos de salud." );
    }
    public void fireBall(Human human) {
        human.setHealth(human.getHealth() - (this.getIntelligence()*3));
        System.out.println( this.getName() + " ha lanzado una Bola de Fuego a " + human.getName() + " ha restado " + (this.getIntelligence()*3) + " puntos de salud.");
    }

    
}
