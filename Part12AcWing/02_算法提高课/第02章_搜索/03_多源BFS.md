# 多源BFS
> 一般尝试从终点向起点遍历，这样不用考虑多点之间的覆盖问题，一次性把所有终点加入进BFS的Queue，进行一遍BFS，最终的dis数组就是我们要的最小距离，和自己第一次专业级考试的第一题完全相同

## `自己没做出来，正向做法超时了`[173.矩阵距离](https://www.acwing.com/problem/content/description/175/)
```java
// 多源BFS要学会从终点开始遍历，互相之间不用覆盖即可。即逆向思维
import java.util.*;

// 在栅格中，字符为1且距离(i, j)最近的距离的点。即从(i, j)开始bfs，找第一个遇到点
public class Main {
    static int N, M;
    static char[][] grid;
    static int[][] dis;
    static boolean[][] visited;
    final static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    static boolean inGrid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
    
    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == '1') {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        while (!q.isEmpty()) {
            int[] point = q.remove();
            for (int[] dir : dirs) {
                int rNext = point[0] + dir[0];
                int cNext = point[1] + dir[1];
                if (inGrid(rNext, cNext) && !visited[rNext][cNext]) {
                    q.add(new int[]{rNext, cNext});
                    visited[rNext][cNext] = true;
                    dis[rNext][cNext] = dis[point[0]][point[1]] + 1;
                }
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        dis = new int[N][M];
        grid = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) grid[i] = sc.next().trim().toCharArray();
        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) sb.append(dis[i][j]).append(" ");
            if (i != N - 1) sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
```