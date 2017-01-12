package participants;

import com.google.common.base.Preconditions;
import dices.DiceCollection;
import dices.DiceRollResult;
import lombok.Getter;

import java.util.Collection;

@Getter
public abstract class BattleParticipant {

    public static final int DICE_FACES_NUM = 6;

    protected int armySize;
    protected DiceCollection diceCollection;

    public BattleParticipant(final int armySize) {
        Preconditions.checkArgument(armySize >= getMinArmySize(),
                String.format("Army must have at least %s soldiers", getMinArmySize()));
        this.armySize = armySize;
        this.setDiceCollection(this.armySize);
    }

    public Collection<DiceRollResult> rollDices() {
        return diceCollection.roll();
    }

    public void damage(int lostSoldiersNum) {
        armySize -= lostSoldiersNum;
        setDiceCollection(armySize);
    }

    private void setDiceCollection(int armySize) {
        int effectiveArmySize = getEffectiveArmySize();
        diceCollection = new DiceCollection((effectiveArmySize < getMaxDicesNum()) ?
                effectiveArmySize : getMaxDicesNum(), DICE_FACES_NUM);
    }

    public abstract int getEffectiveArmySize();
    public abstract int getMinArmySize();
    public abstract int getMaxDicesNum();
}
