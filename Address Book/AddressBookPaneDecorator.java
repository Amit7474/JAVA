import java.io.RandomAccessFile;

import javafx.scene.layout.Pane;

public abstract class AddressBookPaneDecorator implements IAddressBookPane {
	private IAddressBookPane iAddressBookPane;

	public AddressBookPaneDecorator(IAddressBookPane iAddressBookPane) {
		this.iAddressBookPane = iAddressBookPane;
	}

	@Override
	public void addButtons(CommandButton jbtUndo, CommandButton jbtRedo) {
		iAddressBookPane.addButtons(jbtUndo, jbtRedo);

	}

	@Override
	public AddressBookPane getPane() {
		return iAddressBookPane.getPane();
	}

	@Override
	public RandomAccessFile getRaf() {
		return iAddressBookPane.getRaf();
	}
	

}
