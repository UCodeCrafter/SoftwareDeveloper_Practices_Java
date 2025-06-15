package system_design.creational.singelton;
//It will create only one instance when multiple thread trying to get objects
public class DbConnectionSyncronized {
	private static DbConnectionSyncronized dbConnectionSyncronized;
	
	private DbConnectionSyncronized() {
		
	}
	synchronized public static DbConnectionSyncronized getInstance() {
		if(dbConnectionSyncronized==null) {

			dbConnectionSyncronized =  new DbConnectionSyncronized();
		}
		return dbConnectionSyncronized;
	}

}
