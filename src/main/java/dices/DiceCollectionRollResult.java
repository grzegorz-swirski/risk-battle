package dices;

import com.google.common.base.Preconditions;
import lombok.Getter;

import java.util.Collection;

public class DiceCollectionRollResult {

    @Getter
    private Collection<DiceRollResult> diceRollResults;

    public DiceCollectionRollResult(Collection<DiceRollResult> diceRollResults) {
        Preconditions.checkNotNull(diceRollResults,
                "Dice roll results may not be null");
        this.diceRollResults = diceRollResults;
    }
}
