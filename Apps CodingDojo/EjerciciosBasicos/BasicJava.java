import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class BasicJava {
        public void sumarNumeros() {
            for ( int i = 1 ; i <=255 ; i++ ){
                System.out.println(i);
            }
        }
        public void sumarImpares(){
            for ( int i = 1 ; i <=255 ; i++ ){ 
                    if (i%2!=0){
                        System.out.println(i);
                    }
                }
            }
        
        public int imprimirSuma() {
            int sum = 0; 
            for (int i = 1 ; i <=255 ; i++ ){
                sum += i ;
                System.out.println("Nuevo numero:" + i + "Suma:" + sum);
            }
            return sum;
        }

        public void imprimirArreglo(){
            int[] array = {1,3,5,7,9,13};
            for(int i = 0 ; i < array.length ; i++ ){
                System.out.println(array[i]);
            }
        }
        public int  findMax() {
            int[] array = {-3,-5,-7};
            int max = array [0];
            for(int i = 0 ; i < array.length ; i++){
                if (array[i] > max){
                    max = array[i];
                }
            }
            System.out.println(max);
            return max; 
        }
        public void obtenerAvg(){
            int[] array = {2,10,3};
            int sum = 0;
            int avg = 0;
            for(int i = 0 ; i < array.length ; i++){
                sum += array[i] ;
                avg = sum/array.length; 
            }
            System.out.println(avg);
        }
            public void arreglo255() {
            ArrayList<Integer> y = new ArrayList<Integer>();
            for ( int i = 1 ; i <=255 ; i++ ){ 
                if (i%2!=0){
                    y.add(i);
                }
            }
            System.out.println(y);
        }
        public void mayorThanY() {
            int[] array = {1,3,5,7};
            int Y = array[1]; 
            int count = 0; 
            for(int i = 0 ; i < array.length ; i++){
                if( Y < array[i]){
                    count +=1 ;
                }
            }
            System.out.println(count);
        }
            public void squareValues() {
            double[] array = {1,5,10,-2};
            ArrayList<Double> newArray = new ArrayList<>();
            for(int i = 0 ; i < array.length ; i++){
                double valorX = Math.pow(array[i], 2);
                newArray.add(valorX);
            }
            System.out.println(newArray);
        }
            public void noNegative(){
                int[] array = {1,5,10,-2};
                for(int i = 0 ; i < array.length ; i++){
                    if(array[i] < 0){
                        array[i] = 0;
                    }
                }
                System.out.println(Arrays.toString(array));
            }
                public void minMaxAvg(){
                ArrayList<Double> arrayChiquito = new ArrayList<>();
                int[] array = {1,5,10,-2};
                double max = array[0];
                double min = array[0];
                double sum = 0;
                for (int i = 0; i < array.length; i++) {
                        if(array[i] > max){
                            max = array[i];
                        }
                        if(array[i] < min){
                            min = array[i];
                        }
                        sum += array[i];
                    }
                    arrayChiquito.add(max);
                    arrayChiquito.add(min);
                    arrayChiquito.add(sum/array.length);
                System.out.println(arrayChiquito);
            }
            public void swapValues(){
                int[] array = {1,5,10,7,-2};
                for (int i = 0; i < array.length-1; i++) {
                    array[i] = array[i+1];
                }
                array[array.length-1] = 0;
                System.out.println(Arrays.toString(array));
            }
   }

