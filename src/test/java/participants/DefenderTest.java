package participants;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DefenderTest {

    private Defender sut;

    @Test(expected = IllegalArgumentException.class)
    public void instantiate_lessThanZeroSoldiers_throwIllegalArgument() {
        sut = new Defender(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void instantiate_zeroSoldiers_throwIllegalArgument() {
        sut = new Defender(0);
    }

    @Test
    public void instantiate_validArmySize_armySizeSet() {
        int expectedArmySize = 1;
        sut = new Defender(expectedArmySize);
        assertEquals(expectedArmySize, sut.getArmySize());
    }
}
