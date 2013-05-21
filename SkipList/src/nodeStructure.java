
//跳表节点
public class nodeStructure {
	private static final int MAXLEVEL = 12;
	int key;
	int value;
	//Java数组的初始话，先创建数组，然后再对数组的每一个元素进行创建
	nodeStructure[]  forward;
	
	public nodeStructure(int key,int value){
		this.key=key;
		this.value=value;
		forward = new nodeStructure[MAXLEVEL];
		for(int i=0;i<MAXLEVEL;i++)
			forward[i] = null;
	}
	
	public int getMaxLevel(){
		return MAXLEVEL;
	}
}
