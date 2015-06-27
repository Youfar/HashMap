import java.awt.*;
import java.util.Dictionary;
import java.util.Enumeration;

/**
 * Created by youfar on 15/6/22.
 */
public class UseDAT {

    public static void main(String[] args) {
        DirectAddressTable<String,String> dic = new DirectAddressTable<String, String>(10);
        dic.insert("AB1", "ATGC");
        dic.insert("C12", "GCTA");
        dic.insert("3D4", "GTTTG");
        dic.insert("2ds", "GTTA");
        String result = dic.search("2ds");
        dic.delete("3D4");
        System.out.println(result);

        Enumeration<String> keys = dic.keys();
        while(keys.hasMoreElements()){
            System.out.print(keys.nextElement() + " ");
        }
        System.out.println();
        Enumeration<String> elements = dic.elements();
        while(elements.hasMoreElements()){
            System.out.print(elements.nextElement() + " ");
        }
        System.out.println();

        dic.delete("3d4");




    }
}
