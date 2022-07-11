package chap18.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getLocalHost();
			System.out.println("내 컴퓨터의 ip = " + ip.getHostAddress());

			InetAddress[] ip2 = InetAddress.getAllByName("www.naver.com");
			for (InetAddress inet : ip2) {
				System.out.println("네이버의 ip = " + inet.getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
