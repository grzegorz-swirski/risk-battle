package participants;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AttackerTest {

    private Attacker sut;

    @Test(expected = IllegalArgumentException.class)
    public void instantiate_lessThanZeroSoldiers_throwIllegalArgument() {
        sut = new Attacker(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void instantiate_zeroSoldiers_throwIllegalArgument() {
        sut = new Attacker(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void instantiate_oneSoldier_throwIllegalArgument() {
        sut = new Attacker(1);
    }

    @Test
    public void instantiate_validArmySize_armySizeSet() {
        int expectedArmySize = 2;
        sut = new Attacker(expectedArmySize);
        assertEquals(expectedArmySize, sut.getArmySize());
    }
}
