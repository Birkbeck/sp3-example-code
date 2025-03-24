package mf.qcon.talk.example12;

import java.util.function.*;

public class FluentEndoMonoid<A> implements EndoMonoid<A> {
    private final UnaryOperator<A> endo;


    public FluentEndoMonoid(UnaryOperator<A> endo) {
        this.endo = endo;
    }

    public FluentEndoMonoid(UnaryOperator<A> endo, boolean b) {
        this.endo = b ? endo : zero();
    }

    public static <A> FluentEndoMonoid<A> endo(UnaryOperator<A> f) {
        return new FluentEndoMonoid<A>(f);
    }

    public static <A> FluentEndoMonoid<A> endo(UnaryOperator<A> f, boolean b) {
        return new FluentEndoMonoid<A>(f, b);
    }

    public FluentEndoMonoid<A> add(UnaryOperator<A> other) {
        return new FluentEndoMonoid<A>(apply(endo, other));
    }

    public FluentEndoMonoid<A> add(UnaryOperator<A> other, boolean b) {
        return add(b ? other : zero());
    }

    public UnaryOperator<A> get() {
        return endo;
    }
}
