package day02.pm;

public class MyQueue {
    private char[] arr;
    private int size=0; //实际长度
    private int length; //数组最大长度
    private int rear; //队头
    private int front; //队尾

    public MyQueue(int len) {
        this.length=len;
        arr=new char[length];
        this.size=0;
        this.rear=-1;
        this.front=-1;
    }

    //入队
    public void insert(char data){
        if(isFull())
            System.out.println("队列已满！");
        else {
            rear = (rear + 1) % length;
            arr[rear] = data;
            size++;
        }
    }

    //出队
    public char remove(){
        char data='0';
        if(isEmpty())
            System.out.println("队列为空！");
        else{
            front=(front+1)%length;
            data=arr[front];
            size--;
        }
        return data;
    }

    //返回队列实际长度
    public int getSize(){
        return size;
    }

    //判断是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //判断队列是否满
    public boolean isFull(){
        return size==length;
    }

    //打印队列
    public void printQueue(){
        for(int i=(front+1)%length;i!=rear;i=(i+1)%length)
            System.out.print(arr[i]+" ");
        System.out.println(arr[rear]);
    }
}
