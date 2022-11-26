import java.io.*;
import java.util.Arrays;
import java.util.Random;


public class IntegerSort {
    private final Sorter<Integer> passPerItemSorter = new BubbleSortPassPerItem<>(); // passPerItem algorithm
    private final Sorter<Integer> untilNoChangeSorter = new BubbleSortUntilNoChange<>(); // untilNoChange algorithm
    private final Sorter<Integer> whileNeededSorter = new BubbleSortWhileNeeded<>(); // whileNeeded algorithm

    /*
    Method used for generating random integers of given length and given number of elements
    @param int length - the desired digits for an integer
    @param int size - number of elements in the array
     */
    private Integer[] generateRandomIntegers(int length, int size){
        var max = 10; // max possible value of integers
        var min = 0; // min possible value of integers

        for(int i = 1 ;i < length;i++){
            min = max;
            max = max * 10;
        }

        Integer[] integers = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            integers[i] = random.nextInt(max - min + 1) + min ;
        }
        return integers;
    }

    /*
    Method used to run and test the PassPerItem algorithm
     */
    public void intPassPerItem() throws IOException{
        File file = new File("intPassPerItem.txt"); //file used to store the result of the computation
        FileWriter outfile = new FileWriter(file);
        try {
            for (int i = 1; i <= 5; i++) { //number of digits per integer
                for(int k = 10;k <= 1000;k = k * 10){ //total number of integers in the array
                    Integer[] integers = generateRandomIntegers(i,k);
                    for(int j = 0 ; j < 100; j++){
                        long startTime = System.nanoTime();
                        passPerItemSorter.sort(integers);
                        long endTime = System.nanoTime();
                        System.out.println("PassPerItemSorter: " + i + " " + (endTime - startTime));
                        outfile.write("Digits: " + i + ",Time: " + (endTime - startTime) + ",Count" + k);
                        outfile.write('\n');
                        integers = generateRandomIntegers(i,k);
                    }
                }
            }
            outfile.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /*
    Method used to run and test the UntilNoChange algorithm
     */
    public void intUntilNoChange() throws IOException{
        File file = new File("intUntilNoChange.txt"); //file used to store the result of the computation
        FileWriter outfile = new FileWriter(file);
        try {
            for (int i = 1; i <= 5; i++) {
                for(int k = 10; k<= 1000; k = k * 10){
                    Integer[] integers = generateRandomIntegers(i,k);
                    for(int j = 0 ; j < 100; j++){
                        long startTime = System.nanoTime();
                        untilNoChangeSorter.sort(integers);
                        long endTime = System.nanoTime();
                        System.out.println("UntilNoChange: " + i + " " + (endTime - startTime));
                        outfile.write("Digits: " + i + ",Time: " + (endTime - startTime) + ",Count" + k);
                        outfile.write('\n');
                        integers = generateRandomIntegers(i,k);
                    }
                }
            }
            outfile.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /*
    Method used to run and test the WhileNeeded algorithm
     */
    public void intWhileNeeded() throws IOException{
        File file = new File("intWhileNeeded.txt"); //file used to store the result of the computation
        FileWriter outfile = new FileWriter(file);
        try {
            for (int i = 1; i <= 5; i++) {
                for(int k = 10; k<= 1000; k = k * 10){
                    Integer[] integers = generateRandomIntegers(i,k);
                    for(int j = 0 ; j < 100; j++){
                        long startTime = System.nanoTime();
                        whileNeededSorter.sort(integers);
                        long endTime = System.nanoTime();
                        System.out.println("WhileNeeded: " + i + " " + (endTime - startTime));
                        outfile.write("Digits: " + i + ",Time: " + (endTime - startTime) + ",Count" + k);
                        outfile.write('\n');
                        integers = generateRandomIntegers(i,k);
                    }
                }
            }
            outfile.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /*
    Method used to run and test the three algorithms, with the same arrays
     */
    public void testAlgorithms() throws IOException{
        File file = new File("intAlgorithmTest.txt");
        FileWriter outfile = new FileWriter(file);
        try {
            for (int i = 1; i <= 5; i++) {
                for(int k = 10; k<= 1000; k = k * 10){
                    Integer[] integers = generateRandomIntegers(i,k);
                    for(int j = 0 ; j < 100; j++){
                        Integer[] whileNeededArray = Arrays.copyOf(integers,integers.length);
                        Integer[] passPerItemArray = Arrays.copyOf(integers,integers.length);
                        Integer[] untilNoChangeArray = Arrays.copyOf(integers,integers.length);

                        long startTimeWN = System.nanoTime();
                        whileNeededSorter.sort(whileNeededArray);
                        long endTimeWN = System.nanoTime();

                        long startTimePPI = System.nanoTime();
                        passPerItemSorter.sort(passPerItemArray);
                        long endTimePPI = System.nanoTime();

                        long startTimeUNC = System.nanoTime();
                        untilNoChangeSorter.sort(untilNoChangeArray);
                        long endTimeUNC = System.nanoTime();
                        outfile.write("Digits: " + i + ",WN: " + (endTimeWN - startTimeWN) + ",PPI: " + (endTimePPI - startTimePPI) + ",UNC: " + (endTimeUNC - startTimeUNC) + ",Count" + k);
                        outfile.write('\n');
                        integers = generateRandomIntegers(i,k);
                    }
                }
            }
            outfile.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        IntegerSort sort = new IntegerSort();
        sort.intWhileNeeded();
        sort.intPassPerItem();
        sort.intUntilNoChange();
        sort.testAlgorithms();
    }
}
