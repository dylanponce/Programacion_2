package acumuladores;

public class Ejercicio_Adicional_Acum {
	
	public static boolean diagonalMayor10algunaFilaPar(int [][] mat) {
		if (mat==null||mat.length==0||mat.length!=mat[0].length) {
			return false;
		}
		return sumaDiagonal(mat)>10 && algunaFilaPar(mat);
	}
	
	//Metodo para sumar diagonal
	public static int sumaDiagonal (int [][] mat) {
		int suma = 0;
		for (int s = 0;s<mat.length;s++) {
			suma = suma + mat[s][s];
		}
		return suma;
	}
	
	public static boolean algunaFilaPar(int [][] mat) {
		boolean ret = false;
		for (int f = 0; f<mat.length;f++ ) {
			ret = ret || filaPar(mat[f]);
		}
		return ret;
	}
	
	public static boolean filaPar(int [] mat2) {
		boolean ret = true;
		for (int c = 0; c<mat2.length;c++) {
			ret = ret && (mat2[c]%2==0);
		}
		return ret;
	}
	

	public static void main(String[] args) {
		int [][] a = 	{};
		System.out.println(diagonalMayor10algunaFilaPar(a));

	}

}
