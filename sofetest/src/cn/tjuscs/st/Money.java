/**
 * 
 */
package cn.tjuscs.st;



/**
 * @author m^_^m
 *
 */
public class Money {
	
  public static int a[] = { 50,20,10,5,5,1,1,1 };
  
  public static boolean TakeOut(int money){
	  for (int i = 0 ; i < a.length ; i++) {
			if (money  == 0) {
				return true;
			}
			
			if (money - a[i] < 0) {
				continue;
			}else {
				money = money - a[i];
				continue;
			}
		}
		
		if ( money == 0) {
			return true;
		}else {
			return false;
		}
  }
      
 
}
