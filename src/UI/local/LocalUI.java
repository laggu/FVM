package UI.local;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import Main.CommitTree;
import Main.Status;

public class LocalUI extends JPanel {

	private North northPanel;
	private Center centerPanel;
	private South southPanel;
	private String selectedFileName;
	
	public LocalUI() {
		
		setLayout(new BorderLayout());

		northPanel = new North(this);
		centerPanel = new Center(this);
		southPanel = new South(this);
		
		add(northPanel,BorderLayout.NORTH);
		add(centerPanel,BorderLayout.CENTER);
		add(southPanel,BorderLayout.SOUTH);
	}

	public North getNorthPanel() {
		return northPanel;
	}

	public Center getCenterPanel() {
		return centerPanel;
	}

	public South getSouthPanel() {
		return southPanel;
	}

	public String getSelectedFileName() {
		return selectedFileName;
	}

	public void setSelectedFileName(String selectedFileName) {
		this.selectedFileName = selectedFileName;
		System.out.println(selectedFileName);
	}

	
	public void updateCenterPanel(){
		if(centerPanel == null)
			return;
		remove(centerPanel);
		centerPanel = new Center(this);
		add(centerPanel, BorderLayout.CENTER);
		revalidate();
	}
	
	public void setCenterPanelText()
	{
		Status current = Status.getInstance();
		Status s =CommitTree.getInstance().getParent(current);
		centerPanel.setL1(current.getBranch()+':'+current.getVersion());
		if(s != null && s.getCommitMessage()!=null)
			centerPanel.setMs(s.getCommitMessage());
	}
	
	
	
}
