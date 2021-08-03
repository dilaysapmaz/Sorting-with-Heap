/*Author: Dilay Sapmaz
 * ID= 041701032
 * Date: 30.12.2018
 * This code sorting an array with 3 different sort and compares every sort with their milliseconds.
 */


package SortingWithHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class dilay_sapmaz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int SIZE= 40000; //constant size
		Random random =new Random();
		Integer[] array = new Integer[SIZE];

		for(int i=0; i<array.length;i++) {
			array[i]=random.nextInt(9999999)+1; //it assign random values
		}
		Integer[] array1 = array.clone(); //its for mixed after every calculations with average and milliseconds.
		Integer[] array2 = array.clone(); // '' for not occur any mistake, I mixed.
		

		System.out.println("Array Size: " + SIZE);

		
		//first heap
		//with milliseconds
		System.out.println("Heap Sort"); 
		double sumhs = 0; //sum for heap sort milliseconds
		double averagehs=0; // average for heap sort milliseconds
		for(int i=1; i<=10; i++) {
			double start = System.nanoTime(); // code to measure timing
			heapSort(array1);
			double finish = System.nanoTime(); // code to measure timing
			double elapsedTimeMilliSeconds = (finish - start) / 1000000.0; //convert nanoseconds to milliseconds
			System.out.print(i + ": " );
			sumhs = sumhs + elapsedTimeMilliSeconds;
			averagehs = sumhs/10;
			System.out.println(elapsedTimeMilliSeconds + " ms");
			for(int b=0; b<array.length;b++) {
				array[b]=random.nextInt(9999999)+1;
			}
		}
		System.out.println("Average Sort Time for Heap Sort= " + averagehs);
		
		
		

		//second java sort
		//with milliseconds
		System.out.println("Java Array Sort");
		double sumjs = 0; // sum for java sort milliseconds
		double averagejs=0; //average for jav asort milliseconds
		for(int i=1; i<=10; i++) {
			double start = System.nanoTime(); // code to measure timing
			Arrays.sort(array2);

			double finish = System.nanoTime(); // code to measure timing
			double elapsedTimeMilliSeconds = (finish - start) / 1000000.0; //convert nanoseconds to milliseconds
			System.out.print(i + ": " );
			sumjs = sumjs + elapsedTimeMilliSeconds;
			averagejs = sumjs/10;
			System.out.println(elapsedTimeMilliSeconds + " ms");
			for(int c=0; c<array.length;c++) {
				array[c]=random.nextInt(9999999)+1;
			}
		}
		System.out.println("Average Sort Time for Java Sort= " + averagejs);
		
		
		
		
		//third selection sort  
		//with milliseconds
		System.out.println("Selection Sort");
		double sumss = 0; //sum for selection sort milliseconds
		double averagess=0;// average for selection sort milliseconds
		for(int i=1; i<=10; i++) {
			double start = System.nanoTime(); // code to measure timing
			selectionSort(array);
			double finish = System.nanoTime(); // code to measure timing
			double elapsedTimeMilliSeconds = (finish - start) / 1000000.0; //convert nanoseconds to milliseconds
			System.out.print(i + ": " );
			sumss = sumss + elapsedTimeMilliSeconds;
			averagess = sumss/10;
			System.out.println(+ elapsedTimeMilliSeconds + " ms");
			for(int a=0; a<array.length;a++) {
				array[a]=random.nextInt(9999999)+1;
			}
		}
		System.out.println("Average Sort Time for Selection Sort= " + averagess);
	}

	public static void heapSort(Integer[] list) { //this method sorts with heap sort.

		Heap<Integer> heap = new Heap<>();
		ArrayList<Integer> sortedArrayList = new ArrayList<>(); 

		for(int i=0; i<sortedArrayList.size(); i++) {
			heap.add(list[i]);
			for(int j=0; j<sortedArrayList.size();j++) {
				int a = heap.remove();
				sortedArrayList.add(a);
			}
		}
	}

	public static void selectionSort(Integer[] list) { //this method sorts with selection sort

		for (int i = 0; i < list.length - 1; i++) {  
			int index = i;  
			for (int j = i + 1; j < list.length; j++){  
				if (list[j] < list[index]){  
					index = j;//searching for lowest index  
				}  
			}  
			int smallerNumber = list[index];   
			list[index] = list[i];  
			list[i] = smallerNumber;  

		}  

	}
}
