package battle;

import participants.Attacker;
import participants.Defender;

public class Battle {

    private Attacker attacker;
    private Defender defender;

    public Battle(int attackingArmySize, int defendingArmySize) {
        this.attacker = new Attacker(attackingArmySize);
        this.defender = new Defender(defendingArmySize);
    };



}
