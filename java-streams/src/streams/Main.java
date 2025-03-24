<<<<<<< Updated upstream
package streams;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.Vector;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", 100_000.0),
                new Employee(2, "Bill Gates", 200_000.0),
                new Employee(3, "Mark Zuckerberg", 300_000.0)
        };
        List<Employee> empList = Arrays.asList(arrayOfEmps);
        EmployeeRepository employeeRepository = new EmployeeRepository(empList);
        //whenFilterEmployees_thenGetFilteredStream(employeeRepository);
        //whenStreamToArray_thenGetArray(empList);
        //whenLimitInfiniteStream_thenGetFiniteElements();
        //whenSortStream_thenGetSortedStream(empList);
        whenFindMin_thenGetMinElementFromStream(empList);
//        System.out.println(empList);
//
//        Double tmp = arrayOfEmps[0].getSalary() * 1.1;
//        arrayOfEmps[0].salaryIncrement(.1);

        //empList.stream().forEach(e -> e.salaryIncrement(10.0));
//        empList.forEach(e -> e.salaryIncrement(10.0));
//        System.out.println(empList);

//        Integer[] empIds = {1, 99, 3};
//        var employees = Stream.of(empIds)
//                .map(employeeRepository::findById)
//                .toList();
//        System.out.println(employees);
//
//        Stream.Builder<Employee> empStreamBuilder = Stream.builder();
//
//        empStreamBuilder.accept(arrayOfEmps[0]);
//        empStreamBuilder.accept(arrayOfEmps[1]);
//        empStreamBuilder.accept(arrayOfEmps[2]);
//        Stream<Employee> empStream = empStreamBuilder.build();

//        List<List<String>> namesNested = Arrays.asList(
//                Arrays.asList("Jeff", "Bezos"),
//                Arrays.asList("Bill", "Gates"),
//                Arrays.asList("Mark", "Zuckerberg"));
//        System.out.println(namesNested);

//        for (var x : namesNested) {
//            System.out.println(x);
//        }

//        List<String> namesFlatStream = namesNested.stream()
//                .parallel()
//                .flatMap(Collection::stream)
//                .toList();
//        System.out.println(namesFlatStream);
    }

    public static void whenFilterEmployees_thenGetFilteredStream(EmployeeRepository employeeRepository) {
        Integer[] empIds = {1, 99, 3, 2};

        List<Employee> employees = Stream.of(empIds)
                .map(employeeRepository::findById)
                .filter(Objects::nonNull)
                .filter(e -> e.getSalary() > 200_000)
                .toList();

        employees.forEach(System.out::println);
    }


    public static void whenStreamToArray_thenGetArray(List<Employee> empList) {
        Employee[] employees = empList.toArray(Employee[]::new);
        System.out.println(Arrays.toString(employees));
    }


    public static void whenStreamCount_thenGetElementCount(List<Employee> empList) {
        Long empCount = empList.stream()
                .filter(e -> e.getSalary() > 200_000)
                .count();
        System.out.println(empCount);
    }

    public static void whenLimitInfiniteStream_thenGetFiniteElements() {
        Stream<BigInteger> infiniteStream = Stream.iterate(BigInteger.TWO, i -> i.multiply(BigInteger.TWO));

        List<BigInteger> result = infiniteStream
                .skip(99)
                .limit(5)
                .toList();
        System.out.println(result);
    }


    public static void whenSortStream_thenGetSortedStream(List<Employee> empList) {
        List<Employee> employees = empList.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .toList();
        System.out.println(employees);
    }


    public static void whenFindMin_thenGetMinElementFromStream(List<Employee> empList) {
        //empList = List.of();
        var firstEmp = empList.stream()
                .min((e1, e2) -> e1.getId() - e2.getId());

                //.orElseThrow(NoSuchElementException::new);
        System.out.println(firstEmp.isPresent());
    }


    public void whenFindMax_thenGetMaxElementFromStream() {
//        Employee maxSalEmp = empList.stream()
//                .max(Comparator.comparing(Employee::getSalary))
//                .orElseThrow(NoSuchElementException::new);
//
//        // assert(maxSalEmp.getSalary(), new Double(300000.0));
    }


    public void whenApplyDistinct_thenRemoveDuplicatesFromStream() {
        List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
        List<Integer> distinctIntList = intList.stream().distinct().collect(Collectors.toList());

        // assert(distinctIntList, Arrays.asList(2, 5, 3, 4));
    }


    public void whenApplyMatch_thenReturnBoolean() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);

        boolean allEven = intList.stream().allMatch(i -> i % 2 == 0);
        boolean oneEven = intList.stream().anyMatch(i -> i % 2 == 0);
        boolean noneMultipleOfThree = intList.stream().noneMatch(i -> i % 3 == 0);

        // assert(allEven, false);
        // assert(oneEven, true);
        // assert(noneMultipleOfThree, false);
    }


    public void whenFindMaxOnIntStream_thenGetMaxInteger() {
//        Integer latestEmpId = empList.stream()
//                .mapToInt(Employee::getId)
//                .max()
//                .orElseThrow(NoSuchElementException::new);

        // assert(latestEmpId, new Integer(3));
    }


    public void whenApplySumOnIntStream_thenGetSum() {
//        Double avgSal = empList.stream()
//                .mapToDouble(Employee::getSalary)
//                .average()
//                .orElseThrow(NoSuchElementException::new);

        // assert(avgSal, new Double(200000));
    }


    public void whenApplyReduceOnStream_thenGetValue() {
//        Double sumSal = empList.stream()
//                .map(Employee::getSalary)
//                .reduce(0.0, Double::sum);

        // assert(sumSal, new Double(600000));
    }


    public void whenCollectByJoining_thenGetJoinedString() {
//        String empNames = empList.stream()
//                .map(Employee::getName)
//                .collect(Collectors.joining(", "))
//                .toString();

        // assert(empNames, "Jeff Bezos, Bill Gates, Mark Zuckerberg");
    }


    public void whenCollectBySet_thenGetSet() {
//        Set<String> empNames = empList.stream()
//                .map(Employee::getName)
//                .collect(Collectors.toSet());

        // assert(empNames.size(), 3);
    }


    public void whenToVectorCollection_thenGetVector() {
//        Vector<String> empNames = empList.stream()
//                .map(Employee::getName)
//                .collect(Collectors.toCollection(Vector::new));

        // assert(empNames.size(), 3);
    }


    public void whenApplySummarizing_thenGetBasicStats() {
//        DoubleSummaryStatistics stats = empList.stream()
//                .collect(Collectors.summarizingDouble(Employee::getSalary));

        // assert(stats.getCount(), 3);
        // assert(stats.getSum(), 600000.0, 0);
        // assert(stats.getMin(), 100000.0, 0);
        // assert(stats.getMax(), 300000.0, 0);
        // assert(stats.getAverage(), 200000.0, 0);
    }


    public void whenApplySummaryStatistics_thenGetBasicStats() {
//        DoubleSummaryStatistics stats = empList.stream()
//                .mapToDouble(Employee::getSalary)
//                .summaryStatistics();

        // assert(stats.getCount(), 3);
        // assert(stats.getSum(), 600000.0, 0);
        // assert(stats.getMin(), 100000.0, 0);
        // assert(stats.getMax(), 300000.0, 0);
        // assert(stats.getAverage(), 200000.0, 0);
    }


    public void whenStreamPartition_thenGetMap() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
        Map<Boolean, List<Integer>> isEven = intList.stream().collect(
                Collectors.partitioningBy(i -> i % 2 == 0));

        // assert(isEven.get(true).size(), 4);
        // assert(isEven.get(false).size(), 1);
    }


    public void whenStreamGroupingBy_thenGetMap() {
//        Map<Character, List<Employee>> groupByAlphabet = empList.stream().collect(
//                Collectors.groupingBy(e -> new Character(e.getName().charAt(0))));
//
//        // assert(groupByAlphabet.get('B').get(0).getName(), "Bill Gates");
        // assert(groupByAlphabet.get('J').get(0).getName(), "Jeff Bezos");
        // assert(groupByAlphabet.get('M').get(0).getName(), "Mark Zuckerberg");
    }


    public void whenStreamMapping_thenGetMap() {
//        Map<Character, List<Integer>> idGroupedByAlphabet = empList.stream().collect(
//                Collectors.groupingBy(e -> new Character(e.getName().charAt(0)),
//                        Collectors.mapping(Employee::getId, Collectors.toList())));

        // assert(idGroupedByAlphabet.get('B').get(0), new Integer(2));
        // assert(idGroupedByAlphabet.get('J').get(0), new Integer(1));
        // assert(idGroupedByAlphabet.get('M').get(0), new Integer(3));
    }

    /**
     public void whenStreamReducing_thenGetValue() {
     Double percentage = 10.0;
     Double salIncrOverhead = empList.stream().collect(Collectors.reducing(
     0.0, e -> e.getSalary() * percentage / 100, (s1, s2) -> s1 + s2));

     // assert(salIncrOverhead, 60000.0, 0);
     }


     public void whenStreamGroupingAndReducing_thenGetMap() {
     Comparator<Employee> byNameLength = Comparator.comparing(Employee::getName);

     Map<Character, Optional<Employee>> longestNameByAlphabet = empList.stream().collect(
     Collectors.groupingBy(e -> new Character(e.getName().charAt(0)),
     Collectors.reducing(BinaryOperator.maxBy(byNameLength))));

     // assert(longestNameByAlphabet.get('B').get().getName(), "Bill Gates");
     // assert(longestNameByAlphabet.get('J').get().getName(), "Jeff Bezos");
     // assert(longestNameByAlphabet.get('M').get().getName(), "Mark Zuckerberg");
     }


     public void whenParallelStream_thenPerformOperationsInParallel() {
     Employee[] arrayOfEmps = {
     new Employee(1, "Jeff Bezos", 100000.0),
     new Employee(2, "Bill Gates", 200000.0),
     new Employee(3, "Mark Zuckerberg", 300000.0)
     };

     List<Employee> empList = Arrays.asList(arrayOfEmps);

     empList.stream().parallel().forEach(e -> e.salaryIncrement(10.0));
     }


     public void whenGenerateStream_thenGetInfiniteStream() {
     Stream.generate(Math::random)
     .limit(5)
     .forEach(System.out::println);
     }


     public void whenIterateStream_thenGetInfiniteStream() {
     Stream<Integer> evenNumStream = Stream.iterate(2, i -> i * 2);

     List<Integer> collect = evenNumStream
     .limit(5)
     .collect(Collectors.toList());

     // assert(collect, Arrays.asList(2, 4, 8, 16, 32));
     }


     public void whenStreamToFile_thenGetFile() throws IOException {
     String[] words = {
     "hello",
     "refer",
     "world",
     "level"
     };

     try (PrintWriter pw = new PrintWriter(
     Files.newBufferedWriter(Paths.get(fileName)))) {
     Stream.of(words).forEach(pw::println);
     }
     }

     private List<String> getPalindrome(Stream<String> stream, int length) {
     return stream.filter(s -> s.length() == length)
     .filter(s -> s.compareToIgnoreCase(
     new StringBuilder(s).reverse().toString()) == 0)
     .collect(Collectors.toList());
     }

     //
     //    public void whenFileToStream_thenGetStream() throws IOException {
     //        whenStreamToFile_thenGetFile();
     //
     //        List<String> str = getPalindrome(Files.lines(Paths.get(fileName)), 5);
     //        // assertThat(str, contains("refer", "level"));
     //    }
     **/
}
||||||| Stash base
=======
package streams;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.Vector;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", 100_000.0),
                new Employee(2, "Bill Gates", 200_000.0),
                new Employee(3, "Mark Zuckerberg", 300_000.0)
        };
        List<Employee> empList = Arrays.asList(arrayOfEmps);
        EmployeeRepository employeeRepository = new EmployeeRepository(empList);
        //whenFilterEmployees_thenGetFilteredStream(employeeRepository);
        //whenStreamToArray_thenGetArray(empList);
        //whenLimitInfiniteStream_thenGetFiniteElements();
        //whenSortStream_thenGetSortedStream(empList);
        whenFindMin_thenGetMinElementFromStream(empList);
//        System.out.println(empList);
//
//        Double tmp = arrayOfEmps[0].getSalary() * 1.1;
//        arrayOfEmps[0].salaryIncrement(.1);

        //empList.stream().forEach(e -> e.salaryIncrement(10.0));
//        empList.forEach(e -> e.salaryIncrement(10.0));
//        System.out.println(empList);

//        Integer[] empIds = {1, 99, 3};
//        var employees = Stream.of(empIds)
//                .map(employeeRepository::findById)
//                .toList();
//        System.out.println(employees);
//
//        Stream.Builder<Employee> empStreamBuilder = Stream.builder();
//
//        empStreamBuilder.accept(arrayOfEmps[0]);
//        empStreamBuilder.accept(arrayOfEmps[1]);
//        empStreamBuilder.accept(arrayOfEmps[2]);
//        Stream<Employee> empStream = empStreamBuilder.build();

//        List<List<String>> namesNested = Arrays.asList(
//                Arrays.asList("Jeff", "Bezos"),
//                Arrays.asList("Bill", "Gates"),
//                Arrays.asList("Mark", "Zuckerberg"));
//        System.out.println(namesNested);

//        for (var x : namesNested) {
//            System.out.println(x);
//        }

//        List<String> namesFlatStream = namesNested.stream()
//                .parallel()
//                .flatMap(Collection::stream)
//                .toList();
//        System.out.println(namesFlatStream);
    }

    public static void whenFilterEmployees_thenGetFilteredStream(EmployeeRepository employeeRepository) {
        Integer[] empIds = {1, 99, 3, 2};

        List<Employee> employees = Stream.of(empIds)
                .map(employeeRepository::findById)
                .filter(Objects::nonNull)
                .filter(e -> e.getSalary() > 200_000)
                .toList();

        employees.forEach(System.out::println);
    }


    public static void whenStreamToArray_thenGetArray(List<Employee> empList) {
        Employee[] employees = empList.toArray(Employee[]::new);
        System.out.println(Arrays.toString(employees));
    }


    public static void whenStreamCount_thenGetElementCount(List<Employee> empList) {
        Long empCount = empList.stream()
                .filter(e -> e.getSalary() > 200_000)
                .count();
        System.out.println(empCount);
    }

    public static void whenLimitInfiniteStream_thenGetFiniteElements() {
        Stream<BigInteger> infiniteStream = Stream.iterate(BigInteger.TWO, i -> i.multiply(BigInteger.TWO));

        List<BigInteger> result = infiniteStream
                .skip(99)
                .limit(5)
                .toList();
        System.out.println(result);
    }


    public static void whenSortStream_thenGetSortedStream(List<Employee> empList) {
        List<Employee> employees = empList.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .toList();
        System.out.println(employees);
    }


    public static void whenFindMin_thenGetMinElementFromStream(List<Employee> empList) {
        //…empList = List.of();
        var firstEmp = empList.stream()
                .min((e1, e2) -> e1.getId() - e2.getId());

                //.orElseThrow(NoSuchElementException::new);
        System.out.println(firstEmp.isPresent());
    }


    public void whenFindMax_thenGetMaxElementFromStream() {
//        Employee maxSalEmp = empList.stream()
//                .max(Comparator.comparing(Employee::getSalary))
//                .orElseThrow(NoSuchElementException::new);
//
//        // assert(maxSalEmp.getSalary(), new Double(300000.0));
    }


    public void whenApplyDistinct_thenRemoveDuplicatesFromStream() {
        List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
        List<Integer> distinctIntList = intList.stream().distinct().collect(Collectors.toList());

        // assert(distinctIntList, Arrays.asList(2, 5, 3, 4));
    }


    public void whenApplyMatch_thenReturnBoolean() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);

        boolean allEven = intList.stream().allMatch(i -> i % 2 == 0);
        boolean oneEven = intList.stream().anyMatch(i -> i % 2 == 0);
        boolean noneMultipleOfThree = intList.stream().noneMatch(i -> i % 3 == 0);

        // assert(allEven, false);
        // assert(oneEven, true);
        // assert(noneMultipleOfThree, false);
    }


    public void whenFindMaxOnIntStream_thenGetMaxInteger() {
//        Integer latestEmpId = empList.stream()
//                .mapToInt(Employee::getId)
//                .max()
//                .orElseThrow(NoSuchElementException::new);

        // assert(latestEmpId, new Integer(3));
    }


    public void whenApplySumOnIntStream_thenGetSum() {
//        Double avgSal = empList.stream()
//                .mapToDouble(Employee::getSalary)
//                .average()
//                .orElseThrow(NoSuchElementException::new);

        // assert(avgSal, new Double(200000));
    }


    public void whenApplyReduceOnStream_thenGetValue() {
//        Double sumSal = empList.stream()
//                .map(Employee::getSalary)
//                .reduce(0.0, Double::sum);

        // assert(sumSal, new Double(600000));
    }


    public void whenCollectByJoining_thenGetJoinedString() {
//        String empNames = empList.stream()
//                .map(Employee::getName)
//                .collect(Collectors.joining(", "))
//                .toString();

        // assert(empNames, "Jeff Bezos, Bill Gates, Mark Zuckerberg");
    }


    public void whenCollectBySet_thenGetSet() {
//        Set<String> empNames = empList.stream()
//                .map(Employee::getName)
//                .collect(Collectors.toSet());

        // assert(empNames.size(), 3);
    }


    public void whenToVectorCollection_thenGetVector() {
//        Vector<String> empNames = empList.stream()
//                .map(Employee::getName)
//                .collect(Collectors.toCollection(Vector::new));

        // assert(empNames.size(), 3);
    }


    public void whenApplySummarizing_thenGetBasicStats() {
//        DoubleSummaryStatistics stats = empList.stream()
//                .collect(Collectors.summarizingDouble(Employee::getSalary));

        // assert(stats.getCount(), 3);
        // assert(stats.getSum(), 600000.0, 0);
        // assert(stats.getMin(), 100000.0, 0);
        // assert(stats.getMax(), 300000.0, 0);
        // assert(stats.getAverage(), 200000.0, 0);
    }


    public void whenApplySummaryStatistics_thenGetBasicStats() {
//        DoubleSummaryStatistics stats = empList.stream()
//                .mapToDouble(Employee::getSalary)
//                .summaryStatistics();

        // assert(stats.getCount(), 3);
        // assert(stats.getSum(), 600000.0, 0);
        // assert(stats.getMin(), 100000.0, 0);
        // assert(stats.getMax(), 300000.0, 0);
        // assert(stats.getAverage(), 200000.0, 0);
    }


    public void whenStreamPartition_thenGetMap() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
        Map<Boolean, List<Integer>> isEven = intList.stream().collect(
                Collectors.partitioningBy(i -> i % 2 == 0));

        // assert(isEven.get(true).size(), 4);
        // assert(isEven.get(false).size(), 1);
    }


    public void whenStreamGroupingBy_thenGetMap() {
//        Map<Character, List<Employee>> groupByAlphabet = empList.stream().collect(
//                Collectors.groupingBy(e -> new Character(e.getName().charAt(0))));
//
//        // assert(groupByAlphabet.get('B').get(0).getName(), "Bill Gates");
        // assert(groupByAlphabet.get('J').get(0).getName(), "Jeff Bezos");
        // assert(groupByAlphabet.get('M').get(0).getName(), "Mark Zuckerberg");
    }


    public void whenStreamMapping_thenGetMap() {
//        Map<Character, List<Integer>> idGroupedByAlphabet = empList.stream().collect(
//                Collectors.groupingBy(e -> new Character(e.getName().charAt(0)),
//                        Collectors.mapping(Employee::getId, Collectors.toList())));

        // assert(idGroupedByAlphabet.get('B').get(0), new Integer(2));
        // assert(idGroupedByAlphabet.get('J').get(0), new Integer(1));
        // assert(idGroupedByAlphabet.get('M').get(0), new Integer(3));
    }

    /**
     public void whenStreamReducing_thenGetValue() {
     Double percentage = 10.0;
     Double salIncrOverhead = empList.stream().collect(Collectors.reducing(
     0.0, e -> e.getSalary() * percentage / 100, (s1, s2) -> s1 + s2));

     // assert(salIncrOverhead, 60000.0, 0);
     }


     public void whenStreamGroupingAndReducing_thenGetMap() {
     Comparator<Employee> byNameLength = Comparator.comparing(Employee::getName);

     Map<Character, Optional<Employee>> longestNameByAlphabet = empList.stream().collect(
     Collectors.groupingBy(e -> new Character(e.getName().charAt(0)),
     Collectors.reducing(BinaryOperator.maxBy(byNameLength))));

     // assert(longestNameByAlphabet.get('B').get().getName(), "Bill Gates");
     // assert(longestNameByAlphabet.get('J').get().getName(), "Jeff Bezos");
     // assert(longestNameByAlphabet.get('M').get().getName(), "Mark Zuckerberg");
     }


     public void whenParallelStream_thenPerformOperationsInParallel() {
     Employee[] arrayOfEmps = {
     new Employee(1, "Jeff Bezos", 100000.0),
     new Employee(2, "Bill Gates", 200000.0),
     new Employee(3, "Mark Zuckerberg", 300000.0)
     };

     List<Employee> empList = Arrays.asList(arrayOfEmps);

     empList.stream().parallel().forEach(e -> e.salaryIncrement(10.0));
     }


     public void whenGenerateStream_thenGetInfiniteStream() {
     Stream.generate(Math::random)
     .limit(5)
     .forEach(System.out::println);
     }


     public void whenIterateStream_thenGetInfiniteStream() {
     Stream<Integer> evenNumStream = Stream.iterate(2, i -> i * 2);

     List<Integer> collect = evenNumStream
     .limit(5)
     .collect(Collectors.toList());

     // assert(collect, Arrays.asList(2, 4, 8, 16, 32));
     }


     public void whenStreamToFile_thenGetFile() throws IOException {
     String[] words = {
     "hello",
     "refer",
     "world",
     "level"
     };

     try (PrintWriter pw = new PrintWriter(
     Files.newBufferedWriter(Paths.get(fileName)))) {
     Stream.of(words).forEach(pw::println);
     }
     }

     private List<String> getPalindrome(Stream<String> stream, int length) {
     return stream.filter(s -> s.length() == length)
     .filter(s -> s.compareToIgnoreCase(
     new StringBuilder(s).reverse().toString()) == 0)
     .collect(Collectors.toList());
     }

     //
     //    public void whenFileToStream_thenGetStream() throws IOException {
     //        whenStreamToFile_thenGetFile();
     //
     //        List<String> str = getPalindrome(Files.lines(Paths.get(fileName)), 5);
     //        // assertThat(str, contains("refer", "level"));
     //    }
     **/
}
>>>>>>> Stashed changes
