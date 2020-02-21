/*
 * класс Connection — контекст. В этом классе реализована логика переходов, в
 * соответствии с графом переходов
 */
package connection;

import java.io.IOException;
import statemachine.AutomatonBase;
/**
 *
 * @author AKravchuk
 */
public class Connection extends AutomatonBase<IConnection> implements IConnection {
    private Connection() {
        Socket socket = new Socket();
        
        // Создание объектов состояний
        IConnection connected = new ConnectedState<Connection>(this, this, socket);
        IConnection disconnected = new DisconnectedState<Connection>(this, this, socket);
        
        //Логика переходов
        addEdge(connected, ConnectedState.DISCONNECT, disconnected);
        addEdge(connected, ConnectedState.ERROR, disconnected);
        addEdge(disconnected, DisconnectedState.CONNECT, connected);
        addEdge(disconnected, DisconnectedState.ERROR, disconnected);
        
        // Начальное состояние
        state = disconnected; 
    }
    
    // Создание экземпляра автомата
    public static IConnection createAutomaton() {
        return new Connection();
    }
    // Делегирование методов интерфейса
    @Override
    public void connect() throws IOException { state.connect(); }
    @Override
    public void disconnect() throws IOException { state.disconnect(); }
    @Override
    public int receive() throws IOException { return state.receive(); }
    @Override
    public void send(int value) throws IOException { state.send(value); } 
}
