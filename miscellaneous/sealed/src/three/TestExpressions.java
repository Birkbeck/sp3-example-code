package three;

sealed interface Expr
    permits ConstantExpr, PlusExpr, TimesExpr, NegExpr {
    int eval();
}

public class TestExpressions {
    public static void main(String[] args) {
        //(6 + 7) * -8
        System.out.println(
            new TimesExpr(
                new PlusExpr(
                    new ConstantExpr(6),
                    new ConstantExpr(7)
                ),
                new NegExpr(new ConstantExpr(8))
            ).eval());
    }
}

final class ConstantExpr implements Expr {
    int i;

    ConstantExpr(int i) {
        this.i = i;
    }

    @Override
    public int eval() {
        return i;
    }
}

final class PlusExpr implements Expr {
    Expr a, b;

    PlusExpr(Expr a, Expr b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int eval() {
        return a.eval() + b.eval();
    }
}

final class TimesExpr implements Expr {
    Expr a, b;

    TimesExpr(Expr a, Expr b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int eval() {
        return a.eval() * b.eval();
    }
}

final class NegExpr implements Expr {
    Expr e;

    NegExpr(Expr e) {
        this.e = e;
    }

    @Override
    public int eval() {
        return -e.eval();
    }
}