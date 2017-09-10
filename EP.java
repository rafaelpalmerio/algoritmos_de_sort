package ep;
/*
 * @author Rafael
 */
import java.util.Arrays;
import java.util.Random;

public class EP {
    
    public static void main (String[] args) {
        Executar(10000, false, 30);
        
    }
    public static void Executar (int l, boolean EnablePrint, int n) {
        java.util.Random rng = new java.util.Random(); 
        for(int b = 1; b<=n;b++){            
            int a[] = new int[l];
            for(int i = 0; i<l; i++)      
                a[i] = i+1;
            shuffle(a,rng);
            int a2[] = new int[a.length];  
            int a3[] = new int[a.length];
            int a4[] = new int[a.length];
            int a5[] = new int[a.length];
            int a6[] = new int[a.length];
            System.arraycopy(a, 0, a2, 0, a.length); //fazer cópias de a
            System.arraycopy(a, 0, a3, 0, a.length);
            System.arraycopy(a, 0, a4, 0, a.length);
            System.arraycopy(a, 0, a5, 0, a.length);
            System.arraycopy(a, 0, a6, 0, a.length);            
            if (EnablePrint){                
                System.out.print(b+ ". Vetor original: ");
                for(int v : a) 
                    System.out.print(java.lang.Integer.toString(v)+" ");            
                System.out.println();
            }      
            
            Inserção.insercao(a, n, b, EnablePrint);
            Inserção.insercaoContador(a2, n, b, EnablePrint);
            Seleção.selecao(a3, n, b, EnablePrint);
            Seleção.selecaoContador(a4, n, b, EnablePrint);
            Mergesort.mergesort(a5, n, b, EnablePrint);            
            Mergesort.mergesortContador(a6, n, b, EnablePrint);
            if(EnablePrint){
                System.out.print(b+". Vetor ordenado: ");
                for(int v : a) 
                    System.out.print(java.lang.Integer.toString(v)+" ");            
                System.out.println();
            }
            
        }
        
}    
    
    public static void shuffle(int a[], java.util.Random rng) {
        for(int i=a.length-1;i>0;i--) {
            int pos = rng.nextInt(i+1); // Gera de 0 a i
            int temp = a[i];
            a[i] = a[pos];
            a[pos] = temp;
        }    
    }  
   
}