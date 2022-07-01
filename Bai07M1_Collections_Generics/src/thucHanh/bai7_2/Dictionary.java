package thucHanh.bai7_2;

public class Dictionary implements Comparable<Dictionary> {

	String word;
	String meaning;

	public Dictionary(String word, String meaning) {
		super();
		this.word = word;
		this.meaning = meaning;
	}

	public Dictionary() {
		super();
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	@Override
	public int compareTo(Dictionary o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
