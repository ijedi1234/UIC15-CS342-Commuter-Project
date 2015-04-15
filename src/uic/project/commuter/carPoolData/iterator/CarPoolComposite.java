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
	
	/**
	 * Print out available information on 'this' object. The tree is not printed here.
	 */
	public void printSelf() {
		System.out.println("Name: " + this.getName() + " Status: " + this.getStatus() 
				+ " Associated Distance: " + this.getDistanceTraveled());
	}
	
	/**
	 * This method handles equality between 'this' and another CarPoolComponent.
	 * @return The boolean representing the equality between the two objects.
	 */
	public boolean equals(CarPoolComponent obj) {
		return obj.getName().equals(this.getName());
	}
	
	/**
	 * This method prints information on all objects directly below it in the data structure.
	 */
	public void printLevel(){
		CarPoolIterator iter = this.getIterator();
		
		while(iter.hasNext(this)) {
			CarPoolComponent currentObject = iter.next(this);
			currentObject.printSelf();
		}
	}
	
	/**
	 * This method prints information on all objects below it in the data structure.
	 */
	public void printAll(){
		CarPoolIterator iter = this.getIterator();
		
		while(iter.hasNext(this)) {
			CarPoolComponent currentObject = iter.next(this);
			currentObject.printSelf();
			CarPoolIterator tier2Iter = this.getIterator();
			//As this class is a CarPoolComposite, I can use this class for ensuring I further operate on CarPoolComposites.
			if(currentObject.getClass() == this.getClass()) {
				while(tier2Iter.hasNext(currentObject)) {
					System.out.print("     ");
					tier2Iter.next(currentObject).printSelf();
				}
			}
		}
	}
	
	/**
	 * A getter for the tree of this object.
	 * @return tree
	 */
	public ArrayList<CarPoolComponent> getTree(){ return tree;}
	
	/**
	 * This method returns a new iterator.
	 */
	public CarPoolIterator getIterator() {return new CarPoolIterator();}
	
	public void determineLazyCommuter() {}
	public void determineLazyCommuter(String name) {}
	public CarPoolComponent findCommuter(String personName) {return null;}
	public CarPoolComponent findCarpool(String cpName) {return null;}
	public CarPoolComponent addCommuter(CarPoolComponent person, CarPoolComponent cp) {return null;}
	public CarPoolComponent removeCommuter(CarPoolComponent person) {return null;}
	public CarPoolComponent addCarpool(CarPoolComponent cp, double distance) {return null;}
	public CarPoolComponent removeCarpool(CarPoolComponent cp) {return null;}
	public void moveCommuter(CarPoolComponent person, CarPoolComponent cp) {}
	
	/**
	 * This toggles a particular commuter in a carpool to be leader.
	 * The statuses for the commuters are reset to account for this.
	 * ONLY the head should use this method.
	 * @param person - The person to promote. 
	 * @param cp - The carpool to operate within.
	 */
	public void toggleLeader(CarPoolComponent person, CarPoolComponent cp) {
		//if there is no such carpool, leave. cpCopy is the entry found in the data structure.
		CarPoolComponent cpCopy = this.findCarpool(cp.getName());
		if(cpCopy == null || cpCopy.getStatus() == false) {
			System.out.println("Error: The carpool specified is either inactive or nonexistent.");
			return;
		}
		
		//Set up the iterator.
		CarPoolIterator CPiter = cp.getIterator();
		//A safety boolean for reporting the commuter's existence.
		boolean bFoundCommuter = false;
		
		while(CPiter.hasNext(cp)) {
			//Check for the valid commuter, first.
			CarPoolComponent currentObject = CPiter.next(cp);
			if(currentObject.equals(person) && currentObject.getStatus()) {
				person.setIsLeader(true);
				bFoundCommuter = true;
			}
		}
		
		//No more work to be done if the commuter does not exist.
		if(!bFoundCommuter) {
			System.out.println("Error: The commuter specified is either inactive or nonexistent.");
			return;
		}
		
		//reset the iterator
		CPiter.reset(cp);
		
		//Purge the carpool of isLeader = true.
		while(CPiter.hasNext(cp)) {
			//Use an if to reduce operations.
			CarPoolComponent currentObject = CPiter.next(cp);
			if(currentObject.getIsLeader()) {
				currentObject.setIsLeader(false);
				//Replace with the demoted commuter.
				this.removeCommuter(currentObject);
				this.addCommuter(currentObject, cp);
			}
		}
		
		//Finally, replace with the promoted commuter.
		this.removeCommuter(person);
		this.addCommuter(person, cp);
	}
	
	/**
	 * Activates this object.
	 */
	public void activate(String name) {this.setStatus(true);}
	
	/**
	 * Deactivates this object.
	 */
	public void deactivate(String name) {this.setStatus(false);}
	
	/**
	 * All methods below do no meaningful work as they are not considered to be a useful part of this class.
	 */
	
	public boolean getIsLeader() {return true;}
	public void setIsLeader(boolean isLeader_input) {}
}
