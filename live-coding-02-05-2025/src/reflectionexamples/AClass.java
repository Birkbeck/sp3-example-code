package reflectionexamples;

public class AClass implements A {
    public boolean b;
    protected String y;
    float f;
    private int x;

    public AClass(float f, int x) {
    }

    public AClass() {
        System.err.println(this.getClass().getSimpleName());
    }

    public AClass(int x) {
    }

    @Override
    public String getThing(String s) {
        return s;
    }
}