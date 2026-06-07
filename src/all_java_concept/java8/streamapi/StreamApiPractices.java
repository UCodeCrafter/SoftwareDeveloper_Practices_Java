package all_java_concept.java8.streamapi;

import java.util.*;
import java.util.stream.Stream;
//https://medium.com/@asishpanda444/stream-api-coding-qna-8df8682b7e2a

public class StreamApiPractices {
    public static void main(String[] args){

        filterEvenNumbers();


        findMaximumInList();

        sortAList();

        countStringsWithCharA();

        findFirstNonRepeatedCharacterInAString();

        convertListofStringsToUppercase();
    }

    private static void convertListofStringsToUppercase() {
        List<String> list = Arrays.asList("java", "Spring", "Python");
        System.out.println(
                "\nConverted to upper case: "
        );
        list.stream().map(e->e.toUpperCase(Locale.ROOT)).forEach(
                e->System.out.print(e+" ")
        );
    }

    private static void findFirstNonRepeatedCharacterInAString() {
        String str = "UUttamModi";

        Optional<Character> ans =  str.chars()
                .mapToObj(e->(char) e)
                .filter(
                        e -> str.indexOf(e) == str.lastIndexOf(e)
                ).findFirst();

        System.out.println("Non-Repeating char from give string is: "+ ans.orElse(null));
    }

    private static void countStringsWithCharA() {
        List<String> list = Arrays.asList("Akash", "Anil", "Bikas", "Amol", "Chanda", "Ram");
        System.out.println("\nStrings starts with A : ");
        list.stream().filter(e->e.startsWith("A")).forEach(e->System.out.print(e+" "));

    }

    private static void sortAList() {
        List<Integer> list = Arrays.asList(12,34,65,8,5,34,90,32,2);
        System.out.println("Sorted Array Ascending Order: ");
        list.stream().sorted().forEach(e->System.out.print(e+" "));

        List<Integer> list2 = Arrays.asList(12,34,65,8,5,34,90,32,2);
        System.out.println("\nSorted Array Descending Order: ");
        list2.stream().sorted(Comparator.reverseOrder()).forEach(e->System.out.print(e+" "));
    }

    private static void findMaximumInList() {
        System.out.println("\n2. Find Maximum in a List");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<?> answer = list.stream().max(Integer::compare);
        answer.ifPresent(System.out::println);
    }

    private static void filterEvenNumbers() {
        System.out.println("1. Filter Even Numbers from a List");
        Stream.of(1,2,3,4,5,6,7,8,9,10)
                .filter(num -> num % 2 == 0)
                .forEach(e-> System.out.print(e+" ") );}

}
