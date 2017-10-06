/**
 * package_name:chapter1
 * @author:solitudeycq
 * date:2017-10-03 00:40:23
 * E-Mail:solitudeycq@163.com
 */
package chapter1;

import java.util.HashSet;
import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

/**
 * @author solitudeycq
 *
 */
public class ProgrammaticEchoServerAppConfig implements ServerApplicationConfig {

	@Override
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> arg0) {
		return arg0;
	}

	@Override
	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> endpointClasses) {
		Set<ServerEndpointConfig> configs = new HashSet<ServerEndpointConfig>();
		ServerEndpointConfig sec = ServerEndpointConfig.Builder.create(ProgrammaticEchoServer.class, "/programmaticecho").build();
		configs.add(sec);
		return configs;
	}

}
