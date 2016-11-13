package battle;

import dices.DiceRollResult;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import participants.Attacker;
import participants.Defender;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BattleTest {

    private Battle sut;
    private Collection<DiceRollResult> sampleRollResults;

    @Mock
    private Attacker attackerMock;

    @Mock
    private Defender defenderMock;

    @Before
    public void init() {
        sut = new Battle(attackerMock, defenderMock);
        Optional<Collection<DiceRollResult>> resultOptional = Optional.ofNullable(sampleRollResults);
        sampleRollResults = resultOptional.orElseGet(BattleTest::getSampleRollResult);
    }

    private static Collection<DiceRollResult> getSampleRollResult() {
        Collection<DiceRollResult> diceRollResults = new ArrayList<>();
        diceRollResults.add(new DiceRollResult(6));
        diceRollResults.add(new DiceRollResult(1));
        diceRollResults.add(new DiceRollResult(3));
        return diceRollResults;
    }

    @Test(expected = NullPointerException.class)
    public void instantiateBattle_nullAttacker_throwNullPointer() {
        sut = new Battle(null, defenderMock);
    }

    @Test(expected = NullPointerException.class)
    public void instantiateBattle_nullDefender_throwNullPointer() {
        sut = new Battle(attackerMock, null);
    }

    @Test
    public void execute_battleFinished_doNotExecuteRoll() {
        when(attackerMock.getArmySize()).thenReturn(1);

        sut.execute();

        verify(attackerMock, never()).rollDices();
        verify(defenderMock, never()).rollDices();
    }

    @Test
    public void execute_BattleNotFinished_executeRoll() {
        when(attackerMock.getArmySize()).thenReturn(5).thenReturn(3).thenReturn(1);
        when(defenderMock.getArmySize()).thenReturn(5).thenReturn(3).thenReturn(1);
        when(attackerMock.rollDices()).thenReturn(sampleRollResults);
        when(defenderMock.rollDices()).thenReturn(sampleRollResults);
        int expectedRollExecutions = 2;

        sut.execute();

        verify(attackerMock, times(expectedRollExecutions)).rollDices();
        verify(defenderMock, times(expectedRollExecutions)).rollDices();
    }
}
