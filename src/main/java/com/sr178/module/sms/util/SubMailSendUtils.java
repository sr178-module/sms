package com.sr178.module.sms.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


import com.sr178.module.sms.config.AppConfig;
import com.sr178.module.sms.entity.SubMailResult;
import com.sr178.module.sms.lib.MESSAGEXsend;

import net.sf.json.JSONObject;

public class SubMailSendUtils {
	
	
	public static boolean sendMessage(String to,String projectCode,Map<String,String> param){
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
		if(config.isOpen()){
			MESSAGEXsend submail = new MESSAGEXsend(config);
			submail.addTo(to);
			submail.setProject(projectCode);
			for(Entry<String,String> entity:param.entrySet()){
				submail.addVar(entity.getKey(),entity.getValue());
			}
			return submail.xsend();
		}else{
			System.out.println("测试阶段，不真正发送验证码:code="+param.get("code"));
			return true;
		}
	}
	
	
	public static SubMailResult sendMessageForResult(String to,String projectCode,Map<String,String> param){
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
		if(config.isOpen()){
			MESSAGEXsend submail = new MESSAGEXsend(config);
			submail.addTo(to);
			submail.setProject(projectCode);
			for(Entry<String,String> entity:param.entrySet()){
				submail.addVar(entity.getKey(),entity.getValue());
			}
			String result = submail.xsendForResult();
			if(result!=null){
				JSONObject json = JSONObject.fromObject(result);
				SubMailResult re =  new SubMailResult(json.getString("status"), json.getString("send_id"),json.getInt("fee") ,json.getInt("sms_credits"));
			    return re;
			}else{
				return null;
			}
		}else{
			System.out.println("测试阶段，不真正发送验证码:code="+param.get("code"));
			return new SubMailResult();
		}
	}
	
	public static void main(String[] args) {
		Map<String,String> param = new HashMap<String,String>();
		param.put("code", "1234567");
		SubMailResult re = SubMailSendUtils.sendMessageForResult("15919820372", "aGTtt3", param);
		System.out.println(re);
	}
}
