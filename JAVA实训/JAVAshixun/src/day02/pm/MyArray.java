package day02.pm;

public class MyArray {
	private int[] arr;
	private int realnumber;
	

	public void insert(int data) {
		if(realnumber<arr.length)
          arr[realnumber++]=data;
	}

	public void display() {
		for (int i = 0; i < realnumber; i++) {
			System.out.print (arr[i]+"    ");
		}
		
	}

	public void delete(int i) {
		// TODO Auto-generated method stub
		
	}

	public void bubbleSort() {
		
	 for (int j = 1; j < realnumber; j++) {
		 for (int i = 0; i < realnumber-j; i++) {
			if(arr[i]>arr[i+1]){
				int temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
		}
	}	
	}
	
	
	public MyArray(int length){
		arr=new int[length];
		//realnumber=0;
	}

	public void selectSort() {
		
		for (int j = 1; j < realnumber; j++) {
		  int min=arr[j-1];
		  int minindex=j-1;
			for (int i = j; i < realnumber; i++) {
	 	       if(arr[i]<min){
	 	    	   min=arr[i];
	 	    	  minindex=i;
	 	       }	 
			}
			int temp=arr[minindex];
	        arr[minindex]=arr[j-1];
	        arr[j-1]=temp;
		} 	
	}

}
