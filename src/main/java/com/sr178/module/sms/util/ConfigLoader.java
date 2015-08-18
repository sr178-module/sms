package com.sr178.module.sms.util;

import java.io.IOException;
import java.util.Properties;

import com.sr178.module.sms.config.AppConfig;
import com.sr178.module.sms.config.MailConfig;
import com.sr178.module.sms.config.MessageConfig;

/**
 * A class obtain the value and create configuration object by loading file
 * app_config.properties,including creating <strong>MailConfig<strong> and
 * creating <strong>MessageConfig<strong>.
 * 
 * @see AppConfig
 * @see MailConfig
 * @see MessageConfig
 * @version 1.0 at 2014/10/28
 * */
public class ConfigLoader {

	private static Properties pros = null;
	
	private static AppConfig messageConfig = null;
	
	private static AppConfig mailConfig = null;
	/**
	 * Loading file while class loading.The operation inside of static block
	 * will be run once.
	 * */
	static {
		pros = new Properties();
		try {
			pros.load(ConfigLoader.class
					.getResourceAsStream("/app_config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * enum define two kinds of configuration.
	 * */
	public static enum ConfigType {
		Mail, Message
	};

	/**
	 * A static method for outer class to create configuration by loading file.
	 * 
	 * @param type
	 *            ConfigType
	 * @return If the type is ConfigType#Mail,return the instance of
	 *         {@link MailConfig}. And,if the type is ConfigType#Message,return
	 *         the instance of {@link MessageConfig}.
	 * */
	public static AppConfig load(ConfigType type) {
		switch (type) {
		case Mail:
			return createMailConfig();
		case Message:
			return createMessageConfig();
		default:
			return null;
		}
	}

	private static AppConfig createMailConfig() {
		if(mailConfig==null){
			mailConfig = new MailConfig();
			mailConfig.setAppId(pros.getProperty(MailConfig.APP_ID));
			mailConfig.setAppKey(pros.getProperty(MailConfig.APP_KEY));
			mailConfig.setSignType(pros.getProperty(MailConfig.APP_SIGNTYPE));
		}
		return mailConfig;
	}

	private static AppConfig createMessageConfig() {
		if(messageConfig==null){
			messageConfig  = new MessageConfig();
			messageConfig.setAppId(pros.getProperty(MessageConfig.APP_ID));
			messageConfig.setAppKey(pros.getProperty(MessageConfig.APP_KEY));
			messageConfig.setSignType(pros.getProperty(MessageConfig.APP_SIGNTYPE));
		}
		return messageConfig;
	}

}
