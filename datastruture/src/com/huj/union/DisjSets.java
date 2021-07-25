package com.huj.union;

/**
 * package: com.huj.union
 * date: 2019/2/25 10:07
 *
 * @author smallcase
 * @since JDK 1.8
 */
public class DisjSets {
    private int[] s;
    private int count;

    //初始时每个元素代表一个集合，自己就是树根，父节点用-1表示
    public DisjSets(int numElement) {
        this.count = numElement;
        s = new int[numElement];
        for (int i = 0; i < s.length; i++) {
            s[i] = -1;
        }
    }

    //root1作为root2的新树根,简单的合并
    public void simpleUnion(int root1,int root2){
        s[root2] = root1;
    }

    //<0,表示节点x就是一个父节点
    //返回值永远大于等于0
    public int find(int x){
        if (s[x]<0) return x; //s[x]为负数时,说明 x 为该子集合的代表(也即树根), 且s[x]的值表示树的高度
        else return s[x] = find(s[x]);//使用了路径压缩,让查找路径上的所有顶点都指向了树根(代表节点)
    }


    //对于按高度求并，数组中存储的元素：是高度的负值再减去1
    //依据：让矮的子树的根指向高的子树的根
    public void unionByHeight(int root1,int root2){
        if (find(root1)==find(root2)) return; //已经通了

        if (s[root1] > s[root2]) { //root2 deeper
            s[root1] = root2;
        }else {
            if (s[root1]==s[root2]) s[root1]--;
            s[root2] = root1;
        }
        count--;
    }
}

