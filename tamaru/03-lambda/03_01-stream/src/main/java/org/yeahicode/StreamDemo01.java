package org.yeahicode;

import org.yeahicode.entity.Author;
import org.yeahicode.entity.Book;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo01 {

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

    public void test01() {
        // 创建流
        List<Author> authors = getAuthors();
        authors.stream() // 将集合转换成流
                .distinct() // 去重复
                .filter(x -> x.getAge() < 18) // 过滤
                .forEach(System.out::println); // 循环打印
    }

    public void test02() {
        // 数组流操作
        int[] arrs = {1, 2, 3, 4, 5};
        Arrays.stream(arrs).forEach(System.out::println);
        // of可以传入可变参数，可变参数底层其实就是数组
        Stream.of(arrs).forEach(System.out::println);
    }

    public void test03() {
        // 双列集合操作
        // 双列集合不能转化成流，得先将双列集合转换成单列集合，然后再进行流操作
        Map<String, Integer> map = new HashMap<>();
        map.put("张三", 18);
        map.put("李四", 20);
        map.put("王五", 16);
        map.entrySet().stream()
                .filter(x -> x.getValue() > 16)
                .forEach(new Consumer<Map.Entry<String, Integer>>() {
                    @Override
                    public void accept(Map.Entry<String, Integer> entrySet) {
                        System.out.println(String.format("key=%s,value=%s", entrySet.getKey(), entrySet.getValue()));
                    }
                });
    }

    public void test04() {
        // 打印所有姓名长度大于1的作家的姓名
        // 中间操作filter
        List<Author> authors = getAuthors();
        authors.stream()
                .filter(x -> x.getName().length() > 1) // 中间操作
                .forEach(System.out::println); // 结束操作
    }

    public void test05() {
        // map是也是流的中间操作的一种，可以对流进行计算和转换
        List<Author> authors = getAuthors();
        authors.stream()
                .map(author -> author.getAge())
                .map(age -> age + 10)
                .forEach(System.out::println);
    }

    public void test06() {
        // distinct去重
        // distinct方法是依赖Object的equals方法来判断是否是相同对象的。所以需要注意重写equals方法
        // 如果不重写自定义对象的equals方法，是没办法进行去重的
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .forEach(System.out::println);
    }

    public void test07() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted(new Comparator<Author>() {
                    @Override
                    public int compare(Author o1, Author o2) {
                        return o1.getAge() - o2.getAge();
                    }
                })
                .forEach(System.out::println);
    }

    public void test08() {
        // 按照年龄进行降序排序，并且不能有重复元素，然后打印年龄最大的两个
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted(((o1, o2) -> o2.getAge() - o1.getAge()))
                .limit(2)
                .forEach(System.out::println);
    }

    public void test09() {
        // skip跳过前几条记录
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted(((o1, o2) -> o2.getAge() - o1.getAge()))
                .skip(1) // 排序后跳过年龄最大的那一条记录
                .forEach(System.out::println);
    }

    public void test10() {
        // map只能把一个对象转换成另一个对象来作为流中的元素。而flatMap可以把一个对象转换成多个对象作为流中的元素
        // 打印所有书籍的名字。要求对重复的元素进行去重
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .forEach(System.out::println);
    }

    public void test11() {
        // 打印现有数据的所有分类。要求对分类进行去重。不能出现这种格式：哲学,爱情
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getCategory())
                .flatMap(category -> Arrays.stream(category.split(",")))
                .distinct()
                .forEach(System.out::println);
    }

    public void test12() {
        List<Author> authors = getAuthors();
        authors.stream()
                .map(x -> x.getName())
                .distinct()
                .forEach(System.out::println);
    }

    public void test13() {
        // 打印这些作家的所出书籍的数目，注意删除重复元素
        List<Author> authors = getAuthors();
        long count = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .count();
        System.out.println(String.format("书籍总数：%s", count));
    }

    public void test14() {
        // 分别获取这些作家的所出书籍的最高分和最低分并打印
        List<Author> authors = getAuthors();
        Integer max = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(Book::getScore)
                .max(((o1, o2) -> o1 - o2)).get();
        Integer min = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(Book::getScore)
                .min(((o1, o2) -> o1 - o2)).get();
        System.out.println(String.format("max => %s, min => %s", max, min));
    }

    public void test15() {
        // 转换成List
        List<Author> authors = getAuthors();
        List<Author> list = authors.stream()
                .collect(Collectors.toList());
        System.out.println(list);
    }

    public void test16() {
        // 转换成Set
        List<Author> authors = getAuthors();
        Set<Author> set = authors.stream()
                .collect(Collectors.toSet());
        System.out.println(set);
    }

    public void test17() {
        List<Author> authors = getAuthors();
        Map<String, List<Book>> map = authors.stream()
                .distinct()
                .collect(Collectors.toMap(x -> x.getName(), x -> x.getBooks()));
        System.out.println(map);
    }

    public void test18() {
        // 存在年龄大于30的作者吗？
        List<Author> authors = getAuthors();
        boolean b = authors.stream()
                .anyMatch(x -> x.getAge() > 30);
        System.out.println(b);
    }

    public void test19() {
        // 存在年龄大于50的作者吗？
        List<Author> authors = getAuthors();
        boolean b = authors.stream()
                .anyMatch(x -> x.getAge() > 50);
        System.out.println(b);
    }

    public void test20() {
        // 作者年龄全部大于10吗？
        List<Author> authors = getAuthors();
        boolean b = authors.stream()
                .allMatch(x -> x.getAge() > 10);
        System.out.println(b);
    }

    public void test21() {
        // 作者年龄全部大于50吗？
        List<Author> authors = getAuthors();
        boolean b = authors.stream()
                .allMatch(x -> x.getAge() > 50);
        System.out.println(b);
    }

    public void test22() {
        // 不存在作者年龄大于50的吗？
        List<Author> authors = getAuthors();
        boolean b = authors.stream()
                .noneMatch(x -> x.getAge() > 50);
        System.out.println(b);
    }

    public void test23() {
        // 不存在作者年龄大于10的吗？
        List<Author> authors = getAuthors();
        boolean b = authors.stream()
                .noneMatch(x -> x.getAge() > 10);
        System.out.println(b);
    }

    public void test24() {
        // 获取流中的任意一个元素，该方法没有办法保证获取的一定是流中的第一个元素
        List<Author> authors = getAuthors();
        // 获取作者年龄大于25的任意哥作家
        Author author = authors.stream()
                .filter(x -> x.getAge() > 25)
                .findAny().get();
        System.out.println(author);
    }

    public void test25() {
        // 获取流中的第一个元素
        List<Author> authors = getAuthors();
        // 获取书籍数量大于2的作者集合中的第一个作者信息
        Author author = authors.stream()
                .filter(x -> x.getBooks().size() > 2)
                .findFirst().get();
        System.out.println(author);
    }

    public void test26() {
        // 缩减操作，求所有作者的年龄和
        List<Author> authors = getAuthors();
        Integer sum = authors.stream()
                .distinct()
                .map(Author::getAge)
                .reduce((result, element) -> result + element).get();
        System.out.println(sum);
    }

    public void test27() {
        // 缩减操作，求所有作者中年龄的最大值
        // 其实在max方法中底层就是用了reduce
        List<Author> authors = getAuthors();
        Integer max = authors.stream()
                .map(Author::getAge)
                .reduce((reuslt, element) -> element > reuslt ? element : reuslt).get();
        System.out.println(max);
    }

    public void test28() {
        // 缩减操作，求所有 作者中年龄的最小值
        // 其实在min方法中底层就是用了reduce
        List<Author> authors = getAuthors();
        Integer min = authors.stream()
                .map(Author::getAge)
                .reduce((result, element) -> element < result ? element : result).get();
        System.out.println(min);
    }

    public void test29() {
        // 打印作家中年龄大于17并且姓名的长度大于1的作家
        List<Author> authors = getAuthors();
        authors.stream()
                .filter(new Predicate<Author>() {
                            @Override
                            public boolean test(Author author) {
                                return author.getAge() > 17;
                            }
                        }.and(x -> x.getName().length() > 1)
                )
                .forEach(System.out::println);
    }

    public void test30() {
        // 打印作家中年龄大于17或者姓名的长度小于2的作家
        List<Author> authors = getAuthors();
        authors.stream()
                .filter(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge() > 17;
                    }
                }.or(x -> x.getName().length() < 2))
                .forEach(System.out::println);
    }

    public void test31() {
        // 打印作家中年龄不大于17的作家
        List<Author> authors = getAuthors();
        authors.stream()
                .filter(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge() > 17;
                    }
                }.negate())
                .forEach(System.out::println);
    }
}
