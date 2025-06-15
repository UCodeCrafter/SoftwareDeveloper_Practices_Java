package system_design.creational.singelton;


//Singelton: It is used we required only one object of the class
public class MainClass {
	public static void main(String[] args) {
		
//		DbConnection connection = new DbConnection(); it is not visible because of constructor is private
		//LAZY LOAD
		DbConnectionLazy connection1 = DbConnectionLazy.getInstance();	
		DbConnectionLazy connection2 = DbConnectionLazy.getInstance();
		
		System.out.println("Connection1 LAZY: "+ connection1);
		System.out.println("Connection2 LAZY: "+ connection2);
		

		//EAGER LOAD
		DbConnectionEagerLoad connectionEagerLoad1 = DbConnectionEagerLoad.getInstance();
		DbConnectionEagerLoad connectionEagerLoad2 = DbConnectionEagerLoad.getInstance();
		
		System.out.println("connectionEagerLoad EAGER: "+ connectionEagerLoad1);
		System.out.println("connectionEagerLoad EAGER: "+ connectionEagerLoad2);
		
		//SYNCHRONIZED
		DbConnectionSyncronized dbConnectionSyncronized1 = DbConnectionSyncronized.getInstance();
		DbConnectionSyncronized dbConnectionSyncronized2 = DbConnectionSyncronized.getInstance();
		
		System.out.println("dbConnectionSyncronized1 SYNCHRONIZED: "+ dbConnectionSyncronized1);
		System.out.println("dbConnectionSyncronized2 SYNCHRONIZED: "+ dbConnectionSyncronized2);
		
		//Double Locking
		DbConnectionDoubleLock connectionDoubleLock1 = DbConnectionDoubleLock.getInstance();
		DbConnectionDoubleLock connectionDoubleLock2 = DbConnectionDoubleLock.getInstance();
		System.out.println("connectionDoubleLock1 DOUBLE LOCK: "+ connectionDoubleLock1);
		System.out.println("connectionDoubleLock2 DOUBLE LOCK: "+ connectionDoubleLock2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
