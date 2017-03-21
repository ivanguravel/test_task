package com.concretepage.rabbitmq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.Socket;

@Component
public class SocketIO {

    @Value("${v_switch.host}")
    private String host;
    @Value("${v_switch.port}")
    private String port;

    public String writeAndGetResponse(final String payload) {
        try (Socket socket = new Socket(host, Integer.parseInt(port))) {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            output.println(payload);
            output.flush();
            return input.readLine();
        }
        catch (IOException e) {
            System.out.println("Problems while working with socket input/output");
            System.out.println(e.getMessage());
        }
        return "";
    }
}
