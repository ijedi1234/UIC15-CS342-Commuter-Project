// interface of CarPoolIteratorPrototype
public interface CarPoolIteratorPrototype 
{
	/** hasNext(obj) will check to see if there is any
	 *  additional entries to iterate through
	 *  
	 *  @param CarPoolComponent obj: The obj will be iterated 
	 *  through
	 *  
	 *  @return true if there exist an element else false
	 */
	public boolean hasNext(CarPoolComponent obj);
	
	/** next(obj) will iterate to the next element of the 
	 *  obj
	 * 
	 *  @param CarPoolComponent obj: The obj will be iterated
	 *  to the next element
	 *  
	 *  @return obj's next element
	 */
	public CarPoolComponent next(CarPoolComponent obj);
	
	/** reset(obj) will reset the list so no element is in 
	 *  the list
	 * 
	 *  @param obj whose elements will be cleared off the list
	 */
	public void reset(CarPoolComponent obj);
}
