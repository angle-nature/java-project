package shiyan;


class Average{

 	public static void main(String args[ ]){
    	double n,sum=0;
   	for (int i=0;i<args.length;i++){
       	sum=sum+Double.valueOf(args[i]).doubleValue();
}
	n=sum/args.length;
	System.out.println("average="+n);
}
}


