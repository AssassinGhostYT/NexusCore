package net.nexuscore.server;

import java.net.InetAddress;

public class PlayerSession {

    public enum State {
        UNCONNECTED,
        CONNECTING_1,
        CONNECTING_2,
        CONNECTED
    }

    private final InetAddress address;
    private final int port;
    private State state;
    private long lastPingTime;
    private String username;
    private short mtuSize; // <-- ¡NUEVO!

    public PlayerSession(InetAddress address, int port) {
        this.address = address;
        this.port = port;
        this.state = State.UNCONNECTED;
        this.lastPingTime = 0;
        this.username = null;
        this.mtuSize = 0; // <-- ¡NUEVO!
    }

    public InetAddress getAddress() { return address; }
    public int getPort() { return port; }
    public State getState() { return state; }
    public void setState(State state) { this.state = state; }
    public long getLastPingTime() { return lastPingTime; }
    public void updatePingTime() { this.lastPingTime = System.currentTimeMillis(); }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public short getMtuSize() { return mtuSize; } // <-- ¡NUEVO!
    public void setMtuSize(short mtuSize) { this.mtuSize = mtuSize; } // <-- ¡NUEVO!
}