/*
 * 
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
public class DisconnectedState <AI extends IConnection> 
        extends StateBase<AI> implements IConnection{
    public static final Event CONNECT = new Event("CONNECT");
    public static final Event ERROR = new Event("ERROR");
    
    protected final Socket socket;
    
    public DisconnectedState(AI automaton, IEventSink eventSink, Socket socket) {
        super(automaton, eventSink);
        this.socket = socket;
    }
    
    @Override
    public void connect() throws IOException {
        try {
            socket.connect();
        } //catch (IOException e) {
        catch (Exception e) {
            eventSink.castEvent(ERROR);
            throw e;
        }
    }
    
    @Override
    public void disconnect() throws IOException {}
    
    @Override
    public int receive() throws IOException {
        throw new IOException("Connection is closed (receive)");
    }
    
    @Override
    public void send(int value) throws IOException {
        throw new IOException("Connection is closed (send)");
    }
}
