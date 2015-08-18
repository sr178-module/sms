package com.sr178.module.sms.lib;

import com.sr178.module.sms.config.AppConfig;
import com.sr178.module.sms.config.MailConfig;
import com.sr178.module.sms.config.MessageConfig;
import com.sr178.module.sms.lib.base.ISender;
import com.sr178.module.sms.lib.base.SenderWapper;

/**
 * A SenderWapper class as decoration class for user to subscribe and unsubscribe by message.
 * User can set the basic information of request by included several methods.
 * Then,send the request data by a mode of message.
 * 
 * @see Mail
 * 
 * @version 1.0 at 2014/10/28
 * */
public class ADDRESSBOOKMessage extends SenderWapper {

	/**
	 * If the mode is mail,it's an instance of {@link MailConfig}. If the mode
	 * is message,it's an instance of {@link MessageConfig}
	 * */
	protected AppConfig config = null;
	public static final String ADDRESS = "address";
	public static final String TARGET = "target";

	public ADDRESSBOOKMessage(AppConfig config) {
		this.config = config;
	}
	
	public void setAddress(String address){
		requestData.put(ADDRESS, address);
	}
	
	public void setAddressbook(String target){
		requestData.put(TARGET, target);
	}
	@Override
	public ISender getSender() {
		return new Message(this.config);
	}
	
	public void subscribe(){
		getSender().subscribe(requestData);
	}
	
	public void unsubscribe(){
		getSender().unsubscribe(requestData);
	}
}
