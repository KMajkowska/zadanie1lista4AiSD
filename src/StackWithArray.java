
public class StackWithArray implements IStack<Integer>{
	
	IList<Element<int []>> list;
	int place;
	public StackWithArray()
	{
		list = new OneWayLinkedListWithHead<Element<int []>>();
		place = 0;
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
		place--;
		if(place != -1) 
		{
			return list.get(0).getValue()[place + 1];
		}
		else 
		{
			list.remove(0);
			if(list.isEmpty())
				throw new EmptyStackException();
			place = 1023;
			return list.get(0).getValue()[place];
		}	
	}
	@Override
	public void push(Integer elem) throws FullStackException {
		place++;
		if(list.isEmpty()) {
			int [] elements = new int [1024];
			elements[0] = elem;
			list.add(0, new Element(elements));
		}
		else {
			if(place != 1024) {
				list.get(0).getValue()[place - 1] = elem;
			}
			else {
				place = 0;
				int [] elements = new int [1024];
				elements[place] = elem;
				Element newArray = new Element(elements);
				list.add(0, newArray);
			}
		}
	}
	@Override
	public int size() 
	{
		return list.size();
	}
	@Override
	public Integer top() throws EmptyStackException 
	{
		Integer value=list.get(0).getValue()[place];
		if(value==null) 
			throw new EmptyStackException(); 
		return value;
	}
	public void clear() 
	{
		list = null;
	}
}
