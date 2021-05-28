package com.std.source.jdk;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Maps;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.StandardCharsets;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zyc
 * @date 2021/5/26 12:07
 */
public class BitSetS {

    /**
     * 计时器
     */
    public static final ThreadLocal<Stopwatch> TIME_COUNTER_LOCAL = ThreadLocal.withInitial(Stopwatch::createStarted);

    /**
     * 数据量计数器
     */
    public static final ThreadLocal<Integer> COUNTER_LOCAL = ThreadLocal.withInitial(() -> 0);

    /**
     * bloom过滤器
     */
    public static final ThreadLocal<BloomFilter<CharSequence>> BLOOM_FILTER_LOCAL =
            ThreadLocal.withInitial(() -> BloomFilter.create(Funnels.stringFunnel(StandardCharsets.UTF_8), 100000, 0.001d));

    /**
     * 将hashKey分解后存储容器
     */
    public static final ThreadLocal<Map<String, Set<String>>> KEY_SET_LOCAL = ThreadLocal.withInitial(() -> {
        HashMap<String, Set<String>> keySetMap = Maps.newHashMap();
        return keySetMap;
    });

    public static void main1(String[] args) {

//        System.out.println(1000>>6);
//
        BitSet bitSet = new BitSet();
//        // 支持动态扩容
//        bitSet.set(1);
//        bitSet.set(100);
//        boolean b = bitSet.get(1);
//
//        System.out.println(bitSet.cardinality());


    }
}