package org.yeahicode;

import org.yeahicode.entity.Author;
import org.yeahicode.entity.Book;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamNewDemo {

    public static void main(String[] args) {
//        test01();
//        test02();
//        test03();
//        test04();
//        test05();
//        test06();
//        test07();
//        test08();
//        test09();
//        test10();
//        test11();
//        test12();
//        test13();
//        test14();
//        test15();
//        test16();
//        test17();
//        test18();
//        test19();
//        test20();
//        test21();
//        test22();
//        test23();
//        test24();
//        test25();
//        test26();
//        test27();
//        test28();
//        test29();
//        test30();
//        test31();
//        test32();
//        test33();
//        test34();
//        test35();
//        test36();
//        test37();
        test38();
    }

    private static void test38() {
        List<Author> authors = getAuthors();
        authors.parallelStream()
                .peek(new Consumer<Author>() {
                    @Override
                    public void accept(Author author) {
                        System.out.println(Thread.currentThread().getName() + " >>> " + author);
                    }
                }).forEach(System.out::println);
    }

    private static void test37() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(
                integerStream.parallel().peek(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        System.out.println(String.format("%s >>> %s", String.valueOf(integer), Thread.currentThread().getName()));
                    }
                }).reduce((result, ele) -> result + ele).get());
    }

    private static void test36() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(
                integerStream.peek(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        System.out.println(String.format("%s >>> %s", String.valueOf(integer), Thread.currentThread().getName()));
                    }
                }).reduce((result, ele) -> result + ele).get());
    }

    private static void test35() {
        List<Author> authors = getAuthors();
        authors.stream()
                // 将流中的数据类型转换成基本数据类型
                .mapToInt(author -> author.getAge())
                // 此后的流操作就统一使用基本数据，避免拆箱装箱产生的损耗
                .map(age -> age + 10)
                .filter(age -> age > 18)
                .map(age -> age + 2)
                .forEach(System.out::println);
    }

    private static void test34() {
        List<Author> authors = getAuthors();
        authors.stream()
                .map(new Function<Author, Integer>() {
                    @Override
                    public Integer apply(Author author) {
                        return author.getAge();
                    }
                })
                // 此时转换成了Integer
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer age) {
                        // 先拆箱，后装箱
                        return age + 10;
                    }
                })
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer age) {
                        // 这里又拆箱
                        return age > 18;
                    }
                })
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer age) {
                        // 先拆箱，后装箱
                        return age + 2;
                    }
                })
                .forEach(System.out::println);
    }

    private static void test33() {
        List<Author> authors = getAuthors();
        StringBuilder sb = new StringBuilder();
        authors.stream().map(x -> x.getName()).forEach(sb::append);
    }

    private static void test32() {
        List<Author> authors = getAuthors();
        authors.stream().map(x -> x.getAge()).map(String::valueOf).forEach(System.out::println);
    }

    private static void test31() {
        List<Author> authors = getAuthors();
        authors.stream()
                .filter(
                        ((Predicate<Author>) author -> author.getAge() > 17).negate()
                ).forEach(System.out::println);
    }

    private static void test30() {
        List<Author> authors = getAuthors();
        authors.stream()
                .filter(
                        ((Predicate<Author>) author -> author.getAge() > 17).or(author -> author.getName().length() < 2)
                ).forEach(System.out::println);
    }

    private static void test29() {
        List<Author> authors = getAuthors();
        authors.stream()
                .filter(
                        ((Predicate<Author>) author -> author.getAge() > 17).and(author -> author.getName().length() > 1)
                ).forEach(System.out::println);
    }

    private static Author getAuthor() {
        Author author = new Author();
        author.setId(888l);
        author.setName("刘刘刘");
        author.setAge(20);
        return null;
    }

    private static void test28() {
        Author author = getAuthor();
        Optional<Author> author1 = Optional.ofNullable(author);
        Optional<List<Book>> books = author1.map(author2 -> author2.getBooks());
        books.ifPresent(x -> System.out.println(books));
    }

    private static void test27() {
        Optional<Author> author = Optional.ofNullable(getAuthor());
        if (author.isPresent()) {
            System.out.println("有数据");
        } else {
            System.out.println("无数据");
        }
    }

    private static void test26() {
        Optional<Author> author = Optional.ofNullable(getAuthor());
        Optional<Author> authorOptional = author.filter(author1 -> author1.getAge() > 88);
        System.out.println(authorOptional.orElse(new Author()));
    }

    private static void test25() throws Throwable {
        Author author = getAuthor();
        Optional<Author> authorOptional = Optional.ofNullable(author);
//        Optional<Author> authorOptional = Optional.of(null);
//        Optional<Object> empty = Optional.empty();
//        Author author1 = authorOptional.get();
//        Author author1 = authorOptional.orElseGet(() -> new Author());
        Author author1 = authorOptional.orElseThrow((Supplier<Throwable>) () -> new RuntimeException("aaa"));
    }

    private static void test24() {
        List<Author> authors = getAuthors();
        authors.stream()
                .map(new Function<Author, Author>() {
                    @Override
                    public Author apply(Author author) {
                        author.setAge(author.getAge() + 10);
                        return author;
                    }
                }).forEach(System.out::println);
    }

    private static void test23() {
        List<Author> authors = getAuthors();
        authors.stream()
                .map(x -> x.getAge())
                .map(age -> age + 10)
                .forEach(System.out::println);
        System.out.println(authors);
    }

    private static void test22() {
        List<Author> authors = getAuthors();
        Optional<Integer> max = authors.stream()
                .map(Author::getAge)
                .reduce((result, element) -> result < element ? element : result);
        max.ifPresent(System.out::println);
    }

    private static void test21() {
        List<Author> authors = getAuthors();
        Integer result = authors.stream()
                .map(Author::getAge)
                .reduce(0, (result1, element) -> result1 + element);
        System.out.println(result);
    }

    private static void test20() {
        List<Author> authors = getAuthors();
        Optional<Author> first = authors.stream()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .findFirst();
        System.out.println(first.get());
    }

    private static void test19() {
        List<Author> authors = getAuthors();
        Optional<Author> any = authors.stream()
                .filter(x -> x.getAge() > 18)
                .findAny();
        any.ifPresent(x -> System.out.println(x.getName()));
    }

    private static void test18() {
        List<Author> authors = getAuthors();
        boolean match = authors.stream()
                .allMatch(author -> author.getAge() < 100);
        System.out.println(match == true ? "都小于100岁" : "有大于100岁的");
    }

    private static void test17() {
        List<Author> authors = getAuthors();
        boolean match = authors.stream()
                .anyMatch(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge() > 29;
                    }
                });
        System.out.println(match == true ? "有" : "没有");
    }

    private static void test16() {
        List<Author> authors = getAuthors();
        Map<String, Object> map = authors.stream()
                .distinct()
                .collect(Collectors.toMap(new Function<Author, String>() {
                    @Override
                    public String apply(Author author) {
                        return author.getName();
                    }
                }, new Function<Author, Object>() {
                    @Override
                    public List<Book> apply(Author author) {
                        return author.getBooks();
                    }
                }));
        System.out.println(map);
    }

    private static void test15() {
        List<Author> authors = getAuthors();
        Set<String> set = authors.stream()
                .flatMap(x -> x.getBooks().stream())
                .map(x -> x.getName())
                .collect(Collectors.toSet());
        System.out.println(set);
    }

    private static void test14() {
        List<Author> authors = getAuthors();
        List<String> list = authors.stream()
                .map(x -> x.getName())
                .collect(Collectors.toList());
        System.out.println(list);
    }

    private static void test13() {
        List<Author> authors = getAuthors();
        Optional<Integer> max = authors.stream()
                .flatMap(x -> x.getBooks().stream())
                .map(x -> x.getScore())
                .max((x1, x2) -> x1 - x2);
        System.out.println(max.get());
    }

    private static void test12() {
        List<Author> authors = getAuthors();
        long count = authors.stream()
                .flatMap(x -> x.getBooks().stream())
                .distinct()
                .count();
        System.out.println(count);
    }

    private static void test11() {
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(x -> x.getBooks().stream())
                .flatMap(x -> Arrays.stream(x.getCategory().split(",")))
                .distinct()
                .forEach(System.out::println);
    }

    private static void test10() {
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(x -> x.getBooks().stream())
                .distinct()
                .forEach(x -> System.out.println(x.getName()));

    }

    private static void test09() {
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(x -> x.getBooks().stream())
                .forEach(System.out::println);
    }

    private static void test08() {
        List<Author> authors = getAuthors();
        authors.stream()
                .map(new Function<Author, List<Book>>() {
                    @Override
                    public List<Book> apply(Author author) {
                        return author.getBooks();
                    }
                })
                .forEach(System.out::println);
    }

    private static void test07() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .skip(1l)
                .forEach(System.out::println);
    }

    private static void test06() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .limit(2)
                .forEach(x -> System.out.println(x.getName()));
    }

    private static void test05() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .forEach(System.out::println);
    }

    private static void test04() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .forEach(x -> System.out.println(x.getName()));
    }

    private static void test03() {
        List<Author> authors = getAuthors();
        authors.stream()
                .map(x -> x.getName())
                .forEach(System.out::println);
    }

    private static void test02() {
        List<Author> authors = getAuthors();
        authors.stream()
                .filter(x -> x.getName().length() > 1)
                .forEach(System.out::println);
    }

    private static void test01() {
        List<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();

        Integer[] arr = {1, 2, 3, 4, 5,};
        Stream<Integer> stream1 = Arrays.stream(arr);
        Stream<Integer> Stream2 = Stream.of(arr);

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        Stream<Map.Entry<String, Integer>> stream3 = map.entrySet().stream();
    }

    private static List<Author> getAuthors() {
        //数据初始化
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        Author author2 = new Author(2L, "亚拉索", 15, "狂风也追逐不上他的思考速度", null);
        Author author3 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);
        Author author4 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);

        //书籍列表
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学,爱情", 88, "用一把刀划分了爱恨"));
        books1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长,爱情", 99, "讲述如何从失败中明悟真理"));

        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(4L, "吹或不吹", "爱情,个人传记", 56, "一个哲学家的恋爱观注定很难把他所在的时代理解"));

        books3.add(new Book(5L, "你的剑就是我的剑", "爱情", 56, "无法想象一个武者能对他的伴侣这么的宽容"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));

        author.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author, author2, author3, author4));
        return authorList;
    }
}
