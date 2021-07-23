package com.std.arithemic.geektime.datastruct;

import com.std.arithemic.domain.TreeNode;

/**
 * @author zyc
 * @date 2021/7/15 16:32
 */
public class Tree {

    class BinaryTree {
        private TreeNode node;
        public TreeNode find (int data) {
            TreeNode p = node;
            while (p != null) {
                if (data == p.val) {
                    return p;
                } else if (data < p.val) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }
            return null;
        }

        public void insert (int data) {
            if (node == null) {
                node = new TreeNode(data);
            }
            TreeNode p = node;
            while (true) {
                if (p.val > data) {
                    if (p.left == null) {
                        p.left = new TreeNode(data);
                        return;
                    }
                    p = p.left;
                } else {
                    if (p.right == null) {
                        p.right = new TreeNode(data);
                        return;
                    }
                    p = p.right;
                }
            }
        }

        public void delete(int data) {
            TreeNode p = node; // p 指向要删除的节点，初始化指向根节点
            TreeNode pp = null; // pp 记录的是 p 的父节点
            while (p != null && p.val != data) {
                pp = p;
                if (data > p.val) {
                    p = p.right;
                } else {
                    p = p.left;
                }
            }
            if (p == null) {
                return; // 没有找到
            }

            // 要删除的节点有两个子节点
            if (p.left != null && p.right != null) { // 查找右子树中最小节点
                TreeNode minP = p.right;
                TreeNode minPp= p; // minPP 表示 minP 的父节点
                while (minP.left != null) {
                    minPp = minP;
                    minP = minP.left;
                }
                p.val = minP.val; // 将 minP 的数据替换到 p 中
                p = minP; // 下面就变成了删除 minP 了
                pp = minPp;
            }

            // 删除节点是叶子节点或者仅有一个子节点
            TreeNode child; // p 的子节点
            if (p.left != null) {
                child = p.left;
            } else if (p.right != null) {
                child = p.right;
            } else {
                child = null;
            }
            if (pp == null) {
                node = child; // 删除的是根节点
            } else if (pp.left == p) {
                pp.left = child;
            } else {
                pp.right = child;
            }
        }
    }
}