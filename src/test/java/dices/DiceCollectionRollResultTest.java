package dices;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DiceCollectionRollResultTest {

    @Test(expected = NullPointerException.class)
    public void createDiceCollectionRollResult_resultsNull_throwNullPointer() {
        DiceCollectionRollResult sut = new DiceCollectionRollResult(null);
    }
}
