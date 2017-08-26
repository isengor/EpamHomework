import java.awt.*;
import java.awt.event.MouseEvent;

class TablePile extends CardPile {

	TablePile(int x, int y, int c) {
		// initialize the parent class
		super(x, y);
		// then initialize our pile of cards
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
	public boolean includes(MouseEvent mouseEvent) {
		int tx = mouseEvent.getX();
		int ty = mouseEvent.getY();

		// doesn't test bottom of card
		return x <= tx && tx <= x + Card.width && y <= ty;
	}

	@Override
	public void select(MouseEvent mouseEvent) {
		if (empty()) {
			return;
		}

		// if face down, then flip
		Card topCard = top();
		if (!topCard.isFaceUp()) {
			topCard.flip();
			return;
		}



		// else see if any suit pile can take card
		topCard = pop();

		if(mouseEvent.getClickCount()==2) { //double click listener
			System.out.println("double");
			for (int i = 0; i < 4; i++) {
				if (Solitare.suitPile[i].canTake(topCard)) {    //смотрим можем ли мы закинуть карту наверх в suitpile
					if(topCard.link!=null){
						topCard.link.flip();
					}
					Solitare.suitPile[i].push(topCard);            //и есди да, соответственно кидаем её в подходящую колоду

					return;
				}
			}
		}
		//TODO: мы должны сначала выделить карту по которой был клик, а уже затем проверять куда был сделан следующий клик
		//TODO: и только тогда перекидываем карту или же снимаем выделение цветом

		// else see if any other table pile can take card
//		for (int i = 0; i < 7; i++) {
//			if (Solitare.tablePile[i].canTake(topCard)) {
//				topCard.link.flip();
//				Solitare.tablePile[i].push(topCard);				//а здесь мы пробегаемся по колодам на столе, и перекидываем
//											//карту в подходящую колоду
//				return;
//			}
//		}


		// else put it back on our pile
		push(topCard);
	}

	private int stackDisplay(Graphics g, Card aCard) {
		int localy;

		if (aCard == null) {
			return y;
		}
		localy = stackDisplay(g, aCard.link);
		aCard.draw(g, x, localy);
		return localy + 35;
	}

	@Override
	public void display(Graphics g) {
		stackDisplay(g, top());
	}

}