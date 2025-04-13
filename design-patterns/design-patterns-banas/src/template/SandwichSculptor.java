package template;

public class SandwichSculptor {

    public static void main(String[] args) {

        ItalianSub cust12Hoagie = new ItalianSub();

        cust12Hoagie.makeSandwich();

        System.out.println();

        VeggieSub cust13Hoagie = new VeggieSub();

        cust13Hoagie.makeSandwich();

    }

}