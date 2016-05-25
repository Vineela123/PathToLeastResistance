package codechallenge.com.pathtlr;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class PTLRCodeChallenge {

	private static int possiblePattern = 0;
	private static String TempPath;
	private static String FailedPath;
	private static Stack<MatrixObject> ObjectPile;
	private static String succesPath;
	private static boolean isOnlyonepath = false;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter No. of Rows between 1 and 10");
		Preconditions.NO_ROW = sc.nextInt();
		System.out.println("Enter No. of Columns between 5 and 100");
		Preconditions.NO_COLUMN = sc.nextInt();
		if ((Preconditions.NO_ROW >= 1 && Preconditions.NO_ROW <= 10) && (Preconditions.NO_COLUMN >= 5 && Preconditions.NO_COLUMN <= 100)) {
			Preconditions.Matrix = new int[Preconditions.NO_ROW][Preconditions.NO_COLUMN];
			System.out.println("Enter the Matrix with "+Preconditions.NO_ROW+" rows and "+Preconditions.NO_COLUMN +" Columns");
			try {
				for (int i = 0; i < Preconditions.NO_ROW; i++){
					for (int j = 0; j < Preconditions.NO_COLUMN; j++){
						Preconditions.Matrix[i][j] = sc.nextInt();}}
				possiblePattern = Preconditions.Matrix[0][0];
				ObjectPile = new Stack<MatrixObject>();
				TempPath = succesPath = "1";
				PathToResistance(0, 0, succesPath);
				if (isOnlyonepath) {
					System.out.println("Yes, Water made it all the way through the grid \n "+" Total Resistance: "+ Preconditions.totalResistanceT+"\n"+" Path: "+ TempPath);
				} else {
					System.out.println("No \n"+" Total Resistance "+Preconditions.totalResistanceF+" Failed Path: "+FailedPath);
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Matrix input");}
		} else {
			System.out.println("InValid Input");}
		sc.close();
	}

	private static void calcuatedResistancePath(int FirstD, int SecondD, String path) {
		String tempPath;
		if (Preconditions.NO_ROW == 1) {
			if ((possiblePattern + Preconditions.Matrix[FirstD][SecondD + 1] <= Preconditions.MAX_RESISTANCE)
					&& (possiblePattern + Preconditions.Matrix[FirstD][SecondD + 1] < Preconditions.totalResistanceT)) {
				tempPath = path;
				tempPath = path.concat(" " + Integer.toString(FirstD + 1));
		ObjectPile.push(matrixInflate(FirstD, SecondD + 1,
				(possiblePattern + Preconditions.Matrix[FirstD][SecondD + 1]), tempPath));
			}
		}

		if ((Preconditions.NO_ROW > 1) && (SecondD < Preconditions.NO_COLUMN - 1)) {
			if (FirstD == 0) {
				if ((possiblePattern + Preconditions.Matrix[Preconditions.NO_ROW - 1][SecondD + 1] <= Preconditions.MAX_RESISTANCE)
						&& (possiblePattern + Preconditions.Matrix[Preconditions.NO_ROW - 1][SecondD + 1] < Preconditions.totalResistanceT)) {
					tempPath = path;
					tempPath = path.concat(" " + Integer.toString(Preconditions.NO_ROW));
					ObjectPile.push(matrixInflate(Preconditions.NO_ROW - 1, SecondD + 1,
							(possiblePattern + Preconditions.Matrix[Preconditions.NO_ROW - 1][SecondD + 1]), tempPath));
				}
				if ((possiblePattern + Preconditions.Matrix[FirstD + 1][SecondD + 1] <= Preconditions.MAX_RESISTANCE)
						&& (possiblePattern + Preconditions.Matrix[FirstD + 1][SecondD + 1] < Preconditions.totalResistanceT)) {
					tempPath = path;
					tempPath = path.concat(" " + Integer.toString(FirstD + 2));
					ObjectPile.push(matrixInflate(FirstD + 1, SecondD + 1,
							(possiblePattern + Preconditions.Matrix[FirstD + 1][SecondD + 1]), tempPath));
				}
			} else if (FirstD == Preconditions.NO_ROW - 1) {
				if ((possiblePattern + Preconditions.Matrix[0][SecondD + 1] <= Preconditions.MAX_RESISTANCE)
						&& (possiblePattern + Preconditions.Matrix[0][SecondD + 1] < Preconditions.totalResistanceT)) {
					tempPath = path;
					tempPath = path.concat(" " + Integer.toString(1));
					ObjectPile.push(matrixInflate(0, SecondD + 1,
							(possiblePattern + Preconditions.Matrix[0][SecondD + 1]), tempPath));
				}
				if ((possiblePattern + Preconditions.Matrix[FirstD - 1][SecondD + 1] <= Preconditions.MAX_RESISTANCE)
						&& (possiblePattern + Preconditions.Matrix[FirstD - 1][SecondD + 1] < Preconditions.totalResistanceT)) {
					tempPath = path;
					tempPath = path.concat(" " + Integer.toString(FirstD));
					ObjectPile.push(matrixInflate(FirstD - 1, SecondD + 1,
							(possiblePattern + Preconditions.Matrix[FirstD - 1][SecondD + 1]), tempPath));
				}
			} else if (FirstD > 0 & FirstD < Preconditions.NO_ROW - 1) {
				if ((possiblePattern + Preconditions.Matrix[FirstD - 1][SecondD + 1] <= Preconditions.MAX_RESISTANCE)
						&& (possiblePattern + Preconditions.Matrix[FirstD - 1][SecondD + 1] < Preconditions.totalResistanceT)) {
					tempPath = path;
					tempPath = path.concat(" " + Integer.toString(FirstD));
					ObjectPile.push(matrixInflate(FirstD - 1, SecondD + 1,
							(possiblePattern + Preconditions.Matrix[FirstD - 1][SecondD + 1]), tempPath));
				}
				if ((possiblePattern + Preconditions.Matrix[FirstD + 1][SecondD + 1] <= Preconditions.MAX_RESISTANCE)
						&& (possiblePattern + Preconditions.Matrix[FirstD + 1][SecondD + 1] < Preconditions.totalResistanceT)) {
					tempPath = path;
					tempPath = path.concat(" " + Integer.toString(FirstD + 2));
					ObjectPile.push(matrixInflate(FirstD + 11, SecondD + 1,
							(possiblePattern + Preconditions.Matrix[FirstD + 1][SecondD + 1]), tempPath));
				}
			}
			if ((possiblePattern + Preconditions.Matrix[FirstD][SecondD + 1] <= Preconditions.MAX_RESISTANCE)
					&& (possiblePattern + Preconditions.Matrix[FirstD][SecondD + 1] < Preconditions.totalResistanceT)) {
				tempPath = path;
				tempPath = path.concat(" " + Integer.toString(FirstD + 1));
				ObjectPile.push(matrixInflate(FirstD, SecondD + 1,
						(possiblePattern + Preconditions.Matrix[FirstD][SecondD + 1]), tempPath));
			}
		}
	}
	private static MatrixObject matrixInflate( int FDimension, int Sdimension, int CalculatedResistance,String PTLRPath){
		MatrixObject object=new MatrixObject();
		object.setFirst_dimension(FDimension);
		object.setSecond_dimension(Sdimension);
		object.setCalculatedResistance(CalculatedResistance);
		object.setPtlr(PTLRPath);
		return object;
	}
	private static void PathToResistance(int FirstD, int SecondD, String path) {
		calcuatedResistancePath(FirstD, SecondD, path);
		while (!ObjectPile.isEmpty()) {
			MatrixObject cPos = ObjectPile.pop();
			possiblePattern = cPos.getCalculatedResistance();
			Preconditions.totalResistanceF = (Preconditions.totalResistanceF < possiblePattern) ? possiblePattern
					: Preconditions.totalResistanceF;
			succesPath = cPos.getPtlr();
			FailedPath = succesPath;
			if (cPos.getSecond_dimension() < (Preconditions.NO_COLUMN - 1))
				PathToResistance(cPos.getFirst_dimension(), cPos.getSecond_dimension(), FailedPath);
			else {
				if (isOnlyonepath) {
					if (Preconditions.totalResistanceT > possiblePattern) {
						Preconditions.totalResistanceT = possiblePattern;
						TempPath = succesPath;
					}
				} else {
					Preconditions.totalResistanceT = possiblePattern;
					TempPath = succesPath;
					isOnlyonepath = true;
				}
			}
		}
		possiblePattern = 0;
		succesPath = "";
	}
}