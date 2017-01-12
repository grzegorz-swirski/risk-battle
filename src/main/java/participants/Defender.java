package participants;

import dices.DiceCollection;

public class Defender extends BattleParticipant {

    private static final int MIN_ARMY_SIZE = 1;
    private static final int MAX_DICES_NUM = 2;

    public Defender(int armySize) {
        super(armySize);
    }

    @Override
    public int getMinArmySize() {
        return 1;
    }

    @Override
    protected void setDiceCollection(final int armySize) {
        int effectiveArmySize = armySize;
        diceCollection = new DiceCollection((effectiveArmySize < MAX_DICES_NUM) ?
                effectiveArmySize : MAX_DICES_NUM, DICE_FACES_NUM);
    }
}
