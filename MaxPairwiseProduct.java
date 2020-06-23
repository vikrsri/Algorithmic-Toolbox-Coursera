package Assignments;

import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
	
    static int getMaxPairwiseProduct(int[] numbers) {
        int max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product, numbers[first] * numbers[second]);
            }
        }
        return max_product;
    }
    
    static long getMaxPairwiseProductFast(int[] numbers)
    {
    	int index1 = 0;
    	for (int i = 1; i < numbers.length; i++)
    	{
    		if(numbers[i] > numbers[index1])
    			index1 = i;
    	}
    	int index2;
    	if (index1 == 0) 
    	{
    		index2 = 1;
    	}
    	else 
    	{
    		index2 = 0;
    	}
    	for (int j = 0; j < numbers.length; j++)
    	{
    		if ((j != index1) && (numbers[j] > numbers[index2]))
    			index2 = j;
    	}
    	long result = (long) numbers[index1] * (long) numbers[index2];
    	return result;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        /*
        int n2 = 200001;
        int[] numbers2 = new int[n2];
        for (int j = 0; j < n2; j++)
        	numbers2[j] = j; */
        
        System.out.println(getMaxPairwiseProductFast(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}