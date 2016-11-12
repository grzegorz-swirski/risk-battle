package battle;

import dices.DiceCollectionRollResult;
import participants.Attacker;
import participants.Defender;

public class Battle {

    private Attacker attacker;
    private Defender defender;

    public Battle(int attackingArmySize, int defendingArmySize) {
        this.attacker = new Attacker(attackingArmySize);
        this.defender = new Defender(defendingArmySize);
    };

    public BattleResult execute() {
        while (battleFinished()) {
            break;
        }
        return null;
    }

    private boolean battleFinished() {
        if (attacker.getArmySize() == 1 || defender.getArmySize() == 0) {
            return true;
        }
        return false;
    }

    private void executeRoll() {

    }
}
