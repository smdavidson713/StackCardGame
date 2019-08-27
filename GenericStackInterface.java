/**
Sydney Davidson 
CSI 213
Project 3
*/

public interface GenericStackInterface<String>{

	/**
	Gets the size of the stack
	@return int 
	*/
	public int getSize();

	/**
	Looks at the last object added to the stacks
	without removing it
	@return String 
	*/
	public String peek();

	/**
	Add an Object to the stack
	@param String
	@return String the object being added
	*/
	public String push(String obj);

	/**
	Removes the last object from the stack
	@return the object at the top of the stack
	*/
	public String pop();

	/**
	Tests if the stack is empty
	@return boolean 
	*/
	public boolean isEmpty();

	/**
	Tests if the stack is full
	@return boolean
	*/
	public boolean isFull();

	}
