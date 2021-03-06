package battle;

import com.google.common.base.Preconditions;
import lombok.Getter;

@Getter
public class BattleResult {

    private final int attackingArmySize;
    private final int defendingArmySize;

    public BattleResult(int attackingArmySize, int defendingArmySize) {
        Preconditions.checkArgument(attackingArmySize != 0, "Attacking " +
                "army cannot end battle with zero soldiers.");
        this.attackingArmySize = attackingArmySize;
        this.defendingArmySize = defendingArmySize;
    }

    @Override
    public String toString() {
        return String.format("Attacker: %s\nDefender: %s",
                attackingArmySize, defendingArmySize);
    }
}
