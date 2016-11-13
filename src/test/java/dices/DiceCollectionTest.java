package dices;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DiceCollectionTest {

    private DiceCollection sut;

    @Mock
    private Dice diceMock;

    @Mock
    private Random randomGeneratorMock;

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
    public void instantiateCustom_validArguments_validCollectionInstantiated() {
        Collection<Dice> expectedDices = new ArrayList<>(Arrays.asList(
           new Dice(randomGeneratorMock, 12), new Dice(randomGeneratorMock, 20)
        ));

        sut = new DiceCollection(expectedDices);

        assertEquals(expectedDices, sut.getDices());
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
    public void rollDiceCollection_allDicesRolled() {
        int diceCollectionSize = 10;
        Collection<Dice> dices = getTestDiceCollection(diceCollectionSize);
        when(diceMock.roll()).thenReturn(new DiceRollResult(1));

        sut = new DiceCollection(dices);
        sut.roll();

        verify(diceMock, times(diceCollectionSize)).roll();
    }

    @Test
    public void rollDiceCollection_resultsNumEqualsDicesNum() {
        int diceCollectionSize = 10;
        Collection<Dice> dices = getTestDiceCollection(diceCollectionSize);
        when(diceMock.roll()).thenReturn(new DiceRollResult(1));

        sut = new DiceCollection(dices);
        Collection<DiceRollResult> result = sut.roll();

        assertEquals(diceCollectionSize, result.size());
    }

    private Collection<Dice> getTestDiceCollection(int size) {
        Collection<Dice> dices = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            dices.add(diceMock);
        }
        return dices;
    }

}
