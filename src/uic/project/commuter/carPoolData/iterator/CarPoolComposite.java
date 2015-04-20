package uic.project.commuter.carPoolData.iterator;

import uic.project.commuter.carPoolData.*;

import java.util.ArrayList;

public class CarPoolComposite extends CarPoolComponent {

	private ArrayList<CarPoolComponent> tree;
	
	public CarPoolComposite() {
		this.setName("");
		this.setStatus(true);
		this.resetDistance();
		tree = new ArrayList<CarPoolComponent>();
	}
	
	public CarPoolComposite(String tag, boolean inputStat, double dist) {
		this.setName(tag);
		this.setStatus(inputStat);
		this.resetDistance();
		this.addDistance(dist);
		tree = new ArrayList<CarPoolComponent>();
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
	
	/**
	 * Updates the distance for the commuters of all carpools, and resets the leader.
	 */
	public void determineLazyCommuter() {
		//Set up the iterator.
		CarPoolIterator iter = this.getIterator();
		while(iter.hasNext(this)) {
			CarPoolComponent obj = iter.next(this);
			double min = Double.MAX_VALUE;
			CarPoolComponent minObj = null;
			if(this.getClass() == obj.getClass()) {
				//Set up the iterator for the next tier.
				CarPoolIterator iterTier2 = this.getIterator();
				while(iterTier2.hasNext(obj)) {
					CarPoolComponent objTier2 = iterTier2.next(obj);
					if(objTier2.getIsLeader()) {
						objTier2.addDistance(obj.getDistanceTraveled());
					}
					if(objTier2.getDistanceTraveled() < min) {
						min = objTier2.getDistanceTraveled();
						minObj = objTier2;
					}
				}
				this.toggleLeader(minObj, obj);
			}
		}
	}
	
	/**
	 * Updates the distance for the commuters of a given carpool, and resets the leader.
	 * @param name - The name of the carpool
	 */
	public void determineLazyCommuter(String name) {
		//Set up the iterator.
		CarPoolIterator iter = this.getIterator();
		while(iter.hasNext(this)) {
			CarPoolComponent obj = iter.next(this);
			double min = Double.MAX_VALUE;
			CarPoolComponent minObj = null;
			if(this.getClass() == obj.getClass() && name.equals(obj.getName())) {
				//Set up the iterator for the next tier.
				CarPoolIterator iterTier2 = this.getIterator();
				while(iterTier2.hasNext(obj)) {
					CarPoolComponent objTier2 = iterTier2.next(obj);
					if(objTier2.getIsLeader()) {
						objTier2.addDistance(obj.getDistanceTraveled());
					}
					if(objTier2.getDistanceTraveled() < min) {
						min = objTier2.getDistanceTraveled();
						minObj = objTier2;
					}
				}
				this.toggleLeader(minObj, obj);
			}
		}
	}
	
	/**
	 * Finds a requested commuter by name.
	 * @param personName - The name of the requested commuter.
	 * @return the requested commuter, by copy.
	 */
	public CarPoolComponent findCommuter(String personName) {
		//Set up the iterator.
		CarPoolIterator iter = this.getIterator();
		while(iter.hasNext(this)) {
			CarPoolComponent obj = iter.next(this);
			if(this.getClass() == obj.getClass()) {
				//Set up the iterator for the next tier.
				CarPoolIterator iterTier2 = this.getIterator();
				while(iterTier2.hasNext(obj)) {
					CarPoolComponent objTier2 = iterTier2.next(obj);
					if(objTier2.getName().equals(personName)) {
						return objTier2;
					}
				}
			} else {
				if(obj.getName().equals(personName)) {
					return obj;
				}
			}
		}
		return null;
	}
	
	/**
	 * Finds a requested carpool by name.
	 * @param cpName - The name of the requested carpool.
	 * @return the requested carpool, by copy.
	 */
	public CarPoolComponent findCarpool(String cpName) {
		//Set up the iterator.
		CarPoolIterator iter = this.getIterator();
		while(iter.hasNext(this)) {
			CarPoolComponent obj = iter.next(this);
			//Checks for the object's status as a CarPoolComposite, and the equality of name.
			if(obj.getName().equals(cpName) && (obj.getClass() == this.getClass())) {
				return obj;
			}
		}
		return null;
	}
	
	/**
	 * Adds a constructed commuter to the system.
	 * ONLY the head should use this method in other classes.
	 * Prevents duplicate addition.
	 * @param person - The person to add. 
	 * @param cp - The carpool to operate within. (null for head)
	 * @return A receipt for the added person.
	 */
	public CarPoolComponent addCommuter(CarPoolComponent person, CarPoolComponent cp) {
		if(person == null || this.findCommuter(person.getName()) != null) { //Invalid person or existing person.
			return null;
		}
		person.setIsLeader(true); //Enforce leadership for commuter initially.
		if(cp == null) { //Null cp? Then it must be the head.
			tree.add(0, person);
			return person;
		}
		CarPoolIterator iter = new CarPoolIterator(); //Setup iterator & index.
		int index = 0;
		while(iter.hasNext(this)) { //Find the carpool, modify it, and return the receipt.
			CarPoolComponent obj = iter.next(this);
			if(obj.getClass() == this.getClass() && cp.equals(obj)) {
				if(obj.getTree().size() > 0)
					person.setIsLeader(false); //Further additions to non-zero carpools shouldn't be leaders at start.
				obj.addCommuter(person, null);
				tree.set(index, obj);
				return person;
			}
			index++;
		}
		//Can't find it? Return null.
		return null;
	}
	
	/**
	 * Removes a constructed commuter from the system.
	 * ONLY the head should use this method in other classes.
	 * @param person - The person to remove. 
	 * @return A receipt for the removed person.
	 */
	public CarPoolComponent removeCommuter(CarPoolComponent person) {
		if(person == null) { //Invalid person.
			return null;
		}
		CarPoolIterator iter = new CarPoolIterator(); //Setup iterator & index.
		int index = 0;
		while(iter.hasNext(this)) { //Find the commuter and remove. If carpools are found, apply this method.
			CarPoolComponent obj = iter.next(this);
			if(obj.getClass() == this.getClass()) {
				obj.removeCommuter(person);
				tree.set(index, obj);
				return person;
			} else if(obj.equals(person)) {
				tree.remove(index);
				return person;
			}
			index++;
		}
		return null;
	}
	
	/**
	 * Adds a constructed carpool to the system.
	 * ONLY the head should use this method in other classes.
	 * @param cp - The carpool to add.
	 * @param distance - A duplicate distance value for saving a function call.
	 * @return A receipt for the added carpool.
	 */
	public CarPoolComponent addCarpool(CarPoolComponent cp, double distance) {
		if(cp == null || this.findCarpool(cp.getName()) != null) { //Invalid carpool or existing carpool.
			return null;
		}
		tree.add(cp); //Add to the end and return.
		return cp;
	}
	
	/**
	 * Removes a constructed carpool to the system.
	 * ONLY the head should use this method in other classes.
	 * @param cp - The carpool to remove.
	 * @return A receipt for the removed carpool. 
	 */
	public CarPoolComponent removeCarpool(CarPoolComponent cp) {
		if(cp == null) { //Invalid carpool.
			return null;
		}
		CarPoolIterator iter = new CarPoolIterator(); //Setup iterator & index.
		int index = 0;
		while(iter.hasNext(this)) { //Find the carpool, modify it, and return the receipt.
			CarPoolComponent obj = iter.next(this);
			if(obj.getClass() == this.getClass() && cp.equals(obj)) {
				tree.remove(index);
				return cp;
			}
			index++;
		}
		return cp;
	}
	
	/**
	 * Moves a commuter to the suggested carpool. (null is head)
	 * ONLY the head should use this method in other classes.
	 * @param person - The person to move. The caller is responsible for generating the correct person.
	 * @param cp - The carpool to move too.
	 */
	public void moveCommuter(CarPoolComponent person, CarPoolComponent cp) {
		//Determine validness, and remove->add
		if(person == null) {
			return;
		}
		this.removeCommuter(person);
		this.addCommuter(person, cp);
	}
	
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
	public void activate(String name) {
		CarPoolIterator iter = this.getIterator();
	
		while(iter.hasNext(this)) {
			CarPoolComponent currentObject = iter.next(this);
			if(currentObject.getName().equals(name) && this.getClass() == currentObject.getClass()) {
				this.removeCarpool(currentObject);
				currentObject.setStatus(true);
				this.addCarpool(currentObject, currentObject.getDistanceTraveled());
			} else if(currentObject.getName().equals(name)) {
				this.removeCommuter(currentObject);
				currentObject.setStatus(true);
				this.addCommuter(currentObject, null);
			}
			CarPoolIterator tier2Iter = this.getIterator();
			//As this class is a CarPoolComposite, I can use this class for ensuring I further operate on CarPoolComposites.
			if(currentObject.getClass() == this.getClass()) {
				while(tier2Iter.hasNext(currentObject)) {
					CarPoolComponent objTier2 = tier2Iter.next(currentObject);
					this.removeCommuter(objTier2);
					objTier2.setStatus(true);
					this.addCommuter(objTier2, null);
				}
			}
		}
	}
	
	/**
	 * Deactivates this object.
	 */
	public void deactivate(String name) {
		CarPoolIterator iter = this.getIterator();
	
		while(iter.hasNext(this)) {
			CarPoolComponent currentObject = iter.next(this);
			if(currentObject.getName().equals(name) && this.getClass() == currentObject.getClass()) {
				this.removeCarpool(currentObject);
				currentObject.setStatus(false);
				this.addCarpool(currentObject, currentObject.getDistanceTraveled());
			} else if(currentObject.getName().equals(name)) {
				this.removeCommuter(currentObject);
				currentObject.setStatus(false);
				this.addCommuter(currentObject, null);
			}
			CarPoolIterator tier2Iter = this.getIterator();
			//As this class is a CarPoolComposite, I can use this class for ensuring I further operate on CarPoolComposites.
			if(currentObject.getClass() == this.getClass()) {
				while(tier2Iter.hasNext(currentObject)) {
					CarPoolComponent objTier2 = tier2Iter.next(currentObject);
					this.removeCommuter(objTier2);
					objTier2.setStatus(false);
					this.addCommuter(objTier2, null);
				}
			}
		}
	}
	
	/**
	 * All methods below do no meaningful work as they are not considered to be a useful part of this class.
	 */
	
	public boolean getIsLeader() {return true;}
	public void setIsLeader(boolean isLeader_input) {}
}
