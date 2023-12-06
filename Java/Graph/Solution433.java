package Graph;

import java.util.*;

/**
 * 433. 最小基因变化
 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 *
 * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 *
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
 *
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
 *
 * 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
 */
public class Solution433 {

    public int minMutation(String startGene, String endGene, String[] bank) {
        char[] items = new char[]{'A', 'C', 'G', 'T'};
        Set<String> set = new HashSet<>(Arrays.asList(bank)); // 检查gene是否合法
        Map<String, Integer> map = new HashMap<>(); // 记录遍历过的gene
        map.put(startGene, 0);
        Deque<String> d = new ArrayDeque<>(); // BFS队列
        d.offerLast(startGene);

        while (!d.isEmpty()) {
            int size = d.size();
            while (size-- > 0) {
                String s = d.pollFirst(); // 取出
                char[] cs = s.toCharArray();
                int step = map.get(s); // 从start到现在的gene经历了几次突变
                // 对一个gene的每一位都尝试突变
                for (int i = 0; i < 8; i++) {
                    // 每一位都尝试突变成A C G T
                    for (char c : items) {
                        if (cs[i] == c) continue;
                        char[] clone = cs.clone();
                        clone[i] = c;
                        String sub = String.valueOf(clone);
                        if (!set.contains(sub)) continue;
                        if (map.containsKey(sub)) continue;
                        if (sub.equals(endGene)) return step + 1;
                        map.put(sub, step + 1);
                        d.offerLast(sub);
                    }
                }
            }
        }
        return -1;
    }

}
