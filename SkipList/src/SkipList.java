//Java ���ݶ���ĳ�ʼ��
//����Ľṹ
public class SkipList {
	private int level;
	nodeStructure head;
	int debug;
	
	//SkipList�ĳ�ʼ��,����head
	public SkipList(int level){
		this.level = level;
		head = new nodeStructure(0,0);
		
	}
	
	public boolean query(int key){
		int k = level;
		nodeStructure p , q;
		p=head;
		
		do{
			q=p.forward[k];
			while(q!=null && q.key < key){
				p=q;
				q=p.forward[k];
				
			}
			
			if(q!=null && q.key == key){
				System.out.println("�ڵ�"+k+"����ҵ���ֵ");
				return true;
			}
		}while( --k >= 0);
		
		return false;
	}
	public void insert(int key,int value){
		nodeStructure[] update = new nodeStructure[12];
		nodeStructure p , q;
		int k;
		p = head;
		k = level;
		
		do{
			q=p.forward[k];
			while(q!=null && q.key < key){
				p=q;
				q=p.forward[k];
				
			}
			update[k] = p;
			
		}while( --k >= 0);  //�����ȷ��������ʧ��֮�󣬼�������Ѱ��
		
		/*if(q.key == key){
			q.value = value;
		}*/
		
		k = randomLevel();
		debug = k;
		System.out.println(k);
		//�����ɵ�����Ĳ�������������ܲ���,������ʱ������k����level�����
		if( k > level ){
			
		}
		//��ʼ��q
		q= new nodeStructure(0,0);
		for(int i=0;i<head.getMaxLevel();i++)
			q.forward[i] = new nodeStructure(0,0);
		q.key=key;
		q.value=value;
		
		//����ָ����
		do{
			p = update[k];
			q.forward[k] = p.forward[k];
			p.forward[k] = q;
		}while(--k >=0);
	}
	//�������0-10֮�������һ����
	public int randomLevel(){
		return (int)(Math.random()*10 ) + 1;
	}
	
	public static  void main(String[] args){
		SkipList sl = new SkipList(11);
		//System.out.println(sl.head.forward[0].key); //head is create!
		sl.insert(3, 4);
		for(int i=0;i<sl.debug;i++){
			System.out.println(sl.head.forward[i].key);
		}
		sl.insert(6, 7);
		for(int i=0;i<sl.debug;i++){
			System.out.println(sl.head.forward[i].key);
		}
		sl.insert(8, 10);
		for(int i=0;i<sl.debug;i++){
			System.out.println(sl.head.forward[i].key);
		}
		
		
		System.out.println("---------------------------------");
		sl.query(6);
		
	}

}
