class Solution{

    /**
     * N:物品数量
     * C:背包容量
     * v:每个物品占用的容量
     * w:每个物品的价值
     * dp[i][j]：前i个物品，剩余容量j的情况下的最大价值
     */
    public int maxValue(inv N,int C,int[] v,int[] w){
        int[][] dp = new int[N][C+1];

        //第一件物品
        for(int i=0;i<=C;i++){
            dp[0][i] = i>=v[0]? w[0]:0;
        }

        for(int i=1; i<N; i++){
            for(int j=0;j<=C; j++){
                //背包里不选第i件物品
                int a = dp[i-1][j];
                //背包里选了第i件物品
                int b = j>=v[i]? dp[i-1][j-v[i]]+w[i]:0;
                dp[i][j] = Math.max(a,b);
            }
        }
        return dp[N-1][C];
    }


    /**
     * dp[2][N+1]
     * 因为最终不需要dp里面的每个值
     */
    public int maxValue2(inv N,int C,int[] v,int[] w){
        int[][] dp = new int[2][C+1];

        //第一件物品
        for(int i=0;i<=C;i++){
            dp[0][i] = i>=v[0]? w[0]:0;
        }

        for(int i=1; i<N; i++){
            for(int j=0;j<=C; j++){
                //背包里不选第i件物品
                int a = dp[(i-1)&1][j];
                //背包里选了第i件物品
                int b = j>=v[i]? dp[(i-1)&1][j-v[i]]+w[i]:0;
                dp[i][j] = Math.max(a,b);
            }
        }
        return dp[(N-1)&1][C];
    }
}