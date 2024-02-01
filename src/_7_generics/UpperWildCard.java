package _7_generics;

/**
 * 泛型/extends通配符
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1265105899616928
 */
public class UpperWildCard {

	public static void main(String[] args) {
		//Pair<Number>和Pair<Integer>没有继承关系不能相互转型是有问题的，如下例所示
		PairHere<Integer> p = new PairHere<>(123,456);
		int n = add(p);	//报错: The method add(PairHere<Number>) in the type UpperWildCard is not applicable for the arguments (PairHere<Integer>)
		System.out.println(n);
		int n1 = rectifiedAdd(p);
		System.out.println(n1);
	}
	
	//修正之后的add函数
	//? extends Number表示Number以及Number的子类，这就可实现向上转型,这种写法也叫上界通配符，即把泛型类型T的上界限定在Number
	public static int rectifiedAdd(PairHere<? extends Number> p) {
		Number first = p.getFirst();
		Number last  = p.getLast();
		return first.intValue() + last.intValue();
	}
	
	//有问题的add函数
	public static int add(PairHere<Number> p) {
		Number first = p.getFirst();
		Number last  = p.getLast();
		return first.intValue() + last.intValue();
	}

}

class PairHere<T>{
	private T first;
	private T last;
	
	public PairHere(T first, T last) {
		this.first = first;
		this.last = last;
	}
	
	public T getFirst() {
		return first;
	}
	
	public T getLast() {
		return last;
	}
}