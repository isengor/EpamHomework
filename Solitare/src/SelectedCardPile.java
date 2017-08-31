import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class SelectedCardPile extends CardPile{

    //BUFFER CARD PILE

   int supplierPileNumb;
   private Deque<Card> selectedCards;

    SelectedCardPile() {
     selectedCards  = new ArrayDeque<>(12);
    }

    @Override
    public boolean includes(MouseEvent mouseEvent) {
        System.out.println(getPileBottom());
        int tx = mouseEvent.getX();
        int ty = mouseEvent.getY();

        return tx >= x && tx <= x + Card.width && ty >= y && ty <= getPileBottom(); //
    }

    @Override
    public void select(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount()==2){
            for (int i = 0; i < 4; i++) {
                if (Solitare.suitPile[i].canTake(Solitare.selectedTableCards.top())) {
                    if(top().link!=null){
                        top().link.flip();
                    }
                    Solitare.suitPile[i].push(Solitare.selectedTableCards.pop());
                    return;
                }
            }
        }
    }

    public void push(Card card,int x,int y,int pileNumb){
        this.x = x;
        this.y = y;
        supplierPileNumb = pileNumb; //last used table pile
        selectedCards.addFirst(card);
        cardscount++;
    }

    @Override
    public boolean empty(){
        return selectedCards.isEmpty();
    }

    @Override
    public int getPileBottom() {
        int bottom = y + (Solitare.tablePile[supplierPileNumb].cardscount)*35+Card.height;

        return bottom;
    }

    @Override
    public Card top(){
      return selectedCards.peekLast();   //does not remove element
    }

    public Card last(){
       return selectedCards.peekFirst(); //does not remove element
    }

    public Card pop(){
        cardscount--;
        return selectedCards.pollFirst();
    }

    public void dissolve() {   //in case of missclick pushing all cards back
        while (!Solitare.selectedTableCards.empty()) {
            Solitare.tablePile[supplierPileNumb].push(pop());
        }
    }

    private void stackDisplay(Graphics g,Iterator<Card> iterator){
        int localy = y + (Solitare.tablePile[supplierPileNumb].cardscount)*35;

        while (iterator.hasNext()){
            iterator.next().draw(g,x,localy,Color.CYAN);
            localy += 35;
        }
    }

    @Override
    public void display(Graphics g) {
        stackDisplay(g, selectedCards.iterator());
    }
}
