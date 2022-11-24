public class DoubleSort {
    private final Sorter<Double> passPerItemSorter = new BubbleSortPassPerItem<Double>();
    private final Sorter<Double> untilNoChangeSorter = new BubbleSortUntilNoChange<Double>();
    private final Sorter<Double> whileNeededSorter = new BubbleSortWhileNeeded<Double>();

    private Double[] generateRandomDoubles(int length, int count){
        Double[] doubles = new Double[count];
        for (int i = 0; i < count; i++) {
            doubles[i] = (double) (Math.random() * length);
        }
        return doubles;
    }

    public static void main(String[] args) {
        DoubleSort doubleSort = new DoubleSort();
        for (int i = 1; i <= 100; i++) {
            Double[] doubles = doubleSort.generateRandomDoubles(i, 1000);
            long startTime = System.nanoTime();
            doubleSort.passPerItemSorter.sort(doubles);
            long endTime = System.nanoTime();
            System.out.println("PassPerItemSorter: " + i + " " + (endTime - startTime));
        }
        for (int i = 1; i <= 100; i++) {
            Double[] doubles = doubleSort.generateRandomDoubles(i, 1000);
            long startTime = System.nanoTime();
            doubleSort.untilNoChangeSorter.sort(doubles);
            long endTime = System.nanoTime();
            System.out.println("UntilNoChangeSorter: " + i + " " + (endTime - startTime));
        }

        for (int i = 1; i <= 100; i++) {
            Double[] doubles = doubleSort.generateRandomDoubles(i, 1000);
            long startTime = System.nanoTime();
            doubleSort.whileNeededSorter.sort(doubles);
            long endTime = System.nanoTime();
            System.out.println("WhileNeededSorter: " + i + " " + (endTime - startTime));
        }
    }
}
