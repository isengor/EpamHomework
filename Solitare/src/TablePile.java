import java.awt.*;
import java.awt.event.MouseEvent;

class TablePile extends CardPile {

	int c;  // start cards count

	TablePile(int x, int y, int c) {
		// initialize the parent class
		super(x, y);
		// then initialize our pile of cards

		this.c = c;

		for (int i = 0; i < c; i++) {
			push(Solitare.deckPile.pop());
		}
		// flip topmost card face up
		top().flip();

	}


	@Override
	public boolean canTake(Card aCard) {
		if (empty()) {
			return aCard.getRank() == 12;
		}
		Card topCard = top();
		return (aCard.getColor() != topCard.getColor())
				&& (aCard.getRank() == topCard.getRank() - 1);
	}

	@Override
	public int getPileBottom() {
		int bottom = y;
		if (cardscount==0){
			bottom+=35;
		}
		if(cardscount==1){
			bottom+=Card.height;
		}
		else if(cardscount>1){
			bottom += (cardscount-1)*35+Card.height;
		}
		return bottom;
	}

	@Override
	public boolean includes(MouseEvent mouseEvent) {

		int tx = mouseEvent.getX();
		int ty = mouseEvent.getY();

		return tx >= x && tx <= x + Card.width && ty >= y && ty <= getPileBottom(); //
	}

	@Override
	public void select(MouseEvent mouseEvent) {
		System.out.println("table pile " + c + " bottom " + getPileBottom());

		if (empty() && Solitare.selectedTableCards.empty()) {
			return;
		}

			int selectedcardscount = cardscount - getClikedCardNumber(mouseEvent); //count chosen cards

			if (Solitare.selectedTableCards.empty()) {    //if

				for (int i = 0; i < selectedcardscount + 1; i++) {
					if (top().isFaceUp()) {
						Solitare.selectedTableCards.push(pop(), x, y, c - 1);
					}
				}
			}

			else {

				if (this.canTake(Solitare.selectedTableCards.last())) {
					//pushing all the cards from the selectedcardpile
					while (!Solitare.selectedTableCards.empty()) {
						push(Solitare.selectedTableCards.pop());
					}

					if (!Solitare.tablePile[Solitare.selectedTableCards.supplierPileNumb].empty()) {
						//flipping topcard of the supplier pile if it's not empty
						if (!Solitare.tablePile[Solitare.selectedTableCards.supplierPileNumb].top().isFaceUp())
							Solitare.tablePile[Solitare.selectedTableCards.supplierPileNumb].top().flip();
					}
				}
			}
	}

	public int getClikedCardNumber(MouseEvent mouseEvent){
		int cardNumb = 0;
		int localY = y;

		for(int i = 1;i<=cardscount;i++){
			if(mouseEvent.getX() >= x && mouseEvent.getX() <= x+Card.width &&
					mouseEvent.getY() >= localY && mouseEvent.getY() <= localY+35){
				cardNumb = i;
				break;
			}

			if(i==cardscount){   //top card clickable area x2 higher
				if(mouseEvent.getX() >= x && mouseEvent.getX() <= x+Card.width &&
						mouseEvent.getY() >= localY && mouseEvent.getY() <= localY+Card.height){
					cardNumb = i;
					break;
				}
			}
			localY+=35;
		}

		return cardNumb;
	}

	private int stackDisplay(Graphics g, Card aCard) {
		int localy;

		if (aCard == null) {
			return y;
		}
		localy = stackDisplay(g, aCard.link);
		aCard.draw(g, x, localy,Color.BLACK);
		return localy + 35;
	}

	@Override
	public void display(Graphics g) {
		stackDisplay(g, top());
	}

}