package Graph;

import java.util.*;

/**
 * 210. 课程表 II
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 *
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 */
public class Solution210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        // 1. 入度map
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) inDegree.put(i, 0);
        // 2. 接邻表
        Map<Integer, List<Integer>> neighborMap = new HashMap<>();
        for (int[] relation : prerequisites) {
            // cur <- pre 先学pre 后学cur
            int cur = relation[0];
            int pre = relation[1];
            // 更新入度
            inDegree.put(cur, inDegree.get(cur) + 1);
            // 更新接邻表
            if (!neighborMap.containsKey(pre)) neighborMap.put(pre, new ArrayList<>());
            neighborMap.get(pre).add(cur);
        }
        // 3. BFS
        Queue<Integer> queue = new LinkedList<>();
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                queue.offer(key);
            }
        }
        while(!queue.isEmpty()) {
            Integer course = queue.poll();
            res.add(course);
            if (!neighborMap.containsKey(course)) continue;

            List<Integer> neighborList = neighborMap.get(course);
            for (int neighbor : neighborList) {
                // 每个neighbor的入度都减 1
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                // 如果neighbor的入度为0 直接加入队列
                if (inDegree.get(neighbor) == 0) queue.offer(neighbor);
            }
        }
        // 如果不能完成所有课程 则返回空数组
        int[] resArray = res.stream().mapToInt(Integer::intValue).toArray();
        return resArray.length == numCourses ? resArray : new int[0];
    }
}
