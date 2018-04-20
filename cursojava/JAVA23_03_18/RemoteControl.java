public class RemoteControl {
	private Turnable e1, e2;
	private Removable t1, t2;

	public RemoteControl (Turnable e1,Turnable e2,Removable t1,Removable t2) {
		this.e1 = e1;
		this.e2 = e2;
		this.t1 = t1;
		this.t2 = t2;
	}

	public void pushButtonOne() {
		e1.turnOn();
	}

	public void pushButtonTwo() {
		e2.turnOn();
	}

	public void pushButtonThree() {
		t1.turnOff();
	}

	public void pushButtonFour() {
		t2.turnOff();
	}





}