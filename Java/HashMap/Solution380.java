package HashMap;

import java.util.*;

/**
 * 380. O(1) 时间插入、删除和获取随机元素
 * 实现RandomizedSet 类：
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 */
public class Solution380 {
    // 这道提是对数据结构的考察，插入和删除要达到O(1)需要哈希表，而获取达到O(1)需要数组，所以这道题是二者的结合
    static class RandomizedSet {

        private List<Integer> array;
        private Map<Integer, Integer> map;
        private Random random;

        public RandomizedSet() {
            this.array = new ArrayList<>();
            this.map = new HashMap<>();
            this.random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            array.add(val);
            map.put(val, array.indexOf(val));
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            // 交换删除，确保 O(1)，先把最后一个元素的值覆盖掉要删除的元素，然后删除最后一个元素
            Integer last = array.get(array.size() - 1);
            Integer index = map.get(val);
            array.set(index, last);
            map.put(last, index);
            array.remove(array.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return array.get(random.nextInt(array.size()));
        }
    }
}


