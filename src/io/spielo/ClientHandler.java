package io.spielo;

import io.spielo.client.Client;

public class ClientHandler {
	public final static Client client;

	static {
		client = new Client();
		client.connect("192.168.2.122");
	}
}
