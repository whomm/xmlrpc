package xmlrpc;

public class XmlRpcHandler {
	public static volatile int id = 0;
	public XmlRpcHandler() {
		id ++;
		System.out.println("I am handler:" + id);
	}
	public String doRun(String message) {
		JarInvoker invoker = JarInvoker.getInstance();
		String result = invoker.execute(message);
		return result;
	}
}