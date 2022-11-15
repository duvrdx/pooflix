import java.sql.Connection;

public abstract class Form {
    public abstract void exibe();   
    
    public Connection connectDB(){
        return (new ConexaoDAO()).conectaBD();
    }
}
