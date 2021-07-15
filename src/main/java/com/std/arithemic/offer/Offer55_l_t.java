package com.std.arithemic.offer;

import com.std.arithemic.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zyc
 * @date 2021/7/14 19:00
 */
public class Offer55_l_t {
    class Solution {
        public int maxDepthV1 (TreeNode root) {
            int deep = 0;
            if (root == null) {
                return deep;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                for (int i = 0; i < queue.size(); i++) {
                    TreeNode node = queue.remove();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                deep ++;
            }
            return deep;
        }
    }
}