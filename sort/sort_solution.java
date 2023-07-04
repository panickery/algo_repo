import java.util.Random;
import java.util.Scanner;

public class Solution {

    public static void bubbleSort(int arrNum) {
        int[] arr = new int[arrNum];
        randomArr(arr);
        System.out.println("---- 정렬되기 전 배열값 ---- ");

        for(int i = 0; i < arr.length; i++)
            System.out.printf("%d ", arr[i]);

        System.out.println("\n----------------------------");

        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr.length - i - 1; j++)
            {
                if (arr[j] > arr[j+1])
                {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("---- 정렬된 후 배열값 ---- ");

        for(int i = 0; i < arr.length; i++)
            System.out.printf("%d ", arr[i]);

        System.out.println("\n---------------------------- ");
    }

    public static void mergeSort(int arrNum)
    {
        int[] arr = new int[arrNum];
        randomArr(arr);
        System.out.println("---- 정렬되기 전 배열값 ---- ");

        for(int i = 0; i < arr.length; i++)
            System.out.printf("%d ", arr[i]);

        System.out.println("\n----------------------------");
        mergeSortRecursive(arr.length, arr);
        System.out.println("---- 정렬된 후 배열값 ---- ");

        for(int i = 0; i < arr.length; i++)
            System.out.printf("%d ", arr[i]);

        System.out.println("\n---------------------------- ");
    }

    public static void mergeSortRecursive(int n, int[] arr)
    {
        if(n > 1)
        {
            int h = n/2;
            int m = n-h;
            int[] u = new int[h];
            int[] v = new int[m];

            for(int i = 0; i < h; i++)
                u[i] = arr[i];

            for(int j = 0; j < m; j++)
                v[j] = arr[h + j];

            mergeSortRecursive(h, u);
            mergeSortRecursive(m, v);
            merge(h, m, u, v, arr);
        }
    }

    public static void merge(int h, int m, int[] u, int[] v, int[] arr)
    {
        int i, j, k;

        i = 0; j = 0; k = 0;

        while(i < h && j < m)
        {
            if(u[i] < v[j])
            {
                arr[k] = u[i];
                i++;
            }
            else
            {
                arr[k] = v[j];
                j++;
            }
            k++;
        }

        if(i >= h)
        {
            for(int tmp = 0; tmp < m-j; tmp++)
                arr[k+tmp] = v[tmp+j];
        }
        else
        {
            for(int tmp = 0; tmp < h-i; tmp++)
                arr[k+tmp] = u[i+tmp];
        }
    }

    public static void randomArr(int[] arr)
    {
        Random rand = new Random();

        for(int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(arr.length) + 1;
//            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        scan.close();

        bubbleSort(k);
        mergeSort(k);
    }
}