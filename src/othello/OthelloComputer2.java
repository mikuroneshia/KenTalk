package othello;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
public class OthelloComputer2 {
	public static int[][] comArray=Othello.array;
	static HashMap<Integer[],Integer> map;
	static Set<Integer[]> key;
	static ArrayList<Integer[]> keyList;
	static ArrayList<Integer[]> kadList;
	static ArrayList<Integer[]> arKadList;
	static ArrayList<Integer[]> lList;

	public static void othelloCom29() {
		comArray=Othello.array;
		map=new HashMap<>();
		//置ける場所とreverseCountのHashMapを作成
		canPut();
		if(map.size()>0) {
			Set<Integer[]> key=map.keySet();
			keyList=new ArrayList<>(key);
			kadList=new ArrayList<>();
			arKadList=new ArrayList<>();
			lList=new ArrayList<>();
			//角周りの座標をarKadListに追加し、mapからそれらを削除、keyListの更新
			arkadListAdd();
			//L字の座標を持つものをlLIstに追加
			lListAdd();
			//角に置けるものをkadListに追加
			kadListAdd();
			if(kadList.isEmpty()) {
				if(!lList.isEmpty()) {
					if(Othello.turnCount>37) {
						listMax(lList);
					}else {
						listMin(lList);
					}
				}
				else if(!keyList.isEmpty()) {
					if(Othello.turnCount>34) {
						listMax(keyList);
					}else {
						listMin(keyList);
					}
				}else {
					//角に置かれないところを予測して置く
					arKadForecast();
					//既に角が取られている場所の周辺に置く
					arKadAccurateJudge();
				}
			}else {
				Othello.gyo=kadList.get(0)[0]+1;
				Othello.retu=kadList.get(0)[1]+1;
			}

			System.out.println(Othello.gyo+" "+Othello.retu);
			Othello.kousin();
			Othello.reverse();
			}
			if(Othello.reverseCount==0) {
				System.out.println("パスしました。");
				Othello.passCount++;
				if(Othello.turn==2) {
					System.out.println("黒のターンです");
				}else {
					System.out.println("白のターンです");
				}
			}

	}
	public static void canPut() {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				Othello.gyo=i+1;
				Othello.retu=j+1;
				if(Othello.array[Othello.gyo-1][Othello.retu-1]!=0) {
					continue;
				}
				Othello.comReverse();
				if(Othello.reverseCount>0) {
					Integer[] gyoretu= {Othello.gyo,Othello.retu};
					map.put(gyoretu,Othello.reverseCount);
				}
			}
		}
	}
	public static void arkadListAdd() {
		for(Integer[] k:keyList) {
			if((k[0]==0&&k[1]==1)||(k[0]==1&&k[1]==0)||(k[0]==1&&k[1]==1)
					||(k[0]==0&&k[1]==6)||(k[0]==1&&k[1]==6)||(k[0]==1&&k[1]==7)
					||(k[0]==6&&k[1]==0)||(k[0]==6&&k[1]==1)||(k[0]==7&&k[1]==1)
					||(k[0]==6&&k[1]==6)||(k[0]==6&&k[1]==7)||(k[0]==7&&k[1]==6)) {
				arKadList.add(k);
				map.remove(k);
				key=map.keySet();
				keyList=new ArrayList<>(key);
			}
		}
	}
	public static void lListAdd() {
		for(Integer[] k:keyList) {
			if((k[0]==0&&k[1]==2)||(k[0]==1&&k[1]==2)||(k[0]==2&&k[1]==2)
					||(k[0]==2&&k[1]==1)||(k[0]==2&&k[1]==0)||(k[0]==0&&k[1]==5)
					||(k[0]==1&&k[1]==5)||(k[0]==2&&k[1]==5)||(k[0]==2&&k[1]==6)
					||(k[0]==2&&k[1]==7)||(k[0]==5&&k[1]==0)||(k[0]==5&&k[1]==1)
					||(k[0]==5&&k[1]==2)||(k[0]==6&&k[1]==2)||(k[0]==7&&k[1]==2)
					||(k[0]==7&&k[1]==5)||(k[0]==6&&k[1]==5)||(k[0]==5&&k[1]==5)
					||(k[0]==5&&k[1]==6)||(k[0]==5&&k[1]==7)) {
				lList.add(k);
			}
		}
	}
	public static void kadListAdd() {
		for(Integer[] k:keyList) {
			if((k[0]==0&&k[1]==0)||(k[0]==0&&k[1]==7)||(k[0]==7&&k[1]==0)||(k[0]==7&&k[1]==7)) {
				kadList.add(k);
			}
		}
	}
	public static void listMax(ArrayList<Integer[]> list) {
		int max=0;
		Integer[] maxGr=new Integer[2];
		for(Integer[]k1:list) {
			for(Integer[]k2:list) {
				int bigger=Math.max(map.get(k1), map.get(k2));
				if(max<bigger) {
					max=bigger;
					if(bigger==map.get(k1)) {
						maxGr=k1;
					}else {
						maxGr=k2;
					}
				}
			}
		}
		Othello.gyo=maxGr[0]+1;
		Othello.retu=maxGr[1]+1;
	}
	public static void listMin(ArrayList<Integer[]>list) {
		Integer[] minGr=new Integer[2];
		int min=50;
		for(Integer[]k1:list) {
			for(Integer[]k2:list) {
				int smaller=Math.min(map.get(k1), map.get(k2));
				if(min>smaller) {
					min=smaller;
					if(smaller==map.get(k1)) {
						minGr=k1;
					}else {
						minGr=k2;
					}
				}
			}
		}
		Othello.gyo=minGr[0]+1;
		Othello.retu=minGr[1]+1;
	}
	public static void arKadForecast() {
		int l=arKadList.size();
		if(Othello.turn==1) {
			Othello.turn=2;
		}else if(Othello.turn==2) {
			Othello.turn=1;
		}
		for(int i=0;i<l;i++) {
			Othello.gyo=arKadList.get(i)[0]+1;
			Othello.retu=arKadList.get(i)[1]+1;

			if(Othello.kadReverse()) {
				Othello.gyo=arKadList.get(i)[0]+1;
				Othello.retu=arKadList.get(i)[1]+1;
				break;
			}
			Othello.gyo=arKadList.get(i)[0]+1;
			Othello.retu=arKadList.get(i)[1]+1;
		}
	}
	public static void arKadAccurateJudge() {
		int l=arKadList.size();
		for(int i=0;i<l;i++) {
			if(Othello.array[0][0]!=0&&(arKadList.get(i)[0]==0&&arKadList.get(i)[1]==1||
					arKadList.get(i)[0]==1&&arKadList.get(i)[1]==0||
					arKadList.get(i)[0]==1&&arKadList.get(i)[1]==1)) {
				Othello.gyo=arKadList.get(i)[0]+1;
				Othello.retu=arKadList.get(i)[1]+1;
			}else if(Othello.array[7][0]!=0&&(arKadList.get(i)[0]==6&&arKadList.get(i)[1]==0||
					arKadList.get(i)[0]==6&&arKadList.get(i)[1]==1||
					arKadList.get(i)[0]==7&&arKadList.get(i)[1]==1)) {
				Othello.gyo=arKadList.get(i)[0]+1;
				Othello.retu=arKadList.get(i)[1]+1;
			}else if(Othello.array[0][7]!=0&&(arKadList.get(i)[0]==0&&arKadList.get(i)[1]==6||
					arKadList.get(i)[0]==1&&arKadList.get(i)[1]==6||
					arKadList.get(i)[0]==1&&arKadList.get(i)[1]==7)) {
				Othello.gyo=arKadList.get(i)[0]+1;
				Othello.retu=arKadList.get(i)[1]+1;
			}else if(Othello.array[7][7]!=0&&(arKadList.get(i)[0]==7&&arKadList.get(i)[1]==6||
					arKadList.get(i)[0]==6&&arKadList.get(i)[1]==6||
					arKadList.get(i)[0]==6&&arKadList.get(i)[1]==7)) {
				Othello.gyo=arKadList.get(i)[0]+1;
				Othello.retu=arKadList.get(i)[1]+1;
			}
		}
		if(Othello.turn==1) {
			Othello.turn=2;
		}else if(Othello.turn==2) {
			Othello.turn=1;
		}
	}
}

