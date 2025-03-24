// generic interface for question 2

@FunctionalInterface
interface TwoElementPredicate <T> {
    boolean findBest(T s1, T s2);
}
