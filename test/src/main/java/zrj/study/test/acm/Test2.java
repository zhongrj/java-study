package zrj.study.test.acm;

/**
 * 不重复足迹路径可能性
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/25
 */
public class Test2 {

    private static int count = 0;

    public static void main(String[] args) {
        noRepeatStep(new int[]{0, 0}, 10);
    }

    private static void noRepeatStep(int[] start, int step) {
        IntArrayNode track = new IntArrayNode(start);
        noRepeatStep(track, start, step);
    }


    private static final int[][] dsteps = new int[][]{
            new int[]{0, 1},
            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, -1}
    };

    private static void noRepeatStep(IntArrayNode track, int[] curr, int step) {
        if (step == 0) {
            printTrack(track);
            System.out.printf("   %s\n", ++count);
            return;
        }
        for (int[] dstep : dsteps) {
            int[] nextPoint = arrayAdd(curr, dstep);
            if (containPoint(track, nextPoint)) {
                continue;
            }
            IntArrayNode newTrack = new IntArrayNode(nextPoint);
            newTrack.next = track;
            noRepeatStep(newTrack, nextPoint, step-1);
        }
    }

    private static void printTrack(IntArrayNode track) {
        if (track != null) {
            printTrack(track.next);
            System.out.printf("(%s, %s)", track.point[0], track.point[1]);
        }
    }

    private static boolean containPoint(IntArrayNode track, int[] target) {
        while (track != null) {
            if (isTheSamePoint(track.point, target)) {
                return true;
            }
            track = track.next;
        }
        return false;
    }

    private static boolean isTheSamePoint(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] arrayAdd(int[] array1, int[] array2) {
        int[] result = array1.clone();
        for (int i = 0; i < result.length; i++) {
            result[i] += array2[i];
        }
        return result;
    }

    private static class IntArrayNode {
        int[] point;
        IntArrayNode next;

        public IntArrayNode(int[] point) {
            this.point = point;
        }
    }
}

