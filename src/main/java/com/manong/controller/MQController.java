package com.manong.controller;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MQController {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Destination destination;
	
	@ResponseBody
	@RequestMapping("mqsend")
	public void messageSend() {
		final String message = "测试发送消息~";
		jmsTemplate.send(destination,new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}
	
}
