class DefExample2 {
	public static int foo(int i) {
	   if ( i < 100 ) {
		  return -1
	   }
	   return 100
	}
	
	public static int foo2(int i) {
		if ( i < 100 ) {
		   return -1
		}
		return 100
	 }
	static void main(String[] args) {
		println foo(50)
		println foo2(200)
	 }
 }