package pkg.yhan;

import java.util.HashMap;
import java.util.Map;

interface EventListener {
    void onEvent();
}

class EventSource {
    private final Map<Object, EventListener> listeners = new HashMap<>();

    public void registerListener(Object key, EventListener listener) {
        listeners.put(key, listener);
    }

    public void notifyListeners() {
        for (EventListener listener : listeners.values()) {
            listener.onEvent();
        }
    }

    public void removeListener(Object key) {
        listeners.remove(key);
    }
}

