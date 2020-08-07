package xyz.acproject.danmuji.conf;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import xyz.acproject.danmuji.client.WebSocketProxy;
import xyz.acproject.danmuji.entity.RoomBarrageMsg.UserBarrageMsg;
import xyz.acproject.danmuji.entity.auto_reply.AutoReply;
import xyz.acproject.danmuji.entity.danmu_data.Gift;
import xyz.acproject.danmuji.entity.danmu_data.Interact;
import xyz.acproject.danmuji.entity.user_data.User;
import xyz.acproject.danmuji.entity.user_data.UserCookie;
import xyz.acproject.danmuji.thread.AdvertThread;
import xyz.acproject.danmuji.thread.AutoReplyThread;
import xyz.acproject.danmuji.thread.FollowShieldThread;
import xyz.acproject.danmuji.thread.GiftShieldThread;
import xyz.acproject.danmuji.thread.LogThread;
import xyz.acproject.danmuji.thread.ParseThankFollowThread;
import xyz.acproject.danmuji.thread.ParseThankGiftThread;
import xyz.acproject.danmuji.thread.SendBarrageThread;
import xyz.acproject.danmuji.thread.core.HeartByteThread;
import xyz.acproject.danmuji.thread.core.ParseMessageThread;
import xyz.acproject.danmuji.thread.core.ReConnThread;
import xyz.acproject.danmuji.thread.online.HeartBeatThread;
import xyz.acproject.danmuji.thread.online.HeartBeatsThread;
import xyz.acproject.danmuji.thread.online.UserOnlineHeartThread;

public class PublicDataConf {
	//url 直播弹幕websocket地址
	public static String URL = null;
	//房间号
	public static Long ROOMID = null;
	//主播uid
	public static Long AUID = null;
	//主播粉丝数
	public static Long FANSNUM =null;
	//主播名称
	public static String ANCHOR_NAME = null;
	//房间人气
	public static Long ROOM_POPULARITY =1L;
	//直播状态 0不直播 1直播 2轮播
	public static Short lIVE_STATUS = 0;
	//cookie String串
	public static String USERCOOKIE = null;
	//user信息
	public static User USER = null;
	//cookie
	public static UserCookie COOKIE = null;
	//user弹幕长度
	public static UserBarrageMsg USERBARRAGEMESSAGE = null;
	//天选礼物屏蔽
	public static String SHIELDGIFTNAME = null;
	//天选是否正在屏蔽关注
	public static Boolean ISSHIELDFOLLOW = false;
	//设置
	public static CenterSetConf centerSetConf;
	
	
	//心跳包 16进制
	public static String heartByte="0000001f0010000100000002000000015b6f626a656374204f626a6563745d";
	//包头长
	public static char packageHeadLength = 16;
	//验证包协议类型
	public static int firstPackageType = 7;
	//心跳包协议类型
	public static int heartPackageType = 2;
	//心跳包&验证包协议版本
	public static char packageVersion = 1;
    //心跳包&验证包的尾巴其他
	public static int packageOther = 1;
	
	//websocket客户端主线程
	public static WebSocketProxy webSocketProxy;
	//心跳线程
	public static HeartByteThread heartByteThread;
	//重新连接线程
	public static ReConnThread reConnThread;
	//处理信息分类线程
	public static ParseMessageThread parseMessageThread;
	//处理弹幕包集合
	public final static Vector<String> resultStrs = new Vector<String>(100);
	//礼物感谢集
	public final static ConcurrentHashMap<String,Vector<Gift>> thankGiftConcurrentHashMap = new ConcurrentHashMap<String,Vector<Gift>>(3000);
	//待发弹幕集
	public final static Vector<String> barrageString = new Vector<String>();
	//log日志待写入集合
	public final static Vector<String> logString = new Vector<String>(100);
	//待发送感谢关注集合
	public final static Vector<Interact> interacts = new Vector<Interact>(200);
	//弹幕
	public final static Vector<AutoReply> replys = new Vector<AutoReply>();
	
	//日志线程
	public static LogThread logThread;
	//处理关注数刷新线程
	public static ParseThankFollowThread parsethankFollowThread = new ParseThankFollowThread();
	//广告姬线程
	public static AdvertThread advertThread;
	//感谢礼物数据集线程
	public static ParseThankGiftThread parsethankGiftThread = new ParseThankGiftThread();
	//发送弹幕线程
	public static SendBarrageThread sendBarrageThread;
	//屏蔽天选礼物线程
	public static GiftShieldThread giftShieldThread = new GiftShieldThread();
	//屏蔽天选关注线程
	public static FollowShieldThread followShieldThread = new FollowShieldThread();
	//自动回复线程
	public static AutoReplyThread autoReplyThread;
	
	//用户在线线程集
	public static HeartBeatThread heartBeatThread;
	public static HeartBeatsThread heartBeatsThread;
	public static UserOnlineHeartThread userOnlineHeartThread;

	//是否显示人气
	public static Boolean IS_ROOM_POPULARITY =false;
	
	public static Long ROOMID_SAFE = null;
	public static String EDITION ="2.0";

	
}
