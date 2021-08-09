public class Ninja extends Human{
    public Ninja(String name) {
        setName(name);
        this.setStealth(10);
    }
    public void steal(Human human) {
        human.setHealth(human.getHealth() - this.getStealth());
        this.setHealth(this.getHealth() + this.getStealth());
        System.out.println(this.getName() + " Ha robado a " + human.getName() + " " +  this.getStealth() + " puntos de salud.");
    }
    public void runAway() {
        this.setHealth(this.getHealth()-10);
        System.out.println(this.getName() + " Ha arrancado " + this.getHealth() + " puntos de vida.");
    }

}
