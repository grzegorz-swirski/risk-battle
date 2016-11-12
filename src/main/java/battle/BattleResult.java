package battle;

import com.google.common.base.Preconditions;

public class BattleResult {

    private final int attackingArmySize;
    private final int defendingArmySize;

    public BattleResult(int attackingArmySize, int defendingArmySize) {
        Preconditions.checkArgument(attackingArmySize != 0, "Attacking " +
                "army cannot end battle with zero soldiers.");
        this.attackingArmySize = attackingArmySize;
        this.defendingArmySize = defendingArmySize;
    }
}
