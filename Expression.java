/**
Sydney Davidson
Lab 8 / project 3
CSI 213
*/
import java.lang.Character;
import java.util.ArrayList;
import java.lang.String;
import java.util.StringTokenizer;
public class Expression{

	private ArrayList<String> infix = new ArrayList<>();
	private ArrayList<String> postfix = new ArrayList<>();

	public Expression(String exp){
		for(int i=0; i < exp.length(); i++){
			if(i+1 < exp.length()){
				if(Character.isDigit(exp.charAt(i)) && Character.isDigit(exp.charAt(i+1))){
					String dig1 = Character.toString(exp.charAt(i));
					String dig2 = Character.toString(exp.charAt(i+1));
					String number = dig1+dig2;
					infix.add(number);
					i++;
				}
				else{
					infix.add(Character.toString(exp.charAt(i)));
				}

			}
			else{
				infix.add(Character.toString(exp.charAt(i)));
			}
		}
	}

	/**
	Converts an infix expression to a 
	postfix expression
	@return ArrayList 
	*/

	public ArrayList<String> infixToPostfix(){
		GenericStack<String> stack = new GenericStack<>();
		for(int i = 0; i < infix.size(); i++){
			String ch = infix.get(i);
			char c = ch.charAt(0);
			if(Character.isDigit(c)){
				postfix.add(infix.get(i));
			}
			else if(ch.compareTo("(") == 0){
				stack.push(ch);
			}
			else if(isOp(c)){
				if(stack.isEmpty()){
					stack.push(ch);

				}
				else if(!stack.isEmpty()){
					while(!stack.isEmpty()){
						if(stack.peek() == ")"){
							stack.push(ch);
							break;
						}
						if(prec(stack.peek().charAt(0)) < prec(c)){
							stack.push(ch);
							break;
						}
						if(prec(stack.peek().charAt(0)) > prec(c)){
							postfix.add(stack.pop());
						}
						if(prec(stack.peek().charAt(0)) == prec(c)){
							postfix.add(stack.pop());
							stack.push(ch);
							break;
						}
					}
				}

			}
			else if(ch.compareTo(")") == 0){
				while(!stack.isEmpty()){
					if(stack.peek().compareTo("(") == 0){
						stack.pop();
						break;
					}
					postfix.add(stack.pop());
				}
			}
		}

		while(!stack.isEmpty()){
			if(stack.peek().compareTo("(") == 0){
				stack.pop();
				break;
			}
			postfix.add(stack.pop());
		}
		return postfix;
	}


	/**
	Evaluates the postfix expression from the previous
	method and returns the result from this method
	@return int 
	*/

	public int evaluate(){
		postfix = this.infixToPostfix();
		GenericStack<String> stack = new GenericStack<>();
		for(int i = 0; i < postfix.size(); i++){
			String ch = postfix.get(i);
			char c = ch.charAt(0);

			if(Character.isDigit(c))
				stack.push(ch);
			else{
				int x = Integer.parseInt(stack.pop());
				int y = Integer.parseInt(stack.pop());

				switch(c){

					case '+':
					stack.push(Integer.toString(y+x));
					break;

					case '-':
					stack.push(Integer.toString(y-x));
					break;

					case '*':
					stack.push(Integer.toString(y*x));
					break;

					case '/':
					stack.push(Integer.toString(y/x));
					break;
				}

			}
			
		}
		return Integer.parseInt(stack.pop());
	}

	/**
	Determines if the character is an operator
	@return char
	*/
	public boolean isOp(char ch){

		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

	/**
	Checks the precedence of the operators
	@param char
	@return int
	*/

	public int prec(char ch){
		switch(ch){
			case '+':
			case '-':

			return 1;

			case '*':
			case'/':

			return 2;
		}
		return -1;
	}

	/**
	sets the infix expression
	@param String
	*/

	public void setInfix(ArrayList<String> infix){
		this.infix = infix;
	}

	/**
	Gets the infix expression
	@return string
	*/

	public ArrayList<String> getInfix(){
		return infix;
	}

	/**
	sets the postfix expression
	@param String
	*/

	public void setPostix(ArrayList<String> postfix){
		this.postfix = postfix;
	}

	/**
	Gets the postfix expression
	@return string
	*/

	public ArrayList<String> getPostfix(){
		return postfix;
	}
}