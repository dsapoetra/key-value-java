
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Store {
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> data = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, AttributeMetadata> attributeTypes = new ConcurrentHashMap<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void addAttributeType(String key, AttributeMetadata metadata) {
        lock.writeLock().lock();
        try {
            attributeTypes.put(key, metadata);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void setValue(String key, String attribute, Object value) {
        lock.writeLock().lock();
        try {
            data.computeIfAbsent(key, k -> new ConcurrentHashMap<>()).put(attribute, value);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Object getValue(String key, String attribute) {
        lock.readLock().lock();
        try {
            return data.getOrDefault(key, new ConcurrentHashMap<>()).get(attribute);
        } finally {
            lock.readLock().unlock();
        }
    }

    public AttributeType determineType(String value) {
        if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
            return AttributeType.BOOLEAN;
        }
        try {
            Float.parseFloat(value);
            return AttributeType.FLOAT;
        } catch (NumberFormatException ignored) { }
        return AttributeType.STRING;
    }

    public Object parseValue(AttributeType type, String value) {
        switch (type) {
            case BOOLEAN:
                return Boolean.parseBoolean(value);
            case FLOAT:
                return Float.parseFloat(value);
            default:
                return value;
        }
    }
}
