
public class AddressBookPaneWithButtons extends AddressBookPaneDecorator {

	public AddressBookPaneWithButtons(IAddressBookPane pane) {
		super(pane);
		CommandButton jbtUndo = new UndoButton(pane.getPane(), pane.getRaf());
		CommandButton jbtRedo = new RedoButton(pane.getPane(), pane.getRaf());
		addButtons(jbtUndo, jbtRedo);
	}

}
