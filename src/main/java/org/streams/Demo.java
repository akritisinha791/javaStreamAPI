package org.streams;

import com.sun.source.doctree.EscapeTree;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args){

//        List<Integer> nums = Arrays.asList(4,5,7,8,9);
//
//        nums.stream().map(n -> n*2).forEach(n -> System.out.println(n));

//        nums.forEach(n -> System.out.println(n));

        //StreamAPI
        List<String> inpList = Arrays.asList("apple", "banana", "avocado", "aam", "litchi" , "kiwi", "applePie");
        List<List<Integer>> nested = Arrays.asList(Arrays.asList(7,8) , Arrays.asList(11,2), Arrays.asList(4,6),
                Arrays.asList(150,68), Arrays.asList(75, 55), Arrays.asList(7,77),
                Arrays.asList(68,58), Arrays.asList(46,6));

        // Intermidiate Operations
        // filter()
//        List<String> inpList = Arrays.asList("apple", "banana", "avocado", "aam", "litchi");
//        List<String> res = inpList.stream().filter(s -> s.startsWith("a")).collect(Collectors.toList());
//        System.out.println(res);

        // map() Convert all strings to uppercase.
//        List<String> res = inpList.stream()
//                .map(String::toUpperCase).collect(Collectors.toList());

        // flatMap() Flatten a list of lists.
        // sorted(), distinct()
        // peek(): to look in between the transitions, just like console
        // limit() limit the number of the output
        // skip(n) skip the first n elements
//        List<Integer> res = nested.stream()
//                .flatMap(List::stream).sorted()
////                .peek(s -> System.out.print("After Sorting: "+ s))
//                .distinct()
////                .limit(5)
////                .skip(4)
//                .collect(Collectors.toList());

//        Terminal operators
        //count() - return long
//        long res = inpList.stream().count();
        // anyMatch() / allMatch() / noneMatch() -returns boolean
//        boolean anyMatch = inpList.stream()
//                        .anyMatch(s -> s.startsWith("a"));
//        boolean allMatch = nested.stream()
//                .flatMap(Collection::stream)
//                .allMatch(n -> n>0);
//        boolean noneMatch = inpList.stream()
//                .noneMatch(s -> s.startsWith("b"));



//        System.out.println(res);
//        System.out.println("Any Match:" +anyMatch);
//        System.out.println("All Match:" +allMatch);
//        System.out.println("None Match:" +noneMatch);

        // min()/max() - use Optional- container object  to avoid null checks
//        Optional<Integer> min = nested.stream().flatMap(Collection::stream)
//                .min(Integer::compareTo);
//        System.out.println("Min: " +min.get());
//
//        Optional<Integer> max = nested.stream().flatMap(Collection::stream)
//                .max(Integer::compareTo);
//        System.out.println("Max: " +max.get());

        //findFirst() - find the first occurance of element may be after filter
        //findAny() - find any occurance f the element -maybe after filter
        // returns Optional<T>
//        Optional<String> first = inpList.stream()
//                .filter(s -> s.startsWith("a"))
//                .findFirst();
//        first.ifPresentOrElse(System.out::println,() -> System.out.println("nothing matching for find first"));
//
//        Optional<String> any = inpList.parallelStream()
//                .filter(s -> s.startsWith("a"))
//                .findAny();
//        any.ifPresentOrElse(System.out::println, () -> System.out.println("nothing matching for find any"));

        //dropWhile() -java9 - drops the value till the condition is true
        //the checking/ dropping stops once the first false occurrence found

//        List<Integer> res = nested.stream()
//                .flatMap(List::stream)
//                .peek(System.out::println)
//                .dropWhile(n -> n<11)
//                .collect(Collectors.toList());


        //takeWhile()-  java 9- take elements till the condition is true
        // stops as soon as it gets the first false condition
        // the peek will display elements till the condition checking, the takeWhile() stops the stream
//        List<Integer> res = nested.stream()
//                .flatMap(List:: stream)
//                .peek(System.out::println)
//                .takeWhile(n -> n<68)
//                .collect(Collectors.toList());

        //mapMulti() - Java 16  - better alternative to .map
        // can mao 1 i/p to multi output
        //syntax like lambda function. need 2 param/argument
//
//        List<Integer> res = nested.stream().
//                flatMap(List::stream)
//                .sorted()
//                .<Integer>mapMulti((n, consumer) -> {
//                    consumer.accept(n);
//                    consumer.accept(n * 10);
//                    consumer.accept(n*100);
//                })
//                .sorted()
//                .collect(Collectors.toList());

        //onClose() - returns a stream . use the stream for terminal function. can use other intermediate functions
        // call stream.close(); again to get the nClose task done.

//        Stream<Integer> stream = nested.stream().flatMap(List::stream)
//                        .onClose(() -> System.out.println("stream closed"))
//                .filter(n -> n%2==0);
//        stream.forEach(System.out::println);
//
//        stream.close();

        // parallel() - convert to ||r for multithreading purposes. cpu intensive op
        // gives o/p in any order
        // sequential()
        // unordered() - to inform jvm that order does not matter. good for ||r stream

//       nested.stream().flatMap(Collection::stream)
//                .distinct()
////                .parallel()
////               .sequential()
//               .unordered()
//                .forEach(System.out::println);
        // no need to use sorted after parallel, no meaning
        // no need to use .parallel().sequential() , no meaning, redundant
//        System.out.println(res);

        //isParallel() - return boolean, check if stream s parallel
//        boolean par = inpList.stream().parallel().isParallel();
//        System.out.println(par);

        //iterator() returns Iteator
//        Iterator<Integer> it = nested.stream().flatMap(Collection::stream).iterator();
//int sum = 0;
//while(it.hasNext()){
//    int n = it.next();
//    sum+=n;
//        }
//        System.out.println("sum="+sum);

        //spliterator() -returns Spliterator, has object methods good for ||r stream


//        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
//
//        Spliterator<Integer> sp1 = list.stream().spliterator();
//        Spliterator<Integer> sp2 = sp1.trySplit(); // split into two
//
//        System.out.println("First half:");
//        sp1.forEachRemaining(System.out::println);
//
//        System.out.println("Second half:");
//        sp2.forEachRemaining(System.out::println);
//
//        int ch = sp1.characteristics();
//        System.out.println(ch);

        // forEach()- returns void, for each element, takes consumers that can be modified

//        inpList.stream().map(String::toUpperCase)
//                .forEach(System.out::println);
//
//        Consumer<String> upper = s ->System.out.println(s.toUpperCase());
//        Consumer<String> length = s ->System.out.println("Length: " +s.length());

        // reduce() 3 types, give 1 result not stream

        Optional<Integer> reduce1 = nested.stream().flatMap(List::stream)
                .reduce((a,b) -> a+b);
reduce1.ifPresent(System.out::println);

int reduce2 = nested.stream().flatMap(List::stream)
        .reduce(1, (a,b) -> a*b);
        System.out.println(reduce2);

        int reduce3 = inpList.stream()
                .reduce(0,(len, reduce3element)-> len+reduce3element.length(),Integer::sum);
        System.out.println(reduce3);


    }
}
