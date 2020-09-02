# Queue (큐)



큐는 FIFO(First-In-First-Out) 순서를 다른다. 큐에 저장되는 항목들은 큐에 추가되는 순서대로 제거된다.



큐에는 다음과 같은 연산이 존재

- add(item) : item 을 리스트의 끝 부분에 추가한다
- remove() ; 리스트의 첫 번째 항목을 제거
- peek() : 큐에서 가장 위에 있는 항목을 반환 
- isEmpty() : 큐가 비어있을 때에 true 를 반환



큐는 너비 우선 탐색 (BFS) 를 하거나, 캐시를 구현 하는 경우에 종종 사용

예를 들면, 처리해야할 노드의 리스트를 저장하는 용도로 큐를 사용할때 노드를 하나 처리할 때마다 해당 노드와 인접한 노드를 큐에 다시 저장.  노드를 접근한 순서대로 처리할 수 있게 된다.



간단한 큐 예제

```java
public class MyQueue<T> {
    
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;
        public QueueNode(T data) {
            this.data = data;
        }
    }
    
    // Queue 는 앞뒤로 주소를 알고 있어야하기 때문에 두개의 멤버변수 선언
    private QueueNode<T> first;
    private QueueNode<T> last;
    
    public void add(T item) {
        QueueNode t = new QueueNode(item);
        // 마지막 노드가 있다면, 새로 생성한 노드의 정보를 붙여준다
		if (last != null) {
            last.next = t;
        }
        // t 가 이제 마지막 노드이기때문에 갈아치워준다.
		last = t;
        // 첫번째 노드가 없다면, 마지막이 첫번째 이므로 넣어준다.
        if (first == null) {
            first = last;
        }
    }
    
    public T remove() {
        if (first == null) throw new NoSuchElementException();
        T data = first.data;
		first = first.next;
		if (first == null) {
            last = null;
        }
        return data;
    }
    
    public T peek() {
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
   
}
```



큐에서 처음과 마지막 노드를 갱신할 때 실수가 나오기 쉽기에 주의 해야한다.