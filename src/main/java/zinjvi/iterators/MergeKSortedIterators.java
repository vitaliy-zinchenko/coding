package zinjvi.iterators;

import zinjvi.Utils;

import java.util.*;

// https://leetcode.com/discuss/interview-question/345744/Google-or-Onsite-or-Merge-K-Sorted-Iterators

class MergingKSortedIterator implements Iterator<Integer> {

    private PriorityQueue<PeekItem> queue = new PriorityQueue<>();

    private static class PeekItem implements Comparable<PeekItem> {
        private Integer head;
        private Iterator<Integer> tail;
        public PeekItem(Iterator<Integer> iterator) {
            head = iterator.next();
            tail = iterator;
        }

        @Override
        public int compareTo(PeekItem other) {
            return head.compareTo(other.head);
        }
    }

    public MergingKSortedIterator(List<Iterator<Integer>> iterators) {
        if (iterators == null)
            return;

        for (Iterator<Integer> iterator: iterators) {
            addToQueueIfNasNext(iterator);
        }
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public Integer next() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException();
        }

        PeekItem item = queue.poll();
        addToQueueIfNasNext(item.tail);
        return item.head;
    }

    private void addToQueueIfNasNext(Iterator<Integer> iterator) {
        if (iterator.hasNext()) {
            queue.add(new PeekItem(iterator));
        }
    }
}

public class MergeKSortedIterators {

    public static void main(String[] args) {
        Iterator<Integer> ii = Arrays.asList(2, 5, 9).iterator();
        ii.next();

        List<Iterator<Integer>> iterators = Arrays.asList(
                Arrays.asList(2, 5, 9).iterator(),
                Collections.emptyIterator(),
                Arrays.asList(4, 10).iterator()
        );
        MergingKSortedIterator itr = new MergingKSortedIterator(iterators);
        Utils.assertTrue(itr.hasNext()); // true
        Utils.assertTrue(itr.next() == 2); // 2
        Utils.assertTrue(itr.next() == 4); // 4
        Utils.assertTrue(itr.next() == 5); // 5
        Utils.assertTrue(itr.next() == 9); // 9
        Utils.assertTrue(itr.next() == 10); // 10
        Utils.assertTrue(!itr.hasNext()); // false

        System.out.println("Going to fail!");
        itr.next(); // error
    }

}
