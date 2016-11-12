package battle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BattleResultTest {

    private BattleResult sut;

    @Test(expected = IllegalArgumentException.class)
    public void initialize_attackingArmyZeroSoldiers_throwIllegalArgument() {
        sut = new BattleResult(0, 5);
    }
}
