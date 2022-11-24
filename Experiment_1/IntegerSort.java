public class IntegerSort {
    private final Sorter<Integer> passPerItemSorter = new BubbleSortPassPerItem<>();
    private final Sorter<Integer> untilNoChangeSorter = new BubbleSortUntilNoChange<>();
    private final Sorter<Integer> whileNeededSorter = new BubbleSortWhileNeeded<>();

    private Integer[] generateRandomIntegers(int length, int count){
        Integer[] integers = new Integer[count];
        for (int i = 0; i < count; i++) {
            integers[i] = (int) (Math.random() * length);
        }
        return integers;
    }

    public static void main(String[] args) {
        IntegerSort integerSort = new IntegerSort();

        for (int i = 1; i <= 100; i++) {
            Integer[] integers = integerSort.generateRandomIntegers(i, 1000);
            long startTime = System.nanoTime();
            integerSort.passPerItemSorter.sort(integers);
            long endTime = System.nanoTime();
            System.out.println("PassPerItemSorter: " + i + " " + (endTime - startTime));
        }

        for (int i = 1; i <= 100; i++) {
            Integer[] integers = integerSort.generateRandomIntegers(i, 1000);
            long startTime = System.nanoTime();
            integerSort.untilNoChangeSorter.sort(integers);
            long endTime = System.nanoTime();
            System.out.println("UntilNoChangeSorter: " + i + " " + (endTime - startTime));
        }

        for (int i = 1; i <= 100; i++) {
            Integer[] integers = integerSort.generateRandomIntegers(i, 1000);
            long startTime = System.nanoTime();
            integerSort.whileNeededSorter.sort(integers);
            long endTime = System.nanoTime();
            System.out.println("WhileNeededSorter: " + i + " " + (endTime - startTime));
        }

    }


}
