/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devsu.serviciocliente.application.port.out.notification;

/**
 * @author rizzoli
 */
public interface MessageBrokerPort {
    public void send(Object message);
}
