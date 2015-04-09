package uic.project.commuter.carPoolData.iterator;

import uic.project.commuter.carPoolData.*;

import java.util.ArrayList;

public class CarPoolComposite extends CarPoolComponent {

	private ArrayList<CarPoolComponent> tree;
	
	public CarPoolComposite() {
		this.setName("");
		this.setStatus(true);
		this.resetDistance();
	}
	
	public CarPoolComposite(String tag, boolean inputStat, double dist) {
		this.setName(tag);
		this.setStatus(inputStat);
		this.resetDistance();
		this.addDistance(dist);
	}
	
	public void printSelf() {}
	public boolean equals(CarPoolComponent obj) {return true;}
	public void printLevel(){}
	public void printAll(){}
	public ArrayList<CarPoolComponent> getTree(){ return null;}
	public CarPoolIterator getIterator() {return null;}
	public CarPoolComponent determineLazyCommuter() {return null;}
	public CarPoolComponent findCommuter(String personName, CarPoolComponent cp) {return null;}
	public CarPoolComponent findCarpool(String cpName) {return null;}
	public CarPoolComponent addCommuter(CarPoolComponent person, CarPoolComponent cp) {return null;}
	public CarPoolComponent removeCommuter(CarPoolComponent person, CarPoolComponent cp) {return null;}
	public CarPoolComponent addCarpool(CarPoolComponent cp) {return null;}
	public CarPoolComponent removeCarpool(CarPoolComponent cp) {return null;}
	public void moveCommuter(CarPoolComponent person, CarPoolComponent cp) {}
	public void toggleLeader(CarPoolComponent person, CarPoolComponent cp) {}
	
	/**
	 * All methods below do no meaningful work as they are not considered to be a useful part of this class.
	 */
	
	public boolean getIsLeader() {return true;}
	public void setIsLeader(boolean isLeader_input) {}
}
