package com.std.arithemic.mihayou;

import com.std.arithemic.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyc
 * @date 2021/7/28 17:08
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 *
 * 输入：root = [1,2]
 * 输出：[2,1]
 * 示例 5：
 *
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class LC94 {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            dfs (root, result);
            return result;
        }

        private void dfs(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }
            dfs(root.left, result);
            result.add(root.val);
            dfs(root.right, result);
        }
    }
}