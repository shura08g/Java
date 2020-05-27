package thinkinginjavach19;

public enum RoShamBo4 implements Competitor<RoShamBo4>{
    ROCK {
        @Override
        public Outcome complete(RoShamBo4 opponent) {
            return complete(SCISSORS, opponent);
        }
    },
    SCISSORS {
        @Override
        public Outcome complete(RoShamBo4 opponent) {
            return complete(PAPER, opponent);
        }
    },
    PAPER {
        @Override
        public Outcome complete(RoShamBo4 opponent) {
            return complete(ROCK, opponent);
        }
    };
    
    Outcome complete(RoShamBo4 loser, RoShamBo4 opponent) {
        return ((opponent == this) ? Outcome.DRAW
                : ((opponent == loser) ? Outcome.WIN
                : Outcome.LOSE));
    }
    
    public static void main(String[] args) {
        RoShamBo.play(RoShamBo4.class, 20);
    }
}
/*
PAPER vs. PAPER: DRAW
SCISSORS vs. PAPER: WIN
SCISSORS vs. PAPER: WIN
SCISSORS vs. PAPER: WIN
ROCK vs. SCISSORS: WIN
ROCK vs. ROCK: DRAW
ROCK vs. SCISSORS: WIN
PAPER vs. SCISSORS: LOSE
SCISSORS vs. SCISSORS: DRAW
PAPER vs. SCISSORS: LOSE
SCISSORS vs. ROCK: LOSE
SCISSORS vs. ROCK: LOSE
PAPER vs. ROCK: WIN
PAPER vs. SCISSORS: LOSE
SCISSORS vs. PAPER: WIN
ROCK vs. SCISSORS: WIN
SCISSORS vs. ROCK: LOSE
SCISSORS vs. ROCK: LOSE
SCISSORS vs. ROCK: LOSE
SCISSORS vs. ROCK: LOSE
*/