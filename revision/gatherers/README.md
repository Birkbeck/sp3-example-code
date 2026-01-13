### Gatherers

#### The Problem

The existing `Stream` API provides a fixed set of intermediate operations like mapping, filtering, and sorting. 
However, it lacks a mechanism (similar to existing `Collectors`) for defining more complex operations, such as grouping elements into fixed-size windows or removing duplicates based on custom criteria. 
As a result, developers often had to resort to complicated workarounds or abandon streams in favor of iterative code ´

#### Solution

Stream gatherers allow developers to define custom intermediate operations for streams. 
These gatherers can be used with both finite and infinite streams and support sequential and parallel processing. 
This makes streams more versatile and adaptable to specific application needs (or the whims of a particular developer).

#### Example

The code demonstrates the use of a custom gatherer, `slidingWindow`, which groups stream elements into windows of a specified size, enabling advanced stream operations. 
