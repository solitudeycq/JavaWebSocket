/**
 * package_name:chapter1
 * @author:solitudeycq
 * date:2017-10-03 00:14:57
 * E-Mail:solitudeycq@163.com
 */
package chapter1;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

/**
 * @author solitudeycq
 *
 */
public class ProgrammaticEchoServer extends Endpoint {

	@Override
	public void onOpen(Session session, EndpointConfig endpointConfig) {
		System.out.println("执行了");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND)+3);
		final Session mySession = session;
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				try {
					mySession.getBasicRemote().sendText((new Date()).toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}, calendar.getTime(),2000);
		mySession.addMessageHandler(new MessageHandler.Whole<String>() {

			@Override
			public void onMessage(String text) {
				try {
					mySession.getBasicRemote().sendText("I got this ("+text+") so I am sending it back!");
				} catch (IOException e) {
					System.out.println("oh dear,something went wrong trying to send the message back: " + e.getMessage());
				}
			}
		});
	}

}
