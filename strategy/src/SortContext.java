public class SortContext {
    private SortingStrategy sortingStrategy;

    public double executeSort(int[] array) {
        return sortingStrategy.getSortingTime(array);
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }
}
