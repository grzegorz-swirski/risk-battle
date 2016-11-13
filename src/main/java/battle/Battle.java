package battle;

import com.google.common.base.Preconditions;
import dices.DiceRollResult;
import participants.Attacker;
import participants.Defender;

import java.util.Collection;

public class Battle {

    private Attacker attacker;
    private Defender defender;

    public Battle(Attacker attacker, Defender defender) {
        Preconditions.checkNotNull(attacker, "Attacker may not be null.");
        Preconditions.checkNotNull(defender, "Defender may not be null.");
        this.attacker = attacker;
        this.defender = defender;
    };

    public BattleResult execute() {
        while (!battleFinished()) {
            executeRoll();
        }
        return new BattleResult(attacker.getArmySize(), defender.getArmySize());
    }

    private boolean battleFinished() {
        if (attacker.getArmySize() == 1 || defender.getArmySize() == 0) {
            return true;
        }
        return false;
    }

    private void executeRoll() {
        Collection<DiceRollResult> attackerResult = attacker.rollDices();
        Collection<DiceRollResult> defenderResult = defender.rollDices();
        compareAndTakeDamage(attackerResult, defenderResult);
    }

    private void compareAndTakeDamage(Collection<DiceRollResult> attackerResult,
                                      Collection<DiceRollResult> defenderResult) {
        int attackerDamage, defenderDamage = 0;


    }
}
