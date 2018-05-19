/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/5/19 12:25
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package Chapter09SegmentTree.Section2To6;

public class Main {
    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        // 用于求和的线段树
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
        System.out.println(segmentTree);
    }
}
