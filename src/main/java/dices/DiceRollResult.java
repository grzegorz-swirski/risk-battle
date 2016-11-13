package dices;

import com.google.common.base.Preconditions;
import lombok.Getter;

public class DiceRollResult implements Comparable<DiceRollResult> {

    @Getter
    private final int value;

    public DiceRollResult(int value) {
        Preconditions.checkArgument(value > 0,
                "Dice roll result may not be smaller than one");
        this.value = value;
    }

    @Override
    public int compareTo(DiceRollResult other) {
        return -1 * Integer.compare(value, other.getValue());
    }
}
