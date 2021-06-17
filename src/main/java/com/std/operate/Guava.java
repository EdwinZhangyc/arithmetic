package com.std.operate;

import com.google.common.base.Objects;
import com.google.common.base.Throwables;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;

import java.util.Optional;

import static com.google.common.base.Preconditions.*;

/**
 * @author zyc
 * @date 2021/5/28 15:11
 */
public class Guava {

    public static void main(String[] args) {

//        StringBuilder builder = new StringBuilder();
//        int templateStart = 0;
//        String s = "aaa%sbbbb";
//
//        int placeholderStart = s.indexOf("%s", templateStart);
//        builder.append(s, templateStart, placeholderStart);
//        System.out.println(placeholderStart);
//        System.out.println(templateStart);
//        System.out.println(builder.toString());

        ImmutableSet<String> immutableSet = ImmutableSet.<String>builder()
                .add("1")
                .add("2")
                .add("1")
                .build();
        UnmodifiableIterator<String> iterator = immutableSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void method(String[] args) {

        Integer integer = Optional.of(1).orElse(3);
        boolean assertFlag =  1 < 2;
        checkArgument(assertFlag, "one is not less two");
        checkNotNull(args[0], "args is not null");
        checkState(assertFlag);

        Objects.equal(null, "aa");
        Objects.equal(null, null);
        Objects.hashCode("1", "2", "abc");

        int result = ComparisonChain.start().compare(1, 1)
                .compare(1, 2).result();

        throw Throwables.propagate(new RuntimeException());


    }
}