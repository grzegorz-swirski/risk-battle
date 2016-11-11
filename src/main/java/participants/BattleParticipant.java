package participants;

import com.google.common.base.Preconditions;
import lombok.Getter;

public abstract class BattleParticipant {

    @Getter
    private int armySize;

    public BattleParticipant(int armySize) {
        Preconditions.checkArgument(armySize >= getMinArmySize(),
                String.format("Army must have at least %s soldiers", getMinArmySize()));
        this.armySize = armySize;
    }

    public int getMinArmySize() {
        return 1;
    }
}
