
import java.io.*;
import java.util.*;

class LinkedList1<T extends Number> {

    public static void main(String[] args) {

        LinkedList1<Integer> linkedList = new LinkedList1<Integer>();
        // You code here
        int n = ni();
        int m = ni();
        for (int i = 0; i < n; i++) {
            int number = ni();
            linkedList.add(number);
        }
        for (int i = 0; i < m; i++) {
            String command = ns();
            if (command.equals("getAt")) {
                int index = ni();
                System.out.println(linkedList.getAt(index));
            } else if (command.equals("firstIndexOf")) {
                int number = ni();
                System.out.println(linkedList.firstIndexOf(number));
            } else if (command.equals("lastIndexOf")) {
                int number = ni();
                System.out.println(linkedList.lastIndexOf(number));
            } else if (command.equals("sum")) {
                System.out.println(linkedList.sum());
            } else if (command.equals("average")) {
                System.out.println(linkedList.average());
            } else if (command.equals("removeFirst")) {
                int number = ni();
                linkedList.removeFirst(number);
            } else if (command.equals("removeAt")) {
                int index = ni();
                linkedList.removeAt(index);
            } else if (command.equals("insertAt")) {
                int index = ni();
                int number = ni();
                linkedList.insertAt(index, number);
            } else if (command.equals("size")) {
                System.out.println(linkedList.size());
            } else if (command.equals("add")) {
                int number = ni();
                linkedList.add(number);
            }
        }
    }

    static private class LinkedNode<U extends Number> {

        U number;
        LinkedNode<U> next;

        public LinkedNode(U number) {
            this.number = number;
        }
    }

    LinkedNode<T> head = null;
    LinkedNode<T> tail = null;
    double sum = 0;
    int count = 0;

    private int compare(T n1, T n2) {
        long l1 = n1.longValue();
        long l2 = n2.longValue();
        if (l1 != l2) {
            return (l1 < l2 ? -1 : 1);
        }
        return Double.compare(n1.doubleValue(), n2.doubleValue());
    }

    public int size() {
        // Your code here
        return count;
    }

    public void add(T number) {
        LinkedNode<T> newNode = new LinkedNode<T>(number);
        if (head == null) {
            head = newNode;
            tail = newNode;
            sum += number.doubleValue();
            count++;
        } else {
            tail.next = newNode;
            tail = newNode;
            sum += number.doubleValue();
            count++;
        }
    }

    /**
     * @return -1 if number is not in list
     */
    public int firstIndexOf(T number) {
        // Your code here
        var temp = head;
        int index = 0;
        while (temp != null) {
            if (compare(temp.number, number) == 0) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    /**
     * @return -1 if number is not in list
     */
    public int lastIndexOf(T number) {
        // Your code here
        var temp = head;
        int index = 0;
        int lastIndex = -1;
        while (temp != null) {
            if (compare(temp.number, number) == 0) {
                lastIndex = index;
            }
            index++;
            temp = temp.next;
        }
        return lastIndex;
    }

    /**
     * Remove first occurence of number
     */
    public void removeFirst(T number) {
        // Your code here
        if (head == null) {
            return;
        }
        if (compare(head.number, number) == 0) {
            head = head.next;
            sum -= number.doubleValue();
            count--;
            return;
        } else {
            var temp = head;
            while (temp.next != null) {
                if (compare(temp.next.number, number) == 0) {
                    temp.next = temp.next.next;
                    sum -= number.doubleValue();
                    count--;
                    return;
                }
                temp = temp.next;
            }
        }

    }

    public void removeAt(int index) {
        if (index < 0 || index >= size()) {
            return;
        }
        if (index == 0) {
            sum -= head.number.doubleValue();
            head = head.next;
            count--;
        } else {
            var temp = head;
            for (var i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            sum -= temp.next.number.doubleValue();
            temp.next = temp.next.next;
            count--;
        }
    }

    public void insertAt(int index, T number) {
        // Your code here
        if (head == null) {
            var newNode = new LinkedNode<T>(number);
            newNode.next = head;
            head = newNode;
            sum += number.doubleValue();
            count++;
        } else {
            if (index == 0) {
                var newNode = new LinkedNode<T>(number);
                newNode.next = head;
                head = newNode;
                sum += number.doubleValue();
                count++;
            } else {
                var newNode = new LinkedNode<T>(number);
                var temp = head;
                for (var i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                newNode.next = temp.next;
                temp.next = newNode;
                sum += number.doubleValue();
                count++;
            }
        }
    }

    /**
     * @return null if index is out of range
     */
    public T getAt(int index) {
        // Your code here
        if (index < 0 || index >= size()) {
            return null;
        }
        var temp = head;
        for (var i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.number;
    }

    public double sum() {
        // Your code here
        return sum;
    }

    public double average() {
        // Your code here
        if (size() == 0) {
            return 0;
        }
        return sum() / size();
    }

    static InputStream is = System.in;
	static byte[] inbuf = new byte[1 << 24];
	static int lenbuf = 0, ptrbuf = 0;

	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}


	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

}
