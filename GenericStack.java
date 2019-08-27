/**
Sydney Davidson 
CSI 213
Project 3
*/

import java.util.ArrayList;
public class GenericStack<String>{
	  /**
	   * The list of objects of this stack
	   */
	   private java.util.ArrayList<String> list;

	   /**
	   maximum size of the stack
	   */
	   private final int MAX = 52;

		/**
		Construct an empty stack with a max size of 52
		when top value is -1, the stack is empty
		*/
		public GenericStack(){
			list = new ArrayList<String>(MAX);
			
		}


		/**
		Gets the size of the stack
		@return int 
		*/
		public int getSize(){
			return list.size();

		}

		/**
		Looks at the last object added to the stack
		without removing it
		@return String
		*/
		public String peek(){
			int n = list.size();
			return list.get(n-1);
		}

		/**
		Add an Object to the stack
		@param String
		@return String the object being added
		*/
		public String push(String obj){
			if(!isFull())
				list.add(obj);
			return obj;

		}

		/**
		Removes the last object from the stack
		@return the object at the top of the stack
		*/
		public String pop(){
			if(!list.isEmpty()){
				String last;
				last = list.remove((list.size()-1));
				return last;
			}
			return null;
		}

		/**
		Tests if the stack is empty
		@return boolean 
		*/
		public boolean isEmpty(){
			return list.isEmpty();

		}
		/**
		Tests if the stack is full
		@return boolean
		*/
		public boolean isFull(){
			if(list.size() == MAX)
				return true;
			else{
				return false;
			}
		}	  
}
