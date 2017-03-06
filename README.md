# iosMonkey

# 1、准备macaca环境

##安装usbmuxd
$ brew install usbmuxd

##安装ios_webkit_debug_proxy
$ brew install ios_webkit_debug_proxy

##安装ios-deploy
$ brew install ios-deploy

##安装ideviceinstaller
$ brew install ideviceinstaller

##安装carthage
$ brew install carthage

##安装macacajs包括，macaca-cli macaca-ios

```
npm install macaca-cli -g

npm install macaca-ios -g

```
MAC全局安装的路径分别如下：

```
/usr/local/lib/node_modules/macaca-cli
/usr/local/lib/node_modules/macaca-ios
```

##检测macaca环境，无报错
$ macaca doctor

# 2、WebDriverAgent项目重签名

查找WebDriverAgent项目发现有两个，都需要使用xcode重新签名

我使用的是自己的苹果账号，有个限制就是，有效期是7天，过期之后需要重新签名，有个开发者账号最好，没有也能用，过期了再签一次就可以了。

 ```
/usr/local/lib/node_modules/app-inspector/node_modules/.1.0.41@webdriveragent/WebDriverAgent
/usr/local/lib/node_modules/macaca-ios/node_modules/.1.0.41@webdriveragent/WebDriverAgent
```
或者
```
/usr/local/lib/node_modules/macaca-ios/node_modules/webdriveragent/WebDriverAgent
/usr/local/lib/node_modules/macaca-inspector/node_modules/webdriveragent/WebDriverAgent
```
这个目录，由于webdriveragent -> .1.0.41@webdriveragent  是软连接，其实是一样的。

第一个目录的项目是inspector功能执行时候，自动化安装WDA到iPhone上，为的是在手机启动WDA，可以查看手机UI控件布局。

第二个目录是在UI自动化脚步时候，自动化安装WDA到iPhone上，为的是在手机启动WDA，可以执行ui case的指令。

上面两个目录下各自找到项目文件，Xcode打开，下图中的［1］［2］team重新选择，原则上就可以直接使用，保险起见，把5处全部修改，保证不出错。

接着修改Bundle Identifier，每个项目中能改的全部改掉，换个名字即可，比如把各处的id中的facebook改成abc


# 3、执行iosMonkey
开一个窗口执行

$ macaca server --verbose

在一个新窗口执行

$ java -jar [iosMonkey.jar Path] -u [设备的UDID] -b [测试App的BundleID]

# 4、修改源码重新打包方法

如果需要源码实现自定义的功能，在项目目录下执行

$ mvn assembly:assembly

最后提示如下，标示打包成功，target下生成iosMonkey-1.0-SNAPSHOT.jar，可以使用最新的包
```
INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 7.350 s
[INFO] Finished at: 2017-03-06T17:01:30+08:00
[INFO] Final Memory: 20M/324M
[INFO] ------------------------------------------------------------------------
```
