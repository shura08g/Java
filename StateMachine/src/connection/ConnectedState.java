/*
 * В состоянии ConnectedState могут произойти события ERROR и DISCONECT, а в 
 * состоянии DisconnectedState — события CONNECT и ERROR
 */
package connection;

import java.io.IOException;
import statemachine.Event;
import statemachine.IEventSink;
import statemachine.StateBase;

/**
 *
 * @author AKravchuk
 * @param <AI>
 */
public class ConnectedState <AI extends IConnection> 
        extends StateBase<AI> implements IConnection {
    
    public static final Event DISCONNECT = new Event("DISCONNECT");
    public static final Event ERROR = new Event("ERROR");
    
    protected final Socket socket;
    
    public ConnectedState(AI automaton, IEventSink eventSink, Socket socket) {
        super(automaton, eventSink);
        this.socket = socket;
    }
    
    @Override
    public void connect() throws IOException {}
    
    @Override
    public void disconnect() throws IOException {
        try {
            socket.disconnect();
        } finally {
            eventSink.castEvent(DISCONNECT);
        }
    }
    
    @Override
    public int receive() throws IOException {
        try {
            return socket.receive();
        } //catch (IOException e) {
        catch (Exception e) {
            eventSink.castEvent(ERROR);
            throw e;
        }
    }
    
    @Override
    public void send(int value) throws IOException {
        try {
            socket.send();
        } //catch (IOException e) {
        catch (Exception e) {
            eventSink.castEvent(ERROR);
            throw e;
        }
    }
}
