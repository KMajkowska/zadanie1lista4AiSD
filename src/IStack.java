
public interface IStack<Integer>
{
	boolean isEmpty();
	boolean isFull();
	Integer pop() throws EmptyStackException;
	void push(Integer elem) throws FullStackException;
	int size(); // zwraca liczb� element�w na stosie 
	Integer top() throws EmptyStackException; 
	// zwraca element ze szczytu stosu bez usuwania go
}
