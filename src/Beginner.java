import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * @author: Jenna Kwon jkwon47@gatech.edu. Email if you have any questions!
 *
 * This code is for the workshop at Georgia Tech Technical Interview Prep Club.
 * Slides pertaining to this module's code is at: http://bitly.com/gttip_fall2016_m3
 *
 * Problem:
 * Implement a MyQueue class using stacks,
 * supporting traditional operations such as enqueue, dequeue, peek, and empty.
 *
 */
public class Beginner {

    public static class MyQueue {
        // enq is a stack holding values that are enqueued on its top
        private Deque<Integer> enq = new LinkedList<>();
        // deq is a stack holding values to be dequeued on its top
        private Deque<Integer> deq = new LinkedList<>();

        public void enqueue(Integer x) { enq.addFirst(x); }

        // move elements from enq to deq only if deq is empty
        // if dequeue is called when both are empty, throw exception
        public Integer dequeue() {
            if (deq.isEmpty()) {
                // Transfers the elements from enq to deq.
                while (!enq.isEmpty()) {
                    deq.addFirst(enq.removeFirst());
                }
            }

            if (!deq.isEmpty()) {
                return deq.removeFirst();
            }
            throw new NoSuchElementException("MyQueue is empty!");
        }

        public boolean empty() {
            return enq.isEmpty() && deq.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue Q = new MyQueue();
        Q.enqueue(1);
        Q.enqueue(2);
        Q.enqueue(3);
        System.out.println(Q.dequeue() == 1);
        System.out.println(Q.dequeue() == 2);
        System.out.println(Q.dequeue() == 3);
        System.out.println(Q.empty());

        try {
            Q.dequeue();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
