package uic.project.commuter.carPoolData;

import uic.project.commuter.carPoolData.iterator.CarPoolIterator;
import java.util.ArrayList;

public class CommuterElement extends CarPoolComponent {
	
	private boolean isLeader;
	
	public void printSelf() {}
	public boolean equals(CarPoolComponent obj) {return true;}
	public boolean getIsLeader() {return isLeader;}
	public void setIsLeader(boolean isLeader_input) {isLeader = isLeader_input;}
	
	public CommuterElement(String tag, boolean inputStat, double distanceTraveled_input, boolean bLeader) {
		this.setName(tag);
		this.setStatus(inputStat);
		this.resetDistance();
		this.addDistance(distanceTraveled_input);
		isLeader = bLeader;
	}
	
	/**
	 * All methods below do no meaningful work as they are not considered to be a useful part of this class.
	 */
	
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
}
