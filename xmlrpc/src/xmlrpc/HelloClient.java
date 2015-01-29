package xmlrpc;


import java.net.URL;

import org.apache.xmlrpc.client.*;

public class HelloClient
{
    public void invoke(String name)
    {
        String result = "";
        XmlRpcClient client = new XmlRpcClient();
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        try
        {
            config.setServerURL(new URL("http://localhost:10080"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        client.setConfig(config);
        try
        {
            result = (String) client.execute("Handler.doRun",
                    new Object[] {name});
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Handler.doRun return is: " + result);
    }

   
    public static void main(String[] args)
    {

    	
    	for (int i = 0; i < 100; i++ ) {
            HelloClient client = new HelloClient();
            client.invoke("You are hero !!!");
    	}
    }

}