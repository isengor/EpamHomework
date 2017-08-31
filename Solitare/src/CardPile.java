import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

 class CardPile {

	// coordinates of the card pile
	protected int x;
	protected int y;
	protected int cardscount;
	private Card firstCard;

	CardPile(){
	firstCard = null;
	}


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
		cardscount++;
		aCard.link = firstCard;
		firstCard = aCard;
	}

	public Card pop() {
		Card result = null;
		if (firstCard != null) {
			result = firstCard;
			firstCard = firstCard.link;
			cardscount--;
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

	public void display(final Graphics g) {
		g.setColor(Color.black);
		if (firstCard == null) {
			g.drawRect(x, y, Card.width, Card.height);
		} else {
			firstCard.draw(g, x, y,Color.BLACK);
		}
	}

	public boolean canTake(final Card aCard){
		return false;
	}

	public int getPileBottom(){
		return 0;
	}

	public void select(MouseEvent mouseEvent){
		//do nothing
	}

}