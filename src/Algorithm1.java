/**
 * 最大子序列问题
 */
public class Algorithm1 {
    public static void main(String[] args) {
        int[] a = new int[]{-2,11,-4,13,-5,-2};
        long t1=System.currentTimeMillis();
        int max = algorithm2(a);
        System.out.println(max);
        long t2=System.currentTimeMillis();
        System.out.println("运行时长："+ (t2-t1));

        int max2 = algorithm3(a,0,a.length-1);
        System.out.println(max2);

        int max3 = algorithm4(a);
        System.out.println(max3);
    }

    /**
     * O(n3)
     * @param a
     */
    public static int algorithm1 (int[] a){
        int maxsum = 0;
        int thissum;
        for (int i = 0; i < a.length; i++){
            for (int j = i; j < a.length; j++){
              thissum = 0;
              for (int k = i; k <= j; k++){
                  thissum += a[k];
              }
              if(thissum > maxsum){
                  maxsum = thissum;
              }
            }
        }
        return maxsum;
    }

    /**
     * O(n2)
     * @param a
     * @return
     */
    public static int algorithm2 (int[] a){
        int maxsum = 0;
        int thissum;
        for (int i = 0; i < a.length; i++){
            thissum = 0;
            for (int j = i; j < a.length; j++){
                thissum += a[j];
                if(thissum > maxsum){
                    maxsum = thissum;
                }
            }
        }
        return maxsum;
    }

    /**
     * 分治
     * O(NlogN)
     * @param a
     * @param left
     * @param right
     * @return
     */
    public static int algorithm3 (int[] a , int left, int right){
        int maxLeftSum;int maxRightSum;
        int maxLeftBorderSum;int maxRightBorderSum;
        int leftBorderSum;int rightBorderSum;
        int center;

        if(left == right){
            if(a[left]>0){
                return a[left];
            }else{
                return 0;
            }
        }
        center = (left + right) / 2;
        maxLeftSum = algorithm3(a,left,center);
        maxRightSum = algorithm3(a,center+1,right);

        maxLeftBorderSum = 0; leftBorderSum = 0;
        for (int i = center; i>=left;i--){
            leftBorderSum += a[i];
            if(leftBorderSum > maxLeftBorderSum){
                maxLeftBorderSum = leftBorderSum;
            }
        }

        maxRightBorderSum = 0; rightBorderSum = 0;
        for (int i = center+1; i <= right; i++){
            rightBorderSum += a[i];
            if(rightBorderSum > maxRightBorderSum){
                maxRightBorderSum = rightBorderSum;
            }
        }

        return max3(maxLeftSum,maxRightSum,maxRightBorderSum + maxLeftBorderSum);
    }

    /**
     * 返回三个数中最大的数
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int max3(int a,int b,int c){
        int max = 0;
        int[] x = new int[]{a,b,c};
        for (int i =0 ; i<x.length; i++){
            if(x[i] > max){
                max = x[i];
            }
        }
        return max;
    }

    /**
     * 联机
     * O(N)
     * @param a
     * @return
     */
    public static int algorithm4(int[] a){
        int maxsum = 0;
        int thissum = 0;
        for (int i = 0; i < a.length; i++){
            thissum += a[i];
            if(thissum > maxsum){
                maxsum = thissum;
            }else if(thissum < 0){
                thissum = 0;
            }
        }
        return maxsum;
    }
}
