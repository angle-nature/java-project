package shiyan;

public class Sort { 
	public static void main(String args[ ]){ 
		 int arr[ ]={1,3,5,6,0,2,7,9,8}; 
		 
		 for(int i = 0; i < arr.length - 1; i++) {// ����i������
	            int k = i;
	            for(int j = k + 1; j < arr.length; j++){// ѡ��С�ļ�¼
	                if(arr[j] < arr[k]){ 
	                    k = j; //����Ŀǰ�ҵ�����Сֵ���ڵ�λ��
	                }
	            }
	            //���ڲ�ѭ��������Ҳ�����ҵ�����ѭ������С�����Ժ��ٽ��н���
	            if(i != k){  //����a[i]��a[k]
	                int temp = arr[i];
	                arr[i] = arr[k];
	                arr[k] = temp;
	            }    
		 }
		 
		 for(int i=0;i<arr.length;i++)
			 System.out.print(arr[i]+" ");
	}
}
