public class Human {
    private int strength = 3;
    private int intelligence = 3;
    private int stealth = 3;
    private int health = 100;
    public String name;
    private int muertos = 0;
    
    //Constructor

    public Human() {
    }
    public Human(String name){
        setName(name);
    }
    //Getters and Setters

    public int getMuertos() {
        return muertos;
    }
    public void setMuertos(int muertos) {
        this.muertos = muertos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getStrength() {
        return strength;

    }
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getStealth() {
        return stealth;
    }

    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
