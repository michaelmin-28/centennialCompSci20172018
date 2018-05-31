package note15OOP;

public interface Ford {
	enum ModelNames {
		Focus, Fusion, Mustang, F150
	}
	public boolean onStarTest(Ford.ModelNames model);
}
