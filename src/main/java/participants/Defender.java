package participants;

import com.google.common.base.Preconditions;
import dices.DiceCollection;
import lombok.Getter;

public class Defender extends BattleParticipant {

    public Defender(int armySize) {
        super(armySize);
    }

    @Override
    public int getMinArmySize() {
        return 1;
    }

    @Override
    protected void setDiceCollection(final int armySize) {
        diceCollection = new DiceCollection((armySize == 1) ? 1 : 2, 6);
    }
}
