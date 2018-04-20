public class Zoo {
	private final int N=10;
	public Animal[] animals = new Animal[N];
	public int nums;

	public void addAnimal (Animal a){
		if(nums == N) {
			System.out.println("Full Zoo!");
		}
		else{
			animals[nums] = a;
			nums++;
		}
	}
}