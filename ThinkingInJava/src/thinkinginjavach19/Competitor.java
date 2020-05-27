package thinkinginjavach19;

public interface Competitor<T extends Competitor<T>>{
    Outcome complete(T competitor);
}
