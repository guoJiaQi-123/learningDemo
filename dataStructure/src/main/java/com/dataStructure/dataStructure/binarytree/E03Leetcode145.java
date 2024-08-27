package com.dataStructure.dataStructure.binarytree;


import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的后序遍历
 */
public class E03Leetcode145 {
    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             /   / \
            4   5   6
         */
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
        postOrder(root);

    }

    /**
     * 后序遍历
     */
    public static void postOrder(TreeNode root) {
        //先定义一个变量存放当前节点
        TreeNode curr = root;
        //定义一个栈数据结构，用来存放遍历过程中的节点
        LinkedList<TreeNode> stack = new LinkedList<>();
        //定义一个变量pop存放最近从栈中弹出的节点
        TreeNode pop = null;
        //当左孩子不为空或者栈中不为空，则循环
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                //如果当前节点不为空，将其放入栈中
                stack.push(curr);
                //将curr指向当前节点的左孩子
                curr = curr.left;
            } else {
                //后序遍历调用栈数据结构的peek方法，先操作栈顶元素，不急着弹出
                TreeNode peek = stack.peek();
                //如果栈顶节点的右孩子为空，或者栈顶节点与最近弹出栈的节点相同
                if (peek.right == null || peek.right == pop) {
                    //则将栈顶元素弹出并打印
                    pop = stack.pop();
                    System.out.println(pop);
                } else {
                    //如果不是，则将curr指向栈顶元素的右孩子
                    curr = peek.right;
                }
            }
        }
    }

    /**
     * 后序遍历
     */
    static class Solution {
        /**
         * 后序遍历
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            TreeNode curr = root;//定义一个变量，存放当前节点
            List<Integer> postOrder = new LinkedList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode pop = null;
            //当前节点不为空且栈不为空
            while (curr != null || !stack.isEmpty()) {
                if (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                } else {
                    TreeNode peek = stack.peek();
                    if (peek.right == null || peek.right == pop) {
                        pop = stack.pop();
                        postOrder.add(pop.val);
                    } else {
                        curr = peek.right;
                    }
                }
            }
            return postOrder;
        }
    }

    /*
        31 红
        32 黄
        33 橙
        34 蓝
        35 紫
        36 绿
     */
    public static void colorPrintln(String origin, int color) {
        System.out.printf("\033[%dm%s\033[0m%n", color, origin);
    }
}
