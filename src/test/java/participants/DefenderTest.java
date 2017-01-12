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

    @Test
    public void instantiate_oneSoldier_oneDice() {
        sut = new Defender(1);
        assertEquals(1, sut.getDiceCollection().getDices().size());
    }

    @Test
    public void instantiate_twoSoldiers_twoDices() {
        sut = new Defender(2);
        assertEquals(2, sut.getDiceCollection().getDices().size());
    }

    @Test
    public void instantiate_threeSoldiers_twoDices() {
        sut = new Defender(3);
        assertEquals(2, sut.getDiceCollection().getDices().size());
    }

    @Test
    public void takeDamage_armySizeDecremented() {
        sut = new Defender(10);
        sut.damage(1);
        assertEquals(9, sut.getArmySize());
    }

    @Test
    public void takeDamage_oneSoldierLeft_effectiveArmyOne_oneDice() {
        sut = new Defender(2);
        sut.damage(1);
        assertEquals(1, sut.getDiceCollection().getDices().size());
    }

    @Test
    public void takeDamage_noSoldiersLeft_effectiveArmyZero_emptyDiceCollection() {
        sut = new Defender(1);
        sut.damage(1);
        assertEquals(0, sut.getDiceCollection().getDices().size());
    }
}
