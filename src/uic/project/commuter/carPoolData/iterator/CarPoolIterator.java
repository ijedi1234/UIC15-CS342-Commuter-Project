// CarPoolIterator public class that implements the 
// CarPoolIteratorPrototype interface
public class CarPoolIterator implements CarPoolIteratorPrototype
{
	/** The fields that is used store the number of 
	 *  values in the object CarPoolComponent
	 */
	public int index;

	/** No-arg constructor just initializes the index
	 *  as -1
	 */
	public CarPoolIterator()
	{
		index = -1;
	}
	
	
	/** hasNext(obj) will check to see if there is any
	 *  additional entries to iterate through
	 *  
	 *  @param CarPoolComponent obj: The obj will be iterated 
	 *  through
	 *  
	 *  @return true if there exist an element else false
	 */
	@Override
	public boolean hasNext(CarPoolComponent obj) 
	{
		if(index < obj.getTree().size())
		{
			return true;
		}
		return false;
	}
		
	/** next(obj) will iterate to the next element of the 
	 *  obj
	 * 
	 *  @param CarPoolComponent obj: The obj will be iterated
	 *  to the next element
	 *  
	 *  @return obj's next element
	 */
	@Override
	public CarPoolComponent next(CarPoolComponent obj) 
	{
		if(this.hasNext(obj))
		{
			index++;
			return obj.get(index);
		}
		return null;
	}

	/** reset(obj) will reset the list so no element is in 
	 *  the list
	 * 
	 *  @param obj whose elements will be cleared off the list
	 */
	@Override
	public void reset(CarPoolComponent obj) 
	{
		index = -1;
	}
}
