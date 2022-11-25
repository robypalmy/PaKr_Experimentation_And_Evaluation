public class StringSort {

    private final Sorter<String> passPerItemSorter = new BubbleSortPassPerItem<String>();
    private final Sorter<String> untilNoChangeSorter = new BubbleSortUntilNoChange<String>();
    private final Sorter<String> whileNeededSorter = new BubbleSortWhileNeeded<String>();


}


