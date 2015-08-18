package com.sr178.module.sms.demo;

import com.sr178.module.sms.config.AppConfig;
import com.sr178.module.sms.lib.ADDRESSBOOKMail;
import com.sr178.module.sms.util.ConfigLoader;

public class AddressBookMailUnSubscribe {

	public static void main(String[] args) {

		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Mail);
		ADDRESSBOOKMail addressbook = new ADDRESSBOOKMail(config);
		addressbook.setAddress("leo@apple.cn", "leo");
		addressbook.unsubscribe();
	}	
}
