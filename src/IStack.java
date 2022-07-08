
public interface IStack<Integer>
{
	boolean isEmpty();
	boolean isFull();
	Integer pop() throws EmptyStackException;
	void push(Integer elem) throws FullStackException;
	int size(); // zwraca liczbê elementów na stosie 
	Integer top() throws EmptyStackException; 
	// zwraca element ze szczytu stosu bez usuwania go
}
