package Heap;

public interface List<T> {
	boolean isEmpty();
	int length();
	T get(int i);
	boolean set(int i,T x);
	void add(int i,T x);
	T remove(int i);
	int indexOf(T x);
}
