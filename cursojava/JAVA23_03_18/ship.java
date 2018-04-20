public class ship extends AquaticVehicle{
	public ship(String name){
		super(name);
	}


	public void turnOnMotors(){
		//super.surf()
		System.out.println("I'm turning on the motors...");
	}

	@Override
	public void surf(){
		System.out.println("I'm a Ship and my name is "+name);
	}


}