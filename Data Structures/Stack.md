# Stack (스택)



스택은 LIFO(Last-In-First-Out) 에 따라 자료를 배열한다. 가장 최근에 스택에 추가한 항목이 가장 먼저 제거될 항목이다.



스택에는 다음과 같은 연산이 존재

- pop(): 스택에서 가장 위에 있는 항목을 제거
- push(item) : item 하나를 스택의 가장 윗 부분에 추가
- peek() : 스택의 가장 위에 있는 항목을 반환
- isEmpty() : 스택이 비어있을 때에 true 를 반환



스택의 유용한 경우는 재귀 알고리즘을 사용 할 때다.

재귀적으로 함수를 호출 해야하는 경우에 임시 데이터를 스택에 넣어주고, 재귀 함수를 빠져나와 Backtrack 을 할 때는 스택에 넣어 두었던 임시 데이터를 빼 줘야 한다. 

스택은 재귀 알고리즘을 반복적 형태 (Iterative) 를 통해서 구현할 수 있게 해준다.



스택의 구현 방법

- Array 이용
- Linked List 이용



간단한 스택 예제

```java
public class MyStack() {
	private static class StackNode {
		private T data;
		private StackNode next;
		public StackNode(T data) {
			this.data = data
		}
	}
	
	private StackNode top;
	
	public T pop() {
		if(top == null) throw Exception();
        T item = top.data;
        top = top.next;
        return item;
	}
    
    public void push(T item) {
        StackNode t = new StackNode(item);
        t.next = top;
        top = t;
    }
    
    public T peek() {
        if (top == null) throw Exception();
        return top.data;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
	
}
```





- 참고 서적 :  코딩 인터뷰 완전 분석