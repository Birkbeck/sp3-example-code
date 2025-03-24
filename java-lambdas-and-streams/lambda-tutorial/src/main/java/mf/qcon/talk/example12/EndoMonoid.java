package mf.qcon.talk.example12;

import java.util.function.*;

public interface EndoMonoid<A> extends Monoid<UnaryOperator<A>> {

    @Override
    default UnaryOperator<A> apply(UnaryOperator<A> a1, UnaryOperator<A> a2) {
        return (A a) -> a2.apply(a1.apply(a));
    }

    @Override
    default UnaryOperator<A> zero() {
        return a -> a;
    }
}
