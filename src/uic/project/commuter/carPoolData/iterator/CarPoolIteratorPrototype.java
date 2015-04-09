package uic.project.commuter.carPoolData.iterator;

import uic.project.commuter.carPoolData.*;

public interface CarPoolIteratorPrototype {
	
	public boolean hasNext(CarPoolComponent obj);
	public CarPoolComponent next(CarPoolComponent obj);
	public void reset(CarPoolComponent obj);
	
}
