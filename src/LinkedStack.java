
public class LinkedStack implements IStack<Integer>{
	
	IList<Integer> list;
	public LinkedStack(){
		list = new OneWayLinkedListWithHead<Integer>();
	}
	@Override
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
	@Override
	public boolean isFull() 
	{
		return false;
	}
	@Override
	public Integer pop() throws EmptyStackException 
	{
		if(list.isEmpty()) 
			throw new EmptyStackException(); 
		else
		{
			Integer value = list.remove(0);
			return value;
		}
	}
	@Override
	public void push(Integer elem) throws FullStackException 
	{
		list.add(0,elem);
	}
	@Override
	public int size() 
	{
		return list.size();
	}
	@Override
	public Integer top() throws EmptyStackException 
	{
		Integer value=list.get(0);
		if(value==null) 
			throw new EmptyStackException(); 
		return value;
	}
	public void clear() 
	{
		list = null;
	}
}
