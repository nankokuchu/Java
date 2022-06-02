# Java集合框架概述

1，集合，数组都是对多个数据进行存储操作的结构，简称Java容器

<aside>
💡 此时的存储，主要指的是内存层面的存储，不涉及到永久化的存储（.txt, .jpg, .avi, 数据库中）

</aside>

2.1，数组在存储多个数据方面的特点：

- 一旦初始化以后长度就确定了
- 数组一旦定义号，其元素的类型也就确定了。我们也就只能操作指定类型的数据。比如：String[] arr；int[] arr1；Object[] arr2;

2.2，数组在存储多个数据方面的缺点：

- 一旦初始化以后，七长度就不可修改、
- 数组中提供的方法非常优先，对于添加，删除，插入数据等操作，非常不便，同时效率不高。
- 获取数组中世纪元素的个数的需求，数组没有线程的属性或方法可用
- 数组存储数据的特点：有序，可重复。对于无序，不可重复的需求，不能满足

3，集合框架

- Collection接口：单列集合，用来存储一个一个的对象
    - -  >List接口：存储有序的，可重复的数据  - - - >  ”动态“数组
    - - - - >ArrayList， LinkedList， Vector
    - -  >Set接口：存储无序的，不可重复的数据   - - - > 高中讲的”集合“
    - - - - >HashiSet, LinkedHashset， TreeSet

- Map接口：双列集合，用来存储一对（key - value）一对的数据   - - - >  高中函数：y = f(x)
    - -  >HashMap，LinkedHashMap，TreeMap，Hashtable，Properities

# Collection接口方法

- .add(Object e);   void

  将指定的袁术e添加到该集合中

    ```java
    Collection list = new ArrayList();
    list.add("a");
    list.add("b");
    list.add(123);
    list.add(new Date);
    list.add(LocalDateTime.now);
    ```

- .addAll(Collection coll);

  把形参的coll集合元素，全部加进来

- .clear();

  清空当前集合的素有元素

- .remove(Object o);   boolean

  将指定对象o从该集合中删掉，返回boolean类值

  会调用形参的o的equals（）方法，来确定有没有同样的值。有的话删除返回true

    ```java
    public class MyListTest {
        public static void main(String[] args) {
            Collection list = new ArrayList();
            list.add("a");
            list.add("b");
            list.add(123);
            list.add(new Date());
            list.add(LocalDate.now());
    
            list.remove("a");
        }
    }
    ```

- .removeAll(Collection c)

  从集合当中，删除形参c 集合当中所有的元素

- .isEmpty();   boolean

  判断该集合是否有元素。返回boolean值

    ```java
    list.Empty();
    ```

- .size();    int

  返回int型值，获取该集合中元素的个数

    ```java
    list.size();
    ```

- .iterator();

  返回在此Collection的元素上进行迭代的迭代器。用于遍历集合中的对象

- .contains(Object obj);（如果obj是自定义类或者没有重写equals()方法的话，要重写equals()方法才可以）   boolean

  判断当前集合中，有没有包含形参的obj。返回boolean型值。包含true。

  contains方法在判断的时候，会调用obj对象所在类的equals()方法来比较。比较的时候是以，形参obj.equals(集合中第一个元素开始到最后一个元素为止)。要是找到了同样的内容，就终止方法。

    ```java
    //比较的是内容，而不是地址值。 
    boolean b = list.contains("b");
    ```

- .containsAll(Collection c);   boolean

  判断形参集合c中的所有元素是否都存在于当前集合中。返回boolean形值，都存在返回true

- .retainAll(Collection c);

  交集，获取当前集合跟形参集合c里的共同元素，并付给当前的集合当中

- .equals(Object obj);   boolean

  要想返回true，需要当前集合和形参集合的元素都要相同。obj要放入集合才可以

- .hashCode();    int

  返回当前集合的哈希值

- .toArray;    Object

  把当前集合转换成数组。返回值时Object类型

    ```java
    Object[] arr = list.toArray;
    ```

- Arrays.asList(T.....可变形参，所以可以方数组)； List类型的集合

## Iterator迭代器接口

1. 集合元素的遍历操作，使用迭代器Iterator接口
2. Iterator iterator = list.iterator();  （当生成一个Iterator对象的时候，相当于在当前集合的最上方出现了一个指针。）
3. iterator.hasNext();  boolean （看指针下方还有没有元素，有的话true，没有的话false）
4. iterator.Next();  E(①指针下移，②将下移后集合为止上的元素返回)
5. Iterator.remove();方法，可以在遍历集合的时候，删除集合当中的元素。 此方法不同于集合直接调用remove();
6. 遍历集合，以及数组的时候也可以使用foreach循环来遍历（JDK5.0）

## Collection子接口一：List(存储有序的，可重复的数据  - - - >  ”动态“数组)

<aside>
💡 接口List有三个,ArrayList， LinkedList， Vector 的实现类
总结: ArrayList， LinkedList， Vector 异同
同: 三个类都实现了List接口,存储数据的特点相同; 存储有序,可重复存储数据 
异：见下粉色字

</aside>

- ArrayList - - -是List接口的主要实现类；线程不安全 - -效率高； 底层使用Object[] elementDate存储
  - ArrayList的源码分析
    - JDK7 情况下

        ```java
        public ArrayListTest{
            
            ArrayList list = new ArrayList(); //底层创建了长度是10的Object[]数组elementDate
            list.add(123);//在底层，elementDate[0]= new Integer(123);
            ......
            /*
            如果一直添加数据，导致此次的添加会让底层elementDate数组容量不够，则扩容。
            默认情况下，扩容为原来的1.5倍，同时需要将原有数组中的数据赋值到新的数组当中。
            */
            list.add(11)
        
        }
        ```

    - JDK8情况下

        ```java
        public ArrayListTest{
            
            ArrayList list = new ArrayList(); //底层Object[] elementDate初始化为{},并没有创建长度为10的数组
            list.add(123);//在第一次调用add();时，底层才创建了长度为10的 数组，并将数据new Integer（123）添加到elementDate的数组当中
            ......
            //后续的添加以及扩容操作与JDK7无异
        
        }
        ```


    <aside>
    💡 总结
    JDK7中的ArrayList的对象的创建类似于单例的饿汉式，而JDK8中ArrayLi的对象的创建勒斯与单例的懒汉式，延迟了数据的创建，节省内存。
    
    但是，在开发环境当中，要是可以能猜测出大概有几个元素的情况下，还是建议使用ArrayList（int initialCapacity）的构造器。提前把数组给做好。
    
    </aside>
    
    ### ArrayList的常用方法
    
    ```java
    import java.time.LocalDate;
    import java.util.*;
    
    /**
     * @Description
     * @Author: zzazz
     * @CreateTime: 2021/07/28 11:17
     */
    public class MyListTest {
    
        public static void main(String[] args) {
    
            ArrayList list = new ArrayList();
    
            list.add("a");
            list.add("b");
            list.add(123);
            list.add(new Date());
            list.add(LocalDate.now());
         
            }
        }
    }
    ```
    
    - void add(int index, Object element)
        
        在index位置插入ele元素
        
        ```java
        list.add(1, "zhuzhu");
        //[a, zhuzhu, b, 123, Wed Jul 28 16:46:55 JST 2021, 2021-07-28]
        ```
        
    - boolean addAll(int index, Collection elements)
        
        从index位置开始将eles中的所有元素添加进来
        
    - Object get(int index)
        
        获取指定index位置的元素
        
        ```java
        Object obj = list.get(4);
        System.out.println(obj);//Wed Jul 28 16:50:27 JST 2021
        //index >= index 的话 IndexOutBoundsException有可能发生
        ```
        
    - int indexOf(Object obj)
        
        返回obj在集合中首次出现的位置
        
    - int lastIndexOf(Object obj)
        
        返回obj在当前集合中末次出现的位置
        
    - Object remove(int index)
        
        移除指定index位置的元素，并返回此元素
        
    - Object set(int index, Object ele)
        
        ```java
        				Object zongzong = list.set(0, "zongzong");
                System.out.println(zongzong);
                System.out.println(list);
        
        //返回值
        a  zongzong这个Object 是替换前的 Object 的值 
        [zongzong, zhuzhu, b, 123, Wed Jul 28 16:56:04 JST 2021, 2021-07-28]
        ```
        
        设置指定index位置的元素为ele
        
    - List subList(int fromIndex, int toIndex)
        
        返回从fromIndex到toIndex位置的子集合
        
    
    <aside>
    💡 总结：常用方法
    增：add(Object obj); 末尾增加
    删：Object remove(int index); or remove(Object obj) Collection的remove
    改：Object set(int index, Object element/elements):
    查：Object get(int index);
    插：add(int index, Object element);
    长度：size();
    遍历：Iterator迭代器方法  or  foreach方法  or  普通for循环
    
    </aside>

- LinkedList - - -对于频繁的插入，删除操作，使用此类效率比ArrayList效率高；底层使用双向链表存储
  - LinkedList的源码分析

      ```java
      LinkedList list = new LinkedList();//内部声明了Node类型的first和last属性，默认值为null
      list.add(123);//将123封装到Node中，创建了Node对象
      
      /**
      其中，Node定义为：体现了LinkedList的双向链表的说法
      
              private static class Node<E> {
              E item;
              Node<E> next;
              Node<E> prev;
      
              Node(Node<E> prev, E element, Node<E> next) {
                  this.item = element;
                  this.next = next;
                  this.prev = prev;
              }
          }
      
      */
      ```

    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/519a5f15-caa0-40bd-bb98-18b1d97a3b7c/36b5f07abcb45539d766d9b958c192a3.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/519a5f15-caa0-40bd-bb98-18b1d97a3b7c/36b5f07abcb45539d766d9b958c192a3.png)

- Vector - - -(作为List接口的古老实现类)；线程安全的 - -效率低； 底层使用Object[] elementDate存储

## Collection子接口二：Set（Set接口：存储无序的，不可重复的数据   - - - > 高中讲的”集合“）

<aside>
💡 怎么理解Set的存储无序的，不可重复的数据
以HashSet为例
1.   无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值来决定的
2.   不可重复性：保证添加的元素按照equals（）方法判断时，不能返回true。既：相同的元素只能添加一个。

添加元素的过程：以HashSet为例

</aside>

- HashiSet - - -作为Set接口的主要实现类； 线程不安全的； 可以存储null值
- LinkedHashset - - -作为HashSet的子类； 遍历其内部数据是，可以按照添加的顺序遍历
- TreeSet - - -可以按照添加对象的指定属性，进行排序。但是放入的元素必须是同一个类

# Map接口（双列数据，存储key-value一对的数据）

<aside>
💡 |- - - -HashMap : 作为Map的主要实现类；线程不安全的，效率高；存储null的key和value
           |- - - -LinkedHashMap：保证在遍历map元素时，可以按照添加的顺序实现遍历。
                                                     原因：在原有的Has和Map底层结构基础上，添加了一对指针，指向前一个和后一个的元素
                                                     对于频繁的遍历操作，此类执行效率高于HashMap
|- - - -TreeMap：保证按照添加的key-value对进行排序，实现排序变绿（此时考虑key的自然排序或定制排序）
|- - - -Hashtable：作为古老的实现类； 线程安全的，效率低
            |- - - -Properties：常用来处理配置文件。key和value都是String类型

</aside>

## Map结构的理解：

- Map中的key：无序的，不可重复的，使用Set存储所有的key - - - > key所在的类必须要重写equals（）和 hashCode（）方法
- Map中的value：无序的，可重复的，使用Collection存储所有Value - - - > value所在的类要重写equals（）
- 一个键值对：key - - value 构成了一个Entry对象
- Map中的entry：无序的，不可重复的，使用Set存储所有的enty
### 以jdk7为例说明：

```java
HashMap map = new HashMap();//在实例化以后，底层创建了长度是16的一维数组Entry[] table

//假设可以已经实现多次的put....

map.put(key1, value1): 
/**

	首先，调用key1所在类的hashCode（）计算key1哈希值，此哈希值经过某种算法计算以后，得到在Entry数组中的存放位置
		如果，此位置上数据为空，此时的key1 - value添加成功（key1 gen value1是Enty的属性。所以存储成功也就是存储了一个Entry的对象）
		如果，此位置上的数据不为空，（意味着此位置上存在一个或多个数据（以链表形式存在）），比较key1和已经存在的一个或多个数据的哈希值
				如果，key1的还细致与已经存在数据的哈希值都不相同，此时key1-value1添加成功
				如果，key1的哈希值和已经在某一个数据（key2-value2）的哈希值相同，继续比较： 调用key1所在类的equals（）方法，比较：
						如果equals（）方法返回false：此时key1-value1添加成功
						如果equals（）方法返回true：使用vaule1替换value2
	
	在不断的添加过程中，会涉及到扩容问题，默认的扩容方式：扩容为原来容量2倍，并将原有的数据复制过来、

*/

```

### jdk8相较于jdk7在底层实现方面不同

```java
HashMap map = new HashMap();//底层没有创建一个长度为16的数组，jdk8底层的数组是：Node[]，而非 Entry[]

map.put(key1, value1): 

/** 

	首次调用put（）方法时，底层创建长度为16的数组
	jdk7底层结构只有：数组 + 链表。 而 jdk8中底层结构： 数组 + 链表 +红黑树。
	当数组的某一个元素为止上的元素以链表形式存在的数据 > 8  且当前数组的长度 > 64时，此时索引为止上的所有数据改为使用红黑树存储

*/
```

## Map接口，常用方法

- **添加、删除、修改操作：**
- Object put(Object key,Object value)

  将指定key-value添加到(或修改)当前map对象中

- void putAll(Map m)

  将m中的所有key-value对存放到当前map中

- Object remove(Object key)

  移除指定key的key-value对，并返回value

- void clear()

  清空当前map中的所有数据

- **元素查询的操作：**
- Object get(Object key)

  获取指定key对应的value

- boolean containsKey(Object key)

  是否包含指定的key

- boolean containsValue(Object value)

  是否包含指定的value

- int size()

  返回map中key-value对的个数

- boolean isEmpty()

  判断当前map是否为空

- boolean equals(Object obj)

  判断当前map和参数对象obj是否相等(传进去的obj也必须是map集合才可以

- **元视图操作的方法：**
- Set keySet()：

  返回所有key构成的Set集合

- Collection values()：

  返回所有value构成的Collection集合

- Set entrySet()：