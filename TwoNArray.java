/**
 * Created by qpan on 8/31/2017.
 */
public class TwoNArray {
    public static void main(String []args){
        int[] kv = new int[] {0, 1, 2, 3, 4, 5, 6, -1};
        int key = 0;

        int v = searchkv(kv, key);


        System.out.println(v);
    }

    public static int searchkv(int[] kv, int key){
        boolean is_continue = true;
        int start = 0;
        int end = kv.length - 1;

        int returnValue = -1;

        while(is_continue){
            int partition = (end - start + 1) / 2;

            if(key < kv[start] || key > kv[end - 1] || (key > kv[partition -2] && key < kv[partition])){is_continue = false;}
            else if(key < kv[partition -2]){
                end = partition - 1;
                //go left
            }else if(key > kv[partition]){
                start = partition;
                //go right
            }else if(key == kv[partition -2]){
                returnValue = kv[partition -1];
                is_continue = false;
            }else{
                returnValue = kv[partition + 1];
                is_continue = false;
            }
        }
        return returnValue;
    }
}
