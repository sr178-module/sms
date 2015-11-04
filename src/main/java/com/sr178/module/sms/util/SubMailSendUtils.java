package com.sr178.module.sms.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


import com.sr178.module.sms.config.AppConfig;
import com.sr178.module.sms.lib.MESSAGEXsend;

public class SubMailSendUtils {
	
	
	public static void sendMessage(String to,String projectCode,Map<String,String> param){
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
		if(config.isOpen()){
			MESSAGEXsend submail = new MESSAGEXsend(config);
			submail.addTo(to);
			submail.setProject(projectCode);
			for(Entry<String,String> entity:param.entrySet()){
				submail.addVar(entity.getKey(),entity.getValue());
			}
			submail.xsend();
		}else{
			System.out.println("测试阶段，不真正发送验证码:code="+param.get("code"));
		}
	}
	
	
	public static void main(String[] args) {
		Map<String,String> param = new HashMap<String,String>();
		param.put("code", "1234567");
		SubMailSendUtils.sendMessage("15919820372", "aGTtt3", param);
	}
}
