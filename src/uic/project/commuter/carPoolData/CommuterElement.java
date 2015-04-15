package uic.project.commuter.carPoolData;

import uic.project.commuter.carPoolData.iterator.CarPoolIterator;

import java.util.ArrayList;

public class CommuterElement extends CarPoolComponent {
	
	private boolean isLeader; //Special field that determines leadership status.
	
	/**
	 * Print out available information on 'this' object. The tree is not printed here.
	 */
	public void printSelf() {
		System.out.print("Name: " + this.getName() + " Status: " + this.getStatus() 
				+ " Associated Distance: " + this.getDistanceTraveled() + " Is Leader? " + this.getIsLeader());
	}
	
	/**
	 * This method handles equality between 'this' and another CarPoolComponent.
	 * @return The boolean representing the equality between the two objects.
	 */
	public boolean equals(CarPoolComponent obj) {
		return obj.getName().equals(this.getName());
	}
	
	/**
	 * Getter and setter for the field isLeader.
	 */
	public boolean getIsLeader() {return isLeader;}
	public void setIsLeader(boolean isLeader_input) {isLeader = isLeader_input;}
	
	/**
	 * Activates this object.
	 */
	public void activate(String name) {this.setStatus(true);}
	
	/**
	 * Deactivates this object.
	 */
	public void deactivate(String name) {this.setStatus(false);}
	
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
	public void determineLazyCommuter() {}
	public void determineLazyCommuter(String name) {}
	public CarPoolComponent findCommuter(String personName) {return null;}
	public CarPoolComponent findCarpool(String cpName) {return null;}
	public CarPoolComponent addCommuter(CarPoolComponent person, CarPoolComponent cp) {return null;}
	public CarPoolComponent removeCommuter(CarPoolComponent person) {return null;}
	public CarPoolComponent addCarpool(CarPoolComponent cp, double distance) {return null;}
	public CarPoolComponent removeCarpool(CarPoolComponent cp) {return null;}
	public void moveCommuter(CarPoolComponent person, CarPoolComponent cp) {}
	public void toggleLeader(CarPoolComponent person, CarPoolComponent cp) {}
}
