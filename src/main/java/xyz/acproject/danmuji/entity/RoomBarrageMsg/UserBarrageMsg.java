package xyz.acproject.danmuji.entity.RoomBarrageMsg;



import xyz.acproject.danmuji.utils.FastJsonUtils;

public class UserBarrageMsg {
	private Short bubble;
	private UserBarrage danmu;
	private String uname_color;
	public UserBarrageMsg() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public UserBarrageMsg(Short bubble, UserBarrage danmu, String uname_color) {
		super();
		this.bubble = bubble;
		this.danmu = danmu;
		this.uname_color = uname_color;
	}
	public Short getBubble() {
		return bubble;
	}
	public void setBubble(Short bubble) {
		this.bubble = bubble;
	}
	public UserBarrage getDanmu() {
		return danmu;
	}
	public void setDanmu(UserBarrage danmu) {
		this.danmu = danmu;
	}
	public String getUname_color() {
		return uname_color;
	}
	public void setUname_color(String uname_color) {
		this.uname_color = uname_color;
	}
	@Override
	public String toString() {
		return "UserBarrageMsg [bubble=" + bubble + ", danmu=" + danmu + ", uname_color=" + uname_color + "]";
	}
	
	public String toJson() {
		return FastJsonUtils.toJson(new UserBarrageMsg(bubble, danmu, uname_color));
	}
}
