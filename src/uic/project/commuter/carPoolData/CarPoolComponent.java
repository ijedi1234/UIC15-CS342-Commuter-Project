package uic.project.commuter.carPoolData;

import uic.project.commuter.carPoolData.iterator.*;
import java.util.ArrayList;

public abstract class CarPoolComponent {
	String name;
	boolean status;
	double distanceTraveled;
	
	public abstract void printLevel();
	public abstract void printAll();
	public abstract void printSelf();
	public abstract boolean equals(CarPoolComponent obj);
	public abstract ArrayList<CarPoolComponent> getTree();
	public abstract CarPoolIterator getIterator();
	public abstract CarPoolComponent determineLazyCommuter();
	public abstract CarPoolComponent findCommuter(String personName, CarPoolComponent cp);
	public abstract CarPoolComponent findCarpool(String cpName);
	public abstract CarPoolComponent addCommuter(CarPoolComponent person, CarPoolComponent cp);
	public abstract CarPoolComponent removeCommuter(CarPoolComponent person, CarPoolComponent cp);
	public abstract CarPoolComponent addCarpool(CarPoolComponent cp);
	public abstract CarPoolComponent removeCarpool(CarPoolComponent cp);
	public abstract void moveCommuter(CarPoolComponent person, CarPoolComponent cp);
	public abstract void toggleLeader(CarPoolComponent person, CarPoolComponent cp);
	public abstract boolean getIsLeader();
	public abstract void setIsLeader(boolean isLeader_input);
	
	public boolean getStatus() {return status;}
	
	public void setStatus(boolean status) {this.status = status;}
	
	public String getName() {return name;}
	
	public void setName(String name) {this.name = name;}
	
	public double getDistanceTraveled() {return distanceTraveled;}
	
	public void addDistance(double distanceTraveled) {this.distanceTraveled = distanceTraveled;}
	
	public void resetDistance() {distanceTraveled = 0;}
}
