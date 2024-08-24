package org.yeahicode;


import org.yeahicode.entity.Author;
import org.yeahicode.entity.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

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
        Author author = getAuthor();
        // 如果此时author为空，则会报空指针异常，所以需要加非空校验
//        System.out.println(author.getName());
        if (author != null) {
            System.out.println(author.getName());
        }
    }

    private static Author getAuthor() {
        return null;
    }

    public void test02() {
        Author author = getAuthor1();
        // Otional.ofNullable，把参数封装成Optional对象，无论是否为null
        Optional<Author> authorOpt = Optional.ofNullable(author);
        authorOpt.ifPresent(x -> System.out.println(x.getName()));
    }

    private static Author getAuthor1() {
        List<Book> books1 = new ArrayList<>();
        books1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学,爱情", 88, "用一把刀划分了爱恨"));
        books1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长,爱情", 99, "讲述如何从失败中明悟真理"));
        return new Author(2L, "ryu", 12, "nothing to intro", books1);
    }

    public void test03() {
        // 使用Optional.of，可传入null，所以必须确保传入的参数不为null，否则必须谨慎使用
        Author author = getAuthor2().get();
        System.out.println(author.getName());
    }

    private static Optional<Author> getAuthor2() {
        return Optional.of(null);
    }

    public void test04() {
        Optional<Object> empty = Optional.empty();
        boolean present = empty.isPresent();
        // 当前present为false，因为不存在值
        System.out.println(present);
    }

    public void test05() {
        Optional<Author> author = Optional.ofNullable(getAuthor());
        // 安全消费：存在值才消费，不存在（null）则不消费
        author.ifPresent(x -> System.out.println(x.getName()));
    }

    public void test06() {
        Author author = null;
        Optional<Author> optional = Optional.ofNullable(author);
        // 不推荐使用get，因为不存在值（null）的时候，会报错：java.util.NoSuchElementException: No value present
        System.out.println(optional.get());
    }

    public void test07() {
        // 安全获取值
        Author author = null;
        Optional<Author> optional = Optional.ofNullable(author);
        // 安全获取值
        Author author1 = optional.orElse(new Author());
        // 安全获取值
        Author author2 = optional.orElseGet(() -> new Author());
        System.out.println(author1);
        System.out.println(author2);
    }

    public void test08() {
        Author author = null;
        Optional<Author> optional = Optional.ofNullable(author);
        // 安全获取值：如果存在则返回对象，如果不存在则抛异常，在项目中，可交由spring统一处理
        Author target = optional.orElseThrow(() -> new RuntimeException("对象不能为空"));
        System.out.println(target);
    }

    public void test09() {
        List<Book> books1 = new ArrayList<>();
        books1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学,爱情", 88, "用一把刀划分了爱恨"));
        books1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长,爱情", 99, "讲述如何从失败中明悟真理"));
        Author author = new Author(2L, "ryu", 102, "nothing to intro", books1);
        Optional<Author> optional = Optional.ofNullable(author);
        // 先过滤，如果存在则打印，不存在则不处理
        optional.filter(x -> x.getAge() > 100).ifPresent(System.out::println);
    }

    public void test10() {
        List<Book> books1 = new ArrayList<>();
        books1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学,爱情", 88, "用一把刀划分了爱恨"));
        books1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长,爱情", 99, "讲述如何从失败中明悟真理"));
        Author author = new Author(2L, "ryu", 102, "nothing to intro", books1);
        Optional<Author> optional = Optional.ofNullable(author);
        // 数据转换
        Optional<List<Book>> books = optional.map(x -> x.getBooks());
        books.ifPresent(x -> System.out.println(books));
    }
}
