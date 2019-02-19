package com.manong.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component
public class QueueListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		TextMessage msg=(TextMessage) message;
        try {
        	System.out.println(msg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
	}

}
