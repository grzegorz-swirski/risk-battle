package battle;

import com.google.common.base.Preconditions;
import dices.DiceCollectionRollResult;
import dices.DiceRollResult;
import participants.Attacker;
import participants.Defender;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import com.google.common.collect.Lists;

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
        DiceCollectionRollResult attackerResult = attacker.rollDices();
        DiceCollectionRollResult defenderResult = defender.rollDices();
        compareAndTakeDamage(attackerResult, defenderResult);
    }

    private void compareAndTakeDamage(DiceCollectionRollResult attackerResult,
                                      DiceCollectionRollResult defenderResult) {
        int attackerDamage, defenderDamage = 0;

        ArrayList<DiceRollResult> attackerSortedResults =
                Lists.newArrayList(getSorted(attackerResult));

        ArrayList<DiceRollResult> defenderSortedResults =
                Lists.newArrayList(getSorted(defenderResult));
    }

    private List<DiceRollResult> getSorted(DiceCollectionRollResult result) {
        return result.getDiceRollResults().stream().sorted().collect(Collectors.toList());
    }
}
