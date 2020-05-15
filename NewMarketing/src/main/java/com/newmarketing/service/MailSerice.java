package com.newmarketing.service;

import java.util.List;

public interface MailSerice {

	public void send(String fromAddress, String toAddress, String subject, String content) throws Exception;
	
}
