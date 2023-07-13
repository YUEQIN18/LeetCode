/*
 * 605. 种花问题
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。
 */


class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0, len = flowerbed.length; i < len && n > 0;) {
            if (flowerbed[i] == 1) {
                //即如果，当前i位置已经种植了话，那么下一个可以种花的位置是 i+2
                i += 2;
            } else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                //这里很关键
                //如果是最后一个位置了，那么肯定能够种植（i==flowerbed.length-1)
                //如果不是，则还需要确保 可种花的位置(i+2)紧邻其后的(i+2+1)的位置没有种植（flowerbed[i+1]==0)
                n--;
                //同时找出下一个可以种植的位置
                i += 2;
            } else {
                //这种情况是flowerbed[i]=0 && flowerbed[i + 1]=1，所以跳3个
                i += 3;
            }
	    }
	    return n <= 0;
    }

}