package connection;

import java.io.IOException;

/**
 *
 * @author AKravchuk
 */
public interface IConnection {
    public void connect() throws IOException;
    public void disconnect() throws IOException;
    public int receive() throws IOException;
    public void send(int value) throws IOException;
}
