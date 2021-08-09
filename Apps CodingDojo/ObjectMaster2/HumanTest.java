public class HumanTest {
    public static void main(String[] args) {

        Ninja kennen = new Ninja("Kennen");
        Samurai yasuo = new Samurai("Yasuo");
        Wizzard nami = new Wizzard("Nami");

        nami.heal(yasuo);
        nami.fireBall(kennen);
        kennen.steal(nami);
        kennen.runAway();
        yasuo.deathBlow(kennen);
        yasuo.deathBlow(nami);
        yasuo.meditate();
        yasuo.howMany();


    }
}
