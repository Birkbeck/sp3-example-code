static void main() {
//    List<Integer> ages = Arrays.asList(20,25,30);
//
//    int totalAge = ages.stream()
//            //.mapToInt(Integer::intValue)
//            //.sum()
//            .reduce(0, Integer::sum);
//    System.out.printf("Total age: %d%n", totalAge);

    var langs = Arrays.asList("Java", "JavaScript", "Python",
            "C++", "Ruby", "Julia");
    final long NUMBEROFCHARS = 4L;
    // print out the number of languages more than four characters

    var l = langs.stream()
            .filter(s -> s.length() > NUMBEROFCHARS);
            //.count();
    System.out.println(l.getClass());
    long result = l.count();
    System.out.println(result);
    result = l.count();
    System.out.println(result);
}

