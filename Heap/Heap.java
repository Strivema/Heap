package Heap;

public class Heap<T extends Comparable<T>>  {
	private SeqList<T> ha;
	public Heap(){
		ha = new SeqList<T>();
	}
	public Heap(int n){
		ha = new SeqList<T>(n);
	}
	public Heap(T []a){
		ha = new SeqList<T>(a.length);
		creatHeap(a);
	}
	
	public void creatHeap(T []a){
		ha.clear();
		for(int i = 0;i<a.length;i++){
			ha.add(a[i]);
		}
		int n = a.length-1;
		for(int i = (n-1)/2;i>=0;i--){
			heapAdjust(i,n);
		}
	}
	public void add(T x){
		ha.add(x);
		int i = ha.length()-1;
		while(i!=0&& x.compareTo(ha.get((i-1)/2))>0){
			ha.set(i, ha.get((i-1)/2));
			i = i/2;
		}
		ha.set(i, x);
	}
	public T max(){
		return ha.get(0);
	}
	public T remove(){
		int n = ha.length();
		T temp = ha.get(0);
		ha.set(0, ha.get(n-1));
		heapAdjust(0,n-2);
		ha.remove(n-1);
		return temp;
	}
	
	public void heapAdjust(int s,int m){
		T rc =ha.get(s);
		if(m>ha.length())
			m = ha.length();
		for(int j = 2*s+1;j<=m;j=2*j+1){
			if(j<m&& ha.get(j).compareTo(ha.get(j+1))<0){
				j++;
			}
			if(rc.compareTo(ha.get(j))>0){
				break;
			}
			ha.set(s, ha.get(j));
			s =j;
		}
		ha.set(s, rc);
	}
	public String toString(){
		return ha.toString();
	}
	public boolean isEmpty(){
		return ha.isEmpty();
	}
	public int length(){
		return ha.length();
	}
	public int size(){
		return ha.size();
	}
}
