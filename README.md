# kotlin-demo
Kotlin 学习笔记

##函数的变长参数可以用 vararg 关键字进行标识：
    fun vars(vararg v:Int){
        for(vt in v){
            print(vt)
        }
    }
    // 测试
    fun main(args: Array<String>) {
        vars(1,2,3,4,5)  // 输出12345
    }

##lambda(匿名函数)
lambda表达式使用实例：
    // 测试
    fun main(args: Array<String>) {
        val sumLambda: (Int, Int) -> Int = {x,y -> x+y}
        println(sumLambda(1,2))  // 输出 3
    }

#定义常量与变量
##可变变量定义：var 关键字
var <标识符> : <类型> = <初始化值>
##不可变变量定义：val 关键字，只能赋值一次的变量(类似Java中final修饰的变量)
val <标识符> : <类型> = <初始化值>

#字符串模板
##$ 表示一个变量名或者变量值
$varName 表示变量值
${varName.fun()} 表示变量的方法返回值:

#NULL检查机制
Kotlin的空安全设计对于声明可为空的参数，在使用时要进行空判断处理，有两种处理方式，字段后加!!像Java一样抛出
空异常，另一种字段后加?可不做处理返回值为 null或配合?:做空判断处理

//类型后面加?表示可为空
var age: String? = "23" 
//抛出空指针异常
val ages = age!!.toInt()

#类型检测及自动类型转换
##可以使用 is 运算符检测一个表达式是否某类型的一个实例(类似于Java中的instanceof关键字)。
    fun getStringLength(obj: Any): Int? {
      if (obj is String) {
        // 做过类型判断以后，obj会被系统自动转换为String类型
        return obj.length 
      }
    
      //在这里还有一种方法，与Java中instanceof不同，使用!is
      // if (obj !is String){
      //   // XXX
      // }
    
      // 这里的obj仍然是Any类型的引用
      return null
    }

#区间
##区间表达式由具有操作符形式 .. 的 rangeTo 函数辅以 in 和 !in 形成。
区间是为任何可比较类型定义的，但对于整型原生类型，它有一个优化的实现。以下是使用区间的一些示例:

    // 使用 step 指定步长
    for (i in 1..4 step 2) print(i) // 输出“13”
    
    for (i in 4 downTo 1 step 2) print(i) // 输出“42”
    
    // 使用 until 函数排除结束元素
    for (i in 1 until 10) {   // i in [1, 10) 排除了 10
         println(i)
    }

#Kotlin 基本数据类型
##Kotlin 的基本数值类型包括 Byte、Short、Int、Long、Float、Double 等。不同于 Java 的是，字符不属于数值类型，是一个独立的数据类型

#比较两个数字
Kotlin 中没有基础数据类型，只有封装的数字类型
三个等号 === 表示比较对象地址，两个 == 表示比较两个值大小。

#类型转换
由于不同的表示方式，较小类型并不是较大类型的子类型，较小的类型不能隐式转换为较大的类型。 这意味着在不进行
显式转换的情况下我们不能把 Byte 型值赋给一个 Int 变量

#位操作符
对于Int和Long类型，还有一系列的位操作符可以使用，分别是：
    shl(bits) – 左移位 (Java’s <<)
    shr(bits) – 右移位 (Java’s >>)
    ushr(bits) – 无符号右移位 (Java’s >>>)
    and(bits) – 与
    or(bits) – 或
    xor(bits) – 异或
    inv() – 反向

#字符
和 Java 不一样，Kotlin 中的 Char 不能直接和数字操作，Char 必需是单引号 ' 包含起来的。比如普通字符 '0'，'a'
#字符串
和 Java 一样，String 是不可变的。方括号 [] 语法可以很方便的获取字符串中的某个字符，也可以通过 for 循环来遍历：
Kotlin 支持三个引号 """ 扩起来的字符串，支持多行字符串，
String 可以通过 trimMargin() 方法来删除多余的空白。

#类定义
Kotlin 类可以包含：构造函数和初始化代码块、函数、属性、内部类、对象声明。
Kotlin 中使用关键字 class 声明类，后面紧跟类名

##Kotlin 中类不能有字段。提供了 Backing Fields(后端变量) 机制,备用字段使用field关键字声明,field 关键词只能用于属性的访问器，如以上实例：
    var no: Int = 100
            get() = field                // 后端变量
            set(value) {
                if (value < 10) {       // 如果传入的值小于 10 返回该值
                    field = value
                } else {
                    field = -1         // 如果传入的值大于等于 10 返回 -1
                }
            }

##非空属性必须在定义的时候初始化,kotlin提供了一种可以延迟初始化的方案,使用 lateinit 关键字描述属性

#主构造器
主构造器中不能包含任何代码，初始化代码可以放在初始化代码段中，初始化代码段使用 init 关键字作为前缀。
如果构造器有注解，或者有可见度修饰符，这时constructor关键字是必须的，注解和修饰符要放在它之前。
#次构造函数
##类也可以有二级构造函数，需要加前缀 constructor
如果类有主构造函数，每个次构造函数都要，或直接或间接通过另一个次构造函数代理主构造函数。在同一个类中代理另一个
构造函数使用 this 关键字
如果一个非抽象类没有声明构造函数(主构造函数或次构造函数)，它会产生一个没有参数的构造函数。构造函数是 public 。
如果你不想你的类有公共的构造函数，你就得声明一个空的主构造函数

#内部类
##内部类使用 inner 关键字来表示。
内部类会带有一个对外部类的对象的引用，所以内部类可以访问外部类成员属性和成员函数。
为了消除歧义，要访问来自外部作用域的 this，我们使用this@label，其中 @label 是一个 代指 this 来源的标签。

#类的修饰符
类的修饰符包括 classModifier 和_accessModifier_:
##classModifier: 类属性修饰符，标示类本身特性。
    abstract    // 抽象类  
    final       // 类不可继承，默认属性
    enum        // 枚举类
    open        // 类可继承，类默认是final的
annotation  // 注解类
##accessModifier: 访问权限修饰符
    private    // 仅在同一个文件中可见
    protected  // 同一个文件中或子类可见
    public     // 所有调用的地方都可见
    internal   // 同一个模块中可见

#扩展函数
扩展函数可以在已有类中添加新的方法，不会对原类做修改，扩展函数定义形式：
    fun receiverType.functionName(params){
        body
    }
receiverType：表示函数的接收者，也就是函数扩展的对象
functionName：扩展函数的名称
params：扩展函数的参数，可以为NULL

##扩展函数是静态解析的
扩展函数是静态解析的，并不是接收者类型的虚拟成员，在调用扩展函数时，具体被调用的的是哪一个函数，由调用函数的的对象表达式来决定的，而不是动态的类型决定的:

##扩展一个空对象
在扩展函数内， 可以通过 this 来判断接收者是否为 NULL,这样，即使接收者为 NULL,也可以调用扩展函数。
##除了函数，Kotlin 也支持属性对属性进行扩展
扩展属性允许定义在类或者kotlin文件中，不允许定义在函数中。初始化属性因为属性没有后端字段（backing field），
所以不允许被初始化，只能由显式提供的 getter/setter 定义。
##扩展属性只能被声明为 val。

#伴生对象的扩展 companion
如果一个类定义有一个伴生对象 ，你也可以为伴生对象定义扩展函数和属性。
伴生对象通过"类名."形式调用伴生对象，伴生对象声明的扩展函数，通过用类名限定符来调用： 

#扩展声明为成员
在一个类内部你可以为另一个类声明扩展。
在这个扩展中，有个多个隐含的接受者，其中扩展方法定义所在类的实例称为分发接受者，而扩展方法的目标类型的实例称为扩展接受者。

以成员的形式定义的扩展函数, 可以声明为 open , 而且可以在子类中覆盖. 也就是说, 在这类扩展函数的派 发过程中, 
针对分发接受者是虚拟的(virtual), 但针对扩展接受者仍然是静态的。

#数据类
##Kotlin 可以创建一个只包含数据的类，关键字为 data：
为了保证生成代码的一致性以及有意义，数据类需要满足以下条件：
    主构造函数至少包含一个参数。
    所有的主构造函数的参数必须标识为val 或者 var ;
    数据类不可以声明为 abstract, open, sealed 或者 inner;
    数据类不能继承其他类 (但是可以实现接口)。

#复制
复制使用 copy() 函数，我们可以使用该函数复制对象并修改部分属性, 对于上文的 User 类，其实现会类似下面这样：
fun copy(name: String = this.name, age: Int = this.age) = User(name, age)

##标准数据类
标准库提供了 Pair 和 Triple 。在大多数情形中，命名数据类是更好的设计选择，因为这样代码可读性更强而且提供了有意义的名字和属性。

#密封类
密封类用来表示受限的类继承结构：当一个值为有限几种的类型, 而不能有任何其他类型时。在某种意义上，他们是枚举
类的扩展：枚举类型的值集合 也是受限的，但每个枚举常量只存在一个实例，而密封类 的一个子类可以有可包含状态的多个实例。
声明一个密封类，使用 sealed 修饰类，密封类可以有子类，但是所有的子类都必须要内嵌在密封类中。
sealed 不能修饰 interface ,abstract class(会报 warning,但是不会出现编译错误)
##使用密封类的关键好处在于使用 when 表达式 的时候，如果能够 验证语句覆盖了所有情况，就不需要为该语句再添加一个 else 子句了

#泛型约束
对于多个上界约束条件，可以用 where 子句

#型变
Kotlin 中没有通配符类型，它有两个其他的东西：声明处型变（declaration-site variance）与类型投影（type projections）。

##声明处型变
声明处的类型变异使用协变注解修饰符：in、out，消费者 in, 生产者 out。
使用 out 使得一个类型参数协变，协变类型参数只能用作输出，可以作为返回值类型但是无法作为入参的类型

#星号投射
"安全地使用"是指, 对泛型类型定义一个类型投射, 要求这个泛型类型的所有的实体实例, 都是这个投射的子类型。
对于这个问题, Kotlin 提供了一种语法, 称为 星号投射(star-projection):
    
    假如类型定义为 Foo<out T> , 其中 T 是一个协变的类型参数, 上界(upper bound)为 TUpper ,Foo<> 等价于 Foo<out TUpper> . 
    它表示, 当 T 未知时, 你可以安全地从 Foo<> 中 读取TUpper 类型的值.
    
    假如类型定义为 Foo<in T> , 其中 T 是一个反向协变的类型参数, Foo<> 等价于 Foo<inNothing> . 
    它表示, 当 T 未知时, 你不能安全地向 Foo<> 写入 任何东西.
    
    假如类型定义为 Foo<T> , 其中 T 是一个协变的类型参数, 上界(upper bound)为 TUpper , 对于读取值的场合,
     Foo<*> 等价于 Foo<out TUpper> , 对于写入值的场合, 等价于 Foo<in Nothing> .
    如果一个泛型类型中存在多个类型参数, 那么每个类型参数都可以单独的投射. 比如, 如果类型定义为interface Function<in T, out U> , 那么可以出现以下几种星号投射:
     Function<*, String> , 代表 Function<in Nothing, String> ;
     Function<Int, *> , 代表 Function<Int, out Any?> ;
     Function<, > , 代表 Function<in Nothing, out Any?> .
注意: 星号投射与 Java 的原生类型(raw type)非常类似, 但可以安全使用

#Kotlin 枚举类
枚举类最基本的用法是实现一个类型安全的枚举。
##枚举常量用逗号分隔,每个枚举常量都是一个对象。
##每一个枚举都是枚举类的实例，它们可以被初始化
枚举还支持以声明自己的匿名类及相应的方法、以及覆盖基类的方法。如：
    
    enum class ProtocolState {
        WAITING {
            override fun signal() = TALKING
        },
    
        TALKING {
            override fun signal() = WAITING
        };
    
        abstract fun signal(): ProtocolState
    }

##Kotlin 中的枚举类具有合成方法，允许遍历定义的枚举常量，并通过其名称获取枚举常数。
    
    EnumClass.valueOf(value: String): EnumClass  // 转换指定 name 为枚举值，若未匹配成功，会抛出IllegalArgumentException
    EnumClass.values(): Array<EnumClass>        // 以数组的形式，返回枚举值

#对象表达式 --object
通过对象表达式实现一个匿名内部类的对象用于方法的参数中：
##对象可以继承于某个基类，或者实现其他接口
Kotlin 使用 object 关键字来声明一个对象。
Kotlin 中我们可以方便的通过对象声明来获得一个单例。

##请注意，匿名对象可以用作只在本地和私有作用域中声明的类型。如果你使用匿名对象作为公有函数的 返回类型或者用
##作公有属性的类型，那么该函数或属性的实际类型 会是匿名对象声明的超类型，如果你没有声明任何超类型，就会是 Any
##。在匿名对象 中添加的成员将无法访问。

#伴生对象
类内部的对象声明可以用 companion 关键字标记，这样它就与外部类关联在一起，我们就可以直接通过外部类访问到对象的内部元素

注意：一个类里面只能声明一个内部关联对象，即关键字 companion 只能使用一次。
请伴生对象的成员看起来像其他语言的静态成员，但在运行时他们仍然是真实对象的实例成员。例如还可以实现接口：

#kotlin 委托
by 子句表示，将 b 保存在 Derived 的对象实例内部，而且编译器将会生成继承自 Base 接口的所有方法, 并将调用转发给 b。

#延迟属性 Lazy
lazy() 是一个函数, 接受一个 Lambda 表达式作为参数, 返回一个 Lazy <T> 实例的函数，返回的实例可以作为实现延迟属
性的委托： 第一次调用 get() 会执行已传递给 lazy() 的 lamda 表达式并记录结果， 后续调用 get() 只是返回记录的结果。
#可观察属性 Observable
observable 可以用于实现观察者模式。

#Not Null
notNull 适用于那些无法在初始化阶段就确定属性值的场合。


#属性委托要求
对于只读属性(也就是说val属性), 它的委托必须提供一个名为getValue()的函数。该函数接受以下参数：
    
    thisRef —— 必须与属性所有者类型（对于扩展属性——指被扩展的类型）相同或者是它的超类型
    property —— 必须是类型 KProperty<*> 或其超类型
这个函数必须返回与属性相同的类型（或其子类型）。
对于一个值可变(mutable)属性(也就是说,var 属性),除 getValue()函数之外,它的委托还必须 另外再提供一个名为setValue()的函数, 这个函数接受以下参数:
    
    property —— 必须是类型 KProperty<*> 或其超类型
    new value —— 必须和属性同类型或者是它的超类型



















