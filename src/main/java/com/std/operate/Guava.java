package com.std.operate;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

import java.util.Optional;

import static com.google.common.base.Preconditions.*;

/**
 * @author zyc
 * @date 2021/5/28 15:11
 */
public class Guava {

    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();
        int templateStart = 0;
        String s = "aaa%sbbbb";

        int placeholderStart = s.indexOf("%s", templateStart);
        builder.append(s, templateStart, placeholderStart);
        System.out.println(placeholderStart);
        System.out.println(templateStart);
        System.out.println(builder.toString());
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

        ComparisonChain.start().compare(1, 1)
                .compare(1, 2).result();


    }
}