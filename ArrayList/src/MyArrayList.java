import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<E> {
    private int size=0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public MyArrayList(int capacity){
        elements=new Object[capacity];
    }
    public void add(E element){
        if (size == elements.length) {
            ensureCapa(1);
        }
        elements[size++] = element;
    }
    public E remove(int index){
        E result= (E) elements[index];
        if(index>this.size||index<0){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + this.size);
        } else
            for (int i = index; i < elements.length-1; i++) {
                    elements[i]=elements[i+1];
            }
            this.size=this.size-1;
            return result;
    }

    public int getSize(){
        return this.size;
    }

    public MyArrayList<E> clone(){
        MyArrayList<E> newList = new MyArrayList<E>(getSize());
        newList.size=this.size;
        newList.elements = Arrays.copyOf(elements,this.size);
        return newList;
    }
    public boolean contains(E elemen){
        for (int i = 0; i < elements.length; i++) {
            if(elements[i]==elemen){
                return true;
            }
        } return false;

    }
    public int indexOf( E elemen){
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == elemen) {
                return i;
            }
        } return -1;
    }
    private void ensureCapa(int minCapacity) {
        int newSize = elements.length +minCapacity;
        elements = Arrays.copyOf(elements, newSize);
    }
    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }
    public void clear(){
        this.size=0;
        elements=new Object[this.size];
    }
}
class TestMyArrList{
    public static void main(String[] args) {
        MyArrayList<String> arrs=new MyArrayList(3);

        arrs.add("12");
        arrs.add("3");
        arrs.add("5");
        arrs.add("22");
        arrs.add("8");

        MyArrayList<String> newarrs = arrs.clone();

        System.out.println("cac phan tu cua mang newarrs: "+newarrs.get(0));
        System.out.println("cac phan tu cua mang newarrs: "+newarrs.get(1));
        System.out.println("cac phan tu cua mang newarrs: "+newarrs.get(2));
        System.out.println("cac phan tu cua mang newarrs: "+newarrs.get(3));
        System.out.println("cac phan tu cua mang newarrs: "+newarrs.get(4));

        System.out.println("size cua mang arrs : "+arrs.getSize());
        System.out.println("su ton tai cua gia tri 22 trong mang arrs : "+arrs.contains("22"));
        System.out.println("value phan tu vi tri thu 3 cua mang arrs bi xoa : "+arrs.remove(3));

        System.out.println("size cua mang arrs sau khi xoa 1 phan tu: "+arrs.getSize());

        System.out.println("su ton tai cua gia tri 22 trong mang arrs : "+arrs.contains("22"));
        System.out.println("vi tri cua gia tri 12 trong mang :" +arrs.indexOf("12"));
        System.out.println("gia tri phan tu vi tri 3 : " +arrs.get(3));

       arrs.clear();
      System.out.println("size cua mang arrs sau clear: " +arrs.getSize());






    }
}
