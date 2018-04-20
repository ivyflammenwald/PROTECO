import java.util.ArrayList;

public class ColectionArrayList{
	public static void main(String[] args) {
		ArrayList <String> elements = new ArrayList<String>();

		elements.add("red");//add an element  to arrayList
		elements.add(0,"blue");//add an element to a certain position

		for (int i = 0;i<elements.size() ;i++ ) {
			System.out.printf("%s\n", elements.get(i));
		}

		elements.remove("red");
		elements.remove(0);
		System.out.println("arrayList modified");

		for (int i = 0;i<elements.size() ;i++ ) {
			System.out.printf("%s\n", elements.get(i));
		}
		
	}
}