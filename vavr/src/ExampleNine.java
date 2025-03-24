import io.vavr.Value;
import io.vavr.collection.List;
import io.vavr.concurrent.Future;

public class ExampleNine {
    public static void main(String[] args) {
        List<Future<Integer>> futureList = List.of(
                Future.of(() -> doubleIt(1)),
                Future.of(() -> doubleIt(2)),
                Future.of(() -> doubleIt(3)),
                Future.of(() -> doubleIt(4)),
                Future.of(() -> doubleIt(5))
        );

//        Future<Seq<Integer>> future = Future.traverse(ofAll(futureList), f -> f);
//        future.await();
//        future.onComplete(result -> {
//            if (result.isSuccess()) {
//                System.out.println(result.get());
//            } else {
//                System.out.println("Error: " + result.getCause());
//            }
//        });
        long start = System.currentTimeMillis();
        List<Integer> result = Future.sequence(List.ofAll(futureList)).map(Value::toList).get();
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + "ms");
        System.out.println(result);

        long start2 = System.currentTimeMillis();
        List<Integer> results = futureList.toJavaParallelStream().map(Future::get).collect(List.collector());
        long end2 = System.currentTimeMillis();
        System.out.println("Time taken: " + (end2 - start2) + "ms");
        System.out.println(results);
    }

    private static Integer doubleIt(Integer x) {
        return x * 2;
    }
}
