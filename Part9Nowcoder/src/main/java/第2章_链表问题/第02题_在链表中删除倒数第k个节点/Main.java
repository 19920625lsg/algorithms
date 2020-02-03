/***********************************************************
 * @Description : 第02题_在链表中删除倒数第k个节点
 * https://www.nowcoder.com/practice/e5d90aac4c8b4628aa70d9b6597c0560
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2020/1/29 12:18
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package 第2章_链表问题.第02题_在链表中删除倒数第k个节点;

import 第2章_链表问题.LinkedListTool;
import 第2章_链表问题.Node;

import java.util.Scanner;

public class Main {
    public static Node removeLastKthNode(Node head, int k) {
        if (head == null || k < 1) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            k--;
            cur = cur.next;
        }
        if (k == 0) {
            // 倒数第k个节点正好是链表头结点
            head = head.next;
        }
        if (k < 0) {
            cur = head;
            while (++k != 0) {
                cur = cur.next;
            }
            // 找到倒数第k个节点的前一个节点了
            cur.next = cur.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        Node head = LinkedListTool.create(nums);
        Node newHead = removeLastKthNode(head, k);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}
