/**
 * Created by youfar on 15/6/22.
 */
public class ChainHashTable {
    static String[] HashTable;
    static int size;

    private class Key{
        String str;
        public Key(String s){
            this.str = s;
        }

        public boolean equals(Object obj){
            if(obj != null && obj instanceof Key){
                return this.str.equals(((Key)obj).str);
            }else{
                return false;
            }
        }

        public int hashCode(){
            int sum = 0;
            for(int i = 0; i < str.length(); i++){
                sum += (int)str.charAt(i);
            }
            return sum;
        }

        public String toString(){
            return str;
        }
    }

    private class Cell{
        Key key;
        String data;
        Cell next;

        private Cell(Key key, String data){
            this.key = key;
            this.data = data;
        }
    }

    //装数据的hashtable
    Cell[] table;
    //hashtable的大小
    int bucketSize;
    //数据个数
    int elementSize;

    //hashtable初始大小
    static final int DEFAULT_BUCKET_SIZE = 50;

    public ChainHashTable(int bucketSize){
        this.table = new Cell[bucketSize];
        this.bucketSize = bucketSize;
        this.elementSize = 0;
    }

    private int hash(Key key){
        return key.hashCode() % this.bucketSize;
    }

    public String search(String key){
        return this.search(new Key(key));
    }

    public String search(Key key){
        for(Cell cell = this.table[hash(key)]; cell != null; cell = cell.next){
            if(key.equals(cell.key)){
                return cell.data;
            }
        }
        return null;
    }

    public boolean insert(String key, String data){
        return this.insert(new Key(key), data);
    }

    public boolean insert(Key key, String data){
        if(search(key) != null)
            return false;

        Cell cell = new Cell(key, data);
        int hash = hash(key);
        cell.next = this.table[hash];
        this.table[hash] = cell;
        elementSize++;
        return true;
    }

    public boolean delete(String key){
        return this.delete(new Key(key));
    }

    public boolean delete(Key key) {
        int hash = hash(key);
        if(this.table[hash] == null){
            return false;
        }

        if(key.equals(this.table[hash].key)){
            Cell cell = this.table[hash];
            this.table[hash] = cell.next;
            elementSize--;
            return true;
        }

        for(Cell cellq = this.table[hash], cellp = cellq.next; cellp != null; cellq = cellp, cellp = cellp.next){
            if(key.equals(cellp.key)){
                cellq.next = cellp.next;
                elementSize--;
                return true;
            }
        }
        return false;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < this.bucketSize; i++){
            sb.append("bucket:").append(i).append(", ");
            for(Cell cell = table[i]; cell != null; cell = cell.next){
                sb.append("[key: ").append(cell.key).append(", data: ").append(cell.data).append("]");
            }
            sb.append("\n");
        }
        sb.append("元素个数：").append(this.elementSize);
        return sb.toString();
    }

    public static void main(String[] args) {
        ChainHashTable cht = new ChainHashTable(15);

        String[] words = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        for(int i = 0; i < words.length; i++){
            cht.insert(words[i], "登录顺序" + (i+1));
        }

        System.out.println(cht.toString());
        System.out.println();

        //search
        String[] keys1 = new String[]{"ten", "one", "ones"};
        String result;
        for(int i = 0; i < keys1.length; i++){
            result = cht.search(keys1[i]);
            if(result != null){
                System.out.println("检索成功");
            } else {
                System.out.println("检索失败");
            }
        }

        System.out.println();

        //delete
        String[] keys2 = new String[]{"ten", "tens"};
        for(int i = 0; i < keys2.length; i++){
            if(cht.delete(keys2[i])){
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        }

        System.out.println(cht.toString());
        System.out.println();

    }

}
