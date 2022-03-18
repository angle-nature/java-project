package day03.am;

public class Test04 {

	public static void main(String[] args) {
        HaffmanTree ht=new HaffmanTree();
        ht.insert(54);
        ht.insert(70);
        ht.insert(47);
        ht.insert(67);
        ht.insert(60);
        ht.insert(52);
        ht.insert(43);
        ht.insert(68);
        ht.insert(75);
        ht.insert(89);
        System.out.println("先序遍历结果：");
        ht.preOrder(ht.getRoot());   //先序遍历
        System.out.println();
        System.out.println("中序遍历结果：");
        ht.midOrder(ht.getRoot());   //中序遍历
        System.out.println();
        System.out.println("后续遍历结果：");
        ht.postOrder(ht.getRoot());  //后序遍历
	}
}