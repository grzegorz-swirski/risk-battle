package participants;

import dices.DiceCollection;

public class Attacker extends BattleParticipant {

    public Attacker(int armySize) {
        super(armySize);
    }

    @Override
    public int getMinArmySize() {
        return 2;
    }

    @Override
    protected void setDiceCollection() {
        diceCollection = new DiceCollection((armySize >= 2 && armySize <= 4) ? armySize - 1 : 3, 6);
    }
}
