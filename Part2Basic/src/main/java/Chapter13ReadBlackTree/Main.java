/***********************************************************
 * @Description : 红黑树的测试
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/10/03 11:47
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package Chapter13ReadBlackTree;

import Chapter07SetAndMap.Section1SetBasicAndBSTSet.FileOperation;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        String filename = "/Users/liangshanguang/Program/Algorithm/liuyubobobo-algorithms/Part2Basic/src/main/java/Chapter07SetAndMap/Section1SetBasicAndBSTSet/pride-and-prejudice.txt";
        if (FileOperation.readFile(filename, words)) {
            // 排序后看看性能，这样最能测AVL的实现好不好
            Collections.sort(words);
            System.out.println("Total words: " + words.size());

            RBTree<String, Integer> map = new RBTree<>();
            for (String word : words) {
                if (map.contain(word)) {
                    // 之前存在地话就词频+1
                    map.insert(word, map.get(word) + 1);
                } else {
                    // 不存在就插入进去，词频初始化为1
                    map.insert(word, 1);
                }
            }
            System.out.println("Total different words: " + map.size());
            // 出现pride和prejudice单词的次数
            System.out.println("Frequency of PRIDE : " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE : " + map.get("prejudice"));
        }
        System.out.println();
    }
}
