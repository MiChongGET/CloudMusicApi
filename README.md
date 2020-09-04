# CloudMusicApi
网易云音乐API接口获取和分析

## 一、网易云音乐歌曲评论数据获取分析

>本来是想着用jsoup来爬取网易的评论，结果一分析发现获取的网页中找不到评论数据。研究了半天，无果。于是百度看看。
果然是大厂，在安全方面肯定做的比较多，原因是在传递参数的时候对参数进行加密，所以在我们直接访问网址的时候，如果传递的参数没有经过加密，前端页面就获取不到数据。看看知乎的大神们的解法：https://www.zhihu.com/question/36081767

**下面是我的分析**
![](https://ae01.alicdn.com/kf/H949d927783084247bc52252237ed04d3W.jpg)

>我们先对页面分析：
- 1、首先通过URL得知歌曲的固定id
- 2、这是我们需要查看的歌曲
- 3、通过开发者工具可以找到评论的API接口
- 4、我们可以看到response给我们的是json数据，我们所需要的评论数据就是包含在json数据中。

>现在问题来了，API接口知道了，直接访问行不行呢？答案是，肯定不行啊！最起码我们要把歌曲的id传过去，才可以找到指定的评论啊。
通过分析可以知道，参数没有放在URL中，所以参数肯定是post过去的。要不怎么说是大厂呢，就算是你把参数放在请求头也是不行的！如果我是产品经理肯定要程序员去加密传输数据，我大厂的数据岂是你能随便获取的！
继续分析：
![](https://ae01.alicdn.com/kf/He7f85dc58e9540fd90eeb064f09b3a8cU.jpg)

**通过在header中我们可以发现完整的请求地址，以及包头的一些参数配置。**
**重点来了：**
![](https://ae01.alicdn.com/kf/Hd690b10a961243fc9c1ec341474a15a7u.jpg)

>在data中我们发现了两个参数，对，就是加密之后的参数，肯定看不懂啦。这都是加密之后的密文。这里肯定是我们要传递的参数，包括歌曲的id什么的，但是加密算法我们怎么能知道呢？
走到这一步我们似乎前一脚已经踏进去了，还没有落地，发现脚下埋着地雷！
不急不急，再神秘的算法也是人写的嘛！总会有破解的方法。

## 二、post数据加密破解
>为了安全问题，一般程序员或多或少会对数据进行加密。一般加解密的程序只有开发者自己清楚。
总是有那么些大牛平时没事干就喜欢琢磨这些事情，通过破解这些程序来证明自己。还有的是为了喜欢的女孩，比如下面这位：（这是一个悲伤的故事！）

![](https://ae01.alicdn.com/kf/Hcf5b10bcaf1f41c3b729d9edd2bd71514.jpg)

>这位同学的代码分析能力很强，他提供的方法属于另辟蹊径。其他的大牛都是通过分析js加密算法，然后自己写出来，实现对传输参数的加密，大部分都是使用Python，这位作者使用的是纯Java写的加密程序。通过java内置的ScriptEngine调用js引擎，实现对js中的方法调用，这个我也是第一次听说，在JavaSE6中提供的功能。什么是ScriptEngine,请看博客：https://www.cnblogs.com/zouhao/p/3644788.html或者
http://blog.csdn.net/u012660667/article/details/49821811
作者通过对core.js的核心文件分析，将两万行的代码删减成一千多行，不得不说作者很有耐心啊！最后就简单了，直接在java代码中调用js的方法就可以对参数进行加密了。

### 现在对代码进行分析：
#### 1、首先分析JSSecret.java
![](https://ae01.alicdn.com/kf/Ha0cc72dcfb0d4bf3aa64dc065ed99789b.jpg)

**一开始是static中实现起始加载的功能**
- 1）首先使用Java的NIO实现对文件的读取，Path和Files，对于以往的各种IO流大家是不是写吐了
- 2）第二步使用ScriptEngineManager，详情看下面的官方API,使用getEngineByName()方法指定参数，可以获取指定脚本的ScriptEngine的对象。
![](https://ae01.alicdn.com/kf/H82d6513d66754d40956051a66eebe17aP.jpg)
![](https://ae01.alicdn.com/kf/H574f41bf2d1d49cd99ebb0559811f8ffH.jpg)

- 3）第三步创建ScriptEngine对象
![](https://ae01.alicdn.com/kf/H4ec65b2bd74e40caa5473b9a80bc992dC.jpg)
![](https://ae01.alicdn.com/kf/H25635ff4712945af855700c453f0e4f1f.jpg)
>也就是说当我们将js代码放入到eval中当做参数就可以执行相应的js代码。

- 2）Invocable
>这一步我们就要调用js中的方法，上一步我们获取到了js的对象，我们来看看什么是Invocable：

![](https://ae01.alicdn.com/kf/Hbe6810a382794f07b27c1b453105b67dL.jpg)
![](https://ae01.alicdn.com/kf/H1021c06dbf4a439f86a1fe39ab093225g.jpg)

#### 2、js中实现参数加密：
![](https://ae01.alicdn.com/kf/H95cddf20f4cb41f4bbbb277c04ac926bD.jpg)

**Core.js中部分代码：**
![](https://ae01.alicdn.com/kf/Ha97758b534de48fc8eea28284d806f7aq.jpg)

**让我们来看看网易的js代码**
![](https://ae01.alicdn.com/kf/H96b7b872a4c7476fb8b319d43d5c93dbx.jpg)

>这些都是什么鬼，你没看错，找不到变量名称吧，一般写程序都是按照功能给变量起特定的名字，但是网易的全是abcdefg什么的，这里应该是使用了代码混淆！

- 1）第一步可以看到。此处执行了core.js中myFunc()方法，将传入的参数paras进行加密。那么paras参数是什么呢？通过程序运行可以看出paras参数是一个json数据集，包含了四个参数，实际测试随着接口的不同参数是可以改变的，csrf_token亲测给不给数据没关系的。主要是offset和limit，懂数据库的同学应该懂得，起始位置和返回数据的数目。Uid可以根据具体的需求来改，参数名称可以从URL中获取到。
![](https://ae01.alicdn.com/kf/H811dfb796966454695c8d52a61293a04p.jpg)

大家再看看`ScriptObjectMirror`这个东西，这又是什么鬼？在java6的API找了一圈，结果没找到，java7才支持的，可见作者的见识很广。但是奇怪的是从1.7找到1.8也找不到这个东西！
![](https://ae01.alicdn.com/kf/H00bf6d1a8e504e11bbef78a2c6e69e30n.jpg)

>没办去去Oracle的官网去看API了，是不是这玩意太偏了，一般用不到。链接如下：
https://docs.oracle.com/javase/9/docs/api/jdk/nashorn/api/scripting/ScriptObjectMirror.html
你没看错，这是JDK9，也就是Java9的API，我能怎么办，我也很无奈啊！先看官方解释：
![](https://ae01.alicdn.com/kf/Hf8b422a9639842bc96a52cf01c3e3798Y.jpg)

>大家看一看，这不就是和Map非常相似嘛，get(参数)方法中的参数就是key，返回值就是value，下面我们来验证一下：这应该是set集合，以`Map.Entry<String,Object>`为泛型类型，通过foreach我们就可以获取so存储的全部的值。它的两个key分别是encText和encSeckey，它们的值就是js加密过后的值。

![](https://ae01.alicdn.com/kf/H05f1c9c3f8ae48c8a471878a06b0c38ak.jpg)
![](https://ae01.alicdn.com/kf/Hf4caa6565590402fb18b39b5ac9c9d15h.jpg)
**源码**
```java
publicObject get(finalObject key) {
    checkKey(key);
    return this.inGlobal(newCallable() {
       publicObject call() {
           returnScriptObjectMirror.translateUndefined(ScriptObjectMirror.this.wrapLikeMe(ScriptObjectMirror.this.sobj.get(key)));
       }
    });
}
```

2）第二步就是在Map中设置这两个值，最后整个方法返回一个map对象。

## 三、数据请求测试
**分析测试类：**
![](https://ae01.alicdn.com/kf/Hd998d73790914f21bd77ca3a57aacf719.jpg)
- 1）将请求参数封装到json中。
![](https://ae01.alicdn.com/kf/H293a95ab59b244d8b1d8401679d9fa6bo.jpg)
- 2）封装请求头。
- 3）请求头中主要修改的是url和data的参数，也就是请求地址和携带的参数。
- 4）最后通过API接口返回完整的json数据
![](https://ae01.alicdn.com/kf/H02f13edd3dfe484c92e21db8ca9c8aadS.jpg)


## 四、爆出其它的API接口：

>通过分析各种页面，发现参数加密方式都是一致的，所以这就很简单了，其它的接口也都出来了。下面做个总结：

### 1、搜索API：
 
原来的网页地址：
http://music.163.com/#/search/m/?id=28193075&s=%E5%9C%A8%E4%BA%BA%E9%97%B4&type=1
 
(%E5%9C%A8%E4%BA%BA%E9%97%B4)这个就是我们在搜索框中输入内容
 
搜索建议：
http://music.163.com/weapi/search/suggest/web?csrf_token=
 
按类型搜索：
http://music.163.com/weapi/cloudsearch/get/web?csrf_token=
 
 
在原地址上面传递的参数可以分析：
type类型的不同，搜索的类型不同
type=1             单曲

type=10           专辑

type=100         歌手

type=1000      歌单

type=1002      用户

type=1004       MV

type=1006      歌词

type=1009      主播电台
 
 
 
#### 2、查看粉丝
请求头：
Referer:http://music.163.com/user/fans?id=97526496
 
获取指定用户的粉丝：
http://music.163.com/weapi/user/getfolloweds?csrf_token=
 
 
#### 3、动态：
http://music.163.com/user/event?id=97526496
http://music.163.com/weapi/event/get/97526496?csrf_token=
 
 
#### 4、播放
http://music.163.com/weapi/song/enhance/player/url
直接播放地址：id可以改为任何存在的歌曲的ID
http://music.163.com/outchain/player?type=2&id=516392300&auto=1&height=66&bg=e8e8e8
 
#### 5、评论（热门评论和全部评论）
516392300这就是歌曲的id
http://music.163.com/weapi/v1/resource/comments/R_SO_4_516392300?csrf_token=1ac15bcb947b3900d9e8e6039d121a81




2、查看粉丝
请求头：
Referer:http://music.163.com/user/fans?id=97526496

获取指定用户的粉丝：
http://music.163.com/weapi/user/getfolloweds?csrf_token=


3、动态：
http://music.163.com/user/event?id=97526496
http://music.163.com/weapi/event/get/97526496?csrf_token=


4、播放
http://music.163.com/weapi/song/enhance/player/url
直接播放地址：id可以改为任何存在的歌曲的ID
http://music.163.com/outchain/player?type=2&id=516392300&auto=1&height=66&bg=e8e8e8

5、评论（热门评论和全部评论）
516392300这就是歌曲的id
http://music.163.com/weapi/v1/resource/comments/R_SO_4_516392300?csrf_token=1ac15bcb947b3900d9e8e6039d121a81    
