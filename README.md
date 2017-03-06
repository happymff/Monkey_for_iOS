# iosMonkey

# 0、简介
1.可以模拟android monkey执行的方式，在页面点击 滑动操作

2.计划保存截图

3.计划多台ios一起执行

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
按照项目

https://github.com/baozhida/MacacaAutomation

操作项目重签名

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
