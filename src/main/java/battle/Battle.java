package battle;

import com.google.common.base.Preconditions;
import dices.DiceRollResult;
import participants.Attacker;
import participants.BattleParticipant;
import participants.Defender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

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
            ArrayList<DiceRollResult> attackerResults = rollAndSortResults(attacker);
            ArrayList<DiceRollResult> defenderResults = rollAndSortResults(defender);
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

    private ArrayList<DiceRollResult> rollAndSortResults(BattleParticipant participant) {
        ArrayList<DiceRollResult> rollResults = new ArrayList<>(participant.rollDices());
        Collections.sort(rollResults, Collections.reverseOrder());
        return rollResults;
    }

    private void compareAndTakeDamage(ArrayList<DiceRollResult> attackerResults,
                                      ArrayList<DiceRollResult> defenderResults) {
        // for each defender compare with attacker and:
        // attacker.takeDamage(int k)
        // defender.takeDamage(int p)
    }
}
