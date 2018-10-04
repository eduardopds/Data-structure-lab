package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (element != null) {
			if (!isFull()) {
				list.insert(element);
			} else {
				throw new QueueOverflowException();
			}

		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
	
		if (!isEmpty()) {
			T retorno = (T) ((DoubleLinkedListImpl<T>) list).getHead().getData();
			list.removeFirst();
			return retorno;

		} else {
			throw new QueueUnderflowException();
		}
	}

	@Override
	public T head() {
		T head  = null;
		if(!isEmpty()) {
			head = ((DoubleLinkedListImpl<T>) list).getHead().getData();
		}
		return head;
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return (size == list.size());
	}

}
