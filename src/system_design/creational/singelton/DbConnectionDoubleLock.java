package system_design.creational.singelton;


//Double Locking is used in real world programs it is efficient than synchronization
public class DbConnectionDoubleLock {
	private static DbConnectionDoubleLock dbConnectionDoubleLock;
	
	private DbConnectionDoubleLock() {
		
	}
	public static DbConnectionDoubleLock getInstance() {
		if(dbConnectionDoubleLock==null) {
			synchronized(DbConnectionDoubleLock.class) {
				if(dbConnectionDoubleLock==null) {
					dbConnectionDoubleLock = new DbConnectionDoubleLock();
				}
			}
		}
		return dbConnectionDoubleLock;
		
	}

}
