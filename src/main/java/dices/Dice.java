package dices;

import com.google.common.base.Preconditions;
import lombok.Getter;

import java.util.Random;

public final class Dice {

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
        int rollResultValue = MIN_ROLL_RESULT + randomGenerator.nextInt(facesNum + 1);
        return new DiceRollResult(rollResultValue);
    }
}
