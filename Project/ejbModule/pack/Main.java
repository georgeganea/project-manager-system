package pack;


import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.speedy.ProgrammerSessionRemote;

import beans.MyBeanRemote;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try { 
//			Hashtable<String,String> env = new Hashtable<String,String>();
//			env.put(Context.INITIAL_CONTEXT_FACTORY,  
//		    "org.jboss.naming.HttpNamingContextFactory");
//			env.put("java.naming.provider.url", "http://localhost:1099");
//			env.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
			InitialContext ctx = new InitialContext(); 
//			NamingEnumeration<Binding> listBindings = ctx.listBindings("/");
//			if (System.getSecurityManager() == null) {
//				System.setSecurityManager(new SecurityManager());
//				} 
//			for (String string : args) {
//				System.out.println(">>>> bin"+string);
//			}
			ProgrammerSessionRemote  bean = ( ProgrammerSessionRemote) ctx.lookup("programmerSession"); 
			bean.doSmth();
		} catch (NamingException e) { 
			e.printStackTrace(); 
		} 

	}

}
