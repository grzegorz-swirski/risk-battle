import battle.Battle;
import battle.BattleResult;
import participants.Attacker;
import participants.BattleParticipant;
import participants.Defender;

public class Main {

    public static void main(String[] args) {

        Attacker attacker = new Attacker(10);
        Defender defender = new Defender(20);

        Battle battle = new Battle(attacker, defender);
        BattleResult result = battle.execute();
    }
}
