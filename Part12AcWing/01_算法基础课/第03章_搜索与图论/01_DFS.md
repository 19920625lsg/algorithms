# 01_DFS

## 题目
### [AcWing 842.排列数字](https://www.acwing.com/problem/content/844/)
```java
import java.util.*;

public class Main {
    private static boolean[] visited;
    private static int n;

    static void dfs(int num, List<Integer> path) {
        visited[num] = true;
        path.add(num);
        if (path.size() == n) {
            // 输出路径
            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    System.out.println(path.get(i));
                    break;
                }
                System.out.print(path.get(i) + " ");
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i, path);
                // 递归回退，记得弹出元素
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            dfs(i, new ArrayList<>());
        }
    }
}
```

### [AcWing 843.n-皇后问题](https://www.acwing.com/problem/content/845/)
```java
import java.util.*;

public class Main {
    private static int n;
    private static boolean[][] visited; // 节点访问数组

    // 检查位置(r, c)处放置皇后是否和之前放地冲突
    private static boolean check(int r, int c, List<int[]> points) {
        for (int[] point : points) {
            // 同一行 or 同一列则不能放，直接返回
            if (point[0] == r || point[1] == c) return false;
            // 斜率为1表明在一条斜线上，直接返回，不和上面的条件合并是为了防止point[1] - c值为0
            double k = Math.abs((point[0] - r) * 1.0 / (point[1] - c)); // 注意斜率为负数的情况
            if (k == 1.0) return false;
        }
        return true;
    }

    private static void dfs(int r, int c, List<int[]> points) {
        visited[r][c] = true;
        points.add(new int[]{r, c});
        if (points.size() == n) { // 找到了一个合适的放置方案
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) sb.append("Q");
                    else sb.append(".");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
            return;
        }

        // 上面的点满足条件了，则下一个必须从下一行开始了
        if (r + 1 < n) { // 行必须在合适的范围
            for (int i = 0; i < n; i++) { // 固定行，遍历列
                if (!visited[r + 1][i] && check(r + 1, i, points)) {
                    dfs(r + 1, i, points);
                    visited[r + 1][i] = false;
                    points.remove(points.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        for (int i = 0; i < n; i++) { // 第一个起始的元素肯定是在第1行
            List<int[]> points = new ArrayList<>(); // 记录皇后放置的位置
            visited = new boolean[n][n]; // 每次开始的位置不一样，所以要重置访问数组
            dfs(0, i, points);
        }
    }
}
```