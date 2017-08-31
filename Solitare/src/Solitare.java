import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Solitare extends Applet implements MouseListener{

    /*
    - дать возможность указывать место, куда класть карту				@DONE
- дать возможность выбирать не одну карту,								@DONE
  а несколько: выбрать карту и все на ней лежащие
- по двойному клику перемещать в стопки с мастями (optional) 			@DONE
- автоматически переворачитвать верхнюю карту рубашкой вниз в TablePile @DONE
- когда колода DeckPile заканчивается, клик на пустой рамке на ней 		@DONE
  должен перенести все карты из DiscardPile обратно в неё (в DeckPile).
  не забыть перевернуть все перемещённые карты рубашкой вверх
     */

	static DeckPile deckPile;
	static DiscardPile discardPile;
	static SelectedCardPile selectedTableCards;
	static TablePile tablePile[];
	static SuitPile suitPile[];
	static CardPile allPiles[];

	@Override
	public void init() {

		addMouseListener(this);

		// first allocate the arrays
		allPiles = new CardPile[14];
		suitPile = new SuitPile[4];
		tablePile = new TablePile[7];
		// then fill them in
		allPiles[0] = deckPile = new DeckPile(335, 5);
		allPiles[1] = discardPile = new DiscardPile(268, 5);
		for (int i = 0; i < 4; i++) {
			allPiles[2 + i] = suitPile[i] = new SuitPile(15 + 60 * i, 5);
		}
		for (int i = 0; i < 7; i++) {
			allPiles[6 + i] = tablePile[i] = new TablePile(5 + 55 * i, 80, i + 1);
		}
		allPiles[13] = selectedTableCards = new SelectedCardPile();
	}

	@Override
	public void paint(Graphics g) {

		for (int i = 0; i < 14; i++) {
			allPiles[i].display(g);
		}
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < 14; i++) {
			if (allPiles[i].includes(e)) {
				allPiles[i].select(e);
				repaint();
				return;
			}
		}
		System.out.println("missclick");
			selectedTableCards.dissolve();
			repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}


}
