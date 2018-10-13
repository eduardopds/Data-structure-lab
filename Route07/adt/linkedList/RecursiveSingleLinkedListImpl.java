package adt.linkedList;

import java.util.Arrays;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T>, Comparable {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	public static void main(String[] args) {
		RecursiveSingleLinkedListImpl<Integer> lista = new RecursiveSingleLinkedListImpl<Integer>();
		lista.insert(10);
		lista.insert(6);
		lista.insert(8888);
	
		
		System.out.println((lista.maior().getData()));


	}

	public RecursiveSingleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		boolean isEmpty = false;
		if (data == null) {
			isEmpty = true;
		}
		return isEmpty;

	}

	@Override
	public int size() {
		int tamanho;
		if (isEmpty()) {
			tamanho = 0;
		} else {
			tamanho = 1 + next.size();
		}
		return tamanho;
	}

	@Override
	public T search(T element) {
		T saida = null;
		if (isEmpty()) {

		} else {
			if (this.getData().equals(element)) {
				saida = this.getData();
			} else {
				saida = this.getNext().search(element);
			}
		}
		return saida;
	}

	@Override
	public void insert(T element) {
		if (element != null) {

			if (isEmpty()) {
				this.setData(element);
				this.setNext(new RecursiveSingleLinkedListImpl<T>());
			}

			else {
				this.getNext().insert(element);
			}

		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty()) {
			if (this.getData().equals(element)) {
				this.setData(this.getNext().getData());
				this.setNext(this.getNext().getNext());
			} else {
				this.getNext().remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[this.size()];
		auxArray(result, this, 0);
		return result;
	}

	public void auxArray(T[] array, RecursiveSingleLinkedListImpl<T> node, int i) {
		if (!node.isEmpty()) {
			array[i] = node.getData();
			auxArray(array, node.getNext(), ++i);

		}

	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

	public RecursiveSingleLinkedListImpl<T> maior() {
		RecursiveSingleLinkedListImpl<T> maior = this;
		

		if (this.next != null && !this.next.isEmpty()) {
			maior = this;
			RecursiveSingleLinkedListImpl<T> outroMaior = next.maior();
			System.out.println(maior.getData());
			System.out.println(outroMaior.getData());
			maior = max(maior, outroMaior);
			

		}
		return maior;

	}

	private RecursiveSingleLinkedListImpl<T> max(RecursiveSingleLinkedListImpl<T> maior,
			RecursiveSingleLinkedListImpl<T> outroMaior) {
		if (maior.compareTo(outroMaior) > 0) {
			return maior;
		} else if (outroMaior.compareTo(maior) > 0) {
			return outroMaior;
		} else {
			return maior;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(Object o) {
		
		if ((Integer) ((RecursiveSingleLinkedListImpl<T>) o).getData() < (Integer) this.getData()) {
			return 1;
		}else if ( (Integer) ((RecursiveSingleLinkedListImpl<T>) o).getData() > (Integer) this.getData()) {
			return -1;
		}else {
			return 0;
		}
	}

}
