Strategy
========

* Defined family of interchangeable and encapsulated algorithms
* Change algorithms independently of clients that use them

  java.util.Comparator, java.io.FileFilter

To sort integers represented as strings in descending order, you could do:

    Arrays.sort(stringArray, new ReverseComparator(new StringIntegerComparator()));

The sort algorithm is independent of the comparison behavioural.strategy.