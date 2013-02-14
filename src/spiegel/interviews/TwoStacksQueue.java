package spiegel.interviews;

import java.util.Stack;

public class TwoStacksQueue<E> {

	private Stack<E> original;
	private Stack<E> queue;
	private int size;

	public TwoStacksQueue(Stack<E> stack1) {
		this.original = stack1;
		this.queue = new Stack<E>();
		this.size = original.size();
		transform(original, queue);
	}

	public void transform(Stack<E> stack1, Stack<E> stack2) {
		for (int i = 0; i < size; i++) {
			E varE = stack1.pop();
			stack2.push(varE);
		}

	}
	
	public void enqueue(E item)
	{
		transform(queue, original);
		original.push(item);
		size++;
		transform(original, queue);
		
	}
	
	public E dequeue()
	{
		size--;
		return queue.pop();
	}

	public String toString() {

		String que = "";
		for (int i = 0; i < size; i++) {
			que += queue.pop();
		}
		size = 0;
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