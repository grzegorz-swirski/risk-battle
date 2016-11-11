package dices;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DiceCollectionTest {

    @Test(expected = IllegalArgumentException.class)
    public void instantiate_zeroDices_throwIllegalArgument() {
        DiceCollection sut = new DiceCollection(0, 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void instantiate_oneDice_throwIllegalArgument() {
        DiceCollection sut = new DiceCollection(1, 6);
    }

    @Test(expected = NullPointerException.class)
    public void instantiate_nullCollection_throwNullPointer() {
        DiceCollection sut = new DiceCollection(null);
    }

    @Test
    public void instantiate_validArguments_validCollectionInstantiated() {
        int dicesNum = 10;
        int facesNum = 6;

        DiceCollection sut = new DiceCollection(dicesNum, facesNum);

        Assert.assertEquals(sut.getDices().size(), dicesNum);
        Assert.assertTrue(sut.getDices().stream()
                        .allMatch(dice -> dice.getFacesNum() == facesNum)
        );
    }

    @Test
    public void rollDiceCollection_resultsNumEqualsDicesNum() {
    }


}
