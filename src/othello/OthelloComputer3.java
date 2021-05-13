package othello;

import java.util.ArrayList;

public class OthelloComputer3 {
	public static int[][] vBanmen;
	static ArrayList<ArrayList<Integer>>canPut=null;
	static ArrayList<Integer[]> keyList;
	static ArrayList<ArrayList<Integer>> kadList;
	static ArrayList<ArrayList<Integer>> arKadList;
	static ArrayList<ArrayList<Integer>> lList;
	static ArrayList<ArrayList<Integer>> octagonList;
	static ArrayList<ArrayList<Integer>> arOctagonList;

	public static int[] othelloCom37(OthelloJSP othello) {
		int[] gyoretu=new int[2];
		canPut=new ArrayList<>();
		kadList=new ArrayList<>();
		arKadList=new ArrayList<>();
		vBanmen=othello.getVBanmen();
		canPut=othello.vReverse();
		kadListAdd();
		arkadListAdd(othello);
		if(!kadList.isEmpty()) {
			//System.out.println("kad");
			int gyo=kadList.get(0).get(0);
			int retu=kadList.get(0).get(1);
			othello.getBanmen()[gyo][retu]=othello.getTurn();
			othello.reverse(gyo,retu);
			gyoretu[0]=gyo;
			gyoretu[1]=retu;
		}else if(!canPut.isEmpty()){
			//System.out.println("normal");
			if(othello.getTurnCount()<40) {
				ArrayList<ArrayList<Integer>>minList=listMin(canPut);
				int gyo=minList.get(0).get(0);
				int retu=minList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}else {
				ArrayList<ArrayList<Integer>>maxList=listMax(canPut);
				int gyo=maxList.get(0).get(0);
				int retu=maxList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}
		}else if(!arKadList.isEmpty()){
			//System.out.println("arkad");
			ArrayList<ArrayList<Integer>>safeList=arKadForecast(othello);
			int gyo;
			int retu;
			if(!safeList.isEmpty()) {
				gyo=safeList.get(0).get(0);
				retu=safeList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}else {
				gyo=arKadList.get(0).get(0);
				retu=arKadList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}
		}else {
			othello.updateTurn();
			othello.plusPassCount();
			return null;
		}
		othello.updateTurn();
		othello.setPassCount(0);
		return gyoretu;

	}

	public static int[] othelloCom38(OthelloJSP othello) {
		int[] gyoretu=new int[2];
		canPut=new ArrayList<>();
		kadList=new ArrayList<>();
		arKadList=new ArrayList<>();
		lList=new ArrayList<>();
		vBanmen=othello.getVBanmen();
		canPut=othello.vReverse();
		kadListAdd();
		arkadListAdd(othello);
		if(!kadList.isEmpty()) {
			//System.out.println("kad");
			int gyo=kadList.get(0).get(0);
			int retu=kadList.get(0).get(1);
			othello.getBanmen()[gyo][retu]=othello.getTurn();
			othello.reverse(gyo,retu);
			gyoretu[0]=gyo;
			gyoretu[1]=retu;
		}else if(!canPut.isEmpty()){
			//System.out.println("normal");
			if(othello.getTurnCount()<40) {
				ArrayList<ArrayList<Integer>>minList=listMin(canPut);
				int gyo=minList.get(0).get(0);
				int retu=minList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}else {
				ArrayList<ArrayList<Integer>>maxList=listMax(canPut);
				int gyo=maxList.get(0).get(0);
				int retu=maxList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}
		}else if(!arKadList.isEmpty()){
			//System.out.println("arkad");
			ArrayList<ArrayList<Integer>>safeList=arKadForecast(othello);
			int gyo;
			int retu;
			if(!safeList.isEmpty()) {
				gyo=safeList.get(0).get(0);
				retu=safeList.get(0).get(1);
				for(ArrayList<Integer>safe:safeList) {
					gyo=safe.get(0);
					retu=safe.get(1);
					if((gyo==1&&retu==1)||(gyo==1&&retu==6)||(gyo==6&&retu==1)||(gyo==6&&retu==6)) {
						continue;
					}else {
						break;
					}
				}
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}else {
				gyo=arKadList.get(0).get(0);
				retu=arKadList.get(0).get(1);
				for(ArrayList<Integer>arkad:arKadList) {
					gyo=arkad.get(0);
					retu=arkad.get(1);
					if((gyo==1&&retu==1)||(gyo==1&&retu==6)||(gyo==6&&retu==1)||(gyo==6&&retu==6)) {
						continue;
					}else {
						break;
					}
				}
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}
		}else {
			othello.updateTurn();
			othello.plusPassCount();
			return null;
		}
		othello.updateTurn();
		othello.setPassCount(0);
		return gyoretu;

	}
	public static int[] othelloCom39(OthelloJSP othello) {
		int[] gyoretu=new int[2];
		canPut=new ArrayList<>();
		kadList=new ArrayList<>();
		octagonList=new ArrayList<>();
		arKadList=new ArrayList<>();
		//arOctagonList=new ArrayList<>();
		vBanmen=othello.getVBanmen();
		canPut=othello.vReverse();
		kadListAdd();
		octagonListAdd();
		arkadListAdd(othello);
		//arOctagonListAdd(othello);
		if(!kadList.isEmpty()) {
			//System.out.println("kad");
			int gyo=kadList.get(0).get(0);
			int retu=kadList.get(0).get(1);
			othello.getBanmen()[gyo][retu]=othello.getTurn();
			othello.reverse(gyo,retu);
			gyoretu[0]=gyo;
			gyoretu[1]=retu;
		}else if(!octagonList.isEmpty()) {
			if(othello.getTurnCount()<44) {
				ArrayList<ArrayList<Integer>>minList=listMin(octagonList);
				int gyo=minList.get(0).get(0);
				int retu=minList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}else {
				ArrayList<ArrayList<Integer>>maxList=listMin(octagonList);
				int gyo=maxList.get(0).get(0);
				int retu=maxList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}
		}
		else if(!canPut.isEmpty()){
			//System.out.println("normal");
			if(othello.getTurnCount()<40) {
				ArrayList<ArrayList<Integer>>nakawari=nakawari(canPut,othello.getVBanmen());
				ArrayList<ArrayList<Integer>>minList=listMin(nakawari);
				int gyo=minList.get(0).get(0);
				int retu=minList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}else {
				ArrayList<ArrayList<Integer>>nakawari=nakawari(canPut,othello.getVBanmen());
				ArrayList<ArrayList<Integer>>maxList=listMax(nakawari);
				int gyo=maxList.get(0).get(0);
				int retu=maxList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}
		/*}else if(!arOctagonList.isEmpty()) {
			if(othello.getTurnCount()<40) {
				ArrayList<ArrayList<Integer>>minList=listMin(arOctagonList);
				int gyo=minList.get(0).get(0);
				int retu=minList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}else {
				ArrayList<ArrayList<Integer>>maxList=listMax(arOctagonList);
				int gyo=maxList.get(0).get(0);
				int retu=maxList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}*/
		}else if(!arKadList.isEmpty()){
			//System.out.println("arkad");
			ArrayList<ArrayList<Integer>>safeList=arKadForecast(othello);
			int gyo;
			int retu;
			if(!safeList.isEmpty()) {
				ArrayList<Integer>array=avoidRedZone(safeList);
				gyo=array.get(0);
				retu=array.get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}else {
				ArrayList<Integer>array=avoidRedZone(arKadList);
				gyo=array.get(0);
				retu=array.get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}
		}else {
			othello.updateTurn();
			othello.plusPassCount();
			return null;
		}
		othello.updateTurn();
		othello.setPassCount(0);
		return gyoretu;

	}

	public static int[] othelloCom310(OthelloJSP othello) {
		int[] gyoretu=new int[2];
		canPut=new ArrayList<>();
		kadList=new ArrayList<>();
		octagonList=new ArrayList<>();
		arKadList=new ArrayList<>();
		//arOctagonList=new ArrayList<>();
		//if(othello.getTurnCount()>36) {
		canPut=othello.vReverse();
		canPut=othelloCom00(othello,canPut,"0");
		System.out.print("turnCount:"+othello.getTurnCount()+"  canWin:[");
		for(ArrayList<Integer>put:canPut) {
			System.out.print("["+put.get(0)+" "+put.get(1)+"],");
		}
		System.out.println("]");
		if(canPut.isEmpty()){
		vBanmen=othello.getVBanmen();
		canPut=othello.vReverse();
		}
		kadListAdd();
		octagonListAdd();
		arkadListAdd(othello);
		if(!kadList.isEmpty()) {
			//System.out.println("kad");
			ArrayList<ArrayList<Integer>>maxList=new ArrayList<>();
			maxList=listMax(kadList);
			int gyo=maxList.get(0).get(0);
			int retu=maxList.get(0).get(1);
			othello.getBanmen()[gyo][retu]=othello.getTurn();
			othello.reverse(gyo,retu);
			gyoretu[0]=gyo;
			gyoretu[1]=retu;
		}else if(!octagonList.isEmpty()) {
			if(othello.getTurnCount()<44) {
				ArrayList<ArrayList<Integer>>minList=listMin(octagonList);
				int gyo=minList.get(0).get(0);
				int retu=minList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}else {
				ArrayList<ArrayList<Integer>>maxList=listMin(octagonList);
				int gyo=maxList.get(0).get(0);
				int retu=maxList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}
		}
		else if(!canPut.isEmpty()){
			//System.out.println("normal");
			if(othello.getTurnCount()<40) {
				ArrayList<ArrayList<Integer>>nakawari=nakawari(canPut,othello.getVBanmen());
				ArrayList<ArrayList<Integer>>minList=listMin(nakawari);
				int gyo=minList.get(0).get(0);
				int retu=minList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}else {
				ArrayList<ArrayList<Integer>>nakawari=nakawari(canPut,othello.getVBanmen());
				ArrayList<ArrayList<Integer>>maxList=listMax(nakawari);
				int gyo=maxList.get(0).get(0);
				int retu=maxList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}

		}else if(!arKadList.isEmpty()){
			//System.out.println("arkad");
			ArrayList<ArrayList<Integer>>safeList=arKadForecast(othello);
			int gyo;
			int retu;
			if(!safeList.isEmpty()) {
				ArrayList<Integer>array=avoidRedZone(safeList);
				gyo=array.get(0);
				retu=array.get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}else {
				ArrayList<Integer>array=avoidRedZone(arKadList);
				gyo=array.get(0);
				retu=array.get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}
		}else {
			othello.updateTurn();
			othello.plusPassCount();
			return null;
		}
		othello.updateTurn();
		othello.setPassCount(0);
		return gyoretu;
	}

	public static int[] othelloCom311(OthelloJSP othello) {
		int[] gyoretu=new int[2];
		int gyo=0;
		int retu=0;
		canPut=new ArrayList<>();
		kadList=new ArrayList<>();
		octagonList=new ArrayList<>();
		arKadList=new ArrayList<>();
		//arOctagonList=new ArrayList<>();
		//if(othello.getTurnCount()>36) {
		canPut=othello.vReverse();
		canPut=othelloCom00(othello,canPut,"0");
		System.out.print("turnCount:"+othello.getTurnCount()+"  canWin:[");
		for(ArrayList<Integer>put:canPut) {
			System.out.print("["+put.get(0)+" "+put.get(1)+"],");
		}
		System.out.println("]");
		if(!canPut.isEmpty()) {
			gyo=canPut.get(0).get(0);
			retu=canPut.get(0).get(1);
		}
		if(canPut.isEmpty()||gyo==0&&retu==1||gyo==1&&retu==1||gyo==1&&retu==0||
				gyo==6&&retu==0||gyo==6&&retu==1||gyo==7&&retu==1||
				gyo==6&&retu==7||gyo==6&&retu==6||gyo==7&&retu==6||
				gyo==0&&retu==6||gyo==1&&retu==6||gyo==1&&retu==7){
		vBanmen=othello.getVBanmen();
		canPut=othello.vReverse();
		}
		kadListAdd();
		octagonListAdd();
		arkadListAdd(othello);
		if(!kadList.isEmpty()) {
			//System.out.println("kad");
			ArrayList<ArrayList<Integer>>maxList=new ArrayList<>();
			maxList=listMax(kadList);
			gyo=maxList.get(0).get(0);
			retu=maxList.get(0).get(1);
			othello.getBanmen()[gyo][retu]=othello.getTurn();
			othello.reverse(gyo,retu);
			gyoretu[0]=gyo;
			gyoretu[1]=retu;
		}else if(!octagonList.isEmpty()) {
			if(othello.getTurnCount()<44) {
				ArrayList<ArrayList<Integer>>minList=listMin(octagonList);
				gyo=minList.get(0).get(0);
				retu=minList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}else {
				ArrayList<ArrayList<Integer>>maxList=listMin(octagonList);
				gyo=maxList.get(0).get(0);
				retu=maxList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}
		}
		else if(!canPut.isEmpty()){
			//System.out.println("normal");
			if(othello.getTurnCount()<40) {
				ArrayList<ArrayList<Integer>>nakawari=nakawari(canPut,othello.getVBanmen());
				ArrayList<ArrayList<Integer>>minList=listMin(nakawari);
				gyo=minList.get(0).get(0);
				retu=minList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}else {
				ArrayList<ArrayList<Integer>>nakawari=nakawari(canPut,othello.getVBanmen());
				ArrayList<ArrayList<Integer>>maxList=listMax(nakawari);
				gyo=maxList.get(0).get(0);
				retu=maxList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}

		}else if(!arKadList.isEmpty()){
			//System.out.println("arkad");
			ArrayList<ArrayList<Integer>>safeList=arKadForecast(othello);
			if(!safeList.isEmpty()) {
				ArrayList<Integer>array=avoidRedZone(safeList);
				gyo=array.get(0);
				retu=array.get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}else {
				ArrayList<Integer>array=avoidRedZone(arKadList);
				gyo=array.get(0);
				retu=array.get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}
		}else {
			othello.updateTurn();
			othello.plusPassCount();
			return null;
		}
		othello.updateTurn();
		othello.setPassCount(0);
		return gyoretu;
	}

	public static int[] othelloCom312(OthelloJSP othello) {
		int[] gyoretu=new int[2];
		int gyo=0;
		int retu=0;
		canPut=new ArrayList<>();
		kadList=new ArrayList<>();
		octagonList=new ArrayList<>();
		arKadList=new ArrayList<>();
		//arOctagonList=new ArrayList<>();
		//if(othello.getTurnCount()>36) {
		if(othello.getTurnCount()>=0) {
			canPut=othello.vReverse();
			canPut=othelloCom00(othello,canPut,"0");
		System.out.print("turnCount:"+othello.getTurnCount()+"  canWin:[");
		for(ArrayList<Integer>put:canPut) {
			System.out.print("["+put.get(0)+" "+put.get(1)+"],");
		}
		System.out.println("]");
		}
		if(!canPut.isEmpty()&&canPut.size()==1) {
			gyo=canPut.get(0).get(0);
			retu=canPut.get(0).get(1);
		}
		canPut=kadForecast(othello,canPut);
		if(canPut.isEmpty()/*||gyo==0&&retu==1||gyo==1&&retu==1||gyo==1&&retu==0||
				gyo==6&&retu==0||gyo==6&&retu==1||gyo==7&&retu==1||
				gyo==6&&retu==7||gyo==6&&retu==6||gyo==7&&retu==6||
				gyo==0&&retu==6||gyo==1&&retu==6||gyo==1&&retu==7*/){
		vBanmen=othello.getVBanmen();
		canPut=othello.vReverse();
		}
		kadListAdd();
		octagonListAdd();
		arkadListAdd(othello);
		if(!kadList.isEmpty()) {
			//System.out.println("kad");
			ArrayList<ArrayList<Integer>>maxList=new ArrayList<>();
			maxList=listMax(kadList);
			gyo=maxList.get(0).get(0);
			retu=maxList.get(0).get(1);
			othello.getBanmen()[gyo][retu]=othello.getTurn();
			othello.reverse(gyo,retu);
			gyoretu[0]=gyo;
			gyoretu[1]=retu;
		}else if(!octagonList.isEmpty()) {
			if(othello.getTurnCount()<44) {
				ArrayList<ArrayList<Integer>>minList=listMin(octagonList);
				gyo=minList.get(0).get(0);
				retu=minList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}else {
				ArrayList<ArrayList<Integer>>maxList=listMin(octagonList);
				gyo=maxList.get(0).get(0);
				retu=maxList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}
		}
		else if(!canPut.isEmpty()){
			//System.out.println("normal");
			if(othello.getTurnCount()<40) {
				ArrayList<ArrayList<Integer>>nakawari=nakawari(canPut,othello.getVBanmen());
				ArrayList<ArrayList<Integer>>minList=listMin(nakawari);
				gyo=minList.get(0).get(0);
				retu=minList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}else {
				ArrayList<ArrayList<Integer>>nakawari=nakawari(canPut,othello.getVBanmen());
				ArrayList<ArrayList<Integer>>maxList=listMax(nakawari);
				gyo=maxList.get(0).get(0);
				retu=maxList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}

		}else if(!arKadList.isEmpty()){
			//System.out.println("arkad");
			ArrayList<ArrayList<Integer>>safeList=arKadForecast(othello);
			if(!safeList.isEmpty()) {
				ArrayList<Integer>array=avoidRedZone(safeList);
				gyo=array.get(0);
				retu=array.get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}else {
				ArrayList<Integer>array=avoidRedZone(arKadList);
				gyo=array.get(0);
				retu=array.get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}
		}else {
			othello.updateTurn();
			othello.plusPassCount();
			return null;
		}
		othello.updateTurn();
		othello.setPassCount(0);
		return gyoretu;
	}

	public static int[] othelloCom313(OthelloJSP othello) {
		int[] gyoretu=new int[2];
		int gyo=0;
		int retu=0;
		canPut=new ArrayList<>();
		kadList=new ArrayList<>();
		octagonList=new ArrayList<>();
		arKadList=new ArrayList<>();
		//arOctagonList=new ArrayList<>();
		vBanmen=othello.getVBanmen();
		canPut=othello.vReverse();
		/*int maxLength=0;
		ArrayList<ArrayList<Integer>>lengthList=new ArrayList<>();
		for(ArrayList<Integer>put:canPut) {
			vBanmen=othello.getVBanmen();
			int g=put.get(0);
			int r=put.get(1);
			int canPutLength=getCanPutLength(othello,g,r,vBanmen,false);
			put.add(canPutLength);
			lengthList.add(put);
			if(canPutLength>maxLength) {
				maxLength=canPutLength;
			}
		}
		canPut=new ArrayList<>();
		for(ArrayList<Integer>l:lengthList) {
			if(l.get(3)==maxLength) {
				canPut.add(l);
			}
		}
		System.out.print("maxLength:"+maxLength+"canPut:[");
		for(ArrayList<Integer>put:canPut) {
			System.out.print("["+put.get(0)+" "+put.get(1)+"],");
		}
		System.out.println("]");*/
		int minLength=30;
		ArrayList<ArrayList<Integer>>lengthList=new ArrayList<>();
		for(ArrayList<Integer>put:canPut) {
			vBanmen=othello.getVBanmen();
			int g=put.get(0);
			int r=put.get(1);
			int canPutLength=getCanPutLength(othello,g,r,vBanmen,true);
			put.add(canPutLength);
			lengthList.add(put);
			if(canPutLength<minLength) {
				minLength=canPutLength;
			}
		}
		canPut=new ArrayList<>();
		for(ArrayList<Integer>l:lengthList) {
			if(l.get(3)==minLength) {
				canPut.add(l);
			}
		}
		System.out.print("minLength:"+minLength+"canPut:[");
		for(ArrayList<Integer>put:canPut) {
			System.out.print("["+put.get(0)+" "+put.get(1)+"],");
		}
		System.out.println("]");
		if(!canPut.isEmpty()&&canPut.size()==1) {
			gyo=canPut.get(0).get(0);
			retu=canPut.get(0).get(1);
		}
		canPut=kadForecast(othello,canPut);
		if(canPut.isEmpty()/*||gyo==0&&retu==1||gyo==1&&retu==1||gyo==1&&retu==0||
				gyo==6&&retu==0||gyo==6&&retu==1||gyo==7&&retu==1||
				gyo==6&&retu==7||gyo==6&&retu==6||gyo==7&&retu==6||
				gyo==0&&retu==6||gyo==1&&retu==6||gyo==1&&retu==7*/
				) {
			canPut=othello.vReverse();
		}
		kadListAdd();
		octagonListAdd();
		arkadListAdd(othello);
		if(!kadList.isEmpty()) {
			gyo=kadList.get(0).get(0);
			retu=kadList.get(0).get(1);
			othello.getBanmen()[gyo][retu]=othello.getTurn();
			othello.reverse(gyo,retu);
			gyoretu[0]=gyo;
			gyoretu[1]=retu;
		}else if(!octagonList.isEmpty()) {
			if(othello.getTurnCount()<44) {
				ArrayList<ArrayList<Integer>>minList=listMin(octagonList);
				gyo=minList.get(0).get(0);
				retu=minList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}else {
				ArrayList<ArrayList<Integer>>maxList=listMin(octagonList);
				gyo=maxList.get(0).get(0);
				retu=maxList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}
		}
		else if(!canPut.isEmpty()){
			if(othello.getTurnCount()<40) {
				ArrayList<ArrayList<Integer>>nakawari=nakawari(canPut,othello.getVBanmen());
				ArrayList<ArrayList<Integer>>minList=listMin(nakawari);
				gyo=minList.get(0).get(0);
				retu=minList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}else {
				ArrayList<ArrayList<Integer>>nakawari=nakawari(canPut,othello.getVBanmen());
				ArrayList<ArrayList<Integer>>maxList=listMax(nakawari);
				gyo=maxList.get(0).get(0);
				retu=maxList.get(0).get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}
		}else if(!arKadList.isEmpty()){
			ArrayList<ArrayList<Integer>>safeList=arKadForecast(othello);
			if(!safeList.isEmpty()) {
				ArrayList<Integer>array=avoidRedZone(safeList);
				gyo=array.get(0);
				retu=array.get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}else {
				ArrayList<Integer>array=avoidRedZone(arKadList);
				gyo=array.get(0);
				retu=array.get(1);
				othello.getBanmen()[gyo][retu]=othello.getTurn();
				othello.reverse(gyo,retu);
				gyoretu[0]=gyo;
				gyoretu[1]=retu;
			}
		}else {
			othello.updateTurn();
			othello.plusPassCount();
			return null;
		}
		othello.updateTurn();
		othello.setPassCount(0);
		return gyoretu;

	}

	public static int[] othelloCom314(OthelloJSP othello) {
		return null;
	}

	public static ArrayList<ArrayList<Integer>>othelloCom00(OthelloJSP othello,
			ArrayList<ArrayList<Integer>>canPut,String com){
		int turn=othello.getTurn();
		int[][]banmen=new int[8][8];
		ArrayList<ArrayList<Integer>>canWin=new ArrayList<>();
		ArrayList<ArrayList<Integer>>maxList=new ArrayList<>();
			int blackMax=0;
			int whiteMax=0;
			for(ArrayList<Integer>put:canPut) {
				othello.setTurn(turn);
				int gyo=put.get(0);
				int retu=put.get(1);
				for(int i=0;i<8;i++) {
					for(int j=0;j<8;j++) {
						banmen[i][j]=othello.getVBanmen()[i][j];
					}
				}
				banmen[gyo][retu]=turn;
				banmen=othello.vReverse(gyo, retu, banmen);
				for(int i=0;i<8;i++) {
					for(int j=0;j<8;j++) {
						banmen[i][j]=othello.vReverse(gyo, retu, banmen)[i][j];
					}
				}
				othello.updateTurn();
				int whileCount=0;
				while(true) {
					whileCount++;
					for(int i=0;i<8;i++) {
						for(int j=0;j<8;j++) {
							if(com.equals("0")) {
								banmen[i][j]=othelloCom0(othello,banmen)[i][j];
							}else if(com.equals("X13")) {
								banmen[i][j]=othelloComX13(othello,banmen)[i][j];
							}
						}
					}
					/*if(whileCount>70) {
						break;
					}*/
					if(othello.none0(banmen)||othello.getPassCount()>=2||othello.all(banmen)||whileCount>70) {
						if(othello.none0(banmen)) {
							System.out.println("none0");
						}else if(othello.getPassCount()>=2) {
							System.out.println("passCount");
						}else if(whileCount>70) {
							System.out.println("whileCount");
						}
						int[] bw=othello.result(banmen);
						int black=bw[0];
						int white=bw[1];
						System.out.println("black:"+black+"white:"+white);
						othello.vBanmenhyoji(banmen);
						if(turn==1&&black>=blackMax) {
							blackMax=black;
							put.add(black);
							maxList.add(put);
						}else if(turn==2&&white>=whiteMax) {
							whiteMax=white;
							put.add(white);
							maxList.add(put);
						}
						if((turn==1&&black>=white)||(turn==2&&black<=white)) {
							/*put.add(reverseCount);
							canWin.add(put);*/
						}
						othello.setPassCount(0);
						break;
					}
				}
			}
			for(ArrayList<Integer>max:maxList) {
				if((turn==1&&max.get(3)==blackMax)||(turn==2&&max.get(3)==whiteMax)) {
					canWin.add(max);
				}
			}
			if(turn==1) {
				System.out.println("blackMax:"+blackMax);
			}else if(turn==2) {
				System.out.println("whiteMax:"+whiteMax);
			}
			othello.setTurn(turn);
			return canWin;

	}

	public static int[][] othelloCom0(OthelloJSP othello,int[][]banmen) {
		canPut=new ArrayList<>();
		kadList=new ArrayList<>();
		octagonList=new ArrayList<>();
		arKadList=new ArrayList<>();
		canPut=othello.vReverse(banmen);
		kadListAdd();
		octagonListAdd();
		arkadListAdd(othello);
		if(!kadList.isEmpty()) {
			int gyo=kadList.get(0).get(0);
			int retu=kadList.get(0).get(1);
			banmen[gyo][retu]=othello.getTurn();
			banmen=othello.vReverse(gyo,retu,banmen);

		}else if(!octagonList.isEmpty()) {
			if(othello.getTurnCount()<44) {
				ArrayList<ArrayList<Integer>>minList=listMin(octagonList);
				int gyo=minList.get(0).get(0);
				int retu=minList.get(0).get(1);
				banmen[gyo][retu]=othello.getTurn();
				banmen=othello.vReverse(gyo,retu,banmen);
			}else {
				ArrayList<ArrayList<Integer>>maxList=listMin(octagonList);
				int gyo=maxList.get(0).get(0);
				int retu=maxList.get(0).get(1);
				banmen[gyo][retu]=othello.getTurn();
				banmen=othello.vReverse(gyo,retu,banmen);
			}
		}
		else if(!canPut.isEmpty()){
			if(othello.getTurnCount()<40) {
				ArrayList<ArrayList<Integer>>nakawari=nakawari(canPut,othello.getVBanmen());
				ArrayList<ArrayList<Integer>>minList=listMin(nakawari);
				int gyo=minList.get(0).get(0);
				int retu=minList.get(0).get(1);
				banmen[gyo][retu]=othello.getTurn();
				banmen=othello.vReverse(gyo,retu,banmen);
			}else {
				ArrayList<ArrayList<Integer>>nakawari=nakawari(canPut,othello.getVBanmen());
				ArrayList<ArrayList<Integer>>maxList=listMax(nakawari);
				int gyo=maxList.get(0).get(0);
				int retu=maxList.get(0).get(1);
				banmen[gyo][retu]=othello.getTurn();
				banmen=othello.vReverse(gyo,retu,banmen);
			}
		}else if(!arKadList.isEmpty()){
			ArrayList<ArrayList<Integer>>safeList=arKadForecast(othello);
			int gyo;
			int retu;
			if(!safeList.isEmpty()) {
				ArrayList<Integer>array=avoidRedZone(safeList);
				gyo=array.get(0);
				retu=array.get(1);
				banmen[gyo][retu]=othello.getTurn();
				banmen=othello.vReverse(gyo,retu,banmen);
			}else {
				ArrayList<Integer>array=avoidRedZone(arKadList);
				gyo=array.get(0);
				retu=array.get(1);
				banmen[gyo][retu]=othello.getTurn();
				banmen=othello.vReverse(gyo,retu,banmen);
			}
		}else {
			othello.updateTurn();
			othello.plusPassCount();
			return banmen;
		}
		othello.updateTurn();
		othello.setPassCount(2);
		return banmen;
	}

	public static int[][] othelloComX13(OthelloJSP othello,int[][]banmen) {
		canPut=new ArrayList<>();
		kadList=new ArrayList<>();
		octagonList=new ArrayList<>();
		arKadList=new ArrayList<>();
		canPut=othello.vReverse(banmen);
		int minLength=30;
		ArrayList<ArrayList<Integer>>lengthList=new ArrayList<>();
		for(ArrayList<Integer>put:canPut) {
			vBanmen=othello.getVBanmen();
			int g=put.get(0);
			int r=put.get(1);
			int canPutLength=getCanPutLength(othello,g,r,vBanmen,true);
			put.add(canPutLength);
			lengthList.add(put);
			if(canPutLength<minLength) {
				minLength=canPutLength;
			}
		}
		canPut=new ArrayList<>();
		for(ArrayList<Integer>l:lengthList) {
			if(l.get(3)==minLength) {
				canPut.add(l);
			}
		}
		System.out.print("minLength:"+minLength+"canPut:[");
		for(ArrayList<Integer>put:canPut) {
			System.out.print("["+put.get(0)+" "+put.get(1)+"],");
		}
		System.out.println("]");
		/*if(!canPut.isEmpty()&&canPut.size()==1) {
			int gyo=canPut.get(0).get(0);
			int retu=canPut.get(0).get(1);
		}*/
		canPut=kadForecast(othello,canPut);
		if(canPut.isEmpty()/*||gyo==0&&retu==1||gyo==1&&retu==1||gyo==1&&retu==0||
				gyo==6&&retu==0||gyo==6&&retu==1||gyo==7&&retu==1||
				gyo==6&&retu==7||gyo==6&&retu==6||gyo==7&&retu==6||
				gyo==0&&retu==6||gyo==1&&retu==6||gyo==1&&retu==7*/
				) {
			canPut=othello.vReverse();
		}
		kadListAdd();
		octagonListAdd();
		arkadListAdd(othello);
		if(!kadList.isEmpty()) {
			int gyo=kadList.get(0).get(0);
			int retu=kadList.get(0).get(1);
			banmen[gyo][retu]=othello.getTurn();
			banmen=othello.vReverse(gyo,retu,banmen);

		}else if(!octagonList.isEmpty()) {
			if(othello.getTurnCount()<44) {
				ArrayList<ArrayList<Integer>>minList=listMin(octagonList);
				int gyo=minList.get(0).get(0);
				int retu=minList.get(0).get(1);
				banmen[gyo][retu]=othello.getTurn();
				banmen=othello.vReverse(gyo,retu,banmen);
			}else {
				ArrayList<ArrayList<Integer>>maxList=listMin(octagonList);
				int gyo=maxList.get(0).get(0);
				int retu=maxList.get(0).get(1);
				banmen[gyo][retu]=othello.getTurn();
				banmen=othello.vReverse(gyo,retu,banmen);
			}
		}
		else if(!canPut.isEmpty()){
			if(othello.getTurnCount()<40) {
				ArrayList<ArrayList<Integer>>nakawari=nakawari(canPut,othello.getVBanmen());
				ArrayList<ArrayList<Integer>>minList=listMin(nakawari);
				int gyo=minList.get(0).get(0);
				int retu=minList.get(0).get(1);
				banmen[gyo][retu]=othello.getTurn();
				banmen=othello.vReverse(gyo,retu,banmen);
			}else {
				ArrayList<ArrayList<Integer>>nakawari=nakawari(canPut,othello.getVBanmen());
				ArrayList<ArrayList<Integer>>maxList=listMax(nakawari);
				int gyo=maxList.get(0).get(0);
				int retu=maxList.get(0).get(1);
				banmen[gyo][retu]=othello.getTurn();
				banmen=othello.vReverse(gyo,retu,banmen);
			}
		}else if(!arKadList.isEmpty()){
			ArrayList<ArrayList<Integer>>safeList=arKadForecast(othello);
			int gyo;
			int retu;
			if(!safeList.isEmpty()) {
				ArrayList<Integer>array=avoidRedZone(safeList);
				gyo=array.get(0);
				retu=array.get(1);
				banmen[gyo][retu]=othello.getTurn();
				banmen=othello.vReverse(gyo,retu,banmen);
			}else {
				ArrayList<Integer>array=avoidRedZone(arKadList);
				gyo=array.get(0);
				retu=array.get(1);
				banmen[gyo][retu]=othello.getTurn();
				banmen=othello.vReverse(gyo,retu,banmen);
			}
		}else {
			othello.updateTurn();
			othello.plusPassCount();
			return banmen;
		}
		othello.updateTurn();
		othello.setPassCount(2);
		return banmen;
	}

	public static void arkadListAdd(OthelloJSP othello) {
		ArrayList<ArrayList<Integer>>remove=new ArrayList<>();
		vBanmen=othello.getVBanmen();
		if(!canPut.isEmpty()) {
			for(ArrayList<Integer>put:canPut) {
				//System.out.print("["+put.get(0)+" "+put.get(1)+" "+put.get(2)+"],");
				//System.out.println("]");
				int gyo=put.get(0);
				int retu=put.get(1);
				if(vBanmen[0][0]!=0&&((gyo==0&&retu==1)||(gyo==1&&retu==0)||(gyo==1&&retu==1))) {
					continue;
				}
				if(vBanmen[7][0]!=0&&((gyo==6&&retu==0)||(gyo==6&&retu==1)||(gyo==7&&retu==1))) {
					continue;
				}
				if(vBanmen[7][7]!=0&&((gyo==6&&retu==6)||(gyo==6&&retu==7)||(gyo==7&&retu==6))) {
					continue;
				}
				if(vBanmen[0][7]!=0&&((gyo==0&&retu==6)||(gyo==1&&retu==6)||(gyo==1&&retu==7))) {
					continue;
				}
				if(gyo==0&&retu==1||gyo==1&&retu==1||gyo==1&&retu==0||
						gyo==6&&retu==0||gyo==6&&retu==1||gyo==7&&retu==1||
						gyo==6&&retu==7||gyo==6&&retu==6||gyo==7&&retu==6||
						gyo==0&&retu==6||gyo==1&&retu==6||gyo==1&&retu==7) {
					remove.add(put);
					arKadList.add(put);
				}
			}
			for(ArrayList<Integer>r:remove) {
				boolean a=canPut.remove(r);
				//System.out.println(a);
			}
		}
	}

	public static void octagonListAdd() {
		ArrayList<ArrayList<Integer>>remove=new ArrayList<>();
		if(!canPut.isEmpty()) {
			for(ArrayList<Integer> put:canPut) {
				int gyo=put.get(0);
				int retu=put.get(1);
				if((gyo==0&&retu==2)||(gyo==2&&retu==0)
						||(gyo==5&&retu==0)||(gyo==7&&retu==2)
						||(gyo==7&&retu==5)||(gyo==5&&retu==7)
						||(gyo==0&&retu==5)||(gyo==2&&retu==7)) {
					remove.add(put);
					octagonList.add(put);
				}
			}
			for(ArrayList<Integer>r:remove) {
				boolean a=canPut.remove(r);
				//System.out.println(a);
			}
		}
	}
	/*public static void octagonListAdd() {
		if(!canPut.isEmpty()) {
			int l=canPut.size();
			try {
				for(int i=0;i<l;i++) {
					int gyo=canPut.get(i).get(0);
					int retu=canPut.get(i).get(1);
					int reverseCount=canPut.get(i).get(2);
					ArrayList<Integer>put=new ArrayList<>();
					put.add(gyo);
					put.add(retu);
					put.add(reverseCount);
					if((gyo==0&&retu==2)||(gyo==2&&retu==0)
							||(gyo==5&&retu==0)||(gyo==7&&retu==2)
							||(gyo==7&&retu==5)||(gyo==5&&retu==7)
							||(gyo==0&&retu==5)||(gyo==2&&retu==7)) {
						//System.out.println("octagonList:"+put.get(0)+" "+put.get(1)+" "+put.get(2));
						octagonList.add(put);
					}
				}
			}catch(IndexOutOfBoundsException e) {
			}
			for(ArrayList<Integer>remove:octagonList) {
				int index=canPut.indexOf(remove);
				canPut.remove(index);
			}
		}
	}*/
	public static void arOctagonListAdd(OthelloJSP othello) {
		if(!canPut.isEmpty()) {
			ArrayList<ArrayList<Integer>>arOctagon=new ArrayList<>();
			ArrayList<Integer> arO=new ArrayList<>();
			arO.add(0);
			arO.add(2);
			arOctagon.add(arO);
			arO=new ArrayList<>();
			arO.add(0);
			arO.add(5);
			arOctagon.add(arO);
			arO=new ArrayList<>();
			arO.add(2);
			arO.add(0);
			arOctagon.add(arO);
			arO=new ArrayList<>();
			arO.add(2);
			arO.add(7);
			arOctagon.add(arO);
			arO=new ArrayList<>();
			arO.add(5);
			arO.add(0);
			arOctagon.add(arO);
			arO=new ArrayList<>();
			arO.add(5);
			arO.add(7);
			arOctagon.add(arO);
			arO=new ArrayList<>();
			arO.add(7);
			arO.add(2);
			arOctagon.add(arO);
			arO=new ArrayList<>();
			arO.add(7);
			arO.add(5);
			int l=canPut.size();
			try {
				for(int i=0;i<l;i++) {
					int gyo=canPut.get(i).get(0);
					int retu=canPut.get(i).get(1);
					int reverseCount=canPut.get(i).get(2);
					arOctagon.add(arO);
					int[][]vBanmen=othello.getVBanmen();
					boolean canPut=othello.canPut(gyo,retu,vBanmen,arOctagon);
					if(canPut) {
						ArrayList<Integer>array=new ArrayList<>();
						array.add(gyo);
						array.add(retu);
						array.add(reverseCount);
						arOctagonList.add(array);
					}
				}
			}catch(IndexOutOfBoundsException e) {
			}
			for(ArrayList<Integer>remove:arOctagonList) {
				int index=canPut.indexOf(remove);
				canPut.remove(index);
			}
		}
	}
	public static void lListAdd() {
		if(!canPut.isEmpty()) {
			int l=canPut.size();
			try {
				for(int i=0;i<l;i++) {
					int gyo=canPut.get(i).get(0);
					int retu=canPut.get(i).get(1);
					int reverseCount=canPut.get(i).get(2);
					ArrayList<Integer>put=new ArrayList<>();
					put.add(gyo);
					put.add(retu);
					put.add(reverseCount);
					if((gyo==0&&retu==2)||(gyo==2&&retu==2)||(gyo==2&&retu==0)
							||(gyo==5&&retu==0)||(gyo==5&&retu==2)||(gyo==7&&retu==2)
							||(gyo==7&&retu==5)||(gyo==5&&retu==5)||(gyo==5&&retu==7)
							||(gyo==0&&retu==5)||(gyo==2&&retu==5)||(gyo==2&&retu==7)) {
						lList.add(put);
					}
				}
			}catch(IndexOutOfBoundsException e) {
			}
			for(ArrayList<Integer>remove:lList) {
				int index=canPut.indexOf(remove);
				canPut.remove(index);
			}
		}
	}
	public static void kadListAdd() {
		ArrayList<ArrayList<Integer>>remove=new ArrayList<>();
		if(!canPut.isEmpty()) {
			for(ArrayList<Integer> put:canPut) {
				int gyo=put.get(0);
				int retu=put.get(1);
				if(((gyo==0&&retu==0)||(gyo==0&&retu==7)||(gyo==7&&retu==0)||(gyo==7&&retu==7))) {
					remove.add(put);
					kadList.add(put);
				}
			}
			for(ArrayList<Integer>r:remove) {
				boolean a=canPut.remove(r);
				//System.out.println(a);
			}
		}
	}
	/*public static void kadListAdd() {
		try {
			if(!canPut.isEmpty()) {
				int l=canPut.size();
				for(int i=0;i<l;i++) {
					int gyo=canPut.get(i).get(0);
					int retu=canPut.get(i).get(1);
					int reverseCount=canPut.get(i).get(2);
					ArrayList<Integer>put=new ArrayList<>();
					put.add(gyo);
					put.add(retu);
					put.add(reverseCount);
					if((gyo==0&&retu==0)||(gyo==0&&retu==7)||(gyo==7&&retu==0)||(gyo==7&&retu==7)) {
						//System.out.println("kadList:"+put.get(0)+" "+put.get(1)+" "+put.get(2));
						kadList.add(put);
					}
				}
			}
		}catch(IndexOutOfBoundsException e) {

		}
		for(ArrayList<Integer>remove:kadList) {
			int index=canPut.indexOf(remove);
			canPut.remove(index);
		}
	}*/
	public static ArrayList<ArrayList<Integer>> listMax(ArrayList<ArrayList<Integer>>canPut) {
		int maxCount=0;
		ArrayList<ArrayList<Integer>> max=new ArrayList<>();
		for(ArrayList<Integer> put:canPut){
			int reverseCount=put.get(2);
			if(reverseCount>maxCount) {
				maxCount=reverseCount;
			}
		}
		for(ArrayList<Integer> put:canPut){
			int reverseCount=put.get(2);
			if(reverseCount==maxCount) {
				max.add(put);
			}
		}
		return max;
	}
	public static ArrayList<ArrayList<Integer>> listMin(ArrayList<ArrayList<Integer>>canPut) {
		int minCount=100;
		ArrayList<ArrayList<Integer>> min=new ArrayList<>();
		for(ArrayList<Integer> put:canPut){
			int reverseCount=put.get(2);
			if(reverseCount<minCount) {
				minCount=reverseCount;
			}
		}
		for(ArrayList<Integer> put:canPut){
			int reverseCount=put.get(2);
			if(reverseCount==minCount) {
				min.add(put);
			}
		}
		return min;
	}

	public static ArrayList<ArrayList<Integer>> arKadForecast(OthelloJSP othello) {
		ArrayList<ArrayList<Integer>>canPut=new ArrayList<>();
		ArrayList<Integer>put;
		ArrayList<ArrayList<Integer>> kadList= new ArrayList<>();
		ArrayList<Integer>kad=new ArrayList<>();
		vBanmen=othello.getVBanmen();
		if(vBanmen[0][0]==0) {
			kad.add(0);
			kad.add(0);
			kadList.add(kad);
		}
		if(vBanmen[7][0]==0) {
			kad=new ArrayList<>();
			kad.add(7);
			kad.add(0);
			kadList.add(kad);
		}
		if(vBanmen[7][7]==0) {
			kad=new ArrayList<>();
			kad.add(7);
			kad.add(7);
			kadList.add(kad);
		}
		if(vBanmen[0][7]==0) {
			kad=new ArrayList<>();
			kad.add(0);
			kad.add(7);
			kadList.add(kad);
		}
		label:
		for(ArrayList<Integer>arkad:arKadList) {
			int gyo=arkad.get(0);
			int retu=arkad.get(1);
			for(ArrayList<Integer>k:kadList) {
				int kGyo=k.get(0);
				int kRetu=k.get(1);
				vBanmen=othello.getVBanmen();
				if(othello.getTurn()==1) {
					vBanmen[gyo][retu]=1;
					vBanmen=othello.vReverse(gyo,retu,vBanmen);
					//othello.vBanmenhyoji(vBanmen);
					othello.setTurn(2);
					boolean canReverse=othello.canReverse(kGyo, kRetu, vBanmen);
					othello.setTurn(1);
					//System.out.println(kGyo+" "+kRetu);
					//System.out.println(canReverse);
					if(canReverse) {
						continue label;
					}

				}else if(othello.getTurn()==2) {
					vBanmen[gyo][retu]=2;
					vBanmen=othello.vReverse(gyo,retu,vBanmen);
					othello.setTurn(1);
					boolean canReverse=othello.canReverse(kGyo, kRetu, vBanmen);
					othello.setTurn(2);
					if(canReverse) {
						continue label;
					}
				}
			}
			put=new ArrayList<>();
			put.add(gyo);
			put.add(retu);
			canPut.add(put);
		}
		return canPut;
	}

	public static ArrayList<ArrayList<Integer>> kadForecast(OthelloJSP othello,ArrayList<ArrayList<Integer>> putList) {
		ArrayList<ArrayList<Integer>>canPut=new ArrayList<>();
		ArrayList<Integer>put;
		ArrayList<ArrayList<Integer>> kadList= new ArrayList<>();
		ArrayList<Integer>kad=new ArrayList<>();
		vBanmen=othello.getVBanmen();
		if(vBanmen[0][0]==0) {
			kad.add(0);
			kad.add(0);
			kadList.add(kad);
		}
		if(vBanmen[7][0]==0) {
			kad=new ArrayList<>();
			kad.add(7);
			kad.add(0);
			kadList.add(kad);
		}
		if(vBanmen[7][7]==0) {
			kad=new ArrayList<>();
			kad.add(7);
			kad.add(7);
			kadList.add(kad);
		}
		if(vBanmen[0][7]==0) {
			kad=new ArrayList<>();
			kad.add(0);
			kad.add(7);
			kadList.add(kad);
		}
		label:
		for(ArrayList<Integer>arkad:putList) {
			int gyo=arkad.get(0);
			int retu=arkad.get(1);
			int reverseCount=arkad.get(2);
			for(ArrayList<Integer>k:kadList) {
				int kGyo=k.get(0);
				int kRetu=k.get(1);
				vBanmen=othello.getVBanmen();
				if(othello.getTurn()==1) {
					vBanmen[gyo][retu]=1;
					vBanmen=othello.vReverse(gyo,retu,vBanmen);
					othello.setTurn(2);
					boolean canReverse=othello.canReverse(kGyo, kRetu, vBanmen);
					othello.setTurn(1);
					if(canReverse) {
						continue label;
					}
				}else if(othello.getTurn()==2) {
					vBanmen[gyo][retu]=2;
					vBanmen=othello.vReverse(gyo,retu,vBanmen);
					othello.setTurn(1);
					boolean canReverse=othello.canReverse(kGyo, kRetu, vBanmen);
					othello.setTurn(2);
					if(canReverse) {
						continue label;
					}
				}
			}
			put=new ArrayList<>();
			put.add(gyo);
			put.add(retu);
			put.add(reverseCount);
			canPut.add(put);
		}
		return canPut;
	}

	public static ArrayList<Integer>avoidRedZone(ArrayList<ArrayList<Integer>>list){
		ArrayList<Integer>gyoretu=new ArrayList<>();
		int gyo=list.get(0).get(0);
		int retu=list.get(0).get(1);
		for(ArrayList<Integer>l:list) {
			gyo=l.get(0);
			retu=l.get(1);
			if((gyo==1&&retu==1)||(gyo==1&&retu==6)||(gyo==6&&retu==1)||(gyo==6&&retu==6)) {
				continue;
			}else {
				break;
			}
		}
		gyoretu.add(gyo);
		gyoretu.add(retu);
		return gyoretu;
	}

	public static ArrayList<ArrayList<Integer>> nakawari(ArrayList<ArrayList<Integer>>canPut ,int[][] banmen){
		ArrayList<ArrayList<Integer>>nakawari=new ArrayList<>();
		int max=0;
		for(ArrayList<Integer>put:canPut) {
			int nakawariCount=0;
			int gyo=put.get(0);
			int retu=put.get(1);
			if(gyo+1>=8||banmen[gyo+1][retu]!=0
					||(gyo+1==6&&retu==0)||(gyo+1==6&&retu==1)||(gyo+1==6&&retu==6)||(gyo+1==6&&retu==7)) {
				nakawariCount++;
			}
			if(gyo-1<=0||banmen[gyo-1][retu]!=0
					||(gyo-1==1&&retu==0)||(gyo-1==1&&retu==1)||(gyo-1==1&&retu==6)||(gyo-1==1&&retu==7)) {
				nakawariCount++;
			}
			if(retu+1>=8||banmen[gyo][retu+1]!=0
					||(gyo==0&&retu+1==6)||(gyo==1&&retu+1==6)||(gyo==6&&retu+1==6)||(gyo==7&&retu+1==6)) {
				nakawariCount++;
			}
			if(retu-1<=0||banmen[gyo][retu-1]!=0
					||(gyo==0&&retu-1==1)||(gyo==1&&retu-1==1)||(gyo==6&&retu-1==1)||(gyo==7&&retu-1==1)) {
				nakawariCount++;
			}
			if(gyo+1>=8||retu+1>=8||banmen[gyo+1][retu+1]!=0||(gyo+1==6&&retu+1==6)) {
				nakawariCount++;
			}
			if(gyo+1>=8||retu-1<=0||banmen[gyo+1][retu-1]!=0||(gyo+1==6&&retu-1==1)) {
				nakawariCount++;
			}
			if(gyo-1<=0||retu+1>=8||banmen[gyo-1][retu+1]!=0||(gyo-1==1&&retu+1==6)) {
				nakawariCount++;
			}
			if(gyo-1<=0||retu-1<=0||banmen[gyo-1][retu-1]!=0||(gyo-1==1&&retu-1==1)) {
				nakawariCount++;
			}
			if(nakawariCount>max) {
				max=nakawariCount;
				if(nakawari.size()>0) {
					nakawari=new ArrayList<>();
				}
				nakawari.add(put);
			}else if(nakawariCount==max) {
				nakawari.add(put);
			}
		}
		return nakawari;
	}
	public static int getCanPutLength(OthelloJSP othello,int gyo,int retu,int[][]banmen,boolean reverseOrder) {
		int canPutLength=0;
		if(reverseOrder==false) {
			banmen[gyo][retu]=othello.getTurn();
			for(int i=0;i<8;i++) {
				for(int j=0;j<8;j++) {
					banmen[i][j]=othello.vReverse(gyo,retu,banmen)[i][j];
				}
			}
			canPutLength=othello.getCanPut(banmen).size();
		}else {
			banmen[gyo][retu]=othello.getTurn();
			for(int i=0;i<8;i++) {
				for(int j=0;j<8;j++) {
					banmen[i][j]=othello.vReverse(gyo,retu,banmen)[i][j];
				}
			}
			othello.updateTurn();
			canPutLength=othello.getCanPut(banmen).size();
			othello.updateTurn();
		}

		return canPutLength;
	}

}
