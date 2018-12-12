package com.atguigu.scala

package object ch02 {
  def custom(string: String): Unit ={
    print(string+"111")
  }

  def main(args: Array[String]): Unit = {
    custom("123")
  }
}
