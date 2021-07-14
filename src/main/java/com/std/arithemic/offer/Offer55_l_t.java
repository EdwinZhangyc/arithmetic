package com.std.arithemic.offer;

import com.std.arithemic.domain.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author zyc
 * @date 2021/7/14 19:00
 */
public class Offer55_l_t {
    class Solution {
        public int maxDepth(TreeNode root) {
            int deep = 0;
            if (Objects.isNull(root)) {
                return deep;
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            while (!queue.isEmpty()) {
                for(int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    if(node.left != null) {
                        queue.add(node.left);
                    }
                    if(node.right != null) {
                        queue.add(node.right);
                    }
                }
                deep++;
            }
            return deep;
        }
    }
}