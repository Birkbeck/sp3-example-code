import java.util.*;

public class Sample {  
  public static void doWork(ContinuationScope scope) {
    System.out.println("Entering... " + Thread.currentThread());
    Continuation.yield(scope);
    
    System.out.println("Step 2 " + Thread.currentThread());
    Continuation.yield(scope);
    
    System.out.println("Step 3 " + Thread.currentThread());
    Continuation.yield(scope);
    
    System.out.println("Step 4 " + Thread.currentThread());
    Continuation.yield(scope);
    
    System.out.println("Step 5 " + Thread.currentThread());
  } 
  
  public static void main(String[] args) {   
    var scope = new ContinuationScope("sample");
    var continuation = new Continuation(scope, () -> doWork(scope));

    while(!continuation.isDone()) {
      System.out.println("In the loop with " + Thread.currentThread());
      continuation.run();
    }
  }
}

