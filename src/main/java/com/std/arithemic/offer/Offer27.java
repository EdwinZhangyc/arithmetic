package com.std.arithemic.offer;

import com.std.arithemic.domain.TreeNode;

import java.util.Objects;

/**
 * @author zyc
 * @date 2021/7/8 19:25
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 */
public class Offer27 {

    public TreeNode mirrorTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        TreeNode treeNode = new TreeNode(root.val);
        treeNode.left = mirrorTree(root.right);
        treeNode.right = mirrorTree(root.left);
        return treeNode;
    }
}