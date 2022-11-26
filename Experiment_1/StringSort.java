import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class StringSort {

    private final Sorter<String> passPerItemSorter = new BubbleSortPassPerItem<String>();
    private final Sorter<String> untilNoChangeSorter = new BubbleSortUntilNoChange<String>();
    private final Sorter<String> whileNeededSorter = new BubbleSortWhileNeeded<String>();

    private String[] generateRandomStrings(int length, int size){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        String[] strings = new String[size];

        for(int i = 0; i < size; i++){
            StringBuilder s = new StringBuilder(length);
            Random random = new Random();
            for(int j = 0; j < length;j++){
                int index = random.nextInt(alphabet.length());
                char charToAdd = alphabet.charAt(index);
                s.append(charToAdd);
            }
            strings[i] = s.toString();
        }
        return strings;
    }

    public void testAlgorithm() throws IOException {
        File file = new File("stringAlgorithmTest.txt");
        FileWriter out = new FileWriter(file);
        try {
            for(int i = 1;i<=5 ; i++){ // number of characters per string
                for(int k = 10; k<= 1000; k = k * 10){
                    String[] strings = generateRandomStrings(i,k);
                    for(int j = 0; j< 100; j++){
                        String[] whileNeededArray = Arrays.copyOf(strings,strings.length);
                        String[] passPerItemArray = Arrays.copyOf(strings,strings.length);
                        String[] untilNoChangeArray = Arrays.copyOf(strings,strings.length);

                        long startTimeWN = System.nanoTime();
                        whileNeededSorter.sort(whileNeededArray);
                        long endTimeWN = System.nanoTime();

                        long startTimePPI = System.nanoTime();
                        passPerItemSorter.sort(passPerItemArray);
                        long endTimePPI = System.nanoTime();

                        long startTimeUNC = System.nanoTime();
                        untilNoChangeSorter.sort(untilNoChangeArray);
                        long endTimeUNC = System.nanoTime();
                        out.write("Characters: " + i + ",WN: " + (endTimeWN - startTimeWN) + ",PPI: " + (endTimePPI - startTimePPI) + ",UNC: " + (endTimeUNC - startTimeUNC) + ",Count" + k);
                        out.write('\n');
                        strings = generateRandomStrings(i,k);
                    }
                }
            }
            out.close();
        }catch (IOException e){
            e.printStackTrace();

        }
    }
    public static void main(String[] args) throws IOException{
        StringSort sorter = new StringSort();
        sorter.testAlgorithm();
    }


}





