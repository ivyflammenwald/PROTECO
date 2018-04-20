public class AquaticVehicle extends vehicle{
	String aquaticName;

	public AquaticVehicle(String name){
		super(name);
	}

	public void surf (){
		System.out.println(super.transport()+"Aquatic");
	}
}