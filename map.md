### map

map存储的是k-v键值对映射的数据

实现子类：
	
	HashMap：数据+链表（1.7） 数组+链表+红黑树（1.8）

	LinkedHashMap：链表

	TreeMap:红黑树

	Map.entry:表示的是K-V组合的一组映射关系，key和value成组出现

hashmap跟hashtable的区别：

1、hashmap线程不安全，效率比较高，hashtable线程安全，效率低

2、hashmap中key和value都可以为空,hashtable不允许为空

hashmap初始值为2的N次幂，
	
	1、方便进行&操作，提高效率，&要比取模运算效率要高 hash & (initCapacity-1)

	2、在扩容之后涉及到元素的迁移过程，迁移的时候只需要判断二进制的前一位是0或者是1即可