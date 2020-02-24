package com.mail.service;

public interface MailSerice {

	public void send(String fromAddress, String toAddress, String subject, String content) throws Exception;
}
