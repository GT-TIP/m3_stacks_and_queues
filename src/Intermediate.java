import java.util.*;

/**
 * @author: Jenna Kwon jkwon47@gatech.edu. Email if you have any questions or !
 *
 * This code is for Workshop #3 at Georgia Tech Technical Interview Prep Club.
 * Slides pertaining to this module's code is at: http://bitly.com/gttip_fall2016_m3
 *
 * Implement a MyStack class using queues,
 * supporting traditional operations such as push, pop, peek, and empty
 *
 */
public class Intermediate {

    // There are three solutions to this.
    // 1) Two queues. Push - O(1), Pop - O(n)
    // 2) Two queues. Push - O(n), Pop - O(1)
    // 3) One queue. Push - O(n), Pop - O(1)
    // We demonstrate the One stackueue solution.

    public static class MyStack {
        private Deque<Integer> queue;

        public void push(Integer x) {
            queue.add(x);
            int sz = queue.size();
            while (sz > 1) {
                queue.add(queue.remove());
                sz--;
            }
        }

        public Integer pop() {
            return queue.remove();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }


    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop() == 1);
        System.out.println(stack.pop() == 2);
        System.out.println(stack.pop() == 3);
        System.out.println(stack.empty());

        try {
            stack.pop();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}
