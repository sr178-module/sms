package com.sr178.module.sms.lib.base;

import com.sr178.module.sms.entity.DataStore;

public abstract class SenderWapper {

	protected DataStore requestData = new DataStore();

	public abstract ISender getSender();
}
