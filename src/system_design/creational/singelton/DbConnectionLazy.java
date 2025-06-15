package system_design.creational.singelton;

//Singelton: It is used when we required only one object from class
//Lazy Initialization: When objects are required then it is created
//It may create multiple instances when multiple thread access class simultaneously
public class DbConnectionLazy {
	private static DbConnectionLazy dbConnection = null;

	private DbConnectionLazy() {	
	}
	public static DbConnectionLazy getInstance() {
		if(dbConnection==null) {
			dbConnection = new DbConnectionLazy();
		}
			
		return dbConnection;
	}

}
