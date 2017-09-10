package ep;

public class Inserção {
    
    static float TrocasTotalInserção = 0;
    static float ComparaçõesTotalInserção = 0;
    static float tempototalInserção = 0;
    
    public static void insercao(int[] x, int repeticoes, int etapa, boolean EnablePrint) {
        Stopwatch.start();
        for(int i=1; i<x.length; i++) {
            int temp = x[i];
            int j;
            for(j=i; (j>0) && (temp<x[j-1]); j--){
                x[j] = x[j-1];
            }
            x[j] = temp;
            
        }
        Stopwatch.stop();
        if(EnablePrint){
            System.out.println(Stopwatch.Resultado());
        }    
        tempototalInserção += Stopwatch.elapsedTimeMillis();        
    if (etapa==repeticoes){
        System.out.println("Tempo médio de execução da Inserção, para N =  "+x.length+": "+tempototalInserção/repeticoes);
        tempototalInserção = 0;
        }
    }
    
    public static void insercaoContador(int[] x, int repeticoes, int etapa, boolean EnablePrint) {
        int TrocasInserção = 0;        
        int ComparaçõesInserção = 0;
        for(int i=1; i<x.length; i++) {
            int temp = x[i];
            int j;            
            for(j=i; (j>0) && (temp<x[j-1]); j--){                
                ComparaçõesInserção++;
                x[j] = x[j-1];
                TrocasInserção++;                
            }
            if(j!=0)
                ComparaçõesInserção++; /*quando as condições do segundo for não forem
                        satisfeitas,e j>0, o contador não aumenta, mas há comparação*/
             
            x[j] = temp;           
            
        }
        if(EnablePrint){
            System.out.println("Trocas na Inserção: "+TrocasInserção);
            System.out.println("Comparações na Inserção: "+ComparaçõesInserção);
        }
        TrocasTotalInserção += TrocasInserção;
        ComparaçõesTotalInserção += ComparaçõesInserção;
        if (etapa==repeticoes){
            System.out.println("Número médio de Trocas na Inserção, para N =  "+x.length+": "+TrocasTotalInserção/repeticoes);
            System.out.println("Número médio de Comparações na Inserção, para N =  "+x.length+": "+ComparaçõesTotalInserção/repeticoes);
            TrocasTotalInserção = 0;
            ComparaçõesTotalInserção = 0;
        }
    }
    
}
