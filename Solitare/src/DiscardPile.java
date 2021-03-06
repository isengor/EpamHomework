import java.awt.event.MouseEvent;

class DiscardPile extends CardPile {

	DiscardPile(int x, int y) {
		super(x, y);
	}

	@Override
	public void push(Card aCard) {
		if (!aCard.isFaceUp()) {
			aCard.flip();
		}
		super.push(aCard);
	}

	@Override
	public void select(MouseEvent mouseEvent) {
		if (empty()) {
			return;
		}
		Card topCard = pop();
		for (int i = 0; i < 4; i++) {
			if (Solitare.suitPile[i].canTake(topCard)) {
				Solitare.suitPile[i].push(topCard);
				return;
			}
		}
		for (int i = 0; i < 7; i++) {
			if (Solitare.tablePile[i].canTake(topCard)) {
				Solitare.tablePile[i].push(topCard);
				return;
			}
		}
		// nobody can use it, put it back on our list
		push(topCard);
	}
}