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

    @Test
    public void instantiate_twoSoldiers_oneDice() {
        sut = new Attacker(2);
        assertEquals(1, sut.getDiceCollection().getDices().size());
    }

    @Test
    public void instantiate_threeSoldiers_twoDices() {
        sut = new Attacker(3);
        assertEquals(2, sut.getDiceCollection().getDices().size());
    }

    @Test
    public void instantiate_fourSoldiers_threeDices() {
        sut = new Attacker(4);
        assertEquals(3, sut.getDiceCollection().getDices().size());
    }

    @Test
    public void instantiate_fiveSoldiers_threeDices() {
        sut = new Attacker(5);
        assertEquals(3, sut.getDiceCollection().getDices().size());
    }
}
