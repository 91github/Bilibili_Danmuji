# 运行环境
**可在所有主要操作系统上运行，并且仅需要安装Java JDK或JRE版本8或更高版本。要检查，请运行java -version：**
```bash
$ java -version
java version "1.8.0_121"
```
**Bootstrap4 放弃了对 IE8 以及 iOS 6 的支持，现在仅仅支持 IE9 以上 以及 iOS 7 以上版本的浏览器。**<br/>
**以最新版本浏览器示例:**
<table>
    <thead>
        <tr>
            <td></td>
            <th>Chrome</th>
            <th>Firefox</th>
            <th>Internet Explorer</th>
            <th>Microsoft Edge</th>
            <th>Opera</th>
            <th>Safari</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th>Mac</th>
            <td>支持</td>
            <td>支持</td>
            <td>N/A</td>
            <td>N/A</td>
            <td>支持</td>
            <td>支持</td>
        </tr>
        <tr>
            <th>Windows</th>
            <td>支持</td>
            <td>支持</td>
            <td>支持</td>
            <td>支持</td>
            <td>支持</td>
            <td>不支持</td>
        </tr>
        <tr>
            <th>Linux</th>
            <td>支持</td>
            <td>支持</td>
            <td>N/A</td>
            <td>N/A</td>
            <td>支持</td>
            <td>支持</td>
        </tr>
    </tbody>
</table>

# 简介

**Bilibili Live Barrage Kyi in Springboot,基于Springboot的Bilibili直播弹幕姬(使用websocket协议)，java版B站弹幕姬.**<br/>
**本软件基于控制台 项目控制台运行，弹幕在控制台显示(也可以在网页查看弹幕).**<br/>
**本软件基于web设置 必须在浏览器上设置.**

## 现有功能
- **弹幕显示**
1. 舰爷房管勋章ul的设置显示
2. 禁言欢迎信息显示
3. 礼物显示
4. 新关注显示
- **弹幕保存本地**
- **网页弹幕显示**
- **扫码登录**
- **自动获取弹幕长度及颜色**
- **发送弹幕长度超出上限自动分条发送**
- **礼物舰感谢**
1. **延迟感谢(可统计延时内赠送的礼物合并感谢)！注意：延迟设置过高礼物持续赠送可能会造成刷屏**
2. 是否仅在直播中开启
3. **4种感谢屏蔽模式(1自定义礼物名称，2屏蔽所有免费礼物，3低价值礼物，4自定义规则)**
4. 可屏蔽天选时刻下的礼物
5. **3种礼物感谢模式(单人单种，单人多种，多人多种)**
6. 可调节每次感谢人数，礼物数
7. 触发直播间有人上舰长后发送私信(用于发送舰长群)
- **关注感谢**
1. 是否仅在直播中开启
2. 可调节每次感谢人数
- **定时发送弹幕(用于发送广告)**
1. 是否仅在直播中开启
2. 可调节时间
3. 目前两种模式 随机和按顺序发送
- **上舰私信**
1. 发送私信
2. 并可以设置发送私信成功后直播间发送提醒弹幕
- **模拟在线(老爷可增加在线经验)**
- **断线自动重连(实验性)**

## 后续功能

- **优化上舰私信**

# 如何运行(环境配置好的前提下)
### 发布版本
项目目录下控制台执行：
```bash
$ java -jar BiliBili_Danmuji-1.0.2beta.jar
```
Window下：<br/>
双击执行项目目录下run.bat
### 注意
- **首次运行会在项目目录下生成 log日志文件夹 DanmujiProfile配置文件**<br/>
- **关于DanmujiProfile配置文件，配置信息和用户cookie已加密存放在此，注意不要泄露给任何人**<br/>
- **本地运行浏览器输入localhost:23333(主页地址) 打开配置页面 远程请输入：远程主机ip:23333**<br/>
- **首次开启日志 会在项目目录下生成Danmuji_log文件夹 用来存放弹幕**<br/>
- **生成的用于存放弹幕文件名命名规则为 当天时间+房间号**<br/>
- **localhost:23333/connect 连接房间地址**<br/>
- **localhost:23333/login 扫码登录地址**<br/>

## 项目提示或教程
- **光标悬浮在相应位置出现提示**<br/><br/>
![提示](https://images.acproject.xyz/dm_tips.gif "提示")

## 项目UI
- **主页(未登录)**<br/><br/>
![主页(未登录)](https://images.acproject.xyz/dm_index.PNG "主页(未登录)")
- **连接房间**<br/><br/>
![连接房间](https://images.acproject.xyz/dm_connect.PNG "连接房间")
- **登录**<br/><br/>
![连接房间](https://images.acproject.xyz/dm_login.PNG "登录")
- **主页设置示例(未登录)**<br/><br/>
![主页设置示例(未登录)](https://images.acproject.xyz/dm_setn.PNG "主页设置示例(未登录)")
- **主页弹幕显示(已登录)**<br/><br/>
![主页弹幕显示(已登录)](https://images.acproject.xyz/dm_danmu.PNG "主页弹幕显示(已登录)")
- **主页设置示例(已登录)**<br/><br/>
![主页设置示例(已登录)](https://images.acproject.xyz/dm_sety.PNG "主页设置示例(已登录)")

## 开源

**基于MIT License开源协议.**

## 项目线上实战展示（用户名：坂崎简）

[破站坂本叔直播间](https://live.bilibili.com/1000 "破站坂本叔直播间")<br/><br/>
**本项目已在坂本叔直播间经过2年多的风吹雨打 最近才想起来开源,请放心使用**<br/>
**如果您使用了本软件，最好能在破站私聊我吱一下呢**

# 版本详细<br/>
**！！！注意：版本更新 覆盖jar文件就行，但是更新版本后，配置文件需要重新配置 登录不需要重新登录，更新版本注意自己另外存档配置**
<blockquote>
<h2>Beta1.0.3</h2>
<p>修复了若干bug(ke neng zhi zao le geng duo bug)</p>
<p>新功能：</p>
<p>增加了感谢关注姬感谢人数上限，以防止感谢刷屏 和 有效屏蔽天选时刻下的感谢关注</p>
<p>留言加入感谢  格式为 感谢name赠送的n个xx秒留言</p>
</blockquote>
<blockquote>
<h2>Beta1.0.2</h2>
<p>首发公开版本发出</p>
<p>已知bug：</p>
<p>自定义屏蔽礼物名称当只有一个时候只能后面加中文逗号才能保存设置，在1.0.3以后版本得到解决</p>
<p>自定义规则不显示提示，在1.0.3以后版本得到解决</p>
<p>多人多种礼物感谢模式当单人多种礼物时并不会合并多种礼物，在1.0.3以后版本得到解决</p>
<p>重要问题：弹幕姬登录后，在不开启广告姬的情况下保存设置会出现致命错误，导致弹幕姬开启不了，在1.0.3以后版本得到解决</p>
<p></p>
</blockquote>

