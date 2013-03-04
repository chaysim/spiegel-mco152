package spiegel.fire;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FireMouseListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent event) {

		FireView view = (FireView) event.getSource();
		Fountain fountain = new Fountain(event.getX(), view.getHeight()
				- event.getY());
		view.addFountain(fountain);
	}

	@Override
	public void mouseEntered(MouseEvent event) {

	}

	@Override
	public void mouseExited(MouseEvent event) {

	}

	@Override
	public void mousePressed(MouseEvent event) {

	}

	@Override
	public void mouseReleased(MouseEvent event) {

	}

}
