package xyz.acproject.danmuji.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

import xyz.acproject.danmuji.conf.PublicDataConf;

public class HttpHeartBeatData {
	private static Logger LOGGER = LogManager.getLogger(HttpHeartBeatData.class);
	public static void httpGetHeartBeatOrS(Long timestamp) {
		BufferedReader bufferedReader = null;
		HttpURLConnection httpURLConnection = null;
		String data = null;
		JSONObject jsonObject = null;
		URL url = null;
		String urlString = null;
		try {
			if(timestamp!=null) {
			urlString = "https://api.live.bilibili.com/relation/v1/Feed/heartBeat?_="+timestamp;
			}else {
			urlString = "https://api.live.bilibili.com/relation/v1/Feed/heartBeat";
			}
			url = new URL(urlString);
			httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty("USER-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36");
			httpURLConnection.setRequestProperty("referer", "https://live.bilibili.com/" + PublicDataConf.ROOMID);
			if (!StringUtils.isEmpty(PublicDataConf.USERCOOKIE)) {
				httpURLConnection.setRequestProperty("cookie", PublicDataConf.USERCOOKIE);
			}
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
			String msg = null;
			while (null != (msg = bufferedReader.readLine())) {
				data = msg;
			}
			bufferedReader.close();
			httpURLConnection.disconnect();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			if (httpURLConnection != null) {
				httpURLConnection.disconnect();
			}
		}
		jsonObject = JSONObject.parseObject(data);
		short code = jsonObject.getShort("code");
		if (code == 0) {
			if(jsonObject.getString("msg").equals("success")) {
//				LOGGER.debug("在线心跳包get发送成功"+jsonObject.getString("data"));
			}else {
				LOGGER.error("在线心跳包get发送失败"+jsonObject.toString());
			}
		}else {
			LOGGER.error("在线心跳包get发送失败"+jsonObject.toString());
		}
	}
    public static void httpPostUserOnlineHeartBeat() {
    	JSONObject jsonObject = null;
		OutputStreamWriter out = null;
		BufferedReader bufferedReader = null;
		HttpURLConnection httpURLConnection = null;
		String data = null;
		URL url = null;
		StringBuilder stringBuilder = new StringBuilder();
		String param = null;
		try {
			String urlString = " https://api.live.bilibili.com/User/userOnlineHeart";
			url = new URL(urlString);
			httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			httpURLConnection.setRequestProperty("USER-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36");
			httpURLConnection.setRequestProperty("referer", "https://live.bilibili.com/" + PublicDataConf.ROOMID);
			if (!StringUtils.isEmpty(PublicDataConf.USERCOOKIE)) {
				httpURLConnection.setRequestProperty("cookie", PublicDataConf.USERCOOKIE);
			}
			httpURLConnection.setUseCaches(false);
			httpURLConnection.setInstanceFollowRedirects(true);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setDoInput(true);
			out = new OutputStreamWriter(httpURLConnection.getOutputStream(), "utf-8");
			if (PublicDataConf.USERBARRAGEMESSAGE != null&&PublicDataConf.COOKIE!=null) {
				stringBuilder.append("csrf_token=").append(PublicDataConf.COOKIE.getBili_jct()).append("&csrf=").append(PublicDataConf.COOKIE.getBili_jct()).append("&visit_id=");
				param = stringBuilder.toString();
			}
			out.write(param);
			out.flush();

			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
			String msgs = null;
			while (null != (msgs = bufferedReader.readLine())) {
				data = msgs;
			}
			bufferedReader.close();
			httpURLConnection.disconnect();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			if (httpURLConnection != null) {
				httpURLConnection.disconnect();
			}
		}
		jsonObject = JSONObject.parseObject(data);
		short code = jsonObject.getShort("code");
		if (code == 0) {
			if(jsonObject.getString("message").equals("0")) {
//				LOGGER.debug("心跳包post发送成功" + jsonObject.getString("data"));
			}else{
				LOGGER.error("心跳包post发送失败,未知错误,原因未知v" + jsonObject.toString());
			}
		} else {
			LOGGER.error("发跳包post发送失败,未知错误,原因未知" + jsonObject.toString());
		}
   	}
}
