public class ArrayDeque<T> {
    private Object[] headArray;
    private Object[] tailArray;
    private int headIndex;
    private int tailIndex;
    private Object head;
    private Object tail;

    public ArrayDeque() {
        headArray = new Object[8];
        tailArray = new Object[8];
        headIndex = 0;
        tailIndex = 0;
    }

    private Object[] checkArrayResize(Object[] a) {

        int newArraySizeBigger = a.length * 2;
        int newArraySizeSmaller = a.length / 2;
        int quarterSize = a.length / 4;

        if(a[a.length-1] != null) {
            Object[] aTemp = new Object[newArraySizeBigger];

            System.arraycopy(a, 0, aTemp, 0, a.length);

            return aTemp;

        } else if(a[quarterSize - 1] != null && a[quarterSize] == null) {
            Object[] aTemp = new Object[newArraySizeSmaller];

            System.arraycopy(a, 0, aTemp, 0, a.length);

            return aTemp;
        }

        else {

//            System.out.println("Array not ready to be resized");
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
            tailIndex--;

            return itemToPop;
        } else {
            Object itemToPop = headArray[headIndex - 1];
            headArray[headIndex - 1] = null;
            headIndex --;
            return itemToPop;
        }
    }

    public Object popTail() {
        if (tailIndex == 0 && headIndex == 0) {
            System.out.println("Nothing to pop, Deque is empty");
            return null;
        } else if (tailIndex == 0) {

            Object itemToPop = headArray[0];

            Object[] tempArray = new Object[headArray.length];

            for (int i = 0; i < headArray.length - 1; i++) {
                tempArray[i] = headArray[i+1];
            }

            headArray = tempArray;
            headIndex--;

            return itemToPop;
        } else {
            Object itemToPop = tailArray[tailIndex - 1];
            tailArray[tailIndex - 1] = null;
            tailIndex--;
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

    private void printHelper() {

        StringBuilder sb = new StringBuilder();
        int j = headIndex;

        for (int i = 0; i < j + 1; i++) {
            sb.append(headArray[j - 1]);
            sb.append(", ");

            if (i == headIndex - 1 && tailArray[0] == null) {
                break;
            }

            j--;
        }

        int k = tailIndex;
        for (int i = 0; i < k; i++) {
            sb.append(tailArray[i]);

            if (i != tailIndex - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
    }

//    private Object[] tailArrayPrintHelper(Object[] a, int aLength) {
//        Object[] aTemp = new Object[aLength];
//        for (int i = 0; i < aLength; i++) {
//            aTemp[i] = a[i];
//        }
//        return aTemp;
//    }

    public static void main (String[] args) {
        ArrayDeque<Integer> aD2 = new ArrayDeque<>();
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
        aD2.printHelper();
        aD2.popHead();
        aD2.printItem((Integer) aD2.retrieveHead());
        aD2.printItem((Integer) aD2.retrieveTail());
        aD2.popHead();
        aD2.printItem((Integer) aD2.retrieveHead());
        aD2.printItem((Integer) aD2.retrieveTail());
        aD2.popHead();
        aD2.printItem((Integer) aD2.retrieveHead());
        aD2.printItem((Integer) aD2.retrieveTail());

    }


}
