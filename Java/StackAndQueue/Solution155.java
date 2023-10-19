package StackAndQueue;

import java.util.*;

public class Solution155 {
    class MinStack {
        private int min;
        private final Deque<Integer> stack;

        public MinStack() {
            this.min = Integer.MAX_VALUE;
            this.stack = new LinkedList<>();
        }

        public void push(int val) {
            stack.push(val);
            this.min = Math.min(min, val);
        }

        public void pop() {
            if ( stack.pop() == min && !stack.isEmpty()) {
                List<Integer> l = new ArrayList<>(stack);
                this.min = Collections.min(l);
            }
            if (stack.isEmpty()) {
                this.min = Integer.MAX_VALUE;
            }
        }

        public int top() {
            if (stack.isEmpty()) return 0;
            return stack.peek();
        }

        public int getMin() {
            return this.min;
        }
    }

}
