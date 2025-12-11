package text;

public abstract class TextDecorator implements Text {

	protected Text text;

	public TextDecorator(Text text) {
		this.text = text;
	}

	public String getText(String text) {
		return text;
	}
}
