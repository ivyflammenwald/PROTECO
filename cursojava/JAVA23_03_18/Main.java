public class Main {
	public static void main(String[] args) {
		vehicle v = new vehicle("Rob");
		AquaticVehicle va = new AquaticVehicle("SS Ned");
		ship vav = new ship("SS nick");

		System.out.println(v.transport());

		va.surf();
		vav.surf();
		vav.turnOnMotors();
	}
}