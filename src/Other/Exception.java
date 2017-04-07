package Other;

import java.util.EmptyStackException;
import java.util.Stack;

public class Exception {
	private static Stack<Integer> s = new Stack<>();
	static void popEmptyStack() throws EmptyStackException{
		try{
			s.pop();
		} catch (NullPointerException e){
			System.out.println("1");
		} catch (EmptyStackException e){
			System.out.println("2");
		} catch (Throwable e){
			System.out.println("3");
		}
		
		try{
			s.pop();
		} catch (NullPointerException|EmptyStackException e){
			System.out.println("1 or 2");
			e.printStackTrace();
		} catch (Throwable e){
			System.out.println("3");
		} finally {
			System.out.println("This line will always be called");
		}
	}
	static void pushForever() {
		try{
			s.push(1);
		} catch (StackOverflowError e){
			System.err.println("She's gonna blow!");
		}
		Exception.pushForever();
	}
}
