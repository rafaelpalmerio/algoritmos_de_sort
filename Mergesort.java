package ep;

public class Mergesort {
    
    static float tempototalMerge = 0;
    
    public static void mergesort(int[] x, int repeticoes, int etapa, boolean EnablePrint) {
        Stopwatch.start();
        int[] temp = new int[x.length];
        mergesort(x, temp, 0, x.length-1);
        Stopwatch.stop();
        if(EnablePrint){
            System.out.println(Stopwatch.Resultado());
        }
        tempototalMerge += Stopwatch.elapsedTimeMillis();        
    if (etapa==repeticoes){
        System.out.println("Tempo médio de execução do Mergesort, para N =  "+x.length+": "+tempototalMerge/repeticoes);
        tempototalMerge = 0;
        }
    }
    
    public static void mergesort(int[] x, int[] temp, int left, int right) {
        if(left<right){
            int center = (left + right)/2;            
            mergesort(x, temp, left, center);
            mergesort(x, temp, (center+1), right);            
            merge(x, temp, left, center, (center+1), right);
        }
        
    }
    
    public static void merge (int[] x, int[] temp, int leftStart, int leftEnd,
            int rightStart, int rightEnd) {
        int start = leftStart;
        int aux = start;
        while((leftStart<=leftEnd)&& (rightStart<=rightEnd)) {
            if(x[leftStart]<x[rightStart])
                temp[aux++] = x[leftStart++];
            else
                temp[aux++] = x[rightStart++];            
        }
        while (leftStart<=leftEnd)
            temp[aux++] = x[leftStart++];
        while (rightStart<=rightEnd)
            temp[aux++] = x[rightStart++];
        for (int i = start; i<=rightEnd; i++)
            x[i] = temp[i];
                    
        
    }
    
    static int TrocasMerge = 0;
    static int ComparaçõesMerge = 0;
    static float TrocasTotalMerge = 0;
    static float ComparaçõesTotalMerge = 0;
    
    public static void mergesortContador(int[] x, int repeticoes, int etapa, boolean EnablePrint) {        
        int[] temp = new int[x.length];
        mergesortContador(x, temp, 0, x.length-1);
        if(EnablePrint){
            System.out.println("Trocas no Mergesort: "+TrocasMerge);
            System.out.println("Comparações no Mergesort: "+ComparaçõesMerge);
        }
        TrocasTotalMerge += TrocasMerge;
        ComparaçõesTotalMerge += ComparaçõesMerge;
        TrocasMerge = 0;
        ComparaçõesMerge = 0;
        if (etapa==repeticoes){
            System.out.println("Número médio de Trocas no Mergesort, para N =  "+x.length+": "+TrocasTotalMerge/repeticoes);
            System.out.println("Número médio de Comparações no Mergesort, para N =  "+x.length+": "+ComparaçõesTotalMerge/repeticoes);
            TrocasTotalMerge = 0;
            ComparaçõesTotalMerge = 0;
        }
        
    }
    public static void mergesortContador(int[] x, int[] temp, int left, int right) {        
        if(left<right){
            int center = (left + right)/2;            
            mergesortContador(x, temp, left, center);
            mergesortContador(x, temp, (center+1), right);            
            mergeContador(x, temp, left, center, (center+1), right);
        }
        
    }
    
    public static void mergeContador (int[] x, int[] temp, int leftStart, int leftEnd,
            int rightStart, int rightEnd) {        
        int start = leftStart;
        int aux = start;
        while((leftStart<=leftEnd)&& (rightStart<=rightEnd)) {
            ComparaçõesMerge++; /*Conta as comparações do if abaixo*/
            if(x[leftStart]<x[rightStart]) {
                if(aux!=leftStart)
                    TrocasMerge++; /*Conta como troca se a posição do termo 
                            original não for igual à sua posição no temp*/
                temp[aux++] = x[leftStart++];                
            }
            else {
                if(aux!=rightStart)
                    TrocasMerge++; /*Mesma condição já citada acima*/
                temp[aux++] = x[rightStart++];                
            }
                        
        }        
        while (leftStart<=leftEnd){
            if(aux!=leftStart)
                    TrocasMerge++;
            temp[aux++] = x[leftStart++];
        }        
        while (rightStart<=rightEnd){
            if(aux!=rightStart)
                    TrocasMerge++; 
            temp[aux++] = x[rightStart++];
            
        }
        for (int i = start; i<=rightEnd; i++)
            x[i] = temp[i];
                  
        
    }
}
