1、Collection、SET、List、Map区别：

	Collection 接口存储一组不唯一，无序的对象；
	
	List 接口存储一组不唯一，有序（插入顺序）的对象；
	
	Set 接口存储一组唯一，无序的对象；
	
	Map接口存储一组键值对象，提供key到value的映射；
	
2、ArrayList、LinkedList区别

	ArrayList实现了长度可变的数组，在内存中分配连续的空间。
	
	– 优点：遍历元素和随机访问元素的效率比较高
	
	– 缺点：添加和删除需要大量移动元素效率低，按照内容查询效率低
	
	LinkedList采用链表存储方式。
	
	– 优点：插入、删除元素时效率比较高
	
	– 缺点：遍历和随机访问元素效率低下
	
	
3、Iterator 接口
	所有实现了Collection接口的容器类都有一个iterator方法用以返回一个实现了Iterator接口的对象。
	
	Iterator对象称作迭代器，用以方便的实现对容器内元素的遍历操作。

	Iterator接口定义了如下方法：
	
	boolean hasNext(); //判断是否有元素没有被遍历
	
	Object next(); //返回游标当前位置的元素并将游标移动到下一个位置

	void remove(); //删除游标左面的元素，在执行完next之后该操作只能执行一次