package ejemplos.tema2;

public class ejercicios
{
    public static int puntoCruce(int[] v, int i, int j){
        int m = (i + j) / 2;
        if(v[m]<=0){
            if(v[m+1]>0){
                return m;
            }
            else{
                return puntoCruce(v,m+1,j);
            }
        }
        else{
            return puntoCruce(v,i,m-1);
        }
    }
    
    public static int puntoCruce(int[] v){
        return puntoCruce(v, 0, v.length - 1);
    }
    
    public static <T extends Comparable <T>> void mergeSort(T[] v){
        mergeSort(v, 0, v.length - 1);
    }
    
    public static <T extends Comparable <T>> void mergeSort(T[] v ,int izq, int der){
        if(izq < der){
            int mitad = (izq + der) / 2;
            mergeSort(v, izq, mitad);
            mergeSort(v, mitad + 1, der);
            mergeDC(v, izq, mitad + 1, der);
        }
    }
    
    public static <T extends Comparable <T>> void mergeDC(T[] v, int i, int m, int j){
        T[] res = (T[]) new Comparable [j-i+1];
        int k = 0;
        int i1 = i;
        int i2 = m;
        while(i1 < m && m <= j){
            if(v[i1].compareTo(v[i2]) < 0){
                res[k++] = v[i1++];
            }
            else{
                res[k++] = v[i2++];
            }
        }
        for(int r = i1; r < m; r++){
            res[k++] = v[r];
        }
        for(int r = i2; r <= j; r++){
            res[k++] = v[r];
        }
        for(int r = 0; r < res.length; r++){
            v[r + i] = res[r];
        }
    }
    
    public static int subsecuenciaMax(int[] v){
        return subsecuenciaMax(v, 0, v.length - 1);
    }
    
    public static int subsecuenciaMax(int[] v , int izq, int der){
        if(izq == der){
            if(v[izq] > 0) return v[izq];
            else return 0;
        }
        int m = (izq + der) / 2;
        int sumaMaxIzq = subsecuenciaMax(v, izq, m);
        int sumaMaxDer = subsecuenciaMax(v, m + 1, der);
        
        int sumaMaxBordeIzq = 0, sumaBordeIzq = 0;
        for (int i = m; i >= izq; i--) {
            sumaBordeIzq += v[i] ;
            if (sumaBordeIzq > sumaMaxBordeIzq) sumaMaxBordeIzq = sumaBordeIzq;
        }
        int sumaMaxBordeDer = 0, sumaBordeDer = 0;
        for (int i = m + 1; i <= der; i++) {
            sumaBordeDer += v[i] ;
            if (sumaBordeDer > sumaMaxBordeDer) sumaMaxBordeDer = sumaBordeDer;
        }
        return Math.max(Math.max(sumaMaxIzq, sumaMaxDer), sumaMaxBordeIzq + sumaMaxBordeDer);
    }
    
    public static int numRepe(int[] v){
        return numRepe(v, 0, v.length - 1);
    }
    public static int numRepe(int[] v, int izq, int der){
        if(izq > der){
            return -1;
        }
        int m = (izq + der) / 2;
        if(v[m] != m + v[0]){
            if(m > 0 && v[m] == v[m-1]){return v[m];}
            
            return numRepe(v,izq,m-1);
        }
        return numRepe(v,m+1,der);
    }
}
