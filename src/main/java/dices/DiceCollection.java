package dices;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class DiceCollection {

    public static final int MIN_SIZE = 1;

    @Getter
    private final Collection<Dice> dices;

    public DiceCollection(Collection<Dice> dices) {
        Preconditions.checkNotNull(dices, "Dice collection may not be null");
        this.dices = ImmutableList.copyOf(dices);
    }

    public DiceCollection(final int dicesNum, final int facesNum) {
        Preconditions.checkArgument(dicesNum >= MIN_SIZE,
                "Collection of dices must contain at least one dice");

        List<Dice> dices = new ArrayList<Dice>();
        for (int i = 0; i < dicesNum; i++) {
            Random randomGenerator = new Random();
            dices.add(new Dice(randomGenerator, facesNum));
        }

        this.dices = ImmutableList.copyOf(dices);
    }

    public DiceCollectionRollResult roll() {
        Collection<DiceRollResult> rollResults = new ArrayList<>();
        dices.stream().forEach(dice -> rollResults.add(dice.roll()));
        return new DiceCollectionRollResult(rollResults);
    }
}
