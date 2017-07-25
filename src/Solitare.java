import java.applet.Applet;
import java.awt.Event;
import java.awt.Graphics;

public class Solitare extends Applet {

    /*
    - дать возможность указывать место, куда класть карту
- дать возможность выбирать не одну карту,
  а несколько: выбрать карту и все на ней лежащие
- по двойному клику перемещать в стопки с мастями (optional)
- автоматически переворачитвать верхнюю карту рубашкой вниз в TablePile
- когда колода DeckPile заканчивается, клик на пустой рамке на ней
  должен перенести все карты из DiscardPile обратно в неё (в DeckPile).
  не забыть перевернуть все перемещённые карты рубашкой вверх
     */

	static DeckPile deckPile;
	static DiscardPile discardPile;
	static TablePile tablePile[];
	static SuitPile suitPile[];
	static CardPile allPiles[];

	@Override
	public void init() {
		// first allocate the arrays
		allPiles = new CardPile[13];
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
	}

	@Override
	public void paint(Graphics g) {
		for (int i = 0; i < 13; i++) {
			allPiles[i].display(g);
		}
	}

	@Override
	public boolean mouseDown(Event evt, int x, int y) {
		for (int i = 0; i < 13; i++) {
			if (allPiles[i].includes(x, y)) {
				allPiles[i].select(x, y);
				repaint();
				return true;
			}
		}
		return true;
	}


}
