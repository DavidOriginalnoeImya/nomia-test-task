package map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// Решение с call - O(n) и getActions - O(n).
// Время работы call хуже, чем в решении с очередью,
// но при этом размер мапы всегда не больше 300
public class ActionCounter {

    private static final int ACCESS_PERIOD = 300;

    private Map<Integer, Integer> calls = new HashMap<>();

    public ActionCounter() {
    }

    public void call(int timestamp) {
        calls = calls.entrySet()
                .stream()
                .filter(call -> call.getKey() > timestamp - ACCESS_PERIOD)
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (c1, c2) -> c1, HashMap::new)
                );

        calls.put(timestamp, calls.getOrDefault(timestamp, 0) + 1);
    }

    public int getActions(int timestamp) {
        return calls.entrySet()
                .stream()
                .filter(call -> call.getKey() > timestamp - ACCESS_PERIOD)
                .mapToInt(Map.Entry::getValue).sum();
    }
}
