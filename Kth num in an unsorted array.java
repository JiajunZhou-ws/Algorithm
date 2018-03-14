import java.lang.reflect.Field;
import java.lang.reflect.Method;


class Test
{
    public static int partition(Integer[] arr, int l, int r)
    {
        int pivot = arr[r];
        int i = l - 1;
        for(int j = l; j<r; j++)
        {
            if(arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = temp;
        return i + 1;
    }
    public static void printarray(Integer[] arr)
    {
        for(int each:arr)
            System.out.print(each + " ");
        System.out.println("\n");

    }

    public static int kthSmallest(Integer[] arr, int l, int r, int k)
    {
        if(k >0 && k <= r - l + 1) {
            int pos = partition(arr, l, r);
            System.out.print(pos + " \n");
            printarray(arr);
            if (pos - l == k - 1)
                return arr[pos];
            else if (pos < k - 1)
                return kthSmallest(arr,pos + 1,r,k-(pos - l) - 1);
            else
                return kthSmallest(arr,l,pos - 1,k);
        }
        return -1;
    }

    public static void main(String[] args)
    {
        Integer arr[] = new Integer[]{12, 3, 5, 7, 4, 19, 26};
        int k = 3;
        System.out.print( "K'th smallest element is " +
                kthSmallest(arr, 0, arr.length - 1, k) );
    }
}
