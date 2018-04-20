/**@author prebe17
@version 1.5.2
*/

import java.util.Scanner;
import java.util.Random;

interface Gun{
	int shoot(int left);
	int reload(int remaining);
}

interface Automatic{
	void changeRate();
}

interface HandGun{
	void twoHands();
}

class Shotgun implements Gun{
	int shells;
 
	Shotgun(){
		this.shells=8;	
	}

	void setShells(int rem){
		this.shells=rem;
	}

	int getShells(){
		return this.shells;
	}
 
	public int shoot(int left){
		int rem=this.getShells()-1;
		this.setShells(rem);
		System.out.println("the old reliable (Shotgun) fired "+this.getShells()+" shells left");
		if(this.getShells()==0){
			left=this.reload(left);
		}
	return left;
	}
 
	public int reload(int left){
		if(left <= 0){
			System.out.println("\nShotgun : out of ammo");
			return -1;
		}else{
			System.out.println("\nreloading\n");
			left-=8;
			this.setShells(8);
		}
		return left;
		}

	public String toString(){
		return String.format("Shotgun - 8 shells load, got 24 shells; 1-3 kills per shot");
	}
}

class MachineGun implements Gun, Automatic{
	int rounds;
	boolean automatic;

	MachineGun(){
		this.rounds=30;
		this.automatic=true;
	}

	boolean getAutomatic(){
		return this.automatic;
	}

	public void changeRate(){
		if(this.getAutomatic()){
			this.automatic=false;  //set single shot
			System.out.println("\none shot one down\n");
		}else{
			this.automatic=true; //set machine gun
			System.out.println("\nburst of lead\n");
		}
	}

	void setRounds(int rounds){
		this.rounds=rounds;
	}
	

	int getRounds(){
		return this.rounds;
	}
 
	public int shoot(int left){
		if(this.getAutomatic()){
			System.out.println(" Shooting up your favorite  machine gun  "+this.getRounds()+" rounds in the clip; holding tha trigger");
			int rem=this.getRounds()-10;
			this.setRounds(rem);
			if (this.getRounds()<10){
				this.setRounds(0);
			}
		}else{ //automatic ==  false
			System.out.println(" Shooting up your favorite  machine gun  "+this.getRounds()+" rounds in the clip; fire at will");
			int rem=this.getRounds()-2;
			this.setRounds(rem);
			if (this.getRounds()<2){
				this.setRounds(0);
			}

		}
		if(this.getRounds()==0){
			left=this.reload(left);
		}
	return left;
	}
 
	public int reload(int left){
		if(left <= 0){
			System.out.println("\nMachine gun : out of ammo");
			return -1;
		}else{
			System.out.println("\nreloading\n");
			left-=30;
			this.setRounds(30);
		}
		return left;
	}

	public String toString(){
		return String.format("Machine gun - 30 rounds clip, got 4 loaders;\n it has single shot ( 0-2 kills/2 rounds ) and burst-shot (0-7 kills/10 rounds) ");
	}
}



class Uzi implements Gun, Automatic, HandGun{
	int rounds;
	boolean automatic;
	boolean twohands;

	Uzi(){
		this.rounds=16;
		this.automatic=true;
		this.twohands=false;
	}

	boolean getTwoHands(){
		return this.twohands;
	}

	public void twoHands(){
		if(this.getTwoHands()){
			System.out.println("\nill use a single gun in order to increase accuracy\n");
			this.twohands=false;
		}else{
			System.out.println("\ntwo guns, nigger, take a look at ma lils uzis\n");
			this.twohands=true;
		}
	}

	boolean getAutomatic(){
		return this.automatic;
	}

	public void changeRate(){
		if(this.getAutomatic()){
			this.automatic=false;  //set single shot
			System.out.println("\none shot one down\n");
		}else{
			this.automatic=true; //set machine gun
			System.out.println("\nburst of lead\n");
		}
	}

	void setRounds(int rounds){
		this.rounds=rounds;
	}
	

	int getRounds(){
		return this.rounds;
	}

	public int shoot(int left){
		if(this.getTwoHands() && this.getAutomatic()){ //if shooting up two uzi on automatic mode
			System.out.println(" Shooting up your golden uzis  "+(this.getRounds())+" rounds in the clips - half on each; holding tha trigger");
			int rem=this.getRounds()-16;
			this.setRounds(rem);
			if (this.getRounds()<16){
				this.setRounds(0);
			}
		}else  if(this.getTwoHands()==false && this.getAutomatic()){ //shooting a gun - automatic
			System.out.println(" both hands on one gun, get those headshots; holding tha trigger "+this.getRounds()+" rounds on clip");
			int rem=this.getRounds()-8;
			this.setRounds(rem);
			if (this.getRounds()<8){
				this.setRounds(0);
			}
		}else if (this.getAutomatic()==false && this.getTwoHands()){ // shooting up two guns on single shot mode
			System.out.println(" Shooting up your golden uzis  "+(this.getRounds()*2)+" rounds in the clips - half on each; fire at will");
			int rem=this.getRounds()-2;
			this.setRounds(rem);
			if (this.getRounds()<2){
				this.setRounds(0);
			}
		}else{ //one gun single shot mode
			System.out.println(" both hands on one gun, get those headshots "+this.getRounds()+" rounds on clip; fire at will ");
			int rem=this.getRounds()-1;
			this.setRounds(rem);
			if (this.getRounds()<1){
				this.setRounds(0);
			}
		}
		if(this.getRounds()==0){
			left=this.reload(left);
		}
	return left;
	}

 
	public int reload(int left){
		if(left <= 0){
			System.out.println("\n Uzi: out of ammo");
			return -1;
		}else{
			System.out.println("\nreloading\n");
			if(this.getTwoHands()){
				left-=32;
				this.setRounds(32);
			}else{
				left-=16;
				this.setRounds(16);
			}
		}
		return left;
		}

		public String toString(){
		return String.format("Uzi - 16 rounds clip, got 8  clip\n you can use two of those babys at once , it has single shot and burst-shot\n (one hand single shot 0-1/1 ; two-handed single shot 0-2/2 ;\n one hand burst shot 0-5/8 ; two-handed burst shot 1-10/16"); //ohss 0-1/1 thss 0-2/2 ohbs 0-5/8 thbs 1-10/16
	}
}


class Revolver implements Gun, HandGun{
	int bullets;
	boolean twohands;

	Revolver(){
		this.bullets=6;
		this.twohands=false;
	}

	boolean getTwoHands(){
		return this.twohands;
	}

	public void twoHands(){
		if(this.getTwoHands()){
			System.out.println("\ni just need my revolver\n");
			this.twohands=false;
		}else{
			System.out.println("\ntwo revolver cause im a gunslinger, come and get me\n");
			this.twohands=true;
		}
	}

	int getBullets(){
		return this.bullets;
	}

	void setBullets(int b){
		this.bullets=b;
	}

	public int shoot(int left){
		int ret=left;
		if(this.getTwoHands()){  
			System.out.println("Two-hand revolver  "+(this.getBullets()-2)+" remaining shots within both guns ");
			int rem=this.getBullets();
			rem-=2;
			this.setBullets(rem); //this.bullets-=2;
			if (this.getBullets()<2){
				this.setBullets(0);
			}
		}else{ //single gun
			System.out.println("Shooting up your 6 shots revolver "+(this.getBullets()-1)+" shots left");
			int rem=this.getBullets();
			rem-=1;
			this.setBullets(rem); //this.bullets-=1;
			if (this.getBullets()<1){
				this.setBullets(0);
			}

		}
		if(this.getBullets()==0){
			ret =this.reload(ret);
		}
		return ret;
	}
 
	public int reload(int left){
		int ret=left;
		if(ret <= 0){
			System.out.println("\n Revolver : out of ammo");
			return -1;
		}else{
			System.out.println("\nreloading\n");
			if(this.getTwoHands()){
				ret-=12;
				this.setBullets(12);
			}else{
				ret-=6;
				this.setBullets(6);
			}
		}
		return ret;
	}
	public String toString(){
		return String.format("Revolver - 6 bullets per load, got 36 bullets;  \nyou can use two of those babys at once \n(0-1 kills per shot , 0-4 (two-handed) per two shots)"); //th 1-4
	}

}


class Ejercicio7{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Revolver re = new Revolver();
		MachineGun mg = new MachineGun();
		Uzi uz = new Uzi();
		Shotgun sh = new Shotgun();

		System.out.println("\nYoure surrounded by zombies and theres no escaping.");
		System.out.println("\nPick up a gun so you can take some of those bastards to hell with you!!! ");
		System.out.print("\n 1)    ");
		System.out.println(re);
		System.out.print("\n 2)    ");
		System.out.println(mg);
		System.out.print("\n 3)    ");
		System.out.println(uz);
		System.out.print("\n 4)    ");
		System.out.println(sh);
		System.out.println("");

		int ammo, zombies=0, kills, chth=0, chfr=0 ; //chth is use to set two-handed weapon and chfr to change fire rate
		int gu = sc.nextInt();
		Random ram = new Random();
		System.out.println("");
		switch(gu){
			case 1: //revolver 72
				ammo = 36;
				//int test=0; //
				while(ammo>-1){ //

					if(re.getTwoHands()){
						kills=ram.nextInt(4);
					}else{
						kills=ram.nextInt(2);
					}
					ammo =re.shoot(ammo);
					zombies+=kills;
					chth++; 
					if (chth==12){
						re.twoHands();
						chth=0;
					}
					//test++;//
				}
			break;

			case 2: //machine gun 180
				ammo = 120;
				while(ammo>0){
					// kills=ram.nextInt();
					chfr++;
					if (chfr==10){
						mg.changeRate();
						chfr=0;
					}
					ammo = mg.shoot(ammo);
					if(mg.getAutomatic()){
						kills=ram.nextInt(7);
					}else{
						kills=ram.nextInt(2);
					}
					zombies+=kills;	
				}	
			break;

			case 3: //uzi 192 ohss 0-1/1 thss 0-2/2 ohbs 0-5/8 thbs 1-10/16
				ammo =128;
				while(ammo>0){
					ammo = uz.shoot(ammo);

					chth++;
					if (chth==6){
						uz.twoHands();
						chth=0;
					}
					chfr++;
					if (chfr==4){
						uz.changeRate();
						chfr=0;
					}

					if(uz.getAutomatic() && uz.getTwoHands()){ // two automatic
						kills=ram.nextInt(10)+1;
					}else if(mg.getAutomatic() && uz.getTwoHands()==false){ //  one automatic
						kills=ram.nextInt(5);
					}else if(uz.getTwoHands() && uz.getAutomatic()==false){	//two singleshot
						kills=ram.nextInt(2);
					}else{ 		//one singleshot
						kills=ram.nextInt(1);
					}
					zombies+=kills;
				}	
			break;

			case 4: //shotgun 48
				ammo=24;
				while(ammo>0){
					ammo = sh.shoot(ammo);
					kills=ram.nextInt(3)+1;
					zombies+=kills;	
				}	
			break;

			default:
				System.out.println(" you chose to die like a fag, whitout figthing");
			break;
			}
	
		System.out.println("You ran out of ammo and the living dead ate you.");
		System.out.println("Before you died you anhilliate "+zombies+" zombies.");


	}
}

/*
	En el ejercicio 7 se implementan tres interfaces: gun, automatic y handgun; cada una de estas interfaces tiene sus metodos
	propios que definen el comportamiento de un objeto que desciende de ellos en la jerarquia de clases, la principal utilidad
	de las interfaces en este programa es permitir la herencia multiple, creando clases que comparten comportamiento y metodos
	de varias interfaces y mantener una codificacion limpia y con un buen nivel de abstraccion, dividiendo los metodos a realizar 
	por cada clase y heredandolos de las interfaces segun lo requiera la clase

*/