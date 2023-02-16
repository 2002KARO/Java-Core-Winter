package homework.Homework9;

public class DynamicArray {
    private int[] array = new int[10];
    //սա մէր մասիվի մէջ ավելացված էլեմնտների քանական է:
    private int size = 0;

    //1.ստուգել եթե մասիվի մէջ տէղ չկա կանչել-extend():
    //2.ավելացնել:
    public void add(int value) {
        if (size == array.length) {
            extend();

        }
        array[size++] = value;


    }

    //1.ստեխծել հին մասիվից 10 էլեմենտ ավելի մեծ մասիվ.
    //2.քցել հին մասիվի էլէմենտները նորի մէջ.
    //3.հին մասիվի հղումը կապնեխ նոր մասիվի հղման հէտ.
    private void extend() {
        int[] newArray = new int[array.length + 10];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];


        }
        array = newArray;

    }

    //1.եթե տվյալ ինդեքսը մեր ունեցած մասիվի ինդեքսների սահմանում է, վերադարդձնել:
    //2.մասիվի Index-երրորդ էլեմենտը:հակառակ դեպքում վերադարձնել -1:
    public int getByIndex(int index) {
        if (index < 0 || index > size - 1) {
            System.out.println("Error Index");
            return -1;


        }
        return array[index];

    }

    //Տպել մասիվի ավելաացված էլեմենտները:
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");

        }
        System.out.println();

    }

    //1.Ջնջել մասիվի Index-երրորդ ելեմենտը:
    //2.եթե չկա նման ինդեքսով էլեմենտ, տպել, որ չկա նման էլեմենտ:
    public void deleteByIndex(int index) {
        if (index < 0 || index > size - 1) {
            System.out.println("սխալ ինդեքս");
            return;
        }
        for (int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];

        }
        size--;

    }

    //1.տրված value-ն դնելու ենք տրված index-ով էլեմենտի տեղը։
    //2.Հին արժեքը կկորի:
    //3.եթե նման ինդեքսով էլեմենտ չկա, գրում ենք որ չկա։
    public void set(int index, int value) {

        if (index < 0 || index > size - 1) {
            System.out.println("սխալ ինդեքս");
            return;
        }
        array[index] = value;

    }

    //1.ավելացնել տրված value-ն տրված ինդեքսում, իսկ եղած էլեմնտները մի հատ աջ տանել:
    //2.եթե չկա նման ինդեքս,տպել որ չկա:
    public void add(int index, int value) {

        if (index < 0 || index > size - 1) {
            System.out.println("սխալ ինդեքս");
            return;
        }
        if (size == array.length) {
            extend();

        }
        for (int i = size; i >= index; i--) {
            array[i] = array[i - 1];

        }
        array[index] = value;
        size++;
    }

    //Վերադարնձել true եթե տրված value-ն կա մեր մասիվի մեջ, եթե ոչ false:
    public boolean exists(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return true;

            }

        }
        return false;
    }
    //Վերադարնձել տրված value-ի ինդեկսը, եթե շատ կա տվյալ թվից,վերադարձնել արաիջն ինդեքսը:
    // եթե չկա, -1:
    public  int getIndexByValue(int value ){
        for (int i = 0; i < size; i++) {
            if (array[i]==value){
                return i;
            }

        }
        return -1;

    }
    


}
