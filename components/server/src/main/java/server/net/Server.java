package server;
/*
   Caian R. Ertl     (@caianrais)       - 20733152
   Diogo Casagrande  (@DiogoCasagrande) - 20718678
   Julia G. C. Chiba (@JuliaChiba)      - 20511823
 */

import java.util.Random;
import java.io.IOException;

import java.net.Socket;
import java.net.ServerSocket;

import java.lang.Runtime;

class Server
{
    private int port;
    private String name;
    private Random rand;

    private final int MAX_PORT_NUMBER = 65535;
    private final int MIN_PORT_NUMBER = 5000;

    public Server(Integer port)
    {
        this.rand = new Random();

        if(port == null)
            this.port = generateValidPort();
        else
            this.port = port.intValue();

        this.name = generateUniqueName();
    }

    private String generateUniqueName()
    {
        String[] humanNames = {
            "JAMES", "JOHN", "ROBERT", "MICHAEL", "WILLIAM",
            "DAVID", "RICHARD", "CHARLES", "JOSEPH", "THOMAS",
            "MARY", "LINDA", "ELIZABETH", "SUSAN", "MARGARETH",
            "DOROTHY", "LISA", "NANCY", "DONNA", "MICHELLE"
        };

        int index = rand.nextInt(humanNames.length);

        String name = humanNames[index];
        String numb = Integer.toString(rand.nextInt(1000000));

        return (name + "-" + numb);
    }

    private int generateValidPort()
    {
        int port = 0;
        while(port < MIN_PORT_NUMBER)
        {
            port = rand.nextInt((MAX_PORT_NUMBER - MIN_PORT_NUMBER) + 1) - MIN_PORT_NUMBER;
        }

        return port;
    }

    public String getName()
    {
        return name;
    }

    public int getPort()
    {
        return port;
    }

    public void listen() throws IOException
    {
        try(ServerSocket socket = new ServerSocket(port))
        {
            Runtime.getRuntime().addShutdownHook(
                    new Thread()
                    {
                       @Override
                       public void run()
                       {
                           System.out.print("\n");
                           Logger.warning("SIGINT caught.");
                           Logger.info("Exiting...");

                           return;
                       }
                    });

            while(true)
            {
                Socket client = socket.accept();
                new Thread(new Connection(client, this)).start();
            }
        }
    }
}
