package xmlrpc;

import java.net.InetAddress;

import org.apache.xmlrpc.server.*;
import org.apache.xmlrpc.webserver.WebServer;

public class HelloServer
{
    public WebServer    web_server;

    public HelloServer()
    {
        try
        {
            this.web_server = new WebServer(10080,
                    InetAddress.getByAddress(new byte[] { 0, 0, 0, 0 }));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void initServer()
    {
        XmlRpcServer xmlRpcServer = web_server.getXmlRpcServer();
        PropertyHandlerMapping phm = new PropertyHandlerMapping();
        try
        {
            phm.addHandler("Handler", XmlRpcHandler.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        xmlRpcServer.setHandlerMapping(phm);
        try
        {
            web_server.start();
            System.out.println("The web server has started....");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

   
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        HelloServer mySer = new HelloServer();
        mySer.initServer();
    }

}
