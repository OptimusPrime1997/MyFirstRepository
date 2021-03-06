package edu.nju.model.impl;

import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.events.PlayerEvent;
import com.sun.org.apache.regexp.internal.recompile;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import edu.nju.controller.impl.ClientControllerImpl;
import edu.nju.model.po.BlockPO;
import edu.nju.model.service.ChessBoardModelService;
import edu.nju.model.service.GameModelService;
import edu.nju.model.service.ParameterModelService;
import edu.nju.model.state.BlockState;
import edu.nju.model.state.GameResultState;
import edu.nju.model.state.GameState;
import edu.nju.model.vo.BlockVO;
import edu.nju.network.Player;

public class ChessBoardModelImpl extends BaseModel implements ChessBoardModelService{
	
	private GameModelService gameModel;
	private ParameterModelService parameterModel;
	
	private BlockPO[][] blockMatrix;

	public static  GameState gameState = GameState.RUN;
	private GameModelImpl gameModelImpl;
	
	public static final Player PLAYER=Player.HOST;
	
	public ChessBoardModelImpl(ParameterModelService parameterModel){
		this.parameterModel = parameterModel;
	}

	@Override
	public boolean initialize(int width, int height, int mineNum) {
		// TODO Auto-generated method stub
		/********************简单示例初始化方法，待完善********************/
		blockMatrix = new BlockPO[width][height];
		setBlock(mineNum);
		this.parameterModel.setMineNum(mineNum);
		/***********请在删除上述内容的情况下，完成自己的内容****************/
//	已写
		this.printBlockMatrix();
		
		return false;
	}

	@Override
	public boolean excavate(int x, int y,Player player) {
		// TODO Auto-generated method stub
		/********************简单示例挖开方法，待完善********************/
		if(gameState==GameState.RUN){
			if(blockMatrix == null)
				return false;
			
			List<BlockPO> blocks = new ArrayList<BlockPO>();
			BlockPO block = blockMatrix[x][y];
			BlockState state = block.getState();
			if(state == BlockState.UNCLICK){
				block.setState(BlockState.CLICK);
				if(blockMatrix[x][y].getMineNum()==0){
					int width = blockMatrix.length;
					int height = blockMatrix[0].length;
					for(int tempI = x-1;tempI<=x+1;tempI++){
						for(int tempJ = y-1;tempJ<=y+1;tempJ++){
							if((tempI>=0&&tempI<width)&&(tempJ>=0&&tempJ<height)){
								if(blockMatrix[tempI][tempJ].getState()==BlockState.UNCLICK){
									excavate(tempI, tempJ,player);
								}
							}
						}
					}
				}
				blocks.add(block);
			}
			
			
			if(block.isMine()){
				gameState = GameState.OVER;
				this.gameModel.gameOver(GameResultState.FAIL,player);
			}
			
			if(gameState!=GameState.OVER){
				gameState=GameState.OVER;
				for(int i=0;i<blockMatrix.length;i++){
					for(int j=0;j<blockMatrix[0].length;j++){
						if(blockMatrix[i][j].getState()==BlockState.UNCLICK){
							gameState=GameState.RUN;
							break;
						}
					}
				}
				if(gameState==GameState.OVER){
					this.gameModel.gameOver(GameResultState.SUCCESS,player);
				}
			}
			if(ClientControllerImpl.getIsSetClient()){
				super.updateChange(new UpdateMessage("excute",
						this.getDisplayList(blocks, gameState),player));
			}else{
				super.updateChange(new UpdateMessage("excute",
						this.getDisplayList(blocks, gameState),player));
			}
			
			
		}
		/***********请在删除上述内容的情况下，完成自己的内容****************/
//		已写
		return true;
	}
	
	@Override
	public boolean mark(int x, int y,Player player) {
		// TODO Auto-generated method stub
		/********************简单示例标记方法，待完善********************/
		if(gameState==GameState.RUN){
			if(blockMatrix == null)
				return false;
			
			List<BlockPO> blocks = new ArrayList<BlockPO>();
			BlockPO block = blockMatrix[x][y];
			 
				BlockState state = block.getState();
				if(state == BlockState.UNCLICK){
					if(this.parameterModel.isOKMinus()){
						if(player==Player.CLIENT){
							block.setState(BlockState.FLAGC);
							System.out.println("标记该块("+x+","+y+")为FLAGC");
						}else{
							block.setState(BlockState.FLAG);
						}
						this.parameterModel.minusMineNum();
					}
				}else if(state == BlockState.FLAG){
					if(!(player==Player.CLIENT)){
						block.setState(BlockState.UNCLICK);
					}
					this.parameterModel.addMineNum();
				}else if(state==BlockState.FLAGC){
					if((player==Player.CLIENT)){
						block.setState(BlockState.UNCLICK);
					}
				}
				blocks.add(block);
		    
			if(gameState!=GameState.OVER){
				gameState=GameState.OVER;
				for(int i=0;i<blockMatrix.length;i++){
					for(int j=0;j<blockMatrix[0].length;j++){
						if(blockMatrix[i][j].getState()==BlockState.UNCLICK){
							gameState=GameState.RUN;
							break;
						}
					}
				}
				if(gameState==GameState.OVER){
					this.gameModel.gameOver(GameResultState.SUCCESS,player);
				}
			}
			if(ClientControllerImpl.getIsSetClient()){
				super.updateChange(new UpdateMessage("excute",
						this.getDisplayList(blocks, GameState.RUN),player));
			}else{
				super.updateChange(new UpdateMessage("excute",
						this.getDisplayList(blocks, GameState.RUN),player));
			}
		
			/***********请在删除上述内容的情况下，完成自己的内容****************/
	//		已写
		}
		return true;
	}

	@Override
	public boolean quickExcavate(int x, int y,Player player) {
		// TODO Auto-generated method stub
		/***********请在此处完成快速挖开方法实现****************/
		if(gameState==GameState.RUN){
			int width = blockMatrix.length;
			int height = blockMatrix[0].length;
			if(blockMatrix[x][y].getState()==BlockState.CLICK){
				int flagCount=0;
				for(int tempI = x-1;tempI<=x+1;tempI++){
					for(int tempJ = y-1;tempJ<=y+1;tempJ++){
						if((tempI>=0&&tempI<width)&&(tempJ>=0&&tempJ<height)){
							if(blockMatrix[tempI][tempJ].getState()==BlockState.FLAG
									||blockMatrix[tempI][tempJ].getState()==BlockState.FLAGC){
								flagCount++;
							}
						}
					}
				}
				if(blockMatrix[x][y].getMineNum()==flagCount){
					
					for(int tempI = x-1;tempI<=x+1;tempI++){
						for(int tempJ = y-1;tempJ<=y+1;tempJ++){
							if((tempI>=0&&tempI<width)&&(tempJ>=0&&tempJ<height)){
								if(blockMatrix[tempI][tempJ].getState()==BlockState.UNCLICK){
									excavate(tempI, tempJ,player);
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * 示例方法，可选择是否保留该形式
	 * 
	 * 初始化BlockMatrix中的Block，并随机设置mineNum颗雷
	 * 同时可以为每个Block设定附近的雷数
	 * @param mineNum
	 * @return
	 */
	private boolean setBlock(int mineNum){
		if(!ClientControllerImpl.getIsSetClient()){
			int width = blockMatrix.length;
			int height = blockMatrix[0].length;
			
	
			//初始化及布雷
			for(int i = 0 ; i<width; i++){
				for (int j = 0 ; j< height; j++){
					blockMatrix[i][j] = new BlockPO(i,j);
				}
			}
			for (int i = 0; i < mineNum;) {
				int x = (int) (Math.random() * width);
				int y = (int) (Math.random() * height);
	
				if (blockMatrix[x][y].isMine()!=true) {
					blockMatrix[x][y].setMine(true);
					addMineNum(x, y);
					i++;
				}
			}
			
			
		}
		return false;
	}
	
	
	/**
	 * 示例方法，可选择是否保留该形式
	 * 
	 * 将(i,j)位置附近的Block雷数加1
	 * @param i
	 * @param j
	 */
	private void addMineNum(int i, int j){
		int width = blockMatrix.length;
		int height = blockMatrix[0].length;
		
				
		
		for(int tempI = i-1;tempI<=i+1;tempI++){
			for(int tempJ = j-1;tempJ<=j+1;tempJ++){
				if((tempI>=0&&tempI<width)&&(tempJ>=0&&tempJ<height)){
//					System.out.println(i+";"+j+":"+tempI+";"+tempJ+":");
					blockMatrix[tempI][tempJ].addMine();
				}
			}
		}
		
	}
	
	/**
	 * 将逻辑对象转化为显示对象
	 * @param blocks
	 * @param gameState
	 * @return
	 */
	private List<BlockVO> getDisplayList(List<BlockPO> blocks, GameState gameState){
		List<BlockVO> result = new ArrayList<BlockVO>();
		if(gameState==GameState.RUN){
			for(BlockPO block : blocks){
				if(block != null){
					BlockVO displayBlock = block.getDisplayBlock(gameState);
					if(displayBlock.getState() != null)
						result.add(displayBlock);
				}
			}
		}else if(gameState==GameState.OVER){
			for(int i=0;i<blockMatrix.length;i++){
				for(int j=0;j<blockMatrix[0].length;j++){
					if(blockMatrix[i][j]!=null){
						BlockVO displayBlock=blockMatrix[i][j].getDisplayBlock(gameState);
						if(displayBlock.getState()!=null){
							result.add(displayBlock);
						}
					}
				}
			}
		}
		return result;
	}

	@Override
	public void setGameModel(GameModelService gameModel) {
		// TODO Auto-generated method stub
		this.gameModel = gameModel;
	}
	
	
	private void printBlockMatrix(){
		for(BlockPO[] blocks : this.blockMatrix){
			for(BlockPO b :blocks){
				String p = b.getMineNum()+"";
				if(b.isMine())
					p="*";
				System.out.print(p);
			}
			System.out.println();
		}
	}
}
