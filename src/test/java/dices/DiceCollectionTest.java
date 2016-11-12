package dices;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class DiceCollectionTest {

    private DiceCollection sut;

    @Test(expected = NullPointerException.class)
    public void instantiate_nullCollection_throwNullPointer() {
        sut = new DiceCollection(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void instantiate_zeroDices_throwIllegalArgument() {
        sut = new DiceCollection(0, 6);
    }

    public void instantiate_oneDice_validCollectionInstantiated() {
        sut = new DiceCollection(1, 6);
    }

    @Test
    public void instantiate_validArguments_validCollectionInstantiated() {
        int dicesNum = 10;
        int facesNum = 6;

        sut = new DiceCollection(dicesNum, facesNum);

        assertEquals(dicesNum, sut.getDices().size());
        assertTrue(sut.getDices().stream()
                        .allMatch(dice -> dice.getFacesNum() == facesNum)
        );
    }

    @Test
    public void rollDiceCollection_resultsNumEqualsDicesNum() {
    }


}
