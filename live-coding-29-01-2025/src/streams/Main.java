package streams;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        Employee[] arrayOfEmps = {new Employee(1, "Jeff Bezos", 100000.0), new Employee(2, "Bill Gates", 200000.0), new Employee(3, "Mark Zuckerberg", 300000.0)};

        List<Employee> empList = Arrays.asList(arrayOfEmps);
        EmployeeRepository employeeRepository = new EmployeeRepository(empList);

        whenParallelStream_thenPerformOperationsInParallel(arrayOfEmps);
        whenGenerateStream_thenGetInfiniteStream();
        whenIterateStream_thenGetInfiniteStream();
        whenGetStreamFromList_ObtainStream(empList);
        whenGetStreamFromArray_ObtainStream(arrayOfEmps);
        whenGetStreamFromElements_ObtainStream(arrayOfEmps);
        whenBuildStreamFromElements_ObtainStream(arrayOfEmps);
        whenIncrementSalaryForEachEmployee_thenApplyNewSalary(arrayOfEmps);
        whenMapIdToEmployees_thenGetEmployeeStream(employeeRepository);
        whenFlatMapEmployeeNames_thenGetNameStream();
        whenFilterEmployees_thenGetFilteredStream(employeeRepository,arrayOfEmps);
        whenFindFirst_thenGetFirstEmployeeInStream(employeeRepository);
        whenStreamCount_thenGetElementCount(empList);
        whenLimitInfiniteStream_thenGetFiniteElements();
        whenSortStream_thenGetSortedStream(empList);
        whenFindMin_thenGetMinElementFromStream(empList);
        whenApplyDistinct_thenRemoveDuplicatesFromStream();
        whenApplyMatch_thenReturnBoolean();
        whenFindMaxOnIntStream_thenGetMaxInteger(empList);
        whenApplySumOnIntStream_thenGetSum(empList);
        whenFindMax_thenGetMaxElementFromStream(empList);
        whenApplyReduceOnStream_thenGetValue(empList);
        whenCollectByJoining_thenGetJoinedString(empList);
        whenCollectBySet_thenGetSet(empList);
        whenToVectorCollection_thenGetVector(empList);
        whenApplySummarizing_thenGetBasicStats(empList);
        whenApplySummaryStatistics_thenGetBasicStats(empList);
        whenStreamPartition_thenGetMap();
        whenStreamGroupingBy_thenGetMap(empList);
        whenStreamReducing_thenGetValue(empList);
        whenStreamGroupingAndReducing_thenGetMap(empList);
    }

    static void whenParallelStream_thenPerformOperationsInParallel(Employee[] arrayOfEmps) {
        List<Employee> empList = Arrays.asList(arrayOfEmps);

        empList.stream().parallel().forEach(e -> e.salaryIncrement(10.0));
        System.out.println(empList);
    }

    static void whenGenerateStream_thenGetInfiniteStream() {
        Stream.generate(Math::random).limit(5).forEach(System.out::println);
    }

    static void whenIterateStream_thenGetInfiniteStream() {
        Stream<Integer> evenNumStream = Stream.iterate(2, i -> i * 2);

        List<Integer> collect = evenNumStream.limit(5).toList();

        assert (collect.equals(Arrays.asList(2, 4, 8, 16, 32)));
    }

    static void whenGetStreamFromList_ObtainStream(List<Employee> empList) {
        assert (empList.stream() instanceof Stream<?>);
    }

    static void whenGetStreamFromArray_ObtainStream(Employee[] arrayOfEmps) {
        assert (Stream.of(arrayOfEmps) instanceof Stream<?>);
    }

    static void whenGetStreamFromElements_ObtainStream(Employee[] arrayOfEmps) {
        assert (Stream.of(arrayOfEmps[0], arrayOfEmps[1], arrayOfEmps[2]) instanceof Stream<?>);
    }

    static void whenBuildStreamFromElements_ObtainStream(Employee[] arrayOfEmps) {
        Stream.Builder<Employee> empStreamBuilder = Stream.builder();

        empStreamBuilder.accept(arrayOfEmps[0]);
        empStreamBuilder.accept(arrayOfEmps[1]);
        empStreamBuilder.accept(arrayOfEmps[2]);

        Stream<Employee> empStream = empStreamBuilder.build();

        assert (empStream instanceof Stream<?>);
    }

    static void whenIncrementSalaryForEachEmployee_thenApplyNewSalary(Employee[] arrayOfEmps) {
        final double DELTA = 0.0000001;

        List<Employee> empList = Arrays.asList(arrayOfEmps);

        Double tmp = arrayOfEmps[0].getSalary() * 1.1;
        empList.forEach(e -> e.salaryIncrement(10.0));
        double value = Math.abs(tmp - arrayOfEmps[0].getSalary());
        assert (value <= DELTA);
    }

    static void whenMapIdToEmployees_thenGetEmployeeStream(EmployeeRepository employeeRepository) {
        Integer[] empIds = {1, 2, 3};

        List<Employee> employees = Stream.of(empIds).map(employeeRepository::findById).toList();

        assert (empIds.length == employees.size());
    }

    static void whenFlatMapEmployeeNames_thenGetNameStream() {
        List<List<String>> namesNested = Arrays.asList(Arrays.asList("Jeff", "Bezos"), Arrays.asList("Bill", "Gates"), Arrays.asList("Mark", "Zuckerberg"));

        for (var x : namesNested) {
            System.out.println(x);
        }

        List<String> namesFlatStream = namesNested.stream().flatMap(Collection::stream).toList();

        assert (namesNested.size() * 2 == namesFlatStream.size());
    }

    static void whenFilterEmployees_thenGetFilteredStream(EmployeeRepository employeeRepository, Employee[] arrayOfEmps) {
        Integer[] empIds = {1, 2, 3, 4};

        List<Employee> employees = Stream.of(empIds).map(employeeRepository::findById).filter(Objects::nonNull).filter(e -> e.getSalary() > 200_000).toList();

        employees.forEach(System.out::println);

        assert (Collections.singletonList(arrayOfEmps[2]).equals(employees));
    }

    static void whenFindFirst_thenGetFirstEmployeeInStream(EmployeeRepository employeeRepository) {
        Integer[] empIds = {1, 2, 3, 4};
        final Double LIMIT = Double.valueOf(100_000);

        Employee employee = Stream.of(empIds).map(employeeRepository::findById).filter(Objects::nonNull).filter(e -> e.getSalary() > LIMIT).findFirst().orElse(new Employee(10, "Donald", LIMIT));
        System.out.println(employee);
        assert (employee.getSalary() == 200000.0);
    }

    static void whenStreamCount_thenGetElementCount(List<Employee> empList) {
        Long empCount = empList.stream().filter(e -> e.getSalary() > 200_000).count();

        assert (empCount == 1);
    }

    static void whenLimitInfiniteStream_thenGetFiniteElements() {
        Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);

        List<Integer> collect = infiniteStream.skip(3).limit(5).toList();

        assert (collect.equals(Arrays.asList(16, 32, 64, 128, 256)));
    }

    static void whenSortStream_thenGetSortedStream(List<Employee> empList) {
        List<Employee> employees = empList.stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName())).toList();

        assert (employees.get(0).getName().equals("Bill Gates"));
        assert (employees.get(1).getName().equals("Jeff Bezos"));
        assert (employees.get(2).getName().equals("Mark Zuckerberg"));
    }

    static void whenFindMin_thenGetMinElementFromStream(List<Employee> empList) {
        Employee firstEmp = empList.stream().min((e1, e2) -> e1.getId() - e2.getId()).orElseThrow(NoSuchElementException::new);

        assert (firstEmp.getId() == 1);
    }

    static void whenFindMax_thenGetMaxElementFromStream(List<Employee> empList) {
        Employee maxSalEmp = empList.stream().max(Comparator.comparing(Employee::getSalary)).orElseThrow(NoSuchElementException::new);

        assert (maxSalEmp.getSalary() == 300000.0);
    }

    static void whenApplyDistinct_thenRemoveDuplicatesFromStream() {
        List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
        List<Integer> distinctIntList = intList.stream().distinct().toList();

        assert (distinctIntList.equals(Arrays.asList(2, 5, 3, 4)));
    }

    static void whenApplyMatch_thenReturnBoolean() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);

        boolean allEven = intList.stream().allMatch(i -> i % 2 == 0);
        boolean oneEven = intList.stream().anyMatch(i -> i % 2 == 0);
        boolean noneMultipleOfThree = intList.stream().noneMatch(i -> i % 3 == 0);

        assert (!allEven);
        assert (oneEven);
        assert (!noneMultipleOfThree);
    }

    static void whenFindMaxOnIntStream_thenGetMaxInteger(List<Employee> empList) {
        Integer latestEmpId = empList.stream().mapToInt(Employee::getId).max().orElseThrow(NoSuchElementException::new);

        assert (latestEmpId == 3);
    }

    static void whenApplySumOnIntStream_thenGetSum(List<Employee> empList) {
        Double avgSal = empList.stream().mapToDouble(Employee::getSalary).average().orElseThrow(NoSuchElementException::new);

        assert (avgSal == 200_000);
    }

    static void whenApplyReduceOnStream_thenGetValue(List<Employee> empList) {
        Double sumSal = empList.stream().map(Employee::getSalary).reduce(0.0, Double::sum);

        assert (sumSal == 600_000);
    }

    static void whenCollectByJoining_thenGetJoinedString(List<Employee> empList) {
        String empNames = empList.stream().map(Employee::getName).collect(joining(", "));

        assert (empNames.equals("Jeff Bezos, Bill Gates, Mark Zuckerberg"));
    }

    static void whenCollectBySet_thenGetSet(List<Employee> empList) {
        Set<String> empNames = empList.stream().map(Employee::getName).collect(toSet());

        assert (empNames.size() == 3);
    }

    static void whenToVectorCollection_thenGetVector(List<Employee> empList) {
        Vector<String> empNames = empList.stream().map(Employee::getName).collect(toCollection(Vector::new));

        assert (empNames.size() == 3);
    }

    static void whenApplySummarizing_thenGetBasicStats(List<Employee> empList) {
        DoubleSummaryStatistics stats = empList.stream().collect(summarizingDouble(Employee::getSalary));

        assert (stats.getCount() == 3);
        assert (stats.getSum() == 600_000.0);
        assert (stats.getMin() == 100_000.0);
        assert (stats.getMax() == 300_000.0);
        assert (stats.getAverage() == 200_000.0);
    }

    static void whenApplySummaryStatistics_thenGetBasicStats(List<Employee> empList) {
        DoubleSummaryStatistics stats = empList.stream().mapToDouble(Employee::getSalary).summaryStatistics();

        assert (stats.getCount() == 3);
        assert (stats.getSum() == 600_000.0);
        assert (stats.getMin() == 100_000.0);
        assert (stats.getMax() == 300_000.0);
        assert (stats.getAverage() == 200_000.0);
    }

    static void whenStreamPartition_thenGetMap() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
        Map<Boolean, List<Integer>> isEven = intList.stream().collect(partitioningBy(i -> i % 2 == 0));

        assert (isEven.get(true).size() == 4);
        assert (isEven.get(false).size() == 1);
    }

    static void whenStreamGroupingBy_thenGetMap(List<Employee> empList) {
        Map<Character, List<Employee>> groupByAlphabet = empList.stream().collect(groupingBy(e -> e.getName().charAt(0)));

        assert (groupByAlphabet.get('B').get(0).getName().equals("Bill Gates"));
        assert (groupByAlphabet.get('J').get(0).getName().equals("Jeff Bezos"));
        assert (groupByAlphabet.get('M').get(0).getName().equals("Mark Zuckerberg"));
    }

    static void whenStreamReducing_thenGetValue(List<Employee> empList) {
        Double percentage = 10.0;
        Double salIncrOverhead = empList.stream().map(e -> e.getSalary() * percentage / 100).reduce(0.0, (s1, s2) -> s1 + s2);

        assert (salIncrOverhead == 60_000.0);
    }

    static void whenStreamGroupingAndReducing_thenGetMap(List<Employee> empList) {
        Comparator<Employee> byNameLength = Comparator.comparing(Employee::getName);

        Map<Character, Optional<Employee>> longestNameByAlphabet = empList.stream().collect(groupingBy(e -> e.getName().charAt(0), reducing(BinaryOperator.maxBy(byNameLength))));

        assert (longestNameByAlphabet.get('B').get().getName().equals("Bill Gates"));
        assert (longestNameByAlphabet.get('J').get().getName().equals("Jeff Bezos"));
        assert (longestNameByAlphabet.get('M').get().getName().equals("Mark Zuckerberg"));
    }


}