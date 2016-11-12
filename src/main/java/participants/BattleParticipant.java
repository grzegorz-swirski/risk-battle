package participants;

import com.google.common.base.Preconditions;
import dices.DiceCollection;
import lombok.Getter;

@Getter
public abstract class BattleParticipant {

    protected int armySize;
    protected DiceCollection diceCollection;

    public BattleParticipant(int armySize) {
        Preconditions.checkArgument(armySize >= getMinArmySize(),
                String.format("Army must have at least %s soldiers", getMinArmySize()));
        this.armySize = armySize;
        this.setDiceCollection();
    }

    public abstract int getMinArmySize();
    protected abstract void setDiceCollection();
}
