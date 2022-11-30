import java.sql.Connection;

public abstract class Form {
    public abstract void exibe(boolean isUpdate);   
    
    public Connection connectDB(){
        return (new ConexaoDAO()).conectaBD();
    }
}
