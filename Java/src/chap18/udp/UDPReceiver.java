package chap18.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiver {

	public static void main(String[] args) {
		try {
			DatagramSocket receiver = new DatagramSocket(15000);
			System.out.println("==수신 시작==");
			byte[] receive_byte = new byte[100];
			DatagramPacket pack = new DatagramPacket(receive_byte, receive_byte.length); // 데이터, 길이
			receiver.receive(pack);

			String receive_str = new String(pack.getData(), 0, pack.getLength()); // byte[] -> String
			System.out.println("받은 문자열 ==>" + receive_str);
			System.out.println("==수신 종료==");
			receiver.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
