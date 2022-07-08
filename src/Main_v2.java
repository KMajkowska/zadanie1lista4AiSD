import java.util.Random;

public class Main_v2 {
	
	volatile long time1;
	volatile long time2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_v2 main = new Main_v2();
		long time =0;
		IStack<Integer>LinkedStack1 = new LinkedStack();
		IStack<Integer>LinkedStack2 = new LinkedStack();
		IStack<Integer>LinkedStack3 = new LinkedStack();
		main.adding(LinkedStack1, LinkedStack2, LinkedStack3, 10000000);
		System.out.println("Time for LinkedStack: " + main.change_Stack(LinkedStack1, LinkedStack2, LinkedStack3, 10000000) + " miliseconds");
		IStack<Integer>StackWithArray1 = new StackWithArray();
		IStack<Integer>StackWithArray2 = new StackWithArray();
		IStack<Integer>StackWithArray3 = new StackWithArray();
		main.adding(StackWithArray1, StackWithArray2, StackWithArray3, 10000000);
		System.out.println("Time for StackWithArray: " + main.change_Stack(StackWithArray1, StackWithArray2, StackWithArray3,10000000) + " miliseconds");
		IStack<Integer>StackWithSecondList1 = new StackWithSecondList<Integer>();
		IStack<Integer>StackWithSecondList2 = new StackWithSecondList<Integer>();
		IStack<Integer>StackWithSecondList3 = new StackWithSecondList<Integer>();
		main.adding(StackWithSecondList1, StackWithSecondList2, StackWithSecondList3, 10000000);
		System.out.println("Time for StackWithSecondList: " + main.change_Stack(StackWithSecondList1, StackWithSecondList2, StackWithSecondList3, 10000000) + " miliseconds");
	}
	
	public void adding(IStack<Integer> Stack1, IStack<Integer> Stack2, IStack<Integer> Stack3, int N)
	{
		Random g = new Random();
		int stack;
		for(int i=0; i<N; i++)
		{
			stack = g.nextInt(3)+1;
			int tmp = g.nextInt();
			Integer number = new Integer(tmp);
			if(stack == 1)
			{
				try {
					Stack1.push(number);
				}catch (FullStackException e)
				{
					System.out.println(e.getMessage());
				}
			}
			else if(stack == 2)
			{
				try {
					Stack2.push(number);
				}catch (FullStackException e)
				{
					System.out.println(e.getMessage());
				}
			}
			else if(stack == 3)
			{
				try {
					Stack3.push(number);
				}catch (FullStackException e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	public long change_Stack(IStack<Integer> Stack1, IStack<Integer> Stack2, IStack<Integer> Stack3, int M)
	{
		Random g = new Random();
		time2=0;
		int stack;
		time1=0;
		long Start, Stop, Start2, Stop2;
		Integer value=null;
		Start2 = System.currentTimeMillis();
		for(int i=0; i<M; i++)
		{
			stack = g.nextInt(3)+1;
			if(stack == 1)
			{
				try {
					Start = System.currentTimeMillis();
					value = Stack1.pop();
					Stop = System.currentTimeMillis();
					time1 += Stop - Start;
				}catch (EmptyStackException e)
				{
					System.out.println(e.getMessage());
				}
			}
			else if(stack == 2)
			{
				try {
					Start = System.currentTimeMillis();
					value = Stack2.pop();
					Stop = System.currentTimeMillis();
					time1 += Stop - Start;
				}catch (EmptyStackException e)
				{
					System.out.println(e.getMessage());
				}
			}
			else if(stack ==3)
			{
				try {
					Start = System.currentTimeMillis();
					value = Stack3.pop();
					Stop = System.currentTimeMillis();
					time1 += Stop - Start;
				}catch (EmptyStackException e)
				{
					System.out.println(e.getMessage());
				}
			}
			stack = g.nextInt(3)+1;
			if(stack == 1)
			{
				try {
					Start = System.currentTimeMillis();
					Stack1.push(value);
					Stop = System.currentTimeMillis();
					time1 += Stop - Start;

				}catch (FullStackException e)
				{
					System.out.println(e.getMessage());
				}
			}
			else if(stack == 2)
			{
				try {
					Start = System.currentTimeMillis();
					Stack2.push(value);
					Stop = System.currentTimeMillis();
					time1 += Stop - Start;
				}catch (FullStackException e)
				{
					System.out.println(e.getMessage());
				}
			}
			else if(stack == 3)
			{
				try {
					Start = System.currentTimeMillis();
					Stack3.push(value);
					Stop = System.currentTimeMillis();
					time1 += Stop - Start;
				}catch (FullStackException e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
		Stop2 = System.currentTimeMillis();
		time2 = Stop2 - Start2;
		return time1;
	}
	
	/*public void adding_equal(IStack<Integer> Stack1, IStack<Integer> Stack2, IStack<Integer> Stack3, int N)
	{
		Random g = new Random();
		int stack;
		int size = N/3;
		for(int i=0; i<size; i++)
		{
			int tmp = g.nextInt();
			Integer number = new Integer(tmp);
			try {
				Stack1.push(number);
			}catch(FullStackException e) {
				System.out.println(e.getMessage());
			}
		}
		for(int i=0; i<size; i++)
		{
			int tmp = g.nextInt();
			Integer number = new Integer(tmp);
			try {
				Stack2.push(number);
			}catch(FullStackException e) {
				System.out.println(e.getMessage());
			}
		}
		for(int i=0; i<size; i++)
		{
			int tmp = g.nextInt();
			Integer number = new Integer(tmp);
			try {
				Stack3.push(number);
			}catch(FullStackException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}*/

}
