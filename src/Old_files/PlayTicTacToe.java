package Old_files;

public class PlayTicTacToe {
	public static void main(String[] args) {
		TicTacToe t= new TicTacToe(3);
		System.out.println(t.move(1,1,1));
		System.out.println(t.move(1,2,2));
		System.out.println(t.move(0,0,1));
		System.out.println(t.move(2,2,2));
		System.out.println(t.move(0,2,1));
		System.out.println(t.move(0,1,2));
		System.out.println(t.move(2,0,1));

	}
}
