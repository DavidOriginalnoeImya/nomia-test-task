package array;

// Решение с call - O(1) и getActions - O(n).
// Сначала хотел реализовать на основе одного массива,
// но в итоге понял, что за счет дополнительного массива
// на 300 элементов можно сделать call со сложностью O(1),
// а не O(n). Наверное, это самое оптимальное из всех моих решений
public class ActionCounter {

    private static final int ACCESS_PERIOD = 300;

    private int[] timestamps = new int[ACCESS_PERIOD];

    private int[] calls = new int[ACCESS_PERIOD];

    private int lastCallTimestamp = -1;

    public ActionCounter() {
    }

    public void call(int timestamp) {
        if (timestamp != lastCallTimestamp) {
            timestamps[timestamp % ACCESS_PERIOD] = timestamp;
            calls[timestamp % ACCESS_PERIOD] = 0;
            lastCallTimestamp = timestamp;
        }

        ++calls[timestamp % ACCESS_PERIOD];
    }

    public int getActions(int timestamp) {
        int actions = 0;

        for (int index = 0; index < timestamps.length; ++index) {
            if (timestamps[index] > timestamp - ACCESS_PERIOD) {
                actions += calls[index];
            }
        }

        return actions;
    }
}
