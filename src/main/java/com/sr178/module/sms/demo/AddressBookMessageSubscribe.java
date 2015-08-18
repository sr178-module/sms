package com.sr178.module.sms.demo;

import com.sr178.module.sms.config.AppConfig;
import com.sr178.module.sms.lib.ADDRESSBOOKMessage;
import com.sr178.module.sms.util.ConfigLoader;

public class AddressBookMessageSubscribe {

	public static void main(String[] args) {

		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
		ADDRESSBOOKMessage addressbook = new ADDRESSBOOKMessage(config);
		//addressbook.setAddress("186****7150");
		addressbook.subscribe();
	}	
}
