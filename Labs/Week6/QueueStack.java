package Labs.Week6;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStack {
    public static void main(String[] args) {
        TwoQueueStack stack = new TwoQueueStack();
    }
}

class TwoQueueStack {
    private Queue<Integer> queue1 = new LinkedList<Integer>();
    private Queue<Integer>  queue2 = new LinkedList<Integer>() {
        
    };
    public TwoQueueStack() {

    }
}
