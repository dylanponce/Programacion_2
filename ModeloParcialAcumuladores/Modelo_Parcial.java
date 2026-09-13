package parcial;

public class Modelo_Parcial {
	public static boolean esRaraYDiagonalEsIgualAVector(int[][] mat, int[] vec) {
		if (mat==null || (mat.length==0) || (mat[0].length != mat.length)) {return false;}		
		if (mat.length != vec.length) {return false;}
		return todasLasColumnasMultiploDe5(mat) && AlgunaFilaTodoPar(mat) && diagonalAscendenteIdenticaAVector(mat, vec);
		
		
	}
	//Resuelve Todas las columnas de la matriz tienen algún elemento que es un múltiplo de 5
	public static boolean todasLasColumnasMultiploDe5(int [][] mat) {
		boolean todas = true;
		for (int c = 0; c<mat[0].length;c++) {
			todas = todas && algunoEsMultiploDe5 (mat, c);
		}
		return todas;
	}
	public static boolean algunoEsMultiploDe5(int mat[][],int c) {
		boolean alguno = false;
		for (int f = 0; f<mat.length;f++) {
			alguno = alguno || (mat[f][c]%5==0);
		}
		return alguno;
	}
	//Resuelve  Alguna fila de la matriz tiene todos sus elementos con un valor par.
	public static boolean AlgunaFilaTodoPar(int [][] mat) {
		boolean alguno = false;
		for (int f = 0; f<mat.length;f++) {
			alguno = alguno || todoPar(mat[f]);
		}
		return alguno;
	}
	public static boolean todoPar(int [] arreglo) {
		boolean todos = true;
		for (int c = 0; c<arreglo.length;c++) {
			todos = todos && arreglo[c]%2==0;
		}
		return todos;
	}
	//Resuelve Los elementos de la diagonal ascendente de la matriz son idénticos a los del vector de entrada, en el mismo orden.
	public static boolean diagonalAscendenteIdenticaAVector(int [][] mat, int []vec) {
		boolean todos = true;
		for (int c = 0; c<mat[0].length;c++) {
			todos = todos && (mat[mat.length-c-1][c] == vec[c]);
		}
		return todos;
	}

	public static void main(String[] args) {
		int mat [][] = {{ 1, 2, 3},
						{10, 5, 6},
						{ 2, 8,30}};
		
		int vec [] = {2,5,3};
		
		System.out.println(esRaraYDiagonalEsIgualAVector(mat, vec));
	}
}
