package com.feishu._07backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/9/9
 * @apiNote 78. 子集
 */
public class E08subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(0, nums, list, path);
        return list;
    }

    private void dfs(int start, int[] nums, List<List<Integer>> list, LinkedList<Integer> path) {
        // 子集是收集树形结构中树的所有节点的结果。
        list.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            path.push(num);
            dfs(i + 1, nums, list, path);
            path.pop();
        }
    }
}