public class MainInterfaces {
	public static void main(String[] args) {
		RemoteControl Control = new RemoteControl(new LightBulb(), new Bomb(),new LightBulb(),new computer());

		Control.pushButtonOne();
		Control.pushButtonTwo();		
		Control.pushButtonThree();
		Control.pushButtonFour();
	}
}