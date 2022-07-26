package moraes.lima.anderson.uno.morintegracaocomjava.utils_app;

public class UtilsApp {
    private static final String TAG = "UtilsApp";
    private static moraes.lima.anderson.uno.morintegracaocomjava.utils_app.DataBaseCrudOperations dataBaseCrudOperations;

    public enum DataBaseCrudOperations{
        CREATE,
        READ,
        UPDATE,
        DELETE,
    }
}
