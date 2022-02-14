/*
斐波那契数列指的是这样一个数列：1，1，2，3，5，8，13，21，34，55，89...
这个数列从第3项开始，每一项都等于前两项之和。
 */
public class fibonacci {
    public static void main(String[] args) {
        for(int i = 1;i<=10;i++){
            System.out.print(getNumber(i)+"\t");
        }
    }

    public static int getNumber(int number) {
        if (number == 1 || number == 2) {
            return 1;
        } else {
            return getNumber(number - 1) + getNumber((number - 2));
        }
    }
}
