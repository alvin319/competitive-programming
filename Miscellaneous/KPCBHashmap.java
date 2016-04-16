/**
 * Created by Alvin Deng on 12/11/15.
 */
public class KPCBHashmap {

    public static void main(String[] args) {
        primitiveHashMap testHashmap = new primitiveHashMap(10);
        testHashmap.set("Apple", new String("Fruit"));
        testHashmap.set("Ford", new String("Car"));
        testHashmap.set("Michael", new String("Person"));
        testHashmap.set("Hello", new String("World"));
        testHashmap.set("Yes", new String("No"));
        System.out.println("Apple: " + testHashmap.get("Apple").toString());
        System.out.println("Ford: " + testHashmap.get("Ford").toString());
        System.out.println("Michael: " + testHashmap.get("Alvin").toString());
        System.out.println("Load Value: " + testHashmap.load());
    }

    public static class primitiveHashMap {

        private int currentSize;
        private int maxSize;

        private Object[] bucketList;

        public primitiveHashMap(int size) {
            currentSize = 0;
            maxSize = size;
            bucketList = new Object[size];
        }

        public boolean set(String key, Object value) {
            if(currentSize == maxSize)
                return false;
            int keyHashcode = getHash(key);
            if(bucketList[keyHashcode] == null) {
                bucketList[keyHashcode] = value;
                currentSize++;
                return true;
            }
            if(bucketList[keyHashcode] != null) {
                bucketList[keyHashcode] = value;
                return true;
            }
            return false;
        }

        public Object get(String key) {
            int keyHashcode = getHash(key);
            if(bucketList[keyHashcode] == null) {
                return null;
            }
            return bucketList[keyHashcode];
        }

        public boolean delete(String key) {
            int keyHashcode = getHash(key);
            if(bucketList[keyHashcode] != null) {
                bucketList[keyHashcode] = null;
                currentSize--;
                return true;
            }
            return false;
        }

        public float load() {
            return (float)currentSize / maxSize;
        }

        private int getHash(String key) {
            return key.hashCode() % maxSize;
        }

    }
}