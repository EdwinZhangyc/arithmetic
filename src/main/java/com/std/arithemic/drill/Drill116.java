package com.std.arithemic.drill;

import com.std.arithemic.domain.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zyc
 * @date 2021/7/19 10:00
 * 116. 填充每个节点的下一个右侧节点指针
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class Drill116 {

    class Solution {
        public Node connectDFS(Node root) {
            if (root == null) {
                return root;
            }
            Node leftmost = root;
            while (leftmost.left != null) {
                Node head = leftmost;
                while (head != null) {
                    head.left.next = head.right;
                    if (head.next != null) {
                        head.right.next = head.next.left;
                    }
                    head = head.next;
                }
                leftmost = leftmost.next;
            }
            return root;
        }
        public Node connectBFS(Node root) {
            if (root == null) {
                return root;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                     Node node = queue.remove();
                     if (i < size - 1) {
                         node.next = queue.peek();
                     }
                     if (node.left != null) {
                         queue.add(node.left);
                     }
                     if (node.right != null) {
                         queue.add(node.right);
                     }
                }
            }
            return root;
        }
    }
}