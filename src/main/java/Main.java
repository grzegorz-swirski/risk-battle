import battle.Battle;
import participants.Attacker;
import participants.Defender;

public class Main {

    public static void main(String[] args) {

        Attacker attacker = new Attacker(10);
        Defender defender = new Defender(7);

        Battle battle = new Battle(attacker, defender);
        battle.execute();
    }
}
