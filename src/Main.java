import java.util.*;
public class Main {
	
	volatile long time1=0, time2=0, time3=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IStack<Integer> Stack1 = new LinkedStack();
		IStack<Integer> Stack2 = new StackWithArray();
		IStack<Integer> Stack3 = new StackWithSecondList();
		Main main = new Main();
		main.adding(Stack1, Stack2, Stack3, 100000);
		System.out.println("ok");
		main.change(Stack1, Stack2, Stack3, 10000);
	}
	
	public void adding(IStack<Integer> Stack1, IStack<Integer> Stack2, IStack<Integer> Stack3, int n)
	{
		Random g = new Random();
		int stack;
		for(int i=0; i<n; i++)
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
			else
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
	
	public void change(IStack<Integer> Stack1, IStack<Integer> Stack2, IStack<Integer> Stack3, int M)
	{
		Random g = new Random();
		int stack, pushed1=0, pushed2=0, pushed3=0, popped1=0, popped2=0, popped3=0;
		long Start, Stop;
		Integer value=null;
		for(int i=0; i<M; i++)
		{
			stack = g.nextInt(3)+1;
			if(stack == 1)
			{
				try {
					Start = System.nanoTime();
					value = Stack1.pop();
					Stop = System.nanoTime();
					time1 += Stop - Start;
					popped1++;
				}catch (EmptyStackException e)
				{
					System.out.println(e.getMessage());
				}
			}
			else if(stack == 2)
			{
				try {
					Start = System.nanoTime();
					value = Stack2.pop();
					Stop = System.nanoTime();
					time2 += Stop - Start;
					popped2++;
				}catch (EmptyStackException e)
				{
					System.out.println(e.getMessage());
				}
			}
			else
			{
				try {
					Start = System.nanoTime();
					value = Stack3.pop();
					Stop = System.nanoTime();
					time3 += Stop - Start;
					popped3++;
				}catch (EmptyStackException e)
				{
					System.out.println(e.getMessage());
				}
			}
			stack = g.nextInt(3)+1;
			if(stack == 1)
			{
				try {
					Start = System.nanoTime();
					Stack1.push(value);
					Stop = System.nanoTime();
					time1 += Stop - Start;
					pushed1++;
				}catch (FullStackException e)
				{
					System.out.println(e.getMessage());
				}
			}
			else if(stack == 2)
			{
				try {
					Start = System.nanoTime();
					Stack2.push(value);
					Stop = System.nanoTime();
					time2 += Stop - Start;
					pushed2++;
				}catch (FullStackException e)
				{
					System.out.println(e.getMessage());
				}
			}
			else
			{
				try {
					Start = System.nanoTime();
					Stack3.push(value);
					Stop = System.nanoTime();
					time3 += Stop - Start;
					pushed3++;
				}catch (FullStackException e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
		System.out.println("time for Stack 1: " + time1/(pushed1+popped1));
		System.out.println("time for Stack 2: " + time2/(pushed2+popped2));
		System.out.println("time for Stack 3: " + time3/(pushed3+popped3));
	}
}