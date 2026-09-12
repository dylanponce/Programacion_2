package practica_0_acumuladores;

//CONSEJOS
/*Acumuladores Booleanos:
 * En caso de que todos los casos se cumplan, su acumulador es:
 * ret = true;
 * En caso de que quiero que algunos elementos cumplan:
 * ret = false;
 * 
 * Por otro lado dependiendo del enunciado, podemos decir que si dicen:
 * "algunos", "o" podemos dar por hecho que estamos en OR (||)
 * "todos", "y" podemos dar por hecho que estamos en AND (&&)
 * 
 * Hay casos donde debemos verificar si una matriz o arreglo tiene o no elementos
 * Partimos con un detalle, una arreglo puede tambien no estar creado.
 * 
 * Si el arreglo no esta creado se verifica con arreglo=null
 * Si el arreglo se creo, pero no tiene elementos se verifica con arreglo.length==0;
 * 
 */

public class Practica_0 {
	
	//Ejercicio 1
	public static boolean mayor10(int [] lista) {
		boolean mayor = true;
		for (int i = 0; i<lista.length;i++) {
			mayor = mayor && (lista[i]>10);
		}
		return mayor;
	}
	
	//Ejercicio 2
	public static boolean multiplo5algunoMayor100(int [] lista) {
		if (lista.length==0 || lista==null) {
			return false;
		}
		boolean algunoMayor100 = false;
		boolean multiploDe5 = true;
		for (int m = 0; m<lista.length; m++) {
			multiploDe5=multiploDe5 && (lista[m]%5==0);
			algunoMayor100=algunoMayor100 || (lista[m]>100);
		}
		return algunoMayor100 && multiploDe5;
	}
	
	//Ejercicio 3
	public static boolean pertenecenTodos(int[] elems, int[] arreglo) {
		if (arreglo==null || elems==null || arreglo.length==0) {return false;}
		if (elems.length==0) {return true;}
		boolean pertenece = true;
		for(int p = 0; p<elems.length;p++) {
			pertenece=pertenece && esta(elems[p], arreglo); 
		}
		return pertenece;
	}
	public static boolean esta(int numero, int[]arreglo) {
		boolean estaEnArreglo=false;
		for (int i=0;i<arreglo.length;i++) {
			estaEnArreglo=estaEnArreglo||(numero==arreglo[i]);
		}
		return estaEnArreglo;
	}
	
	//Ejercicio 4
	public static void mostrarPorFila(int[][]matriz) {
		for(int fila = 0; fila<matriz.length;fila++) {
			for(int colum = 0; colum<matriz[fila].length;colum++) {
				System.out.print(matriz[fila][colum] + " ");
			}
			System.out.println();
		}
	}
	public static void mostrarPorColumna(int[][]matriz) {
		for(int colum = 0; colum<matriz[0].length;colum++) {
			for(int fila = 0; fila<matriz.length;fila++) {
				System.out.print(matriz[fila][colum] + " ");
			}
			System.out.println();
		}
	}
	public static int sumarMatriz(int[][]matriz) {
		int suma=0;
		for (int f = 0; f<matriz.length; f++) {
			for (int c = 0; c<matriz[f].length; c++) {
				suma=suma+matriz[f][c];
			}
		}
		return suma;
	}
	//...
	
	//Ejercicio 6
	public static boolean tieneNegativos(int[][] mat){
		boolean tieneNegativos = true;
		for (int f = 0; f<mat.length; f++) {
			tieneNegativos=tieneNegativos && contieneNegativo(mat[f]);
		}
		return tieneNegativos;
	}
	public static boolean contieneNegativo(int [] array) {
		boolean contienNegativo = false;
		for (int c = 0; c<array.length; c++) {
			contienNegativo=contienNegativo || (array[c]<0);
		}
		return contienNegativo;
	}
	
	//Ejercicio 7
	public static boolean filasCrecientesParImpar(int[][] mat) {
		if(mat==null || mat.length==0) {return false;}
		boolean filCrece = filasCrecientes(mat);
		boolean parImpar = ParImpar(mat);
		return filCrece && parImpar;
	}
	
	public static boolean filasCrecientes(int[][] mat) {
		boolean crece = true;
		for (int f = 0;f <mat.length && crece; f++) {
			for (int c = 0;c <mat[f].length-1 && crece; c++) {
				crece=crece && mat[f][c]<mat[f][c+1];
			}
		}
		return crece;
	}
	
	public static boolean ParImpar(int [][] mat) {
		boolean todaValida = true;
		for(int c = 0;c<mat[0].length; c++) {
			boolean esPar = false;
			boolean esImpar = false;
			for (int f = 0;f<mat.length; f++) {
				esPar=esPar || (mat[f][c] % 2==0);
				esImpar=esImpar || (mat[f][c] % 2!=0);
			}
			todaValida=todaValida && (esPar&&esImpar);
		}
		return todaValida;
	}
	
	

	public static void main(String[] args) {
		//Ejercicio 1
		int [] lista = {11,23,12,15};
		int [] lista2 = {1,23,12,15};
		//System.out.println(mayor10(lista));
		//System.out.println(mayor10(lista2));
		
		//Ejercicio 2
		int [] lista3 = {10,20,105,50};
		//System.out.println(multiplo5algunoMayor100(lista3));
		
		//Ejercicio 3
		int [] lista4 = {11,23};
		//System.out.println(pertenecenTodos(lista4, lista));
	
		//Ejercicio 4
		int [][] matriz = {{1,23,12,15},{11,3,42,85}};
		//mostrarPorFila(matriz);
		//mostrarPorColumna(matriz);
		//System.out.println(sumarMatriz(matriz));
		
		//..
		//Ejercicio 6
		int [][] matriz2 = {{1,-1,12,15},{11,3,-2,85}};
		//System.out.println(tieneNegativos(matriz2));
		
		//Ejercicio 7
		int [][] matriz3 = {{1,2,3,4},{5,6,7,8}};
		System.out.println(filasCrecientes(matriz3));
	}

}
