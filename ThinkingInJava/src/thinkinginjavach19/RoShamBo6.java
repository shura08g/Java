package thinkinginjavach19;

import static thinkinginjavach19.Outcome.*;

public enum RoShamBo6 implements Competitor<RoShamBo6> {
    PAPER, SCISSORS, ROCK;
    
    private static Outcome[][] table = {
        {DRAW, LOSE, WIN}, //PAPER
        {WIN, DRAW, LOSE}, //SCISSORS
        {LOSE, WIN, DRAW}  //ROCK
    };
    
    @Override
    public Outcome complete(RoShamBo6 other) {
        return table[this.ordinal()][other.ordinal()];
    }
    
    public static void main(String[] args) {
        RoShamBo.play(RoShamBo6.class, 20);
    }

}
/*
ROCK vs. ROCK: DRAW
SCISSORS vs. ROCK: LOSE
SCISSORS vs. ROCK: LOSE
SCISSORS vs. ROCK: LOSE
PAPER vs. SCISSORS: LOSE
PAPER vs. PAPER: DRAW
PAPER vs. SCISSORS: LOSE
ROCK vs. SCISSORS: WIN
SCISSORS vs. SCISSORS: DRAW
ROCK vs. SCISSORS: WIN
SCISSORS vs. PAPER: WIN
SCISSORS vs. PAPER: WIN
ROCK vs. PAPER: LOSE
ROCK vs. SCISSORS: WIN
SCISSORS vs. ROCK: LOSE
PAPER vs. SCISSORS: LOSE
SCISSORS vs. PAPER: WIN
SCISSORS vs. PAPER: WIN
SCISSORS vs. PAPER: WIN
SCISSORS vs. PAPER: WIN
*/