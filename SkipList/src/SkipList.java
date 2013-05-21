//Java 数据对象的初始化
//跳表的结构
public class SkipList {
	private int level;
	nodeStructure head;
	int debug;
	
	//SkipList的初始化,生成head
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
				System.out.println("在第"+k+"层查找到了值");
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
			
		}while( --k >= 0);  //这里就确保了数组失败之后，继续往下寻找
		
		/*if(q.key == key){
			q.value = value;
		}*/
		
		k = randomLevel();
		debug = k;
		System.out.println(k);
		//新生成的跳表的层数大于跳表的总层数,这里暂时不考虑k大于level的情况
		if( k > level ){
			
		}
		//初始化q
		q= new nodeStructure(0,0);
		for(int i=0;i<head.getMaxLevel();i++)
			q.forward[i] = new nodeStructure(0,0);
		q.key=key;
		q.value=value;
		
		//更新指针域
		do{
			p = update[k];
			q.forward[k] = p.forward[k];
			p.forward[k] = q;
		}while(--k >=0);
	}
	//随机生成0-10之间的任意一个数
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
