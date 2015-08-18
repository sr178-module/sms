package com.sr178.module.sms.demo;

import com.sr178.module.sms.config.AppConfig;
import com.sr178.module.sms.lib.MESSAGEXsend;
import com.sr178.module.sms.util.ConfigLoader;

public class MessageXSendDemo {

	public static void main(String[] args) {
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
		MESSAGEXsend submail = new MESSAGEXsend(config);
		submail.addTo("18516632554");
		submail.setProject("MApf82");
		submail.addVar("code", "a你好aaaa");
		submail.xsend();
	}	
}
