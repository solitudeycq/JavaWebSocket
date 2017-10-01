/**
 * package_name:chapter1
 * @author:solitudeycq
 * date:2017-10-02 00:44:26
 * E-Mail:solitudeycq@163.com
 */
package chapter1;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

/**
 * @author solitudeycq
 *
 */
@ServerEndpoint("/echo")
public class EchoServer {
	@OnMessage
	public String echo(String incomingMessage) {
		System.out.println(incomingMessage);
		return "I got this ("+incomingMessage+")"+" so I am sending it back.";
	}
}
