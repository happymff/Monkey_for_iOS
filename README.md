# iosMonkey

# 1、准备macaca环境,和IOS UI自动化的准备一样
##安装命令行工具和驱动模块
$ npm i -g macaca-cli macaca-ios

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

##检测macaca环境
$ macaca doctor

# 2、打包WDA
重新签名后打包WDA


# 3、执行iosMonkey
开一个窗口
$ macaca server --verbose

在新窗口执行
$ java -jar [iosMonkey.jar Path] -u [设备的UDID] -b [测试App的BundleID]

# 4、修改源码重新打包

在项目下执行

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
