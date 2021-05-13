package othello;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class OthelloComputer {
	public static int[][] comArray=Othello.array;

	public static void othelloCom() {
		comArray=Othello.array;
		label:
			for(int i=0;i<8;i++) {
				for(int j=0;j<8;j++) {
					Othello.gyo=i+1;
					Othello.retu=j+1;
					if(Othello.array[Othello.gyo-1][Othello.retu-1]!=0) {
						continue;
					}
					Othello.comReverse();
					if(Othello.reverseCount>0) {
						Othello.gyo=i+1;
						Othello.retu=j+1;
						System.out.println(Othello.gyo+" "+Othello.retu);
						Othello.kousin();
						Othello.reverse();
						break label;
					}
				}
			}
		if(Othello.reverseCount==0) {
			System.out.println("パスしました。");
		}
	}
	public static void othelloCom2() {
		HashMap<Integer,Integer[]> map=new HashMap<>();
		comArray=Othello.array;
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
					map.put(Othello.reverseCount,gyoretu);
				}
			}
		}
		if(map.size()>0) {
			Set<Integer> key=map.keySet();
			ArrayList<Integer> keyList=new ArrayList<>(key);
			Collections.sort(keyList,Collections.reverseOrder());
			Integer[] gyoretu=map.get(keyList.get(0));
			Othello.gyo=gyoretu[0]+1;
			Othello.retu=gyoretu[1]+1;
			System.out.println(Othello.gyo+" "+Othello.retu);
			Othello.kousin();
			Othello.reverse();
		}
		if(Othello.reverseCount==0) {
			System.out.println("パスしました。");
			if(Othello.turn==2) {
				System.out.println("黒のターンです");
			}else {
				System.out.println("白のターンです");
			}
		}
	}
	public static void othelloCom3() {
		HashMap<Integer,Integer[]> map=new HashMap<>();
		comArray=Othello.array;
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
					map.put(Othello.reverseCount,gyoretu);
				}
			}
		}
		if(map.size()>0) {
			Set<Integer> key=map.keySet();
			ArrayList<Integer> keyList=new ArrayList<>(key);
			ArrayList<Integer> kadList=new ArrayList<>();
			for(int k:keyList) {
				Integer[] gr=map.get(k);
				if((gr[0]==0&&gr[1]==0)||(gr[0]==0&&gr[1]==7)||(gr[0]==7&&gr[1]==0)||(gr[0]==7&&gr[1]==7)) {
					kadList.add(k);
				}
			}
			Collections.sort(kadList,Collections.reverseOrder());
			Collections.sort(keyList,Collections.reverseOrder());
			Integer[] gyoretu=new Integer[2];
			if(kadList.isEmpty()) {
				gyoretu=map.get(keyList.get(0));
			}else {
				gyoretu=map.get(kadList.get(0));
			}
			Othello.gyo=gyoretu[0]+1;
			Othello.retu=gyoretu[1]+1;
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
	public static void othelloCom4() {
		HashMap<Integer[],Integer> map=new HashMap<>();
		comArray=Othello.array;
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
		if(map.size()>0) {
			Set<Integer[]> key=map.keySet();
			ArrayList<Integer[]> keyList=new ArrayList<>(key);
			ArrayList<Integer[]> kadList=new ArrayList<>();
			ArrayList<Integer[]> arKadList=new ArrayList<>();
			for(Integer[] k:keyList) {
				if((k[0]==0&&k[1]==0)||(k[0]==0&&k[1]==7)||(k[0]==7&&k[1]==0)||(k[0]==7&&k[1]==7)) {
					kadList.add(k);
				}
				if((k[0]==0&&k[1]==1)||(k[0]==1&&k[1]==2)||(k[0]==1&&k[1]==1)
						||(k[0]==0&&k[1]==6)||(k[0]==1&&k[1]==6)||(k[0]==1&&k[1]==7)
						||(k[0]==6&&k[1]==0)||(k[0]==6&&k[1]==1)||(k[0]==7&&k[1]==1)
						||(k[0]==6&&k[1]==6)||(k[0]==6&&k[1]==7)||(k[0]==7&&k[1]==6)) {
					arKadList.add(k);
				}
			}
			if(kadList.isEmpty()) {
				if(Othello.turnCount>30) {
					Integer[] maxGr=new Integer[2];
					for(Integer[]k1:keyList) {
						for(Integer[]k2:keyList) {
							int bigger=Math.max(map.get(k1), map.get(k2));
							if(bigger==map.get(k1)) {
								maxGr=k1;
							}else {
								maxGr=k2;
							}
						}
						//break;
					}
					Othello.gyo=maxGr[0]+1;
					Othello.retu=maxGr[1]+1;
				}else {
					Integer[] minGr=new Integer[2];
					for(Integer[]k1:keyList) {
						for(Integer[]k2:keyList) {
							int smaller=Math.min(map.get(k1), map.get(k2));
							if(smaller==map.get(k1)) {
								minGr=k1;
							}else {
								minGr=k2;
							}
						}
						//break;
					}
					Othello.gyo=minGr[0]+1;
					Othello.retu=minGr[1]+1;
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
	public static void othelloCom5() {
		HashMap<Integer[],Integer> map=new HashMap<>();
		comArray=Othello.array;
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
		if(map.size()>0) {
			Set<Integer[]> key=map.keySet();
			ArrayList<Integer[]> keyList=new ArrayList<>(key);
			ArrayList<Integer[]> kadList=new ArrayList<>();
			ArrayList<Integer[]> arKadList=new ArrayList<>();
			for(Integer[] k:keyList) {
				if((k[0]==0&&k[1]==1)||(k[0]==1&&k[1]==0)||(k[0]==1&&k[1]==1)
						||(k[0]==0&&k[1]==6)||(k[0]==1&&k[1]==6)||(k[0]==1&&k[1]==7)
						||(k[0]==6&&k[1]==0)||(k[0]==6&&k[1]==1)||(k[0]==7&&k[1]==1)
						||(k[0]==6&&k[1]==6)||(k[0]==6&&k[1]==7)||(k[0]==7&&k[1]==6)) {
					arKadList.add(k);
					map.remove(k);
				}
			}
			key=map.keySet();
			keyList=new ArrayList<>(key);
			for(Integer[] k:keyList) {
				if((k[0]==0&&k[1]==0)||(k[0]==0&&k[1]==7)||(k[0]==7&&k[1]==0)||(k[0]==7&&k[1]==7)) {
					kadList.add(k);
				}

			}
			if(kadList.isEmpty()) {
				if(!keyList.isEmpty()) {
			if(Othello.turnCount>30) {
				Integer[] maxGr=new Integer[2];
				for(Integer[]k1:keyList) {
					for(Integer[]k2:keyList) {
						int bigger=Math.max(map.get(k1), map.get(k2));
						if(bigger==map.get(k1)) {
							maxGr=k1;
						}else {
							maxGr=k2;
						}
					}
					//break;
				}
				Othello.gyo=maxGr[0]+1;
				Othello.retu=maxGr[1]+1;
			}else {
				Integer[] minGr=new Integer[2];
				for(Integer[]k1:keyList) {
					for(Integer[]k2:keyList) {
						int smaller=Math.min(map.get(k1), map.get(k2));
						if(smaller==map.get(k1)) {
							minGr=k1;
						}else {
							minGr=k2;
						}
					}
					//break;
				}
				Othello.gyo=minGr[0]+1;
				Othello.retu=minGr[1]+1;
			}
				}else {
					Othello.gyo=arKadList.get(0)[0]+1;
					Othello.retu=arKadList.get(0)[1]+1;
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
	public static void othelloCom6() {
		HashMap<Integer[],Integer> map=new HashMap<>();
		comArray=Othello.array;
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
		if(map.size()>0) {
			Set<Integer[]> key=map.keySet();
			ArrayList<Integer[]> keyList=new ArrayList<>(key);
			ArrayList<Integer[]> kadList=new ArrayList<>();
			ArrayList<Integer[]> arKadList=new ArrayList<>();
			for(Integer[] k:keyList) {
				if((k[0]==0&&k[1]==1)||(k[0]==1&&k[1]==0)||(k[0]==1&&k[1]==1)
						||(k[0]==0&&k[1]==6)||(k[0]==1&&k[1]==6)||(k[0]==1&&k[1]==7)
						||(k[0]==6&&k[1]==0)||(k[0]==6&&k[1]==1)||(k[0]==7&&k[1]==1)
						||(k[0]==6&&k[1]==6)||(k[0]==6&&k[1]==7)||(k[0]==7&&k[1]==6)) {
					arKadList.add(k);
					map.remove(k);
				}
			}
			key=map.keySet();
			keyList=new ArrayList<>(key);
			for(Integer[] k:keyList) {
				if((k[0]==0&&k[1]==0)||(k[0]==0&&k[1]==7)||(k[0]==7&&k[1]==0)||(k[0]==7&&k[1]==7)) {
					kadList.add(k);
				}

			}
			if(kadList.isEmpty()) {
				if(!keyList.isEmpty()) {
					if(Othello.turnCount>37) {
						Integer[] maxGr=new Integer[2];
						for(Integer[]k1:keyList) {
							for(Integer[]k2:keyList) {
								int bigger=Math.max(map.get(k1), map.get(k2));
								if(bigger==map.get(k1)) {
									maxGr=k1;
								}else {
									maxGr=k2;
								}
							}
							break;
						}
						Othello.gyo=maxGr[0]+1;
						Othello.retu=maxGr[1]+1;
					}else {
						Integer[] minGr=new Integer[2];
						for(Integer[]k1:keyList) {
							for(Integer[]k2:keyList) {
								int smaller=Math.min(map.get(k1), map.get(k2));
								if(smaller==map.get(k1)) {
									minGr=k1;
								}else {
									minGr=k2;
								}
							}
							break;
						}
						Othello.gyo=minGr[0]+1;
						Othello.retu=minGr[1]+1;
					}
				}else {
					Othello.gyo=arKadList.get(0)[0]+1;
					Othello.retu=arKadList.get(0)[1]+1;
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
	public static void othelloCom7() {
		HashMap<Integer[],Integer> map=new HashMap<>();
		Set<Integer[]> key=map.keySet();
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
		if(map.size()>0) {
			ArrayList<Integer[]> keyList=new ArrayList<>(key);
			ArrayList<Integer[]> kadList=new ArrayList<>();
			ArrayList<Integer[]> arKadList=new ArrayList<>();
			ArrayList<Integer[]> lList=new ArrayList<>();
			comArray=Othello.array;
			for(Integer[] k:keyList) {
				if((k[0]==0&&k[1]==1)||(k[0]==1&&k[1]==0)||(k[0]==1&&k[1]==1)
						||(k[0]==0&&k[1]==6)||(k[0]==1&&k[1]==6)||(k[0]==1&&k[1]==7)
						||(k[0]==6&&k[1]==0)||(k[0]==6&&k[1]==1)||(k[0]==7&&k[1]==1)
						||(k[0]==6&&k[1]==6)||(k[0]==6&&k[1]==7)||(k[0]==7&&k[1]==6)) {
					arKadList.add(k);
					map.remove(k);
				}
			}
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
			key=map.keySet();
			keyList=new ArrayList<>(key);
			for(Integer[] k:keyList) {
				if((k[0]==0&&k[1]==0)||(k[0]==0&&k[1]==7)||(k[0]==7&&k[1]==0)||(k[0]==7&&k[1]==7)) {
					kadList.add(k);
				}

			}
			if(kadList.isEmpty()) {
				if(!lList.isEmpty()) {
					if(Othello.turnCount>22) {
						Integer[] maxGr=new Integer[2];
						for(Integer[]k1:lList) {
							for(Integer[]k2:lList) {
								int bigger=Math.max(map.get(k1), map.get(k2));
								if(bigger==map.get(k1)) {
									maxGr=k1;
								}else {
									maxGr=k2;
								}
							}
							//break;
						}
						Othello.gyo=maxGr[0]+1;
						Othello.retu=maxGr[1]+1;
					}else {
						Integer[] minGr=new Integer[2];
						for(Integer[]k1:lList) {
							for(Integer[]k2:lList) {
								int smaller=Math.min(map.get(k1), map.get(k2));
								if(smaller==map.get(k1)) {
									minGr=k1;
								}else {
									minGr=k2;
								}
							}
							//break;
						}
						Othello.gyo=minGr[0]+1;
						Othello.retu=minGr[1]+1;
					}
				}
				else if(!keyList.isEmpty()) {
					if(Othello.turnCount>30) {
						Integer[] maxGr=new Integer[2];
						for(Integer[]k1:keyList) {
							for(Integer[]k2:keyList) {
								int bigger=Math.max(map.get(k1), map.get(k2));
								if(bigger==map.get(k1)) {
									maxGr=k1;
								}else {
									maxGr=k2;
								}
							}
							//break;
						}
						Othello.gyo=maxGr[0]+1;
						Othello.retu=maxGr[1]+1;
					}else {
						Integer[] minGr=new Integer[2];
						for(Integer[]k1:keyList) {
							for(Integer[]k2:keyList) {
								int smaller=Math.min(map.get(k1), map.get(k2));
								if(smaller==map.get(k1)) {
									minGr=k1;
								}else {
									minGr=k2;
								}
							}
							//break;
						}
						Othello.gyo=minGr[0]+1;
						Othello.retu=minGr[1]+1;
					}
				}else {
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
					}else {

					}
					Othello.gyo=arKadList.get(i)[0]+1;
					Othello.retu=arKadList.get(i)[1]+1;
					}
					if(Othello.turn==1) {
						Othello.turn=2;
					}else if(Othello.turn==2) {
						Othello.turn=1;
					}
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
	public static void othelloCom8() {
		HashMap<Integer[],Integer> map=new HashMap<>();

		comArray=Othello.array;
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
		if(map.size()>0) {
			Set<Integer[]> key=map.keySet();
			ArrayList<Integer[]> keyList=new ArrayList<>(key);
			ArrayList<Integer[]> kadList=new ArrayList<>();
			ArrayList<Integer[]> arKadList=new ArrayList<>();
			ArrayList<Integer[]> lList=new ArrayList<>();
			for(Integer[] k:keyList) {
				if((k[0]==0&&k[1]==1)||(k[0]==1&&k[1]==0)||(k[0]==1&&k[1]==1)
						||(k[0]==0&&k[1]==6)||(k[0]==1&&k[1]==6)||(k[0]==1&&k[1]==7)
						||(k[0]==6&&k[1]==0)||(k[0]==6&&k[1]==1)||(k[0]==7&&k[1]==1)
						||(k[0]==6&&k[1]==6)||(k[0]==6&&k[1]==7)||(k[0]==7&&k[1]==6)) {
					arKadList.add(k);
					map.remove(k);
				}
			}
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
			key=map.keySet();
			keyList=new ArrayList<>(key);
			for(Integer[] k:keyList) {
				if((k[0]==0&&k[1]==0)||(k[0]==0&&k[1]==7)||(k[0]==7&&k[1]==0)||(k[0]==7&&k[1]==7)) {
					kadList.add(k);
				}

			}
			if(kadList.isEmpty()) {
				if(!lList.isEmpty()) {
					if(Othello.turnCount>22) {
						int max=0;
						Integer[] maxGr=new Integer[2];
						for(Integer[]k1:lList) {
							for(Integer[]k2:lList) {
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
							//break;
						}
						Othello.gyo=maxGr[0]+1;
						Othello.retu=maxGr[1]+1;
					}else {
						Integer[] minGr=new Integer[2];
						int min=50;
						for(Integer[]k1:lList) {
							for(Integer[]k2:lList) {
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
							//break;
						}
						Othello.gyo=minGr[0]+1;
						Othello.retu=minGr[1]+1;
					}
				}
				else if(!keyList.isEmpty()) {
					if(Othello.turnCount>40) {
						int max=0;
						Integer[] maxGr=new Integer[2];
						for(Integer[]k1:keyList) {
							for(Integer[]k2:keyList) {
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
							//break;
						}
						Othello.gyo=maxGr[0]+1;
						Othello.retu=maxGr[1]+1;
					}else {
						Integer[] minGr=new Integer[2];
						int min=50;
						for(Integer[]k1:keyList) {
							for(Integer[]k2:keyList) {
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
							//break;
						}
						Othello.gyo=minGr[0]+1;
						Othello.retu=minGr[1]+1;
					}
				}else {
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
					}else {

					}
					Othello.gyo=arKadList.get(i)[0]+1;
					Othello.retu=arKadList.get(i)[1]+1;
					}
					if(Othello.turn==1) {
						Othello.turn=2;
					}else if(Othello.turn==2) {
						Othello.turn=1;
					}
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
	public static void othelloCom9() {
		HashMap<Integer[],Integer> map=new HashMap<>();

		comArray=Othello.array;
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
		if(map.size()>0) {
			Set<Integer[]> key=map.keySet();
			ArrayList<Integer[]> keyList=new ArrayList<>(key);
			ArrayList<Integer[]> kadList=new ArrayList<>();
			ArrayList<Integer[]> arKadList=new ArrayList<>();
			ArrayList<Integer[]> lList=new ArrayList<>();
			for(Integer[] k:keyList) {
				if((k[0]==0&&k[1]==1)||(k[0]==1&&k[1]==0)||(k[0]==1&&k[1]==1)
						||(k[0]==0&&k[1]==6)||(k[0]==1&&k[1]==6)||(k[0]==1&&k[1]==7)
						||(k[0]==6&&k[1]==0)||(k[0]==6&&k[1]==1)||(k[0]==7&&k[1]==1)
						||(k[0]==6&&k[1]==6)||(k[0]==6&&k[1]==7)||(k[0]==7&&k[1]==6)) {
					arKadList.add(k);
					map.remove(k);
				}
			}
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
			key=map.keySet();
			keyList=new ArrayList<>(key);
			for(Integer[] k:keyList) {
				if((k[0]==0&&k[1]==0)||(k[0]==0&&k[1]==7)||(k[0]==7&&k[1]==0)||(k[0]==7&&k[1]==7)) {
					kadList.add(k);
				}

			}
			if(kadList.isEmpty()) {
				if(!lList.isEmpty()) {
					if(Othello.turnCount>37) {
						int max=0;
						Integer[] maxGr=new Integer[2];
						for(Integer[]k1:lList) {
							for(Integer[]k2:lList) {
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
							//break;
						}
						Othello.gyo=maxGr[0]+1;
						Othello.retu=maxGr[1]+1;
					}else {
						Integer[] minGr=new Integer[2];
						int min=50;
						for(Integer[]k1:lList) {
							for(Integer[]k2:lList) {
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
							//break;
						}
						Othello.gyo=minGr[0]+1;
						Othello.retu=minGr[1]+1;
					}
				}
				else if(!keyList.isEmpty()) {
					if(Othello.turnCount>34) {
						int max=0;
						Integer[] maxGr=new Integer[2];
						for(Integer[]k1:keyList) {
							for(Integer[]k2:keyList) {
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
							//break;
						}
						Othello.gyo=maxGr[0]+1;
						Othello.retu=maxGr[1]+1;
					}else {
						Integer[] minGr=new Integer[2];
						int min=50;
						for(Integer[]k1:keyList) {
							for(Integer[]k2:keyList) {
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
							//break;
						}
						Othello.gyo=minGr[0]+1;
						Othello.retu=minGr[1]+1;
					}
				}else {
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
					}else {

					}
					Othello.gyo=arKadList.get(i)[0]+1;
					Othello.retu=arKadList.get(i)[1]+1;
					}
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

}




