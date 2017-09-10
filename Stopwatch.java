package ep;

public class Stopwatch {
    
    private static long inicio;
    private static long fim;
    
    public static void start(){
        inicio = System.currentTimeMillis();
    }
    
    public static void stop(){
        fim = System.currentTimeMillis();         
    }
    
    public static long elapsedTimeMillis() {
        return (fim-inicio);
    }
    
    public static String Resultado(){
        return("Tempo de execução (ms): "+ Long.toString(elapsedTimeMillis()));
    }
   
    
}
