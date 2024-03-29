package Graph;

import java.util.*;

/**
 * 399. 除法求值
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 * 注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。
 */
public class Solution399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 生成储存变量所构成的图, 本质上是一种json结构 graph = {a: {b: 3, ...}, ...}
        Map<String, Map<String, Double>> graph = new HashMap<>();
        int n = equations.size();
        for (int i = 0; i < n; i++) {
            String s = equations.get(i).get(0), e = equations.get(i).get(1);
            double v = values[i]; // v = s / e
            if (!graph.containsKey(s)) graph.put(s, new HashMap<>());
            if (!graph.containsKey(e)) graph.put(e, new HashMap<>());
            graph.get(s).put(e, v); // 生成一条s指向e，权重为v的路径，表示 s / e = v
            graph.get(e).put(s, 1 / v); // 生成一条反向路径，权重为1 / v，表示 e / s = 1 /v
            graph.get(s).put(s, 1.0); // 生成一个指向自己、权重为1的路径，表示自己除自己等于1
            graph.get(e).put(e, 1.0); // 生成一个指向自己、权重为1的路径，表示自己除自己等于1
        }
        Queue<NodeData> queue = new LinkedList<>();   // 用于广度优先搜索的队列
        int m = queries.size();
        double[] res = new double[m];    // 答案列表
        Arrays.fill(res, -1.0);          // 初始都为-1表示未定义
        Set<String> visited;
        // 对于每一个query 寻找从起点qx到终点qy的最短路径 并计算权重积
        for (int i = 0; i < m; i++) {
            String qx = queries.get(i).get(0), qy = queries.get(i).get(1);
            if (!graph.containsKey(qx) || !graph.containsKey(qy)) continue;
            queue.offer(new NodeData(qx, 1.0));
            visited = new HashSet<>(); // 记录已经遍历过的节点
            visited.add(qx);
            while (!queue.isEmpty()) {
                NodeData node = queue.poll();
                // 遍历当前节点的所有邻节点
                for (Map.Entry<String, Double> entry : graph.get(node.var).entrySet()) {
                    String neighbor = entry.getKey();
                    Double weight = entry.getValue();
                    // 找到终点 保存答案 结束遍历
                    if (qy.equals(neighbor)) {
                        res[i] = node.mulWeight * weight;
                    }
                    // 找到未处理的邻节点
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        // 将未处理的邻节点及到达该节点时的权重积加入队列
                        queue.offer(new NodeData(neighbor, node.mulWeight * weight));
                    }
                }
            }
        }
        return res;
    }

    // 用于广度优先搜索存储数据的节点数据结构
    class NodeData{
        String var;         // 当前变量名
        double mulWeight;   // 到达该节点时的累乘权重积

        NodeData(String var, double weight){
            this.var = var;
            this.mulWeight = weight;
        }
    }

    public double[] calcEquationV2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvars = 0;
        Map<String, Integer> variables = new HashMap<String, Integer>();
        // 先遍历已知的变量
        int n = equations.size();
        for (List<String> equation : equations) {
            if (!variables.containsKey(equation.get(0))) {
                variables.put(equation.get(0), nvars++);
            }
            if (!variables.containsKey(equation.get(1))) {
                variables.put(equation.get(1), nvars++);
            }
        }
        // 对于每个点，存储其直接连接到的所有点及对应的权值
        List<Pair>[] edges = new List[nvars];
        for (int i = 0; i < nvars; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int va = variables.get(equations.get(i).get(0)), vb = variables.get(equations.get(i).get(1));
            edges[va].add(new Pair(vb, values[i]));
            edges[vb].add(new Pair(va, 1.0 / values[i]));
        }
        // 确定每个问题的答案
        int queriesCount = queries.size();
        double[] ret = new double[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            List<String> query = queries.get(i);
            double result = -1.0;
            if (variables.containsKey(query.get(0)) && variables.containsKey(query.get(1))) {
                int ia = variables.get(query.get(0)), ib = variables.get(query.get(1));
                if (ia == ib) {
                    result = 1.0;
                } else {
                    Queue<Integer> points = new LinkedList<>();
                    points.offer(ia);
                    double[] ratios = new double[nvars];
                    Arrays.fill(ratios, -1.0);
                    ratios[ia] = 1.0;

                    while (!points.isEmpty() && ratios[ib] < 0) {
                        int x = points.poll();
                        for (Pair pair : edges[x]) {
                            int y = pair.index;
                            double val = pair.value;
                            if (ratios[y] < 0) {
                                ratios[y] = ratios[x] * val;
                                points.offer(y);
                            }
                        }
                    }
                    result = ratios[ib];
                }
            }
            ret[i] = result;
        }
        return ret;
    }


    class Pair {
        int index;
        double value;

        Pair(int index, double value) {
            this.index = index;
            this.value = value;
        }
    }
}
