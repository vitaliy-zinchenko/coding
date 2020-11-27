package zinjvi.iterators;

import zinjvi.Utils;

import java.util.*;

// https://leetcode.com/discuss/interview-question/345744/Google-or-Onsite-or-Merge-K-Sorted-Iterators

class Merging2SortedIterator implements Iterator<Integer> {

    private Integer leftHead;
    private Integer rightHead;
    private Iterator<Integer> leftTail;
    private Iterator<Integer> rightTail;

    public Merging2SortedIterator(Iterator<Integer> leftIter, Iterator<Integer> rightIter) {
        updateLeft(leftIter);
        updateRight(rightIter);
    }

    private void updateLeft(Iterator<Integer> leftIter) {
        if(leftIter != null && leftIter.hasNext()) {
            leftHead = leftIter.next();
            leftTail = leftIter;
        } else {
            leftHead = null;
        }
    }

    private void updateRight(Iterator<Integer> rightIter) {
        if(rightIter != null && rightIter.hasNext()) {
            rightHead = rightIter.next();
            rightTail = rightIter;
        } else {
            rightHead = null;
        }
    }

    public boolean hasNext() {
        return leftHead != null || rightHead != null;
    }

    public Integer next() {
        if (leftHead == null && rightHead == null) {
            throw new NoSuchElementException();
        }

        Integer result;

        if (rightHead == null) {
            result = leftHead;
            updateLeft(leftTail);
        } else if (leftHead == null) {
            result = rightHead;
            updateRight(rightTail);
        } else if (leftHead < rightHead) {
            result = leftHead;
            updateLeft(leftTail);
        } else {
            result = rightHead;
            updateRight(rightTail);
        }

        return result;
    }
}

public class Merge2SortedIterators {

    public static void main(String[] args) {
        Merging2SortedIterator itr = new Merging2SortedIterator(Arrays.asList(2, 5, 9).iterator(), Arrays.asList(4, 10).iterator());
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
