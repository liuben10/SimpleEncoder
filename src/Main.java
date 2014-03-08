import java.util.ArrayList;

public class Main {
	public static void main(String...args) {
		encode("fooo");
		encode("aabbbccfffffoooddddddeee");
		encode("hkklliiooojjjj");
		encode("hhhiiiuullkljklmlkjljiioo");
	}
	
	public static String encode(String a0) {
		boolean writeFlag = true;
		ArrayList<Tuple> tups = new ArrayList<Tuple>();
		for(int i = 0; i < a0.length(); i++) {
			String currchar = a0.substring(i, i+1);
			if (writeFlag) {
				Tuple tup = new Tuple(currchar, 1);
				writeFlag = false;
				tups.add(tup);
			} else {
				Tuple curtup = tups.get(tups.size()-1);
				if (currchar.equals(curtup.character)) {
					curtup.addcount();
				} else {
					tups.add(new Tuple(currchar, 1));
				}
			}
		}
		System.out.println(tups);
		return tups.toString();
	}
}


final class Tuple {
	String character;
	int count;
	Tuple(String character, int count) {
		this.character = character;
		this.count = count;
	}
	
	@Override
	public String toString() {
		return character + count;
	}
	
	void addcount() {
		this.count += 1;
	}
}