package el;

public class Tools {
	
	int mathPoint = 0;
	int physicsPoint = 0;
	int biologyPoint = 0;
	int chemistryPoint = 0;
	int artPoint  = 0;
	int computerPoint = 0;
	int time = 2;
	int money = 10;
	int emvDamage = 0;
	boolean isClicked = false;
	boolean upDate = false;
	
	private Tools(int math,int physics,int biology,int chemistry,int art,int computer,int t,int m){
		int n = 0;
		int i = 0;
		double k = 0;
		mathPoint = math;
		physicsPoint = physics;
		biologyPoint = biology;
		chemistryPoint = chemistry;
		artPoint = art;
		computerPoint = computer;
		time = t;
		money = m;
		
		n = m/25;
		for(i=0;i<=(n-1);i++){
			k = k + 0.001;
		}
		emvDamage = (int) (0.045*(0.09*physics + 0.0675*biology + 0.09*chemistry + 0.045*computer - k));
	}

	public void judgeC(Tools tool){
		if(tool.isClicked==true)
			ToolFunction.add(tool);
	}
	
	public void judgeU(Tools tool){
		if(tool.upDate==true)
			tool.emvDamage=0;
	}

	public static Tools computer = new Tools(0,0,1,4,4,2,1,15);
	public static Tools media = new Tools(0,0,1,4,4,2,1,20);
	public static Tools hitectool = new Tools(0,0,4,3,3,2,1,17);
	public static Tools plastic = new Tools(5,4,1,4,3,1,1,20);
	public static Tools ai = new Tools(0,0,6,7,7,3,2,30);
	public static Tools nuclear = new Tools(4,0,7,7,6,2,2,35);
	public static Tools medicine = new Tools(5,7,2,4,4,2,2,40);
	public static Tools supercreature = new Tools(9,7,9,11,10,4,3,70);
	public static Tools spaceship = new Tools(4,0,13,14,13,5,3,65);
	public static Tools mixcreature = new Tools(5,7,8,11,11,5,3,75);
	
}
