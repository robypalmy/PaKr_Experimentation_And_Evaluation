public class ByteSort {
    private final Sorter<Byte> passPerItemSorter = new BubbleSortPassPerItem<Byte>();
    private final Sorter<Byte> untilNoChangeSorter = new BubbleSortUntilNoChange<Byte>();
    private final Sorter<Byte> whileNeededSorter = new BubbleSortWhileNeeded<Byte>();

    private Byte[] generateRandomBytes(int length, int count){
        Byte[] bytes = new Byte[count];
        for (int i = 0; i < count; i++) {
            bytes[i] = (byte) (Math.random() * length);
        }
        return bytes;
    }

    public static void main(String[] args) {
        ByteSort byteSort = new ByteSort();
        for (int i = 1; i <= 100; i++) {
            Byte[] bytes = byteSort.generateRandomBytes(i, 1000);
            long startTime = System.nanoTime();
            byteSort.passPerItemSorter.sort(bytes);
            long endTime = System.nanoTime();
            System.out.println("PassPerItemSorter: " + i + " " + (endTime - startTime));
        }
        for (int i = 1; i <= 100; i++) {
            Byte[] bytes = byteSort.generateRandomBytes(i, 1000);
            long startTime = System.nanoTime();
            byteSort.untilNoChangeSorter.sort(bytes);
            long endTime = System.nanoTime();
            System.out.println("UntilNoChangeSorter: " + i + " " + (endTime - startTime));
        }
        for (int i = 1; i <= 100; i++) {
            Byte[] bytes = byteSort.generateRandomBytes(i, 1000);
            long startTime = System.nanoTime();
            byteSort.whileNeededSorter.sort(bytes);
            long endTime = System.nanoTime();
            System.out.println("WhileNeededSorter: " + i + " " + (endTime - startTime));
        }
    }

}
