package ex03;

// PROVIDED CODE

/* public class Counter {

	private int n = 0;

	public void increase() {
			n++;
	}

	public int getCount() {
		return n;
	}

}
*/

// these changes ensures that n++ is atomic (?)
// & so always get to 100 X 1,000 = 100,000

/**
 * We could synchronize on the method or the current object
 * Alternatively we could add a "dummy" object (obj in this case)
 * that we can also use to synchronize on.
 */
public class Counter {

  //private Object obj = new Object();

  private int n = 0;

  public void increase() {

    synchronized (this) {   // could also be obj
      n++;
    }
  }

  public int getCount() {
    return n;
  }
}


// This produces the same results and synchronizes on the method instead
// In this case there is very little difference between the two choices

// One could argue that the get should also be synchronized - this would
// be true if one is not dealing with an atomic value

/*	private int n = 0;

	public synchronized void increase() {
			n++;
	}

	public int getCount() {
		return n;
	}
*/
