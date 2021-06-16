package othello;

import java.util.ArrayList;

public class OthelloJSP {
	private int[][] banmen=new int[8][8];
	private int turn=1;
	private int reverseCount=0;
	private int turnCount=0;
	private int passCount=0;
	private boolean computer1=false;
	private boolean computer2=false;
	private int com1Level;
	private int com2Level;
	private ArrayList<int[][]>record=new ArrayList<>();
	private boolean result;
	/*public static void main(String[] args) {
		mainOthello();
	}*/

	public OthelloJSP() {

	}

	public  void mainOthello() {
		shokibanmen();
	}

	public void plusTurnCount() {
		turnCount++;
	}
	public void minusTurnCount() {
		turnCount--;
	}
	public void plusPassCount() {
		passCount++;
	}
	public void setBanmen(int[][]banmen) {
		this.banmen=banmen;
	}
	public void setTurn(int turn) {
		this.turn=turn;
	}
	public void setReverseCount(int count) {
		reverseCount=count;
	}
	public void setPassCount(int n) {
		passCount=n;
	}
	public void setCom1(){
		computer1=true;
	}
	public void setCom2() {
		computer2=true;
	}
	public void setCom1Lv(int level) {
		com1Level=level;
	}
	public void setCom2Lv(int level) {
		com2Level=level;
	}
	public void setResult(boolean result) {
		this.result=result;
	}
	public void addRecord(int[][]banmen) {
		record.add(banmen);
	}
	public int[][] getBanmen(){
		return banmen;
	}
	public int getReverseCount() {
		return reverseCount;
	}
	public int getTurn() {
		return turn;
	}
	public int getPassCount() {
		return passCount;
	}
	public boolean getComputer1() {
		return computer1;
	}
	public boolean getComputer2() {
		return computer2;
	}
	public int getCom1Lv() {
		return com1Level;
	}
	public int getCom2Lv() {
		return com2Level;
	}
	public boolean getResult() {
		return result;
	}
	public ArrayList<int[][]> getRecord(){
		return record;
	}
	public int[][]cloneBanmen(int[][] banmen){
		int[][]cBanmen=new int[8][8];
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				cBanmen[i][j]=banmen[i][j];
			}
		}
		return cBanmen;
	}
	public void shokibanmen() {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if((i==3&&j==3)||(i==4&&j==4)) {
					banmen[i][j]=1;
				}else if((i==3&&j==4)||(i==4&&j==3)) {
					banmen[i][j]=2;
				}else {
					banmen[i][j]=0;
				}
			}
		}
	}

	public void banmenhyoji() {
		System.out.print("  ");
		for(int i=1;i<=8;i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i=0;i<8;i++) {
			System.out.print(i+1+" ");
			for(int j=0;j<8;j++) {
				if(banmen[i][j]==1) {
						System.out.print("黒");
				}else if(banmen[i][j]==2) {
						System.out.print("白");
				}else if(banmen[i][j]==0){
					System.out.print("み");
				}
			}
			System.out.println();
		}
	}

	public void vBanmenhyoji(int[][]vBanmen) {
		System.out.print("  ");
		for(int i=0;i<=7;i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i=0;i<8;i++) {
			System.out.print(i+" ");
			for(int j=0;j<8;j++) {
				if(vBanmen[i][j]==1) {
						System.out.print("黒");
				}else if(vBanmen[i][j]==2) {
						System.out.print("白");
				}else if(vBanmen[i][j]==0){
					System.out.print("み");
				}
			}
			System.out.println();
		}
	}

	public void reverse(int gyo,int retu) {
		int reverseGyo=gyo;
		int reverseRetu=retu;
		//下
		for(int i=1;gyo+i<8;i++) {
			if(banmen[gyo+i][retu]==0) {
				break;
			}else if(banmen[gyo+i][retu]==turn) {
				for(int j=1;j+gyo<=reverseGyo;j++) {
					banmen[gyo+j][retu]=turn;
					reverseCount++;
				}
				reverseGyo=gyo;
				reverseRetu=retu;
				break;
			}else {
				reverseGyo++;
				continue;
			}
		}
		//上
		reverseGyo=gyo;
		reverseRetu=retu;
		for(int i=1;gyo-i>=0;i++) {
			if(banmen[gyo-i][retu]==0) {
				break;
			}else if(banmen[gyo-i][retu]==turn) {
				for(int j=1;gyo-j>=reverseGyo;j++) {
					banmen[gyo-j][retu]=turn;
					reverseCount++;
				}
				break;
			}else {
				reverseGyo--;
				continue;
			}
		}
		//右
		reverseGyo=gyo;
		reverseRetu=retu;
		for(int i=1;retu+i<8;i++) {
			if(banmen[gyo][retu+i]==0) {
				break;
			}else if(banmen[gyo][retu+i]==turn) {
				for(int j=1;retu+j<=reverseRetu;j++) {
					banmen[gyo][retu+j]=turn;
					reverseCount++;
				}
				break;
			}else {
				reverseRetu++;
				continue;
			}
		}
		//左
		reverseGyo=gyo;
		reverseRetu=retu;
		for(int i=1;retu-i>=0;i++) {
			if(banmen[gyo][retu-i]==0) {
				break;
			}else if(banmen[gyo][retu-i]==turn) {
				for(int j=1;retu-j>=reverseRetu;j++) {
					banmen[gyo][retu-j]=turn;
					reverseCount++;
				}
				break;
			}else {
				reverseRetu--;
				continue;
			}
		}
		//右下
		reverseGyo=gyo;
		reverseRetu=retu;
		for(int i=1;gyo+i<8&&retu+i<8;i++) {
			if(banmen[gyo+i][retu+i]==0) {
				break;
			}else if(banmen[gyo+i][retu+i]==turn) {
				for(int j=1;j+gyo<=reverseGyo;j++) {
					banmen[gyo+j][retu+j]=turn;
					reverseCount++;
				}
				break;
			}else {
				reverseGyo++;
				reverseRetu++;
				continue;
			}
		}
		//左上
		reverseGyo=gyo;
		reverseRetu=retu;
		for(int i=1;gyo-i>=0&&retu-i>=0;i++) {
			if(banmen[gyo-i][retu-i]==0) {
				break;
			}else if(banmen[gyo-i][retu-i]==turn) {
				for(int j=1;gyo-j>=reverseGyo;j++) {
					banmen[gyo-j][retu-j]=turn;
					reverseCount++;
				}
				break;
			}else {
				reverseGyo--;
				reverseRetu--;
				continue;
			}
		}
		//右上
		reverseGyo=gyo;
		reverseRetu=retu;
		for(int i=1;gyo-i>=0&&retu+i<8;i++) {
			if(banmen[gyo-i][retu+i]==0) {
				break;
			}else if(banmen[gyo-i][retu+i]==turn) {
				for(int j=1;gyo-j>=reverseGyo;j++) {
					banmen[gyo-j][retu+j]=turn;
					reverseCount++;
				}
				break;
			}else {
				reverseGyo--;
				reverseRetu++;
				continue;
			}
		}
		//左下
		reverseGyo=gyo;
		reverseRetu=retu;
		for(int i=1;gyo+i<8&&retu-i>=0;i++) {
			if(banmen[gyo+i][retu-i]==0) {
				break;
			}else if(banmen[gyo+i][retu-i]==turn) {
				for(int j=1;gyo+j<=reverseGyo;j++) {
					banmen[gyo+j][retu-j]=turn;
					reverseCount++;
				}
				break;
			}else {
				reverseGyo++;
				reverseRetu--;
				continue;
			}
		}
	}

	public boolean canReverse(int gyo,int retu,int[][]vBanmen) {
		ArrayList<ArrayList<Integer>>canPut=new ArrayList<>();
			int reverseCount=0;
			//下
			int reverseGyo=gyo;
			int reverseRetu=retu;
			for(int i=1;gyo+i<8;i++) {
				if(vBanmen[gyo+i][retu]==0) {
					break;
				}else if(vBanmen[gyo+i][retu]==turn) {
					for(int j=1;j+gyo<=reverseGyo;j++) {
						vBanmen[gyo+j][retu]=turn;
						reverseCount++;
					}
					reverseGyo=gyo;
					reverseRetu=retu;
					break;
				}else {
					reverseGyo++;
					continue;
				}
			}
			//上
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo-i>=0;i++) {
				if(vBanmen[gyo-i][retu]==0) {
					break;
				}else if(vBanmen[gyo-i][retu]==turn) {
					for(int j=1;gyo-j>=reverseGyo;j++) {
						vBanmen[gyo-j][retu]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo--;
					continue;
				}
			}
			//右
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;retu+i<8;i++) {
				if(vBanmen[gyo][retu+i]==0) {
					break;
				}else if(vBanmen[gyo][retu+i]==turn) {
					for(int j=1;retu+j<=reverseRetu;j++) {
						vBanmen[gyo][retu+j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseRetu++;
					continue;
				}
			}
			//左
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;retu-i>=0;i++) {
				if(vBanmen[gyo][retu-i]==0) {
					break;
				}else if(vBanmen[gyo][retu-i]==turn) {
					for(int j=1;retu-j>=reverseRetu;j++) {
						vBanmen[gyo][retu-j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseRetu--;
					continue;
				}
			}
			//右下
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo+i<8&&retu+i<8;i++) {
				if(vBanmen[gyo+i][retu+i]==0) {
					break;
				}else if(vBanmen[gyo+i][retu+i]==turn) {
					for(int j=1;j+gyo<=reverseGyo;j++) {
						vBanmen[gyo+j][retu+j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo++;
					reverseRetu++;
					continue;
				}
			}
			//左上
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo-i>=0&&retu-i>=0;i++) {
				if(vBanmen[gyo-i][retu-i]==0) {
					break;
				}else if(vBanmen[gyo-i][retu-i]==turn) {
					for(int j=1;gyo-j>=reverseGyo;j++) {
						vBanmen[gyo-j][retu-j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo--;
					reverseRetu--;
					continue;
				}
			}
			//右上
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo-i>=0&&retu+i<8;i++) {
				if(vBanmen[gyo-i][retu+i]==0) {
					break;
				}else if(vBanmen[gyo-i][retu+i]==turn) {
					for(int j=1;gyo-j>=reverseGyo;j++) {
						vBanmen[gyo-j][retu+j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo--;
					reverseRetu++;
					continue;
				}
			}
			//左下
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo+i<8&&retu-i>=0;i++) {
				if(vBanmen[gyo+i][retu-i]==0) {
					break;
				}else if(vBanmen[gyo+i][retu-i]==turn) {
					for(int j=1;gyo+j<=reverseGyo;j++) {
						vBanmen[gyo+j][retu-j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo++;
					reverseRetu--;
					continue;
				}
			}
			if(reverseCount>0) {
				return true;
			}else {
				return false;
			}
	}

	public int[][]vReverse(int gyo,int retu,int[][]vBanmen) {
		ArrayList<ArrayList<Integer>>canPut=new ArrayList<>();
			int reverseCount=0;
			int reverseGyo=gyo;
			int reverseRetu=retu;
			//下
			for(int i=1;gyo+i<8;i++) {
				if(vBanmen[gyo+i][retu]==0) {
					break;
				}else if(vBanmen[gyo+i][retu]==turn) {
					for(int j=1;j+gyo<=reverseGyo;j++) {
						vBanmen[gyo+j][retu]=turn;
						reverseCount++;
					}
					reverseGyo=gyo;
					reverseRetu=retu;
					break;
				}else {
					reverseGyo++;
					continue;
				}
			}
			//上
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo-i>=0;i++) {
				if(vBanmen[gyo-i][retu]==0) {
					break;
				}else if(vBanmen[gyo-i][retu]==turn) {
					for(int j=1;gyo-j>=reverseGyo;j++) {
						vBanmen[gyo-j][retu]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo--;
					continue;
				}
			}
			//右
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;retu+i<8;i++) {
				if(vBanmen[gyo][retu+i]==0) {
					break;
				}else if(vBanmen[gyo][retu+i]==turn) {
					for(int j=1;retu+j<=reverseRetu;j++) {
						vBanmen[gyo][retu+j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseRetu++;
					continue;
				}
			}
			//左
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;retu-i>=0;i++) {
				if(vBanmen[gyo][retu-i]==0) {
					break;
				}else if(vBanmen[gyo][retu-i]==turn) {
					for(int j=1;retu-j>=reverseRetu;j++) {
						vBanmen[gyo][retu-j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseRetu--;
					continue;
				}
			}
			//右下
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo+i<8&&retu+i<8;i++) {
				if(vBanmen[gyo+i][retu+i]==0) {
					break;
				}else if(vBanmen[gyo+i][retu+i]==turn) {
					for(int j=1;j+gyo<=reverseGyo;j++) {
						vBanmen[gyo+j][retu+j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo++;
					reverseRetu++;
					continue;
				}
			}
			//左上
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo-i>=0&&retu-i>=0;i++) {
				if(vBanmen[gyo-i][retu-i]==0) {
					break;
				}else if(vBanmen[gyo-i][retu-i]==turn) {
					for(int j=1;gyo-j>=reverseGyo;j++) {
						vBanmen[gyo-j][retu-j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo--;
					reverseRetu--;
					continue;
				}
			}
			//右上
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo-i>=0&&retu+i<8;i++) {
				if(vBanmen[gyo-i][retu+i]==0) {
					break;
				}else if(vBanmen[gyo-i][retu+i]==turn) {
					for(int j=1;gyo-j>=reverseGyo;j++) {
						vBanmen[gyo-j][retu+j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo--;
					reverseRetu++;
					continue;
				}
			}
			//左下
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo+i<8&&retu-i>=0;i++) {
				if(vBanmen[gyo+i][retu-i]==0) {
					break;
				}else if(vBanmen[gyo+i][retu-i]==turn) {
					for(int j=1;gyo+j<=reverseGyo;j++) {
						vBanmen[gyo+j][retu-j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo++;
					reverseRetu--;
					continue;
				}
			}
		return vBanmen;
	}

	public ArrayList<ArrayList<Integer>> vReverse() {
		ArrayList<ArrayList<Integer>> emptyList=new ArrayList<>();
		int[][]vBanmen=getVBanmen();
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(vBanmen[i][j]==0) {
					ArrayList<Integer> subEmptyList=new ArrayList<>();
					subEmptyList.add(i);
					subEmptyList.add(j);
					emptyList.add(subEmptyList);
				}
			}
		}
		ArrayList<ArrayList<Integer>>canPut=new ArrayList<>();
		for(ArrayList<Integer> emp:emptyList) {
			vBanmen=getVBanmen();
			int reverseCount=0;
			int gyo=emp.get(0);
			int retu=emp.get(1);
			int reverseGyo=gyo;
			int reverseRetu=retu;
			//下
			for(int i=1;gyo+i<8;i++) {
				if(vBanmen[gyo+i][retu]==0) {
					break;
				}else if(vBanmen[gyo+i][retu]==turn) {
					for(int j=1;j+gyo<=reverseGyo;j++) {
						vBanmen[gyo+j][retu]=turn;
						reverseCount++;
					}
					reverseGyo=gyo;
					reverseRetu=retu;
					break;
				}else {
					reverseGyo++;
					continue;
				}
			}
			//上
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo-i>=0;i++) {
				if(vBanmen[gyo-i][retu]==0) {
					break;
				}else if(vBanmen[gyo-i][retu]==turn) {
					for(int j=1;gyo-j>=reverseGyo;j++) {
						vBanmen[gyo-j][retu]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo--;
					continue;
				}
			}
			//右
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;retu+i<8;i++) {
				if(vBanmen[gyo][retu+i]==0) {
					break;
				}else if(vBanmen[gyo][retu+i]==turn) {
					for(int j=1;retu+j<=reverseRetu;j++) {
						vBanmen[gyo][retu+j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseRetu++;
					continue;
				}
			}
			//左
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;retu-i>=0;i++) {
				if(vBanmen[gyo][retu-i]==0) {
					break;
				}else if(vBanmen[gyo][retu-i]==turn) {
					for(int j=1;retu-j>=reverseRetu;j++) {
						vBanmen[gyo][retu-j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseRetu--;
					continue;
				}
			}
			//右下
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo+i<8&&retu+i<8;i++) {
				if(vBanmen[gyo+i][retu+i]==0) {
					break;
				}else if(vBanmen[gyo+i][retu+i]==turn) {
					for(int j=1;j+gyo<=reverseGyo;j++) {
						vBanmen[gyo+j][retu+j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo++;
					reverseRetu++;
					continue;
				}
			}
			//左上
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo-i>=0&&retu-i>=0;i++) {
				if(vBanmen[gyo-i][retu-i]==0) {
					break;
				}else if(vBanmen[gyo-i][retu-i]==turn) {
					for(int j=1;gyo-j>=reverseGyo;j++) {
						vBanmen[gyo-j][retu-j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo--;
					reverseRetu--;
					continue;
				}
			}
			//右上
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo-i>=0&&retu+i<8;i++) {
				if(vBanmen[gyo-i][retu+i]==0) {
					break;
				}else if(vBanmen[gyo-i][retu+i]==turn) {
					for(int j=1;gyo-j>=reverseGyo;j++) {
						vBanmen[gyo-j][retu+j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo--;
					reverseRetu++;
					continue;
				}
			}
			//左下
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo+i<8&&retu-i>=0;i++) {
				if(vBanmen[gyo+i][retu-i]==0) {
					break;
				}else if(vBanmen[gyo+i][retu-i]==turn) {
					for(int j=1;gyo+j<=reverseGyo;j++) {
						vBanmen[gyo+j][retu-j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo++;
					reverseRetu--;
					continue;
				}
			}
			if(reverseCount>0) {
				ArrayList<Integer>gyoretu=new ArrayList<>();
				gyoretu.add(gyo);
				gyoretu.add(retu);
				gyoretu.add(reverseCount);
				canPut.add(gyoretu);
			}
		}
		return canPut;
	}

	public ArrayList<ArrayList<Integer>> vReverse(int[][]vBanmen) {
		ArrayList<ArrayList<Integer>> emptyList=new ArrayList<>();
		int[][]vBanmenClone=new int[8][8];
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				vBanmenClone[i][j]=vBanmen[i][j];
				if(vBanmen[i][j]==0) {
					ArrayList<Integer> subEmptyList=new ArrayList<>();
					subEmptyList.add(i);
					subEmptyList.add(j);
					emptyList.add(subEmptyList);
				}
			}
		}
		ArrayList<ArrayList<Integer>>canPut=new ArrayList<>();
		for(ArrayList<Integer> emp:emptyList) {
			for(int i=0;i<8;i++) {
				for(int j=0;j<8;j++) {
					vBanmen[i][j]=vBanmenClone[i][j];
				}
			}
			int reverseCount=0;
			int gyo=emp.get(0);
			int retu=emp.get(1);
			int reverseGyo=gyo;
			int reverseRetu=retu;
			//下
			for(int i=1;gyo+i<8;i++) {
				if(vBanmen[gyo+i][retu]==0) {
					break;
				}else if(vBanmen[gyo+i][retu]==turn) {
					for(int j=1;j+gyo<=reverseGyo;j++) {
						vBanmen[gyo+j][retu]=turn;
						reverseCount++;
					}
					reverseGyo=gyo;
					reverseRetu=retu;
					break;
				}else {
					reverseGyo++;
					continue;
				}
			}
			//上
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo-i>=0;i++) {
				if(vBanmen[gyo-i][retu]==0) {
					break;
				}else if(vBanmen[gyo-i][retu]==turn) {
					for(int j=1;gyo-j>=reverseGyo;j++) {
						vBanmen[gyo-j][retu]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo--;
					continue;
				}
			}
			//右
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;retu+i<8;i++) {
				if(vBanmen[gyo][retu+i]==0) {
					break;
				}else if(vBanmen[gyo][retu+i]==turn) {
					for(int j=1;retu+j<=reverseRetu;j++) {
						vBanmen[gyo][retu+j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseRetu++;
					continue;
				}
			}
			//左
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;retu-i>=0;i++) {
				if(vBanmen[gyo][retu-i]==0) {
					break;
				}else if(vBanmen[gyo][retu-i]==turn) {
					for(int j=1;retu-j>=reverseRetu;j++) {
						vBanmen[gyo][retu-j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseRetu--;
					continue;
				}
			}
			//右下
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo+i<8&&retu+i<8;i++) {
				if(vBanmen[gyo+i][retu+i]==0) {
					break;
				}else if(vBanmen[gyo+i][retu+i]==turn) {
					for(int j=1;j+gyo<=reverseGyo;j++) {
						vBanmen[gyo+j][retu+j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo++;
					reverseRetu++;
					continue;
				}
			}
			//左上
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo-i>=0&&retu-i>=0;i++) {
				if(vBanmen[gyo-i][retu-i]==0) {
					break;
				}else if(vBanmen[gyo-i][retu-i]==turn) {
					for(int j=1;gyo-j>=reverseGyo;j++) {
						vBanmen[gyo-j][retu-j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo--;
					reverseRetu--;
					continue;
				}
			}
			//右上
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo-i>=0&&retu+i<8;i++) {
				if(vBanmen[gyo-i][retu+i]==0) {
					break;
				}else if(vBanmen[gyo-i][retu+i]==turn) {
					for(int j=1;gyo-j>=reverseGyo;j++) {
						vBanmen[gyo-j][retu+j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo--;
					reverseRetu++;
					continue;
				}
			}
			//左下
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo+i<8&&retu-i>=0;i++) {
				if(vBanmen[gyo+i][retu-i]==0) {
					break;
				}else if(vBanmen[gyo+i][retu-i]==turn) {
					for(int j=1;gyo+j<=reverseGyo;j++) {
						vBanmen[gyo+j][retu-j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo++;
					reverseRetu--;
					continue;
				}
			}
			if(reverseCount>0) {
				ArrayList<Integer>gyoretu=new ArrayList<>();
				gyoretu.add(gyo);
				gyoretu.add(retu);
				gyoretu.add(reverseCount);
				canPut.add(gyoretu);
			}
		}
		return canPut;
	}

	public ArrayList<ArrayList<Integer>> getCanPut(int[][]banmen) {
		ArrayList<ArrayList<Integer>> emptyList=new ArrayList<>();
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(banmen[i][j]==0) {
					ArrayList<Integer> subEmptyList=new ArrayList<>();
					subEmptyList.add(i);
					subEmptyList.add(j);
					emptyList.add(subEmptyList);
				}
			}
		}
		ArrayList<ArrayList<Integer>>canPut=new ArrayList<>();
		for(ArrayList<Integer> emp:emptyList) {
			int reverseCount=0;
			int gyo=emp.get(0);
			int retu=emp.get(1);
			int reverseGyo=gyo;
			int reverseRetu=retu;
			//下
			for(int i=1;gyo+i<8;i++) {
				if(banmen[gyo+i][retu]==0) {
					break;
				}else if(banmen[gyo+i][retu]==turn) {
					for(int j=1;j+gyo<=reverseGyo;j++) {
						banmen[gyo+j][retu]=turn;
						reverseCount++;
					}
					reverseGyo=gyo;
					reverseRetu=retu;
					break;
				}else {
					reverseGyo++;
					continue;
				}
			}
			//上
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo-i>=0;i++) {
				if(banmen[gyo-i][retu]==0) {
					break;
				}else if(banmen[gyo-i][retu]==turn) {
					for(int j=1;gyo-j>=reverseGyo;j++) {
						banmen[gyo-j][retu]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo--;
					continue;
				}
			}
			//右
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;retu+i<8;i++) {
				if(banmen[gyo][retu+i]==0) {
					break;
				}else if(banmen[gyo][retu+i]==turn) {
					for(int j=1;retu+j<=reverseRetu;j++) {
						banmen[gyo][retu+j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseRetu++;
					continue;
				}
			}
			//左
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;retu-i>=0;i++) {
				if(banmen[gyo][retu-i]==0) {
					break;
				}else if(banmen[gyo][retu-i]==turn) {
					for(int j=1;retu-j>=reverseRetu;j++) {
						banmen[gyo][retu-j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseRetu--;
					continue;
				}
			}
			//右下
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo+i<8&&retu+i<8;i++) {
				if(banmen[gyo+i][retu+i]==0) {
					break;
				}else if(banmen[gyo+i][retu+i]==turn) {
					for(int j=1;j+gyo<=reverseGyo;j++) {
						banmen[gyo+j][retu+j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo++;
					reverseRetu++;
					continue;
				}
			}
			//左上
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo-i>=0&&retu-i>=0;i++) {
				if(banmen[gyo-i][retu-i]==0) {
					break;
				}else if(banmen[gyo-i][retu-i]==turn) {
					for(int j=1;gyo-j>=reverseGyo;j++) {
						banmen[gyo-j][retu-j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo--;
					reverseRetu--;
					continue;
				}
			}
			//右上
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo-i>=0&&retu+i<8;i++) {
				if(banmen[gyo-i][retu+i]==0) {
					break;
				}else if(banmen[gyo-i][retu+i]==turn) {
					for(int j=1;gyo-j>=reverseGyo;j++) {
						banmen[gyo-j][retu+j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo--;
					reverseRetu++;
					continue;
				}
			}
			//左下
			reverseGyo=gyo;
			reverseRetu=retu;
			for(int i=1;gyo+i<8&&retu-i>=0;i++) {
				if(banmen[gyo+i][retu-i]==0) {
					break;
				}else if(banmen[gyo+i][retu-i]==turn) {
					for(int j=1;gyo+j<=reverseGyo;j++) {
						banmen[gyo+j][retu-j]=turn;
						reverseCount++;
					}
					break;
				}else {
					reverseGyo++;
					reverseRetu--;
					continue;
				}
			}
			if(reverseCount>0) {
				ArrayList<Integer>gyoretu=new ArrayList<>();
				gyoretu.add(gyo);
				gyoretu.add(retu);
				gyoretu.add(reverseCount);
				canPut.add(gyoretu);
			}
		}
		return canPut;
	}

	public int getReverseCount(int gyo,int retu,int[][]vBanmen) {
		ArrayList<ArrayList<Integer>>canPut=new ArrayList<>();
		int reverseCount=0;
		int reverseGyo=gyo;
		int reverseRetu=retu;
		//下
		for(int i=1;gyo+i<8;i++) {
			if(vBanmen[gyo+i][retu]==0) {
				break;
			}else if(vBanmen[gyo+i][retu]==turn) {
				for(int j=1;j+gyo<=reverseGyo;j++) {
					vBanmen[gyo+j][retu]=turn;
					reverseCount++;
				}
				reverseGyo=gyo;
				reverseRetu=retu;
				break;
			}else {
				reverseGyo++;
				continue;
			}
		}
		//上
		reverseGyo=gyo;
		reverseRetu=retu;
		for(int i=1;gyo-i>=0;i++) {
			if(vBanmen[gyo-i][retu]==0) {
				break;
			}else if(vBanmen[gyo-i][retu]==turn) {
				for(int j=1;gyo-j>=reverseGyo;j++) {
					vBanmen[gyo-j][retu]=turn;
					reverseCount++;
				}
				break;
			}else {
				reverseGyo--;
				continue;
			}
		}
		//右
		reverseGyo=gyo;
		reverseRetu=retu;
		for(int i=1;retu+i<8;i++) {
			if(vBanmen[gyo][retu+i]==0) {
				break;
			}else if(vBanmen[gyo][retu+i]==turn) {
				for(int j=1;retu+j<=reverseRetu;j++) {
					vBanmen[gyo][retu+j]=turn;
					reverseCount++;
				}
				break;
			}else {
				reverseRetu++;
				continue;
			}
		}
		//左
		reverseGyo=gyo;
		reverseRetu=retu;
		for(int i=1;retu-i>=0;i++) {
			if(vBanmen[gyo][retu-i]==0) {
				break;
			}else if(vBanmen[gyo][retu-i]==turn) {
				for(int j=1;retu-j>=reverseRetu;j++) {
					vBanmen[gyo][retu-j]=turn;
					reverseCount++;
				}
				break;
			}else {
				reverseRetu--;
				continue;
			}
		}
		//右下
		reverseGyo=gyo;
		reverseRetu=retu;
		for(int i=1;gyo+i<8&&retu+i<8;i++) {
			if(vBanmen[gyo+i][retu+i]==0) {
				break;
			}else if(vBanmen[gyo+i][retu+i]==turn) {
				for(int j=1;j+gyo<=reverseGyo;j++) {
					vBanmen[gyo+j][retu+j]=turn;
					reverseCount++;
				}
				break;
			}else {
				reverseGyo++;
				reverseRetu++;
				continue;
			}
		}
		//左上
		reverseGyo=gyo;
		reverseRetu=retu;
		for(int i=1;gyo-i>=0&&retu-i>=0;i++) {
			if(vBanmen[gyo-i][retu-i]==0) {
				break;
			}else if(vBanmen[gyo-i][retu-i]==turn) {
				for(int j=1;gyo-j>=reverseGyo;j++) {
					vBanmen[gyo-j][retu-j]=turn;
					reverseCount++;
				}
				break;
			}else {
				reverseGyo--;
				reverseRetu--;
				continue;
			}
		}
		//右上
		reverseGyo=gyo;
		reverseRetu=retu;
		for(int i=1;gyo-i>=0&&retu+i<8;i++) {
			if(vBanmen[gyo-i][retu+i]==0) {
				break;
			}else if(vBanmen[gyo-i][retu+i]==turn) {
				for(int j=1;gyo-j>=reverseGyo;j++) {
					vBanmen[gyo-j][retu+j]=turn;
					reverseCount++;
				}
				break;
			}else {
				reverseGyo--;
				reverseRetu++;
				continue;
			}
		}
		//左下
		reverseGyo=gyo;
		reverseRetu=retu;
		for(int i=1;gyo+i<8&&retu-i>=0;i++) {
			if(vBanmen[gyo+i][retu-i]==0) {
				break;
			}else if(vBanmen[gyo+i][retu-i]==turn) {
				for(int j=1;gyo+j<=reverseGyo;j++) {
					vBanmen[gyo+j][retu-j]=turn;
					reverseCount++;
				}
				break;
			}else {
				reverseGyo++;
				reverseRetu--;
				continue;
			}
		}
		return reverseCount;
	}

	public int getTurnCount(){
		return turnCount;
	}

	public void updateTurn() {
		if(turn==1) {
			turn=2;
		}else {
			turn=1;
		}
	}

	public void updateTurnCount() {
		turnCount++;
	}

	public int[][] getVBanmen() {
		int[][]vBanmen=new int[8][8];
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				int v=banmen[i][j];
				vBanmen[i][j]=v;
			}
		}
		return vBanmen;
	}

	public boolean canPut() {
		ArrayList<ArrayList<Integer>>canPut=vReverse();
		if(canPut.isEmpty())return false;
		return true;
	}

	public boolean canPut(int gyo,int retu,int[][]banmen,ArrayList<ArrayList<Integer>>list) {
		for(ArrayList<Integer>l:list) {
			banmen[gyo][retu]=turn;
			updateTurn();
			boolean canPut=canReverse(l.get(0),l.get(1),banmen);
			updateTurn();
			if(canPut) {
				return true;
			}
		}
		return false;
	}

	public boolean none0() {
		int zero=0;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++) {
				if(banmen[i][j]==0) {
					zero++;
				}
			}
		}
		if(zero>0) {
			return false;
		}else{
			return true;
		}
	}
	public boolean none0(int[][]banmen) {
		int zero=0;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++) {
				if(banmen[i][j]==0) {
					zero++;
				}
			}
		}
		if(zero>0) {
			return false;
		}else{
			return true;
		}
	}

	public String result() {
		int black=0;
		int white=0;
		String result=null;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++) {
				if(banmen[i][j]==1) {
					black++;
				}else if(banmen[i][j]==2) {
					white++;
				}
			}
		}
		if(black>white) {
			result=black+":"+white+"で黒の勝ちです";
		}else if(white>black) {
			result=black+":"+white+"で白の勝ちです";
		}else {
			result=black+":"+white+"で引き分けです";
		}
		return result;
	}
	public int[] result(int[][]banmen) {
		int[] bw=new int[2];
		int black=0;
		int white=0;
		String result=null;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++) {
				if(banmen[i][j]==1) {
					black++;
				}else if(banmen[i][j]==2) {
					white++;
				}
			}
		}
		bw[0]=black;
		bw[1]=white;
		return bw;
	}
	public boolean all(int[][]banmen){
		int black=0;
		int white=0;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(banmen[i][j]==1) {
					black++;
				}else if(banmen[i][j]==2) {
					white++;
				}
			}
		}
		if(black==0||white==0) {
			return true;
		}
		return false;
	}
}
