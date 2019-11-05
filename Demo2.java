class Node{
    int value;
    Node next = null;

    Node(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}

//从头结点依次切断链表
public class Demo2 {
    private static Node separate(Node head,int x){
        // 难度：尾插
        Node cur = head;
        Node small = null;
        Node smallLast = null;
        Node big = null;
        Node bigLast = null;

        while (cur != null) {
            if (cur.value < x) {
                // 把 cur 尾插到 small
                if (small == null) {
                    small = cur;
                } else {
                    smallLast.next = cur;
                }
                smallLast = cur;
            } else {
                // 把 cur 尾插到 big
                if (big == null) {
                    big = cur;
                } else {
                    bigLast.next = cur;
                }
                bigLast = cur;
            }
            cur = cur.next;
        }

        // 把 big 接到 small 的后边
        if (smallLast == null) {
            return big;
        } else {
            smallLast.next = big;
        }

        if (bigLast == null) {
            return small;
        } else {
            bigLast.next = null;
        }

        return small;
        // 引用.属性
        // 引用.方法
        // NullPointerException，没有对象
        // 引用 == null
        // 1. 根据引用找到对象
        // 2. 访问对象的属性或者调用对象的方法
    }

    private static Node createList() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        n1.next = n2; n2.next = n3; n3.next = n4;
        n4.next = n5; n5.next = n6; n6.next = n7;
        n7.next = n8;

        return n1;
    }

    public static void main(String[] args) {
        Node head = createList();
        Node rhead = separate(head, 1);
        for (Node c = rhead; c != null; c = c.next) {
            System.out.println(c);
        }
    }
}
