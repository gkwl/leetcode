package com.gkwl.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int ans = num[0] + num[1] + num[2];
        for (int i = 0; i < num.length; i++) {
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                if (sum == target) {
                    return sum;
                }

                int minus = sum - target;
                if (Math.abs(minus) < Math.abs(ans - target)) {
                    ans = sum;
                }

                if (minus < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
    }
}