package chap18.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPSender {

	public static void main(String[] args) {
		try {
			DatagramSocket sender = new DatagramSocket(); // 보내는 컴퓨터 os 랜덤 포트 지정
			System.out.println("==발신 시작==");

			String message = "폭염에 조심하세요";
			byte[] message_byte = message.getBytes();

			DatagramPacket pack = new DatagramPacket(message_byte, message_byte.length,
					new InetSocketAddress("172.30.1.48", 15000)); // 데이터, 길이, 받는컴퓨터 ip,port
			sender.send(pack);

//			String message = "코로나가 다시 증가세를 보입니다.";
//			byte[] message_byte = message.getBytes();
//
//			DatagramPacket pack = new DatagramPacket(message_byte, message_byte.length,
//					new InetSocketAddress("172.30.1.48", 15000)); // 데이터, 길이, 받는컴퓨터 ip,port
//			sender.send(pack);

			System.out.println("==발신 종료==");
			sender.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
