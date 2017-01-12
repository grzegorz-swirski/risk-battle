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
        return MIN_ARMY_SIZE;
    }

    @Override
    public int getMaxDicesNum() {
        return MAX_DICES_NUM;
    }

    @Override
    public int getEffectiveArmySize() {
        return armySize;
    }
}
