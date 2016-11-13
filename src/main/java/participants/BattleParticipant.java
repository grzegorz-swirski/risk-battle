package participants;

import com.google.common.base.Preconditions;
import dices.DiceCollection;
import dices.DiceCollectionRollResult;
import lombok.Getter;

@Getter
public abstract class BattleParticipant {

    protected int armySize;
    protected DiceCollection diceCollection;

    public BattleParticipant(final int armySize) {
        Preconditions.checkArgument(armySize >= getMinArmySize(),
                String.format("Army must have at least %s soldiers", getMinArmySize()));
        this.setDiceCollection(armySize);
        this.armySize = armySize;
    }

    public DiceCollectionRollResult rollDices() {
        return diceCollection.roll();
    }

    public abstract int getMinArmySize();
    protected abstract void setDiceCollection(int armySize);
}
