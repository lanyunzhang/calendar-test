
//����ڵ�
public class nodeStructure {
	private static final int MAXLEVEL = 12;
	int key;
	int value;
	//Java����ĳ�ʼ�����ȴ������飬Ȼ���ٶ������ÿһ��Ԫ�ؽ��д���
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
