public class Branch extends BaseCommand
{
  private  String branchName;

  public Branch(branchName)
  {
    this.branchName = branchName;
  }

  @Override
	public void execute()
  {
    Status status = Status.getInstance();
    String branch_dir_str = new String(status.getRootPath() + "/.fvm/branch/" + this.branchName);

    File dir = new File(branch_dir_str);
		dir.mkdirs();
    status.setBranch(branchName);
    status.setVersion(1);
	}
}
