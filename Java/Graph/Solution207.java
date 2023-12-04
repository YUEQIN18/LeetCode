package Graph;

import java.util.*;

public class Solution207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1.课号和对应的入度
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) inDegree.put(i, 0);

        // 2.依赖关系, 依赖当前课程的后序课程
        Map<Integer, List<Integer>> adj = new HashMap<>();
        // 初始化入度和依赖关系
        for (int[] relate : prerequisites) {
            // (3,0), 想学3号课程要先完成0号课程, 更新3号课程的入度和0号课程的依赖(邻接表)
            // cur 3 <- pre 0  箭头代表了学习的顺序 先学pre 再学cur
            int cur = relate[0];
            int pre = relate[1];
            // 1.更新入度
            inDegree.put(cur, inDegree.getOrDefault(cur, 0) + 1);
            // 2.当前节点的邻接表
            if (!adj.containsKey(pre)) adj.put(pre, new ArrayList<>());
            adj.get(pre).add(cur);
        }
        // 3.BFS, 将入度为0的课程放入队列, 队列中的课程就是没有先修, 可以学的课程
        Queue<Integer> q = new LinkedList<>();
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                q.offer(key);
            }
        }
        // 取出一个节点, 对应学习这门课程.
        // 遍历当前邻接表, 更新其入度; 更新之后查看入度, 如果为0, 加入到队列
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            // 遍历当前课程的邻接表, 更新后继节点的入度
            if (!adj.containsKey(cur)) continue;

            List<Integer> successorList = adj.get(cur);

            for (int k : successorList) {
                inDegree.put(k, inDegree.get(k) - 1);
                if (inDegree.get(k) == 0) {
                    q.offer(k);
                }
            }
        }
        return count == numCourses;
    }

}
