import java.io.IOException;

public class main {
	public static void main(String argv[]) throws IOException {
		clientetcp client= new clientetcp();
		java.net.Socket socket= client.crear();
		client.enviar(socket);
		//client.recibir(socket);
	}

}
