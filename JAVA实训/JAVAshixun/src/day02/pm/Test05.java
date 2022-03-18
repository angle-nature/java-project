package day02.pm;

public class Test05 {
    public static void main(String[] args) {
        MyQueue myQueue=new MyQueue(10);

        myQueue.insert('1');
        myQueue.insert('2');
        myQueue.insert('3');
        myQueue.insert('4');
        myQueue.insert('5');
        myQueue.insert('6');
        myQueue.insert('7');
        myQueue.insert('8');
        myQueue.insert('9');
        myQueue.insert('a');
        myQueue.printQueue();

        myQueue.remove();
        myQueue.printQueue();

    }
}
