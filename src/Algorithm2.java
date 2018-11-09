/**
 * O(logN)算法
 */
public class Algorithm2 {
    public static void main(String[] args) {
        int[] a = new int[]{-2,3,6,7,21,67,22,-24,-14};
        //int x = algorithm1(a,3);
        //System.out.println("\n"+x);

        //int x2 = algorithm2(1989,1590);
        //System.out.println("\n"+x2);

        int x3 = algorithm3(2,25);
        System.out.println("\n"+x3);

    }

    /**
     * 对分查找
     * O(logN)
     * @param a
     * @param x
     * @return
     */
    public static int algorithm1(int[] a, int x){
        int low; int mid; int high;
        low = 0; high = a.length-1;
        while (high >= low){
            System.out.print("x");
            mid = (high + low) / 2;
            if (x == a[mid]){
                return mid;
            }else if(x > a[mid]){
                low = mid + 1;
            }else if(x < a[mid]){
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 欧几里得算法
     * O(logN)
     * @param m
     * @param n
     * @return
     */
    public static int algorithm2(int m, int n){
        int rem;
        while (n > 0){
            rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

    /**
     * 幂运算
     * 输出的星号表示乘法运行次数
     * O(logN)
     * @param x
     * @param n
     * @return
     */
    public static int algorithm3(int x, int n){
        if(n == 0){
            return 1;
        }
        if(n % 2 == 0){
            System.out.print("*");
            return algorithm3(x*x,n / 2);
        }else{
            System.out.print("**");
            return algorithm3(x*x,n / 2) * x;
        }
    }
}
