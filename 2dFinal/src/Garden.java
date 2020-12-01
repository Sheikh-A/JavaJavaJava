public class Garden {

	private static final int N = 5;
	private static final int M = 5;
	private int[][] matrix;
	private int carrots;
	private int rabbitX;
	private int rabbitY;

	public Garden() {
		matrix = new int[N][M];
		initialize();
		carrots = 0;
	}

	public int play(int[][] matrix) {

		placeRabbit(matrix);
		while (shouldSleep()) {
			int choice = takeIntegerInput();
			switch (choice) {
			case 8:
				up();
				break;
			case 4:
				left();
				break;
			case 6:
				right();
				break;
			case 2:
				down();
				break;
			default:
				break;
			}
		}

		return getCarrots();

	}

	private boolean shouldSleep() {

		if (rabbitX + 1 != getRows() && matrix[rabbitX + 1][rabbitY] == 0) {
			if (rabbitX - 1 != -1 && matrix[rabbitX - 1][rabbitY] == 0) {
				if (rabbitY + 1 != getColumns() && matrix[rabbitX][rabbitY + 1] == 0) {
					if (rabbitY - 1 != -1 && matrix[rabbitX][rabbitY - 1] == 0) {
						return false;
					}
				}
			}
		}
		return true;

	}

	private void up() {
		if (rabbitX - 1 != -1) {
			rabbitX = rabbitX - 1;
			carrots += matrix[rabbitX][rabbitY];
			matrix[rabbitX][rabbitY] = 0;
		}
	}

	private void down() {
		if (rabbitX + 1 != getRows()) {
			rabbitX = rabbitX + 1;
			carrots += matrix[rabbitX][rabbitY];
			matrix[rabbitX][rabbitY] = 0;
		}
	}

	private void left() {
		if (rabbitY - 1 != -1) {
			rabbitY = rabbitY - 1;
			carrots += matrix[rabbitX][rabbitY];
			matrix[rabbitX][rabbitY] = 0;
		}
	}

	private void right() {
		if (rabbitY + 1 != getColumns()) {
			rabbitY = rabbitY + 1;
			carrots += matrix[rabbitX][rabbitY];
			matrix[rabbitX][rabbitY] = 0;
		}
	}

	private void placeRabbit(int[][] matrix) {

		if (getRows() >= 3 && getColumns() >= 3 && getRows() % 2 != 0 && getColumns() % 2 != 0) {
			rabbitX = getRows() / 2;
			rabbitY = getColumns() / 2;
			matrix[rabbitX][rabbitY] = 0;
		} else {
			int highestRowIndex = -1;
			int highestColumnIndex = -1;
			int highestCarrots = -1;

			highestRowIndex = getRows() / 2;
			highestColumnIndex = getColumns() / 2;
			rabbitX = highestRowIndex;
			rabbitY = highestColumnIndex;

			highestCarrots = matrix[highestRowIndex][highestColumnIndex];

			if (highestColumnIndex - 1 != -1) {
				if (matrix[highestRowIndex][highestColumnIndex - 1] > highestCarrots) {
					rabbitY = highestColumnIndex - 1;
					highestCarrots = matrix[highestRowIndex][highestColumnIndex - 1];
				}
			}
			if (highestRowIndex - 1 != -1 && getRows() % 2 == 0) {
				if (matrix[highestRowIndex - 1][highestColumnIndex] > highestCarrots) {
					rabbitX = highestRowIndex - 1;
					highestCarrots = matrix[highestRowIndex][highestColumnIndex - 1];
				}
			}
			if (highestRowIndex - 1 != -1 && highestColumnIndex != -1) {
				if (matrix[highestRowIndex - 1][highestColumnIndex - 1] > highestCarrots) {
					rabbitX = highestRowIndex - 1;
					rabbitY = highestColumnIndex - 1;
					highestCarrots = matrix[highestRowIndex - 1][highestColumnIndex - 1];
				}
			}

			matrix[rabbitX][rabbitY] = 0;

		}

	}

	private void initialize() {
		int carrots = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				carrots = (int) ((Math.random() * ((9 - 1) + 1)) + 1);
				matrix[i][j] = carrots;
			}
		}
	}

	private void dispayMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	private int getRows() {
		return N;
	}

	private int getColumns() {
		return M;
	}

	public int getCarrots() {
		return carrots;
	}

	private int takeIntegerInput() {

		int number = 0;

		do {
			number = (int) ((Math.random() * ((8 - 2) + 1)) + 2);

		} while (number < 0);

		return number;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public static void main(String[] args) {

		Garden garden = new Garden();
		int eatenCarrots = garden.play(garden.getMatrix());

		System.out.println(eatenCarrots);

	}

}
