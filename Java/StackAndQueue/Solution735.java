package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 735. 行星碰撞
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 */
public class Solution735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i : asteroids) {
            boolean alive = true;
            while (alive && i < 0 && !stack.isEmpty() && stack.peekLast() > 0) {
                alive = Math.abs(stack.peekLast()) < Math.abs(i);
                if (Math.abs(stack.peekLast()) <= Math.abs(i)) {
                    stack.pollLast();
                }
            }
            if (alive) {
                stack.offer(i);
            }
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution735 solution735 = new Solution735();
        int[] a = new int[]{5, 10, -5};
        int[] res = solution735.asteroidCollision(a);
    }
}
