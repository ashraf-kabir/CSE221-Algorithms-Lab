package heapSort;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class HeapSort {
	public static void main(String[] args) throws IOException {
		int n, i;
		InputStream input = HeapSort.class.getResourceAsStream("input.txt");
		Scanner sc = new Scanner(input);
		try {
			int c = 1;
			int array[] = new int[10];
			
			while (sc.hasNext()) {
				int num = sc.nextInt();
				if (c == -1) {
					c++;
					array = new int [num];
				} else {
					array[c] = num;
					c++;
				}
			}
			sort(array);
			for (i = 1; i <= array.length-1; i++) {
				System.out.print(array[i]+ " ");
            }
        } catch(Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}
    }
    
    private static int N;
    
    public static void sort(int array[]) {
        buildHeap(array);
        for (int i = N; i > 0; i--) {
            swap(array,0, i);
            N = N-1;
            maxHeap(array, 0);
        }
    }
    
    public static void buildHeap(int array[]) {
        N = array.length-1;
        for (int i = N/2; i >= 0; i--) {
        	maxHeap(array, i);
        }
    }     
    
    public static void maxHeap(int array[], int i) {
        int left = 2*i;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && array[left] > array[i]) {
            max = left;
        }
        if (right <= N && array[right] > array[max]) {
            max = right;
        }
        if (max != i) {
            swap(array, i, max);
            maxHeap(array, max);
        }
    }
    
    public static void swap(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
