import java.io.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class IntegerSort {
    private final Sorter<Integer> passPerItemSorter = new BubbleSortPassPerItem<>();
    private final Sorter<Integer> untilNoChangeSorter = new BubbleSortUntilNoChange<>();
    private final Sorter<Integer> whileNeededSorter = new BubbleSortWhileNeeded<>();



    private Integer[] generateRandomIntegers(int length, int size){
        var max = 10;
        var min = 0;

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

    public void intPassPerItem() throws IOException{
        File file = new File("intPassPerItem.txt");
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

    public void intUntilNoChange() throws IOException{
        File file = new File("intUntilNoChange.txt");
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

    public void intWhileNeeded() throws IOException{
        File file = new File("intWhileNeeded.txt");
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
    public static void main(String[] args) throws IOException {
        IntegerSort sort = new IntegerSort();
        sort.intWhileNeeded();
        sort.intPassPerItem();
        sort.intUntilNoChange();
    }
}
