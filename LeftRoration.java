package com.datastructure;

/**
 * Created by tinhv on 29/07/2016.
 */
public class LeftRoration {

//With O(d*n)
    public void method1(int[] arr, int d, int n){

        for(int i = 0; i < d; i++){
            for(int j = 0; j < n - 1; j++){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }

    }

//With O(n)
    public void method2(int[] arr, int d, int n){
        int j,k, temp;
        for(int i = 0; i < gcd(d,n); i++){
            temp = arr[0];
            j = i;
            while(true){
                k = j + d;
                if(k >= n){
                    k = k - n;
                }
                if(k == i){
                    break;
                }
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    public void printArr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public int gcd(int d, int n){
        if(n == 0){
            return d;
        }
        else{
            return gcd(n, d%n);
        }
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int d = in.nextInt();
//        int[] arr = new int[n];
//
//        for(int i = 0; i < n; i++){
//            arr[i] = in.nextInt();
//        }

        int[] arr = {1,2,3,4,5};
        LeftRoration lefR = new LeftRoration();
        lefR.method1(arr,4,5);
       // lefR.method2(arr,4,5);
        //lefR.printArr(arr);

        //System.out.println(lefR.gcd(2,7));
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i]);
        }

        System.out.println(lefR.gcd(4,5));


    }
}

