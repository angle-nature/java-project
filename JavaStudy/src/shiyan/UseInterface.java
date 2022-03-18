package shiyan;

class UseInterface implements Interfaceclass{

		public void func1(){  //在使用接口的类中一定要实现接口中的所有抽象方法
			System.out.println("func1="+i);
		}
	    public int func2(int i){
			System.out.println("func2="+i);
			return i;
	    }
		public static void main(String args[]){
			UseInterface x=new UseInterface();
			x.func1();
			x.func2(k);
		}
}

