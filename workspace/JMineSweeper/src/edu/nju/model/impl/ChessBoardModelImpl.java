package edu.nju.model.impl;

import java.util.ArrayList;
import java.util.List;

import edu.nju.model.po.BlockPO;
import edu.nju.model.service.ChessBoardModelService;
import edu.nju.model.service.GameModelService;
import edu.nju.model.service.ParameterModelService;
import edu.nju.model.state.BlockState;
import edu.nju.model.state.GameResultState;
import edu.nju.model.state.GameState;
import edu.nju.model.vo.BlockVO;

public class ChessBoardModelImpl extends BaseModel implements ChessBoardModelService{
	
	private GameModelService gameModel;
	private ParameterModelService parameterModel;
	
	private BlockPO[][] blockMatrix;

	
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
	public boolean excavate(int x, int y) {
		// TODO Auto-generated method stub
		/********************简单示例挖开方法，待完善********************/
		
		if(blockMatrix == null)
			return false;
		
		List<BlockPO> blocks = new ArrayList<BlockPO>();
		BlockPO block = blockMatrix[x][y];
		BlockState state = block.getState();
		if(state == BlockState.UNCLICK||state == BlockState.FLAG){
			block.setState(BlockState.CLICK);
			if(blockMatrix[x][y].getMineNum()==0){
				int width = blockMatrix.length;
				int height = blockMatrix[0].length;
				for(int tempI = x-1;tempI<=x+1;tempI++){
					for(int tempJ = y-1;tempJ<=y+1;tempJ++){
						if((tempI>=0&&tempI<width)&&(tempJ>=0&&tempJ<height)){
							if(blockMatrix[tempI][tempJ].getState()==BlockState.UNCLICK){
								excavate(tempI, tempJ);
							}
						}
					}
				}
			}
			if(state==BlockState.FLAG){
				this.parameterModel.minusMineNum();
			}
		}
		blocks.add(block);
		
		GameState gameState = GameState.RUN;
		if(block.isMine()){
			gameState = GameState.OVER;
			this.gameModel.gameOver(GameResultState.FAIL);
		}
		
		super.updateChange(new UpdateMessage("excute",this.getDisplayList(blocks, gameState)));			
		/***********请在删除上述内容的情况下，完成自己的内容****************/
//		已写
		return true;
	}
	
	@Override
	public boolean mark(int x, int y) {
		// TODO Auto-generated method stub
		/********************简单示例标记方法，待完善********************/
		if(blockMatrix == null)
			return false;
		
		List<BlockPO> blocks = new ArrayList<BlockPO>();
		BlockPO block = blockMatrix[x][y];
		 
		BlockState state = block.getState();
		if(state == BlockState.UNCLICK){
			block.setState(BlockState.FLAG);
			this.parameterModel.minusMineNum();
		}
		else if(state == BlockState.FLAG){
			block.setState(BlockState.UNCLICK);
			this.parameterModel.addMineNum();
		}
		
		blocks.add(block);	
		super.updateChange(new UpdateMessage("excute",this.getDisplayList(blocks, GameState.RUN)));
		/***********请在删除上述内容的情况下，完成自己的内容****************/
//		已写
		return true;
	}

	@Override
	public boolean quickExcavate(int x, int y) {
		// TODO Auto-generated method stub
		/***********请在此处完成快速挖开方法实现****************/
		int width = blockMatrix.length;
		int height = blockMatrix[0].length;
		if(blockMatrix[x][y].getState()==BlockState.CLICK){
			int flagCount=0;
			for(int tempI = x-1;tempI<=x+1;tempI++){
				for(int tempJ = y-1;tempJ<=y+1;tempJ++){
					if((tempI>=0&&tempI<width)&&(tempJ>=0&&tempJ<height)){
						if(blockMatrix[tempI][tempJ].getState()==BlockState.FLAG){
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
								excavate(tempI, tempJ);
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
		for(BlockPO block : blocks){
			if(block != null){
				BlockVO displayBlock = block.getDisplayBlock(gameState);
				if(displayBlock.getState() != null)
				result.add(displayBlock);
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
