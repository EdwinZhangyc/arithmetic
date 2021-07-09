package com.std.arithemic.offer;

/**
 * @author qushuang
 * @date 2021/4/10 下午9:17
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Offer07 {

     static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

    static class Solution {
        int inp = 0, prep = 0;
        public TreeNode buildTree(int[] preorder,int[] inorder){
            return build2(preorder,inorder,Integer.MAX_VALUE);
        }
        public TreeNode build2(int[] preorder,int[] inorder,int stop){
            if(prep >= preorder.length){
                return null;
            }
            //如果stop与中序inp相等，说明左树完结，返回
            if(inorder[inp] == stop){ inp++; return null;}
            //创造节点加入树，同时调用，而节点的值加入了stop栈（调用体现）
            TreeNode node = new TreeNode(preorder[prep++]);
            node.left = build2(preorder,inorder,node.val);
            node.right = build2(preorder,inorder,stop);
            return node;
        }
    }
}