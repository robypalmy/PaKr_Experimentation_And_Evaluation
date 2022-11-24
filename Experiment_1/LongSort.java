public class LongSort {
    private Sorter<Long> passPerItemSorter = new BubbleSortPassPerItem<Long>();
    private Sorter<Long> untilNoChangeSorter = new BubbleSortUntilNoChange<Long>();
    private Sorter<Long> whileNeededSorter = new BubbleSortWhileNeeded<Long>();

    private Long[] generateRandomLongs(int length, int count){
        Long[] longs = new Long[count];
        for (int i = 0; i < count; i++) {
            longs[i] = (long) (Math.random() * length);
        }
        return longs;
    }

    public static void main(String[] args) {
        LongSort longSort = new LongSort();
        for (int i = 1; i <= 100; i++) {
            Long[] longs = longSort.generateRandomLongs(i, 1000);
            long startTime = System.nanoTime();
            longSort.passPerItemSorter.sort(longs);
            long endTime = System.nanoTime();
            System.out.println("PassPerItemSorter: " + i + " " + (endTime - startTime));
        }
        for (int i = 1; i <= 100; i++) {
            Long[] longs = longSort.generateRandomLongs(i, 1000);
            long startTime = System.nanoTime();
            longSort.untilNoChangeSorter.sort(longs);
            long endTime = System.nanoTime();
            System.out.println("UntilNoChangeSorter: " + i + " " + (endTime - startTime));
        }

        for (int i = 1; i <= 100; i++) {
            Long[] longs = longSort.generateRandomLongs(i, 1000);
            long startTime = System.nanoTime();
            longSort.whileNeededSorter.sort(longs);
            long endTime = System.nanoTime();
            System.out.println("WhileNeededSorter: " + i + " " + (endTime - startTime));
        }
    }
}
