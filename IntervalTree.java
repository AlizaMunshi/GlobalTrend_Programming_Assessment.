package Assignment;

import java.util.ArrayList;
import java.util.List;

class IntervalTree {

    private class IntervalNode {
        int start, end, maxEnd;
        IntervalNode left, right;

        IntervalNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.maxEnd = end;
        }
    }

    private IntervalNode root;

    public void insertInterval(int start, int end) {
    	System.out.println("Interval inserting for "+start+", "+end);
        root = insert(root, start, end);
    }

    public void deleteInterval(int start, int end) {
    	System.out.println("Delete interval for "+start+", "+end);
        root = delete(root, start, end);
    }

    public List<int[]> findOverlappingIntervals(int start, int end) {
    	System.out.println("Find overlapping interval for "+start+", "+end);
        List<int[]> result = new ArrayList<>();
        findOverlappingIntervals(root, start, end, result);
        return result;
    }

    private IntervalNode insert(IntervalNode node, int start, int end) {
        if (node == null) {
            return new IntervalNode(start, end);
        }

        if (start < node.start) {
            node.left = insert(node.left, start, end);
        } else {
            node.right = insert(node.right, start, end);
        }

        node.maxEnd = Math.max(node.maxEnd, end);
        return node;
    }

    private IntervalNode delete(IntervalNode node, int start, int end) {
        if (node == null) {
            return null;
        }

        if (start < node.start) {
            node.left = delete(node.left, start, end);
        } else if (start > node.start) {
            node.right = delete(node.right, start, end);
        } else if (node.start == start && node.end == end) {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            IntervalNode minLargerNode = getMin(node.right);
            node.start = minLargerNode.start;
            node.end = minLargerNode.end;
            node.right = delete(node.right, minLargerNode.start, minLargerNode.end);
        }

        node.maxEnd = Math.max(node.end, Math.max(getMaxEnd(node.left), getMaxEnd(node.right)));
        return node;
    }

    private void findOverlappingIntervals(IntervalNode node, int start, int end, List<int[]> result) {
        if (node == null) {
            return;
        }

        if (isOverlapping(node.start, node.end, start, end)) {
            result.add(new int[]{node.start, node.end});
        }

        if (node.left != null && node.left.maxEnd >= start) {
            findOverlappingIntervals(node.left, start, end, result);
        }

        findOverlappingIntervals(node.right, start, end, result);
    }

    private boolean isOverlapping(int start1, int end1, int start2, int end2) {
        return start1 <= end2 && start2 <= end1;
    }

    private IntervalNode getMin(IntervalNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private int getMaxEnd(IntervalNode node) {
        return node == null ? Integer.MIN_VALUE : node.maxEnd;
    }

    public static void main(String[] args) {
        IntervalTree tree = new IntervalTree();
        tree.insertInterval(15, 20);
        tree.insertInterval(10, 30);
        tree.insertInterval(17, 19);
        tree.insertInterval(5, 20);
        tree.insertInterval(12, 15);
        tree.insertInterval(30, 40);

        List<int[]> overlaps = tree.findOverlappingIntervals(6, 7); 
        for (int[] interval : overlaps) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }

        overlaps = tree.findOverlappingIntervals(14, 16); 
        for (int[] interval : overlaps) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }

        tree.deleteInterval(10, 30);
        overlaps = tree.findOverlappingIntervals(14, 16); 
        for (int[] interval : overlaps) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}