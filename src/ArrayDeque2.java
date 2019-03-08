import java.util.Arrays;

public class ArrayDeque2 <T> {
    private Object[] headArray;
    private Object[] tailArray;
    private int headIndex;
    private int tailIndex;
    private Object head;
    private Object tail;

    public ArrayDeque2() {
        headArray = new Object[8];
        tailArray = new Object[8];
        headIndex = 0;
        tailIndex = 0;
    }

    private Object[] checkArrayResize(Object[] a) {

        int newArraySize = a.length * 2;

        if(a[a.length-1] != null) {
            Object[] aTemp = new Object[newArraySize];

            System.arraycopy(a, 0, aTemp, 0, a.length);

            return aTemp;

        } else {

            System.out.println("Array not ready to be resized");
            return a;

        }
    }

    public void addHead(T item) {
        //will only resize if needs to, otherwise assigns current value to self and there is no change
        headArray = checkArrayResize(headArray);

        headArray[headIndex] = item;
        headIndex++;
    }

    public void addTail(T item) {
        tailArray = checkArrayResize(tailArray);

        tailArray[tailIndex] = item;
        tailIndex++;
    }

    public Object popHead() {
        if (tailIndex == 0 && headIndex == 0) {
            System.out.println("Nothing to pop, Deque is empty");
            return null;
        } else if (headIndex == 0) {

            Object itemToPop = tailArray[0];

            Object[] tempArray = new Object[tailArray.length];

            for (int i = 0; i < tailArray.length - 1; i++) {
                tempArray[i] = tailArray[i+1];
            }

            tailArray = tempArray;

            return itemToPop;
        } else {
            Object itemToPop = tailArray[tailIndex];
            tailArray[tailIndex] = null;
            tailIndex --;
            return itemToPop;
        }
    }

    public Object popTail() {
        if (tailIndex == 0 && headIndex == 0) {
            System.out.println("Nothing to pop, Deque is empty");
            return null;
        } else if (tailIndex == 0) {

            Object itemToPop = headArray[0];

            Object[] tempArray = new Object[tailArray.length];

            for (int i = 0; i < headArray.length - 1; i++) {
                tempArray[i] = headArray[i+1];
            }

            headArray = tempArray;

            return itemToPop;
        } else {
            Object itemToPop = headArray[headIndex];
            headArray[headIndex] = null;
            headIndex --;
            return itemToPop;
        }
    }

    public Object retrieveHead() {
        if(headIndex == 0 && tailIndex == 0) {
            System.out.println("No head to retrieve");
            return null;
        } else if(headIndex == 0) {
            return tailArray[0];
        } else {
            return headArray[headIndex - 1];
        }
    }

    public Object retrieveTail() {
        if(tailIndex == 0 && headIndex == 0) {
            System.out.println("No tail to retrieve");
            return null;
        } else if(tailIndex == 0) {
            return headArray[0];
        } else {
            return tailArray[tailIndex - 1];
        }
    }

    public void printItem(Integer item) {
        System.out.println(item);
    }

    public void printArray() {
        Object[] ha = headArrayPrintHelper(headArray, headIndex);
        Object[] ta = tailArrayPrintHelper(tailArray,tailIndex);
        System.out.println(Arrays.toString(ha) + Arrays.toString(ta));
    }

    private Object[] headArrayPrintHelper(Object[] a, int aLength) {
        Object[] aReversedTemp = new Object[aLength];
        int j = aLength;

        for (int i = 0; i < aLength; i++) {
            aReversedTemp[j - 1] = a[i];
            j--;
        }
        return aReversedTemp;
    }

    private Object[] tailArrayPrintHelper(Object[] a, int aLength) {
        Object[] aTemp = new Object[aLength];
        for (int i = 0; i < aLength; i++) {
            aTemp[i] = a[i];
        }
        return aTemp;
    }

    public static void main (String[] args) {
        ArrayDeque2<Integer> aD2 = new ArrayDeque2<>();
        aD2.addHead(1);
        aD2.printItem((Integer) aD2.retrieveHead());
        aD2.printItem((Integer) aD2.retrieveTail());
        aD2.addTail(2);
        aD2.printItem((Integer) aD2.retrieveHead());
        aD2.printItem((Integer) aD2.retrieveTail());
        aD2.addTail(3);
        aD2.printItem((Integer) aD2.retrieveHead());
        aD2.printItem((Integer) aD2.retrieveTail());
        aD2.addHead(4);
        aD2.printItem((Integer) aD2.retrieveHead());
        aD2.printItem((Integer) aD2.retrieveTail());
        aD2.printArray();

    }


}
