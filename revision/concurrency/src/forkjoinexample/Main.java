package forkjoinexample;

public class Main {
    public static void main(String[] args) {

        System.out.println(ForkJoinAdd.startForkJoinSum(100_000_000));
    }
}
