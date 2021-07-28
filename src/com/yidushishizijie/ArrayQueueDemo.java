package com.yidushishizijie;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试一把
        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    int res = 0;
                    try {
                        res = arrayQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class ArrayQueue{
    private int maxSize;//队列最大数值
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数组用来存放数据,模拟队列

    //创建构造器
    public ArrayQueue(int arrMaxSize){
        this.maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
        front = -1;
        rear = -1;
    }

    //判断是否满
    public boolean isFull(){
        return rear == maxSize-1;
    }

    //判断是否为空
    public boolean isEnpty(){
        return rear == front;
    }

    //向队列中添加数据
    public void addQueue(int n){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列满，不能加入数据~");
            return;
        }
        rear++;//让队列尾向后移动
        arr[rear] = n;
    }

    //向队列中提取数据
    public int getQueue(){
        //判断队列是否为空
        if(isEnpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if(isEnpty()){
            System.out.println("队列空，没有数据");
            return;
        }
        for(int i=front+1;i<rear+1;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列的头数据，注意不是取数据
    public int headQueue(){
        if(isEnpty()){
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front+1];
    }
}