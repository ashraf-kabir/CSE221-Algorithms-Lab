package adjacencyMatrix;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class AdjMatrix {
	
	public static void main(String[] args) throws IOException {
        
		InputStream input = AdjMatrix.class.getResourceAsStream("graph.txt");
		
		Scanner sc = new Scanner(input);

        int vertex = sc.nextInt();

        int[][] arr = new int[vertex + 1][vertex + 1];

        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for (int row = 0; row < arr.length; row++) {
            for (int coloumn = 0; coloumn < arr[row].length; coloumn++) {
                System.out.print(arr[row][coloumn] + " ");
            }
            System.out.println();
        }
    }

}
