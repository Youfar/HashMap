/**
 * Created by youfar on 15/6/22.
 */
public class OpenHashTable {

    class Entry {
        int key;
        String data;

        public Entry(int key, String data){
            this.key = key;
            this.data = data;
        }
    }

    final static int MAX = 100;

    Entry[] table = new Entry[MAX];

    int n = 0;

    public void insert(int key, String data){
        if(n >= MAX) {
            System.err.println("too much data");
            System.exit(1);
        }
        table[n++] = new Entry(key, data);
    }

    public String search(int key){
        for(int i = 0; i < n; i++){
            if(table[i].key == key){
                return table[i].data;
            }
        }
        return null;
    }

    public void delete(int key){
        if(n <= 0){
            System.err.println("this data is not insert");
            System.exit(1);
        }
        for(int i = 0; i < n; i++){
            if(table[i].key == key){
                if(i+1 < n){
                    table[i] = table[i+1];
                }
            }
        }
        table[--n] = null;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append("key: ").append(table[i].key).append(", value: ").append(table[i].data).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        OpenHashTable table = new OpenHashTable();
        System.out.println(table.toString());

        table.insert(1, "one");
        table.insert(10, "ten");
        table.insert(2, "two");
        table.insert(5, "five");
        System.out.println(table.toString());

        //search
        String x = table.search(10);
        if(x != null){
            System.out.println("find");
        } else {
            System.out.println("not found");
        }
        System.out.println();

        //delete
        table.delete(2);
        System.out.println(table.toString());
        table.delete(5);
        System.out.println(table.toString());



    }


}
