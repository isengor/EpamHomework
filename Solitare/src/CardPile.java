import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

class CardPile {

	// coordinates of the card pile
	protected int x;
	protected int y;
	private Card firstCard;

	CardPile(final int xCoord, final int yCoord) {
		x = xCoord;
		y = yCoord;
		firstCard = null;
	}


	// access to cards are not overridden

	public Card top() {
		return firstCard;
	}

	public boolean empty() {
		return firstCard == null;
	}

	public void push(final Card aCard) {
		aCard.link = firstCard;
		firstCard = aCard;
	}

	public Card pop() {
		Card result = null;
		if (firstCard != null) {
			result = firstCard;
			firstCard = firstCard.link;
		}
		return result;
	}

	// the following are sometimes overridden

	public boolean includes(MouseEvent mouseEvent) {
			int clickX = mouseEvent.getX();
			int clickY = mouseEvent.getY();
		return x <= clickX && clickX <= x + Card.width && y <= clickY
				&& clickY <= y + Card.height;
	}

	public void select(MouseEvent mouseEvent) {
		// do nothing
	}


	public void display(final Graphics g) {
		g.setColor(Color.black);
		if (firstCard == null) {
			g.drawRect(x, y, Card.width, Card.height);
		} else {
			firstCard.draw(g, x, y);
		}
	}

	public boolean canTake(final Card aCard) {
		return false;
	}

}