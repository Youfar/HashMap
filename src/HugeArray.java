/**
 * Created by youfar on 15/6/22.
 */
import java.util.Random;
public class HugeArray {

    int[] Huge = new int[100];
    int[] smallKeyStack = new int[10];
    int[] smallValueStack = new int[10];

    public int BigArraySearch(int k){
        int p = Huge[k];
        if(p > 0 && p <= smallKeyStack[0] && smallKeyStack[p] == k)
            return p;
        return 0;
    }

    public int BigArrayInsert(int k, int v){

        if(k == BigArraySearch(k)){
            System.out.println("already in");
            return 0;
        }

        smallKeyStack[0]++;
        smallKeyStack[smallKeyStack[0]] = k;
        smallValueStack[smallKeyStack[0]] = v;
        Huge[k] = smallKeyStack[0];
        return smallKeyStack[0];
    }

    public int BigArrayDelete(int k){
        int ret = BigArraySearch(k);
        if(ret == 0){
            System.out.println("already in");
            return 0;
        }
        smallKeyStack[Huge[k]] = smallKeyStack[smallKeyStack[0]];
        smallValueStack[Huge[k]] = smallValueStack[smallKeyStack[0]];
        Huge[smallKeyStack[Huge[k]]] = Huge[k];
        Huge[k] = 0;
        smallKeyStack[0]--;
        return ret;
    }

    public void BigArrayPrint(){
        int i;
        for(i = 1;i <= smallKeyStack[0]; i++)
            System.out.println(smallKeyStack[i] + ":" + smallValueStack[i]);
    }

    public static void main(String[] args) {
        Random r = new Random();
        HugeArray ba = new HugeArray();
        for(int i = 0; i < 100; i++)
        {
            ba.Huge[i] = r.nextInt(100);
        }

        ba.BigArrayInsert(15, 20);
        ba.BigArrayInsert(20, 25);
        ba.BigArrayDelete(15);
        ba.BigArrayInsert(30, 35);
        ba.BigArrayPrint();

        int a = ba.BigArraySearch(20);
        int b = ba.BigArraySearch(40);
        System.out.println(a);
        System.out.println(b);



    }









}

