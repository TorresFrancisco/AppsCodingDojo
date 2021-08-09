public class Samurai extends Human{
    public Samurai(String name) {
        setName(name);
        this.setHealth(200);
    }
    public void deathBlow(Human human) {
        human.setHealth(human.getHealth() - 9999);
        this.setHealth(this.getHealth()/2);
        this.setMuertos(this.getMuertos() +1 );
        System.out.println(this.getName() + " Ha ejecutado a " + human.getName() + "." + " La vida de " + this.getName() + " baja a mitad " + this.getHealth() + ".");
    }
    public void meditate() {
        this.setHealth(this.getHealth() + this.getHealth()/2);
        System.out.println(this.getName() + " ocupa meditacion y recupera " + this.getHealth() + " puntos de salud.");
    }
    public void howMany() {
        System.out.println(this.getName()+ " ha asesinado a " + this.getMuertos() + " enemigos.");
    }

}
