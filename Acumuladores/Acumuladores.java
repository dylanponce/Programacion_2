package acumuladores;

public class Acumuladores {

	/**
	 * Dada una matriz de enteros y un número, verifica si existe alguna fila 
	 * donde todos sus elementos sean múltiplos del número recibido por 
	 * parámetro.
	 * 
	 * Si la matriz está vacía o si el número no es positivo, devuelve falso.
	 * 
	 * @param mat
	 * @param num
	 * @return
	*/
	
	//Ejercicio 1
	public boolean todosMultiplosEnAlgunaFila(int[][] mat, int num) {
		if (mat == null || mat.length == 0 || num <= 0) return false;
		boolean ret = false;
		for (int i = 0; i< mat.length; i++) {
			ret = todosMultiplos(mat[i], num) || ret;
		}
		return ret;
	}
	public boolean todosMultiplos(int[] fila, int num) {
		if (fila.length == 0) return false;
		boolean ret = true;
		for (int j = 0; j<fila.length; j++) {
			ret=(fila[j]%num==0) && ret;
		}
		return ret;
	}
	
	/**
	 * Dado 2 matrices se verifica si hay intersección entre las filas de cada
	 * matriz, fila a fila.
	 * 
	 * Si las matrices tienen distinta cantidad de filas o si alguna matriz 
	 * está vacía, devuelve falso.
	 * 
	 * @param mat1
	 * @param mat2
	 * @return
	*/
	
	//Ejercicio 2
	public boolean hayInterseccionPorFila(int[][] mat1, int[][]mat2) {
		if (mat1 == null || mat1.length == 0) return false;
		if (mat2 == null || mat2.length == 0) return false;
		if (mat1.length!=mat2.length) return false;
		boolean ret = true;
		for (int i = 0; i<mat1.length; i++) {
			ret = hayInterseccion(mat1[i],mat2[i]) && ret;
		}
		return ret;
	}
	public boolean hayInterseccion(int[] fila1, int [] fila2) {
		if (fila1 == null || fila2 == null) return false;
        if (fila1.length == 0 || fila2.length == 0) return false;
		boolean ret = false;
		for (int j = 0; j<fila1.length; j++) {
			for (int h = 0; h<fila2.length; h++) {
				ret = fila1[j]==fila2[h]||ret;
			}
		}
		return ret;
	}
	
	/**
	 * Dada una matriz y el índice de una columna, se verifica si existe alguna
	 * fila cuya suma de todos sus elementos sea mayor estricto que la suma de
	 * todos los elementos de la columna indicada por parámetro.
	 * 
	 * Si el índice de la columna es inválido o la matriz está vacía, devuelve 
	 * falso.
	 * 
	 * @param mat
	 * @param nColum
	 * @return
	*/
	
	//Ejercicio 3
	public boolean algunaFilaSumaMasQueLaColumna(int[][] mat, int nColum) { 
	    if (mat == null || mat.length == 0) return false;
	    if (nColum < 0 || nColum >= mat[0].length) return false;
	    
	    int sumaCol = sumarColumna(mat, nColum);
	    
	    boolean ret = false;
	    for (int i = 0; i < mat.length; i++) {
	        int sumaFila = 0;
	        for (int j = 0; j < mat[i].length; j++) {
	            sumaFila = sumaFila + mat[i][j];
	        }
	        ret = (sumaFila > sumaCol) || ret;
	    }
	    return ret;
	}
	public int sumarColumna (int[][] mat, int nColum) {
		int sumaColumna = 0;
		for (int h = 0; h < mat.length; h++) {
	        sumaColumna = sumaColumna + mat[h][nColum];
	    }
		return sumaColumna;
	}
	
	/**
	 * Dadas 2 matrices, se verifica si hay intersección entre las columnas de
	 * cada matriz, columna a columna.
	 * 
	 * Si las matrices tienen distinta cantidad de columnas o alguna matriz 
	 * está vacía, devuelve falso. 
	 * 
	 * @param mat1
	 * @param mat2
	 * @return
	*/
	
	//Ejercicio 4
	public boolean hayInterseccionPorColumna(int[][] mat1, int[][]mat2) {
		if (mat1 == null || mat1.length == 0) return false;
		if (mat2 == null || mat2.length == 0) return false;
		if (mat1[0].length != mat2[0].length) return false;
		
		boolean ret = true;
		for (int i = 0; i < mat1[0].length; i++) {
	        ret = hayInterseccionColumnas(mat1, mat2, i) && ret;
	    }
	    return ret;
	}
	public boolean hayInterseccionColumnas(int[][] m1, int[][] m2, int c) {
	    boolean existeComun = false;
	    for (int j = 0; j < m1.length; j++) {
	        for (int k = 0; k < m2.length; k++) {
	            existeComun = (m1[j][c] == m2[k][c]) || existeComun;
	        }
	    }
	    return existeComun;
	}
}
