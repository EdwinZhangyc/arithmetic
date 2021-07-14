package com.std.arithemic.offer;

import com.std.arithemic.domain.TreeNode;

/**
 * @author zyc
 * @date 2021/7/8 19:38
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 */
public class Offer28_t {

    public boolean isSymmetric(TreeNode root) {
        return preOrder(root, build(root));
    }
    public boolean isSymmetricV2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return preOrder(root.left, root.right);
    }

    private TreeNode build (TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode mirroTree = new TreeNode(root.val);
        mirroTree.left = build(root.right);
        mirroTree.right = build(root.left);
        return mirroTree;
    }

    boolean preOrder(TreeNode root, TreeNode root2) {
        if (root == null ){
            return root2 == null;
        }
        if (root2 == null ){
            return false;
        }
        if (root.val != root2.val) {
            return false;
        }
        return preOrder(root.left, root2.left) && preOrder(root.right, root2.right);
    }

}