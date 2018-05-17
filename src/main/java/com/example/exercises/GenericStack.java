package com.example.exercises;

import java.util.*;

public class GenericStack<T> {
	private List<T> stack = new ArrayList<T>();
	private int top = 0;

	public int size() {
		return top;
	}
	
	public T peek() {
		if (top == 0) return null;
		return stack.get(top-1);
	}

	public void push(T item) {
		stack.add(top++, item);
	}

	public T pop() {
		if (top == 0) return null;
		return stack.remove(--top);
	}
	
	public List<T> popAll() {
		List<T> popped= new ArrayList<T>(stack);
		stack.clear();
		top = 0;
		return popped;
	}

	public static void main(String[] args) {
		GenericStack<Integer> s = new GenericStack<Integer>();
		s.push(17);
		s.push(22);
		s.push(99);
		s.pop();
		System.out.println(s.popAll().size());
		s.push(1);
		s.push(15);
		int i = s.pop();
		System.out.format("%4d%n", i);
		System.out.println(s.peek());
	}

}

