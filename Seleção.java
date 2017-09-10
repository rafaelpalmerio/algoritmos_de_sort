package ep;

public class Seleção {
    
    static float ComparaçõesTotalSeleção = 0;
    static float TrocasTotalSeleção = 0;
    static float tempototalSeleção = 0;
    
    public static void selecao(int x[], int repeticoes, int etapa, boolean EnablePrint) {        
        Stopwatch.start();
        for(int i=0; i<x.length; i++){
            int min = x[i];
            int troca = i;
            
            for(int j=i+1; j<x.length; j++) {
                if(x[j]<min) {
                    min = x[j];
                    troca = j;
                }
            }
        int temp = x[i];
        x[i] = min;
        x[troca] = temp;
                
        }
        Stopwatch.stop();
        if(EnablePrint){        
            System.out.println(Stopwatch.Resultado());
        }
        tempototalSeleção += Stopwatch.elapsedTimeMillis();
    if (etapa==repeticoes){
        System.out.println("Tempo médio de execução da Seleção, para N =  "+x.length+": "+tempototalSeleção/repeticoes);
        tempototalSeleção = 0;
        }   
    }
     
     public static void selecaoContador (int[] x, int repeticoes, int etapa, boolean EnablePrint) {
        int TrocasSeleção = 0;
        int ComparaçõesSeleção = 0;
        for(int i=0; i<x.length; i++){
            int min = x[i];
            int troca = i;
            
            for(int j=i+1; j<x.length; j++) {
                ComparaçõesSeleção++;
                if(x[j]<min) {
                    min = x[j];
                    troca = j;                                                              
                }
            }
        int temp = x[i];
        x[i] = min;
        x[troca] = temp;
        if(troca != i)
            TrocasSeleção++; /*não há troca se o elemento já está no lugar certo*/
                
        }
    if(EnablePrint){
        System.out.println("Trocas na Seleção: "+TrocasSeleção);
        System.out.println("Comparações na Seleção: "+ComparaçõesSeleção);
    }
    TrocasTotalSeleção += TrocasSeleção;
    ComparaçõesTotalSeleção += ComparaçõesSeleção;    
    if (etapa==repeticoes){
        System.out.println("Número médio de Trocas na Seleção, para N =  "+x.length+": "+TrocasTotalSeleção/repeticoes);
        System.out.println("Número médio de Comparações na Seleção, para N =  "+x.length+": "+ComparaçõesTotalSeleção/repeticoes);
        TrocasTotalSeleção = 0;
        ComparaçõesTotalSeleção = 0;
        }
    }
    
}
