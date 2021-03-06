1、情况一（try中有return，finally中没有return）：

```java
public class TryTest{
	public static void main(String[] args){
		System.out.println(test());
	}

	private static int test(){
		int num = 10;
		try{
			System.out.println("try");
			return num += 80;
		}catch(Exception e){
			System.out.println("error");
		}finally{
			if (num > 20){
				System.out.println("num>20 : " + num);
			}
			System.out.println("finally");
		}
		return num;
	}
}
```
	
2、情况二（try和finally中均有return）：

```java
	public class TryTest{
		public static void main(String[] args){
			System.out.println(test());
		}
	
		private static int test(){
			int num = 10;
			try{
				System.out.println("try");
				return num += 80;
			}catch(Exception e){
				System.out.println("error");
			}finally{
				if (num > 20){
					System.out.println("num>20 : " + num);
				}
				System.out.println("finally");
				num = 100;
				return num;
			}
		}
	}
```

3、情况三（finally中改变返回值num）：

```java
public class TryTest{
	public static void main(String[] args){
		System.out.println(test());
	}
 
	private static int test(){
		int num = 10;
		try{
			System.out.println("try");
			return num;
		}catch(Exception e){
			System.out.println("error");
		}finally{
			if (num > 20){
				System.out.println("num>20 : " + num);
			}
			System.out.println("finally");
			num = 100;
		}
		return num;
	}
}
```

4、情况四（将num的值包装在Num类中）：

```java
public class TryTest{
	public static void main(String[] args){
		System.out.println(test().num);
	}
 
	private static Num test(){
		Num number = new Num();
		try{
			System.out.println("try");
			return number;
		}catch(Exception e){
			System.out.println("error");
		}finally{
			if (number.num > 20){
				System.out.println("number.num>20 : " + number.num);
			}
			System.out.println("finally");
			number.num = 100;
		}
		return number;
	}
}
 
class Num{
	public int num = 10;
}

```
1、

输出结果如下：
```java
try
num>20 : 90
finally
90
```

分析：显然“return num += 80”被拆分成了“num = num+80”和“return num”两个语句，线执行try中的“num = num+80”语句，将其保存起来，在try中的”return num“执行前，先将finally中的语句执行完，而后再将90返回。

2、

输出结果如下：

```java
try
num>20 : 90
finally
100
```

分析：try中的return语句同样被拆分了，finally中的return语句先于try中的return语句执行，因而try中的return被”覆盖“掉了，不再执行。

3、

输出结果如下：

```java
try

finally

10
```

分析：虽然在finally中改变了返回值num，但因为finally中没有return该num的值，因此在执行完finally中的语句后，test（）函数会得到try中返回的num的值，而try中的num的值依然是程序进入finally代码块前保留下来的值，因此得到的返回值为10。

4、

输出结果如下：

```java
try
finally
100
```

从结果中可以看出，同样是在finally中改变了返回值num的值，在情况三中，并没有被try中的return返回（test（）方法得到的不是100），但在这里却被try中的return语句返回了。


总结：

	try语句在返回前，将其他所有的操作执行完，保留好要返回的值，而后转入执行finally中的语句，而后分为以下三种情况：


情况一：如果finally中有return语句，则会将try中的return语句”覆盖“掉，直接执行finally中的return语句，得到返回值，这样便无法得到try之前保留好的返回值。

情况二：如果finally中没有return语句，也没有改变要返回值，则执行完finally中的语句后，会接着执行try中的return语句，返回之前保留的值。

情况三：如果finally中没有return语句，但是改变了要返回的值，这里有点类似与引用传递和值传递的区别，分以下两种情况，：

	1）如果return的数据是基本数据类型或文本字符串，则在finally中对该基本数据的改变不起作用，try中的return语句依然会返回进入finally块之前保留的值。

	2）如果return的数据是引用数据类型，而在finally中对该引用数据类型的属性值的改变起作用，try中的return语句返回的就是在finally中改变后的该属性的值。