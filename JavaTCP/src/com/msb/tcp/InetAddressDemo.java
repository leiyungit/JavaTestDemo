package com.msb.tcp;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
            InetAddress byName = InetAddress.getByName("leiyun.site");
            System.out.println(localHost);
            System.out.println(byName);



    }
}
