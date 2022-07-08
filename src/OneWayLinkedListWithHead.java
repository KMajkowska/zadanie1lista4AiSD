
public class OneWayLinkedListWithHead<Integer> implements IList<Integer>{
	
	Element head=null;
	public OneWayLinkedListWithHead() {
		
	}
	public boolean isEmpty()
	{
		return head==null;
	}

	public void clear() 
	{
		head=null;
	}
	public int size() {
		int pos=0;
		Element actElem=head;
		while(actElem!=null)
		{
			pos++;
			actElem=actElem.getNext();
		}
		return pos;
	}
	
	private Element getElement(int index)
	{
		if(index<0) throw new IndexOutOfBoundsException();
		Element actElem=head;
		while(index>0 && actElem!=null){
			index--;
			actElem=actElem.getNext();
		}
		if (actElem==null)
			throw new IndexOutOfBoundsException();
		return actElem;
	}
	public boolean add(Integer e) {
		Element newElem=new Element(e);
		if(head==null){
			head=newElem;
			return true;
		}
		Element tail=head;
			while(tail.getNext()!=null)
				tail=tail.getNext();
		tail.setNext(newElem);
		return true;
	}
	
	public void add(int index, Integer data) {
		if(index<0) throw new IndexOutOfBoundsException();
			Element newElem=new Element(data);
		if(index==0)
		{
			newElem.setNext(head);
			head=newElem;
		}
		else 
		{
			Element actElem=getElement(index-1);
			newElem.setNext(actElem.getNext());
			actElem.setNext(newElem);
		}
	}

	public int indexOf(Integer data) {
		int pos=0;
		Element actElem=head;
		while(actElem!=null)
		{
			if(actElem.getValue().equals(data))
				return pos;
			pos++;
			actElem=actElem.getNext();
		}
		return -1;
	}
	

	public boolean contains(Integer data) 
	{
		return indexOf(data)>=0;
	}

	public Integer get(int index) 
	{
		Element actElem=getElement(index);
		return (Integer)actElem.getValue();
	}

	public Integer set(int index, Integer data) 
	{
		Element actElem=getElement(index);
		Integer elemData=(Integer)actElem.getValue();
		actElem.setValue(data);
		return elemData;
	}


	public Integer remove(int index) 
	{
		if(index<0 || head==null) throw new IndexOutOfBoundsException();
		if(index==0)
		{
			Integer retValue=(Integer)head.getValue();
			head=head.getNext();
			return retValue;
		}
		Element actElem=getElement(index-1);
		if(actElem.getNext()==null)
			throw new IndexOutOfBoundsException();
		Integer retValue=(Integer)actElem.getNext().getValue();
		actElem.setNext(actElem.getNext().getNext());
		return retValue;
	}

	public boolean remove(Element value) {
		if(head==null) 
			return false;
		if(head.getValue().equals(value.getValue()))
		{
			head=head.getNext();
			return true;
		}
		Element actElem=head;
		while(actElem.getNext()!=null && !actElem.getNext().getValue().equals(value.getValue())) 
			actElem=actElem.getNext();
		if(actElem.getNext()==null)	
				return false;
		actElem.setNext(actElem.getNext().getNext());
		return true;
	}

}
