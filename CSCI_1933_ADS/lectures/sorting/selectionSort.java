// Select.java
// selection sort
// Source originally derived from Wikipedia "selection sort" page 9/3/2013
// Revised 2/2020
public class selectionSort {
public static void sort(int[] a) {
    int i, j, minIndex, temp;
    int counter = 0;
    for (i = 0; i < a.length - 1; i++) {
        minIndex = i;
        for (j = i+1; j < a.length; j++) {
            counter++;
            if (a[j] < a[minIndex])
              minIndex = j;
        }
        temp = a[minIndex];
        a[minIndex] = a[i];
        a[i] = temp;
        System.out.println("list after iteration: " + counter);
        display(a);
    }
    System.out.println("Iterations through inner loop: " + counter);
}  // selectionSort
public static void display(int[] a) {
    int i;
    for (i = 0; i < a.length; i++)
        System.out.print(a[i]);
    System.out.println();
}  // display
public static void main(String[] args) {
    int a[] = {4, 5, 2, 7, 6, 1, 3};
    int b[] = {1, 2, 3, 4, 5, 6, 7};
    int c[] = {7, 6, 5, 4, 3, 2, 1};
    System.out.println("Selection sort ...");
    System.out.println("\nFirst array:");
    display(a);
    sort(a);
    display(a);
    System.out.println("\nSecond array:");
    display(b);
    sort(b);
    display(b);
    System.out.println("\nThird array:");
    display(c);
    sort(c);
    display(c);
}
}  // Select