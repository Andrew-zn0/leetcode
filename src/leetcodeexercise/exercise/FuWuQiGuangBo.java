package leetcodeexercise.exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Classname FuWuQiGuangBo
 * @Description 服务器广播
 * @Date 2020/9/29 11:47 上午
 * @Created by Jay
 * <p>
 * 题目：服务器连接方式包括直接相连，间接连接。
 * A 和 B 直接连接， B 和 c 直接连接，则 A 和 c 间接连接。直接连接和间接连接都可以发送广播。
 * 给出一个 N * N 数组，代表 N 个服务器， matrix[i][j] == 1 ，则代表 i 和 j 直接连接；不等于 1 时，
 * 代表 i 和 j 不直接连接。 matrix[i][i]== 1 ，即自己和自己直接连接。 matrix[i][j]==matrix[j][i] 。
 * 计算初始需要给几台服务器广播，才可以使侮个服务器都收到广播。
 * 输入描述： n * n 矩阵，
 * <p>
 * [[1,1,0],[1,1,0],[0,0,1]]
 * 输出描述：整数
 */
public class FuWuQiGuangBo {

    public static void main(String[] args) {
        int[][] servers = {
                {1, 0, 1, 0, 1, 1},
                {0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 1, 0},
                {1, 0, 0, 0, 0, 1}
        };
        int count = getBroadcastNo(servers);
        System.out.println("共向" + count + "台服务器发送广播");

    }

    private static int getBroadcastNo(int[][] servers) {
        int count = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        // 把直接相连的存起来
        for (int i = 0; i < servers.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < servers[i].length; j++) {
                if (servers[i][j] == 1) {
                    set.add(j);
                    map.put(i, set);
                }
            }

        }
        // 取出间接相连的
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            Set<Integer> broadcastList = entry.getValue();
            for (Integer broadcast : broadcastList) {
                if (key != broadcast) {
                    map.put(broadcast, broadcastList);
                }
            }
        }
        Set<Set<Integer>>  ret = new HashSet<>();
        for(Map.Entry<Integer,Set<Integer>> blist:map.entrySet()){
            ret.add(blist.getValue());
        }
        count = ret.size();
        return count;
    }
}
