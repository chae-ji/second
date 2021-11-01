package com.with.second;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        for(int i = 0; i < C; i++){
            int N = sc.nextInt(); //6
            int L = sc.nextInt(); //3

            int[] arr = new int[N];
            double avgMin = 0;

            for(int j = 0; j < arr.length; j++){
                arr[j] = sc.nextInt();
            }

            for(int j = 0; j < arr.length; j++){

                double avg = 0;

                for(int k = 0; k < L + j; k++){
                    double sum = 0;
                    sum += arr[k];
                    avg = sum / L;
                }
                if(avgMin == 0){
                    avgMin = avg;
                }else if(avg < avgMin){
                    avgMin = avg;
                }
            }
            System.out.println(avgMin);
        }
    }
}

