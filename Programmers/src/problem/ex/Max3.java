package problem.ex;

public class Max3 {
    static int binSearch(int[] a, int n, int key) {
        int pl = 0;
        int pr = n - 1;
        do {
            int pc = (pl + pr) / 2;
            if (a[pc] == key) {
//                System.out.println();
//                for (int i = 0; i < pc; i++) {
//                    System.out.print("  ");
//                }
//                System.out.print(" +\n");
//                for (int e : a) {
//                    System.out.printf("%2d", e);
//                }
                for(int i = 0; i < pc + 1; i++) {
                    if (a[pc - i] != key) {
                        return pc - i + 1;
                    }
                }
                return pc;
            } else if (a[pc] < key) {
//                System.out.println();
//                for (int i = 0; i < pl; i++) {
//                    System.out.print("  ");
//                }
//                System.out.print("<-");
//                for(int i = 0; i < pc - pl - 1; i++) {
//                    System.out.print("  ");
//                }
//                System.out.print(" +");
//
//                for(int i = 0; i < pr - pc - 1; i++) {
//                    System.out.print("  ");
//                }
//                System.out.print("->\n");
//                for (int e : a) {
//                    System.out.printf("%2d", e);
//                }
                pl = pc + 1;
            } else {
//                System.out.println();
//                for (int i = 0; i < pl; i++) {
//                    System.out.print("  ");
//                }
//                System.out.print("<-");
//                for(int i = 0; i < pc - pl - 1; i++) {
//                    System.out.print("  ");
//                }
//                System.out.print(" +");
//
//                for(int i = 0; i < pr - pc - 1; i++) {
//                    System.out.print("  ");
//                }
//                System.out.print("->\n");
//                for (int e : a) {
//                    System.out.printf("%2d", e);
//                }
                pr = pc - 1;
            }
        }
        while (pl <= pr);
        return -1;
    }

    public static void main(String[] args) {
        int [] a = {0,1,1,1,1,1,2,2,3,3,3,3,4,4,5,5,6,6,7,7,7,8,8,8,9,9,9,9,9,};
        for (int i = 0;  i < a.length; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();
        for (int e : a) {
            System.out.printf("%3d", e);
        }
        System.out.println();
        System.out.println(binSearch(a,a.length, 3));
    }
}