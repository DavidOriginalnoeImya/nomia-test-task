package queue;

import java.util.LinkedList;
import java.util.Queue;

// Решение с call - O(1) и getActions - O(n) в худшем случае.
// Плохо подходит для случаев, когда getActions вызывается редко,
// так как очередь может разрастись до гигантских размеров.
// При этом чистить недостижимые элементы очереди в call
// не имеет особого смысла, поскольку это не поможет справиться
// с проблемой добавления большого количества одинаковых таймстампов
public class ActionCounter {

    private static final int ACCESS_PERIOD = 300;

    private Queue<Integer> calls = new LinkedList<>();

    public ActionCounter() {
    }

    public void call(int timestamp) {
        calls.add(timestamp);
    }

    public int getActions(int timestamp) {
        while (!calls.isEmpty() && calls.peek() <= timestamp - ACCESS_PERIOD) {
            calls.poll();
        }

        return calls.size();
    }
}
