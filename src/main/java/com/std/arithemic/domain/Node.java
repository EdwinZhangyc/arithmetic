package com.std.arithemic.domain;

/**
 * @author zyc
 * @date 2021/7/19 10:05
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    public Node(int _val) {
        val = _val;
    }
}