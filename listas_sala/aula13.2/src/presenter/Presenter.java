package presenter;

import model.Automat;
import model.Automat.Cell;

public class Presenter {
	
	IBoardView view;
	Automat currentAutomat;
	
	public Presenter(IBoardView view, Automat automat) {
		this.view = view;
		currentAutomat = automat;
	}

	public void nextClicked() {
		currentAutomat = currentAutomat.nextState();
		updateView();
	}
	
	public void changeAutomatCellState(int xCell,int yCell,int state) {
		currentAutomat.changeCellState(xCell,yCell,state);
	}

	private void updateView() {
		view.resizeBoardSizeInCellsTo(currentAutomat.width(), currentAutomat.height());
		for(Cell c : currentAutomat) {
			view.changeCell(c.x,c.y,c.state);
		}
	}

}
