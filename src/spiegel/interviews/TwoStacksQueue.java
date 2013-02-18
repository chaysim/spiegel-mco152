package spiegel.interviews;

import java.util.Stack;

public class TwoStacksQueue<E> {

	private Stack<E> original;
	private Stack<E> queue;
	
	public TwoStacksQueue(Stack<E> stack1) {
		this.original = stack1;
		this.queue = new Stack<E>();
		transform(original, queue);
	}

	public void transform(Stack<E> stack1, Stack<E> stack2) {
		while (!stack1.isEmpty()) {
			E varE = stack1.pop();
			stack2.push(varE);
		}

	}
	
	public void enqueue(E item)
	{
		transform(queue, original);
		original.push(item);
		transform(original, queue);
		
	}
	
	public E dequeue()
	{
		return queue.pop();
	}
	
	public E peek()
	{
		return queue.peek();
	}

	public String toString() {

		String que = "";
		while (!queue.isEmpty()) {
			que += queue.pop();
		}
		return que;
	}

	public static void main(String[] args) {
		String[] letters = { "d", "b", "a" };
		Stack<String> letter = new Stack<String>();
		for (int i = 0; i < letters.length; i++) {
			letter.push(letters[i]);
		}
		
		TwoStacksQueue<String> test = new TwoStacksQueue<String>(letter);
		System.out.println(test.toString());
		test.enqueue("f");
		System.out.println(test.queue.peek());
		test.enqueue("g");
		System.out.println(test.queue.peek());
		test.enqueue("h");
		System.out.println(test.queue.peek());
		System.out.println(test.dequeue());
		test.enqueue("f");
		System.out.println(test.toString());
	}

}