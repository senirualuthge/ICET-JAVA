class A{
	private static A ob;
    
	private A(){}
    
	public static A getInstance(){
		if(ob==null){
			ob=new A();
		}
		return ob;
    }
}
   
class B{
    private B(){}

    private static B oa;

        public static B getInstance(){
		    if(oa==null){
		    	oa=new B();
		    }
		    return oa;
        }
}



class sing1{
	public static void main(String[] args) {
		//A a1=new A(); //Illegal
		A a1=A.getInstance();
		A a2=A.getInstance();
		System.out.println(a1==a2); //true

        B b1= B.getInstance();
		B b2= B.getInstance();
		System.out.println(b1==b2); //true
	}
}
