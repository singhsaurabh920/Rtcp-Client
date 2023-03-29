package org.reactor.tcp;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufFlux;
import reactor.netty.Connection;
import reactor.netty.DisposableServer;
import reactor.netty.tcp.TcpClient;
import reactor.netty.tcp.TcpServer;

import java.time.Duration;

@Slf4j
@SpringBootApplication
public class Client {

	public static void main(String[] args) {

		SpringApplication.run(Client.class, args);
		TcpClient client = TcpClient.create()
				.doOnConnect(connection-> log.info("doOnConnect {}",connection))
				.doOnConnected(connection-> log.info("doOnConnected {}",connection))
				.doOnDisconnected(connection-> log.info("doOnDisconnected {}",connection))
				.doOnChannelInit((connectionObserver,channel,remoteAddress)-> log.info("doOnConnection {}, {}, {}",connectionObserver,channel,remoteAddress))
				.host("127.0.0.1")
				.port(8089)
				.wiretap(true)
				//.metrics(true)
				.noSSL();
		Connection connection = client.handle((in, out) -> {
			//return out.send(Flux.concat(ByteBufFlux.fromString(Mono.just("echo")), in.receive().retain()))
			in.receive().asString().subscribe(i->{
				log.info("RECEIVED: {}",i);
			});
			return out.sendString(Flux.interval(Duration.ofMillis(100)).map(l -> {
				final String msg= Long.toString(l);
				log.info("SEND: {}",msg);
				return msg;
			}));
		}).connectNow();
		connection.onDispose()
				.block();
	}

}
