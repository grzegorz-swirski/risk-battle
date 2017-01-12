package participants;

import dices.DiceCollection;

public class Attacker extends BattleParticipant {

    private static final int MIN_ARMY_SIZE = 2;
    private static final int MAX_DICES_NUM = 3;

    public Attacker(int armySize) {
        super(armySize);
    }

    @Override
    public int getMinArmySize() {
        return 2;
    }

    @Override
    protected void setDiceCollection(final int armySize) {
        int effectiveArmySize = armySize - 1;
        diceCollection = new DiceCollection((effectiveArmySize < MAX_DICES_NUM) ?
                effectiveArmySize : MAX_DICES_NUM, DICE_FACES_NUM);
    }
}
