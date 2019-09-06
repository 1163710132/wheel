package com.chen1144.wheel.coroutine;

import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.channels.Channel;
import co.paralleluniverse.strands.channels.Channels;

import java.util.Optional;

public class ChannelWritableChannel<T> implements com.chen1144.wheel.coroutine.Channel<T> {
    private Channel<Optional<T>> channel;

    ChannelWritableChannel(){
        this.channel = Channels.newChannel(-1, Channels.OverflowPolicy.BLOCK, false, true);
    }

    @Override
    public void ret(T value) {
        try {
            channel.send(Optional.of(value));
        }catch (SuspendExecution | InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void brk() {
        try {
            channel.send(Optional.empty());
        }catch (SuspendExecution | InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<T> readNext() {
        try {
            return channel.receive();
        }catch (SuspendExecution | InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
