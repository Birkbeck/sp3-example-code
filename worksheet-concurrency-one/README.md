# Worksheet on Java Concurrency

Once you have completed this worksheet, you should have achieved the following learning goals:

- Launching different threads in a program
- Having a general understanding of how a non-deterministic program works
-  Synchronising access to shared resources
-  ...

Questions marked with `*` or `** `are advanced questions; you should not attempt them until you have completed the "ordinary" questions.

------

## 1. Text loops

Examine the following code (comments omitted for brevity). 
What will the output be for each thread and the `no threads` modes?


```java
     public class TextLoop implements Runnable {
        public static final int COUNT = 10;

    private final String name;

    public TextLoop(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < COUNT; i++) {
            System.out.println("Loop:" + name + ", iteration:" + i + ".");
        }
    }

    public static void main(String args[]) {
        if (args.length < 1 || (!args[0].equals("0") && !args[0].equals("1"))) {
            System.out.println("USAGE: java TextLoop <mode>");
            System.out.println("     mode 0: without threads");
            System.out.println("     mode 1: with threads");
        } else if (args[0].equals("0")) {
            for (int i = 0; i < 10; i++) {
                Runnable r = new TextLoop("Thread " + i);
                r.run();
            }
        } else {
            for (int i = 0; i < 10; i++) {
                Runnable r = new TextLoop("Thread " + i);
                Thread t = new Thread(r);
                t.start();
            }
        }
    }
} 
```

Compile and execute this code several times. 
Did you get the result you expected? 
Run it several times. 
Do you always get the same result in mode~0 as in mode~1?

## 2. Sleeping

Modify the code from the previous question so that method `run()` looks like the following:

```java
@Override
public void run() {
	for (int i = 0; i < COUNT; i++) {
  	sleep();
	}
}
```

```java
private void sleep() {
	try {
		Thread.sleep(1000); // Sleep one second
  } catch (InterruptedException ex) {
  	ex.printStackTrace(); // Nothing to do, sleep a bit less
  }
}
```

What differences do you expect between the two behaviours of the program (mode 0, mode 1)? 
Run the code to check whether your hypothesis holds. 

Now, change the behaviour of the method `sleep()` to be a little more verbose. 

```java
private void sleep() {
	try { 
  	System.out.print("Sleeping for a second");
    for (int i = 0; i < 5; i++) {
    	Thread.sleep(200); 
      System.out.print(".");
    }
    System.out.println("done!");
  } catch (InterruptedException ex) {
  		ex.printStackTrace(); // Nothing to do, sleep a bit less
  }
}
```

## 3. Counting

Examine the following code. 
What will the counter's value be at the end of its execution (comments omitted for brevity)? 

```java
public class Increaser implements Runnable {
	private Counter c;
    
	public Increaser(Counter counter) {
  	this.c = counter;
  }

  public static void main(String args[]) {
  	Counter counter = new Counter();
    for (int i = 0; i < 100; i++) {
    	Increaser increaserTask = new Increaser(counter);
      Thread t = new Thread(increaserTask);
      t.start();
  	}
 	}

 	public void run() {
  	System.out.println("Starting at " + c.getCount());
    for (int i = 0; i < 1000; i++) {
    	c.increase();
    }
    System.out.println("Stopping at " + c.getCount());
  }
}

public class Counter {
	private int n = 0;
  
  public void increase() {
  	n++;
  }
   
  public int getCount() {
  	return n;
  }
}
```

Compile and execute this code several times. 

Did you get the result you expected? 

Do you always get the same result? 

What would you change to ensure the counter's last value is what it should be?

## 4. misc.Bank account

Examine the following code of a simplified bank account (comments omitted for brevity).  Assume that many threads are accessing this object and think about the minimum number of `synchronized` statements needed to ensure correct behaviour. 

```java
public class BankAccount {
	private int balance = 0;
  
  public int getBalance() {
  	return balance;
  }
  
  public void deposit(int money) {
  	balance = balance + money;
  }
  
  public int retrieve(int money) {
  	int result = 0;
    if (balance > money) {
    	result = money;
    } else {
    	result = balance;
    }
    balance = balance - result;
    return result;
  }
}
```

Check your answer with a colleague or one of the faculty members. 

## 5. Responsive UI

Write a program that asks the user the length in milliseconds of ten tasks. As the user enters the length, the tasks start running in the background while the user enters the length of the other tasks. At the end of the functions, the program must register and say it unless it waits for the user to enter data. See the following sample output:

```shell
Enter the duration (in ms) of task 0: 10
Enter the duration (in ms) of task 1: 3000
Finished tasks: 0
Enter the duration (in ms) of task 2: 2000
Enter the duration (in ms) of task 3: 1000
Enter the duration (in ms) of task 4: 10
Enter the duration (in ms) of task 5: 1000
Finished tasks: 2, 1, 3, 4
Enter the duration (in ms) of task 6: 
...
```

Note that several tasks may end between two user inputs. In the example provided, tasks 1, 2, 3, and 4 (not in that order) end between the moment the user enters `10` for task 4 and the moment the user enters `1000` for task 5. 

Write two versions of your program (on different branches of your repo), one using `Thread.isAlive()` and the other without using that method. 

**Note:** Remember that it is bad practice to have static fields if they are not `final`. Do not use `static` fields in this exercise (or any other in the future, unless there is no other option).

## 6. Parallel computation

Examine the program `ComputationLauncher` from the repo for an example of a heavy computation being performed in sequence or in parallel
using more than one processor simultaneously. In an old machine with two processors, the output looks like: 

```shell
Result: 7.999582837247596E14
Time without threads: 11110ms
Result: 7.999582837247596E14
Time with threads: 6326ms
```

Make sure you understand how the program works. How would you modify the program if your machine had four processors? You can see how many processors (or cores) your machine has by reading the value of: 

`Runtime.getRuntime().availableProcessors();`

## 7. Immutability (*)

Examine the program `ImmutableExample`. Please read it carefully. 
Do you see any flaws? If yes, what would you change to make the program work without problems? 
What would you change to make the `MutableIDCard` class immutable?

## 8. Self-ordering list (*)

One of the advantages of using threads in some applications is that they allow programmers to do costly operations in the background when nobody is looking. For example, a self-sorting list can reorder between calls to minimise the time needed to add elements (e.g., in applications where details are added in big batches but rarely consulted).

**Hint:** It may be easier to create your dynamic list for this exercise instead of relying on those from the *Java Collections Library* (JCL). Remember that the latter are not thread-safe, i.e., they are not correctly synchronised, so they require external synchronisation. 

Create a list of `Integers` that keeps itself sorted by sorting itself when others are not looking. The list must have at least methods `add(Integer)` (to add new Integers) and `get(int)` (to get the i$^{th}$ integer in the (sorted) list). 

- The `add()` method must add the new element at the end of the list, mark the list as `not sorted` and return immediately.
- Another thread must always observe the list and check whether it is sorted; if it is, it must mark it as `sorted`; if not, the thread must sort it. The thread must re-order the list in small steps to make sure it does not cause additional delay when new elements are added to the list while it is sorting itself (i.e., do not include a long loop in your synchronised code that may block the addition of new elements for a long time).
- The method `get(int)` must always return the i$^{th}$  integer in the (sorted) list; if this method is called while the list is `not sorted`, the list must be fully sorted before it can return; no additional elements can be added until the call of `get(int)` returns.

Create another self-ordering list in which the `add()` method launches a new thread whose only purpose is to add the new integer at the right position. (**Hint:** If the new element has to be placed at the beginning of the list, there is no need to launch a thread only for that).

------

End of worksheet
