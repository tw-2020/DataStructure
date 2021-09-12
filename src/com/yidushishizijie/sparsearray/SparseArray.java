package com.yidushishizijie.sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        //先创建一个原始的二位数组 11*11的大小
        // 0:表示没有棋子，1：表示 黑子 2：表示白子
 
        int cheerArr1[][]=new int[11][11];
        cheerArr1[1][2]=1;
        cheerArr1[2][3]=2;
        //输出原始二维数组
        System.out.println("原始二位数组");
        for (int[] row:cheerArr1){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
 
        //二维数组转稀疏数组
        //1.遍历原始二位数组，得到有效数据的个数sum 2. 根据sum就可以创建稀疏数组spareArr[sum+1][3] 3.将二维数组数据存入稀疏数组
        int sum=0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(cheerArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println("sum:"+sum);
 
        //创建对应的稀疏数组
        int sparseArr[][]=new int[sum+1][3];
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;
 
        //遍历二维数组，将数据放入稀疏数组
        int count=0;//用于遍历第几个非0数据
        for (int i=0;i<11;i++){
            for (int j=0;j<11;j++){
                if (cheerArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=cheerArr1[i][j];
 
                }
            }
        }
        //输出稀疏数组的形式
        System.out.println();
        System.out.println("稀疏数组");
        for (int i=0;i<sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();
 
        //稀疏数组转二维数组
        // 1.先读取稀疏数组的第一行，根据第一行的数据，创建原始二维数组
        // 2.在读取稀疏数组的后几行数据，并付给原始二维数组即可
        int cheerArr2[][]=new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i=1;i<sparseArr.length;i++){
            cheerArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        //恢复的二维数组
        System.out.println();
        System.out.println("恢复的二维数组");
        for(int[] row:cheerArr2){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //增加一行代码，使用一下git
    }
}
