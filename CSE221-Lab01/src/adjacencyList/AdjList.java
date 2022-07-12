package adjacencyList;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class AdjList {
	
	public static void main(String[] args) throws IOException {
		
		InputStream input = AdjList.class.getResourceAsStream("input.txt");
        LinkedList arr[];
        int numberOfEdges;
        Scanner sc = new Scanner(input);
        try {
        	String line = sc.next();
            int numberOfNodes = Integer.parseInt(line);
            arr = new LinkedList[numberOfNodes];
            numberOfEdges = Integer.parseInt(sc.next());
            for (int y = 0; y < numberOfNodes; y++) {
                LinkedList j = new LinkedList();
                arr[y] = j;
            }
            for (int i = 0; i < numberOfEdges; i++) {
                String line2 = sc.next();
                int edgeColumnOneValue = Integer.parseInt(line2);
                String line3 = sc.next();
                int edgeColumnTwoValue = Integer.parseInt(line3);
                LinkedList address = arr[edgeColumnOneValue];
                address.addLast(edgeColumnTwoValue);
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(i + "-->");
				LinkedList address = arr[i];
                int size = address.size();
                int count = 0;
                while (count != size) {
                    System.out.print(address.get(count));
                    if (count + 1 != size) {
                        System.out.print("-->");
                    }
                    count++;
                }
                System.out.println();
            }
        } catch(Exception e) {
			System.out.println(e);
		} finally {
			sc.close();
		}
    }
}
