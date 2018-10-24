# HuaceDamon
华测最骚阿离
# Java内部接口和外部接口的使用（内部接口是进一步的逻辑细分）  
当你只实现外部接口，那么只需实现外部接口的方法即可（内部接口是调不到的）  
而实现内部接口的方式是“外部接口.内部接口”，那么就可以实现内部接口的方法了  

---
# Android bundle和intent：  
bundle类是final类，不能被继承。  
bundle主要用于传递数据；它保存的数据是以key-value（键值对）的形式存在的。  
bundle提供了各种常用类型的读写方法。  
bundle在activity和线程间传递数据。  
**example**
@Override  
public void onClick(View v) {  
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);  
	startActivity(intent);  
	}  
//显式Intent
<intent-filter>
        <action android:name="com.vince.intent.MY_ACTION"></action>
        <category android:name="com.vince.intent.MY_CATEGORY"></category>
        <category android:name="android.intent.category.DEFAULT"></category>
</intent-filter>

@Override
public void onClick(View v) {
         Intent intent = new Intent("com.vince.intent.MY_ACTION");
         startActivity(intent);
}

目前我们的Intent中只有一个默认的category，现在可以通过intent.addCategory()方法来实现.
@Override
public void onClick(View v) {
        Intent intent = new Intent();
        intent.setAction("com.example.smyh006intent01.MY_ACTION");
        intent.addCategory("com.example.smyh006intent01.MY_CATEGORY");
        startActivity(intent);
}
在清单文件中要去声明这个category,不然程序无法运行.  

---
自定义类别:在intent添加类别可以添加多个类别,那就要求被匹配的组件必须同时满足这多个类别,才能匹配成功.,
操作Activity的时候,如果没有类别,需要添加上默认类别.  

---
Data是用一个uri对象来表示的,uri代表数据的地址,属于一种标识符.我们使用action+data属性来描述一个意图.

@Override
public void onClick(View v){
        Intent intent = new Intent();
        intent.setAction(intent.ACTION_VIEW);
        Uri data = Uri.parse("http://www.baidu.com");
        intent.setData(data);
        startActivity(intent);
}
<activity 
        android:name=".SecondActivity">
        <intent-filter android priority="-1">
                 <action android:name="android.intent.action.VIEW"/>
	 <category android:name="android.intent.category.DEFAULT"/>
	 <data android:scheme:"http" android:host="www.baidu.com"/>
         </intent-filter	>
/activity >
---
type 数据类型 用于明确指定Data属性的数据类型或MIME类型,当intent不指定Data属性时,Type类型才会起作用
否则android系统将会根据data属性值来分析数据的类型,所以无需指定type类型
data和type属性一般只需要一个,通过setdata方法会把type属性设置为null
相反设置settype方法会把data设置为null
如果想要两个属性同时设置,要使用intent.setdataandtype()方法.

@Override
public void onClick(View v) {
         Intent  intent = new Intent();
         intent.setAction(Intent.ACTION_VIEW);
         Uri data = Uri.parse("file:///storage/sdcard0/pingfanzhilu.mp3");
         intent.setDataAndType(data, "audio/mp3");
         startActivity(intent);
}
---
extras 扩展信息

Android中菜单的形式有三种,其中最常用的是选项菜单optionmenu

progressdialog静态方法show显示进度对话框

---
AsyncTask
优点：简单、快捷、过程可控；
缺点：使用多个异步操作并需要修改UI时，就非常复杂了

Handler+Message
优点：结果清晰，功能定义明确，执行多个后台任务时简单
缺点：在单个后台异步处理时，显得代码稍多，结构稍微复杂
# Java字节流和字符流
IO输出流 写入 输入流 读取
---
字节流
创建FOS对象 重写模式和追加模式（true） write
创建FIS对象                                             read

缓冲字节流
创建BOS对象 使用flush方法
创建BIS对象
---------------------
字符流
创建OSW对象
创建ISR对象
缓冲字符流
PrintWriter 使用println（）方法
BufferReader 使用readline（）方法
---
# 统一建模语言UML简介
案例图、类图和序列图
类图是显示出类、接口以及他们之间的静态结构和关系的图。类图最基本的元素是类或接口。接口内有 public或final static类
类图中的关系是指类和类、类和接口、接口和接口之间可以建立以下几种关系：一般化关系、关联关系、聚合关系、合成关系和依赖关系
一般化关系 关键字extends和implement
关联关系  实例变量 单联更为普遍 
聚合关系  一个代表整体，另一个代表部分
合成关系 不能共享 
依赖关系 单向的 在Java语言中体现为局域变量、方法的参量，以及对静态方法的调用。

---
在Java语言规范中，一个方法的特征仅包括方法的名字、参量的数目和种类，而不包括方法的返还类型、参量的名字以及所抛出的异常。
一个类实现一个接口，这种关系叫做接口继承；而一个类是另一个类的子类，这种关系叫做实现继承。
一个接口的方法只能是抽象的和公开的，Java接口不能有构造子。Java接口可以有public、静态的和final的属性。
没有接口，可插入性就没有保证。
Java接口常见的方法：单方法接口、标识接口（工具类）、常量接口（代码模式）

---
在Java语言中，类有两种：一种是具体类，另一种是抽象类；具体类可以实例化，抽象类不可以实例化。
抽象类仅提供一个类型的部分实现。抽象类可以有实例变量，以及一个或多个构造子。抽象类可以同时有抽象方法和具体方法。（模板方法模式）
抽象类一定是用来继承的，具体类不是用来继承的。
抽象类应当拥有尽可能多的共同代码，提高代码的复用率；抽象类应当拥有尽可能少的数据，这样可以保证节省内存资源。

---
开-闭原则：一个软件实体应当对拓展开放，对修改关闭。

---
简单工厂模式：
简单工厂模式是类的创建模式 
工厂类角色Creator、抽象产品角色product、具体产品角色concrete product
在简单工厂模式中，一个工厂类处于对产品类实例化的中心位置上，他知道每一个产品，他决定哪一个产品类应当被实例化。

---
工厂方法模式：
工厂方法模式的用意是定义一个创建产品对象的工厂接口，将实际创建工作推迟到子类中。
在工厂方法模式中，核心的工厂类不再负责所有产品的创建，而是将具体创建的工作交给子类去做。
抽象工厂角色creator、具体工厂角色concrete creator、抽象产品角色product、具体产品角色concrete product
抽象工厂角色是接口、具体工厂角色实现了抽象工厂角色所声明的工厂方法，抽象产品角色是接口、具体产品角色实现了抽象产品角色

---
抽象工厂模式：
抽象工厂模式可以向客户端提供一个接口，使得客户端在不必指定产品的具体类型的情况下，创建多个产品族中的产品对象。
抽象工厂角色AbstractFactory、具体工厂类角色Concrete Factory、抽象产品角色Abstract product、具体产品角色Concrete product

---
地固坐标系与地图投影
地固坐标系根据坐标原点位置的不同分为地心坐标系和参心坐标系，无论是地心坐标系还是参心坐标系都可以分为空间直角坐标系和大地坐标系
地图投影有高斯克吕格投影、墨卡托投影、通用横轴墨卡托投影（UTM投影）

---
Android MVP的构成
MVP的全程时Model-View-Presenter，Model提供数据（网络请求、数据存储等）；View负责页面显示；Presenter负责逻辑的处理
Android MVP的优缺点
优点：主要就是将Model层和View层完全解耦，使得任何一方的修改都不会对另一方产生影响，而是将逻辑处理放在了Presenter层；
缺点：随着项目的增大，Presenter层也会变得臃肿
定义View层接口，实现View接口；定义Model层接口，实现Model接口；定义Presenter层接口，实现Presenter接口；在Activity中控制Presenter
三层之间调用顺序为View Presenter Model,为了调用安全不可反向调用，不可跨级调用

---
Android的startActivityForResult与onActivityResult与setResult参数分析，activity带参数的返回
使用场景：
在一个主界面通过意图跳转至多个不同的子Activity上去，当子模块的代码执行完毕后再次返回至主界面，将子activity中得到的数据交给主activity处理。

---
MVC中M是指数据模型、V是指用户界面、C则是控制器，使用MVC的目的是将M和V的实现代码分离，从而使得同一程序可以使用不同的表现形式
C存在的目的则是保证M和V的同步，一旦M改变，V应该同步更新。
# MVC的处理过程（https://www.cnblogs.com/CVstyle/p/6389990.html）
视图是用户看到并与之交互的界面，作为视图来讲，他只是作为一种输出数据并允许用户操纵的方式。
模型表示企业数据和业务规则，模型拥有最多的处理任务，应用模型的代码只需要写一次就可以被多个视图重用，减少了代码的重复性。
控制器接受用户的输入并调用模型和视图群完成用户的需求。

---
在Android中controller由activity和fragment担当，View由XML+java担当，Model由SQL担当。
controller负责根据用户从View输入的指令，选取Model中的数据，然后对其进行相应的操作，产生最终的结果。
通过界面响应用户的输入，通过模型层处理数据，最后返回结果给界面，控制器扮演着模型和界面的粘合剂角色。
Android应用程序中，MVC框架是如何实现的？都充当什么角色？
1-View接受用户的请求
2-View将请求转交给Controller
3-Controller操作Model进行数据更新
4-数据更新后，Model通知View数据变化
5-View显示更新后的数据
M层适合做一些业务逻辑处理，比如数据库存取操作、网络操作、复杂的算法等耗时操作；
V层显示数据部分，XML布局可以视为是V层，显示Model层的数据结果；
C层适合使用Activity担当，Android中的Activity用于处理用户交互问题（发起业务请求），读取用户输入（等待业务处理结果），响应用户点击等事件

---
ViewGroup类，UI组件放置到一个专门的View容器中，这个View容器就是ViewGroup，它的作用就是对添加进他的View组件进行布局。
android.view.ViewGroup类是抽象类，不能直接使用它。
ViewPager其实就是一个ViewPager，用法跟ListView类似，重点在于实现这样一个Adapter




