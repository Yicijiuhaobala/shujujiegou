/**
 * @author Zah
 * @create 2022-12-05 14:52
 * @Description 迷宫问题 当搜寻最短路径时 可以选用不同的移动策略 进行遍历循环得出最短路径
 */

public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
//        设置迷宫墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
//        设置挡板
        map[3][1] = 1;
        map[3][2] = 1;


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }


        setWay(map, 1, 1);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 1.i,j 表示从地图的哪个位置开始找
     * 2.当小球到map[6][5]的位置，通路找到
     * 3.当map[i][j]为0表示该点没有走过
     * 为1时表示为墙
     * 为2时表示该路可走
     * 为3时表示该位置已经走过，但走不通
     * 4.走路策略 下 -> 右 -> 上 -> 左
     * @param map 表示地图
     * @param i  从哪个位置开始找
     * @param j
     * @return 找到路 返回为true
     */
    public static boolean setWay(int[][] map, int i, int j){
        if(map[6][5] == 2){
            System.out.println("成功找到出口");
            return true;
        }else {
            if(map[i][j] == 0){ // 该点还没有走过
                map[i][j] = 2; // 假定该点可以走通
                if(setWay(map, i+1, j)){
                    return true;
                }else if(setWay(map, i ,j+1)){
                    return true;
                }else if(setWay(map, i-1, j )){
                    return true;
                }else if (setWay(map, i, j-1)){
                    return true;
                }else {
                    map[i][j] = 3; // 该点走不通 设为3
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}
