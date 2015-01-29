package xmlrpc;

public class JarInvoker {
	private static JarInvoker instance;

	public static JarInvoker getInstance() {
		synchronized (JarInvoker.class) {
			if (instance == null) {
				instance = new JarInvoker();
			}
		}
		return instance;
	}

	private JarInvoker() {
		// Init the jar package here
	}
	
	public String execute(String message) {
		// Jar send message here
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The message has sent: " + message);
		String result = "Success";
		
		return result;
	}

}
