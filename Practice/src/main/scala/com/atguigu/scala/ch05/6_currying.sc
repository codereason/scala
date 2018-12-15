// These are meant to be typed into the REPL. You can also run
// scala -Xnojline < repl-session.scala to run them all at once.

// 传统定义两个参数
def mul(x: Int, y: Int) = x * y
mul(6, 7)

// 柯里化定义，使用到了闭包
def mulOneAtATime(x: Int) = (y: Int) => x * y

mulOneAtATime(6)(7)

// Scala中可以简写
//def mulOneAtATime(x: Int)(y: Int) = x * y

val a = Array("Hello", "World")
val b = Array("hello", "world")
// def corresponds[B](that: GenSeq[B])(p: (A,B) => Boolean): Boolean
a.corresponds(b)(_.equalsIgnoreCase(_))



def mulTwo(x: Int, y: Int) = x * y
//mulTwo: mulTwo[](val x: Int,val y: Int) => Int
def mulThree(z: Int) = (x: Int, y: Int) => x * y * z
//mulThree: mulThree[](val z: Int) => (Int, Int) => Int
//接受一个参数x 返回一个匿名函数
mulThree(5)(1, 2)
//res3: Int = 10
def mulThree_1(z: Int) = (x: Int, y: Int) => z * mulTwo(x: Int, y: Int)
//mulThree_1: mulThree_1[](val z: Int) => (Int, Int) => Int
def mulThree_2(z: Int)(y: Int)(x: Int) = x * y * z
//mulThree_2: mulThree_2[](val z: Int)(val y: Int)(val x: Int) => Int
mulThree_2(1)(2)(3)
//res4: Int = 6
mulThree_2(1) _ //将方法转为函数
//res5: Int => (Int => Int) = com.atguigu.scala.ch05.A$A68$A$A68$$Lambda$1974/424264706@67afab
def mulThree_4(z:Int)={
  (y:Int)=>{
    (x:Int)=>
      x*y*z
  }
}
//mulThree_4: mulThree_4[](val z: Int) => Int => (Int => Int)
mulThree_4(1)
//res6: Int => (Int => Int) = com.atguigu.scala.ch05.A$A68$A$A68$$Lambda$1975/1172498579@67bfe8fe

//mulThree_4 mulThree_2作用相同