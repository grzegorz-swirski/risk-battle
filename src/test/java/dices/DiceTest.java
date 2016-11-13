package dices;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Random;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DiceTest {

    @Mock
    private Random randomGenerator;

    private Dice sut;
    private int diceFacesNum = 6;

    @Test(expected = NullPointerException.class)
    public void createDice_nullRandomGenerator_throwNullPointer() {
        sut = new Dice(null, diceFacesNum);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createDice_notEnoughFaces_throwIllegalArgument() {
        sut = new Dice(randomGenerator, 0);
    }

    @Test
    public void rollDice() {
        sut = new Dice(randomGenerator, diceFacesNum);
        sut.roll();
        verify(randomGenerator, times(1)).nextInt(diceFacesNum);
    }

    @Test
    public void rollDice_minRollResultIsOne() {
        int minRandomNumber = 0;
        int minExpectedRollResult = 1;
        when(randomGenerator.nextInt(anyInt())).thenReturn(minRandomNumber);


        sut = new Dice(randomGenerator, diceFacesNum);
        int actualRollResult = sut.roll().getValue();

        Assert.assertEquals(minExpectedRollResult, actualRollResult);
    }

    @Test
    public void rollDice_maxRollResultAsExpected() {
        int expectedMaxRollResult = diceFacesNum;
        when(randomGenerator.nextInt(anyInt())).thenReturn(expectedMaxRollResult - 1);

        sut = new Dice(randomGenerator, diceFacesNum);
        int actualRollResult = sut.roll().getValue();

        Assert.assertEquals(expectedMaxRollResult, actualRollResult);
    }
}
