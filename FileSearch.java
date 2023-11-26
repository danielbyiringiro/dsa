import java.util.LinkedList;

class CustomHashMap<K, V> {

    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] buckets;

    public CustomHashMap() {
        this(INITIAL_CAPACITY);
    }

    public CustomHashMap(int capacity) {
        this.buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        // Check if the key already exists in the bucket
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                // Update the value if the key exists
                entry.value = value;
                return;
            }
        }

        // Add a new entry if the key does not exist
        bucket.add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        // Search for the key in the bucket
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        // Return null if the key is not found
        return null;
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode % buckets.length);
    }

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

public class FileSearch {

    public static void main(String[] args) {
        CustomHashMap<String, String> fileMap = new CustomHashMap<>();

        // Insert files into the custom hash map
        fileMap.put("file1.txt", "/path/to/file1.txt");
        fileMap.put("file2.txt", "/path/to/file2.txt");
        fileMap.put("file3.txt", "/path/to/file3.txt");

        // Search for a file
        String fileNameToSearch = "file2.txt";
        String filePath = fileMap.get(fileNameToSearch);

        if (filePath != null) {
            System.out.println("File found: " + fileNameToSearch + " at " + filePath);
        } else {
            System.out.println("File not found: " + fileNameToSearch);
        }
    }
}
