## 一、Arrays类的定义

Arrays类位于 java.util 包中，主要包含了操纵数组的各种方法，使用时导包:import java.util.Arrays。

## 二、Arrays常用函数（都是静态的)

1.void Arrays.sort()

void Array.sort(Object[] array)

功能：对数组按照升序排序

示例：

```java
int[] nums = {2,5,0,4,6,-10};
Arrays.sort(nums);
for(int i :nums)
	System.out.print(i+" ");
/* 之前:2 5 0 4 6 -10 
 * 结果:-10 0 2 4 5 6 
 */
```

Arrays.sort(Object[] array, int from, int to)

功能：对数组元素指定范围进行排序（排序范围是从元素下标为from,到下标为to-1的元素进行排序）

示例:

```java
int[] nums = {2,5,0,4,1,-10};
//对前四位元素进行排序
Arrays.sort(nums, 0, 4);
for(int i :nums)
	System.out.print(i+" ");
/* 之前:2 5 0 4 1 -10
 * 结果:0 2 4 5 1 -10 
 */
```

2.Arrays.fill(Object[] array,Object object)

功能：可以为数组元素填充相同的值

```java
int[] nums = {2,5,0,4,1,-10};
Arrays.fill(nums, 1);
for(int i :nums)
	System.out.print(i+" ");
/* 之前:2 5 0 4 1 -10
 * 结果:1 1 1 1 1 1 
 */
```

Arrays.fill(Object[] array,int from,int to,Object object)

功能：对数组的部分元素填充一个值,从起始位置到结束位置，取头不取尾

```java
int[] nums = {2,5,0,4,1,-10};
//对数组元素下标2到4的元素赋值为3
Arrays.fill(nums,2,5,3);
for(int i :nums)
	System.out.print(i+" ");
/* 之前:2 5 0 4 1 -10
 * 结果:2 5 3 3 3 -10 
 */
```

3.Arrays.toString(Object[] array)

功能：返回数组的字符串形式

示例:

```java
        int[] nums = {2,5,0,4,1,-10};
        System.out.println(Arrays.toString(nums));
        /*
         * 结果:[2, 5, 0, 4, 1, -10]
         */
```

4.Arrays.deepToString(Object[][] arrays)

功能：返回多维数组的字符串形式

示例

```java


int[][] nums = {{1,2},{3,4}};
        System.out.println(Arrays.deepToString(nums));
        /*
         * 结果:[[1, 2], [3, 4]]
         */

```