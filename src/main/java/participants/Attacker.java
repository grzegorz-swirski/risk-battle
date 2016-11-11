package participants;

import com.google.common.base.Preconditions;
import lombok.Getter;

public class Attacker extends BattleParticipant {

    public Attacker(int armySize) {
        super(armySize);
    }

    @Override
    public int getMinArmySize() {
        return 2;
    }
}
