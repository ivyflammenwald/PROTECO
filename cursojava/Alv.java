
import java.lang.reflect.Field;


public class Alv{
	public static void main(String[] args) throws Exception{
		String s1 ="hola";
		//s1 =s1+"adios"; 
		String s2 = "hola";
		Field f = String.class.getDeclaredField("value");
		f.setAccessible(true);
		f.set(s1, "ppcdsalvc".toCharArray());
		System.out.println(s2);
		System.out.println("hola");
	}
}