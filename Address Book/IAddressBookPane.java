import java.io.RandomAccessFile;

public interface IAddressBookPane {
	void addButtons(CommandButton jbtUndo, CommandButton jbtRedo);

	AddressBookPane getPane();

	RandomAccessFile getRaf();
}
