package day03.am;

public class HaffmanTree {
	private TreeNode root;
	
	public HaffmanTree(){
		root=null;
	}

	public void insert(int data) {
        TreeNode newNode=new TreeNode(data);
        if(root==null){
        	root=newNode;
        }
        else{
        	TreeNode current=root;
        	TreeNode preNode=root;
        	int flag=0;  //0 表示左，1表示右
        	while(true){
        		if(current!=null){
					preNode=current;
					if(data<current.getData()){
//						if(current.getLeftnode()==null)
//							current.setLeftnode(newNode);
						current=current.getLeftnode();
						flag=0;
					}
					else if(data>=current.getData()){
//						if(current.getRightnode()==null)
//							current.setRightnode(newNode);
						current=current.getRightnode();
						flag=1;
					}
				}else{
        			if(flag==0)
        				preNode.setLeftnode(newNode);
        			else
        				preNode.setRightnode(newNode);
        			break;
				}
			}
        }
	}

	public TreeNode getRoot() {
		return root;
	}

	public void preOrder(TreeNode current) {
		if(current!=null){
			current.displaydata();
			preOrder(current.getLeftnode());
			preOrder(current.getRightnode());
		}
	}

	public void midOrder(TreeNode current) {
		if(current!=null){
			midOrder(current.getLeftnode());
			current.displaydata();
			midOrder(current.getRightnode());
		}
	}

	public void postOrder(TreeNode current) {
		if(current!=null){
			postOrder(current.getLeftnode());
			postOrder(current.getRightnode());
			current.displaydata();
		}
	}

}
