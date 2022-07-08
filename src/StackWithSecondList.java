public class StackWithSecondList<Integer> implements IStack<Integer>{
	
	IList<Integer> list;
	IList<Integer> secondList;
	public StackWithSecondList()
	{
		list = new OneWayLinkedListWithHead<Integer>();
		secondList = new OneWayLinkedListWithHead<Integer>();
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
		if(isEmpty())
			throw new EmptyStackException();
		else
		{
			Integer value = list.remove(0);
			ReleaseElement(value);
			return value;
		}
	}
	@Override
	public void push(Integer elem) throws FullStackException 
	{
		if(ProduceElement() == null)
		{
			list.add(0, elem);
		}
		else
		{
			list.add(0, ProduceElement());			
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
		Integer value=list.get(0);
		if(value==null) 
			throw new EmptyStackException(); 
		return value;
	}
	
	public Integer ProduceElement()
	{
		if(!secondList.isEmpty())
		{
			Integer value = secondList.remove(0);
			return value;
		}
		else
			return null;
	}
	
	public void ReleaseElement(Integer value)
	{
		secondList.add(0, value);
	}
	public void clear() 
	{
		list = null;
	}

}
