package system_design.creational.singelton;

//Eagert loading: The instance is create before getInstance() method is called
public class DbConnectionEagerLoad {
	private static DbConnectionEagerLoad connectionEagerLoad = new DbConnectionEagerLoad();
	
	private DbConnectionEagerLoad() {
	}
	public static DbConnectionEagerLoad getInstance() {
		return connectionEagerLoad;	
	}
	

}
