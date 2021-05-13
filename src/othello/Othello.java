package othello;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Othello {
	static int[][] array=new int[8][8];
	static int turn=1;
	static int gyo;
	static int retu;
	static int reverseCount=0;
	static int turnCount=0;
	static int passCount=0;
	static int rvhantei;
	static long bTime=420;
	static long wTime=420;
	static long sTime,eTime;
	static boolean computer1=false;
	static boolean computer2=true;
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		mainOthello();
	}

	public static void mainOthello() {
		shokibanmen();
		banmenhyoji();
		System.out.println("黒のターンです。（9 9でパスコマンド）");
		label:
		for(int i=0;i<60;i++) {
			reverseCount=0;
			turnCount++;
			passCount=0;
			while(reverseCount==0) {

				if(computer1&&turn==1) {
					OthelloComputer2.othelloCom29();
					if(passCount>=2)break label;
				}else if(computer2&&turn==2) {
					OthelloComputer.othelloCom9();
					if(passCount>=2)break label;
				}else {
					if(turn==1) {
						System.out.println("残り時間は"+bTime/60+"分"+bTime%60+"秒です");
					}else if(turn==2) {
						System.out.println("残り時間は"+wTime/60+"分"+wTime%60+"秒です");
					}
					sTime=System.currentTimeMillis();
					//座標の入力
					input();
					//パスの判定
					int pasuhantei=pasuhantei();
					if(pasuhantei==1) {
						//置いた座標を2次元配列に記録
						kousin();
						//引っくり返す処理と2次元配列への記録
						reverse();
						//1枚以上返しているかの判定と0枚の時の処理
						rvhantei=reversehantei();
					}else if(pasuhantei==2||passCount==2) {
						break label;
					}
				}
				eTime=System.currentTimeMillis();
				//ターンの更新
				turnkousin();
			}
			banmenhyoji();

			if(allhantei())break label;

			if(turn==1&&turnCount!=60) {
				System.out.println("黒のターンです");
			}else if(turn==2&&turnCount!=60){
				System.out.println("白のターンです");
			}
		}
		sc.close();
		result();
	}
	public static void shokibanmen() {
		System.out.println();
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if((i==3&&j==3)||(i==4&&j==4)) {
					array[i][j]=1;
				}else if((i==3&&j==4)||(i==4&&j==3)) {
					array[i][j]=2;
				}else {
					array[i][j]=0;
				}
			}
		}
	}

	public static void banmenhyoji() {
		System.out.print("  ");
		for(int i=1;i<=8;i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i=0;i<8;i++) {
			System.out.print(i+1+" ");
			for(int j=0;j<8;j++) {
				if(array[i][j]==1) {
					if(i==gyo&&j==retu) {
						//System.err.print("黒");
						System.out.print("黒");
					}else {
						System.out.print("黒");
					}
				}else if(array[i][j]==2) {
					if(i==gyo&&j==retu) {
						//System.err.print("白");
						System.out.print("白");
					}else {
						System.out.print("白");
					}
				}else if(array[i][j]==0){
					System.out.print("み");
				}
			}
			System.out.println();
		}
	}

	public static void input() {
		boolean hantei=true;
		while(hantei){
			try{
				gyo=sc.nextInt();
				retu=sc.nextInt();
				if(gyo==9&&retu==9) {
				}
				else if((gyo>8||gyo<0||retu>8||retu<0)||array[gyo-1][retu-1]!=0) {
					System.out.println("無効な座標です。入力をやり直してください。");
					continue;
				}
				hantei=false;
			} catch(InputMismatchException e) {
				System.out.println("1〜8の半角数字で入力してください");
				sc.next();
				sc.next();
			}
		}
	}

	public static void kousin() {
		if(turn==1) {
			array[gyo-1][retu-1]=1;
		}else if(turn==2) {
			array[gyo-1][retu-1]=2;
		}
	}

	public static int pasuhantei() {
		if(gyo==9&&retu==9) {
			System.out.println("パスしました。");
			passCount++;
			if(passCount==2) {
				return 2;
			}
			if(turn==1) {
				System.out.println("白のターンです");
			}else {
				System.out.println("黒のターンです");
			}
			return 0;
		}else {
			return 1;
		}
	}
	public static void reverse() {
		gyo--;
		retu--;
		int[] rpoints=new int[2];
		reverseCount=0;
		//縦＋方向
		for(int i=1;gyo!=7&&i+gyo<8;i++) {
			if(array[i+gyo][retu]==0) {
				break;
			}else if(array[i+gyo][retu]==turn){
				rpoints[0]=i+gyo;
				rpoints[1]=retu;
				for(int j=1;j+gyo<rpoints[0];j++) {
					array[j+gyo][retu]=turn;
					reverseCount++;
				}
				break;
			}else{
				continue;
			}
		}
		//縦ー方向
		for(int i=-1;gyo!=0&&i+gyo>=0;i--) {
			if(array[i+gyo][retu]==0) {
				break;
			}else if(array[i+gyo][retu]==turn){
				rpoints[0]=i+gyo;
				rpoints[1]=retu;
				for(int j=-1;j+gyo>rpoints[0];j--) {
					array[j+gyo][retu]=turn;
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//横＋方向
		for(int i=1;retu!=7&&i+retu<8;i++) {
			if(array[gyo][i+retu]==0) {
				break;
			}else if(array[gyo][i+retu]==turn){
				rpoints[0]=gyo;
				rpoints[1]=i+retu;
				for(int j=1;j+retu<rpoints[1];j++) {
					array[gyo][j+retu]=turn;
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//横ー方向
		for(int i=-1;retu!=0&&i+retu>=0;i--) {
			if(array[gyo][i+retu]==0) {
				break;
			}else if(array[gyo][i+retu]==turn){
				rpoints[0]=gyo;
				rpoints[1]=i+retu;
				for(int j=-1;j+retu>rpoints[1];j--) {
					array[gyo][j+retu]=turn;
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//右斜め下方向
		for(int i=1;(gyo!=7&&retu!=7)&&(i+gyo<8&&i+retu<8);i++) {
			if(array[i+gyo][i+retu]==0) {
				break;
			}else if(array[i+gyo][i+retu]==turn) {
				rpoints[0]=i+gyo;
				rpoints[1]=i+retu;
				for(int j=1;j+gyo<rpoints[0];j++) {
					array[j+gyo][j+retu]=turn;
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//左斜め上方向
		for(int i=-1;(gyo!=0&&retu!=0)&&(i+gyo>=0&&i+retu>=0);i--) {
			if(array[i+gyo][i+retu]==0) {
				break;
			}else if(array[i+gyo][i+retu]==turn) {
				rpoints[0]=i+gyo;
				rpoints[1]=i+retu;
				for(int j=-1;j+gyo>rpoints[0];j--) {
					array[j+gyo][j+retu]=turn;
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//右斜め上方向
		for(int i=1;(gyo!=0&&retu!=7)&&(-i+gyo>=0&&i+retu<8);i++) {
			if(array[-i+gyo][i+retu]==0) {
				break;
			}else if(array[-i+gyo][i+retu]==turn) {
				rpoints[0]=-i+gyo;
				rpoints[1]=i+retu;
				for(int j=1;-j+gyo>rpoints[0];j++) {
					array[-j+gyo][j+retu]=turn;
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//左斜め下方向
		for(int i=1;(gyo!=7&&retu!=0)&&(i+gyo<8&&-i+retu>=0);i++) {
			if(array[i+gyo][-i+retu]==0) {
				break;
			}else if(array[i+gyo][-i+retu]==turn) {
				rpoints[0]=i+gyo;
				rpoints[1]=-i+retu;
				for(int j=1;j+gyo<rpoints[0];j++) {
					array[j+gyo][-j+retu]=turn;
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
	}
	public static void reverse(int[][]array,int gyo,int retu,int turn) {
		gyo--;
		retu--;
		int[] rpoints=new int[2];
		reverseCount=0;
		//縦＋方向
		for(int i=1;gyo!=7&&i+gyo<8;i++) {
			if(array[i+gyo][retu]==0) {
				break;
			}else if(array[i+gyo][retu]==turn){
				rpoints[0]=i+gyo;
				rpoints[1]=retu;
				for(int j=1;j+gyo<rpoints[0];j++) {
					array[j+gyo][retu]=turn;
					reverseCount++;
				}
				break;
			}else{
				continue;
			}
		}
		//縦ー方向
		for(int i=-1;gyo!=0&&i+gyo>=0;i--) {
			if(array[i+gyo][retu]==0) {
				break;
			}else if(array[i+gyo][retu]==turn){
				rpoints[0]=i+gyo;
				rpoints[1]=retu;
				for(int j=-1;j+gyo>rpoints[0];j--) {
					array[j+gyo][retu]=turn;
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//横＋方向
		for(int i=1;retu!=7&&i+retu<8;i++) {
			if(array[gyo][i+retu]==0) {
				break;
			}else if(array[gyo][i+retu]==turn){
				rpoints[0]=gyo;
				rpoints[1]=i+retu;
				for(int j=1;j+retu<rpoints[1];j++) {
					array[gyo][j+retu]=turn;
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//横ー方向
		for(int i=-1;retu!=0&&i+retu>=0;i--) {
			if(array[gyo][i+retu]==0) {
				break;
			}else if(array[gyo][i+retu]==turn){
				rpoints[0]=gyo;
				rpoints[1]=i+retu;
				for(int j=-1;j+retu>rpoints[1];j--) {
					array[gyo][j+retu]=turn;
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//右斜め下方向
		for(int i=1;(gyo!=7&&retu!=7)&&(i+gyo<8&&i+retu<8);i++) {
			if(array[i+gyo][i+retu]==0) {
				break;
			}else if(array[i+gyo][i+retu]==turn) {
				rpoints[0]=i+gyo;
				rpoints[1]=i+retu;
				for(int j=1;j+gyo<rpoints[0];j++) {
					array[j+gyo][j+retu]=turn;
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//左斜め上方向
		for(int i=-1;(gyo!=0&&retu!=0)&&(i+gyo>=0&&i+retu>=0);i--) {
			if(array[i+gyo][i+retu]==0) {
				break;
			}else if(array[i+gyo][i+retu]==turn) {
				rpoints[0]=i+gyo;
				rpoints[1]=i+retu;
				for(int j=-1;j+gyo>rpoints[0];j--) {
					array[j+gyo][j+retu]=turn;
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//右斜め上方向
		for(int i=1;(gyo!=0&&retu!=7)&&(-i+gyo>=0&&i+retu<8);i++) {
			if(array[-i+gyo][i+retu]==0) {
				break;
			}else if(array[-i+gyo][i+retu]==turn) {
				rpoints[0]=-i+gyo;
				rpoints[1]=i+retu;
				for(int j=1;-j+gyo>rpoints[0];j++) {
					array[-j+gyo][j+retu]=turn;
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//左斜め下方向
		for(int i=1;(gyo!=7&&retu!=0)&&(i+gyo<8&&-i+retu>=0);i++) {
			if(array[i+gyo][-i+retu]==0) {
				break;
			}else if(array[i+gyo][-i+retu]==turn) {
				rpoints[0]=i+gyo;
				rpoints[1]=-i+retu;
				for(int j=1;j+gyo<rpoints[0];j++) {
					array[j+gyo][-j+retu]=turn;
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
	}
	public static boolean kadReverse() {
		int[][]array=new int[8][8];
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				array[i][j]=Othello.array[i][j];
			}
		}
		if(turn==1) {
			array[gyo-1][retu-1]=2;
			reverse(array,gyo,retu,2);
		}else {
			array[gyo-1][retu-1]=1;
			reverse(array,gyo,retu,1);
		}
		HashMap<Integer,Integer[]> kadMap=new HashMap<>();
		Integer[] kad1= {0,0};
		Integer[] kad2= {0,7};
		Integer[] kad3= {7,0};
		Integer[] kad4= {7,7};
		kadMap.put(0, kad1);
		kadMap.put(1, kad2);
		kadMap.put(2, kad3);
		kadMap.put(3, kad4);
		int[] rpoints=new int[2];
		reverseCount=0;
		for(int n=0;n<4;n++) {
			reverseCount=0;
			gyo=kadMap.get(n)[0];
			retu=kadMap.get(n)[1];
		//縦＋方向
		for(int i=1;gyo!=7&&i+gyo<8;i++) {
			if(array[i+gyo][retu]==0) {
				break;
			}else if(array[i+gyo][retu]==turn){
				rpoints[0]=i+gyo;
				rpoints[1]=retu;
				for(int j=1;j+gyo<rpoints[0];j++) {
					reverseCount++;
				}
				break;
			}else{
				continue;
			}
		}
		//縦ー方向
		for(int i=-1;gyo!=0&&i+gyo>=0;i--) {
			if(array[i+gyo][retu]==0) {
				break;
			}else if(array[i+gyo][retu]==turn){
				rpoints[0]=i+gyo;
				rpoints[1]=retu;
				for(int j=-1;j+gyo>rpoints[0];j--) {
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//横＋方向
		for(int i=1;retu!=7&&i+retu<8;i++) {
			if(array[gyo][i+retu]==0) {
				break;
			}else if(array[gyo][i+retu]==turn){
				rpoints[0]=gyo;
				rpoints[1]=i+retu;
				for(int j=1;j+retu<rpoints[1];j++) {
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//横ー方向
		for(int i=-1;retu!=0&&i+retu>=0;i--) {
			if(array[gyo][i+retu]==0) {
				break;
			}else if(array[gyo][i+retu]==turn){
				rpoints[0]=gyo;
				rpoints[1]=i+retu;
				for(int j=-1;j+retu>rpoints[1];j--) {
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//右斜め下方向
		for(int i=1;(gyo!=7&&retu!=7)&&(i+gyo<8&&i+retu<8);i++) {
			if(array[i+gyo][i+retu]==0) {
				break;
			}else if(array[i+gyo][i+retu]==turn) {
				rpoints[0]=i+gyo;
				rpoints[1]=i+retu;
				for(int j=1;j+gyo<rpoints[0];j++) {
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//左斜め上方向
		for(int i=-1;(gyo!=0&&retu!=0)&&(i+gyo>=0&&i+retu>=0);i--) {
			if(array[i+gyo][i+retu]==0) {
				break;
			}else if(array[i+gyo][i+retu]==turn) {
				rpoints[0]=i+gyo;
				rpoints[1]=i+retu;
				for(int j=-1;j+gyo>rpoints[0];j--) {
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//右斜め上方向
		for(int i=1;(gyo!=0&&retu!=7)&&(-i+gyo>=0&&i+retu<8);i++) {
			if(array[-i+gyo][i+retu]==0) {
				break;
			}else if(array[-i+gyo][i+retu]==turn) {
				rpoints[0]=-i+gyo;
				rpoints[1]=i+retu;
				for(int j=1;-j+gyo>rpoints[0];j++) {
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//左斜め下方向
		for(int i=1;(gyo!=7&&retu!=0)&&(i+gyo<8&&-i+retu>=0);i++) {
			if(array[i+gyo][-i+retu]==0) {
				break;
			}else if(array[i+gyo][-i+retu]==turn) {
				rpoints[0]=i+gyo;
				rpoints[1]=-i+retu;
				for(int j=1;j+gyo<rpoints[0];j++) {
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		if(reverseCount>0) {
			return false;
		}
		}
		return true;
	}
	public static void comReverse() {
		gyo--;
		retu--;
		int[] rpoints=new int[2];
		reverseCount=0;
		//縦＋方向
		for(int i=1;gyo!=7&&i+gyo<8;i++) {
			if(array[i+gyo][retu]==0) {
				break;
			}else if(array[i+gyo][retu]==turn){
				rpoints[0]=i+gyo;
				rpoints[1]=retu;
				for(int j=1;j+gyo<rpoints[0];j++) {
					reverseCount++;
				}
				break;
			}else{
				continue;
			}
		}
		//縦ー方向
		for(int i=-1;gyo!=0&&i+gyo>=0;i--) {
			if(array[i+gyo][retu]==0) {
				break;
			}else if(array[i+gyo][retu]==turn){
				rpoints[0]=i+gyo;
				rpoints[1]=retu;
				for(int j=-1;j+gyo>rpoints[0];j--) {
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//横＋方向
		for(int i=1;retu!=7&&i+retu<8;i++) {
			if(array[gyo][i+retu]==0) {
				break;
			}else if(array[gyo][i+retu]==turn){
				rpoints[0]=gyo;
				rpoints[1]=i+retu;
				for(int j=1;j+retu<rpoints[1];j++) {
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//横ー方向
		for(int i=-1;retu!=0&&i+retu>=0;i--) {
			if(array[gyo][i+retu]==0) {
				break;
			}else if(array[gyo][i+retu]==turn){
				rpoints[0]=gyo;
				rpoints[1]=i+retu;
				for(int j=-1;j+retu>rpoints[1];j--) {
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//右斜め下方向
		for(int i=1;(gyo!=7&&retu!=7)&&(i+gyo<8&&i+retu<8);i++) {
			if(array[i+gyo][i+retu]==0) {
				break;
			}else if(array[i+gyo][i+retu]==turn) {
				rpoints[0]=i+gyo;
				rpoints[1]=i+retu;
				for(int j=1;j+gyo<rpoints[0];j++) {
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//左斜め上方向
		for(int i=-1;(gyo!=0&&retu!=0)&&(i+gyo>=0&&i+retu>=0);i--) {
			if(array[i+gyo][i+retu]==0) {
				break;
			}else if(array[i+gyo][i+retu]==turn) {
				rpoints[0]=i+gyo;
				rpoints[1]=i+retu;
				for(int j=-1;j+gyo>rpoints[0];j--) {
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//右斜め上方向
		for(int i=1;(gyo!=0&&retu!=7)&&(-i+gyo>=0&&i+retu<8);i++) {
			if(array[-i+gyo][i+retu]==0) {
				break;
			}else if(array[-i+gyo][i+retu]==turn) {
				rpoints[0]=-i+gyo;
				rpoints[1]=i+retu;
				for(int j=1;-j+gyo>rpoints[0];j++) {
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
		//左斜め下方向
		for(int i=1;(gyo!=7&&retu!=0)&&(i+gyo<8&&-i+retu>=0);i++) {
			if(array[i+gyo][-i+retu]==0) {
				break;
			}else if(array[i+gyo][-i+retu]==turn) {
				rpoints[0]=i+gyo;
				rpoints[1]=-i+retu;
				for(int j=1;j+gyo<rpoints[0];j++) {
					reverseCount++;
				}
				break;

			}else {
				continue;
			}
		}
	}
	public static int reversehantei() {
		int rvhantei=0;
		if(reverseCount==0) {
			array[gyo][retu]=0;
			System.out.println("返せる石がありません。パスしますか？");
			System.out.println("1:はい 2:石を置き直す");
			boolean hantei=true;
			int yn=0;
			while(hantei) {
				while(hantei) {
					try {
						yn=sc.nextInt();
						hantei=false;
					}catch(InputMismatchException e){
						System.out.println("1か2で入力してください");
						sc.next();
					}
				}
				if(yn==1) {
					System.out.println("パスしました");
					if(turn==2) {
						System.out.println("黒のターンです");
					}else {
						System.out.println("白のターンです");
					}
					rvhantei=0;
				}else if(yn==2) {
					if(turn==2) {
						System.out.println("白のターンです");
					}else {
						System.out.println("黒のターンです");
					}
					rvhantei=2;
				}else {
					System.out.println("1か2で入力してください");
					hantei=true;
				}
			}
		}
		return rvhantei;
	}
	public static void turnkousin() {
		if(turn==1&&rvhantei==0) {
			turn=2;
			bTime=bTime-(eTime-sTime)/1000;
		}else if(turn==2&&rvhantei==0){
			turn=1;
			wTime=wTime-(eTime-sTime)/1000;
		}else if(turn==1&&rvhantei==2) {
			bTime=bTime-(eTime-sTime)/1000;
		}else if(turn==2&&rvhantei==2){
			wTime=wTime-(eTime-sTime)/1000;
		}
	}
	public static void result() {
		int bcount=0;
		int wcount=0;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(array[i][j]==1) {
					bcount+=1;
				}else if(array[i][j]==2) {
					wcount+=1;
				}
			}
		}
		if(bcount>wcount) {
			System.out.println(bcount+":"+wcount+"で黒の勝ちです。");
		}else if(wcount>bcount) {
			System.out.println(bcount+":"+wcount+"で白の勝ちです。");
		}else {
			System.out.println("引き分けです。");
		}
	}
	public static boolean allhantei() {
		int bcount=0;
		int wcount=0;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(array[i][j]==1) {
					bcount+=1;
				}else if(array[i][j]==2) {
					wcount+=1;
				}
			}
		}
		if(bcount==0) {
			return true;
		}else if(wcount==0) {
			return true;
		}
		return false;
	}
}
