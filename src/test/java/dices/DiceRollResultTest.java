package dices;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DiceRollResultTest {

    @Test(expected = IllegalArgumentException.class)
    public void createDiceRollResult_valueSmallerThanOne_throwIllegalArgument() {
        DiceRollResult sut = new DiceRollResult(0);
    }
}
