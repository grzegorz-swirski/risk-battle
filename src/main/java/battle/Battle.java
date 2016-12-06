package battle;

import com.google.common.base.Preconditions;
import dices.DiceRollResult;
import participants.Attacker;
import participants.Defender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
            ArrayList<DiceRollResult> attackerResults = new ArrayList<>(attacker.rollDices());
            ArrayList<DiceRollResult> defenderResults = new ArrayList<>(defender.rollDices());
            compareAndTakeDamage(attackerResults, defenderResults);
        }
        return new BattleResult(attacker.getArmySize(), defender.getArmySize());
    }

    private boolean battleFinished() {
        if (attacker.getArmySize() == 1 || defender.getArmySize() == 0) {
            return true;
        }
        return false;
    }

    private void compareAndTakeDamage(List<DiceRollResult> attackerResults,
                                      List<DiceRollResult> defenderResults) {
        Collections.sort(attackerResults, Comparator.reverseOrder());
        Collections.sort(defenderResults, Comparator.reverseOrder());
        int activeDicesNum = Math.min(defenderResults.size(), attackerResults.size());
        for (int i = 0; i < activeDicesNum; i++) {
            if (defenderResults.get(i).getValue() >= attackerResults.get(i).getValue()) {
                attacker.damage(1);
            } else {
                defender.damage(1);
            }
        }
    }
}
