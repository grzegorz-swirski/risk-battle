package dices;

import com.google.common.base.Preconditions;
import lombok.Getter;

import java.util.Random;

public class Dice {

    public static final int MIN_FACES_NUM = 4;
    public static final int MIN_ROLL_RESULT = 1;

    private final Random randomGenerator;

    @Getter
    private final int facesNum;

    public Dice(final Random randomGenerator, final int facesNum) {
        Preconditions.checkNotNull(randomGenerator,
                "Dice random generator may not be null");
        this.randomGenerator = randomGenerator;

        Preconditions.checkArgument(facesNum >= MIN_FACES_NUM,
                String.format("Dice must have at least %s faces", MIN_FACES_NUM));
        this.facesNum = facesNum;
    }

    public DiceRollResult roll() {
        // draw value from 0 inclusive to (facesNum - 1) inclusive and add 1
        int rollResultValue = MIN_ROLL_RESULT + randomGenerator.nextInt(facesNum);

        return new DiceRollResult(rollResultValue);
    }
}
